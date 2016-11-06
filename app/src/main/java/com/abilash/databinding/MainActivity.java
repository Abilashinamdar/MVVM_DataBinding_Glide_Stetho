package com.abilash.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.abilash.databinding.databinding.ActivityMainBinding;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);
        binding.contactList.setLayoutManager(new LinearLayoutManager(this));

        List<CardItem> items = new ArrayList<>();

        items.add(new CardItem("http://182.72.188.40/download/sws/v1.jpg", "First Image"));
        items.add(new CardItem("http://182.72.188.40/download/sws/v2.jpg", "First Image"));
        items.add(new CardItem("http://182.72.188.40/download/sws/v3.jpg", "First Image"));
        items.add(new CardItem("http://182.72.188.40/download/sws/v4.jpg", "First Image"));
        items.add(new CardItem("http://182.72.188.40/download/sws/v5.jpg", "First Image"));
        items.add(new CardItem("http://182.72.188.40/download/sws/v6.jpg", "First Image"));
        items.add(new CardItem("http://182.72.188.40/download/sws/v7.jpg", "First Image"));
        items.add(new CardItem("http://182.72.188.40/download/sws/v8.jpg", "First Image"));

        CardItemAdapter itemAdapter = new CardItemAdapter(items, this);
        binding.contactList.setAdapter(itemAdapter);




    }

    public void onButtonClick(View view) {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(new StethoInterceptor()).build();
        new Thread(){
            @Override
            public void run() {
                try {
                    final Response response = okHttpClient.newCall(new Request.Builder().url("http://httpbin.org/ip").build()).execute();
                    new android.os.Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                data = response.body().string();
                                Toast.makeText(MainActivity.this, data, Toast.LENGTH_LONG).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
