package com.example.autoriz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class browser extends AppCompatActivity {

    private WebView web;

    @SuppressLint("SetJavaScriptEnabled")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        web = (WebView) findViewById(R.id.webView);
        WebSettings ws = web.getSettings();
        ws.setJavaScriptEnabled(true);
        web.loadUrl("https://animevost.am/");
        web.setWebViewClient(new WebViewClient());
    }
        @Override
        public void onBackPressed()
         {
            if (web.canGoBack())
                web.goBack();
            else
                super.onBackPressed();
        }
}
