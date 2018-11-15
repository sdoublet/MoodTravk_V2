package com.example.doubl.moodtrack.outils;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.doubl.moodtrack.model.Happy;
import com.example.doubl.moodtrack.R;
import com.example.doubl.moodtrack.model.MoodEnum;
import com.example.doubl.moodtrack.view.MainActivity;

import java.util.List;

public class SmileyAdapter extends RecyclerView.Adapter <SmileyAdapter.HappyViewHolder>  {

    private OnMoodClickedCallBack callBack;


    List<Happy> happyList;



    public static class HappyViewHolder extends RecyclerView.ViewHolder {
        public TextView smiley;
        public ImageView background1;
        private OnMoodClickedCallBack callBack;

        public HappyViewHolder(final View itemView) {
            super(itemView);
            smiley = itemView.findViewById(R.id.tv_smiley);
            background1 = itemView.findViewById(R.id.iv_smiley);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                Toast.makeText(itemView.getContext(), "yo", Toast.LENGTH_LONG).show();
                }
            });


        }   // choisir le mood et créer une animation sur le smiley
//        public void moodChoice(View view) {

//            Toast.makeText(itemView.getContext(), "Votre choix a bien été pris en compte", Toast.LENGTH_LONG).show();
//            RotateAnimation rotateAnimation = new RotateAnimation(0, 3600, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
//            rotateAnimation.setDuration(3700);
//            view.startAnimation(rotateAnimation);
//          //  mediaplayer3.start();
//            // TODO: 07/11/2018   change l'historique en fonction du mood choisi
//            // TODO: background history = background happylist
//            // TODO: 07/11/2018 callback
//            // TODO: 07/11/2018 mettre le mood choisi dans database

//            //Log.i("DATABASE", "insertMood invokedMain");
//           // databaseManager = new DatabaseManager(this);
//           // databaseManager.insertComment("salut", MoodEnum.SAD);
//           // databaseManager.getWritableDatabase();
//            Log.i("DATABASE", "insertcomment invoked main");
//            //DialogFragment dialogFragment = new DialogFragment();
//            //dialogFragment.show(getSupportFragmentManager(), "dialog");
//            onMoodSmileyClicked(getAdapterPosition());
//            Log.i("POSITION", itemView.toString());

//        }

        private void onMoodSmileyClicked(int adapterPosition) {
            callBack.onMoodClicked(adapterPosition);
        }

    }



    public interface OnMoodClickedCallBack{
        void onMoodClicked(int position);

    }



    public SmileyAdapter(List<Happy> happyList , OnMoodClickedCallBack callBack) {

        this.happyList = happyList;
        this.callBack = callBack;


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
