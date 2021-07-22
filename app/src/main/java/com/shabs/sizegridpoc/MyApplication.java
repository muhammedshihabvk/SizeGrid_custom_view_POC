package com.shabs.sizegridpoc;

import android.app.Application;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.jacksonandroidnetworking.JacksonParserFactory;

import okhttp3.OkHttpClient;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build();
        AndroidNetworking.initialize(getApplicationContext(),okHttpClient);
//        AndroidNetworking.setParserFactory(new JacksonParserFactory());
        Log.d("TAG","Application Class invoked");
    }
}
