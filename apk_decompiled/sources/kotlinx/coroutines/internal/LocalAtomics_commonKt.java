package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class LocalAtomics_commonKt {
    public static final int getValue(AtomicInteger atomicInteger) {
        return atomicInteger.get();
    }

    public static final void setValue(AtomicInteger atomicInteger, int i) {
        atomicInteger.set(i);
    }
}
