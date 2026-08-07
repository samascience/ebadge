package kotlinx.coroutines.debug.internal;

import defpackage.y70;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: Access modifiers changed from: private */
/* JADX INFO: loaded from: classes4.dex */
public final class DebugProbesImpl$Installations$kotlinx$VolatileWrapper {
    private static final AtomicIntegerFieldUpdater installations$FU = AtomicIntegerFieldUpdater.newUpdater(DebugProbesImpl$Installations$kotlinx$VolatileWrapper.class, "installations");
    private volatile int installations;

    private DebugProbesImpl$Installations$kotlinx$VolatileWrapper() {
    }

    public /* synthetic */ DebugProbesImpl$Installations$kotlinx$VolatileWrapper(y70 y70Var) {
        this();
    }
}
