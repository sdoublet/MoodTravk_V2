package com.example.doubl.moodtrack;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private SmileyAdapter smileyAdapter;
    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.son);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.musique);


        recyclerView = findViewById(R.id.rv1);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<Happy> happyList = new ArrayList<>();
        happyList.add(new Happy(getResources().getDrawable(R.drawable.smileysuperhappy), getResources().getDrawable(R.color.banana_yellow)));
        happyList.add(new Happy(getResources().getDrawable(R.drawable.smileyhappy), getResources().getDrawable(R.color.light_sage)));
        happyList.add(new Happy(getResources().getDrawable(R.drawable.smileynormal), getResources().getDrawable(R.color.cornflower_blue_65)));
        happyList.add(new Happy(getResources().getDrawable(R.drawable.smileydisappointed), getResources().getDrawable(R.color.warm_grey)));
        happyList.add(new Happy(getResources().getDrawable(R.drawable.smileysad), getResources().getDrawable(R.color.faded_red)));


        smileyAdapter = new SmileyAdapter(happyList);
        recyclerView.setAdapter(smileyAdapter);

        //Snaphelper

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
    }



// Set history btn and launch activity



    public  void history (View view){
        Button history = findViewById(R.id.history_btn);
        Intent intent=new Intent(this, History.class);
        startActivity(intent);
        mediaPlayer.start();

    }

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
}
