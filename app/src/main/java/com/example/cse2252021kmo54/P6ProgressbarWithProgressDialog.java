package com.example.cse2252021kmo54;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class P6ProgressbarWithProgressDialog extends AppCompatActivity {
    Button b2;
    ProgressDialog progressBar;
     int progressBarStatus = 0;
     Handler progressBarHandler = new Handler();
    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        b2 = (Button) findViewById(R.id.b12);
        setContentView(R.layout.activity_p6_progressbar_with_progress_dialog);

        }

        public void push2(View v)   //onClick through xml
        {
            progressBar = new ProgressDialog(v.getContext());
            progressBar.setIcon(R.drawable.ic_launcher_background);
            progressBar.setCancelable(true);   //so not get closed clicking outside the dialog box
            progressBar.setMessage("File downloading ...");
            progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
           // progressBar.setProgress(50);
            progressBar.setMax(100);
            progressBar.show();

            Thread t = new Thread(new Runnable()
            {
                public void run()
                {
                    while (progressBarStatus < 100)
                    {
                        progressBarStatus++;        // = doSomeTasks();
                        try {
                            Thread.sleep(1000);
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        progressBarHandler.post(new Runnable()
                        {
                            public void run() {
                                progressBar.setProgress(progressBarStatus);
                            }
                        });
                    }
                    //if it reaches to 100 % then to close the bar
                    if (progressBarStatus >= 100) {

                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        progressBar.dismiss();
                    }

                }
            });
            t.start();

        }
    }