package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;


public class Result extends AppCompatActivity {

    TextView firstNumberTV;
    TextView secondNumberTV;
    TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        firstNumberTV = findViewById(R.id.firstNumberTV);
        secondNumberTV = findViewById(R.id.secondNumberTV);
        resultTV = findViewById(R.id.resultTV);

        Intent intent = getIntent(); //Объект с данными с прошлого активити
        int firstNumber = intent.getIntExtra("firstNumber", 0);
        int secondNumber = intent.getIntExtra("secondNumber", 0);
        int resultValue = intent.getIntExtra("sum", 0);

        firstNumberTV.setText(firstNumber + "");
        if (secondNumber < 0){
            secondNumberTV.setText("(" + secondNumber + ")");
        } else {
            secondNumberTV.setText(secondNumber + "");
        }
        resultTV.setText(resultValue + "");
    }

}