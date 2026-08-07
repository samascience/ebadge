package kotlinx.coroutines.internal;

import defpackage.ar0;
import defpackage.k83;
import defpackage.oi0;
import kotlin.coroutines.d;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

/* JADX INFO: loaded from: classes4.dex */
public final class OnUndeliveredElementKt {
    public static final <E> ar0 bindCancellationFun(final ar0 ar0Var, final E e, final d dVar) {
        return new ar0() { // from class: kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // defpackage.ar0
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return k83.a;
            }

            public final void invoke(Throwable th) {
                OnUndeliveredElementKt.callUndeliveredElement(ar0Var, e, dVar);
            }
        };
    }

    public static final <E> void callUndeliveredElement(ar0 ar0Var, E e, d dVar) {
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException = callUndeliveredElementCatchingException(ar0Var, e, null);
        if (undeliveredElementExceptionCallUndeliveredElementCatchingException != null) {
            CoroutineExceptionHandlerKt.handleCoroutineException(dVar, undeliveredElementExceptionCallUndeliveredElementCatchingException);
        }
    }

    public static final <E> UndeliveredElementException callUndeliveredElementCatchingException(ar0 ar0Var, E e, UndeliveredElementException undeliveredElementException) {
        try {
            ar0Var.invoke(e);
        } catch (Throwable th) {
            if (undeliveredElementException == null || undeliveredElementException.getCause() == th) {
                return new UndeliveredElementException("Exception in undelivered element handler for " + e, th);
            }
            oi0.a(undeliveredElementException, th);
        }
        return undeliveredElementException;
    }

    public static /* synthetic */ UndeliveredElementException callUndeliveredElementCatchingException$default(ar0 ar0Var, Object obj, UndeliveredElementException undeliveredElementException, int i, Object obj2) {
        if ((i & 2) != 0) {
            undeliveredElementException = null;
        }
        return callUndeliveredElementCatchingException(ar0Var, obj, undeliveredElementException);
    }
}
