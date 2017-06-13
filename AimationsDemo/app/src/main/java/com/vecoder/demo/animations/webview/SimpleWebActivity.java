package com.vecoder.demo.animations.webview;

import com.vecoder.demo.animations.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by v.gacina on 10/11/2016.
 */

public class SimpleWebActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_simpleweb);

        bindViews();
        initializeWebView2();
        //webView.loadUrl("file://10.1.90.24/temp/javadoc.html");


    }

    private void bindViews(){
        webView = (WebView) findViewById(R.id.simple_webview);
    }

    private void initializeWebVIew(){
        webView.setInitialScale(1);
        //webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);
        webView.loadUrl("http://www.gspns.co.rs/aktuelno");
    }

    private void initializeWebView2(){
        WebSettings settings = webView.getSettings();
        settings.setBuiltInZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setJavaScriptEnabled(true);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setLightTouchEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);

        webView.loadUrl("http://www.gspns.co.rs/aktuelno");
    }
}
