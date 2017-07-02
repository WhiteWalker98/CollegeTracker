package com.vjti.collegetracker;

import android.content.Context;
import android.content.Intent;
import android.app.FragmentManager;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.Calendar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Date;


public class GetSubjectActivity extends AppCompatActivity implements TimePickerFragment.OnCompleteListener {
    boolean flag;
    Button mSaveButton;
    Button button2;
    Button button3;
    Button mAddButton;
    LinearLayout mLinearLayout;
    private final String DIALOG_DATE = "DialogDate";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_subject);

        mLinearLayout=(LinearLayout)findViewById(R.id.lectures_linear_layout);

        final Context context= getApplicationContext();
        mAddButton = (Button)findViewById(R.id.add_lecture_button);
        mAddButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText editText1= new EditText(context);
                button2 = new Button(context);
                button3 = new Button(context);
                Button mButton = new Button(context);
                final LinearLayout Horizontal_layout = new LinearLayout(context);


                editText1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                button2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                button3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                Horizontal_layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
                Horizontal_layout.setOrientation(LinearLayout.HORIZONTAL);
                mButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                mButton.setText("-");

                editText1.setHint(R.string.lecture_day);
                button2.setText(Calendar.HOUR_OF_DAY + ":" + java.util.Calendar.MINUTE);
                button3.setText(R.string.end_time);

                mLinearLayout.addView(Horizontal_layout);
                Horizontal_layout.addView(editText1);
                Horizontal_layout.addView(button2);
                Horizontal_layout.addView(button3);
                Horizontal_layout.addView(mButton);

                mButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mLinearLayout.removeView(Horizontal_layout);
                    }
                });

                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        flag = true;
                        FragmentManager fragmentManager = getFragmentManager();
                        TimePickerFragment dialog = new TimePickerFragment();
                        dialog.show(fragmentManager, DIALOG_DATE);

                    }
                });

                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        flag = false;
                        FragmentManager fragmentManager = getFragmentManager();
                        TimePickerFragment dialog = new TimePickerFragment();
                        dialog.show(fragmentManager, DIALOG_DATE);
                    }
                });
            }
        });

        mSaveButton=(Button)findViewById(R.id.save_button);
        mSaveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });
    }

    @Override
    public void onComplete(int hourOfDay, int minute) {
        String time = (minute < 10) ? (Integer.toString(hourOfDay) + ":0" + Integer.toString(minute)) : (Integer.toString(hourOfDay) + ":" + Integer.toString(minute));
        if (flag == true)
            button2.setText(time);
        else
            button3.setText(time);
    }
}
