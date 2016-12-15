package com.wifipasshhhwi.wifipasswordhack.main;

import android.net.wifi.ScanResult;

import java.util.ArrayList;

/**
 * Created by medvedomg on 14.12.16.
 */

public interface MainView {
    void onWifiClick(int wifiPosition);

    void setWifiNetworks(ArrayList<ScanResult> list);
}
