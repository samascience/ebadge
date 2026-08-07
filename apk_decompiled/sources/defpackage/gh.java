package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
public class gh extends sn {
    private static final String i = fd1.f("BatteryChrgTracker");

    public gh(Context context, w03 w03Var) {
        super(context, w03Var);
    }

    private boolean j(Intent intent) {
        int intExtra = intent.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    @Override // defpackage.sn
    public IntentFilter g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.CHARGING");
        intentFilter.addAction("android.os.action.DISCHARGING");
        return intentFilter;
    }

    @Override // defpackage.sn
    public void h(Context context, Intent intent) {
        byte b = 0;
        String action = intent.getAction();
        if (action == null) {
        }
        fd1.c().a(i, String.format("Received %s", action), new Throwable[0]);
        switch (action.hashCode()) {
            case -1886648615:
                if (!action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                    b = -1;
                }
                break;
            case -54942926:
                b = !action.equals("android.os.action.DISCHARGING") ? (byte) -1 : (byte) 1;
                break;
            case 948344062:
                b = !action.equals("android.os.action.CHARGING") ? (byte) -1 : (byte) 2;
                break;
            case 1019184907:
                b = !action.equals("android.intent.action.ACTION_POWER_CONNECTED") ? (byte) -1 : (byte) 3;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                d(Boolean.FALSE);
                break;
            case 1:
                d(Boolean.FALSE);
                break;
            case 2:
                d(Boolean.TRUE);
                break;
            case 3:
                d(Boolean.TRUE);
                break;
        }
    }

    @Override // defpackage.m20
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Boolean b() {
        Intent intentRegisterReceiver = this.b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            return Boolean.valueOf(j(intentRegisterReceiver));
        }
        fd1.c().b(i, "getInitialState - null intent received", new Throwable[0]);
        return null;
    }
}
