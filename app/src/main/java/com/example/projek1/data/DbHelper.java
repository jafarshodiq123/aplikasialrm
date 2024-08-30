package com.example.projek1.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    //membuat database dan tabel
    public Context context;
    public static final String DATABASENAME = "projekone";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_USER = "CREATE TABLE user (id INTEGER PRIMARY KEY AUTOINCREMENT , nama TEXT ,email TEXT, password TEXT)";
    public static final String TABLE_TASK = "CREATE TABLE task (id INTEGER PRIMARY KEY AUTOINCREMENT , nama TEXT ,date TEXT, user_id INTEGER," +
        "FOREIGN KEY(user_id) REFERENCES user(id))";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASENAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_USER);
        db.execSQL(TABLE_TASK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion , int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS task");
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }
}
