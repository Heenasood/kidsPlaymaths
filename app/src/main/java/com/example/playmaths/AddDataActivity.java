package com.example.playmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class AddDataActivity extends AppCompatActivity {

    private TextView textView1,textView2, textView3;
    private SeekBar seekBar1, seekBar2, seekBar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        textView1 = (TextView) findViewById(R.id.textViewOption1);
        seekBar1 = (SeekBar) findViewById(R.id.seekBarOption1);
        textView2 = (TextView) findViewById(R.id.textViewOption2);
        seekBar2 = (SeekBar) findViewById(R.id.seekBarOption2);
        textView3 = (TextView) findViewById(R.id.textViewOption3);
        seekBar3 = (SeekBar) findViewById(R.id.seekBarOption3);

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar1, int progress, boolean fromUser) {
                textView1.setText(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar1) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar1) {

            }
        });

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                textView2.setText(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar2) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar2) {

            }
        });

        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar3, int progress, boolean fromUser) {
                textView3.setText(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar3) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar3) {

            }
        });
    }
}
