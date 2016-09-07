package com.example.mtmi.minikgamzeler;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AdminHomePageActivity extends AppCompatActivity {

    Button kayit_ekle_btn;
    ImageView picture;
    static final int REQUEST_IMAGE_CAPTURE=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_homepage_drawer);

        kayit_ekle_btn= (Button) findViewById(R.id.kayit_ekle_btn);

        kayit_ekle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kayit_ekle_btn.setVisibility(View.GONE);

                Intent pictureCaptureIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if(pictureCaptureIntent.resolveActivity(getPackageManager())!=null){
                    startActivityForResult(pictureCaptureIntent,REQUEST_IMAGE_CAPTURE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        picture= (ImageView) findViewById(R.id.imgPreview);
        if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode==RESULT_OK){

            Bundle extras=data.getExtras();
            Bitmap imageBitmap= (Bitmap) extras.get("data");
            picture.setImageBitmap(imageBitmap);
            picture.setVisibility(View.VISIBLE);
        }
    }
}
