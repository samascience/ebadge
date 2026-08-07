package defpackage;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
final class as3 implements Runnable {
    private final /* synthetic */ zr3 a;

    as3(zr3 zr3Var) {
        this.a = zr3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.i.c(new ConnectionResult(4));
    }
}
