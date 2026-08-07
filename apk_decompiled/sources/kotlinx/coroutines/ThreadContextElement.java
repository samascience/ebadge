package kotlinx.coroutines;

import defpackage.or0;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
public interface ThreadContextElement<S> extends d.b {

    public static final class DefaultImpls {
        public static <S, R> R fold(ThreadContextElement<S> threadContextElement, R r, or0 or0Var) {
            return (R) d.b.a.a(threadContextElement, r, or0Var);
        }

        public static <S, E extends d.b> E get(ThreadContextElement<S> threadContextElement, d.c cVar) {
            return (E) d.b.a.b(threadContextElement, cVar);
        }

        public static <S> d minusKey(ThreadContextElement<S> threadContextElement, d.c cVar) {
            return d.b.a.c(threadContextElement, cVar);
        }

        public static <S> d plus(ThreadContextElement<S> threadContextElement, d dVar) {
            return d.b.a.d(threadContextElement, dVar);
        }
    }

    @Override // kotlin.coroutines.d
    /* synthetic */ Object fold(Object obj, or0 or0Var);

    @Override // kotlin.coroutines.d.b, kotlin.coroutines.d
    /* synthetic */ d.b get(d.c cVar);

    @Override // kotlin.coroutines.d.b
    /* synthetic */ d.c getKey();

    @Override // kotlin.coroutines.d
    /* synthetic */ d minusKey(d.c cVar);

    @Override // kotlin.coroutines.d
    /* synthetic */ d plus(d dVar);

    void restoreThreadContext(d dVar, S s);

    S updateThreadContext(d dVar);
}
