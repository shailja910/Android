package com.example.cse2252021kmo54;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class P10DateTimePickerAlarm extends AppCompatActivity  {
    DatePicker pickerDate;
    TimePicker pickerTime;
    Button buttonSetAlarm;
    TextView info;

    final static int RQS_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p10_date_time_picker_alarm);

        info = (TextView)findViewById(R.id.info);
        pickerDate = (DatePicker)findViewById(R.id.pickerdate);
        pickerTime = (TimePicker)findViewById(R.id.pickertime);

        Calendar now = Calendar.getInstance();

        pickerDate.init(
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH),
                null);

        pickerTime.setCurrentHour(now.get(Calendar.HOUR_OF_DAY));
        pickerTime.setCurrentMinute(now.get(Calendar.MINUTE));

        buttonSetAlarm = (Button)findViewById(R.id.setalarm);
        buttonSetAlarm.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                Calendar current = Calendar.getInstance();

                Calendar cal = Calendar.getInstance();
                cal.set(pickerDate.getYear(),
                        pickerDate.getMonth(),
                        pickerDate.getDayOfMonth(),
                        pickerTime.getCurrentHour(),
                        pickerTime.getCurrentMinute(),
                        00);

                if(cal.compareTo(current) <= 0){
                    //The set Date/Time already passed
                    Toast.makeText(getApplicationContext(),
                            "Invalid Date/Time",
                            Toast.LENGTH_LONG).show();
                }else{
                    setAlarm(cal);
                }

            }});
    }

    private void setAlarm(Calendar targetCal){

        info.setText("\n\n***\n"
                + "Alarm is set@ " + targetCal.getTime() + "\n"
                + "***\n");

        Intent intent = new Intent(getBaseContext(), P9MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);
    }

}