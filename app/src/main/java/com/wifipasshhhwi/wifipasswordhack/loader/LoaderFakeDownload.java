package com.wifipasshhhwi.wifipasswordhack.loader;

import android.content.Intent;
import android.os.AsyncTask;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

/**
 * Created by medvedomg on 15.12.16.
 */

public class LoaderFakeDownload implements LoaderModel {


    @Override
    public void loadingProgressBar(final ResultListener listener, final RingProgressBar progressBar) {
        new AsyncTask<Integer, Integer, Void>() {


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar.setProgress(0);
                progressBar.setMax(70);
            }

            @Override
            protected Void doInBackground(Integer... integers) {
                for (int i = 0; i < integers[0] + 1; i++) {
                    if ((i % 10) == 0) {
                        try {
                            Thread.sleep(1000);
                            publishProgress(i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                progressBar.setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                listener.OnSucces();
            }
        }.execute(70);

    }
}
