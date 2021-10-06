package com.example.healthopedia.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class FoodDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "foodInfo.db";

    public FoodDBHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + FoodManage.Food.TABLE_NAME + " (" +
                        FoodManage.Food._ID+ " INTEGER PRIMARY KEY," +
                        FoodManage.Food.COLUMN_NAME_FOODNAME+ " TEXT,"+
                        FoodManage.Food.COLUMN_NAME_SIZE+ " INTEGER," +
                        FoodManage.Food.COLUMN_NAME_TYPE+ " TEXT," +
                        FoodManage.Food.COLUMN_NAME_DATE+ " TEXT)";

        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }
    public long addFood(String foodName, String size, String type, String date){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FoodManage.Food.COLUMN_NAME_FOODNAME,foodName);
        values.put(FoodManage.Food.COLUMN_NAME_SIZE,size);
        values.put(FoodManage.Food.COLUMN_NAME_TYPE,type);
        values.put(FoodManage.Food.COLUMN_NAME_DATE,date);

        return db.insert(FoodManage.Food.TABLE_NAME,null,values);
    }
    public List readAllFoods(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection ={
                FoodManage.Food._ID,
                FoodManage.Food.COLUMN_NAME_FOODNAME,
                FoodManage.Food.COLUMN_NAME_SIZE,
                FoodManage.Food.COLUMN_NAME_TYPE,
                FoodManage.Food.COLUMN_NAME_DATE
        };
        String sortOrder =  FoodManage.Food._ID + " DESC";
        Cursor cursor = db.query(
                FoodManage.Food.TABLE_NAME,
                projection,null,null,null,null,sortOrder
        );
        List info = new ArrayList<>();
        while (cursor.moveToNext()){
            String foodName = cursor.getString(cursor.getColumnIndexOrThrow(FoodManage.Food.COLUMN_NAME_FOODNAME));
            String size = cursor.getString(cursor.getColumnIndexOrThrow(FoodManage.Food.COLUMN_NAME_SIZE));
            String type = cursor.getString(cursor.getColumnIndexOrThrow(FoodManage.Food.COLUMN_NAME_TYPE));
            String date = cursor.getString(cursor.getColumnIndexOrThrow(FoodManage.Food.COLUMN_NAME_DATE));

            info.add(foodName+":\n"+size+" Cup size :\n"+type+" :\n"+date+":\n\n");
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

    public void updateInfo(View view, String foodName, String size, String type, String date){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FoodManage.Food.COLUMN_NAME_SIZE,size);
        values.put(FoodManage.Food.COLUMN_NAME_TYPE,type);
        values.put(FoodManage.Food.COLUMN_NAME_DATE,date);

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
