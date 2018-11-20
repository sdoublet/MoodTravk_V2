package com.example.doubl.moodtrack.outils;


import android.media.MediaPlayer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.doubl.moodtrack.R;

import com.example.doubl.moodtrack.model.Mood;
import com.example.doubl.moodtrack.model.MoodEnum;

import java.util.List;

public class SmileyAdapter extends RecyclerView.Adapter<SmileyAdapter.HappyViewHolder>  {


    private OnMoodClickedCallBack callBack;
    private MediaPlayer mediaplayer3;
    private DatabaseManager databaseManager;
    private DialogFragment dialogFragment;
    List<MoodEnum> happyList;
    DialogFragment getDialogFragment;


    public class HappyViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivSmiley;
        public View background;


        public HappyViewHolder(final View itemView) {
            super(itemView);
            ivSmiley = itemView.findViewById(R.id.iv_smiley);
            background = itemView.findViewById(R.id.view_background);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Mood mood = new Mood();
//
//                    if (getAdapterPosition() == 0) {
//                        databaseManager = new DatabaseManager(v.getContext());
//                        databaseManager.insertComment("", MoodEnum.SUPPER_HAPPY);
//                        databaseManager.getWritableDatabase();
//                        Log.i("DATABASE", "SupperHappy is writing");
//                    } else if (getAdapterPosition() == 1) {
//                        databaseManager = new DatabaseManager(v.getContext());
//                        databaseManager.insertComment("", MoodEnum.HAPPY);
//                        databaseManager.getWritableDatabase();
//                        Log.i("DATABASE", "Happy is writing");
//                    } else if (getAdapterPosition() == 2) {
//                        databaseManager = new DatabaseManager(v.getContext());
//                        databaseManager.insertComment("", MoodEnum.NORMAL);
//                        databaseManager.getWritableDatabase();
//                        Log.i("DATABASE", "Normal is writing");
//                    } else if (getAdapterPosition() == 3) {
//                        databaseManager = new DatabaseManager(v.getContext());
//                        databaseManager.insertComment("", MoodEnum.DISAPPOINTED);
//                        databaseManager.getWritableDatabase();
//                        Log.i("DATABASE", "Disappointed is writing");
//                    } else if (getAdapterPosition() == 4) {
//                        databaseManager = new DatabaseManager(v.getContext());
//                        databaseManager.insertComment("", MoodEnum.SAD);
//                        databaseManager.getWritableDatabase();
//                        Log.i("DATABASE", "Sad is writing");

//                    }


//                }
//            });

            ivSmiley.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    mediaplayer3 = MediaPlayer.create(v.getContext(), R.raw.sound3);
                    Toast.makeText(itemView.getContext(), "Votre choix a bien été pris en compte" + getAdapterPosition(), Toast.LENGTH_LONG).show();
                    RotateAnimation rotateAnimation = new RotateAnimation(0, 3600, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotateAnimation.setDuration(3700);
                    v.startAnimation(rotateAnimation);
                    mediaplayer3.start();

                    Mood mood = new Mood();


                    if (getAdapterPosition() == 0) {
                        mood.setMood("SUPER_HAPPY");
                        databaseManager = new DatabaseManager(v.getContext());
                        databaseManager.insertComment("", MoodEnum.SUPPER_HAPPY);
                        databaseManager.getWritableDatabase();
                        Log.i("DATABASE", "SupperHappy is writing");
                    } else if (getAdapterPosition() == 1) {
                        mood.setMood("HAPPY");
                        databaseManager = new DatabaseManager(v.getContext());
                        databaseManager.insertComment("", MoodEnum.HAPPY);

                        databaseManager.getWritableDatabase();
                        Log.i("DATABASE", "Happy is writing");
                    } else if (getAdapterPosition() == 2) {
                        mood.setMood("NORMAL");
                        databaseManager = new DatabaseManager(v.getContext());
                        databaseManager.insertComment("", MoodEnum.NORMAL);
                        databaseManager.getWritableDatabase();
                        Log.i("DATABASE", "Normal is writing");
                    } else if (getAdapterPosition() == 3) {
                        mood.setMood("DISAPPOINTED");
                        databaseManager = new DatabaseManager(v.getContext());
                        databaseManager.insertComment("", MoodEnum.DISAPPOINTED);
                        databaseManager.getWritableDatabase();
                        Log.i("DATABASE", "Disappointed is writing");
                    } else if (getAdapterPosition() == 4) {
                        mood.setMood("SAD");
                        databaseManager = new DatabaseManager(v.getContext());
                        databaseManager.insertComment("", MoodEnum.SAD);
                        databaseManager.getWritableDatabase();
                        Log.i("DATABASE", "Sad is writing");
                    }


                    Log.i("POSITION", "" + getAdapterPosition());
                }
            });
        }

    }


    public interface OnMoodClickedCallBack {
        void onMoodClicked(MoodEnum position);

    }


    public SmileyAdapter(List<MoodEnum> happyList, OnMoodClickedCallBack callBack) {

        this.happyList = happyList;
        this.callBack = callBack;


    }

    private void onMoodSmileyClicked(int adapterPosition) {
        callBack.onMoodClicked(happyList.get(adapterPosition));
    }

    @Override
    public HappyViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_happy, parent, false);
        HappyViewHolder happyViewHolder = new HappyViewHolder(view);
        return happyViewHolder;
    }

    @Override
    public void onBindViewHolder(HappyViewHolder happyViewHolder, int position) {
        MoodEnum happy = happyList.get(position);
        happyViewHolder.ivSmiley.setImageResource(happy.getDrawableIcone());
        happyViewHolder.background.setBackgroundColor(happyViewHolder.itemView.getContext().getResources().getColor(happy.getColorBakground()));


    }

    @Override
    public int getItemCount() {

        return happyList.size();
    }


}
