package com.example.doubl.moodtrack.view;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.doubl.moodtrack.model.Mood;
import com.example.doubl.moodtrack.model.MoodEnum;
import com.example.doubl.moodtrack.outils.DatabaseManager;
import com.example.doubl.moodtrack.outils.DialogFragment;
import com.example.doubl.moodtrack.R;
import com.example.doubl.moodtrack.outils.SmileyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SmileyAdapter.OnMoodClickedCallBack {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private SmileyAdapter smileyAdapter;
    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayer2;
    private Mood mood;
    private TextView testView;
    private DatabaseManager databaseManager;
    private TextView moodchoice;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.son);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.sound1);



        recyclerView = findViewById(R.id.rv1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // ArrayList Smiley and Background
        List<MoodEnum> happyList = new ArrayList<>();
        happyList.add(MoodEnum.SUPPER_HAPPY);
        happyList.add(MoodEnum.HAPPY);
        happyList.add(MoodEnum.NORMAL);
        happyList.add(MoodEnum.DISAPPOINTED);
        happyList.add(MoodEnum.SAD);


        smileyAdapter = new SmileyAdapter(happyList, null);
        recyclerView.setAdapter(smileyAdapter);

//SnapHelper for fix item
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);



    }



    // Set history btn and launch activity
    public void history(View view) {
        Button history = findViewById(R.id.history_btn);
        Intent intent = new Intent(this, History.class);
        startActivity(intent);
        mediaPlayer.start();
    }

    //Set DialogFragment for comment your mood
    public void comment(View view) {
        Log.i("Main", "comment");
        DialogFragment dialogFragment = new DialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "Dialog");

    }



    // Set sounds
    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer2.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer2.pause();
    }

    @Override
    public void onMoodClicked(MoodEnum moodEnum) {
        databaseManager.insertComment(null, moodEnum);
    }
}
