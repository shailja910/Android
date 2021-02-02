package com.example.cse2252021kmo54;
/* RatingBar is used to get the rating from the app user. A user can simply touch
, drag or click on the stars to set the rating value. The value of rating always
 returns a floating point number which may be 1.0, 2.5, 4.5 etc.

RatingBar is an extension of ProgressBar and
SeekBar which shows a rating in stars. RatingBar is a subclass of AbsSeekBar class.

-->Methods Used in Rating Bar:
a).getRating(): You can get the rating number from a RatingBar by using
getRating() method. This method returns a Floating Point number. Below
we get the current rating number from a RatingBar.
b). getNumStars(): You can get the number of stars of a RatingBar by
using getNumstars() method. This method returns int value. In below
code we get the total number of stars of a RatingBar.

-->     android:background="@color/teal_200"   to provide color to backgrounf of rating bar
        android:numStars="7"   //default total number of start to be shown in this width
                                should be taken wrap_content otherwise whole bar with more number of starts will be shown
        android:rating="3.5"   //default rating
        android:progressBackgroundTint="@color/black"   //color of all the stars
        android:progressTint="#999999"           //color of selected stars
Associated files: activity_p3_rating_bar.xml
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class P3RatingBar extends AppCompatActivity {
    RatingBar rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p3_rating_bar);
        rb = findViewById(R.id.rb); // initiate a rating bar
         }

    public void submit(View v)
    {
        Float ratingNumber = rb.getRating(); // get rating number from a rating bar
        Toast.makeText(this,""+rb,Toast.LENGTH_LONG).show();
        int numberOfStars = rb.getNumStars(); // get total number of stars of rating bar
        Toast.makeText(this,""+rb,Toast.LENGTH_LONG).show();


    }
}