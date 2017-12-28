package com.vjti.collegetracker;

import android.content.Context;
import android.content.Intent;
import android.app.FragmentManager;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.Calendar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Date;
import java.util.stream.Collectors;

public class GetSubjectActivity extends AppCompatActivity implements TimePickerFragment.OnCompleteListener {
    boolean flag;
    String TAG = "LOG_TAG";
    EditText mCourseName;
    EditText mCourseProfessor;
    EditText mCourseCredits;
    TextView mAddText;
    Button mSaveButton;
    Button button2;
    Button button3;
    Button mAddButton;
    LinearLayout mLinearLayout;
    List<Lecture> lectureList;
    ArrayList<String> lectureNames;
    // View view;
    int plus_counter = 0;
    int pass_id =0;
    private final String DIALOG_DATE = "DialogDate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_subject);
        lectureList = new ArrayList<>();

        mLinearLayout=(LinearLayout)findViewById(R.id.lectures_linear_layout);

        final Context context= getApplicationContext();
        mLinearLayout = (LinearLayout) findViewById(R.id.lectures_linear_layout);
        mAddText = (TextView) findViewById(R.id.add_lecture_text_view);
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
                EditText editText1= new EditText(context);
                EditText editText2= new EditText(context);
                EditText editText3= new EditText(context);
                final Button mButton = new Button(context);
                final LinearLayout Horizontal_layout = new LinearLayout(context);

                final Lecture lecture = new Lecture();
                // Log.i(TAG, "after lecture list");
                // Log.i(TAG, "before lecture list");
                lecture.setRemoved(false);
                lectureList.add(plus_counter, lecture);
                // Log.i(TAG, "after lecture list");
                Spinner spinner1 = new Spinner(context);
                button2 = new Button(context);
                button3 = new Button(context);
                Log.i(TAG, "" + plus_counter);

                mButton.setId(1000 + plus_counter);
                button2.setId(2000 + plus_counter);
                button3.setId(3000 + plus_counter);
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
                        int counterC = (int) mButton.getId() % 100;
                        Log.i(TAG, "counter C on minus button = " + counterC);
                        lectureList.get(counterC).setRemoved(true);
                    }
                });

                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        flag = true;
                        pass_id = button2.getId();
                        Log.i(TAG, "Inside button2's listener pass_id="+pass_id);
                        FragmentManager fragmentManager = getFragmentManager();
                        TimePickerFragment dialog = new TimePickerFragment();
                        dialog.show(fragmentManager, DIALOG_DATE);
//                        TimePickerFragment.OnCompleteListener myListener = new TimePickerFragment.OnCompleteListener() {
//                            @Override
//                            public void onComplete(int hourOfDay, int minute) {
//                                String time = (minute < 10) ? (Integer.toString(hourOfDay) + ":0" + Integer.toString(minute)) : (Integer.toString(hourOfDay) + ":" + Integer.toString(minute));
//                                button2.setText(time);
//                            }
//                        };
//                        dialog.show(fragmentManager, DIALOG_DATE);
                    }
                });

                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        flag = false;
                        pass_id = button3.getId();
                        FragmentManager fragmentManager = getFragmentManager();
                        TimePickerFragment dialog = new TimePickerFragment();
                        dialog.show(fragmentManager, DIALOG_DATE);
                    }
                });
//
//                button2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        flag = true;
//                        FragmentManager fragmentManager = getFragmentManager();
//                        TimePickerFragment dialog = new TimePickerFragment();
//                        dialog.show(fragmentManager, DIALOG_DATE);
//
//                    }
//                });


            }
        });

        mSaveButton=(Button)findViewById(R.id.save_button);
        mSaveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.i(TAG, "No. of child views " + mLinearLayout.getChildCount());
