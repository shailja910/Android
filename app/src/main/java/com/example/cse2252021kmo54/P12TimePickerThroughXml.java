package com.example.cse2252021kmo54;
/* In Android, TimePicker is a widget used for selecting the time
 of the day in either AM/PM mode or 24 hours mode. The displayed
  time consist of hours, minutes and clock format.  If we need
   to show this view as a Dialog then we have to use a
   TimePickerDialog class.

-->Methods of TimePicker:
1. setCurrentHour(Integer currentHour):This method is used to
 set the current hours in a time picker.It was deprecated
in API level 23. From api level 23 we have to use
setHour(Integer hour). In this method there is only
one parameter of integer type which is used to set
 the value for hours.

2. setCurrentMinute(Integer currentMinute):This method is used
 to set the current minutes in a time picker.setMinute
 (Integer minute): setCurrentMinute() method was deprecated
  in API level 23. From api level 23 we have to use
  setMinute(Integer minute). In this method there is only
  one parameter of integer type which set the value for minutes.

3. getCurrentHour():This method is used to get the current
hours from a time picker.getCurrentHour() method was
deprecated in API level 23. From api level 23 you have
 to use getHour(). This method returns  an integer value.

4.getCurrentMinute():This method is used to get the current
 minutes from a time picker.getCurrentMinute() method was
 deprecated in API level 23. From api level 23 we have to
 use getMinute(). This method returns an integer value.

5. setIs24HourView(Boolean is24HourView):This method is used
 to set the mode of the Time picker either 24 hour mode or
  AM/PM mode. In this method we set a Boolean value either
   true or false. True value indicate 24 hour mode and false
    value indicate AM/PM mode.

6. is24HourView():This method is used to check the current
mode of the time picker. This method returns true if its
 24 hour mode or false if AM/PM mode is set.

7. setOnTimeChangedListener(TimePicker.OnTimeChangedListener
onTimeChangedListener):This method is used to set the
callback that indicates the time has been adjusted by
 the user. onTimeChanged(TimePicker view, int hourOfDay,
  int minute) is an override function of this listener
  in which we have three parameters first is for TimePicker
  , second for getting hour of the day and last is for
  getting the minutes after changing the time of the time picker.

-->Attributes of TimePicker:
1. id: id is an attribute used to uniquely identify a time picker.
2. timePickerMode: time picker mode is an attribute of time picker
 used to set the mode either spinner or clock. Default mode is
  clock but this mode is no longer used after api level 21,
  so from api level 21 you have to set the mode to spinner.

3.. background: background attribute is used to set the
background of a time picker. We can set a color or a drawable
 image in the background. We can also set the background
 color programmatically means in java class.
simpleTimePicker.setBackgroundColor(Color.YELLOW);

4. padding: padding attribute is used to set the padding
from left, right, top or bottom for a time picker.

paddingRight: set the padding from the right side of the time picker.
paddingLeft: set the padding from the left side of the time picker.
paddingTop: set the padding from the top side of the time picker.
paddingBottom: set the padding from the bottom side of the time picker.
Padding: set the padding from the all side’s of the time picker.
Below example we set the 20dp padding from all the side’s of the time picker.*/
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class P12TimePickerThroughXml extends AppCompatActivity {
TimePicker tp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p12_time_picker_through_xml);
        tp=findViewById(R.id.tp);
        tp.setHour(10);   //for default hour
        tp.setMinute(35);  //for default minute
        tp.setIs24HourView(false);//for 12 hour display
        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                int hour=tp.getHour();
                int min=tp.getMinute();
                Toast.makeText(getApplicationContext(), hour + "\n" + min , Toast.LENGTH_LONG).show();

            }
        });
    }
    public void submit(View v) {
    int hour=tp.getHour();
    int min=tp.getMinute();
        Toast.makeText(getApplicationContext(), hour + "\n" + min , Toast.LENGTH_LONG).show();



    }
}