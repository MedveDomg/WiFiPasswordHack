package com.wifipasshhhwi.wifipasswordhack.main;

import android.content.Intent;
import android.content.Loader;
import android.net.wifi.ScanResult;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.wifipasshhhwi.wifipasswordhack.R;
import com.wifipasshhhwi.wifipasswordhack.loader.LoaderActivityImpl;
import com.wifipasshhhwi.wifipasswordhack.main.adapter.WifiListAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivityImpl extends AppCompatActivity implements MainView {

    @BindView(R.id.networksRecyclerView)
    RecyclerView networksRecyclerView;

    private WifiListAdapter wifiListAdapter;

    private LinearLayoutManager linearLayoutManager;

    public static final String TAG = "MainActivity";

    ArrayList<ScanResult> wifiNetworks;

    MainPresenterImpl presenter;
    Intent listWifiNetworksIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        listWifiNetworksIntent = getIntent();

        setupRepositoriesListView();

        presenter = new MainPresenterImpl(this,listWifiNetworksIntent);
        presenter.loadWifiNetworks(listWifiNetworksIntent);
    }

    private void setupRepositoriesListView() {
        wifiListAdapter = new WifiListAdapter(this);
        networksRecyclerView.setAdapter(wifiListAdapter);
        linearLayoutManager = new LinearLayoutManager(this);
        networksRecyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onWifiClick(int wifiPosition) {
        Log.d(TAG, "onWifiClick");
        Intent openLoader = new Intent(this, LoaderActivityImpl.class);
        startActivity(openLoader);
    }

    public void setWifiNetworks(ArrayList<ScanResult> list) {
        wifiListAdapter.updateWifiNetworks(list);
    }

    public void getListWifiNetworks(Intent intent) {

    }
}
