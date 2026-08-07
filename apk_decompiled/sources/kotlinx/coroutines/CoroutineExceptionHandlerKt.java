package kotlinx.coroutines;

import defpackage.oi0;
import defpackage.or0;
import kotlin.coroutines.d;
import kotlinx.coroutines.internal.CoroutineExceptionHandlerImpl_commonKt;

/* JADX INFO: loaded from: classes4.dex */
public final class CoroutineExceptionHandlerKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1, reason: invalid class name */
    public static final class AnonymousClass1 extends kotlin.coroutines.a implements CoroutineExceptionHandler {
        final /* synthetic */ or0 $handler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(or0 or0Var, CoroutineExceptionHandler.Key key) {
            super(key);
            this.$handler = or0Var;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(d dVar, Throwable th) {
            this.$handler.invoke(dVar, th);
        }
    }

    public static final CoroutineExceptionHandler CoroutineExceptionHandler(or0 or0Var) {
        return new AnonymousClass1(or0Var, CoroutineExceptionHandler.Key);
    }

    @InternalCoroutinesApi
    public static final void handleCoroutineException(d dVar, Throwable th) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) dVar.get(CoroutineExceptionHandler.Key);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(dVar, th);
            } else {
                CoroutineExceptionHandlerImpl_commonKt.handleUncaughtCoroutineException(dVar, th);
            }
        } catch (Throwable th2) {
            CoroutineExceptionHandlerImpl_commonKt.handleUncaughtCoroutineException(dVar, handlerException(th, th2));
        }
    }

    public static final Throwable handlerException(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        oi0.a(runtimeException, th);
        return runtimeException;
    }
}
