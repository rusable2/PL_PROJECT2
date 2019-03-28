package com.example.pl_project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class purchased extends AppCompatActivity {

    TextView tv;
    ImageButton ib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchased);
        tv = findViewById(R.id.textView2);
        ib = findViewById(R.id.imageButton3);
        onClick();
    }

    private void onClick() {
        tv.setText("Thank you for your purchase!\nHope to see you again!");
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(purchased.this, FirstPage.class);
                startActivity(i);
            }
        });
    }
}
