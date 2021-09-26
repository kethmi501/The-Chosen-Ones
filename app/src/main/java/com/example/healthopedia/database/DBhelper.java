package com.example.healthopedia.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "food.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + FoodManage.Food.TABLE_NAME + " (" +
                        FoodManage.Food._ID + " INTEGER PRIMARY KEY," +
                        FoodManage.Food.COLUMN_NAME_FOODNAME + " TEXT,"+
                        FoodManage.Food.COLUMN_NAME_SIZE + " TEXT,"+
                        FoodManage.Food.COLUMN_NAME_CALORY + " TEXT)";

        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);

    }
    public long addFood(String foodName, String size, String calory){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FoodManage.Food.COLUMN_NAME_FOODNAME,foodName);
        values.put(FoodManage.Food.COLUMN_NAME_SIZE,size);
        values.put(FoodManage.Food.COLUMN_NAME_CALORY,calory);

        return db.insert(FoodManage.Food.TABLE_NAME,null,values);
    }

    public List readAllFoods(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection ={
                FoodManage.Food._ID,
                FoodManage.Food.COLUMN_NAME_FOODNAME,
                FoodManage.Food.COLUMN_NAME_SIZE,
                FoodManage.Food.COLUMN_NAME_CALORY
        };
        Cursor cursor = db.query(
                FoodManage.Food.TABLE_NAME,
                projection,null,null,null,null,null
        );
        List info = new ArrayList<>();
        while (cursor.moveToNext()){
            String foodName = cursor.getString(cursor.getColumnIndexOrThrow(FoodManage.Food.COLUMN_NAME_FOODNAME));
            String size = cursor.getString(cursor.getColumnIndexOrThrow(FoodManage.Food.COLUMN_NAME_SIZE));
            String calory = cursor.getString(cursor.getColumnIndexOrThrow(FoodManage.Food.COLUMN_NAME_CALORY));
            info.add("Name : "+foodName+"\nSize : "+size+"\nCalory : "+calory+"\n\n");
        }
        cursor.close();
        return info;
    }

    public void deleteFood(String foodName){
        SQLiteDatabase db = getReadableDatabase();
        String selection = FoodManage.Food.COLUMN_NAME_FOODNAME + " LIKE ?";
        String[] stringArgs = {foodName};

        db.delete(FoodManage.Food.TABLE_NAME,selection,stringArgs);
    }

    public void updateInfo(View view, String foodName, String size, String calory){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FoodManage.Food.COLUMN_NAME_SIZE,size);
        values.put(FoodManage.Food.COLUMN_NAME_CALORY,calory);

        String selection = FoodManage.Food.COLUMN_NAME_FOODNAME + " LIKE ?";
        String[] selectionArgs = {foodName};

        int count = db.update(
                FoodManage.Food.TABLE_NAME,values,selection,selectionArgs
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
