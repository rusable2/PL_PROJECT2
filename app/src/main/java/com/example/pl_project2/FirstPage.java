package com.example.pl_project2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FirstPage extends AppCompatActivity {
    View v1,v2;
    ImageButton ib2;
    TextView tv;
    Button b2,b3,b4;
    int animation;
    DialogFragment f = new Frag2();
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        v1 = findViewById(R.id.view1);
        v2 = findViewById(R.id.view2);
        v2.setVisibility(View.GONE);
        ib2 = findViewById(R.id.imageButton2);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        tv=findViewById(R.id.textView);
        animation = getResources().getInteger(android.R.integer.config_shortAnimTime);
        tv.setText("SUPERFLY");
        onClick();
    }

    private void onClick() {
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1.animate().alpha(0f).setDuration(animation).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        v1.setVisibility(View.GONE);
                    }
                });
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        v2.setAlpha(0f);
                        v2.setVisibility(View.VISIBLE);
                        v2.animate().alpha(1f).setDuration(animation).setListener(null);
                        // Do something after 5s = 5000ms
                    }
                }, 3);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent("com.example.pl_project2.LoginPage");
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent("com.example.pl_project2.SignUpPage");
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f.setCancelable(false);
                f.show(ft, "dialog");
            }
        });
    }
}
