package com.example.pl_project2;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class hoodie2 extends AppCompatActivity {


    FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
    StorageReference storageRef = firebaseStorage.getReference();
    ImageView im3;
    int in;
    Button purc;
    String id,type;
    String clr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tshirt2);
        im3 = findViewById(R.id.imageView3);
        purc = findViewById(R.id.purc);
        Intent i = getIntent();
        id = i.getStringExtra("id").toString();
        type = i.getStringExtra("type").toString();
        clr = i.getStringExtra("color").toString();
        in = Integer.parseInt(id);
        download();
    }

    private void download() {
        StorageReference s = storageRef.child("hoodies.jpg");
        StorageReference stref = s.child(type+in+".jpg");
        final long ONE_MEGABYTE = 1024 * 1024;
        stref.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                // Data for "images/island.jpg" is returns, use this as needed
                Bitmap b = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                im3.setImageBitmap(b);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
        purc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 =  new Intent(hoodie2.this, purchasinghoodie.class);
                i2.putExtra("type", clr);
                startActivity(i2);
            }
        });
    }

}
