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

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Mood.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATA_TABLE = "Comment_Table";

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


    public void insertComment(String comment, MoodEnum moodEnum, int daysAgo) {
        comment = comment.replace("'", "''");

        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.COMMENT, comment);
        contentValues.put(Columns.MOOD, moodEnum.name());
        contentValues.put(Columns.DATE, new Date().getTime());
        // contentValues.put(Columns.DATE,  Calendar.getInstance().get(Calendar.YEAR)
        //        + Calendar.getInstance().get(Calendar.MONTH)
        //        + Calendar.getInstance().get(Calendar.DAY_OF_WEEK));

        this.getWritableDatabase().insert(DATA_TABLE, null, contentValues);
        Log.i("DATABASE", "insertComment invokedManager");
    }

    // list de mes moods enregistrés
    public List<Mood> readForAWeek() {
        List<Mood> moods = new ArrayList<>();
        String selectMood = "SELECT * FROM " +
                DATA_TABLE + " " +
                "WHERE" + Columns.DATE +
                " BETWEEN DATE('NOW','LOCALTIME','START OF DAY','-7 DAY')" +
                "AND DATE('NOW', 'LOCALTITME', 'START OF DAY', '-1DAY')";
        Cursor cursor = getReadableDatabase().rawQuery(selectMood, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Mood mood = new Mood(cursor.getColumnIndex(Columns.COMMENT),
                    cursor.getColumnIndex(Columns.MOOD),
                    cursor.getColumnIndex(Columns.DATE));

            moods.add(mood);
            cursor.moveToNext();
        }
        return moods;
    }
    public Mood getCurrentMood(){
        Cursor cursor = getReadableDatabase().query(DATA_TABLE,
                new String[]{Columns.MOOD, Columns.COMMENT, Columns.DATE},
                Columns.DATE + "LIKE DATE('NOW', 'LOCALTIME, 'START OF DAY)",
                null,null,null,null);
        return  cursorToMood(cursor);
    }
    private Mood cursorToMood(Cursor cursor){
        if(cursor.getCount() == 0)
            return null;
        cursor.moveToFirst();
        Mood currentMood = new Mood();
        currentMood.setMood(cursor.getColumnIndex(Columns.MOOD));
        currentMood.setComment(cursor.getColumnIndex(Columns.COMMENT));
        currentMood.setColor(cursor.getColumnIndex());
        currentMood.setWhen(cursor.getColumnIndex(Columns.DATE));
        cursor.close();
        return currentMood;

    }

    //To check before current day
    public int isHistoryExist() {
        int count = 0;
        String selectCount = "SELECT COUNT * FROM" + DATA_TABLE +
                "WHERE" + Columns.DATE +
                " < DATE('NOW','LOCALTIME','START OF DAY')";
        Cursor c = getReadableDatabase().rawQuery(selectCount, null);
        if (c.getCount() > 0) {
            c.moveToFirst();
            count = c.getInt(0);
        }
        c.close();
        return count;
    }


}
