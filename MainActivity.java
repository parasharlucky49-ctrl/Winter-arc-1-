package com.winterarc.tracker;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    private WebView webView;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showBrandedSplash();
    }

    private void showBrandedSplash() {
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setBackgroundColor(Color.rgb(8,7,8));

        ImageView logo = new ImageView(this);
        logo.setImageResource(com.winterarc.tracker.R.drawable.winter_arc_splash);
        logo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        root.addView(logo, new LinearLayout.LayoutParams(dp(180), dp(180)));

        TextView title = new TextView(this);
        title.setText("WINTER ARC");
        title.setTextColor(Color.rgb(242,226,244));
        title.setTextSize(24);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(null, android.graphics.Typeface.BOLD);
        title.setLetterSpacing(.12f);
        root.addView(title, new LinearLayout.LayoutParams(-1, dp(50)));

        TextView subtitle = new TextView(this);
        subtitle.setText("90 DAYS • DISCIPLINE • CONSISTENCY");
        subtitle.setTextColor(Color.rgb(157,149,158));
        subtitle.setTextSize(10);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setLetterSpacing(.12f);
        root.addView(subtitle, new LinearLayout.LayoutParams(-1, dp(35)));

        setContentView(root);
        root.postDelayed(this::openTracker, 900);
    }

    private void openTracker() {
        webView = new WebView(this);
        setContentView(webView);
        WebSettings s = webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setAllowFileAccess(true);
        s.setAllowContentAccess(true);
        s.setBuiltInZoomControls(false);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("file:///android_asset/index.html");
    }

    private int dp(int value) {
        return Math.round(value * getResources().getDisplayMetrics().density);
    }

    @Override public void onBackPressed() {
        if (webView != null && webView.canGoBack()) webView.goBack(); else super.onBackPressed();
    }
}
