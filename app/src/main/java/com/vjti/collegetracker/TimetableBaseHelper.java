package com.vjti.collegetracker;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sanidhya on 24/6/17.
 */

public class TimetableBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION=1;
    private static final String DATABASE_NAME="TimetableBase.db";


    public TimetableBaseHelper(Context context){
        super(context,DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        database.execSQL("create table "+ TableDBSchema.TimeTable.NAME + "("
            +"_id integer primary key auto increment");
    }
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){


    }
}
