package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
{
    EditText editname;
    Button startbtn;

    public void clickQuiz(View view)
    {
        if(editname.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Enter name to start!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            startquiz();
        }
    }

    public void startquiz()
    {
        Intent intent = new Intent(getApplicationContext(), Quizactivity.class);
        intent.putExtra("names", editname.getText().toString());
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editname = findViewById(R.id.editName);
        startbtn = findViewById(R.id.startbutton);

    }


}
