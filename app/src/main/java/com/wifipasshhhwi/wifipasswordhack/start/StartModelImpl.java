package com.wifipasshhhwi.wifipasswordhack.start;

import android.Manifest;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.wifipasshhhwi.wifipasswordhack.data.OnSmsReceivedListener;
import com.wifipasshhhwi.wifipasswordhack.data.ScanWifiReciever;

import java.util.ArrayList;

/**
 * Created by medvedomg on 14.12.16.
 */

public class StartModelImpl implements StartModel{

    private ArrayList wifiList;

    private ResultListener listener;
    private ScanWifiReciever scannerWifi;


    @Override
    public void getWifi(ResultListener listener, WifiManager wifiManager, Context context) {
//        scannerWifi.setOnSmsReceivedListener(startActivity);
        wifiManager.startScan();
        this.listener = listener;


    }

//    @Override
//    public void onSmsReceived(ArrayList<ScanResult> list) {
//        Log.d("StartModelImpl", "onSmsRecied list size " + list.size());
//        listener.OnSucces(wifiList);
//
//    }
}