//                lectureList.setCourseName(mCourseName.getText().toString());
//                lectureList.setCourseProfessor(mCourseProfessor.getText().toString());
//                try {
//                    float credits = (Float.parseFloat(mCourseCredits.getText().toString()));
//                    if (credits > 4 || credits < 0)
//                        throw new NumberFormatException();
//                    else
//                        course.setCourseCredits(credits);
//                } catch (NumberFormatException e) {
//                    Log.e(TAG, "Display warning");
//                    mCourseCredits.setError("Input should be between 0.0 and 4.0");
//                    return;
//                }

                Log.d(TAG, "before : " + lectureList.size());
                for (Iterator<Lecture> iterator = lectureList.iterator(); iterator.hasNext(); ) {
                    Lecture lecture = iterator.next();
                    Log.d(TAG, "lecture isRemoved() = " + lecture.isRemoved());
                    if (lecture.isRemoved()) {
                        iterator.remove();
                    }
                }
                Log.d(TAG, "after : " + lectureList.size());
//                course.setCourseLectures(lectureList);

//                Iterator<Lecture> iterator= lectureList.iterator();
//                    while(iterator.hasNext()) {
//                        if(iterator.next().isRemoved())
//                        lectureList.remove(iterator);
//                }
//                course.setCourseLectures(lectureList);

//                for(Lecture l : course.getCourseLectures()){
//                    if(l.isRemoved())
//                        course.getCourseLectures().remove(l);
//                }

                final int totalChildViews = mLinearLayout.getChildCount();
                //Check if course name field is empty
                if(mCourseName.getText().toString().compareToIgnoreCase("") == 0) {
                    mCourseName.requestFocus();
                    mCourseName.setError("Empty!");
                }
                //Check if course prof field is empty
                if(mCourseProfessor.getText().toString().compareToIgnoreCase("") == 0) {
                    mCourseProfessor.requestFocus();
                    mCourseProfessor.setError("Empty!");
                }
                float credits = 1;
                //Check if course credits field is empty
                if(mCourseCredits.getText().toString().compareToIgnoreCase("")==0) {
                    mCourseCredits.requestFocus();
                    mCourseCredits.setError("Empty!");
                }

                else credits = (Float.parseFloat(mCourseCredits.getText().toString()));
                //Check if credits lie within permissible range
                if (credits > 4 || credits < 0) {
                    mCourseCredits.setError("Input should be between 0.0 and 4.0");
                }
                if (totalChildViews == 0) {
                    mAddText.requestFocus();
                    mAddText.setError("No lectures have been added");
                }
                if(mCourseName.getText().toString().compareToIgnoreCase("") == 0 || mCourseProfessor.getText().toString().compareToIgnoreCase("") == 0 || mCourseCredits.getText().toString().compareToIgnoreCase("")==0 ||credits > 4 || credits < 0 || totalChildViews == 0)
                    return;
                Log.i(TAG, "totalChildViews = " + totalChildViews);
                for (int i = 0; i < totalChildViews; i++) {
                    lectureList.set(i, getLecture(mLinearLayout.getChildAt(i)));
                }
                Log.d(TAG, lectureList.size() + "");

                LectureStore lectureStore = new LectureStore(getApplicationContext());
                lectureNames = convertToLowerCase(lectureStore.getCourses());
                //Check if lecture already exists
                if(lectureNames.contains(mCourseName.getText().toString().trim())){
                    mCourseName.requestFocus();
                    mCourseName.setError("This course already exist!");
                    return;
                }
//                List<Lecture> lectureList1 = course.getCourseLectures();
                for (Lecture lecture : lectureList) {
                    lectureStore.addLecture(lecture);
                }
                finish();
//                for (int i = 0; i < totalChildViews; i++)
//                    Log.d(TAG, lectureList.get(i).getLectureStart() + " " + lectureList.get(i).isRemoved());
//
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

//    @Override
//    public void onComplete(int hourOfDay, int minute) {
//        String time = (minute < 10) ? (Integer.toString(hourOfDay) + ":0" + Integer.toString(minute)) : (Integer.toString(hourOfDay) + ":" + Integer.toString(minute));
//        if (flag) {
//            Log.i(TAG, "inside flag = true :1");
//            button2.setText(time);
//            Log.i(TAG, "inside flag = true:2");
//        } else {
//            button3.setText(time);
//            Log.i(TAG, "Inside flag =false");
//        }
//    }

