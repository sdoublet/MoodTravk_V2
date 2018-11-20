package com.example.doubl.moodtrack.outils;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doubl.moodtrack.R;
import com.example.doubl.moodtrack.model.Mood;

import java.util.ArrayList;


public class HistoryListAdapter extends ArrayAdapter<Mood> {
    private ArrayList<Mood> moodsList;

    private Context context;


    public HistoryListAdapter(Context context, int layoutResourceId, ArrayList<Mood> moodsList) {
        super(context, layoutResourceId, moodsList);
        this.context = context;
        this.moodsList = moodsList;

    }


    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        TextView textViewDay;
        ImageButton imageButtonComment;
        DisplayMetrics displayMetrics;
        displayMetrics = context.getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels / 5;


        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.row_history_mood, parent, false);

        }
        textViewDay = convertView.findViewById(R.id.row_history_mood_text);
        imageButtonComment = convertView.findViewById(R.id.row_history_mood_button);

        final Mood mood = moodsList.get(position);
        textViewDay.setText(mood.getDaysAgo()); //finalize this
        Log.i("text", textViewDay.toString());
        if ((!mood.getComment().equals(""))) {
            imageButtonComment.setVisibility(View.VISIBLE);
        } else imageButtonComment.setVisibility(View.INVISIBLE);
        imageButtonComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, mood.getComment(), Toast.LENGTH_LONG).show();
            }
        });


        if (mood.getMood().contains("SUPPER_HAPPY")) {
            convertView.getLayoutParams().width = width * 5;
            convertView.setBackgroundColor(convertView.getResources().getColor(R.color.banana_yellow));
        } else if (mood.getMood().contains("HAPPY")) {
            convertView.getLayoutParams().width = width * 4;
            convertView.setBackgroundColor(convertView.getResources().getColor(R.color.light_sage));
        } else if (mood.getMood().contains("NORMAL")) {
            convertView.getLayoutParams().width = width * 3;
            convertView.setBackgroundColor(convertView.getResources().getColor(R.color.cornflower_blue_65));
        } else if (mood.getMood().contains("DISAPPOINTED")) {
            convertView.getLayoutParams().width = width * 2;
            convertView.setBackgroundColor(convertView.getResources().getColor(R.color.warm_grey));
        } else if (mood.getMood().contains("SAD")) {
            // setMoodBackground(convertView, 1);

            convertView.getLayoutParams().width = width;
            convertView.setBackgroundColor(convertView.getResources().getColor(R.color.faded_red));

        }

        return convertView;
    }
}





