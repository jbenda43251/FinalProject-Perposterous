package com.example.joseph.perposterousquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class SuspiciousButtonActivity extends ActionBarActivity {

    ScoreboardFragment scoreFrag;
    Timer timer = new Timer();
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspicious_button);
        timer.execute();
        scoreFrag = new ScoreboardFragment();

        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, scoreFrag)
                .addToBackStack("")
                .commit();

        button = (Button) findViewById(R.id.bt_suspicious);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent newAct = new Intent(SuspiciousButtonActivity.this, GameOverActivity.class);
                SharedPreferences pref = getSharedPreferences("sccores", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = pref.edit();
                int etCurrentScore = pref.getInt("currentScore", 0);
                ed.putInt("currentScore", etCurrentScore - 10);
                ed.commit();
                timer.cancel(true);
                startActivity(newAct);
            }
        });
    }

    @Override
    public void onBackPressed() {
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_suspicious_button, menu);
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

    private class Timer extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] params) {

            try {
                Thread.sleep(6500);

            } catch (InterruptedException e) {
                Thread.interrupted();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            Intent newAct = new Intent(SuspiciousButtonActivity.this, mockedQuestionActivity.class);
            newAct.putExtra("creator", "Nathan");
            SharedPreferences pref = getSharedPreferences("sccores", Context.MODE_PRIVATE);
            SharedPreferences.Editor ed = pref.edit();
            int etCurrentScore = pref.getInt("currentScore", 0);
            ed.putInt("currentScore", etCurrentScore + 1);
            ed.commit();
            startActivity(newAct);
        }
    }//End sublcass Timer
}
