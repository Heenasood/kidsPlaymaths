package com.example.playmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class SelectGameActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_QUIZ = 1;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    public int highscore;

    private TextView textViewHighscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_select_game);

        textViewHighscore = findViewById(R.id.text_view_highscore);
        loadHighscore();


        final ImageButton addition = (ImageButton) findViewById(R.id.imageButtonAddition);
        final ImageButton subtraction = (ImageButton) findViewById(R.id.imageButtonSubtraction);
        final ImageButton multipy = (ImageButton) findViewById(R.id.imageButtonMulti);
        final ImageButton mix = (ImageButton) findViewById(R.id.imageButtonMixNew);


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
                        Intent intent = new Intent(SelectGameActivity.this, GamePlayScreenActivity.class);
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
                        ImageButton buttonStartQuiz = findViewById(R.id.imageButtonAddition);
                        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startQuiz();
                            }
                        });
                        break;
                    }

                }

                return true;
            }
        });

        multipy.setOnTouchListener(new View.OnTouchListener() {
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
                        Intent intent = new Intent(SelectGameActivity.this, GamePlayScreenActivity.class);
                        intent.putExtra("gameSelected","*");
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
                        Intent intent = new Intent(SelectGameActivity.this, GamePlayScreenActivity.class);
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

    private void startQuiz() {
        Intent intent = new Intent(SelectGameActivity.this, SelectGameActivity.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(GamePlayScreenActivity.EXTRA_SCORE, 0);
                if (score > highscore) {
                    updateHighscore(score);
                }
            }
        }
    }


    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighscore.setText("Highscore: " + highscore);
    }

    private void updateHighscore(int highscoreNew) {
        highscore = highscoreNew;
        textViewHighscore.setText("Highscore: " + highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }
}
