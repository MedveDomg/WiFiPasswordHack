package com.wifipasshhhwi.wifipasswordhack.loader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.wifipasshhhwi.wifipasswordhack.R;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

import static android.R.id.progress;

public class LoaderActivityImpl extends AppCompatActivity {

    RingProgressBar mRingProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loader_activity);

        mRingProgressBar = (RingProgressBar) findViewById(R.id.progress_bar_1);

        // Set the progress bar's progress
        mRingProgressBar.setProgress(progress);
        mRingProgressBar.setOnProgressListener(new RingProgressBar.OnProgressListener()
        {

            @Override
            public void progressToComplete()
            {
                // Progress reaches the maximum callback default Max value is 100
                Toast.makeText(LoaderActivityImpl.this, "complete", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
