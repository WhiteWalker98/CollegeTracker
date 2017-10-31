package com.vjti.collegetracker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class CreateTimetable extends AppCompatActivity {

    private Button AddSubjectButton;
    private LectureStore lectureStore;
    private LinearLayout mCourseLinearLayout;
    private List<Course> courseList;
    String TAG = "LOG_TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportActionBar()!= null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_create_timetable);
        Context context = getApplicationContext();
        mCourseLinearLayout = (LinearLayout) findViewById(R.id.Courses_container);

        LectureStore lectureStore = new LectureStore(getApplicationContext());
        courseList = lectureStore.getAllCourses();
        Log.i(TAG, "Size of courseList = " + courseList.size());
        for (Course course : courseList) {
            TextView textView = new TextView(context);
            Log.d(TAG, "Inside course printer " + course.getCourseName());
            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            textView.setText(course.getCourseName());
            textView.setGravity(Gravity.CENTER);
            mCourseLinearLayout.addView(textView);
        }

        AddSubjectButton=(Button)findViewById(R.id.add_subject_button);
        AddSubjectButton.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){
               Log.i(TAG,"inside OnClick of CreateTimetable activity");
               startActivity(new Intent(CreateTimetable.this,GetSubjectActivity.class));
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCourseLinearLayout = (LinearLayout) findViewById(R.id.Courses_container);
        mCourseLinearLayout.removeAllViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        mCourseLinearLayout = (LinearLayout) findViewById(R.id.Courses_container);
//
//        LectureStore lectureStore = new LectureStore(getApplicationContext());
//        courseList = lectureStore.getAllCourses();
//        for (Course course : courseList) {
//            TextView textView = new TextView(getApplicationContext());
//            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//            textView.setText(course.getCourseName());
//            textView.setGravity(Gravity.CENTER);
//            mCourseLinearLayout.addView(textView);
//        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
