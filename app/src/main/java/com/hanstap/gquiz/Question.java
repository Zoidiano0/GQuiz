package com.hanstap.gquiz;

import android.widget.Button;
import android.widget.TextView;

/**
 * Created by zoidiano0 on 01/03/16.
 */
public class Question {
    private int mTextResId;

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    private boolean mAnswerTrue;

    public Question(int textResId, boolean answerTrue){

        mAnswerTrue=answerTrue;
        mTextResId=textResId;
    }


    }



