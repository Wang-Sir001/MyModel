package com.bawei.mymodel.view.activity;

import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.bawei.mymodel.app.App;

public class User {
    @JavascriptInterface
    public void doJsN(){
        Toast.makeText(App.getContext(), "无参方法", Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void doJsY(String name){
        Toast.makeText(App.getContext(), name, Toast.LENGTH_SHORT).show();
    }
}
