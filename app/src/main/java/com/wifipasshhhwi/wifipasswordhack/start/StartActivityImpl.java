package com.wifipasshhhwi.wifipasswordhack.start;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.wifipasshhhwi.wifipasswordhack.R;
import com.wifipasshhhwi.wifipasswordhack.data.OnSmsReceivedListener;
import com.wifipasshhhwi.wifipasswordhack.data.ScanWifiReciever;
import com.wifipasshhhwi.wifipasswordhack.main.MainActivityImpl;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartActivityImpl extends AppCompatActivity implements StartView, OnSmsReceivedListener {

    @BindView(R.id.startButton)
    Button startButton;

    private StartPresenterImpl presenter;

    private ScanWifiReciever scannerWifi;

    WifiManager wifiManager;

    private static final String TAG = "StartActivity";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);

        wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);

        scannerWifi = new ScanWifiReciever(wifiManager);
        scannerWifi.setOnSmsReceivedListener(this);

        presenter = new StartPresenterImpl(this, wifiManager, getApplicationContext());

        registerReceiver(scannerWifi,
                new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));

    }

    @OnClick(R.id.startButton)
    public void sendRequestForOpenMainActivity() {
        Log.d("StartActivity", "start button clicked");
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    1);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
            Log.d(TAG, "not granted");
        }else{
//            getScanningResults();
            //do something, permission was previously granted; or legacy device
            presenter.askWifiList();
        }

    }

    @Override
    public void navigateToHome(ArrayList list) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(scannerWifi);
    }




    @Override
    public void onSmsReceived(ArrayList<ScanResult> list) {
        Log.d(TAG, "onSmsRecied list size " + list.size());
        Intent openMain = new Intent(this, MainActivityImpl.class);
        openMain.putExtra("wifi_list", list);
        startActivity(openMain);
    }
}
