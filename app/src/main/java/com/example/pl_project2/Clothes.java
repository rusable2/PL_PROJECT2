package com.example.pl_project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Clothes extends AppCompatActivity {

    Button b7,b8,b9,b10,b11;
    ListAdapter ls,ls2;
    ListView lv,lv2;
    ImageButton ib1;
    String sleeves[] = {"Sleeveless","Half Sleeves","Long Sleeves"};
    String colours[] = {"White","Black","Red","Green","Blue"};
    String sl,cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        onClickButtonListener();
    }

    private void onClickButtonListener() {
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        b10 = findViewById(R.id.button10);
        b11 = findViewById(R.id.button11);
        ib1 = findViewById(R.id.imageButton);
        ls = new ArrayAdapter<>(this,android.R.layout.select_dialog_item,sleeves);
        ls2 = new ArrayAdapter<>(this,android.R.layout.select_dialog_item,colours);
        lv = findViewById(R.id.list);
        lv.setAdapter(ls);
        lv2 = findViewById(R.id.list2);
        lv2.setAdapter(ls2);
        b11.setVisibility(View.GONE);
        ib1.setVisibility(View.GONE);
        lv.setVisibility(View.GONE);
        lv2.setVisibility(View.GONE);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b8.setVisibility(View.GONE);
                b9.setVisibility(View.GONE);
                b10.setVisibility(View.GONE);
                lv.setVisibility(View.VISIBLE);
                lv2.setVisibility(View.VISIBLE);
                b11.setVisibility(View.VISIBLE);
                ib1.setVisibility(View.VISIBLE);
            }
        });
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b8.setVisibility(View.VISIBLE);
                b9.setVisibility(View.VISIBLE);
                b10.setVisibility(View.VISIBLE);
                lv.setVisibility(View.GONE);
                lv2.setVisibility(View.GONE);
                b11.setVisibility(View.GONE);
                ib1.setVisibility(View.GONE);
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sl = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(Clothes.this,sl,Toast.LENGTH_SHORT).show();
            }
        });
        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cl = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(Clothes.this,cl,Toast.LENGTH_SHORT).show();
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Clothes.this, finaltshirt.class);
                i.putExtra("Sleeves",sl);
                i.putExtra("Colours",cl);
                startActivity(i);
            }
        });
    }
}
