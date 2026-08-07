package kotlinx.coroutines.internal;

import defpackage.or0;
import defpackage.p31;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: loaded from: classes4.dex */
public final class ThreadLocalElement<T> implements ThreadContextElement<T> {
    private final d.c key;
    private final ThreadLocal<T> threadLocal;
    private final T value;

    public ThreadLocalElement(T t, ThreadLocal<T> threadLocal) {
        this.value = t;
        this.threadLocal = threadLocal;
        this.key = new ThreadLocalKey(threadLocal);
    }

    @Override // kotlinx.coroutines.ThreadContextElement, kotlin.coroutines.d
    public <R> R fold(R r, or0 or0Var) {
        return (R) ThreadContextElement.DefaultImpls.fold(this, r, or0Var);
    }

    @Override // kotlinx.coroutines.ThreadContextElement, kotlin.coroutines.d.b, kotlin.coroutines.d
    public <E extends d.b> E get(d.c cVar) {
        if (!p31.a(getKey(), cVar)) {
            return null;
        }
        p31.d(this, "null cannot be cast to non-null type E of kotlinx.coroutines.internal.ThreadLocalElement.get");
        return this;
    }

    @Override // kotlinx.coroutines.ThreadContextElement, kotlin.coroutines.d.b
    public d.c getKey() {
        return this.key;
    }

    @Override // kotlinx.coroutines.ThreadContextElement, kotlin.coroutines.d
    public d minusKey(d.c cVar) {
        return p31.a(getKey(), cVar) ? EmptyCoroutineContext.INSTANCE : this;
    }

    @Override // kotlinx.coroutines.ThreadContextElement, kotlin.coroutines.d
    public d plus(d dVar) {
        return ThreadContextElement.DefaultImpls.plus(this, dVar);
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public void restoreThreadContext(d dVar, T t) {
        this.threadLocal.set(t);
    }

    public String toString() {
        return "ThreadLocal(value=" + this.value + ", threadLocal = " + this.threadLocal + ')';
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public T updateThreadContext(d dVar) {
        T t = this.threadLocal.get();
        this.threadLocal.set(this.value);
        return t;
    }
}
