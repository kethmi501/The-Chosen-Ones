package com.example.healthopedia.database;

import android.provider.BaseColumns;

public  final class UserM {
    private UserM(){}

    public static class Users implements BaseColumns {
        public static final String TABLE_NAME = "bmi";
        public static final String COLUMN_NAME_UNAME = "name";
        public static final String COLUMN_NAME_HEIGHT = "height";
        public static final String COLUMN_NAME_WEIGHT = "weight";
        public static final String COLUMN_NAME_ANSWER = "bmi";

    }
}
