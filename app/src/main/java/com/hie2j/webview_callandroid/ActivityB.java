package com.hie2j.webview_callandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        setTitle("跳转过来的Activity_B");
    }
}
