package com.wifipasshhhwi.wifipasswordhack.start;

import android.content.Context;
import android.net.wifi.WifiManager;

import java.util.ArrayList;

/**
 * Created by medvedomg on 14.12.16.
 */

public class StartPresenterImpl implements StartPresenter, StartModel.ResultListener {

    private StartView startView;
    private StartModel startModel;

    private WifiManager wifiManager;

    private Context context;

    private StartActivityImpl startActivity;

    public StartPresenterImpl(StartView startActivytImpl, WifiManager wifiManager, Context context) {
        this.startView = startActivytImpl;
        startModel = new StartModelImpl();
        this.wifiManager = wifiManager;
        this.context = context;
        this.startActivity = startActivity;
    }


    @Override
    public void askWifiList() {

        startModel.getWifi(this, wifiManager, context);
    }


    @Override
    public ArrayList OnSucces(ArrayList list) {
        return null;
    }
}
