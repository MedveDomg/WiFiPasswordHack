package com.wifipasshhhwi.wifipasswordhack.main.adapter;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wifipasshhhwi.wifipasswordhack.R;
import com.wifipasshhhwi.wifipasswordhack.main.MainActivityImpl;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by medvedomg on 14.12.16.
 */

public class WifiListAdapter extends RecyclerView.Adapter<WifiListAdapter.WifiViewHolder> {
    private ArrayList<ScanResult> wifiNetworks = new ArrayList<>();

    private ArrayList list = new ArrayList();

    Context context;

    private static final String TAG = "WifiAdapter";

    private MainActivityImpl mainActivity;
    private String wifiListAdapter;


    public WifiListAdapter(MainActivityImpl mainActivity) {
        this.mainActivity = mainActivity;
//        this.context = context;
    }

    public static class WifiViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.wifiNetwork)
        TextView nameWifi;

        @BindView(R.id.signalWifi)
        TextView singalWifi;

        @BindView(R.id.keyWifi)
        TextView keyWifi;

        @BindView(R.id.rowLayout)
        LinearLayout linearLayout;

        public WifiViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public WifiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_wifi_networks_list, parent,false);
        final WifiViewHolder holder = new WifiViewHolder(view);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onWifiClicked(holder.getAdapterPosition());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(WifiViewHolder holder, int position) {
        holder.nameWifi.setText(wifiNetworks.get(position).SSID);
        holder.singalWifi.setText("Signal: " + "4");
        holder.keyWifi.setText(wifiNetworks.get(position).capabilities);
    }

    @Override
    public int getItemCount() {
        return wifiNetworks.size();
    }

    private void onWifiClicked(int adapterPosition) {
        mainActivity.onWifiClick(adapterPosition);
    }

    public void updateWifiNetworks(ArrayList<ScanResult> list) {

        Log.d(TAG, "list.size() = " + list.size());

        this.wifiNetworks.clear();
        this.wifiNetworks.addAll(list);
        notifyDataSetChanged();
    }
}
