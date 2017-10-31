package com.vjti.collegetracker;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.vjti.collegetracker.TableDBSchema.TimeTable;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanidhya on 02-07-2017.
 * Handles objects of com.vjti.collegetracker.Lecture class
 */

public class LectureStore {

    private String TAG = "LOG_TAG";
    private static final String DBKEY = "LECTURES";
    private SQLiteDatabase Database;

    public LectureStore(Context context) {
        Database = new TimetableBaseHelper(context)
                .getWritableDatabase();
    }

    private static ContentValues getContentValues(Course course, Lecture lecture) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TimeTable.Cols.UUID, lecture.getLectureUUID().toString());
        contentValues.put(TimeTable.Cols.Course_name, course.getCourseName());
        contentValues.put(TimeTable.Cols.Course_credits, course.getCourseCredits());
        contentValues.put(TimeTable.Cols.Course_professor, course.getCourseProfessor());
        contentValues.put(TimeTable.Cols.Lecture_day, lecture.getLectureDay());
        contentValues.put(TimeTable.Cols.Lecture_time, lecture.getLectureStart());
        contentValues.put(TimeTable.Cols.Lecture_end, lecture.getLectureEnd());
        return contentValues;
    }

    public void addLecture(Course course, Lecture lecture) {
        ContentValues values = getContentValues(course, lecture);
        Database.insert(TimeTable.NAME, null, values);
    }

    public void removeCourse(Course course) {
        Database.delete(TimeTable.NAME, TimeTable.Cols.Course_name + " = ?",
                new String[]{course.getCourseName()});
    }

    public void removeLecture(Lecture lecture) {
        Database.delete(TimeTable.NAME, TimeTable.Cols.UUID + " = ?",
                new String[]{lecture.getLectureUUID().toString()});
    }

    public void updateLecture(Course course, Lecture lecture) {
        String uuidString = lecture.getLectureUUID().toString();
        ContentValues values = getContentValues(course, lecture);
        Database.update(TimeTable.NAME, values,
                TimeTable.Cols.UUID + "= ?",
                new String[]{uuidString});
    }

    private LectureCursorWrapper queryLectures(String whereClause, String[] whereArgs) {
        Cursor cursor = Database.query(TimeTable.NAME, null, whereClause, whereArgs, null, null, TimeTable.Cols.Course_name);
        return new LectureCursorWrapper(cursor);
    }

    private Course getCourse() {
        LectureCursorWrapper cursor = queryLectures(null, null);
        Course course = cursor.wrapCourse();
        try {
            cursor.moveToFirst();
            int i = 0;
            while (!cursor.isAfterLast() && (course.getCourseName()).equals(cursor.wrapCourse().getCourseName())) {
                course.addLectureToCourse(i++, cursor.getLecture());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return course;
    }

    public List<Course> getAllCourses() {

        List<Course> courseList = new ArrayList<>();
        LectureCursorWrapper cursor = queryLectures(null, null);
        int i = 0;
        try {
            int j = 0;
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                courseList.add(cursor.wrapCourse());
                Course course = courseList.get(i);
                while (course.getCourseName().equals(cursor.wrapCourse().getCourseName()) && !cursor.isAfterLast()) {
                    course.addLectureToCourse(j++, cursor.getLecture());
                    cursor.moveToNext();
                }
                i++;
            }
        } finally {
//            Log.i(TAG, "value of getInt(0)= " + cursor.getInt(0));
            cursor.close();
        }
        return courseList;
    }
}
