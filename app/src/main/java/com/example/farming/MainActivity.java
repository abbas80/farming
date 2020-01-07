package com.example.farming;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String baseURL = "http://192.168.0.118/";
    //private static final String apiKey = "adf10aa703ae49cf9baacead697dcc92";
String moduleid="";
    CardView npk;
CardView crops;
ImageView login;
ConstraintLayout sswipe_layout,login_bottom;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i=getIntent();
        moduleid=i.getStringExtra("MODULE_ID");
       // login_bottom=(ConstraintLayout)findViewById(R.id.login_bottom);
        login=(ImageView)findViewById(R.id.user);
        npk=(CardView) findViewById(R.id.npk_card);
        crops=(CardView)findViewById(R.id.crop_card);
        sswipe_layout=(ConstraintLayout)findViewById(R.id.swipe_layout);
        crops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),crop_suggestion.class);
                i.putExtra("MODULE_ID",moduleid);
                startActivity(i);
            }
        });
        npk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),npkdata.class);
                i.putExtra("MODULE_ID",moduleid);
                startActivity(i);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle data = new Bundle();//create bundle instance
                data.putString("MODULE_ID", moduleid);
                example_bottom ex=new example_bottom();

                ex.show(getSupportFragmentManager(),"example_bottom");
                ex.setArguments(data);
            }
        });

        sswipe_layout.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this){
        public void onSwipeTop() {
            Bundle data = new Bundle();//create bundle instance
            data.putString("MODULE_ID", moduleid);//put string to pass with a key value

            example_bottom ex=new example_bottom();
            ex.show(getSupportFragmentManager(),"example_bottom");
            ex.setArguments(data);
            // Toast.makeText(getApplicationContext(), getResources().getString(R.string.toastTop),Toast.LENGTH_SHORT).show();
        }
        public void onSwipeRight() {
            Toast.makeText(getApplicationContext(), "Swipe Right", Toast.LENGTH_SHORT).show();
        }
        public void onSwipeLeft() {
            Toast.makeText(getApplicationContext(),"Swipe Left", Toast.LENGTH_SHORT).show();
        }
        public void onSwipeBottom() {
            Toast.makeText(getApplicationContext(),"Bottom", Toast.LENGTH_SHORT).show();
        }
    });
    }
    public String getmy()
    {
        return moduleid;
    }
}
