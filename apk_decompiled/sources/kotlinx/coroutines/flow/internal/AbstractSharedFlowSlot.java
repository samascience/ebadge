package kotlinx.coroutines.flow.internal;

import defpackage.x30;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractSharedFlowSlot<F> {
    public abstract boolean allocateLocked(F f);

    public abstract x30[] freeLocked(F f);
}
