package com.wifipasshhhwi.wifipasswordhack.start;

import android.content.Context;
import android.net.wifi.WifiManager;

import java.util.ArrayList;

/**
 * Created by medvedomg on 14.12.16.
 */

public interface StartModel {
    void getWifi(ResultListener listener, WifiManager wifiManager, Context context);



    interface ResultListener {
        ArrayList OnSucces(ArrayList list);
    }

}
