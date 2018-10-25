package com.example.doubl.moodtrack;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SmileyAdapter extends RecyclerView.Adapter <SmileyAdapter.HappyViewHolder>{

    List<Happy> happyList;


    public static class HappyViewHolder extends RecyclerView.ViewHolder{
        TextView smiley;
        ImageView background1;
        public HappyViewHolder(@NonNull View itemView) {
            super(itemView);
            smiley=itemView.findViewById(R.id.tv_smiley);
            background1=itemView.findViewById(R.id.iv_smiley);
        }
    }

    public SmileyAdapter(List<Happy> happyList) {
        this.happyList = happyList;
    }

    @NonNull
    @Override
    public HappyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_happy, viewGroup, false);
        HappyViewHolder happyViewHolder = new HappyViewHolder(view);
        return happyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HappyViewHolder happyViewHolder, int position) {
        Happy happy = happyList.get(position);
        happyViewHolder.smiley.setBackground(happy.getSmiley());
        happyViewHolder.background1.setBackground(happy.getBackground1());

    }

    @Override
    public int getItemCount() {
        return happyList.size();
    }


}
