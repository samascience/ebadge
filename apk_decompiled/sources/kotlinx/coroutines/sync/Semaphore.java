package kotlinx.coroutines.sync;

import defpackage.x30;

/* JADX INFO: loaded from: classes4.dex */
public interface Semaphore {
    Object acquire(x30 x30Var);

    int getAvailablePermits();

    void release();

    boolean tryAcquire();
}
