package com.example.doubl.moodtrack.view;

import android.content.Intent;
import android.database.Cursor;
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
import android.view.animation.RotateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.doubl.moodtrack.model.Mood;
import com.example.doubl.moodtrack.model.MoodEnum;
import com.example.doubl.moodtrack.outils.DatabaseManager;
import com.example.doubl.moodtrack.outils.DialogFragment;
import com.example.doubl.moodtrack.model.Happy;
import com.example.doubl.moodtrack.R;
import com.example.doubl.moodtrack.outils.SmileyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private SmileyAdapter smileyAdapter;
    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayer2;
    private MediaPlayer mediaplayer3;
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
        mediaplayer3 = MediaPlayer.create(this, R.raw.sound3);


        recyclerView = findViewById(R.id.rv1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // ArrayList Smiley and Background
        List<Happy> happyList = new ArrayList<>();
        happyList.add(new Happy(getResources().getDrawable(R.drawable.smiley_super_happy), getResources().getDrawable(R.color.banana_yellow)));
        happyList.add(new Happy(getResources().getDrawable(R.drawable.smiley_happy), getResources().getDrawable(R.color.light_sage)));
        happyList.add(new Happy(getResources().getDrawable(R.drawable.smiley_normal), getResources().getDrawable(R.color.cornflower_blue_65)));
        happyList.add(new Happy(getResources().getDrawable(R.drawable.smiley_disappointed), getResources().getDrawable(R.color.warm_grey)));
        happyList.add(new Happy(getResources().getDrawable(R.drawable.smiley_sad), getResources().getDrawable(R.color.faded_red)));


        smileyAdapter = new SmileyAdapter(happyList, null);
        recyclerView.setAdapter(smileyAdapter);

//SnapHelper for fix item
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);




    }




    // choisir le mood et créer une animation sur le smiley
  public void moodChoice(View view) {
//
      Toast.makeText(MainActivity.this, "Votre choix a bien été pris en compte", Toast.LENGTH_LONG).show();
      RotateAnimation rotateAnimation = new RotateAnimation(0, 3600, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
      rotateAnimation.setDuration(3700);
      view.startAnimation(rotateAnimation);
      mediaplayer3.start();
      // TODO: 07/11/2018   change l'historique en fonction du mood choisi
      // TODO: background history = background happylist
      // TODO: 07/11/2018 callback
      // TODO: 07/11/2018 mettre le mood choisi dans database
//
      //Log.i("DATABASE", "insertMood invokedMain");
      databaseManager = new DatabaseManager(this);
      databaseManager.insertComment("salut", MoodEnum.SAD);
      databaseManager.getWritableDatabase();
        Log.i("DATABASE", "insertcomment invoked main");
       //DialogFragment dialogFragment = new DialogFragment();
       //dialogFragment.show(getSupportFragmentManager(), "dialog");
//
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

    // Affichage du message enregistré dans l'historique
//    public void historyComment(View view) {
//        TextView historyComment = findViewById(R.id.tv7);
//        historyComment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // afficher un toast


//            }
//        });
//    }


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
