package com.exampletest.project_blood_bank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
/*
public class DBHelperMakeRequest extends SQLiteOpenHelper {
    public static final String DBNAME = "Blood_Bank_Login.db";
    public DBHelperMakeRequest(@Nullable Context context) {
        super(context, "Blood_Bank_Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table userMakeRequest(name TEXT," +
                "email TEXT primary key, mobile TEXT, address TEXT, " +
                "pincode TEXT, bloodgroup TEXT, message TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists userMakeRequest");
    }

    public Boolean insertData2(String name, String email, String mobile, String address, String pincode,
                               String bloodgroup, String message) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("mobile", mobile);
        contentValues.put("address", address);
        contentValues.put("pincode", pincode);
        contentValues.put("bloodgroup", bloodgroup);
        contentValues.put("message", message);
        long result = MyDB.insert("userMakeRequest", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from userMakeRequset", null);
        return cursor;
    }
}
*/