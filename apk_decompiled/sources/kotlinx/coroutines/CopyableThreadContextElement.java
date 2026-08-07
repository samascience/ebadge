package kotlinx.coroutines;

import defpackage.or0;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
@DelicateCoroutinesApi
@ExperimentalCoroutinesApi
public interface CopyableThreadContextElement<S> extends ThreadContextElement<S> {

    public static final class DefaultImpls {
        public static <S, R> R fold(CopyableThreadContextElement<S> copyableThreadContextElement, R r, or0 or0Var) {
            return (R) ThreadContextElement.DefaultImpls.fold(copyableThreadContextElement, r, or0Var);
        }

        public static <S, E extends d.b> E get(CopyableThreadContextElement<S> copyableThreadContextElement, d.c cVar) {
            return (E) ThreadContextElement.DefaultImpls.get(copyableThreadContextElement, cVar);
        }

        public static <S> d minusKey(CopyableThreadContextElement<S> copyableThreadContextElement, d.c cVar) {
            return ThreadContextElement.DefaultImpls.minusKey(copyableThreadContextElement, cVar);
        }

        public static <S> d plus(CopyableThreadContextElement<S> copyableThreadContextElement, d dVar) {
            return ThreadContextElement.DefaultImpls.plus(copyableThreadContextElement, dVar);
        }
    }

    CopyableThreadContextElement<S> copyForChild();

    @Override // kotlinx.coroutines.ThreadContextElement, kotlin.coroutines.d
    /* synthetic */ Object fold(Object obj, or0 or0Var);

    @Override // kotlinx.coroutines.ThreadContextElement, kotlin.coroutines.d.b, kotlin.coroutines.d
    /* synthetic */ d.b get(d.c cVar);

    @Override // kotlinx.coroutines.ThreadContextElement, kotlin.coroutines.d.b
    /* synthetic */ d.c getKey();

    d mergeForChild(d.b bVar);

    @Override // kotlinx.coroutines.ThreadContextElement, kotlin.coroutines.d
    /* synthetic */ d minusKey(d.c cVar);

    @Override // kotlinx.coroutines.ThreadContextElement, kotlin.coroutines.d
    /* synthetic */ d plus(d dVar);
}
