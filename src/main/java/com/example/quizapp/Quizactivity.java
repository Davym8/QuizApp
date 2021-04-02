package com.example.quizapp;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Quizactivity extends AppCompatActivity
{
    String playername; //name of person playing
    TextView progresscounter, title, nameplate, question;
    ProgressBar progressbar;
    Button answer1,answer2,answer3, nextbutton, submitbutton;
    int probarcalc = 10; //10 because its out of 100  so its in tenths
    int rightanswers = 0; //global variable to keep track of right answers
    int qlistiterator = 1; //start at one because array objects always start at 0
    boolean answerclicked = false; //ensure answer is clicked


    //initialising array of objects
    questions[] qlist = new questions().getqlist();
    questions presentquestion = qlist[qlistiterator-1];

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizactivity);

        nameplate = findViewById(R.id.textname);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        progresscounter = findViewById(R.id.counter);
        title = findViewById(R.id.title);
        question = findViewById(R.id.question);
        nextbutton = findViewById(R.id.nextbutton);
        progressbar = findViewById(R.id.progressBar3);

        submitbutton = findViewById(R.id.submitbutton);

        Intent intent = getIntent();
        playername = intent.getStringExtra("names");
        nameplate.setText("Welcome "+ playername);
        questiondetails();
    }
    //reset button default colour
    public void buttoncolor()
    {
        answer1.setBackgroundColor((Color.parseColor("#717171")));
        answer2.setBackgroundColor((Color.parseColor("#717171")));
        answer3.setBackgroundColor((Color.parseColor("#717171")));
    }


    //set the next question
    @SuppressLint("NewApi")
    public void nextbutton(View view)
    {

        if(qlistiterator < 10)
        {
            presentquestion = qlist[qlistiterator++];
            probarcalc+=10;
            questiondetails();
            nameplate.setVisibility(View.GONE);
        }
        else
        {
            Intent intent = new Intent(getApplicationContext(),Results.class);
            intent.putExtra("name",playername);
            intent.putExtra("score",rightanswers);
            startActivityForResult(intent, 1);
        }

        buttoncolor();

    }


    //shows the correct answer
    public void showcorrectanswer()
    {
        switch (presentquestion.rightone)
        {
            case "ans1":
                answer1.setBackgroundColor(Color.GREEN);
                break;
            case "ans2":
                answer2.setBackgroundColor(Color.GREEN);
                break;
            case "ans3":
                answer3.setBackgroundColor(Color.GREEN);
                break;
        }
    }
    //set the question details
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void questiondetails()
    {
        Intent intent = getIntent();
        progresscounter.setText(qlistiterator+"/10");
        progressbar.setProgress(probarcalc,true);
        title.setText(presentquestion.questiontitle);
        question.setText(presentquestion.question);
        answer1.setText(presentquestion.ans1);
        answer2.setText(presentquestion.ans2);
        answer3.setText(presentquestion.ans3);
        answer1.setClickable(true);
        answer2.setClickable(true);
        answer3.setClickable(true);
        answerclicked = false;
        submitbutton.setVisibility(View.VISIBLE);
        nextbutton.setVisibility(View.GONE);
    }
    public void submitbutton(View view )
    {

        if(answerclicked == false)
        {
            Toast.makeText(Quizactivity.this, "Select an answer to continue! ", Toast.LENGTH_SHORT).show();
        }
        else
        {

            showcorrectanswer();
            submitbutton.setVisibility(View.GONE);
            nextbutton.setVisibility(View.VISIBLE);
        }

    }

    //waits for user click and locks buttons once clicked
    public void onClickAnswer(View view)
    {
        answerclicked = true;
        switch(view.getId())
        {

            case R.id.answer1:
                if(presentquestion.rightone.equals("ans1"))
                {
                    rightanswers+=1;
                    answer1.setBackgroundColor(Color.GREEN);
                }
                else
                {
                    answer1.setBackgroundColor(Color.RED);
                }
                answer2.setClickable(false);
                answer3.setClickable(false);
                break;
            case R.id.answer2:
                if (presentquestion.rightone.equals("ans2"))
                {
                    rightanswers+=1;
                    answer2.setBackgroundColor(Color.GREEN);
                }
                else
                {
                    answer2.setBackgroundColor(Color.RED);
                }
                answer1.setClickable(false);
                answer3.setClickable(false);
                break;
            case R.id.answer3:
                if (presentquestion.rightone.equals("ans3"))
                {
                    rightanswers+=1;
                    answer3.setBackgroundColor(Color.GREEN);
                }
                else
                {
                    answer3.setBackgroundColor(Color.RED);
                }
                answer2.setClickable(false);
                answer1.setClickable(false);
                break;
        }

    }

    //creates new activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK)
        {

            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();

        }
    }
}