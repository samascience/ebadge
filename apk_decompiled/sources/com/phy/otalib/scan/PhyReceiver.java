package com.phy.otalib.scan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import defpackage.qd2;

/* JADX INFO: loaded from: classes.dex */
public class PhyReceiver extends BroadcastReceiver {
    public static final String c = "PhyReceiver";
    private qd2 a;
    private int b = 0;

    public static boolean a(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode") != 0;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void b(qd2 qd2Var) {
        this.a = qd2Var;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
            switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE)) {
                case 10:
                    Log.d(c, "STATE_OFF Phone bluetooth off");
                    break;
                case 11:
                    Log.d(c, "STATE_TURNING_ON Phone bluetooth is on");
                    break;
                case 12:
                    Log.d(c, "STATE_ON Phone bluetooth turned on");
                    break;
                case 13:
                    this.a.bluetoothClose();
                    Log.d(c, "STATE_TURNING_OFF Phone bluetooth is turning off");
                    break;
            }
        }
        if (!action.equals("android.location.PROVIDERS_CHANGED") || a(context)) {
            return;
        }
        int i = this.b + 1;
        this.b = i;
        if (i == 1) {
            Log.d(c, "Positioning off");
            this.a.locationClose();
        } else if (i == 4) {
            this.b = 0;
        }
    }
}
