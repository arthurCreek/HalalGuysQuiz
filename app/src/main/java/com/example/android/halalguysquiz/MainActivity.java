package com.example.android.halalguysquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void finishQuiz(View view){
        //Answer for question 1
        if(((RadioButton) findViewById(R.id.radio_new_york_city)).isChecked()) {
            score++;
        }

        //Anser for question 2
        if(((RadioButton) findViewById(R.id.radio_food_cart)).isChecked()) score++;

        //Anser for question 3
        if(((CheckBox) findViewById(R.id.check_chicken)).isChecked()
                && ((CheckBox) findViewById(R.id.check_gyro)).isChecked()
                && !((CheckBox) findViewById(R.id.check_pork)).isChecked()) score++;

        //Anser for question 4
        String answer4 = ((EditText) findViewById(R.id.edit_bread)).getText().toString().toLowerCase();
        if(answer4.equals("pita")) score++;

        //Anser for question 5
        if(((CheckBox) findViewById(R.id.check_red)).isChecked()
                && ((CheckBox) findViewById(R.id.check_yellow)).isChecked()
                && !((CheckBox) findViewById(R.id.check_white)).isChecked()) score++;


        //Anser for question 6
        if(((RadioButton) findViewById(R.id.radio_large)).isChecked()) score++;

        //Display the Toast
        Context context = getApplicationContext();

        CharSequence text;
        if(score == 6) {
            text = "Congrats! Your Score was " + score + " out of 6!";
        } else {
            text = "You only have " + score + " out of 6! Try again!";
        }
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        //Resest score to 0

        score = 0;
    }
}
