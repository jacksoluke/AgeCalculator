package com.luke.jackson.agecalculator.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.luke.jackson.agecalculator.R;
import com.luke.jackson.agecalculator.model.AgeMath;

public class ResultActivity extends AppCompatActivity {

    private TextView resultText;
    private TextView yearsText;
    private TextView monthsText;
    private TextView weeksText;
    private TextView daysText;
    private TextView hoursText;
    private TextView minutesText;
    private TextView secondsText;
    private Button againButton;
    private int age;

    // This is how to create a TAG for use with Log.d
    public static final String TAG = ResultActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultText = (TextView) findViewById(R.id.resultTextView);
        yearsText = (TextView) findViewById(R.id.yearsTextView);
        monthsText = (TextView) findViewById(R.id.monthsTextView);
        weeksText = (TextView) findViewById(R.id.weeksTextView);
        daysText = (TextView) findViewById(R.id.daysTextView);
        hoursText = (TextView) findViewById(R.id.hoursTextView);
        minutesText = (TextView) findViewById(R.id.minutesTextView);
        secondsText = (TextView) findViewById(R.id.secondsTextView);
        againButton = (Button) findViewById(R.id.againButton);

        againButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // This pulls the extra data (age) sent from MainActivity
        Intent intent = getIntent();
        age = intent.getIntExtra("age", 0);
        Log.d(TAG, ""+age);
        calculateAge();
    }

    // This method gets creates an AgeMath Object and passes that Object to setViews
    private void calculateAge() {
        AgeMath result = new AgeMath(age);
        setViews(result);
    }

    // Sets the values of the text fields on the screen
    private void setViews(AgeMath result) {
        yearsText.setText(String.valueOf(result.getYears()));
        monthsText.setText(String.valueOf(result.getMonths()));
        weeksText.setText(String.valueOf(result.getWeeks()));
        daysText.setText(String.valueOf(result.getDays()));
        hoursText.setText(String.valueOf(result.getHours()));
        minutesText.setText(String.valueOf(result.getMinutes()));
        secondsText.setText(String.valueOf(result.getSeconds()));
    }
}
