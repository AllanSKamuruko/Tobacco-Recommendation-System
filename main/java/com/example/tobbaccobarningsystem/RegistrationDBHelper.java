package com.example.tobbaccobarningsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.tobbaccobarningsystem.RegistrationForm.RegEntry.SQL_CREATE_ENTRIES;
import static com.example.tobbaccobarningsystem.RegistrationForm.RegEntry.SQL_DELETE_ENTRIES;

public class  RegistrationDBHelper  extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Tobacco.db";

    public RegistrationDBHelper(Context context) {
        super(context, "Tobacco.db", null, 1);
    }
@Override
    public void onCreate(SQLiteDatabase MyDB){
    MyDB.execSQL("create Table users( username TEXT primary key, password TEXT)");
}
@Override
    public void onUpgrade(SQLiteDatabase  MyDB,int i,int i1){
   MyDB.execSQL("drop Table if exists users");
}
public Boolean insertData(String username,String password) {
    SQLiteDatabase MyDB = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put("username", username);
    contentValues.put("password", password);
    long result = MyDB.insert("users", null, contentValues);
    if (result == -1) {
        return false;
    } else {
        return true;
    }
}
public Boolean checkusername(String username){
   SQLiteDatabase MyDB = this.getWritableDatabase();
    Cursor cursor = MyDB.rawQuery("Select * from users where username= ?",new String[]{username});
    if(cursor.getCount()>0)
        return true;
    else
        return false;
    }
    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username=? and password= ?",new String[]{username,password});
    if(cursor.getCount()>0){
        return true;
    }
    else{
        return false;
    }
    }

}
