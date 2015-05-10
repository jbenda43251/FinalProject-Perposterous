package com.example.joseph.perposterousquiz;

import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class mockedQuestionActivity extends ActionBarActivity {

    TextView tvQuestion;
    String creator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mocked_question);
        tvQuestion = (TextView) findViewById(R.id.tv_question);

        creator = getIntent().getStringExtra("creator");
        if(creator.equals("Joseph"))
        {
            tvQuestion.setText("If you have me, you want to share me. " +
                    "If you share me, you haven't got me. What am I?");
        }
        else if (creator.equals("Nathan"))
        {
            tvQuestion.setText("What is the answer Nathan?");
        }
        else
        {
            tvQuestion.setText("What is the answer Charles?");
        }

        QuestionRecyclerView qrv = new QuestionRecyclerView();
        qrv.setArguments(getIntent().getExtras());
        getFragmentManager().beginTransaction()
                .replace(R.id.recyclerView_container, qrv)
                        // Don't forget this nice little animation!
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mocked_question, menu);
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
    @Override
    public void onBackPressed() {
    }
}
