package com.example.farming;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class login_qrcode extends AppCompatActivity {
    private static final String baseURL = "http://192.168.0.118/";
    List<Sensordatum> sensordatumList=new ArrayList<>();
    private boolean validdata=false,logged_in=false;
    Button scan;
    ProgressBar progressBar;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_qrcode);
        scan=(Button)findViewById(R.id.scan);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intentIntegrator=new IntentIntegrator(login_qrcode.this);
                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                intentIntegrator.setPrompt("Scanning");
                intentIntegrator.setOrientationLocked(false);
                intentIntegrator.setCameraId(0);
                intentIntegrator.setBeepEnabled(false);
                intentIntegrator.setBarcodeImageEnabled(false);
                intentIntegrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "stopped", Toast.LENGTH_SHORT).show();
            } else {
                String res = result.getContents();
                Toast.makeText(this, result.getContents(), Toast.LENGTH_SHORT).show();
                login(res);
                //dialog = ProgressDialog.show(login_qrcode.this, "new qr",
                //      "Loading. Please wait...", true);}
            }
        }
        else
            {
                super.onActivityResult(requestCode, resultCode, data);
            }
        }
    public void login(final String res)
    {

        dialog =new ProgressDialog(login_qrcode.this,R.style.MyAlertDialogStyle);
        dialog.setTitle("Logging You");
        dialog.setMessage("Please wait...");
        dialog.show();
        //ProgressDialog.show(login_qrcode.this ,"Logging You",
          //      "Please wait...", true);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL).client(client)
                .addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        sensordataapi sensordataapi=retrofit.create(com.example.farming.sensordataapi.class);
        Call<List<Sensordatum>> call=sensordataapi.getsensordata("/sensordata.php");
        call.enqueue(new Callback<List<Sensordatum>>() {
            @Override
            public void onResponse(Call<List<Sensordatum>> call, Response<List<Sensordatum>> response) {
                sensordatumList=response.body();
                validdata=true;
                //Toast.makeText(login_qrcode.this,"sensor data="+sensordatumList+"v="+validdata,Toast.LENGTH_LONG).show();
                for(Sensordatum sensordatum:sensordatumList)
                {
                    String module_id=sensordatum.getModuleId().toUpperCase();
//                    Toast.makeText(login_qrcode.this,"id="+module_id+"",Toast.LENGTH_LONG).show();

                    if(module_id.equalsIgnoreCase(res))
                    {
                        logged_in=true;
                        //Toast.makeText(login_qrcode.this,"id="+module_id+"",Toast.LENGTH_LONG).show();
                        // progressBar.setVisibility(View.GONE);
                        dialog.dismiss();
                        Intent i=new Intent(getApplicationContext(),MainActivity.class);
                        i.putExtra("MODULE_ID",res);
                        startActivity(i);
                        finish();
                    }
                }
                if(logged_in==false)
                {
                    Toast.makeText(login_qrcode.this,"Wrong QR CODE TRY AGAIN",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<Sensordatum>> call, Throwable t) {

                Toast.makeText(login_qrcode.this,"ERROR"+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        if(validdata==true)
        {

        }
    }
    }

