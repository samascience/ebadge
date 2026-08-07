package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class l0 implements Runnable {
    private final /* synthetic */ k0 a;

    l0(k0 k0Var) {
        this.a = k0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.d.disconnect();
    }
}
