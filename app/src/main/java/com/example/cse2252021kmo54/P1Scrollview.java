package com.example.cse2252021kmo54;
/*ScrollView : we have two type of scrollview where "ScrollView" is used for vertical scroll and "HorizontalScrollView" used for horizontal scroll
 It can hold only one direct child.  if you have complex layout with more views(Buttons, TextViews or any other view) then you
 must enclose them inside another standard viewgroup layout like Table Layout, Relative Layout or Linear Layout. Then put that standard
  layout, within ScrollView to make all the element or views scrollable.

--> We never use a Scroll View with a ListView because List View is default scrollable(i.e. vertical scrollable).
--> In android default ScrollView is used to scroll the items in vertical direction and if you want to scroll the
 items horizontally then you need to implement horizontal ScrollView.
-->  android:scrollbars="horizontal"   to explicitly give the directions of scroll

all the files associated with it:
xml: activity_main
 */
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

public class P1Scrollview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ScrollView sv=findViewById(R.id.sv);
        sv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(P1Scrollview.this, "hey scrollview clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}