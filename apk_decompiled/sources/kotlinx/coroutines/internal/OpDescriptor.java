package kotlinx.coroutines.internal;

import kotlinx.coroutines.DebugStringsKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class OpDescriptor {
    public abstract AtomicOp<?> getAtomicOp();

    public abstract Object perform(Object obj);

    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this);
    }
}
