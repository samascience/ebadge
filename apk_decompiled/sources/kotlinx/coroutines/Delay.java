package kotlinx.coroutines;

import defpackage.j70;
import defpackage.k83;
import defpackage.x30;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
@InternalCoroutinesApi
public interface Delay {

    public static final class DefaultImpls {
        public static Object delay(Delay delay, long j, x30 x30Var) {
            if (j <= 0) {
                return k83.a;
            }
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.coroutines.intrinsics.a.c(x30Var), 1);
            cancellableContinuationImpl.initCancellability();
            delay.mo150scheduleResumeAfterDelay(j, cancellableContinuationImpl);
            Object result = cancellableContinuationImpl.getResult();
            if (result == kotlin.coroutines.intrinsics.a.d()) {
                j70.c(x30Var);
            }
            return result == kotlin.coroutines.intrinsics.a.d() ? result : k83.a;
        }

        public static DisposableHandle invokeOnTimeout(Delay delay, long j, Runnable runnable, d dVar) {
            return DefaultExecutorKt.getDefaultDelay().invokeOnTimeout(j, runnable, dVar);
        }
    }

    Object delay(long j, x30 x30Var);

    DisposableHandle invokeOnTimeout(long j, Runnable runnable, d dVar);

    /* JADX INFO: renamed from: scheduleResumeAfterDelay */
    void mo150scheduleResumeAfterDelay(long j, CancellableContinuation<? super k83> cancellableContinuation);
}
