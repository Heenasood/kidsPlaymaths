package com.example.playmaths;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SelectPracticeTypeActivity extends AppCompatActivity {

    GridLayout gridLayout;
    CardView cardView;
    ImageView addition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_practice_type);

        gridLayout=(GridLayout)findViewById(R.id.mainGrid);
        final CardView addition = (CardView) gridLayout.findViewById(R.id.Addition);
        final CardView subtraction = (CardView)gridLayout.findViewById(R.id.Subtraction);
        final CardView multiplication = (CardView)gridLayout.findViewById(R.id.Multiplication);
        final CardView division = (CardView)gridLayout.findViewById(R.id.Division);
        final CardView mix = (CardView)gridLayout.findViewById(R.id.Mix);

        setSingleEvent(gridLayout);



        addition.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {

                        //     play.setImageDrawable(getResources().getDrawable(R.drawable.play_click2));

                        break;
                    }
                    case MotionEvent.ACTION_UP:{

//                        play.setImageDrawable(getResources().getDrawable(R.drawable.play_clicked));
                        Intent intent = new Intent(SelectPracticeTypeActivity.this, PracticeActivity.class);
                        intent.putExtra("gameSelected","+");
                        intent.putExtra("start",0);
                        intent.putExtra("end",10);
                        startActivity(intent);
                        break;
                    }

                }

                return true;
            }
        });

        subtraction.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {

                        //  play.setImageDrawable(getResources().getDrawable(R.drawable.play_click2));

                        break;
                    }
                    case MotionEvent.ACTION_UP:{

//                        play.setImageDrawable(getResources().getDrawable(R.drawable.play_clicked));
                        Intent intent = new Intent(SelectPracticeTypeActivity.this, PracticeActivity.class);
                        intent.putExtra("gameSelected","-");
                        intent.putExtra("start",0);
                        intent.putExtra("end",10);
                        startActivity(intent);
                        break;
                    }

                }

                return true;
            }
        });

        multiplication.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {

                        // play.setImageDrawable(getResources().getDrawable(R.drawable.play_click2));

                        break;
                    }
                    case MotionEvent.ACTION_UP:{

//                        play.setImageDrawable(getResources().getDrawable(R.drawable.play_clicked));
                        Intent intent = new Intent(SelectPracticeTypeActivity.this, PracticeActivity.class);
                        intent.putExtra("gameSelected","*");
                        intent.putExtra("start",0);
                        intent.putExtra("end",10);
                        startActivity(intent);
                    }

                }

                return true;
            }
        });

        division.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {

                        // play.setImageDrawable(getResources().getDrawable(R.drawable.play_click2));

                        break;
                    }
                    case MotionEvent.ACTION_UP:{

//                        play.setImageDrawable(getResources().getDrawable(R.drawable.play_clicked));
                        Intent intent = new Intent(SelectPracticeTypeActivity.this, PracticeActivity.class);
                        intent.putExtra("gameSelected","/");
                        intent.putExtra("start",0);
                        intent.putExtra("end",10);
                        startActivity(intent);
                    }

                }

                return true;
            }
        });

        mix.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {

                        //   play.setImageDrawable(getResources().getDrawable(R.drawable.play_click2));

                        break;
                    }
                    case MotionEvent.ACTION_UP:{

//                        play.setImageDrawable(getResources().getDrawable(R.drawable.play_clicked));
                        Intent intent = new Intent(SelectPracticeTypeActivity.this, PracticeActivity.class);
                        intent.putExtra("gameSelected","mix");
                        intent.putExtra("start",0);
                        intent.putExtra("end",10);
                        startActivity(intent);
                        break;
                    }

                }

                return true;
            }
        });

    }

    private void setSingleEvent(GridLayout gridLayout) {
        for(int i = 0; i<gridLayout.getChildCount(); i++){
            cardView=(CardView)gridLayout.getChildAt(i);
            final TextView tv=(TextView) gridLayout.findViewById(i);
            final int finalI= i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(SelectPracticeTypeActivity.this,"Clicked at index "+ finalI,
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


}
