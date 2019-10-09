package com.example.mvvmtestproject;

import android.content.Context;
import android.location.LocationListener;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class BoundLocationListener implements LifecycleObserver {
 private   Context mcontext;


    public void bindLocationListenerIn(LifecycleActivity lifecycleActivity, LocationListener mGpsListener, Context applicationContext) {
        mcontext=mcontext;
        lifecycleActivity.getLifecycle().addObserver(this);
    }


    //注解绑定类似eventbus

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void ON_RESUME() {
        Log.e("wxq","监听activity时间ON_RESUME");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void ON_STOP() {
        Log.e("wxq","监听activity时间ON_STOP");
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void ON_CREATE() {
        Log.e("wxq","监听activity时间  ON_CREATE,");
    }




}
