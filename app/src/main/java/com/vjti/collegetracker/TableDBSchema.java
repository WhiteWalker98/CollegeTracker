package com.vjti.collegetracker;

/**
 * Created by sanidhya on 24/6/17.
 * stores column names
 */

public class TableDBSchema {
    public static final class TimeTable {

        public static final String NAME = "time_table";

        public static final class Cols {

            public static final String UUID = "UUID";
            public static final String Course_name = "Course_Name";
            public static final String Course_credits = "Course_Credits";
            public static final String Course_professor = "Course_professor";
            public static final String Lecture_day = "Lecture_day";
            public static final String Lecture_time = "Lecture_start";
            public static final String Lecture_end = "Lecture_end";

        }
    }
}