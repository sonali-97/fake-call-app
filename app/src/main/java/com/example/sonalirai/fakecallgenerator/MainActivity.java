package com.example.sonalirai.fakecallgenerator;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText fakeName, fakeNumber;
    private RadioGroup radioGroup;
    private RadioButton radioButton0, radioButton1,radioButton2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        fakeName = findViewById(R.id.fakename);
        fakeNumber = findViewById(R.id.fakenumber);

        radioGroup = findViewById(R.id.radioGroup1);

        radioButton0=findViewById(R.id.radio0);
        radioButton1=findViewById(R.id.radio1);
        radioButton2=findViewById(R.id.radio2);

        button=findViewById(R.id.fakecalls);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedTime=0;
                int radioSelected=radioGroup.getCheckedRadioButtonId();
                int radioTimeSelected=getSelectedTime(radioSelected);


            }
        });
    }

    private int getSelectedTime(int radioSelected) {
        //int time=0;
        if(radioSelected==R.id.radio0)
            return 10;
        if(radioSelected==R.id.radio1)
            return 30;
        else return 60;
    }
}
