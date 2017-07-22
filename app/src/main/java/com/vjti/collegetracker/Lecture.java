package com.vjti.collegetracker;

import java.util.UUID;

/**
 * Created by sanid on 05-07-2017.
 */

public class Lecture {

    private UUID LectureUUID;
    private String LectureDay;
    private int LectureStart;
    private int LectureEnd;
    private boolean isRemoved;

    public Lecture() {
        this(UUID.randomUUID());
//        LectureDay = "Monday";
//        LectureStart=0;
//        LectureEnd=0;
//        isRemoved=false;
    }

    public Lecture(UUID uuid) {
        LectureUUID = uuid;
        isRemoved = false;
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
