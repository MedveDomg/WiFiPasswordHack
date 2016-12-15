package com.wifipasshhhwi.wifipasswordhack.DialogAskTapjoyFragment;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by medvedomg on 15.12.16.
 */

public class DialogTapjoy extends DialogFragment implements DialogView{

    public static final String TAG = "DialogTapjoy";



    public DialogTapjoy() {

    }

    public static DialogTapjoy newInstance() {
        
        Bundle args = new Bundle();
        DialogTapjoy fragment = new DialogTapjoy();
        fragment.setArguments(args);
        return fragment;

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle("Get WiFI Password")
                .setMessage("Please download one of sponsor’s app and you will get the password  to WiFi network.")
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                onOkClicked();
                            }
                        }
                )
                .create();
    }

    @Override
    public void onOkClicked() {
        Log.d(TAG, "onOkClicked");

    }

    @Override
    public void onCancelClicked() {

    }
}
