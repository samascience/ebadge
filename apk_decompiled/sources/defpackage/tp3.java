package defpackage;

import android.location.Location;

/* JADX INFO: loaded from: classes.dex */
class tp3 implements Runnable {
    final /* synthetic */ Location a;
    final /* synthetic */ pp3 b;

    tp3(pp3 pp3Var, Location location) {
        this.b = pp3Var;
        this.a = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.m(this.a);
    }
}
