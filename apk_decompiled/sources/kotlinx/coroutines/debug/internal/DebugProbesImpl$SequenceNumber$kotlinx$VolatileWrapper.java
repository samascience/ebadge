package kotlinx.coroutines.debug.internal;

import defpackage.y70;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: Access modifiers changed from: private */
/* JADX INFO: loaded from: classes4.dex */
public final class DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper {
    private static final AtomicLongFieldUpdater sequenceNumber$FU = AtomicLongFieldUpdater.newUpdater(DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper.class, "sequenceNumber");
    private volatile long sequenceNumber;

    private DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper() {
    }

    public /* synthetic */ DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper(y70 y70Var) {
        this();
    }
}
