package com.vjti.collegetracker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by sanidhya on 27-06-2017.
 * stores details of a lecture
 * <p>
 * TIME IS STORED AS NUMBER OF MINUTES PAST MIDNIGHT
 */

class Course {

    private String courseName;
    private String courseProfessor;
    private float courseCredits;
    private List<Lecture> courseLectures = new ArrayList<>();

    public void setLecture(Course l) {
        courseName = l.courseName;
        courseProfessor = l.courseProfessor;
        courseCredits = l.courseCredits;
    }


    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseProfessor() {
        return courseProfessor;
    }

    public void setCourseProfessor(String courseProfessor) {
        this.courseProfessor = courseProfessor;
    }

    public float getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(float courseCredits) {
        this.courseCredits = courseCredits;
    }

    public List<Lecture> getCourseLectures() {
        return courseLectures;
    }

    public void setCourseLectures(List<Lecture> courseLectures) {
        this.courseLectures = courseLectures;
    }

    public void addLectureToCourse(int index, Lecture lecture) {
        this.courseLectures.add(index, lecture);
    }

}

