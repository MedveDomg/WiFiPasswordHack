package com.wifipasshhhwi.wifipasswordhack.main;

import android.content.Intent;
import android.net.wifi.ScanResult;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by medvedomg on 15.12.16.
 */

public class MainPresenterImpl implements MainPresenter{

    private MainView mainActivity;
    private Intent listWifiNetworksIntent;
    private ArrayList<ScanResult> wifiList;
    public static final String  TAG = "MainPresenter";

    public MainPresenterImpl(MainView mainActivity, Intent intent) {
        this.listWifiNetworksIntent = intent;
        this.mainActivity = mainActivity;
    }

    @Override
    public void loadWifiNetworks(Intent intent) {
        wifiList = listWifiNetworksIntent.getParcelableArrayListExtra("wifi_list");
        Log.d(TAG, "loadWifiNetworks, wifilist.size = " + wifiList.size());
        mainActivity.setWifiNetworks(wifiList);
    }
}
