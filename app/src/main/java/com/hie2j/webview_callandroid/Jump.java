package com.hie2j.webview_callandroid;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;

public class Jump {
    private Context context;

    public Jump(Context context){
        this.context = context;
    }

    @JavascriptInterface
    public void jump(){
        Intent intent = new Intent(context,ActivityB.class);
        context.startActivity(intent);
    }
}
