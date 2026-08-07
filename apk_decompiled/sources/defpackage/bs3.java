package defpackage;

import com.google.android.gms.signin.internal.zaj;

/* JADX INFO: loaded from: classes.dex */
final class bs3 implements Runnable {
    private final /* synthetic */ zaj a;
    private final /* synthetic */ zr3 b;

    bs3(zr3 zr3Var, zaj zajVar) {
        this.b = zr3Var;
        this.a = zajVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.N(this.a);
    }
}
