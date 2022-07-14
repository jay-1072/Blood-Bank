package com.exampletest.project_blood_bank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperRegistration extends SQLiteOpenHelper {
    public static final String DBNAME = "Blood_Bank_Login.db";
    public DBHelperRegistration(@Nullable Context context) {
        super(context, "Blood_Bank_Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table userRegister(firstname TEXT,lastname TEXT, email TEXT primary key, password TEXT, state TEXT, district TEXT, village TEXT, mobile TEXT, bloodgroup TEXT, message TEXT)");
        MyDB.execSQL("create Table userMakeRequest(name TEXT, email TEXT primary key, mobile TEXT, address TEXT, pincode TEXT, bloodgroup TEXT, message TEXT )");
        MyDB.execSQL("create Table donorRequest(name TEXT, email TEXT primary key, mobile TEXT, address TEXT, pincode TEXT, bloodgroup TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists userRegister");
        MyDB.execSQL("drop Table if exists userMakeRequest");
        MyDB.execSQL("drop Table if exists donorRequest");
    }

    public Boolean insertData1(String firstname, String lastname, String email, String password,
                               String mobile){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("firstname", firstname);
        contentValues.put("lastname", lastname);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("mobile", mobile);
        long result = MyDB.insert("userRegister", null, contentValues);
        if(result==-1) return false;
        else
            return true;
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

    public Boolean insertData3(String name, String email, String mobile, String address, String pincode, String bloodgroup) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("mobile", mobile);
        contentValues.put("address", address);
        contentValues.put("pincode", pincode);
        contentValues.put("bloodgroup", bloodgroup);
        long result = MyDB.insert("donorRequest", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkemailpassword(String email, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from userRegister where email = ? and password = ?", new String[] {email,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Cursor getdata1()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from userMakeRequest", null);
        return cursor;
    }

    public Cursor getdata2()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from donorRequest", null);
        return cursor;
    }
}
