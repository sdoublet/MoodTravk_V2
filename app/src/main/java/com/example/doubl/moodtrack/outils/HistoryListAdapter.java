package com.example.doubl.moodtrack.outils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doubl.moodtrack.R;
import com.example.doubl.moodtrack.model.Mood;
import com.example.doubl.moodtrack.model.MoodEnum;

import java.util.ArrayList;

public class HistoryListAdapter extends ArrayAdapter<Mood> {
    private ArrayList<Mood> moodsList = new ArrayList<>();
    private Context context;
    private String[] backgroundColor= {"banana_yellow", "light_sage", "cornflower_blue_65", "warm_grey", "faded_red"};

    public HistoryListAdapter( Context context, int layoutRessourceId, ArrayList<Mood> moodsList) {
        super(context, layoutRessourceId, moodsList);
        this.context = context;
        this.moodsList = moodsList;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        TextView textViewDay;
        ImageButton imageButtonComment;

        if(convertView == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.row_history_mood, parent, false);
        }
        textViewDay = convertView.findViewById(R.id.row_history_mood_text);
        imageButtonComment = convertView.findViewById(R.id.row_history_mood_button);

        final Mood mood = moodsList.get(position);
        textViewDay.setText(mood.getDaysAgo());
        if ((!mood.getComment().equals("")))
            imageButtonComment.setVisibility(View.VISIBLE);

        imageButtonComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, mood.getComment(),Toast.LENGTH_LONG).show();
            }
        });


        return convertView;
    }

}
