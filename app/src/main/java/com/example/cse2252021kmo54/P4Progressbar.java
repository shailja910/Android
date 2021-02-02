package com.example.cse2252021kmo54;
/* Progress bars are used to show progress of a task.
In Android, ProgressBar is used to display the status of work being done
like analyzing status of work or downloading a file etc. In Android, by
 default a progress bar will be displayed as a spinning wheel but If
  we want it to be displayed as a horizontal bar then we need to use
   style attribute as horizontal. It mainly use the “android.widget.ProgressBar”
   class.
-->It is of two types on the basis of UI : (decided through xml)
1) Horizontal sleek bar types
2) circular (byt default) it rotates in circularly.

-->It is of two types on the basis of progress : (decided through xml)
1) determinate: when time numeric amount is shown how much progress is done.
for this we need thread runnable to show numeric value progress.
2) indeterminate: (by default) when it just runs without showing numeric
amount. It runs by default.

-->Methods of progressbar
getMax() – returns the maximum value of progress bar
getProgress() – returns current progress value

there are two ways to
create progress bar : through xml or through java file

This program is implementing through xml:
associated xml:p4progressbar_in_xml

-->attributes of xml:
    android:max="100"   //maximum integer upto which progress should be shown used for determinate progress bar
    style="@style/Widget.AppCompat.ProgressBar.Horizontal"   //to make seek bar
    android:progress="50"     default progress
    */

        import android.os.Handler;
        import androidx.appcompat.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ProgressBar;
        import android.widget.TextView;

public class P4Progressbar extends AppCompatActivity {

/*circular is by default indeterminant so no code needed from java file. only
write it in xml and its done . */

    /*this code is written to show the numeric progress of horizontal bar ,
which is made determinate in xml.for that we have to implement thread .*/

    ProgressBar pb;
    Button b;
    TextView tv;
    int progressStatus = 0;      //a variable on which progress will increment
    /*Handlers are basically background threads which allows you to communicate
     with the UI thread (update the UI).
     Handlers are subclassed from the Android Handler class and can be used
      either by specifying a Runnable to be executed when required by the
      thread, or by overriding the handleMessage() callback method within
       the Handler subclass which will be called when messages are sent
        to the handler by a thread.

There are two main uses for a Handler:
a) To schedule messages and Runnables to be executed at some point in the future
b) To enqueue an action to be performed on a different thread than your own.*/
    Handler handler = new Handler();   //to pass the value of onw object to another

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p4_progressbar);
        pb = findViewById(R.id.pbstraight);
        tv= findViewById(R.id.tv);
        b=findViewById(R.id.start);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb.setVisibility(v.VISIBLE);
         Thread t= new Thread(new Runnable()       //anonymmous class
         {
             public void run()
             {
                 while (progressStatus < 100)
                 {
                     progressStatus += 1;
                     // Update the progress bar and display the current value in the text view
                     handler.post(new Runnable()
                     {
                         public void run()
                         {
                             pb.setProgress(progressStatus);   //value set with bar
                             tv.setText(progressStatus+"/"+pb.getMax());
                         }
                     });
                     try {
                         Thread.sleep(1000); // Sleep for 200 milliseconds.
                     }
                     catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
             }
         }); t.start();
   }});
 }}
