package com.hie2j.webview_callandroid;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private WebView my_WebView;
    private Button btn_Call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_WebView = findViewById(R.id.my_webview);
        btn_Call = findViewById(R.id.btn_call);

        WebSettings webSettings = my_WebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        //网页弹窗
        my_WebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {

                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("安卓的警告框")
                        .setMessage(message)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                result.confirm();
                            }
                        }).create();
                alertDialog.show();
                return true;
            }
        });

        my_WebView.loadUrl("file:///android_asset/app.html");
        my_WebView.addJavascriptInterface(new JStoAndroid(MainActivity.this),"android");
        my_WebView.addJavascriptInterface(new Jump(MainActivity.this),"jump");

        btn_Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //第一种方法
//                my_WebView.loadUrl("javascript:calls()");
                //第二种方法
                my_WebView.evaluateJavascript("javascript:calls()", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        Log.e("calcArea","value = " + value);
                    }
                });
            }
        });
    }
}
