package com.luke.jackson.agecalculator.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.luke.jackson.agecalculator.R;

public class MainActivity extends AppCompatActivity {

    private TextView titleText;
    private EditText age;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sets Views
        titleText = (TextView) findViewById(R.id.titleTextView);
        age = (EditText) findViewById(R.id.ageText);
        calculateButton = (Button) findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Checks if age EditText is empty and creates toast if it is
                if(TextUtils.isEmpty(age.getText())) {
                    Toast.makeText(MainActivity.this, "Please enter an age higher than 0", Toast.LENGTH_LONG).show();
                }
                else {
                    int ageValue = Integer.parseInt(age.getText().toString());
                    if (ageValue <= 0) {
                        Toast.makeText(MainActivity.this, "Please enter an age higher than 0", Toast.LENGTH_LONG).show();
                    } else {
                        // Calls calculate age method
                        getResult(ageValue);
                    }
                }
            }
        });
    }


    //This makes all fields reset to original state whenever returning to this Activity
    @Override
    protected void onResume() {
        super.onResume();
        age.setText("");
    }

    // This method passes EditText data over to ResultActivity
    private void getResult(int ageValue) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("age", ageValue);
        startActivity(intent);
    }

}
