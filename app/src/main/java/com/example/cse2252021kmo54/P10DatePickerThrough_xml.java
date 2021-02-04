package com.example.cse2252021kmo54;
/* In Android, DatePicker is a widget used to select a date.
It allows to select date by day, month and year in your
custom UI (user interface). If we need to show this view as
 a dialog then we have to use a DatePickerDialog class. For
 selecting time Android also provides timepicker to select time.

--> Methods of DatePicker
1. setSpinnersShown(boolean shown): This method is used to
 set whether the spinner of the date picker in shown or not.
In this method you have to set a Boolean value either true
 or false. True indicates spinner is shown, false value
 indicates spinner is not shown. Default value for this
  function is true.
2.  getDayOfMonth():This method is used to get the selected
 day of the month from a date picker.  This method returns
 an integer value.
3. getMonth():This method is used to get the selected month
   from a date picker.  This method returns an integer value.
4. getYear():This method is used to get the selected year
from a date picker.  This method returns an integer value.
5. getFirstDayOfWeek():This method is used to get the first
 day of the week. This method returns an integer value.

 --> Attributes of DatePicker
 1. id: id is an attribute used to uniquely identify a date picker.
 2. datePickerMode: This attribute is used to set the Date Picker
 in mode either spinner or calendar. Default mode is calendar
 but this mode is not used after api level 21, so from api
  level 21 you have to set the mode to spinner.
        <DatePicker
        android:id="@+id/simpleDatePicker"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:datePickerMode="spinner" />
         <!-- spinner mode of a date picker -->
        datePickerMode Spinner calendar in Android3.
4.background: background attribute is used to set
 the background of a date picker. We can
         set a color or a drawable image in the background.
        Below we set the red color for the background of a date picker.

        <DatePicker
        android:id="@+id/simpleDatePicker"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:datePickerMode="spinner"
        android:background="#f00"/> <!-- red color for the background of the date picker -->
        background in DataPicker AndroidSetting background of DatePicker In Java Class:
        DatePicker simpleDatePicker=(DatePicker)findViewById(R.id.simpleDatePicker); // initiate a date picker
        simpleDatePicker.setBackgroundColor(Color.RED); //  red color for the background of a date picker
 4. padding: padding attribute is used to set the padding from left, right, top or bottom for a date picker.

        paddingRight: set the padding from the right side of the date picker.
        paddingLeft: set the padding from the left side of the date picker.
        paddingTop: set the padding from the top side of the date picker.
        paddingBottom: set the padding from the bottom side of the date picker.
        Padding: set the padding from the all side’s of the date picker. */
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class P10DatePickerThrough_xml extends AppCompatActivity {
    DatePicker simpleDatePicker;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p10_date_picker_through_xml);
        simpleDatePicker = (DatePicker) findViewById(R.id.simpleDatePicker);
        submit = (Button) findViewById(R.id.submitButton);
        // perform click event on submit button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the values for day of month , month and year from a date picker
                String day = "Day = " + simpleDatePicker.getDayOfMonth();
                String month = "Month = " + (simpleDatePicker.getMonth() + 1);
                String year = "Year = " + simpleDatePicker.getYear();
                // display the values by using a toast
                Toast.makeText(getApplicationContext(), day + "\n" + month + "\n" + year, Toast.LENGTH_LONG).show();
            }
        });
    }
}