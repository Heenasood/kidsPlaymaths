package com.example.playmaths;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.example.playmaths.MainActivity;
import com.example.playmaths.R;
import com.example.playmaths.SplashScreenActivity;

public class CountDown extends Thread {


    Animation animRotate;
    ImageView imgrotate;
    Handler handler;
    Context con;
    int start;

    public CountDown(int starting, Context con, ImageView tv, Handler handler) {
        this.imgrotate = tv;
        this.con = con;
        this.handler = handler;
        this.start = starting;
    }

    public void run()
    {
        for (int counter = start; counter >= 0; counter--) {
            final int finalCounter = counter;
            handler.post(new Runnable() {
                @Override
                public void run() {
                    animRotate = AnimationUtils.loadAnimation(con, R.anim.move );
                    imgrotate.setVisibility(View.VISIBLE);
                    imgrotate.startAnimation(animRotate);
                }
            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Intent intent = new Intent(con, MainActivity.class);
        con.startActivity(intent);
    }
}

