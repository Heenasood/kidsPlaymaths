package com.example.playmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class ImageGalleryActivity extends AppCompatActivity {

    Handler handler;
    ImageView imageViewSlider;
    ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_image_gallery);

        handler = new Handler();

        imageViewSlider = findViewById(R.id.imageViewSlider);

        imageSlider = new ImageSlider(handler, ImageGalleryActivity.this, imageViewSlider);
        imageSlider.start();

    }
}
