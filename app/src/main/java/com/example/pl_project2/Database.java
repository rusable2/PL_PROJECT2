package com.example.pl_project2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;


public class Database extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "accounts_.db";
    private static final String TABLE_NAME = "accounts_";
    private static final String COLUMN_1 = "username";
    private static final String COLUMN_2 = "password";
    private static final String COLUMN_3 = "image";

    public Database(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String s = "create table "+ TABLE_NAME +"(" + COLUMN_1 + " varchar2 primary key, " + COLUMN_2 + " varchar2, " + COLUMN_3 + " blob " + " )";
        db.execSQL(s);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }
    public boolean InsertData(String name, String name2)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(COLUMN_1,name);
        c.put(COLUMN_2,name2);
        long res = db.insert(TABLE_NAME, null, c);
        db.close();
        if(res == -1)
            return false;
        else
            return true;
    }
    public boolean InsertData2(String name, String name2, Bitmap b)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] arr = baos.toByteArray();
        c.put(COLUMN_1,name);
        c.put(COLUMN_2,name2);
        c.put(COLUMN_3, arr);
        long res = db.insert(TABLE_NAME, null, c);
        db.close();
        if(res == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor r = db.rawQuery("select * from " + TABLE_NAME, null);
        return r;
    }
    public int deleteData(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"username = ?", new String[] {id});
    }
    public boolean checkLogin(String s1, String s2)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String [] username = {COLUMN_1};
        String [] selection = {s1, s2};
        String check = COLUMN_1 + " = ? " + " AND " + COLUMN_2 + " = ?";
        Cursor c = db.query(TABLE_NAME, username, check, selection, null, null, null);
        int cCount = c.getCount();
        c.close();
        db.close();
        if(cCount>0)
            return true;
        else
            return false;
    }
    public boolean checkUser(String s1)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String [] select = {s1};
        String [] username = {COLUMN_1};
        String check = COLUMN_1 + " = ? ";
        Cursor c = db.query(TABLE_NAME, username, check, select, null, null, null);
        int cCount = c.getCount();
        c.close();
        db.close();
        if(cCount>0)
            return false;
        else
            return true;
    }
}

