package com.example.reddragon.guessthenum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int guessSize;
    int min;
    int max;
    int n;

    TextView displayView;
    Button lowerButton;
    Button higherButton;
    Button correctButton;
    Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //----------------Define Scope--------------------------------

        guessSize = 10000;

        min = 0;
        max = guessSize;
        n = randomNumGenerator();

        displayView = (TextView)findViewById(R.id.TV_Guess);
        lowerButton = (Button)findViewById(R.id.BT_Lower);
        higherButton = (Button)findViewById(R.id.BT_Higher);
        correctButton = (Button)findViewById(R.id.BT_Correct);
        resetButton = (Button)findViewById(R.id.BT_Reset);

////------------------------------------------------------------------
////----------------Set On Click Listener-----------------------------

        lowerButton.setOnClickListener(this);
        higherButton.setOnClickListener(this);
        correctButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);

////------------------------------------------------------------------
        displayView.setText(String.valueOf(halfNumMethod()));

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case (R.id.BT_Lower):
                max = halfNumMethod();
                displayView.setText(String.valueOf(halfNumMethod()));

                break;

            case (R.id.BT_Higher):
                min = halfNumMethod();
                displayView.setText(String.valueOf(halfNumMethod()));

                break;

            case (R.id.BT_Correct):
                String correctText = " YAY! ";
                displayView.setText(correctText);
                min = 0;
                max = 10000;

                break;

            case (R.id.BT_Reset):
                String resetText = "0";
                displayView.setText(resetText);
                min = 0;
                max = 10000;

                break;
        }
    }

    private int randomNumGenerator(){
        Random randomNum = new Random();
        int result = randomNum.nextInt(10000 + 1);
        return result;
    }

    private int halfNumMethod(){
        int halfMethod;
        halfMethod = ((max - min)/2);
        return (min + halfMethod);
    }

}
