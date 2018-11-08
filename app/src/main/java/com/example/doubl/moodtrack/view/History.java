package com.example.doubl.moodtrack.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.doubl.moodtrack.R;


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



        oneDaAgo.setText("yoyoyoy");
        //oneDaAgo.set
        }









    }





