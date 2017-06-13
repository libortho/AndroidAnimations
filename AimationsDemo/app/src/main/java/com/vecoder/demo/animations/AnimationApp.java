package com.vecoder.demo.animations;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

/**
 * Created by Prove on 9/16/2016.
 */
public class AnimationApp extends MultiDexApplication {

    private static AnimationApp mInstance;

    public static synchronized AnimationApp getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
