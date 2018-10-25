package com.example.doubl.moodtrack;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        TextView tv = findViewById(R.id.tv1);
        ViewGroup.LayoutParams params= tv.getLayoutParams();
        params.width=800;
        tv.setLayoutParams(params);
        tv.setBackground(getResources().getDrawable(R.color.banana_yellow));
        tv.setText("yoyoyoyoyoyo");
        tv.setTextSize(20);



    }



}
