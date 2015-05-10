package com.example.joseph.perposterousquiz;

/**
 * Created by rl1065uq on 4/29/2015.
 */
public class Answer {
    public String potentialAnswer;
    public boolean correct;
    public String creator;

    public Answer(String potentialAnswer, boolean correct, String c)
    {
        this.potentialAnswer = potentialAnswer;
        this.correct = correct;
        this.creator = c;
    }//End constructor

    public String getAnswer(){
        return potentialAnswer;
    }//End getPotentialAnswer

    public boolean getCorrectStatus(){
        return correct;
    }//End getCorrectStatus
}
