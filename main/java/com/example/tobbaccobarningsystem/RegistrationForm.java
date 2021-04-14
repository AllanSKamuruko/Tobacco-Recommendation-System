package com.example.tobbaccobarningsystem;

import android.provider.BaseColumns;

public class RegistrationForm {

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private RegistrationForm() {}

    /* Inner class that defines the table contents */
    public static class RegEntry implements BaseColumns {
        public static final String TABLE_NAME = "registration";
        public static final String COLUMN_NAME1 = "fullName";
        public static final String COLUMN_NAME2 = "username";
        public static final String COLUMN_NAME3 = "password";
        public static final String COLUMN_NAME4 = "phoneNumber";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + RegEntry.TABLE_NAME + " (" +
                        RegEntry._ID + " INTEGER PRIMARY KEY," +
                        RegEntry.COLUMN_NAME1 + " TEXT," +
                        RegEntry.COLUMN_NAME2 + " TEXT," +
                        RegEntry.COLUMN_NAME3 + " TEXT," +
                        RegEntry.COLUMN_NAME4 + " TEXT)";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + RegEntry.TABLE_NAME;
    }
}
