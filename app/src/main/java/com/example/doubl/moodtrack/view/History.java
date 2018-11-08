package com.example.doubl.moodtrack.view;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doubl.moodtrack.R;
import com.example.doubl.moodtrack.outils.DatabaseManager;


import java.util.Date;

public class History extends AppCompatActivity {
    private TextView toDay;
    private TextView oneDaAgo;
    private TextView twoDaAgo;
    private TextView threeDayAgo;
    private TextView fourDayAgo;
    private TextView fiveDayAgo;
    private TextView sixDayAgo;
    private TextView sevenDayAgo;
    private DatabaseManager databaseManager;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);



        oneDaAgo=findViewById(R.id.tv1);
        twoDaAgo=findViewById(R.id.tv2);
        threeDayAgo=findViewById(R.id.tv3);
        fourDayAgo=findViewById(R.id.tv4);
        fiveDayAgo=findViewById(R.id.tv5);
        sixDayAgo=findViewById(R.id.tv6);
        sevenDayAgo=findViewById(R.id.tv7);


        sixDayAgo.setCompoundDrawables(null, getResources().getDrawable(R.drawable.ic_comment_black_48px), null,null);
        sixDayAgo.setCompoundDrawables(null, null, null,null);

        oneDaAgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//               databaseManager.getReadableDatabase();
//               String strSql = "select from Comment_Table(comment, when)";
//               Cursor cursor = databaseManager.rawQuerry(strSql, null);


            }
        });

        // TODO: 08/11/2018   if(database comment !=null){set visibility}

        // TODO: 08/11/2018  Toast.makeText(comment database)

        }









    }





