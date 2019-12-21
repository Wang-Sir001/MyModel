package com.bawei.mymodel.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;

import com.bawei.mymodel.R;
import com.bawei.mymodel.base.BaseActivity;
import com.bawei.mymodel.base.mvp.BasePresenter;

public class SecondActivity extends BaseActivity {
    private WebView webView;
    private Button button;
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        webView.loadUrl("file:///android_asset/hello.html");
        webView.addJavascriptInterface(new User(),"user");

    }

    @Override
    protected void initView() {
        webView = findViewById(R.id.webView_Second);
        button = findViewById(R.id.button_Second);

        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebChromeClient(new WebChromeClient());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "我是android";

                webView.loadUrl("javascript:a('"+s+"')");
            }
        });
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_second;
    }
}
