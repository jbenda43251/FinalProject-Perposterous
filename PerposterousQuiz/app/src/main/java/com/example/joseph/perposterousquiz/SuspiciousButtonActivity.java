package com.example.joseph.perposterousquiz;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class SuspiciousButtonActivity extends ActionBarActivity {

    Timer timer = new Timer();
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspicious_button);
        timer.execute();

        button = (Button) findViewById(R.id.bt_suspicious);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent newAct = new Intent(SuspiciousButtonActivity.this, GameOverActivity.class);
                timer.cancel(true);
                startActivity(newAct);
            }
        });
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
                Intent newAct = new Intent(SuspiciousButtonActivity.this, MainActivity.class);
                startActivity(newAct);

            } catch (InterruptedException e) {
                Thread.interrupted();
            }


            return null;
        }


    }//End sublcass Timer
}
