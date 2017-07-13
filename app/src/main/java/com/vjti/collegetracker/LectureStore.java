package com.vjti.collegetracker;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vjti.collegetracker.TableDBSchema.TimeTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanidhya on 02-07-2017.
 * Handles objects of com.vjti.collegetracker.Lecture class
 */

public class LectureStore {

    private static final String DBKEY = "LECTURES";
    private SQLiteDatabase Database;
    private Context mContext;

    public LectureStore(Context context) {
        mContext = context.getApplicationContext();
        Database = new TimetableBaseHelper(mContext)
                .getWritableDatabase();
    }

    private static ContentValues getContentValues(Course course, Lecture lecture) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBKEY, lecture.getLectureUUID().toString());
        contentValues.put(DBKEY, course.getCourseName());
        contentValues.put(DBKEY, course.getCourseCredits());
        contentValues.put(DBKEY, course.getCourseProfessor());
        contentValues.put(DBKEY, lecture.getLectureDay());
        contentValues.put(DBKEY, lecture.getLectureStart());
        contentValues.put(DBKEY, lecture.getLectureEnd());
        return contentValues;
    }

    public void addLecture(Course course, Lecture lecture) {
        ContentValues values = getContentValues(course, lecture);
        Database.insert(TimeTable.NAME, null, values);
    }

    public void updateLecture(Course course, Lecture lecture) {
        String uuidString = lecture.getLectureUUID().toString();
        ContentValues values = getContentValues(course, lecture);
        Database.update(TimeTable.NAME, values,
                TimeTable.Cols.UUID + "= ?",
                new String[]{uuidString});
    }

    public List<String> extractCourse() {
        List<String> CourseNames = new ArrayList<>();
        //  Cursor cursor = Database.query(TimeTable.NAME, TimeTable.Cols.Course_name, )
        return CourseNames;
    }
}
