package com.example.joseph.perposterousquiz;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by rl1065uq on 5/4/2015.
 */
public class mockQuestionActivity extends ActionBarActivity {
    protected void onCreate(Bundle saveInstanceState_){

        TextView questionText = (TextView) findViewById(R.id.tv_question);
        questionText.setText("What is the answer?");

        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new QuestionRecyclerView())
                        // Don't forget this nice little animation!
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();



    }
}
