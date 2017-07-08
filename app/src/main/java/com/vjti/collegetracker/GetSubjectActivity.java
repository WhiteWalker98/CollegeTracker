package com.vjti.collegetracker;

import android.content.Context;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class GetSubjectActivity extends AppCompatActivity implements TimePickerFragment.OnCompleteListener {
    boolean flag;
    String TAG = "LOG_TAG";
    EditText mCourseName;
    EditText mCourseProfessor;
    EditText mCourseCredits;
    Button mSaveButton;
    Button button2;
    Button button3;
    Button mAddButton;
    LinearLayout mLinearLayout;
    Course course = new Course();
    List<Lecture> lectureList = new ArrayList<>();
    Lecture lecture = new Lecture();
    View view;

    int plus_counter = 0;

    private final String DIALOG_DATE = "DialogDate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_subject);
        final Context context= getApplicationContext();
        mLinearLayout = (LinearLayout) findViewById(R.id.lectures_linear_layout);
        mCourseName = (EditText) findViewById(R.id.course_name_editText);
        mCourseProfessor = (EditText) findViewById(R.id.course_professor_editText);
        mCourseCredits = (EditText) findViewById(R.id.course_credits_editText);
        mAddButton = (Button)findViewById(R.id.add_lecture_button);
        final List<String> WeekList = new ArrayList<>();
        WeekList.add("Monday");
        WeekList.add("Tuesday");
        WeekList.add("Wednesday");
        WeekList.add("Thursday");
        WeekList.add("Friday");
        WeekList.add("Saturday");
        WeekList.add("Sunday");

        mAddButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                // Log.i(TAG, "before lecture list");
                lectureList.add(plus_counter, lecture);
                // Log.i(TAG, "after lecture list");
                Spinner spinner1 = new Spinner(context);
                button2 = new Button(context);
                button3 = new Button(context);
                final Button mButton = new Button(context);
                Log.i(TAG, "" + plus_counter);

                final LinearLayout Horizontal_layout = new LinearLayout(context);
                mButton.setId(100 + plus_counter);
                plus_counter++;

                ArrayAdapter<String> weekAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, WeekList);
                spinner1.setAdapter(weekAdapter);

                //spinner1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                button2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                button3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                Horizontal_layout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                Horizontal_layout.setOrientation(LinearLayout.HORIZONTAL);
                mButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

                mButton.setText("-");
                button2.setText(R.string.start_time);
                button3.setText(R.string.end_time);

                mLinearLayout.addView(Horizontal_layout);
                Horizontal_layout.addView(spinner1);
                Horizontal_layout.addView(button2);
                Horizontal_layout.addView(button3);
                Horizontal_layout.addView(mButton);

                mButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mLinearLayout.removeView(Horizontal_layout);
                        int counterC = mButton.getId() % 100;
                        Log.i(TAG, "counter C = " + counterC);
                        lectureList.get(counterC).setRemoved(true);
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
                Log.i(TAG, "No. of child views " + mLinearLayout.getChildCount());
                course.setCourseName(mCourseName.getText().toString());
                course.setCourseProfessor(mCourseProfessor.getText().toString());
                course.setCourseCredits(Float.parseFloat(mCourseCredits.getText().toString()));
                for (Lecture l : lectureList) {
                    if (l.isRemoved())
                        lectureList.remove(l);
                }
                //for(Lecture lecture : lectureList){
                lecture = getLecture(mLinearLayout);
                lectureList.add(lecture);
                //  }

//                int i = 0;
//                view = mLinearLayout.getChildAt(i);
//                while(view!=null){
//                    if(view instanceof Spinner){
//                        //Process Spinner
//                    }
//                    if(view instanceof Button){
//                        //Process TimePickerData
//                    }
//                    view = mLinearLayout.getChildAt(++i);
//                }
            }
        });
    }

    @Override
    public void onComplete(int hourOfDay, int minute) {
        String time = (minute < 10) ? (Integer.toString(hourOfDay) + ":0" + Integer.toString(minute)) : (Integer.toString(hourOfDay) + ":" + Integer.toString(minute));
        if (flag) {
            Log.i(TAG, "inside flag = true :1");
            button2.setText(time);
            Log.i(TAG, "inside flag = true:2");
        } else {
            button3.setText(time);
            Log.i(TAG, "Inside flag =false");
        }
    }

    private Lecture getLecture(View view) {
        Lecture l = new Lecture();
        boolean flag = false;
        ViewGroup vg = (ViewGroup) view;
        for (int i = 0; i < vg.getChildCount(); i++) {

            if (vg.getChildAt(i) instanceof LinearLayout) {
                return getLecture(vg.getChildAt(i));
            } else if (vg.getChildAt(i) instanceof Spinner) {
                flag = true;
                Log.e(TAG, "fetching spinner data");
                l.setLectureDay("Monday");//add Day to lecture
            } else if (vg.getChildAt(i) instanceof Button) {
                if (((Button) vg.getChildAt(i)).getText().toString() == "-")
                    break;
                if (flag) {
                    //use timepicker to assign start time
                    Log.i(TAG, "inside function flag = true start");
                    l.setLectureStart(600);
                    flag = false;
                } else {
                    //use timepicker to assign end time
                    Log.i(TAG, "inside function flag = false end");
                    l.setLectureEnd(660);
                }
            }
        }
        return l;
    }
}