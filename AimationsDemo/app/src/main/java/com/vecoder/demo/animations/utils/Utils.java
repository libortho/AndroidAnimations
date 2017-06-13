package com.vecoder.demo.animations.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by velibor.gacina on 4/21/2017.
 */

public class Utils {

    private String getSoftwareVersion(Context context) {
        PackageInfo pi;
        try {
            pi = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return pi.versionName;
        } catch (final PackageManager.NameNotFoundException e) {
            return "na";
        }
    }
}
