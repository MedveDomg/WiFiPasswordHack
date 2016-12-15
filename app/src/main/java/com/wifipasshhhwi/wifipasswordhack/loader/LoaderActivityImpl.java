package com.wifipasshhhwi.wifipasswordhack.loader;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.wifipasshhhwi.wifipasswordhack.DialogAskTapjoyFragment.DialogTapjoy;
import com.wifipasshhhwi.wifipasswordhack.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.netopen.hotbitmapgg.library.view.RingProgressBar;

import static android.R.id.progress;

public class LoaderActivityImpl extends AppCompatActivity implements LoaderView{

    @BindView(R.id.progress_bar)
    RingProgressBar mRingProgressBar;

    LoaderPresenterImpl presenter;

    public static final String TAG = "LoaderActivity";

    DialogTapjoy dialogTapjoy;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loader_activity);
        ButterKnife.bind(this);

        manager = getSupportFragmentManager();..

        presenter = new LoaderPresenterImpl(this, mRingProgressBar, manager, dialogTapjoy);
        askStartLoadingProgressBar();
//        mRingProgressBar = (RingProgressBar) findViewById(R.id.progress_bar_1);
//
//        // Set the progress bar's progress
//        mRingProgressBar.setProgress(progress);
//        mRingProgressBar.setOnProgressListener(new RingProgressBar.OnProgressListener()
//        {
//
//            @Override
//            public void progressToComplete()
//            {
//                // Progress reaches the maximum callback default Max value is 100
//                Toast.makeText(LoaderActivityImpl.this, "complete", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    public void askStartLoadingProgressBar() {
        presenter.startProgressBar();
    }

    @Override
    public void askDialogToDownload() {
        Log.d(TAG, "askDialogDownload");
        presenter.startDialog();
    }
}
