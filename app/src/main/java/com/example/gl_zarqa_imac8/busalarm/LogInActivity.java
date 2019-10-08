package com.example.gl_zarqa_imac8.busalarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import javax.annotation.Nullable;

public class LogInActivity extends AppCompatActivity {
    EditText etN;
    EditText etP;
    String stno;
    String password;
    FirebaseFirestore firestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etN = findViewById(R.id.number);
        etP = findViewById(R.id.etPassword);
        firestore = FirebaseFirestore.getInstance();
    }
    public void logIn(View view) {
        firestore.collection("Users").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if(e == null){
                    int count =0;
                    for(DocumentSnapshot doc : queryDocumentSnapshots){
                        stno = doc.getString("nu");
                        password = doc.getString("pass");
                        if(etN.getText().toString().matches(stno) && etP.getText().toString().matches(password))
                        {
                            Profile pro = new Profile(password,doc.getString("Name"),stno,doc.getString("major"),doc.getString("city"));
                            ProfileActivity.pro = pro;
                            Intent i=new Intent(LogInActivity.this, ProfileActivity.class);
                            startActivity(i);
                        }
                        else {
                            count++;
                            if (queryDocumentSnapshots.size()<=count){
                            Toast.makeText(LogInActivity.this,"Invalid user name or password",Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
            }
        });
    }
}