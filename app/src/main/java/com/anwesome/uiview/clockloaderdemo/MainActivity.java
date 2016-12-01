package com.anwesome.uiview.clockloaderdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anwesome.uiview.clockloader.ClockLoader;

public class MainActivity extends AppCompatActivity {
    private ClockLoader clockLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clockLoader = new ClockLoader(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(i<12) {
                    try {
                        Thread.sleep(1000);
                        i++;
                    }
                    catch (Exception ex) {

                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        clockLoader.stop();
                    }
                });

            }
        }).start();
        clockLoader.startLoading();
    }
}
