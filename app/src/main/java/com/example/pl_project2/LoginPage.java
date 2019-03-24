package com.example.pl_project2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class LoginPage extends AppCompatActivity {
    Button b;
    EditText em,ps;
    FirebaseAuth mAuth;
    String s1,s2;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        b = findViewById(R.id.button);
        em = findViewById(R.id.editText);
        ps = findViewById(R.id.editText2);
        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("users");
    }

    public void login(View view) {

        final String email, pass;
        email = em.getText().toString().trim();
        pass = ps.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(LoginPage.this, "Successfully logged in ", Toast.LENGTH_LONG).show();
                    Intent i = new Intent("com.example.pl_project2.Clothes");
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(LoginPage.this, "Unsuccessful login attempt", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
