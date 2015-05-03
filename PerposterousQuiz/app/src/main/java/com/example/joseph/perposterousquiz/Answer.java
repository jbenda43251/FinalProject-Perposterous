package com.example.joseph.perposterousquiz;

/**
 * Created by rl1065uq on 4/29/2015.
 */
public class Answer {
    public String potentialAnswer;
    public boolean correct;

    public Answer(String potentialAnswer, boolean correct)
    {
        this.potentialAnswer = potentialAnswer;
        this.correct = correct;
    }//End constructor

    public String getAnswer(){
        return potentialAnswer;
    }//End getPotentialAnswer

    public boolean getCorrectStatus(){
        return correct;
    }//End getCorrectStatus
}
