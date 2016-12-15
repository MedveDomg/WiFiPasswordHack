package com.wifipasshhhwi.wifipasswordhack.loader;

import com.wifipasshhhwi.wifipasswordhack.start.StartModel;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

/**
 * Created by medvedomg on 15.12.16.
 */

public interface LoaderModel {

    void loadingProgressBar(ResultListener listener, RingProgressBar progressBar);

    interface ResultListener {
        void OnSucces();
    }
}
