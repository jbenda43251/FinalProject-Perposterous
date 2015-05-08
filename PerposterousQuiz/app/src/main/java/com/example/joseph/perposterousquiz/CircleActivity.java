package com.example.joseph.perposterousquiz;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class CircleActivity extends ActionBarActivity {

    TextView tvI;
    ImageView ivCirc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        tvI = (TextView) findViewById(R.id.Q2);
        ivCirc = (ImageView) findViewById(R.id.imageView);
        tvI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newAct = new Intent(CircleActivity.this, MainActivity.class);
                startActivity(newAct);

            }
        });

        ivCirc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newAct = new Intent(CircleActivity.this, GameOverActivity.class);
                startActivity(newAct);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_circle, menu);
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
