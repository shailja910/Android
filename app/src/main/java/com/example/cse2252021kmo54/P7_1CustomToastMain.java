package com.example.cse2252021kmo54;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class P7_1CustomToastMain extends AppCompatActivity {
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p7_1_custom_toast_main);
        b1 = (Button) findViewById(R.id.b11);
    }

    public void push(View V)     //onClick from xml
    {
        LayoutInflater inflater = getLayoutInflater();
    /*instead of inflating component of "View" or "ViewGroup",now I will
         inflate whole xml file */
        View layout = inflater.inflate(R.layout.activity_p7_2_custom_toast_layout,(ViewGroup) findViewById(R.id.cutom_toast_layout));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("This is a custom toast to make the customized things");
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);   //to set layout on toast
        toast.show();
    }
}
