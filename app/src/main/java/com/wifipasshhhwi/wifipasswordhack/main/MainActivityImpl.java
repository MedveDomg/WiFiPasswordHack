package com.wifipasshhhwi.wifipasswordhack.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wifipasshhhwi.wifipasswordhack.R;
import com.wifipasshhhwi.wifipasswordhack.main.adapter.WifiListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivityImpl extends AppCompatActivity implements MainView {

    @BindView(R.id.networksRecyclerView)
    RecyclerView networksRecyclerView;

    private WifiListAdapter wifiListAdapter;

    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupRepositoriesListView();
    }

    private void setupRepositoriesListView() {
        wifiListAdapter = new WifiListAdapter(list);
        networksRecyclerView.setAdapter(wifiListAdapter);
        linearLayoutManager = new LinearLayoutManager(this);
        networksRecyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onWifiClick(int wifiPosition) {
        
    }
}
