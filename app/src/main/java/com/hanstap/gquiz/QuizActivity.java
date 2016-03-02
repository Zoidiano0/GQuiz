package com.hanstap.gquiz;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private TextView mQuestionTextView;
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_text,true),
            new Question(R.string.question_africa,false),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_americas,true),
            new Question(R.string.question_asia,true),
            new Question(R.string.question_oceans,true)
    };


    private int mCurrentindex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mQuestionTextView =(TextView)findViewById(R.id.question_text_view);
        mTrueButton = (Button)findViewById(R.id.true_button);
        mFalseButton = (Button)findViewById(R.id.false_button);
        mNextButton=(ImageButton)findViewById(R.id.next_button);
        mPrevButton=(ImageButton)findViewById(R.id.prev_button);


        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);

            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });


        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });

        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousQuestion();
            }
        });

        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });

        updateQuestion();

    }




    private void updateQuestion(){
        mCurrentindex=(mCurrentindex+1)%mQuestionBank.length;
        int question = mQuestionBank[mCurrentindex].getTextResId();
        mQuestionTextView.setText(question);

    }
    private void previousQuestion(){
        mCurrentindex=(mCurrentindex-1)%mQuestionBank.length;
        if(mCurrentindex<=0){
            mCurrentindex=1;
            Toast.makeText(this, R.string.first_quest,Toast.LENGTH_SHORT).show();
        }
        int question = mQuestionBank[mCurrentindex].getTextResId();
        mQuestionTextView.setText(question);

    }
    private void checkAnswer( boolean userPresedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentindex].isAnswerTrue();
        int messageResId=0;
        if(userPresedTrue==answerIsTrue){
            messageResId=R.string.correct_toast;
        }else{
            messageResId=R.string.fail_toast;
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
