package com.example.joseph.perposterousquiz;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rl1065uq on 4/22/2015.
 */
public class QuestionRecyclerView extends Fragment{

    private RecyclerView answers;
    public QuestionRecyclerView(){

    }//End Constructor

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question_recycler_view, container, false);
    }// End onCreateView

    public void onViewCreated(View view, Bundle savedInstanceState){

        super.onViewCreated(view, savedInstanceState);

        answers = (RecyclerView)view.findViewById(R.id.recycler_answers);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        answers.setLayoutManager(layoutManager);

        List<Answer> listAnswers = mockAnswers();

        answers.setAdapter(new QuestionAdapter(listAnswers));

    }

    private List<Answer> mockAnswers(){

        List<Answer> answers = new ArrayList<>();

        answers.add( new Answer("One", true));
        answers.add( new Answer("Two", false));
        answers.add( new Answer("three", false));
        answers.add( new Answer("four", false));

        return answers;
    }

}
