package com.example.pl_project2;


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

public class firebasechecker extends AppCompatActivity {

    EditText ed1,ed2;
    Button b,b2;
    FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebasechecker);
        ed1 = findViewById(R.id.editTextEmail);
        ed2 = findViewById(R.id.editTextPassword);
        b = findViewById(R.id.buttonSignup);
        b2 = findViewById(R.id.buttonSignup2);
        mAuth = FirebaseAuth.getInstance();
    }

    public void createUser(View view) {
        String email, pass;
        email = ed1.getText().toString().trim();
        pass = ed2.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    databaseReference = FirebaseDatabase.getInstance().getReference("users");
                    user = mAuth.getCurrentUser();
                    Toast.makeText(firebasechecker.this, "Account created", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(firebasechecker.this, "Account not created", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    public void loginUser(View view)
    {
        String email, pass;
        email = ed1.getText().toString().trim();
        pass = ed2.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(firebasechecker.this, "Successfully logged in ", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(firebasechecker.this, "Unsuccessful login attempt", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
