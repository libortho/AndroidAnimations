package com.vecoder.demo.animations.telephony;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by velibor.gacina on 8/9/2017.
 */

public class CallDetectorService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    
}
