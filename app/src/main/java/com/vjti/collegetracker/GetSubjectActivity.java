package com.vjti.collegetracker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class GetSubjectActivity extends AppCompatActivity {

    Button mSaveButton;
    Button mAddButton;
    LinearLayout mLinearLayout;
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
                EditText editText2= new EditText(context);
                EditText editText3= new EditText(context);
                Button mButton = new Button(context);
                final LinearLayout Horizontal_layout = new LinearLayout(context);

                editText1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                editText2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                editText3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                Horizontal_layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
                Horizontal_layout.setOrientation(LinearLayout.HORIZONTAL);
                mButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                mButton.setText("-");

                editText1.setHint(R.string.lecture_day);
                editText2.setHint(R.string.start_time);
                editText3.setHint(R.string.end_time);

                mLinearLayout.addView(Horizontal_layout);
                Horizontal_layout.addView(editText1);
                Horizontal_layout.addView(editText2);
                Horizontal_layout.addView(editText3);
                Horizontal_layout.addView(mButton);

                mButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mLinearLayout.removeView(Horizontal_layout);
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
}
