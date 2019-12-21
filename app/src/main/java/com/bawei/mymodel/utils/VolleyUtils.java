package com.bawei.mymodel.utils;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.mymodel.app.App;
import com.bawei.mymodel.model.entity.HomeEntity;
import com.google.gson.Gson;

import java.util.Map;

public class VolleyUtils {
    public RequestQueue requestQueue;

    private static VolleyUtils volleyUtils;

    private VolleyUtils() {
        requestQueue = Volley.newRequestQueue(App.getContext());
    }

    public static VolleyUtils getInstance() {
        if (volleyUtils == null) {
            synchronized (VolleyUtils.class){
                if (volleyUtils == null) {
                    volleyUtils = new VolleyUtils();
                }
            }
        }
        return volleyUtils;
    }

    public void doGet(String url, final VolleyCallback volleyCallback){
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                volleyCallback.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyCallback.error(error);
            }
        });

        requestQueue.add(stringRequest);
    }

    public void doPost(String url, final Map<String,String> prams, final VolleyCallback volleyCallback){
        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                volleyCallback.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyCallback.error(error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return prams;
            }
        };
        requestQueue.add(stringRequest);
    }


    public interface VolleyCallback{
        void success(String data);
        void error(Throwable throwable);
    }
}
