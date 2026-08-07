package kotlinx.coroutines;

import defpackage.j21;
import defpackage.jn;
import defpackage.k83;
import defpackage.x30;
import kotlinx.coroutines.internal.ThreadLocalElement;
import kotlinx.coroutines.internal.ThreadLocalKey;

/* JADX INFO: loaded from: classes4.dex */
public final class ThreadContextElementKt {
    public static final <T> ThreadContextElement<T> asContextElement(ThreadLocal<T> threadLocal, T t) {
        return new ThreadLocalElement(t, threadLocal);
    }

    public static /* synthetic */ ThreadContextElement asContextElement$default(ThreadLocal threadLocal, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = threadLocal.get();
        }
        return asContextElement(threadLocal, obj);
    }

    public static final Object ensurePresent(ThreadLocal<?> threadLocal, x30 x30Var) {
        if (x30Var.getContext().get(new ThreadLocalKey(threadLocal)) != null) {
            return k83.a;
        }
        throw new IllegalStateException(("ThreadLocal " + threadLocal + " is missing from context " + x30Var.getContext()).toString());
    }

    private static final Object ensurePresent$$forInline(ThreadLocal<?> threadLocal, x30 x30Var) {
        j21.c(3);
        throw null;
    }

    public static final Object isPresent(ThreadLocal<?> threadLocal, x30 x30Var) {
        return jn.a(x30Var.getContext().get(new ThreadLocalKey(threadLocal)) != null);
    }

    private static final Object isPresent$$forInline(ThreadLocal<?> threadLocal, x30 x30Var) {
        j21.c(3);
        throw null;
    }
}
