package com.example.cse2252021kmo54;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DemoCustomToast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_custom_toast);
    }

    public void submit(View v) {

        LayoutInflater i=getLayoutInflater();
        View l=i.inflate(R.layout.activity_custom_toast_layout,findViewById(R.id.ll));
        //here we will write the code of infalting the custom toast xml
        TextView t=l.findViewById(R.id.tv);
    t.setText("i am custom toast");
        Toast tv=new Toast(getApplicationContext());
        tv.setGravity(Gravity.CENTER_VERTICAL,0,0);
tv.setDuration(Toast.LENGTH_LONG);
    tv.setView(l);
    tv.show();}
}