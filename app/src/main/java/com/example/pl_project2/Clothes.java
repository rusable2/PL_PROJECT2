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

    Button b7,b9,b10,b11,b12,b13;
    ListAdapter ls2,ls3,ls4;
    ListView lv2,lv3,lv4;
    ImageButton ib1;
    String colourst[] = {"White","Black","Red","Green","Blue"};
    String coloursh[] = {"Yellow","Red","Blue","Green","Bluegreen"};
    String colourss[] = {"Black","Red","Orange","Green","Blue"};
    String cl,cl2,cl3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        onClickButtonListener();
    }

    private void onClickButtonListener() {
        b7 = findViewById(R.id.button7);
        b9 = findViewById(R.id.button9);
        b10 = findViewById(R.id.button10);
        b11 = findViewById(R.id.button11);
        b12 = findViewById(R.id.button12);
        b13 = findViewById(R.id.button13);
        ib1 = findViewById(R.id.imageButton);
        ls2 = new ArrayAdapter<>(this,android.R.layout.select_dialog_item,colourst);
        ls3 = new ArrayAdapter<>(this,android.R.layout.select_dialog_item,colourss);
        ls4 = new ArrayAdapter<>(this,android.R.layout.select_dialog_item,coloursh);
        lv2 = findViewById(R.id.list2);
        lv3 = findViewById(R.id.list3);
        lv4 = findViewById(R.id.list4);
        lv2.setAdapter(ls2);
        lv3.setAdapter(ls3);
        lv4.setAdapter(ls4);
        b11.setVisibility(View.GONE);
        b12.setVisibility(View.GONE);
        b13.setVisibility(View.GONE);
        ib1.setVisibility(View.GONE);
        lv2.setVisibility(View.GONE);
        lv3.setVisibility(View.GONE);
        lv4.setVisibility(View.GONE);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b7.setX(200);
                b7.setY(220);
                b9.setVisibility(View.GONE);
                b10.setVisibility(View.GONE);
                lv2.setVisibility(View.VISIBLE);
                b11.setVisibility(View.VISIBLE);
                ib1.setVisibility(View.VISIBLE);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b9.setX(200);
                b9.setY(220);
                b7.setVisibility(View.GONE);
                b10.setVisibility(View.GONE);
                lv3.setVisibility(View.VISIBLE);
                b12.setVisibility(View.VISIBLE);
                ib1.setVisibility(View.VISIBLE);
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b10.setX(200);
                b10.setY(220);
                b9.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                lv4.setVisibility(View.VISIBLE);
                b13.setVisibility(View.VISIBLE);
                ib1.setVisibility(View.VISIBLE);
            }
        });
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b7.setX(250);
                b7.setY(300);
                b9.setX(250);
                b9.setY(550);
                b10.setX(250);
                b10.setY(800);
                b7.setVisibility(View.VISIBLE);
                b9.setVisibility(View.VISIBLE);
                b10.setVisibility(View.VISIBLE);
                lv2.setVisibility(View.GONE);
                lv3.setVisibility(View.GONE);
                lv4.setVisibility(View.GONE);
                b11.setVisibility(View.GONE);
                b13.setVisibility(View.GONE);
                b12.setVisibility(View.GONE);
                ib1.setVisibility(View.GONE);
            }
        });
        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cl = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(Clothes.this,cl,Toast.LENGTH_SHORT).show();
            }
        });
        lv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cl2 = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(Clothes.this,cl2,Toast.LENGTH_SHORT).show();
            }
        });
        lv4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cl3 = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(Clothes.this,cl3,Toast.LENGTH_SHORT).show();
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Clothes.this, finaltshirt.class);
                i.putExtra("Colours",cl);
                startActivity(i);
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("com.example.pl_project2.finalsweatshirt");
                i.putExtra("Colours",cl2);
                startActivity(i);
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("com.example.pl_project2.finalhoodie");
                i.putExtra("Colours",cl3);
                startActivity(i);
            }
        });
    }
}
