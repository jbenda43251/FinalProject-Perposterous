package com.example.joseph.perposterousquiz;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class ScoreboardFragment extends Fragment {

    private TextView currentScoreTv;
    private TextView highScoreTv;
    private TextView lowScoreTv;

    // TODO: Rename and change types and number of parameters
    public static ScoreboardFragment newInstance() {
        ScoreboardFragment fragment = new ScoreboardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ScoreboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scoreboard, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences prefs = getActivity().getSharedPreferences("sccores", Context.MODE_PRIVATE);

        currentScoreTv = (TextView) view.findViewById(R.id.tv_current_score);
        highScoreTv = (TextView) view.findViewById(R.id.tv_high_score);
        lowScoreTv = (TextView) view.findViewById(R.id.tv_low_score);

        currentScoreTv.setText("CurrentScore: " + Integer.toString(prefs.getInt("currentScore", 0)));
        highScoreTv.setText("HighScore: " + Integer.toString(prefs.getInt("highScore", 0)));
        lowScoreTv.setText("LowScore: " + Integer.toString(prefs.getInt("lowScore", 0)));
    }

}
