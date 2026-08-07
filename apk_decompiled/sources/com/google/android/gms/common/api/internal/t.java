package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
abstract class t implements Runnable {
    private final /* synthetic */ j a;

    private t(j jVar) {
        this.a = jVar;
    }

    protected abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        this.a.b.lock();
        try {
            if (Thread.interrupted()) {
                return;
            }
            a();
            return;
        } catch (RuntimeException e) {
            this.a.a.n(e);
            return;
        } finally {
            this.a.b.unlock();
        }
        this.a.b.unlock();
    }

    /* synthetic */ t(j jVar, k kVar) {
        this(jVar);
    }
}
