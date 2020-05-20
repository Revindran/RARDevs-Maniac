package com.rar.cameraimageshare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity
{

    ImageView imageView;
    Button takebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imgv);
        takebtn = (Button) findViewById(R.id.tkbtn);

        takebtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });



    }

    private void takePicture()
    {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, 0);
        Toast.makeText(this, "Opening Camera!", Toast.LENGTH_SHORT).show();
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK)
        {
            Bitmap b  = (Bitmap)data.getExtras().get("data");
                imageView.setImageBitmap(b);

        }

    }
}
