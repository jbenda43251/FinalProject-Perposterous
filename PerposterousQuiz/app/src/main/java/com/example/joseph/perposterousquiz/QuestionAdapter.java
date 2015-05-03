package com.example.joseph.perposterousquiz;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by rl1065uq on 4/22/2015.
 */
public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    boolean correctChoice;
    List<Answer> answers;

    public QuestionAdapter(List<Answer> answers)
    {
        this.answers = answers;
    }//End Constructor

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.answer, parent, false);

        ViewHolder viewHolder = new ViewHolder(view, new ViewHolder.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                correctChoice = answers.get(position).getCorrectStatus();
            }
        });
        return viewHolder;
    }//End method onCreateViewHolder

    public void onBindViewHolder(ViewHolder holder, int i){

    }//End method onBindViewHolder

    @Override
    public int getItemCount() {
        return answers.size();
    }//End method getItemCount


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ItemClickListener listener;

        public ViewHolder(View itemView, ItemClickListener listener) {

            super(itemView);
            this.listener = listener;
        }//End Constructor

        public void onClick(View view) {listener.onItemClick(view, getPosition());

        }//End method onClick

        public interface ItemClickListener
        {
            void onItemClick(View view, int position);
        }//End interface itemClickListener

    }// End sub class ViewHolder


}// End class QuestionAdapater
