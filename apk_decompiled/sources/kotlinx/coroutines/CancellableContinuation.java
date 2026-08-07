package kotlinx.coroutines;

import defpackage.ar0;
import defpackage.x30;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
public interface CancellableContinuation<T> extends x30 {

    public static final class DefaultImpls {
        public static /* synthetic */ boolean cancel$default(CancellableContinuation cancellableContinuation, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                th = null;
            }
            return cancellableContinuation.cancel(th);
        }

        public static /* synthetic */ Object tryResume$default(CancellableContinuation cancellableContinuation, Object obj, Object obj2, int i, Object obj3) {
            if (obj3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
            }
            if ((i & 2) != 0) {
                obj2 = null;
            }
            return cancellableContinuation.tryResume(obj, obj2);
        }
    }

    boolean cancel(Throwable th);

    @InternalCoroutinesApi
    void completeResume(Object obj);

    @Override // defpackage.x30
    /* synthetic */ d getContext();

    @InternalCoroutinesApi
    void initCancellability();

    void invokeOnCancellation(ar0 ar0Var);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    @ExperimentalCoroutinesApi
    void resume(T t, ar0 ar0Var);

    @ExperimentalCoroutinesApi
    void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, T t);

    @ExperimentalCoroutinesApi
    void resumeUndispatchedWithException(CoroutineDispatcher coroutineDispatcher, Throwable th);

    @Override // defpackage.x30
    /* synthetic */ void resumeWith(Object obj);

    @InternalCoroutinesApi
    Object tryResume(T t, Object obj);

    @InternalCoroutinesApi
    Object tryResume(T t, Object obj, ar0 ar0Var);

    @InternalCoroutinesApi
    Object tryResumeWithException(Throwable th);
}
