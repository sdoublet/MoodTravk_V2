package com.example.doubl.moodtrack;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private SmileyAdapter smileyAdapter;
    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer2;
    MediaPlayer loop;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.son);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.musique);
        loop=MediaPlayer.create(this, R.raw.loop);




        recyclerView = findViewById(R.id.rv1);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // ArrayList Smiley and Background
        List<Happy> happyList = new ArrayList<>();
        happyList.add(new Happy(getResources().getDrawable(R.drawable.smileysuperhappy), getResources().getDrawable(R.color.banana_yellow)));
        happyList.add(new Happy(getResources().getDrawable(R.drawable.smileyhappy), getResources().getDrawable(R.color.light_sage)));
        happyList.add(new Happy(getResources().getDrawable(R.drawable.smileynormal), getResources().getDrawable(R.color.cornflower_blue_65)));
        happyList.add(new Happy(getResources().getDrawable(R.drawable.smileydisappointed), getResources().getDrawable(R.color.warm_grey)));
        happyList.add(new Happy(getResources().getDrawable(R.drawable.smileysad), getResources().getDrawable(R.color.faded_red)));


        smileyAdapter = new SmileyAdapter(happyList);
        recyclerView.setAdapter(smileyAdapter);

//SnapHelper for fix item
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);


    }
// choisir le mood et créer une animation sur le smiley
    public void mood_choice (View view){
        final TextView mood_choice = findViewById(R.id.tv_smiley);
        mood_choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Votre choix a bien été pris en compte", Toast.LENGTH_LONG).show();
                RotateAnimation rotateAnimation=new RotateAnimation(0,7200,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation.setDuration(5000);
                mood_choice.startAnimation(rotateAnimation);
                loop.start();

                // change l'historique en fonction du mood choisi
                // background history = background happylist
                // enregistre les preferences

            }

        });
    }

// Set history btn and launch activity
    public  void history (View view){
        Button history = findViewById(R.id.history_btn);
        Intent intent=new Intent(this, History.class);
        startActivity(intent);
        mediaPlayer.start();
    }

//Set DialogFragment for comment your mood
    public void comment (View view){
       Log.i("Main", "comment");
       DialogFragment dialogFragment = new DialogFragment();
       dialogFragment.show(getSupportFragmentManager(), "Dialog");

    }
// Affichage du message enregistré dans l'historique
   public  void history_comment (View view){
       TextView history_comment =findViewById(R.id.tv7);
       history_comment.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            // afficher un toast


            }
       });
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
}
