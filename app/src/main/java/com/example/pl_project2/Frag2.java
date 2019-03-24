package com.example.pl_project2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Frag2 extends android.support.v4.app.DialogFragment{

    public String s1 ="WARNING!";
    public String s2 = "When using a guest account, your data will be lost when exiting the app.";
    public Frag2() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag2, container, false);
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder adb =  new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme).setTitle(s1).setMessage(s2);
        adb.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent i = new Intent("com.example.pl_project2.Clothes");
                startActivity(i);
            }
        });
        adb.setNeutralButton("Return", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        adb.setCancelable(true);

        final AlertDialog ad = adb.create();
        final Button[] b = new Button[1];
        final Button[] b2 = new Button[1];
        ad.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(final DialogInterface dialog) {
                b[0] = ad.getButton(DialogInterface.BUTTON_POSITIVE);
                b2[0] = ad.getButton(DialogInterface.BUTTON_NEGATIVE);


            }
        });

        return ad;
    }
}
