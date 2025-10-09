package com.example.inapptoss;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient; // <-- 1. ADD THIS IMPORT
import androidx.appcompat.app.AppCompatActivity;
import com.example.inapptoss.bridge.GameBridge;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        setContentView(webView);

        // 2. SET THE WebViewClient
        webView.setWebViewClient(new WebViewClient()); // <-- ADD THIS LINE

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setMediaPlaybackRequiresUserGesture(false);

        webView.setWebChromeClient(new WebChromeClient());

        // JS <-> Java 브릿지 연결
        webView.addJavascriptInterface(new GameBridge(this, webView), "GameBridge");

        // HTML5 게임 파일 로드
        webView.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public void onBackPressed() {
        webView.evaluateJavascript("onBackPressed()", null);
    }
}
