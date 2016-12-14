package com.wifipasshhhwi.wifipasswordhack.data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by medvedomg on 14.12.16.
 */

public class ScanWifiReciever extends BroadcastReceiver{

    private OnSmsReceivedListener listener = null;

    private WifiManager wifiManager;

    public ScanWifiReciever(WifiManager wifiManager) {
        this.wifiManager = wifiManager;
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)) {
            if (listener != null) {
                List<ScanResult> mScanResults = wifiManager.getScanResults();
                Log.d("ScanWifiReciever", "mScanResults.size " + mScanResults.size());
                listener.onSmsReceived((ArrayList) mScanResults);
            }
        }
    }

    public void setOnSmsReceivedListener(Context context) {
        this.listener = (OnSmsReceivedListener) context;
    }
}
