package com.example.svb.food_orderingapp;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class web1 extends Activity {

    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web1);
        WebView webview=(WebView)findViewById(R.id.web);
        webview.setWebViewClient (new WebViewClient());
        webview.loadUrl("https://www.google.com/gmail/about/#/");
        WebSettings websettings=webview.getSettings();
        // websettings.setSaveScriptEnabled (true);
        websettings.setJavaScriptEnabled(true);
    }

}
