package com.example.healthopedia.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "BMI.db";


    public DBhelper( Context context) { super(context, DATABASE_NAME, null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + UserM.Users.TABLE_NAME + " ( " +
                        UserM.Users._ID+ " INTEGER_PRIMARY_KEY," +
                        UserM.Users.COLUMN_NAME_HEIGHT+ " INTEGER," +
                        UserM.Users.COLUMN_NAME_WEIGHT+ " INTEGER,"+
                        UserM.Users.COLUMN_NAME_ANSWER+ " INTEGER)";

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public Long addInfo(String height, String weight, String bmi){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserM.Users.COLUMN_NAME_HEIGHT, height);
        values.put(UserM.Users.COLUMN_NAME_WEIGHT, weight);
        values.put(UserM.Users.COLUMN_NAME_ANSWER, bmi);

        return  db.insert(UserM.Users.TABLE_NAME, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
