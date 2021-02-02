package com.example.cse2252021kmo54;
/*Splash screen is most commonly the first startup screen
which appears when App is opened. In other words, it is a
simple constant screen for a fixed amount of time which
 is used to display the company logo, name, advertising
 content etc.

 -->it shows when app is first time launched on android
 device or it may be some kind of process that is used
 to show screen to user just before the app loads completely.

 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class P5_1SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p5_1_splash_screen);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),P5_2SplashScreenMain.class);
                startActivity(intent);
                finish();
            }
        },3000);
        }
}