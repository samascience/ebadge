package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class k1 implements Runnable {
    final /* synthetic */ LifecycleCallback a;
    final /* synthetic */ String b;
    final /* synthetic */ zzd c;

    k1(zzd zzdVar, LifecycleCallback lifecycleCallback, String str) {
        this.c = zzdVar;
        this.a = lifecycleCallback;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzd zzdVar = this.c;
        if (zzdVar.b > 0) {
            this.a.e(zzdVar.c != null ? zzdVar.c.getBundle(this.b) : null);
        }
        if (this.c.b >= 2) {
            this.a.i();
        }
        if (this.c.b >= 3) {
            this.a.g();
        }
        if (this.c.b >= 4) {
            this.a.j();
        }
        if (this.c.b >= 5) {
            this.a.f();
        }
    }
}
