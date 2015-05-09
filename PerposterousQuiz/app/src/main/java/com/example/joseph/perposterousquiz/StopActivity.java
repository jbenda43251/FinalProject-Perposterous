package com.example.joseph.perposterousquiz;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class StopActivity extends ActionBarActivity {

    GridView clockLay;
    ScoreboardFragment scoreFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scoreFrag = new ScoreboardFragment();

        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, scoreFrag)
                .addToBackStack("")
                .commit();
        setContentView(R.layout.activity_stop);
        clockLay = (GridView) findViewById(R.id.gridview);
        clockLay.setAdapter(new ImageAdapter(this));
        clockLay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Send intent to SingleViewActivity
                SharedPreferences pref = getSharedPreferences("sccores", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = pref.edit();
                int etCurrentScore = pref.getInt("currentScore", 0);
                int etHighScore = pref.getInt("highScore", 0);
                if(position != 0) {
                    Intent i =
                            new Intent(getApplicationContext(), GameOverActivity.class);
                    // Pass image index
                    i.putExtra("score", position);
                    ed.putInt("currentScore", etCurrentScore - 20);
                    ed.putInt("highScore", etCurrentScore - 25);
                    ed.commit();
                    startActivity(i);

                }
                else
                {
                    Intent i =
                            new Intent(getApplicationContext(), GameOverActivity.class);
                    // Pass image index
                    i.putExtra("id", position);
                    ed.putInt("currentScore", etCurrentScore + 1);
                    ed.putInt("highScore", etCurrentScore + 2);
                    ed.commit();
                    startActivity(i);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stop, menu);
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

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setPadding(1, 1, 1, 1);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

        // references to our images
        private Integer[] mThumbIds = {
                R.drawable.hammerclock, R.drawable.gameclock,
                R.drawable.bedclock, R.drawable.crunchclock
        };
    }
}
