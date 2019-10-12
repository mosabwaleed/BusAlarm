package com.example.gl_zarqa_imac8.busalarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {


    public static Profile pro;
    TextView studentName,city,stno,major;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        studentName = findViewById(R.id.stname);
        major = findViewById(R.id.major);
        stno = findViewById(R.id.stno);
        city = findViewById(R.id.city);

        studentName.setText(pro.getFullName());
        major.setText(pro.getMajor());
        stno.setText(pro.getS_no());
        city.setText(pro.getCity());
    }
    public void showPositionOnMap(View view) {
        Intent in = new Intent(this, MapsActivity.class);
//        in.putExtra("roundno",roundnum.getText().toString());
//        in.putExtra("busno",busnumber.getText().toString());
        startActivity(in);
    }
}