package kotlinx.coroutines;

import defpackage.ar0;
import defpackage.p31;
import defpackage.x30;
import defpackage.y70;
import kotlin.coroutines.b;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.LimitedDispatcher;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CoroutineDispatcher extends kotlin.coroutines.a implements c {
    public static final Key Key = new Key(null);

    public static final class Key extends b {
        public /* synthetic */ Key(y70 y70Var) {
            this();
        }

        private Key() {
            super(c.E, new ar0() { // from class: kotlinx.coroutines.CoroutineDispatcher.Key.1
                @Override // defpackage.ar0
                public final CoroutineDispatcher invoke(d.b bVar) {
                    if (bVar instanceof CoroutineDispatcher) {
                        return (CoroutineDispatcher) bVar;
                    }
                    return null;
                }
            });
        }
    }

    public CoroutineDispatcher() {
        super(c.E);
    }

    /* JADX INFO: renamed from: dispatch */
    public abstract void mo149dispatch(d dVar, Runnable runnable);

    @InternalCoroutinesApi
    public void dispatchYield(d dVar, Runnable runnable) {
        mo149dispatch(dVar, runnable);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.d.b, kotlin.coroutines.d
    public <E extends d.b> E get(d.c cVar) {
        return (E) c.a.a(this, cVar);
    }

    @Override // kotlin.coroutines.c
    public final <T> x30 interceptContinuation(x30 x30Var) {
        return new DispatchedContinuation(this, x30Var);
    }

    public boolean isDispatchNeeded(d dVar) {
        return true;
    }

    @ExperimentalCoroutinesApi
    public CoroutineDispatcher limitedParallelism(int i) {
        LimitedDispatcherKt.checkParallelism(i);
        return new LimitedDispatcher(this, i);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.d
    public d minusKey(d.c cVar) {
        return c.a.b(this, cVar);
    }

    public final CoroutineDispatcher plus(CoroutineDispatcher coroutineDispatcher) {
        return coroutineDispatcher;
    }

    @Override // kotlin.coroutines.c
    public final void releaseInterceptedContinuation(x30 x30Var) {
        p31.d(x30Var, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((DispatchedContinuation) x30Var).release$kotlinx_coroutines_core();
    }

    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this);
    }
}
