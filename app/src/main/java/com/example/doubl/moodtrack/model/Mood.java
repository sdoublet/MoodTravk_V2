package com.example.doubl.moodtrack.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Mood {
    //private int idComment;
    private String comment;
    private String mood_;
    private String when;
    private String color;

    public Mood(){}
    public Mood( String comment, String mood, String when, String color) {
       // this.setIdComment(idComment);
        this.setComment(comment);
        this.setMood(mood);
        this.setWhen(when);
        this.color = color;

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWhen(String when) {
        this.when = when;
    }

public String getDaysAgo() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String[] number = {"", "", "two", "three", "four", "five", "six"};
    long days = 0;
    try {
        Date newDate = simpleDateFormat.parse(when);
        days = (new Date().getTime() - newDate.getTime()) / 86400000;
    } catch (ParseException e) {
        e.printStackTrace();
    }
    if (days == 0) return "Today";
    else if (days == 1) return "Yesterday";
    else if (days == 7) return "One week ago";
    else return number[(int) days] + " days ago";
}


    @Override
    public String toString() {
        return getDaysAgo() +" " + mood_ + " "+comment;
    }
}


