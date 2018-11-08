package com.example.doubl.moodtrack.model;

import java.util.Date;

public class Mood {
    private int idComment;
    private String comment;
    private String mood_;
    private Date when;

    public Mood(int idComment, String comment, String mood, Date when) {
        this.setIdComment(idComment);
        this.setComment(comment);
        this.setMood(mood);
        this.setWhen(when);
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
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

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }
}

