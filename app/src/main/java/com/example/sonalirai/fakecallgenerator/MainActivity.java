package com.example.sonalirai.fakecallgenerator;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

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

                if(radioSelected==-1){
                    Toast.makeText(MainActivity.this,"Default wait time is 60s",Toast.LENGTH_SHORT);
                }

                Calendar calendar=Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.add(Calendar.SECOND, 10);
                long calendarFakeTime=calendar.getTimeInMillis();
                String fakeNameString=fakeName.getText().toString();
                String fakeNumberString=fakeNumber.getText().toString();

                if(fakeNameString.equals("")&&fakeNumberString.equals("")){
                    Toast.makeText(MainActivity.this, "Must enter name and number", Toast.LENGTH_SHORT);
                }

                setUpAlarm(fakeNameString, fakeNumberString, calendarFakeTime);
            }
        });
    }

    private void setUpAlarm(String fakeNameString, String fakeNumberString, long calendarFakeTime) {
        AlarmManager alarmManager= (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent=new Intent(this,FakeCallReciever.class);

        intent.putExtra("Name", fakeNameString);
        intent.putExtra("Number", fakeNumberString);

        PendingIntent fakeIntent=PendingIntent.getBroadcast(MainActivity.this,0, intent,PendingIntent.FLAG_CANCEL_CURRENT);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendarFakeTime,fakeIntent);

        Intent mainIntent= new Intent(this, MainActivity.class);
        startActivity(mainIntent);
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
