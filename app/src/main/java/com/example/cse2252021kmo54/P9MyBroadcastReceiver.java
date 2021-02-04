package com.example.cse2252021kmo54;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class P9MyBroadcastReceiver extends BroadcastReceiver {
    MediaPlayer mp;
    public void onReceive(Context context, Intent intent) {
        mp=mp.create(context,R.raw.abc);
        mp.start();
        Toast.makeText(context, "Alarm....", Toast.LENGTH_LONG).show();

    }}
