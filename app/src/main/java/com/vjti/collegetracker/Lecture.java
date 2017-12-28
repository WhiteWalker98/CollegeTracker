package com.vjti.collegetracker;

import java.util.UUID;

/**
 * Created by sanid on 05-07-2017.
 */

public class Lecture {

    private UUID LectureUUID;
    private String courseName;
    private String courseProfessor;
    private float courseCredits;
    private String LectureDay;
    private int LectureStart;
    private int LectureEnd;
    private boolean isRemoved;

    public Lecture() {
        this(UUID.randomUUID());
    }

    public Lecture(UUID uuid) {
        LectureUUID = uuid;
        isRemoved = false;
    }
    public String getCourseName() {
        return courseName;
    }

    public String getCourseProfessor() {
        return courseProfessor;
    }

    public float getCourseCredits() {
        return courseCredits;
    }
    public UUID getLectureUUID() {
        return LectureUUID;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setRemoved(boolean removed) {
        isRemoved = removed;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseProfessor(String courseProfessor) {
        this.courseProfessor = courseProfessor;
    }

    public void setCourseCredits(float courseCredits) {
        this.courseCredits = courseCredits;
    }

    public String getLectureDay() {
        return LectureDay;
    }

    public void setLectureDay(String lectureDay) {
        LectureDay = lectureDay;
    }

    public int getLectureStart() {
        return LectureStart;
    }

    public void setLectureStart(int lectureStart) {
        LectureStart = lectureStart;
    }

    public int getLectureEnd() {
        return LectureEnd;
    }

    public void setLectureEnd(int lectureEnd) {
        LectureEnd = lectureEnd;
    }
}
