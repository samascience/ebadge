package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class k implements Runnable {
    private final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d.a(this.a.c);
    }
}
