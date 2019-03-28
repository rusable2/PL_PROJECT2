package com.example.pl_project2;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;


public class finaltshirt extends AppCompatActivity {
    Button clear,save,cont;
    ImageView im2;
    int c_id;
    int i;
    String color;
    FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
    StorageReference storageRef = firebaseStorage.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finaltshirt);
        clear = findViewById(R.id.clear);
        save = findViewById(R.id.save);
        cont = findViewById(R.id.cont);
        im2 = findViewById(R.id.imageView2);
        im2.setImageResource(android.R.color.transparent);
        i = (int) (Math.random()*((29999-0)-1));
        pickImage();
        onClick();
    }
    private void pickImage() {
        Intent i = getIntent();
        color = i.getStringExtra("Colours").toString();
        if(color.equals("White"))
            c_id=0;
        else if(color.equals("Red"))
            c_id=1;
        else if(color.equals("Blue"))
            c_id=2;
        else if(color.equals("Black"))
            c_id=3;
        else if (color.equals("Green"))
            c_id=4;

        if(c_id==0)
            im2.setImageResource(R.drawable.tshirtfront);
        else if(c_id==1)
            im2.setImageResource(R.drawable.tshirt_red);
        else if(c_id==2)
            im2.setImageResource(R.drawable.tshirt_blue);
        else
            im2.setImageResource(android.R.color.transparent);
    }

    private void onClick()
    {
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(finaltshirt.this, Clothes.class);
                startActivity(i2);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent("com.example.pl_project.purchasingtshirt");
                i2.putExtra("type", color);
                startActivity(i2);
            }
        });
    }
    private void save()
    {
        StorageReference s = storageRef.child("tshirts.jpg/");
        StorageReference stref = s.child("tshirt" + i + ".jpg/");
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
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                // ...
            }
        });


    }

}
