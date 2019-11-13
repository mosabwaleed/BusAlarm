package com.example.gl_zarqa_imac8.busalarm;


import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(MainActivity.this,LogInActivity.class);
                startActivity(i);
                MainActivity.this.finish();
            }
        },3000);{


        }
    }
}
