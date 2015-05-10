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
    private String creator;
    public QuestionRecyclerView(){

    }//End Constructor


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question_recycler_view, container, false);
    }// End onCreateView

    public void onViewCreated(View view, Bundle savedInstanceState){

        super.onViewCreated(view, savedInstanceState);
        creator = getArguments() != null ? getArguments().getString("creator") : "Joseph";

        answers = (RecyclerView)view.findViewById(R.id.recycler_answers);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        answers.setLayoutManager(layoutManager);


        List<Answer> listAnswers = new ArrayList<>();
        if(creator.equals("Nathan"))
        {
            listAnswers = mockAnswersNathan();
        }
        else if (creator.equals("Joseph"))
        {
            listAnswers = mockAnswersJoseph();
        }
        else
        {
            listAnswers = mockAnswersCharles();
        }

        answers.setAdapter(new QuestionAdapter(listAnswers, getActivity()));

    }

    private List<Answer> mockAnswersNathan(){

        List<Answer> answers = new ArrayList<>();

        answers.add(new Answer("1: One", false, "Nathan"));
        answers.add( new Answer("2: One", true, "Nathan"));
        answers.add(new Answer("3: One", false, "Nathan"));
        answers.add(new Answer("4: One", false, "Nathan"));

        return answers;
    }

    private List<Answer> mockAnswersJoseph(){

        List<Answer> answers = new ArrayList<>();

        answers.add( new Answer("Love", false, "Joseph"));
        answers.add( new Answer("Money", false, "Joseph"));
        answers.add( new Answer("Secret", true, "Joseph"));
        answers.add( new Answer("Pride", false, "Joseph"));

        return answers;
    }

    private List<Answer> mockAnswersCharles(){

        List<Answer> answers = new ArrayList<>();

        answers.add( new Answer("11", true, "Charles"));
        answers.add( new Answer("22", false, "Charles"));
        answers.add( new Answer("33", false, "Charles"));
        answers.add( new Answer("44", false, "Charles"));

        return answers;
    }

}
