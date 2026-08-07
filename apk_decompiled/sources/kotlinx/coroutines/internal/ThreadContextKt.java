package kotlinx.coroutines.internal;

import defpackage.or0;
import defpackage.p31;
import kotlin.coroutines.d;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: loaded from: classes4.dex */
public final class ThreadContextKt {
    public static final Symbol NO_THREAD_ELEMENTS = new Symbol("NO_THREAD_ELEMENTS");
    private static final or0 countAll = new or0() { // from class: kotlinx.coroutines.internal.ThreadContextKt$countAll$1
        @Override // defpackage.or0
        public final Object invoke(Object obj, d.b bVar) {
            if (!(bVar instanceof ThreadContextElement)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? bVar : Integer.valueOf(iIntValue + 1);
        }
    };
    private static final or0 findOne = new or0() { // from class: kotlinx.coroutines.internal.ThreadContextKt$findOne$1
        @Override // defpackage.or0
        public final ThreadContextElement<?> invoke(ThreadContextElement<?> threadContextElement, d.b bVar) {
            if (threadContextElement != null) {
                return threadContextElement;
            }
            if (bVar instanceof ThreadContextElement) {
                return (ThreadContextElement) bVar;
            }
            return null;
        }
    };
    private static final or0 updateState = new or0() { // from class: kotlinx.coroutines.internal.ThreadContextKt$updateState$1
        @Override // defpackage.or0
        public final ThreadState invoke(ThreadState threadState, d.b bVar) {
            if (bVar instanceof ThreadContextElement) {
                ThreadContextElement<?> threadContextElement = (ThreadContextElement) bVar;
                threadState.append(threadContextElement, threadContextElement.updateThreadContext(threadState.context));
            }
            return threadState;
        }
    };

    public static final void restoreThreadContext(d dVar, Object obj) {
        if (obj == NO_THREAD_ELEMENTS) {
            return;
        }
        if (obj instanceof ThreadState) {
            ((ThreadState) obj).restore(dVar);
            return;
        }
        Object objFold = dVar.fold(null, findOne);
        p31.d(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((ThreadContextElement) objFold).restoreThreadContext(dVar, obj);
    }

    public static final Object threadContextElements(d dVar) {
        Object objFold = dVar.fold(0, countAll);
        p31.c(objFold);
        return objFold;
    }

    public static final Object updateThreadContext(d dVar, Object obj) {
        if (obj == null) {
            obj = threadContextElements(dVar);
        }
        if (obj == 0) {
            return NO_THREAD_ELEMENTS;
        }
        if (obj instanceof Integer) {
            return dVar.fold(new ThreadState(dVar, ((Number) obj).intValue()), updateState);
        }
        p31.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((ThreadContextElement) obj).updateThreadContext(dVar);
    }
}
