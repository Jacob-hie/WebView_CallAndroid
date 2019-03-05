package com.hie2j.webview_callandroid;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class JStoAndroid {
    private Context context;

    public JStoAndroid(Context context){
        this.context =context;
    }

    @JavascriptInterface
    public void sayHello(String str){
        Log.e("sayHello"," str = "+str);
        Toast.makeText(context,"hello " + str,Toast.LENGTH_SHORT).show();
    }
}
