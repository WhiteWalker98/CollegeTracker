package com.vjti.collegetracker;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

<<<<<<< HEAD
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
=======
        database.execSQL("create table " + TimeTable.NAME + " ( " +
                "_id integer primary key autoincrement, " +
                TimeTable.Cols.UUID + ", " +
                TimeTable.Cols.Course_name + ", " +
                TimeTable.Cols.Course_credits + ", " +
                TimeTable.Cols.Course_professor + ", " +
                TimeTable.Cols.Lecture_day + ", " +
                TimeTable.Cols.Lecture_time + ", " +
                TimeTable.Cols.Lecture_end + ", " +
                " unique ( " +
                TimeTable.Cols.UUID + ", " +
>>>>>>> ebddcfafde4a8233ef4e907aa347f7cc4de1654b
                TimeTable.Cols.Course_name + ", " +
                TimeTable.Cols.Lecture_day + ", " +
                TimeTable.Cols.Lecture_time + ", " +
                TimeTable.Cols.Lecture_end +
                " ) on conflict replace " +
<<<<<<< HEAD
                        ");"
=======
                ");"
>>>>>>> ebddcfafde4a8233ef4e907aa347f7cc4de1654b
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){

    }
}
