package com.vecoder.demo.animations.telephony;

import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;

/**
 * Created by velibor.gacina on 8/9/2017.
 */

public class TelephonyActivityPresenter {

    private ViewCallback viewCallback;

    private TelephonyManager telephonyManager;





    interface ViewCallback{
        void onIncomingCall();
        void onCallFinished();
        void onCallStarted();
    }
}