//    private Lecture getLecture(View view) {
//        Lecture l = new Lecture();
//        boolean flag = false;
//        ViewGroup vg = (ViewGroup) view;
//        for (int i = 0; i < vg.getChildCount(); i++) {
//
//            if (vg.getChildAt(i) instanceof LinearLayout) {
//                return getLecture(vg.getChildAt(i));
//            } else if (vg.getChildAt(i) instanceof Spinner) {
//                flag = true;
//                String weekday = ((Spinner) childView).getSelectedItem().toString();
//                Log.i(TAG, "fetching spinner data " + weekday);
//                l.setLectureDay(weekday);//add Day to lecture
//            } else if (childView instanceof Button) {
//                if (((Button) vg.getChildAt(i)).getText().toString().equals("-"))
//                    break;
//                if (flag) {
//                    //use timepicker to assign start time
//                    //Log.i(TAG, "inside function flag = true start");
//                    String start = ((Button) childView).getText().toString();
//                    l.setLectureStart(convertTime(start));
//                    flag = false;
//                } else {
//                    //use timepicker to assign end time
//                    Log.i(TAG, "testing 10.00 = " + convertTime("10:00"));
//                    String end = ((Button) childView).getText().toString();
//                    l.setLectureEnd(convertTime(end));
//                }
//            }
//        }
//        return l;
//    }
    //Call-back method to get data from TimePickerFragment
    @Override
    public void onComplete(int hourOfDay, int minute) {
        String time = (minute < 10) ? (Integer.toString(hourOfDay) + ":0" + Integer.toString(minute)) : (Integer.toString(hourOfDay) + ":" + Integer.toString(minute));
        if (flag) {
            Log.i(TAG, "Button 2 TAG (inside onComplete)=" + pass_id);
            Button button2 = (Button) findViewById(pass_id);
            button2.setText(time);
        } else {
            Log.i(TAG, "Button 3 TAG (inside onComplete)=" + pass_id);
            Button button3 = (Button) findViewById(pass_id);
            button3.setText(time);
        }
    }
    private ArrayList<String> convertToLowerCase(ArrayList<String> list){
        ListIterator<String> iter = list.listIterator();
        ArrayList<String> newList = new ArrayList<>();
        while (iter.hasNext()){
            newList.add(iter.next().toLowerCase());
        }
        return  newList;
    }
    private Lecture getLecture(View view) {
        Lecture l = new Lecture();
        //Adding common details
        l.setCourseName(mCourseName.getText().toString().trim());
        l.setCourseProfessor(mCourseProfessor.getText().toString().trim());
        float credits = Float.parseFloat(mCourseCredits.getText().toString());
        l.setCourseCredits(credits);
        //Adding separate lectures

        boolean flag = false;
        ViewGroup vg = (ViewGroup) view;
        for (int i = 0; i < vg.getChildCount(); i++) {

            View childView = vg.getChildAt(i);
//            if (vg.getChildAt(i) instanceof LinearLayout) {
//                return getLecture(vg.getChildAt(i));
//          }
            if (childView instanceof Spinner) {
                flag = true;
                String weekday = ((Spinner) childView).getSelectedItem().toString();
                Log.i(TAG, "fetching spinner data " + weekday);
                l.setLectureDay(weekday);//add Day to lecture
            } else if (childView instanceof Button) {
                if (((Button) vg.getChildAt(i)).getText().toString().equals("-"))
                    break;
                if (flag) {
                    //use timepicker to assign start time
                    //Log.i(TAG, "inside function flag = true start");
                    String start = ((Button) childView).getText().toString();
                    Log.i(TAG, "testing" + start + " = " + convertTime(start));
                    l.setLectureStart(convertTime(start));
                    flag = false;
                } else {
                    //use timepicker to assign end time
                    String end = ((Button) childView).getText().toString();
                    Log.i(TAG, "testing" + end + " = " + convertTime(end));
                    l.setLectureEnd(convertTime(end));
                }
            }
        }
        return l;
    }

    int convertTime(String sTime) {
        return Integer.parseInt(sTime.split("\\:")[0]) * 60 + Integer.parseInt(sTime.split("\\:")[1]);
    }
}