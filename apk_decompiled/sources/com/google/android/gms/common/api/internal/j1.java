package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class j1 implements Runnable {
    final /* synthetic */ LifecycleCallback a;
    final /* synthetic */ String b;
    final /* synthetic */ zzb c;

    j1(zzb zzbVar, LifecycleCallback lifecycleCallback, String str) {
        this.c = zzbVar;
        this.a = lifecycleCallback;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzb zzbVar = this.c;
        if (zzbVar.b > 0) {
            this.a.e(zzbVar.c != null ? zzbVar.c.getBundle(this.b) : null);
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
