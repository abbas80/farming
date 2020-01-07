package com.example.farming;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class npkdata extends AppCompatActivity {
    private static final String baseURL = "http://192.168.0.118/";
    RecyclerView past_npk_recyclerView;
    String moduleid="";
    ImageView npk_back;
    List<Wholesensordatum> wholesensordatumList=new ArrayList<>();
    List<past_npk_model> npk_list =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npkdata);
        Intent i=getIntent();
        moduleid=i.getStringExtra("MODULE_ID");
        past_npk_recyclerView=(RecyclerView) findViewById(R.id.past_npk_recyclerView);
        npk_back=(ImageView)findViewById(R.id.npk_back);
        npk_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        wholesensordataapi wholesensordataapi=retrofit.create(com.example.farming.wholesensordataapi.class);

        Call<List<Wholesensordatum>> call=wholesensordataapi.getWholesensordata("/wholesensordata.php ");

        call.enqueue(new Callback<List<Wholesensordatum>>() {
            @Override
            public void onResponse(Call<List<Wholesensordatum>> call, Response<List<Wholesensordatum>> response) {
                wholesensordatumList=response.body();
               // Toast.makeText(npkdata.this,"sensor data="+wholesensordatumList.get(10).getModuleId(),Toast.LENGTH_LONG).show();
                fillcrop_list();
                intitrecyclerView();
            }

            @Override
            public void onFailure(Call<List<Wholesensordatum>> call, Throwable t) {

                Toast.makeText(npkdata.this,"Error"+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
       // fillcrop_list();
        //intitrecyclerView();
    }
    private void intitrecyclerView() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        past_npk_recyclerView.setLayoutManager(linearLayoutManager);
        past_npk_adapter adapter_rec=new past_npk_adapter( npk_list);
        past_npk_recyclerView.setAdapter(adapter_rec);
    }

    private void fillcrop_list() {
        for(Wholesensordatum wholesensordatum:wholesensordatumList)
        {
            if(wholesensordatum.getModuleId().equalsIgnoreCase(moduleid)) {
                npk_list.add(new past_npk_model((npk_list.size()+1), wholesensordatum.getNitrogen(), wholesensordatum.getPhosphorus(), wholesensordatum.getPotassium(), "15/10/18"));
            }
        }

        /*npk_list.add(new past_npk_model(1,"120","40","60","15/10/18"));

        npk_list.add(new past_npk_model(2,"100","30","50","21/06/18"));

        npk_list.add(new past_npk_model(3,"130","40","40","19/03/19"));
*/
    }
}
