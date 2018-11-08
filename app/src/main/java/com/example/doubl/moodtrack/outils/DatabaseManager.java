package com.example.doubl.moodtrack.outils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import com.example.doubl.moodtrack.model.Mood;
import com.example.doubl.moodtrack.model.MoodEnum;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Mood.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATA_TABLE= "Comment_Table";

    private class Columns implements BaseColumns {
        public static final String COMMENT = "COMMENT";
        public static final String MOOD = "MOOD";
        public static final String DATE = "DATE";

    }

    /**
     * constructor
     *
     * @param context
     */
    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * if db change
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE Comment_Table("
                + Columns.DATE + " DATE PRIMARY KEY  ,"
                + Columns.COMMENT + " TEXT,"
                + Columns.MOOD + " TEXT NOT NULL "
                + ")";
        db.execSQL(create);
        Log.i("DATABASE", "onCreate invoked");
    }

    /**
     * if version change
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String strSql = "DROP TABLE Comment_Table";
        db.execSQL(strSql);
        this.onCreate(db);
        Log.i("DATABASE", "onUpgrade invoked");
    }


    public  void insertComment(String comment, MoodEnum moodEnum) {
        comment = comment.replace("'", "''");

        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.COMMENT, comment);
        contentValues.put(Columns.MOOD, moodEnum.name());
        contentValues.put(Columns.DATE, new Date().getTime());
       // contentValues.put(Columns.DATE,  Calendar.getInstance().get(Calendar.YEAR)
       //        + Calendar.getInstance().get(Calendar.MONTH)
       //        + Calendar.getInstance().get(Calendar.DAY_OF_WEEK));

        this.getWritableDatabase().insert(DATA_TABLE, null,contentValues );
        Log.i("DATABASE", "insertComment invokedManager");
    }

    public List<Mood> readForAWeek() {
        List<Mood> moods = new ArrayList<>();

       // String strSql = "select * from Comment_Table order by date limit 8";
        Cursor cursor = this.getReadableDatabase().query(DATA_TABLE,new String[]{"COMMENT", "MOOD", "DATE"}, null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Mood mood = new Mood(cursor.getInt(0), cursor.getString(1),
                    cursor.getString(2), new Date(cursor.getInt(3)));
            moods.add(mood);
            cursor.moveToNext();
        }
        cursor.close();
        return moods;
    }


}
