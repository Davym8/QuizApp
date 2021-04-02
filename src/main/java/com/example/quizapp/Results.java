package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Results extends AppCompatActivity
{
    TextView resultsmessage, score;
    String name;
    Button newquiz, exit;
    int results;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        resultsmessage = findViewById(R.id.resultname);
        score = findViewById(R.id.score);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        results = intent.getIntExtra("score",0);

        resultsmessage.setText("Thanks for playing "+ name);
        score.setText("Your Score: "+ results +"/10");

        newquiz = findViewById(R.id.newquiz);
        exit = findViewById(R.id.exit);

        newquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                finishAffinity();
            }
        });

    }
}