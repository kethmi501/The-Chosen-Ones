package com.example.healthopedia.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBhelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "bmiCalc.db";


    public DBhelper( Context context) { super(context, DATABASE_NAME, null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + UserM.Users.TABLE_NAME + " ( " +
                        UserM.Users._ID+ " INTEGER_PRIMARY_KEY," +
                        UserM.Users.COLUMN_NAME_UNAME+ " TEXT," +
                        UserM.Users.COLUMN_NAME_HEIGHT+ " INTEGER," +
                        UserM.Users.COLUMN_NAME_WEIGHT+ " INTEGER,"+
                        UserM.Users.COLUMN_NAME_ANSWER+ " INTEGER)";

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public Long addInfo(String name, String height, String weight, String bmi){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserM.Users.COLUMN_NAME_UNAME, name);
        values.put(UserM.Users.COLUMN_NAME_HEIGHT, height);
        values.put(UserM.Users.COLUMN_NAME_WEIGHT, weight);
        values.put(UserM.Users.COLUMN_NAME_ANSWER, bmi);

        return  db.insert(UserM.Users.TABLE_NAME, null, values);
    }


    public List readAll(){
        SQLiteDatabase db = getReadableDatabase();
        String [] projection = {
                UserM.Users._ID,
                UserM.Users.COLUMN_NAME_UNAME,
                UserM.Users.COLUMN_NAME_HEIGHT,
                UserM.Users.COLUMN_NAME_WEIGHT,
                UserM.Users.COLUMN_NAME_ANSWER
        };

        String sortOrder = UserM.Users._ID + " DESC";

        Cursor cursor = db.query(
                UserM.Users.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder

        );

        List info = new ArrayList<>();

        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndexOrThrow(UserM.Users.COLUMN_NAME_UNAME));
            String height = cursor.getString(cursor.getColumnIndexOrThrow(UserM.Users.COLUMN_NAME_HEIGHT));
            String weight = cursor.getString(cursor.getColumnIndexOrThrow(UserM.Users.COLUMN_NAME_WEIGHT));
            String bmi = cursor.getString(cursor.getColumnIndexOrThrow(UserM.Users.COLUMN_NAME_ANSWER));

            //info.add(name+": "+height+"cm: "+weight+"kg: "+bmi);
            info.add(name+" : \n"+height+"cm \n"+weight+"kg \n"+bmi+"\n");
        }
        cursor.close();
        return info;
    }

    //delete method
    public void deleteInfo(String height){
        SQLiteDatabase db = getReadableDatabase();

        String selections = UserM.Users.COLUMN_NAME_UNAME + " LIKE ?";
        String[] stringargs = {height};

        db.delete(UserM.Users.TABLE_NAME,selections,stringargs);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


