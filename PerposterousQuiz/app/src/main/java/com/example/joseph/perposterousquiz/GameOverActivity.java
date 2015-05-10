package com.example.joseph.perposterousquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class GameOverActivity extends ActionBarActivity {
    TextView returnTv;
    TextView scoreTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        scoreTv = (TextView) findViewById(R.id.score_tv);
        SharedPreferences pref = getSharedPreferences("sccores", Context.MODE_PRIVATE);
        final int etCurrentScore = pref.getInt("currentScore", -1);

        final int etHighScore = pref.getInt("highScore", 0) < etCurrentScore ?
                etCurrentScore : pref.getInt("highScore", 0);

        final int etLowScore = pref.getInt("lowScore", 0) > etCurrentScore ?
                etCurrentScore : pref.getInt("lowScore", 0);

        scoreTv.setText("Your final score is " + Integer.toString(etCurrentScore) + ".\n " +
                        "Your high score is " + Integer.toString(etHighScore));

        returnTv = (TextView) findViewById(R.id.return_tv);
        returnTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences pref = getSharedPreferences("sccores", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = pref.edit();
                ed.putInt("currentScore", etCurrentScore);
                ed.putInt("highScore", etHighScore);
                ed.putInt("lowScore", etLowScore);
                ed.commit();
                Intent newAct = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(newAct);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_over, menu);
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
