package com.vjti.collegetracker;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.vjti.collegetracker.TableDBSchema.TimeTable;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by sanidhya on 19-07-2017.
 */

public class LectureCursorWrapper extends CursorWrapper {
    public LectureCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Lecture getLecture() {
        String uuidString = getString(getColumnIndex(TimeTable.Cols.UUID));
        String lecture_day = getString(getColumnIndex(TimeTable.Cols.Lecture_day));
        int lecture_start = getInt(getColumnIndex(TimeTable.Cols.Lecture_time));
        int lecture_end = getInt(getColumnIndex(TimeTable.Cols.Lecture_end));
        String course_name = getString(getColumnIndex(TimeTable.Cols.Course_name));
        float course_credits = getFloat(getColumnIndex(TimeTable.Cols.Course_credits));
        String course_professor = getString(getColumnIndex(TimeTable.Cols.Course_professor));

        Lecture lecture = new Lecture(UUID.fromString(uuidString));
        lecture.setLectureDay(lecture_day);
        lecture.setLectureStart(lecture_start);
        lecture.setLectureEnd(lecture_end);
        lecture.setCourseName(course_name);
        lecture.setCourseCredits(course_credits);
        lecture.setCourseProfessor(course_professor);
        return lecture;
    }

//    public Course wrapCourse() {
//
//
//        Course course = new Course();
//
//        course.setCourseLectures(new ArrayList<Lecture>());
//        return course;
//    }
}
