package com.example.pl_project2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class SignUpPage extends AppCompatActivity {
    Button b5;
    EditText em,ps;
    FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        b5 = findViewById(R.id.button5);
        em = findViewById(R.id.editText4);
        ps = findViewById(R.id.editText5);
        mAuth = FirebaseAuth.getInstance();
    }
    public void signup(View view)
    {
        final String email,pass;
        email = em.getText().toString().trim();
        pass = ps.getText().toString().trim();


        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    databaseReference = FirebaseDatabase.getInstance().getReference("users");
                    user = mAuth.getCurrentUser();
                    Toast.makeText(SignUpPage.this, "Account created", Toast.LENGTH_LONG).show();
                    String a = databaseReference.push().getKey();
                    username use = new username(email,pass);
                    databaseReference.child(a).setValue(use);
                    Intent i = new Intent("com.example.pl_project2.Clothes");
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(SignUpPage.this, "Account not created", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
