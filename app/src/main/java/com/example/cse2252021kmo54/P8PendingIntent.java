package com.example.cse2252021kmo54;
/*Android PendingIntent is an object that wraps up an intent object and it
specifies an action to be taken place in future. In other words, PendingIntent
lets us pass a future Intent to another application and allow that application
 to execute that Intent as if it had the same permissions as our application,
 whether or not our application is still around when the Intent is eventually invoked.

A PendingIntent is generally used in cases were an AlarmManager needs to
 be executed or for Notification . A PendingIntent provides a means for
 applications to work,even after their process exits.
  
  
-->For security reasons, the base Intent that is supplied to the PendingIntent 
 must have the component name explicitly set to ensure it is ultimately sent there
 and nowhere else. Each explicit intent is supposed to be handled by a specific 
app component like Activity, BroadcastReceiver or a Service. Hence PendingIntent
uses the following methods to handle the different types of intents:
1.PendingIntent.getActivity() : Retrieve a PendingIntent to start an Activity
2.PendingIntent.getBroadcast() : Retrieve a PendingIntent to perform a Broadcast
3.PendingIntent.getService() : Retrieve a PendingIntent to start a Service

-->The parameters inside the getActivity() method and there usages are described below :

1. this (context) : This is the context in which the PendingIntent starts the activity
2. requestCode : “1” is the private request code for the sender used in the above
example. Using it later with the same method again will get back the same
pending intent. Then we can do various things like cancelling the pending
intent with cancel(), etc.
3.intent : Explicit intent object of the activity to be launched
4.flag : One of the PendingIntent flag that we’ve used in our example is
FLAG_UPDATE_CURRENT. This one states that ifa previous PendingIntent
already exists, then the current one will update it with the latest
intent. There are many other  flags like FLAG_CANCEL_CURRENT etc.
*/
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class P8PendingIntent extends AppCompatActivity {
    Button create_notification;
    Button cancel_notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p8_pending_intent);
        create_notification = (Button) findViewById(R.id.notification_btn);
        cancel_notification = (Button) findViewById(R.id.cancel_btn);
    }

    public void dothis(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
        //getActivity(Context context, int requestCode, Intent intent, int flags)
        // Retrieve a PendingIntent that will start a new activity
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification.Builder mBuilder = new Notification.Builder(this,"CHANNEL_ID");   //workes after oreo version
                mBuilder.setSmallIcon(R.mipmap.ic_launcher);
               mBuilder .setContentTitle("My notification");
                mBuilder.setContentText("Hello World!");
                mBuilder.setContentIntent(pendingIntent);
                mBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background));

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // Will display the notification in the notification bar
        notificationManager.notify(0, mBuilder.build());
    }

    public void dothis2(View v) {
        NotificationManager mgr = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        mgr.cancel(0);
    }

}