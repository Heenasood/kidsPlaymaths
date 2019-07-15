package com.example.playmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PracticeActivity extends AppCompatActivity {


    int start , end,answer1, firsNumber , secondNumber,thirdNumber,answer2,answer3,answer4 , mixRandomNumber;
    String gameSelected;
    float[] fstart,fend, firstfloatnumer, secondfloadnumber, fanswer, fanswer2,fanswer3,fanser4;
    TextView tv_ques,tv_result,tv_firstOption,tv_secondOption,tv_thirdOption,tv_fourthOption;
    ImageButton ib_firstOption,ib_secondOption,ib_thirdOption,ib_fourthOption;
    ArrayList<Integer> answers = new ArrayList<>();
    ArrayList<float[]> fanswers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);


        start = getIntent().getExtras().getInt("start");
        end = getIntent().getExtras().getInt("end");
        gameSelected = getIntent().getExtras().getString("gameSelected");

        tv_ques = (TextView) findViewById(R.id.textView4);
        tv_result = (TextView) findViewById(R.id.textView6);
        tv_result.setText("?");

        tv_firstOption = (TextView) findViewById(R.id.textView7);
        tv_secondOption = (TextView) findViewById(R.id.textView8);
        tv_thirdOption = (TextView) findViewById(R.id.textView9);
        tv_fourthOption = (TextView) findViewById(R.id.textView10);


        ib_firstOption = (ImageButton) findViewById(R.id.imageButton2);
        ib_secondOption = (ImageButton) findViewById(R.id.imageButton3);
        ib_thirdOption = (ImageButton) findViewById(R.id.imageButton4);
        ib_fourthOption = (ImageButton) findViewById(R.id.imageButton5);

        TouchListners();
        selectAppropriateGame(gameSelected);


    }



    public void selectAppropriateGame(String game)
    {
        switch (game)
        {
            case "+":


                firsNumber = randomNumberGenerator(start , end);
                secondNumber = randomNumberGenerator(start , end);
                answer1 = 0;
                answer1 = firsNumber+secondNumber;
                answers.add(answer1);
                answer2 = randomNumberGenerator(start,end);
                answers.add(answer2);
                answer3 = randomNumberGenerator(start,end);
                answers.add(answer3);
                answer4 = randomNumberGenerator(start , end);
                answers.add(answer4);
                Collections.shuffle(answers);

                tv_ques.setText(firsNumber+" + "+secondNumber);
                tv_firstOption.setText(Integer.toString(answers.get(0)));
                tv_secondOption.setText(Integer.toString(answers.get(1)));
                tv_thirdOption.setText(Integer.toString(answers.get(2)));
                tv_fourthOption.setText(Integer.toString(answers.get(3)));



                break;
            case "-":

                firsNumber = randomNumberGenerator(start , end);
                secondNumber = randomNumberGenerator(start , end);
                while(firsNumber<secondNumber)
                {
                    firsNumber = randomNumberGenerator(start , end);
                    secondNumber = randomNumberGenerator(start , end);
                }
                answer1 = 0;
                answer1 = firsNumber-secondNumber;
                answers.add(answer1);
                answer2 = randomNumberGenerator(start,end);
                answers.add(answer2);
                answer3 = randomNumberGenerator(start,end);
                answers.add(answer3);
                answer4 = randomNumberGenerator(start , end);
                answers.add(answer4);
                Collections.shuffle(answers);

                tv_ques.setText(firsNumber+" - "+secondNumber);
                tv_firstOption.setText(Integer.toString(answers.get(0)));
                tv_secondOption.setText(Integer.toString(answers.get(1)));
                tv_thirdOption.setText(Integer.toString(answers.get(2)));
                tv_fourthOption.setText(Integer.toString(answers.get(3)));

                break;
            case "*":
                firsNumber = randomNumberGenerator(start , end);
                secondNumber = randomNumberGenerator(start , end);
                answer1 =0;
                answer1 = firsNumber*secondNumber;
                answers.add(answer1);
                answer2 = randomNumberGenerator(start,end);
                answers.add(answer2);
                answer3 = randomNumberGenerator(start,end);
                answers.add(answer3);
                answer4 = randomNumberGenerator(start , end);
                answers.add(answer4);
                Collections.shuffle(answers);

                tv_ques.setText(firsNumber+" * "+secondNumber);
                tv_firstOption.setText(Integer.toString(answers.get(0)));
                tv_secondOption.setText(Integer.toString(answers.get(1)));
                tv_thirdOption.setText(Integer.toString(answers.get(2)));
                tv_fourthOption.setText(Integer.toString(answers.get(3)));


                break;

            case "/":
                firsNumber = randomNumberGenerator(start , end);
                secondNumber = randomNumberGenerator(start , end);
                while(firsNumber<secondNumber)
                {
                    firsNumber = randomNumberGenerator(start , end);
                    secondNumber = randomNumberGenerator(start , end);
                }
                answer1 = firsNumber/secondNumber;
                answers.add(answer1);
                answer2 = randomNumberGenerator(start,end);
                answers.add(answer2);
                answer3 = randomNumberGenerator(start,end);
                answers.add(answer3);
                answer4 = randomNumberGenerator(start , end);
                answers.add(answer4);
                Collections.shuffle(fanswers);

                tv_ques.setText(firsNumber+" / "+secondNumber);
                tv_firstOption.setText(Integer.toString(answers.get(0)));
                tv_secondOption.setText(Integer.toString(answers.get(1)));
                tv_thirdOption.setText(Integer.toString(answers.get(2)));
                tv_fourthOption.setText(Integer.toString(answers.get(3)));


                break;

            case "mix":
                mixRandomNumber = randomNumberGenerator(0 , 5);
                switch (mixRandomNumber)
                {
                    case 0:

                        selectAppropriateGame("+");

                        break;
                    case 1:

                        selectAppropriateGame("-");

                        break;
                    case 2:

                        selectAppropriateGame("*");

                        break;
                    case 3:
                        firsNumber = randomNumberGenerator(start , end);
                        secondNumber = randomNumberGenerator(start , end);
                        thirdNumber = randomNumberGenerator(start , end);

                        answer1 =0;
                        answer1 = (firsNumber*secondNumber)+thirdNumber;
                        answers.add(answer1);
                        answer2 = randomNumberGenerator(start,end);
                        answers.add(answer2);
                        answer3 = randomNumberGenerator(start,end);
                        answers.add(answer3);
                        answer4 = randomNumberGenerator(start , end);
                        answers.add(answer4);
                        Collections.shuffle(answers);

                        tv_ques.setText(firsNumber+" * "+secondNumber+" + "+thirdNumber);
                        tv_firstOption.setText(Integer.toString(answers.get(0)));
                        tv_secondOption.setText(Integer.toString(answers.get(1)));
                        tv_thirdOption.setText(Integer.toString(answers.get(2)));
                        tv_fourthOption.setText(Integer.toString(answers.get(3)));


                        break;
                    case 4:
                        firsNumber = randomNumberGenerator(start , end);
                        secondNumber = randomNumberGenerator(start , end);
                        thirdNumber = randomNumberGenerator(start , end);
                        while((firsNumber*secondNumber)<thirdNumber)
                        {
                            firsNumber = randomNumberGenerator(start , end);
                            secondNumber = randomNumberGenerator(start , end);
                            thirdNumber = randomNumberGenerator(start , end);
                        }
                        answer1 =0;
                        answer1 = (firsNumber*secondNumber)-thirdNumber;
                        answers.add(answer1);
                        answer2 = randomNumberGenerator(start,end);
                        answers.add(answer2);
                        answer3 = randomNumberGenerator(start,end);
                        answers.add(answer3);
                        answer4 = randomNumberGenerator(start , end);
                        answers.add(answer4);
                        Collections.shuffle(answers);

                        tv_ques.setText(firsNumber+" * "+secondNumber+" - "+thirdNumber);
                        tv_firstOption.setText(Integer.toString(answers.get(0)));
                        tv_secondOption.setText(Integer.toString(answers.get(1)));
                        tv_thirdOption.setText(Integer.toString(answers.get(2)));
                        tv_fourthOption.setText(Integer.toString(answers.get(3)));


                        break;
                    case 5:

                        firsNumber = randomNumberGenerator(start , end);
                        secondNumber = randomNumberGenerator(start , end);
                        thirdNumber = randomNumberGenerator(start , end);
                        while((firsNumber*secondNumber)<thirdNumber)
                        {
                            firsNumber = randomNumberGenerator(start , end);
                            secondNumber = randomNumberGenerator(start , end);
                            thirdNumber = randomNumberGenerator(start , end);
                        }
                        answer1 =0;
                        answer1 = (firsNumber+secondNumber)-thirdNumber;
                        answers.add(answer1);
                        answer2 = randomNumberGenerator(start,end);
                        answers.add(answer2);
                        answer3 = randomNumberGenerator(start,end);
                        answers.add(answer3);
                        answer4 = randomNumberGenerator(start , end);
                        answers.add(answer4);
                        Collections.shuffle(answers);

                        tv_ques.setText(firsNumber+" + "+secondNumber+" - "+thirdNumber);
                        tv_firstOption.setText(Integer.toString(answers.get(0)));
                        tv_secondOption.setText(Integer.toString(answers.get(1)));
                        tv_thirdOption.setText(Integer.toString(answers.get(2)));
                        tv_fourthOption.setText(Integer.toString(answers.get(3)));

                        break;
                }
                break;
        }
    }

    public int randomNumberGenerator(int startValue , int endValue)
    {
        Random random = new Random();
        int n = random.nextInt(endValue - startValue + 1) + startValue;

        if(answers.size() >= -1)
        {
            for(int i =0 ; i < answers.size() ; i++)
            {
                if (n == answers.get(i))
                {
                    n = random.nextInt(endValue - startValue + 1) + startValue;
                    i=0;
                }
            }
        }

        return n;
    }



    public void TouchListners()
    {
        //clicks
        ib_firstOption.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {



                        break;
                    }
                    case MotionEvent.ACTION_UP:{
                        if(tv_firstOption.getText().equals(Integer.toString(answer1)))
                        {
                            Toast.makeText(PracticeActivity.this,"correct", Toast.LENGTH_SHORT).show();
                            tv_result.setText(tv_firstOption.getText());
                            answers.clear();
                            selectAppropriateGame(gameSelected);
                            tv_result.setText("?");
                        }
                        else
                        {
                            Toast.makeText(PracticeActivity.this,"incorrect", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    }

                }

                return true;
            }
        });
        ib_secondOption.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {

                        break;
                    }
                    case MotionEvent.ACTION_UP:{
                        if(tv_secondOption.getText().equals(Integer.toString(answer1)))
                        {

                            Toast.makeText(PracticeActivity.this,"correct", Toast.LENGTH_SHORT).show();
                            tv_result.setText(tv_secondOption.getText());
                            answers.clear();
                            selectAppropriateGame(gameSelected);
                            tv_result.setText("?");
                        }
                        else
                        {

                            Toast.makeText(PracticeActivity.this,"incorrect", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    }

                }

                return true;
            }
        });
        ib_thirdOption.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {

                        break;
                    }
                    case MotionEvent.ACTION_UP:{
                        if(tv_thirdOption.getText().equals(Integer.toString(answer1)))
                        {

                            Toast.makeText(PracticeActivity.this,"correct", Toast.LENGTH_SHORT).show();
                            tv_result.setText(tv_thirdOption.getText());
                            answers.clear();
                            selectAppropriateGame(gameSelected);
                            tv_result.setText("?");
                        }
                        else
                        {
                            Toast.makeText(PracticeActivity.this,"incorrect", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    }

                }

                return true;
            }
        });
        ib_fourthOption.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {

                        break;
                    }
                    case MotionEvent.ACTION_UP:{
                        if(tv_fourthOption.getText().equals(Integer.toString(answer1)))
                        {
                            Toast.makeText(PracticeActivity.this,"correct", Toast.LENGTH_SHORT).show();
                            tv_result.setText(tv_fourthOption.getText());
                            answers.clear();
                            selectAppropriateGame(gameSelected);
                            tv_result.setText("?");
                        }
                        else
                        {
                            Toast.makeText(PracticeActivity.this,"incorrect", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    }

                }

                return true;
            }
        });

    }
}
