package com.example.interview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WebviewActivity extends AppCompatActivity  {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        WebView view = findViewById(R.id.webview);
        view.loadUrl("https://www.intellimec.com/about-ims");
        Button btn = findViewById(R.id.webview_btn_ok);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_OK);
                finish();
            }
        });
    }
}
