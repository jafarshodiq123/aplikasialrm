package com.example.projek1.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDAO {

    private SQLiteDatabase db;
    private DbHelper dbHelper;


    public UserDAO(Context context){
        dbHelper = new DbHelper(context);
        db=dbHelper.getWritableDatabase();

    }
    public long addUser(String nama , String email , String password){

        ContentValues values = new ContentValues();
        values.put("nama",nama);
        values.put("email",email);
        values.put("password",password);
        return db.insert("user",null, values);
    }

    //untuk mengecek pasword dan email
    public Cursor getUser (String email ,String password){
        String selection ="email=? AND password=?";
        String []selectionArgs = {email,password};
        return db.query("user",null,selection,selectionArgs,null,null,null);
    }
}
