package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class c1 implements Runnable {
    private final /* synthetic */ b1 a;

    c1(b1 b1Var) {
        this.a = b1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.o.lock();
        try {
            this.a.y();
        } finally {
            this.a.o.unlock();
        }
    }
}
