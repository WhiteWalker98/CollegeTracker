package com.vjti.collegetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateTimetable extends AppCompatActivity {

    private Button AddSubjectButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_timetable);
        AddSubjectButton=(Button)findViewById(R.id.add_subject_button);
        AddSubjectButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(){
//
//            }
        });

        };
    }
}
