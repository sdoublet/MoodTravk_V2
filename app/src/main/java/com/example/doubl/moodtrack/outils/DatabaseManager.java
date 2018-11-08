package com.example.doubl.moodtrack.outils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.doubl.moodtrack.model.Mood;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public  class DatabaseManager extends SQLiteOpenHelper {

  private static final String DATABASE_NAME="Mood.db";
  private static final int DATABASE_VERSION= 1;

  /**
   * constructor
   * @param context
   */
  public DatabaseManager(Context context){
      super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  /**
   * if db change
   * @param db
   */
 @Override
 public void onCreate(SQLiteDatabase db) {
      String create = "create table Comment_Table("
             +" idComment integer primary key autoincrement,"
             +" comment text ,"
             +" mood text not null,"
             +" when_  integer not null"
             +")";
     db.execSQL(create);
     Log.i("DATABASE", "onCreate invoked");
 }

  /**
   * if version change
   * @param db
   * @param oldVersion
   * @param newVersion
   */
 @Override
 public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     String strSql = "drop table Comment_Table";
     db.execSQL(strSql);
     this.onCreate(db);
     Log.i("DATABASE", "onUpgrade invoked");
 }


 public  void insertComment(String comment){
     comment=comment.replace("'","''");
     String strSql = "insert into Comment_Table(comment, when_) values('"
             + comment +  "," + new Date().getTime() +")";

    getWritableDatabase();
     Log.i("DATABASE", "insertComment invokedManager");
 }


 public void insertMood (String mood){
      mood = mood.replace("'","''");
     String strSql = "insert into Comment_Table(comment, when_) values('"
             + mood +  "," + new Date().getTime() +")";
     Log.i("DATABASE", "insertMood invokedManager");
 }



 public List<Mood> readForAWeek(){
      List<Mood> moods = new ArrayList<>();
      String strSql = "select * from Comment_Table order by comment desc limit 8";
     Cursor cursor = this.getReadableDatabase().rawQuery(strSql, null);
     cursor.moveToFirst();
     while (!cursor.isAfterLast()){
         Mood mood = new Mood(cursor.getInt(0), cursor.getString(1),
                 cursor.getString(2),new Date(cursor.getInt(3)));
         moods.add(mood);
         cursor.moveToNext();
     }
     cursor.close();
     return moods;
  }

}
