package com.rwida.childern_story;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class StoryHtml extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_html);

        WebView webView = findViewById(R.id.webview);

        Intent data = getIntent();

        int page = data.getExtras().getInt("page");
                    page++;
        webView.loadUrl("file:///android_asset/html/" + page + ".html");
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setInitialScale(3);
        webView.getSettings().setTextZoom(350);
        webView.setBackgroundColor(0x00000000); //<-- Color to transparent
        webView.setBackgroundResource(R.drawable.background3);
        //webView.setBackgroundColor(Color.rgb(255, 204, 204));
    }
}
