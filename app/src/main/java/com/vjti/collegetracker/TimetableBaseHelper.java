package com.vjti.collegetracker;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import com.vjti.collegetracker.TableDBSchema.TimeTable;

import java.sql.Time;

/**
 * Created by Sanidhya on 24/6/17.
 * The Helper Class
 */

public class TimetableBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION=1;
    private static final String DATABASE_NAME="TimetableBase.db";


    public TimetableBaseHelper(Context context){

        super(context,DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

//        database.execSQL("CREATE TABLE " + TimeTable.NAME + " ( " +
//                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                TimeTable.Cols.UUID + ", " +
//                TimeTable.Cols.Course_name + ", " +
//                TimeTable.Cols.Course_credits + ", " +
//                TimeTable.Cols.Course_professor + ", " +
//                TimeTable.Cols.Lecture_day + ", " +
//                TimeTable.Cols.Lecture_time + ", " +
//                TimeTable.Cols.Lecture_end +
//                ");"
//        );
        database.execSQL("CREATE TABLE "+ TimeTable.NAME + "( "+
                        "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TimeTable.Cols.UUID + " TEXT, " +
                TimeTable.Cols.Course_name + " TEXT, "+
                TimeTable.Cols.Course_credits + " DECIMAL, "+
                TimeTable.Cols.Course_professor + " TEXT, "+
                TimeTable.Cols.Lecture_day + " TEXT, "+
                TimeTable.Cols.Lecture_time + " INTEGER, "+
                TimeTable.Cols.Lecture_end + " INTEGER, " +
                " unique ( " +
                TimeTable.Cols.Course_name + ", " +
                TimeTable.Cols.Lecture_day + ", " +
                TimeTable.Cols.Lecture_time + ", " +
                TimeTable.Cols.Lecture_end +
                " ) on conflict replace " +
                        ");"
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){

    }
}