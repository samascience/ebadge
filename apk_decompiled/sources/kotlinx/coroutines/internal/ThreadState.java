package kotlinx.coroutines.internal;

import defpackage.p31;
import kotlin.coroutines.d;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: loaded from: classes4.dex */
final class ThreadState {
    public final d context;
    private final ThreadContextElement<Object>[] elements;
    private int i;
    private final Object[] values;

    public ThreadState(d dVar, int i) {
        this.context = dVar;
        this.values = new Object[i];
        this.elements = new ThreadContextElement[i];
    }

    public final void append(ThreadContextElement<?> threadContextElement, Object obj) {
        Object[] objArr = this.values;
        int i = this.i;
        objArr[i] = obj;
        ThreadContextElement<Object>[] threadContextElementArr = this.elements;
        this.i = i + 1;
        p31.d(threadContextElement, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        threadContextElementArr[i] = threadContextElement;
    }

    public final void restore(d dVar) {
        int length = this.elements.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            ThreadContextElement<Object> threadContextElement = this.elements[length];
            p31.c(threadContextElement);
            threadContextElement.restoreThreadContext(dVar, this.values[length]);
            if (i < 0) {
                return;
            } else {
                length = i;
            }
        }
    }
}
