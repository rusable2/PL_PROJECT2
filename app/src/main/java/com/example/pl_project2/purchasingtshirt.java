package com.example.pl_project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class purchasingtshirt extends AppCompatActivity {

    EditText ed;
    TextView tv,tv3;
    String color,prc;
    int price;
    Button b6,b8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchasinghoodie);
        ed = findViewById(R.id.editText);
        tv = findViewById(R.id.textView);
        tv3 = findViewById(R.id.textView3);
        b6 = findViewById(R.id.button6);
        b8 = findViewById(R.id.button8);
        Intent i = getIntent();
        color = i.getStringExtra("type").toString();
        onClick();
    }

    private void onClick() {
        tv.setText("Tshirt - " + color);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prc = ed.getText().toString();
                price = Integer.parseInt(prc);
                tv3.setText("Price of one tshirt- 399.00\n\nTotal Price - " +(399*price)+".00");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(purchasingtshirt.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
