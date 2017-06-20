package com.vjti.collegetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CreateTimetable extends AppCompatActivity {

    private Button AddSubjectButton;
    String TAG="TimeTable";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_timetable);
        AddSubjectButton=(Button)findViewById(R.id.add_subject_button);
        AddSubjectButton.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){
               Log.i(TAG,"inside OnClick of CreateTimetable activity");
               startActivity(new Intent(CreateTimetable.this,GetSubjectActivity.class));
            }
        });
    }
}
