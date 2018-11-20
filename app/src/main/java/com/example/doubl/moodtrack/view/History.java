package com.example.doubl.moodtrack.view;


import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.doubl.moodtrack.R;
import com.example.doubl.moodtrack.model.Mood;
import com.example.doubl.moodtrack.model.MoodEnum;
import com.example.doubl.moodtrack.outils.DatabaseManager;
import com.example.doubl.moodtrack.outils.HistoryListAdapter;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {
    private ListView listView;
    private DatabaseManager databaseManager;
    private ArrayList<Mood> moodArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_bis);


        listView = findViewById(R.id.activity_history_list_view);
         databaseManager = new DatabaseManager(this);
       if (moodArrayList!=null ){// voir la bonne condition
           historyList();//create list
       }else {
           Toast.makeText(this, "No history yet, back tomorrow", Toast.LENGTH_LONG).show();
           setContentView(R.layout.activity_history_empty);
       }
       databaseManager.close();

        //historyList();
        listView.setAdapter(new HistoryListAdapter(this, R.layout.row_history_mood, moodArrayList));





    }



    public void fillDatabase() {

        databaseManager.insertComment("salut", MoodEnum.SUPPER_HAPPY);
        databaseManager.insertComment("", MoodEnum.HAPPY);
        databaseManager.insertComment("imotep", MoodEnum.NORMAL);
        databaseManager.insertComment("", MoodEnum.HAPPY);
        databaseManager.insertComment("pas content", MoodEnum.DISAPPOINTED);
        databaseManager.insertComment("very pas content", MoodEnum.SAD);
        databaseManager.insertComment("", MoodEnum.HAPPY);


    }

    public void historyList() {
        List<Mood> moodList = databaseManager.readForAWeek();// create history list
        moodArrayList.addAll(moodList);

    }// add into history list



}




