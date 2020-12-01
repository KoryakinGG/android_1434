package com.example.myapplication;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ResumeActivity extends AppCompatActivity {

    private Button btnExit;
    private Button btnRestart;
    TextView resumeText;

    private ArrayList <String> questions = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        questions.add("2+2=4?");
        questions.add("8-5=4?");
        questions.add("9-4=6?");
        questions.add("3+4=7?");
        questions.add("6-2=4?");


        resumeText = findViewById(R.id.resumeText);
        btnExit = findViewById(R.id.btnExit);
        btnRestart = findViewById(R.id.btnRestart);

        ArrayList<String> arrayFromIntent = (ArrayList<String>) getIntent().getSerializableExtra("clientAnswers");
        for (int i = 0; i < arrayFromIntent.size(); i++) {
            System.out.print("Данные в массиве: " + arrayFromIntent.get(i) + " : ");
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arrayFromIntent.size(); i++) {
            str.append(questions.get(i) + "     " + arrayFromIntent.get(i)).append("\n");

        } resumeText.setText(str);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appExit();
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // взято со стаковерфлоу
                Intent mStartActivity = new Intent(ResumeActivity.this,MainActivity.class);
                int mPendingIntentId = 123456;
                PendingIntent mPendingIntent = PendingIntent.getActivity(ResumeActivity.this, mPendingIntentId, mStartActivity,
                        PendingIntent.FLAG_CANCEL_CURRENT);
                AlarmManager mgr = (AlarmManager) ResumeActivity.this.getSystemService(Context.ALARM_SERVICE);
                mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
                System.exit(0);
            }
        });
    }

    //метод выхода из приложения. Взято со стаковерфлоу.
    public void appExit() {
        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}