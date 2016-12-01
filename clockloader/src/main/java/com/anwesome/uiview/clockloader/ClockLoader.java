package com.anwesome.uiview.clockloader;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anweshmishra on 01/12/16.
 */
public class ClockLoader {
    private boolean isLoading = false;
    private ClockLoaderView clockLoaderView;
    private Activity activity;
    public ClockLoader(Activity activity) {
        this.activity = activity;
    }
    public void startLoading() {
        if(!isLoading) {
            clockLoaderView = new ClockLoaderView(activity.getApplicationContext());
            activity.addContentView(clockLoaderView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            isLoading = true;
        }
    }
    public void stop() {
        if(isLoading) {
            clockLoaderView.setVisibility(View.INVISIBLE);
        }
    }
}
