package com.example.loginapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.jar.Attributes;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String Dbname = "users.db";
    private static final int Dbversion = 1;
    private static final String TableName= "Registration";
    private static final String ColumnName= "Username";
    private static final String ColumnEmail= "Email";
    private static final String ColumnPassword= "Password";
    public DatabaseHelper(Context context) {
        super(context, Dbname, null, Dbversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String createtable ="CREATE TABLE " + TableName + "(" + ColumnName +"," + ColumnEmail +","+ ColumnPassword + ")";
    db.execSQL(createtable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(" DROP TABLE IF EXISTS " + TableName);
    onCreate(db);
    }
    public boolean Insertuser(String Username, String email, String password){
      SQLiteDatabase db= this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(ColumnName, Username);
        content.put(ColumnEmail, email);
        content.put(ColumnPassword, password);
        long result = db.insert(TableName, null, content);
        return result != -1;
    }
}
