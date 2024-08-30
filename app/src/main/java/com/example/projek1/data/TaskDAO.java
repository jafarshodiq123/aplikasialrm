package com.example.projek1.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TaskDAO {
    private SQLiteDatabase db;
    //menginpor database
    private  DbHelper dbHelper;

    //membuat contex
    public TaskDAO(Context context){
        dbHelper = new DbHelper(context);
        db= dbHelper.getWritableDatabase();

    }
    //query untuk menambahkan data
    public long addTask(String nama,String date , Long userId){
        ContentValues values = new ContentValues();
        values.put("nama", nama);
        values.put("date",date);
        values.put("user_id",userId);
        return db.insert("task",null,values);
    }

    public Cursor getTask(long userId){
        String selection = "user_id=?";
        String[] selectionArg = {String.valueOf(userId)};
        return db.query("task",null,selection,selectionArg,null,null,null);
    }

    public int updateTask (long id ,String nama , String date){
         ContentValues values = new ContentValues();
         values.put("nama", nama);
         values.put("date",date);
         return db.update("task",values,"id=?",new String[]{String.valueOf(id)});
    }

    public void deletetask(long id){
        db.delete("task","id=?",new String[]{String.valueOf(id)});

    }



}
