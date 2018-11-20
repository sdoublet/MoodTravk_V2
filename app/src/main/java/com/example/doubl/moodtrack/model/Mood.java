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

    public String getDaysAgo() {
       // history time

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.FRENCH);
        String[] number = {"", "", "", "trois", "quatre", "cinq", "six"};
        long days = 0;
        try {

            Date newDate = sdf.parse(getWhen());
            days = (new Date().getTime() - newDate.getTime()) / 86400000;
            Log.i("seb", getWhen());
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        if(days == 0) return "Aujourd'hui";
        else if(days == 1) return "Hier";
        else if(days == 2) return "Avant-hier";
        else if(days == 7) return "Il y a une semaine";
        else return "Il y a " + number[(int) days] + " jours";
    }


   }









