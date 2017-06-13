package com.vecoder.demo.animations.bluetooth;


import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.vecoder.demo.animations.R;

public class BluetoothActivity extends AppCompatActivity{
    private static final String TAG = "BluetoothActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_blootooth);

        Log.d(TAG, "Application version is: " + getSoftwareVersion());
        Log.d(TAG, "Package name: " + getPackageName());


        Log.d(TAG, "Created.");
    }

    private String getSoftwareVersion() {
        PackageInfo pi;
        try {
            pi = getPackageManager().getPackageInfo(getPackageName(), 0);
            return pi.versionName;
        } catch (final PackageManager.NameNotFoundException e) {
            return "na";
        }
    }
}
