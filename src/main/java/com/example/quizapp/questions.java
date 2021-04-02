package com.example.quizapp;

public class questions
{
    //quiz variables
    String questiontitle, question, ans1,ans2,ans3, rightone;
    //constructor
    public questions(String questiontitle, String question,String ans1,String ans2,String ans3,String rightone)
    {
        this.ans1 = ans1;
        this.question = question;
        this.questiontitle = questiontitle;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.rightone = rightone;
    }

    public com.example.quizapp.questions[] questions = new questions[10];

    public questions()
    {
        questions[0] = new questions("User interface question: ","What does toast do? ","it makes you toast. ","its a textView box.","Toast provides a timed popup that displays feedback about an operation. ", "ans3" );
        questions[1] = new questions("Activity Class question: ", "What does an activity do? ", "Activity provides a window template for User input. ", "Activity is something that you do. ", "Activity provides a template of an app. ", "ans1");
        questions[2] = new questions("UI development question: ", "What method allows access to a widget? ","getApplicationInfo() ", "findViewById() ","getIntent()","ans2");
        questions[3] = new questions("Intent development question: ", "How are activities arranged in memory? ", "Arranged in a stacked format.", "Arranged like pancakes. ", "Heap memory.","ans1");
        questions[4] = new questions("Intent Question: ","What method passes data to the intent? ","setIntent()","PutExtra()","getExtraData()","ans2");
        questions[5] = new questions("Activity Life: ","How many lifecycles do activities have? ","5","4","3","ans2");
        questions[6] = new questions("Lifecycle callbacks:","how many core callbacks does the activity class have? ","10","8","6","ans3");
        questions[7] = new questions("For all intents and purposes:","What does an intent do?","Intent is a messaging function used to communicate.","Intent is an event handler.","Intent is notion to do something.","ans1");
        questions[8] = new questions("User Interface: ","Does TextView allow editing?","Yes","No","Maybe so","ans2");
        questions[9] = new questions("User Interface: Buttons","What does setOnClickListener do?","Invoking this method will make a callback function to run to listen to widgets.","it listens to your problems.","Provides a resource for you to talk to.","ans1");
    }
    public questions[] getqlist() {
        return questions;
    }
}
