package com.example.gl_zarqa_imac8.busalarm;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class register extends AppCompatActivity {

    EditText name,nu,major,city,pass;
    Button submit;
    FirebaseFirestore db;
    HashMap<String,String>info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.name);
        nu = findViewById(R.id.nu);
        major = findViewById(R.id.major);
        city = findViewById(R.id.city);
        pass = findViewById(R.id.pass);
        submit = findViewById(R.id.submit);
        db = FirebaseFirestore.getInstance();
        info = new HashMap<>();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.put("Name",name.getText().toString());
                info.put("nu",nu.getText().toString());
                info.put("pass",pass.getText().toString());
                info.put("major",major.getText().toString());
                info.put("city",city.getText().toString());
                db.collection("Users").document(nu.getText().toString()).set(info).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        startActivity(new Intent(register.this,LogInActivity.class));
                    }
                });
            }
        });


    }
}
