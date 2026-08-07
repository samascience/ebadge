package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
public abstract class sn extends m20 {
    private static final String h = fd1.f("BrdcstRcvrCnstrntTrckr");
    private final BroadcastReceiver g;

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                sn.this.h(context, intent);
            }
        }
    }

    public sn(Context context, w03 w03Var) {
        super(context, w03Var);
        this.g = new a();
    }

    @Override // defpackage.m20
    public void e() {
        fd1.c().a(h, String.format("%s: registering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.b.registerReceiver(this.g, g());
    }

    @Override // defpackage.m20
    public void f() {
        fd1.c().a(h, String.format("%s: unregistering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.b.unregisterReceiver(this.g);
    }

    public abstract IntentFilter g();

    public abstract void h(Context context, Intent intent);
}
