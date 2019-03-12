package com.example.www.dazonghe.sql;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelp extends SQLiteOpenHelper {

    public SQLHelp(Context context) {
        super(context, "bw.db", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("create table person(id integer primary key autoincrement,title text)");
        db.execSQL("CREATE TABLE person(id INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
