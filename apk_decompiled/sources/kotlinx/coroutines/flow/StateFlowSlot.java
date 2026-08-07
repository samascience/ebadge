package kotlinx.coroutines.flow;

import defpackage.ar0;
import defpackage.j70;
import defpackage.k83;
import defpackage.p31;
import defpackage.q1;
import defpackage.x30;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.intrinsics.a;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

/* JADX INFO: loaded from: classes4.dex */
final class StateFlowSlot extends AbstractSharedFlowSlot<StateFlowImpl<?>> {
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowSlot.class, Object.class, "_state");
    private volatile Object _state;

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ar0 ar0Var, Object obj) {
        while (true) {
            ar0Var.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    public final Object awaitPending(x30 x30Var) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(a.c(x30Var), 1);
        cancellableContinuationImpl.initCancellability();
        if (!q1.a(_state$FU, this, StateFlowKt.NONE, cancellableContinuationImpl)) {
            Result.a aVar = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m69constructorimpl(k83.a));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == a.d()) {
            j70.c(x30Var);
        }
        return result == a.d() ? result : k83.a;
    }

    public final void makePending() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null || obj == StateFlowKt.PENDING) {
                return;
            }
            if (obj == StateFlowKt.NONE) {
                if (q1.a(_state$FU, this, obj, StateFlowKt.PENDING)) {
                    return;
                }
            } else if (q1.a(_state$FU, this, obj, StateFlowKt.NONE)) {
                Result.a aVar = Result.Companion;
                ((CancellableContinuationImpl) obj).resumeWith(Result.m69constructorimpl(k83.a));
                return;
            }
        }
    }

    public final boolean takePending() {
        Object andSet = _state$FU.getAndSet(this, StateFlowKt.NONE);
        p31.c(andSet);
        return andSet == StateFlowKt.PENDING;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public boolean allocateLocked(StateFlowImpl<?> stateFlowImpl) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        if (atomicReferenceFieldUpdater.get(this) != null) {
            return false;
        }
        atomicReferenceFieldUpdater.set(this, StateFlowKt.NONE);
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public x30[] freeLocked(StateFlowImpl<?> stateFlowImpl) {
        _state$FU.set(this, null);
        return AbstractSharedFlowKt.EMPTY_RESUMES;
    }
}
