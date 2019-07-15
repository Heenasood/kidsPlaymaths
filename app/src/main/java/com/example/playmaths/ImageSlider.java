package com.example.playmaths;

import android.content.Context;
import android.os.Handler;
import android.widget.ImageView;

public class ImageSlider extends Thread {

    Handler handler;
    Context context;
    ImageView imageSlider;

    int imagePosition;

    int [] imageResources = {R.drawable.imgapp1, R.drawable.imgapp2, R.drawable.imgapp3, R.drawable.imgapp5, R.drawable.imgapp6};;

    int slider_duration_seconds = 20;

    public ImageSlider(Handler handler, Context context, ImageView imageSlider){
        this.handler = handler;
        this.context = context;
        this.imageSlider = imageSlider;

        //imageResources = {R.drawable.imgapp1, R.drawable.imgapp2, R.drawable.imgapp3, R.drawable.imgapp5, R.drawable.imgapp6};

        imagePosition = 0;
    }

    public void run(){

        // The images will keep changing for 20 seconds then stops.
        for(int i = 0; i < slider_duration_seconds; i++){

            try{
                sleep(1000);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    imageSlider.setImageResource(imageResources[imagePosition]);
                }
            });

            imagePosition++;

            if(imagePosition >= imageResources.length)
                imagePosition = 0;
        }
    }
}