package com.wifipasshhhwi.wifipasswordhack.data.model;

/**
 * Created by medvedomg on 14.12.16.
 */

public class Wifi {

    String name;

    int password;

    int signalQuality;



    public void setSignalQuality(int signalQuality) {
        this.signalQuality = signalQuality;
    }

    public int getSignalQuality() {

        return signalQuality;
    }


    public int getPassword() {
        return password;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
