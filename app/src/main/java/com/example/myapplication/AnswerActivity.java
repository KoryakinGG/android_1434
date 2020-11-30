package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    private boolean isAnswerTrue;
    private TextView textAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        isAnswerTrue = getIntent().getBooleanExtra("answer",false);

        textAnswer = findViewById(R.id.textAnswer);
        textAnswer.setText(isAnswerTrue?R.string.yes:R.string.no);

        /*if(isAnswerTrue){
            textAnswer.setText(R.string.correct);
        }else{
            textAnswer.setText(R.string.incorrect);
        }*/



    }
}