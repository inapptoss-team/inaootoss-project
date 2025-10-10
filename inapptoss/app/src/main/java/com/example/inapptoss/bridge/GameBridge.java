package com.example.inapptoss.bridge;

import android.webkit.WebView;
import com.example.inapptoss.MainActivity;

public class GameBridge {

    private final MainActivity mainActivity;
    private final WebView webView;

    // Add this constructor to your GameBridge class
    public GameBridge(MainActivity activity, WebView webView) {
        this.mainActivity = activity;
        this.webView = webView;
    }

    // ... (any other methods in your GameBridge class would go here)
}
