package com.example.playmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton settingButton;

    private static final int REQUEST_CODE_QUIZ = 1;
    public static final String EXTRA_CATEGORY_ID = "extraCategoryID";
    public static final String EXTRA_CATEGORY_NAME = "extraCategoryName";
    public static final String EXTRA_DIFFICULTY = "extraDifficulty";

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private TextView textViewHighscore;
    private Spinner spinnerCategory;
    private Spinner spinnerDifficulty;

    private int highscore;

    Button playbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        playbutton = (Button) findViewById(R.id.playbutton);
        settingButton = (ImageButton)findViewById(R.id.settingButton);
        textViewHighscore = findViewById(R.id.text_view_highscore);
        loadHighscore();

        ImageButton buttonStartQuiz = findViewById(R.id.imageButton);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });


        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, settingButton);

                popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {

          /*  case R.id.setting:

                Intent intentSetting = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intentSetting);

                return true;*/


                            case R.id.emailus:
                                Toast.makeText(MainActivity.this, "You clicked Email Us", Toast.LENGTH_SHORT).show();

                                Intent intentEmailus = new Intent(MainActivity.this, EmailusActivity.class);
                                startActivity(intentEmailus);

                                return true;

                            case R.id.contactus:
                                Toast.makeText(MainActivity.this, "You clicked Contact Us", Toast.LENGTH_SHORT).show();

                                Intent intentContactUS = new Intent(MainActivity.this, ContactusActivity.class);
                                startActivity(intentContactUS);

                                return true;

                            case R.id.locateus:
                                Toast.makeText(MainActivity.this, "You clicked Locate Us", Toast.LENGTH_SHORT).show();

                                Intent intentLocateus = new Intent(MainActivity.this, ContactusActivity.class);
                                startActivity(intentLocateus);
                                return true;

                            case R.id.rateme:
                                Toast.makeText(MainActivity.this, "You are about to redirect to App Store", Toast.LENGTH_SHORT).show();

                                Intent intentRateUs = new Intent(MainActivity.this, RatemeActivity.class);
                                startActivity(intentRateUs);

                                return true;

                            default:
                                return MainActivity.super.onOptionsItemSelected(item);
                        }
                    }
                });
                popupMenu.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

          /*  case R.id.setting:

                Intent intentSetting = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intentSetting);

                return true;*/


            case R.id.emailus:
                Toast.makeText(this, "You clicked Email Us", Toast.LENGTH_SHORT).show();

                Intent intentEmailus = new Intent(MainActivity.this, EmailusActivity.class);
                startActivity(intentEmailus);

                return true;

            case R.id.contactus:
                Toast.makeText(this, "You clicked Contact Us", Toast.LENGTH_SHORT).show();

                Intent intentContactUS = new Intent(MainActivity.this, ContactusActivity.class);
                startActivity(intentContactUS);

                return true;

            case R.id.locateus:
                Toast.makeText(this, "You clicked Locate Us", Toast.LENGTH_SHORT).show();

                Intent intentLocateus = new Intent(MainActivity.this, ContactusActivity.class);
                startActivity(intentLocateus);
                return true;

            case R.id.rateme:
                Toast.makeText(this, "You are about to redirect to App Store", Toast.LENGTH_SHORT).show();

                Intent intentRateUs = new Intent(MainActivity.this, RatemeActivity.class);
                startActivity(intentRateUs);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void startQuiz() {
        Intent intent = new Intent(MainActivity.this, SelectGameActivity.class);
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

    public void onClick(View v) {
        String curText = ((TextView) v).getText().toString();

        if (AudioPlay.isplayingAudio == true && curText.equals("Stop")) {

            ((TextView) v).setText("Music");
            AudioPlay.stopAudio();
        }

        if (AudioPlay.isplayingAudio == false && curText.equals("Music")) {
            ((TextView) v).setText("Stop");
            AudioPlay.playAudio(this, R.raw.appmusic2);
        }


    }
}


