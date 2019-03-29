package com.example.pl_project2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;


public class finalhoodie extends AppCompatActivity {
    Button clear,save,purc,purc2;
    ImageView im2;
    int c_id;
    int in;
    String color,id;
    FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
    StorageReference storageRef = firebaseStorage.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finaltshirt);
        clear = findViewById(R.id.clear);
        save = findViewById(R.id.save);
        purc = findViewById(R.id.cont);
        purc2 = findViewById(R.id.get);
        im2 = findViewById(R.id.imageView2);
        im2.setImageResource(android.R.color.transparent);
        in = (int) (Math.random()*((29999-0)-1));
        pickImage();
        onClick();
    }
    private void pickImage() {
        Intent i = getIntent();
        color = i.getStringExtra("Colours").toString();
        id = String.valueOf(in);
        if(color.equals("Yellow"))
            c_id=0;
        else if(color.equals("Red"))
            c_id=1;
        else if(color.equals("Blue"))
            c_id=2;
        else if(color.equals("Green"))
            c_id=3;
        else if (color.equals("Bluegreen"))
            c_id=4;

        if(c_id==0)
            im2.setImageResource(R.drawable.hoodie_yellow1);
        else if(c_id==1)
            im2.setImageResource(R.drawable.hoodie_red1);
        else if(c_id==2)
            im2.setImageResource(R.drawable.hoodie_blue1);
        else if(c_id==3)
            im2.setImageResource(R.drawable.hoodie_green1);
        else
            im2.setImageResource(R.drawable.hoodie_bluegreen1);
    }

    private void onClick()
    {
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(finalhoodie.this, Clothes.class);
                startActivity(i2);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
        purc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(finalhoodie.this, purchasinghoodie.class);
                i2.putExtra("type", color);
                startActivity(i2);
            }
        });
        purc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = String.valueOf(in);
                Intent i2 = new Intent(finalhoodie.this, hoodie2.class);
                i2.putExtra("id", id);
                i2.putExtra("type", "hoodies");
                i2.putExtra("color", color);
                startActivity(i2);
            }
        });
    }
    private void save()
    {
        StorageReference s = storageRef.child("hoodies.jpg/");
        StorageReference stref = s.child("hoodies" + in + ".jpg/");
        // Get the data from an ImageView as bytes
        im2.setDrawingCacheEnabled(true);
        im2.buildDrawingCache();
        Bitmap bitmap = ((BitmapDrawable) im2.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();

        UploadTask uploadTask = stref.putBytes(data);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(finalhoodie.this, "Image uploaded to Firebase", Toast.LENGTH_SHORT).show();
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                // ...
            }
        });


    }

}
