package com.example.cse2252021kmo54;
/* Android AlarmManager allows you to access system alarm.

By the help of Android AlarmManager in android, you can
schedule your application to run at a specific time in
the future. It works whether your phone is running or not.

The Android AlarmManager holds a CPU wake lock that
provides guarantee not to sleep the phone until
broadcast is handled.
*/
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class P9AlarmUsingPendingIntent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p9_alarm_using_pending_intent);
    }

    public void click(View v){
        EditText text = findViewById(R.id.t);
        int i = Integer.parseInt(text.getText().toString());
        Intent intent = new Intent(this, P9MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(            this.getApplicationContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+(i * 1000), pendingIntent);
        Toast.makeText(this, "Alarm set in " + i + " seconds",Toast.LENGTH_LONG).show();
    }
}