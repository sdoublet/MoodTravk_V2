package com.example.doubl.moodtrack.model;


import android.util.Log;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Mood {

    private String comment;
    private String mood_;
    private String when;


    public Mood() {
    }

    public Mood(String comment, String mood, String when) {
        this.setComment(comment);
        this.setMood(mood);
        this.when = when;


    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getMood() {
        return mood_;
    }

    public void setMood(String mood_) {
        this.mood_ = mood_;

    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getDaysAgo()  {
        // history time
        
        long days = 0;
        long a = Long.parseLong(when);

        days = (new Date().getTime()/86400000 - a/ 86400000);


        if (days == 0) return "Today";
        else if (days>=1 && days<2) return "Yesterday";
        else if (days>=2 && days<3) return "two days ago";
        else if (days>=3 && days<4) return "three days ago";
        else if (days>=4 && days<5) return "four days ago";
        else if (days>=5 && days<6) return "five days ago";
        else if (days>=6 && days<7) return "six days ago";

        else  return "A week ago";

    }


}













