package com.example.doubl.moodtrack.outils;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.doubl.moodtrack.model.Happy;
import com.example.doubl.moodtrack.R;

import java.util.List;

public class SmileyAdapter extends RecyclerView.Adapter <SmileyAdapter.HappyViewHolder>  {


    List<Happy> happyList;


    public static class HappyViewHolder extends RecyclerView.ViewHolder {
        public TextView smiley;
        public ImageView background1;

        public HappyViewHolder(View itemView) {
            super(itemView);
            smiley = itemView.findViewById(R.id.tv_smiley);
            background1 = itemView.findViewById(R.id.iv_smiley);

        }
   }



    public SmileyAdapter(List<Happy> happyList) {

        this.happyList = happyList;
    }



    @Override
    public HappyViewHolder onCreateViewHolder( ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_happy, parent, false);
        HappyViewHolder happyViewHolder = new HappyViewHolder(view);
        return happyViewHolder;
    }

    @Override
    public void onBindViewHolder( HappyViewHolder happyViewHolder, int position) {
        Happy happy = happyList.get(position);
        happyViewHolder.smiley.setBackground(happy.getSmiley());
        happyViewHolder.background1.setBackground(happy.getBackground1());

    }

    @Override
    public int getItemCount() {
        return happyList.size();
    }


}
