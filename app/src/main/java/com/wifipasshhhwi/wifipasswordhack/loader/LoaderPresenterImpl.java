package com.wifipasshhhwi.wifipasswordhack.loader;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.wifipasshhhwi.wifipasswordhack.DialogAskTapjoyFragment.DialogTapjoy;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

/**
 * Created by medvedomg on 15.12.16.
 */

public class LoaderPresenterImpl implements LoaderPresenter, LoaderModel.ResultListener {

    private RingProgressBar ringProgressBar;

    LoaderView loaderView;
    LoaderModel loaderModel;

    public static final String TAG = "LoaderPresenter";

    FragmentManager manager;

    DialogTapjoy dialogTapjoy;

    Context context;


    public LoaderPresenterImpl(LoaderView view, RingProgressBar ringProgressBar, FragmentManager manager, DialogTapjoy dialogTapjoy) {

        this.ringProgressBar = ringProgressBar;
        loaderModel = new LoaderFakeDownload();
        this.loaderView = view;
        this.manager = manager;
        this.dialogTapjoy = dialogTapjoy;
        this.context = context;
    }

    @Override
    public void OnSucces() {
        Log.d(TAG, "onSucces");
        navigateToLoader();
    }

    @Override
    public void startProgressBar() {
        loaderModel.loadingProgressBar(this, ringProgressBar);
    }

    @Override
    public void navigateToLoader() {
        loaderView.askDialogToDownload();
    }

    @Override
    public void startDialog() {
        Log.d(TAG, "startDialog()");
        dialogTapjoy = new DialogTapjoy();
        dialogTapjoy.show(manager, "dialog_tapjoy");
    }
}
