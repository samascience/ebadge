package xfkj.fitpro.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import defpackage.d20;
import defpackage.di0;
import defpackage.ek;
import defpackage.p31;

/* JADX INFO: loaded from: classes4.dex */
public final class BluetoothAdapterStateReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (p31.a(intent != null ? intent.getAction() : null, "android.bluetooth.adapter.action.STATE_CHANGED")) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
            if (intExtra == 10 || intExtra == 13) {
                d20.a = 0;
                di0.a(new ek(false));
            }
        }
    }
}
