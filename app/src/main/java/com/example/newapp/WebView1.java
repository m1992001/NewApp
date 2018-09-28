package com.example.newapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebView1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view1);
        WebView webView1 = findViewById(R.id.webview1);
        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.getSettings().setDomStorageEnabled(true);
        webView1.setWebViewClient(new WebViewClient());
        webView1.loadUrl("http://192.168.1.116:4399/");
    }
}