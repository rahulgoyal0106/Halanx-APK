package com.example.demo2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "Location";
    public static final String COL_2 = "Tenant";
    public static final String COL_3 = "Type";
    public static final String COL_4 = "Rooms";
    public static final String COL_5 = "Furnished";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    public void insertData () {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("Delete From " + TABLE_NAME);
        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Bangalore\",\"Boy\",\"Private Room\",\"1BHK\",\"Semi Furnished\") ");
        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Bangalore\",\"Girl\",\"Shared Room\",\"2BHK\",\"Full Furnished\") ");
        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Bangalore\",\"Boy\",\"Shared Room\",\"3BHK\",\"Non Furnished\") ");
        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Bangalore\",\"Girl\",\"Private Room\",\"1BHK\",\"Full Furnished\") ");
        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Bangalore\",\"Family\",\"Full House\",\"3BHK\",\"Full Furnished\") ");
        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Bangalore\",\"Family\",\"Full House\",\"3BHK\",\"Full Furnished\") ");
        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Bngalore\",\"Family\",\"Full House\",\"2BHK\",\"Semi Furnished\") ");
        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Bangalore\",\"Girl\",\"Shared Room\",\"1BHK\",\"Full Furnished\") ");

        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Delhi\",\"Boy\",\"Private Room\",\"1BHK\",\"Semi Furnished\") ");
        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Delhi\",\"Girl\",\"Shared Room\",\"2BHK\",\"Full Furnished\") ");
        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Delhi\",\"Boy\",\"Shared Room\",\"3BHK\",\"Non Furnished\") ");
        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Delhi\",\"Girl\",\"Private Room\",\"1BHK\",\"Full Furnished\") ");
        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Delhi\",\"Family\",\"Full House\",\"3BHK\",\"Full Furnished\") ");
        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Delhi\",\"Family\",\"Full House\",\"2BHK\",\"Semi Furnished\") ");
        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Delhi\",\"Girl\",\"Shared Room\",\"1BHK\",\"Full Furnished\") ");

        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Mumbai\",\"Boy\",\"Private Room\",\"1BHK\",\"Semi Furnished\") ");
        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Mumbai\",\"Girl\",\"Shared Room\",\"2BHK\",\"Full Furnished\") ");
        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Mumbai\",\"Boy\",\"Shared Room\",\"3BHK\",\"Non Furnished\") ");
        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Mumbai\",\"Girl\",\"Private Room\",\"1BHK\",\"Full Furnished\") ");
        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Mumbai\",\"Family\",\"Full House\",\"3BHK\",\"Full Furnished\") ");
        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Mumbai\",\"Family\",\"Full House\",\"2BHK\",\"Semi Furnished\") ");
        db.execSQL(" Insert into " + TABLE_NAME + " values(\"Mumbai\",\"Girl\",\"Shared Room\",\"1BHK\",\"Full Furnished\") ");


    }

    public Cursor searchData(String city, String tenant, String house) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res;

        if (tenant.equals("Any"))
            res = db.rawQuery(" Select distinct * from " + TABLE_NAME + " where Location = '" + city + "' and Type = '" + house + "'", null);

        else
            res = db.rawQuery(" Select distinct * from " + TABLE_NAME + " where Location = '" + city + "' and Tenant = '" + tenant + "' and Type = '" + house + "'", null);

            return res;

    }

    public Cursor finalData(String room, String furnish) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res2 = db.rawQuery(" Select distinct * from " + TABLE_NAME + " where Rooms = '"  + room + "'  and Status= '" + furnish + "'" , null);
        return res2;

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(LOCATION TEXT, TENANT TEXT, TYPE TEXT, ROOMS TEXT, STATUS TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

}
