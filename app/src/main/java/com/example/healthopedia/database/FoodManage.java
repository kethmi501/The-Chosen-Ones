package com.example.healthopedia.database;

import android.provider.BaseColumns;

public class FoodManage {
    public FoodManage() {
    }

    public static class Food implements BaseColumns{
        public static final String TABLE_NAME = "food";
        public static final String COLUMN_NAME_FOODNAME = "name";
        public static final String COLUMN_NAME_SIZE = "size";
        public static final String COLUMN_NAME_CALORY = "calory";
    }
}
