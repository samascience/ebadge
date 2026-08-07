package kotlinx.coroutines;

import defpackage.or0;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
public interface CompletableDeferred<T> extends Deferred<T> {

    public static final class DefaultImpls {
        public static <T, R> R fold(CompletableDeferred<T> completableDeferred, R r, or0 or0Var) {
            return (R) Deferred.DefaultImpls.fold(completableDeferred, r, or0Var);
        }

        public static <T, E extends d.b> E get(CompletableDeferred<T> completableDeferred, d.c cVar) {
            return (E) Deferred.DefaultImpls.get(completableDeferred, cVar);
        }

        public static <T> d minusKey(CompletableDeferred<T> completableDeferred, d.c cVar) {
            return Deferred.DefaultImpls.minusKey(completableDeferred, cVar);
        }

        public static <T> d plus(CompletableDeferred<T> completableDeferred, d dVar) {
            return Deferred.DefaultImpls.plus(completableDeferred, dVar);
        }

        public static <T> Job plus(CompletableDeferred<T> completableDeferred, Job job) {
            return Deferred.DefaultImpls.plus((Deferred) completableDeferred, job);
        }
    }

    boolean complete(T t);

    boolean completeExceptionally(Throwable th);

    @Override // kotlinx.coroutines.Deferred, kotlinx.coroutines.Job, kotlin.coroutines.d
    /* synthetic */ Object fold(Object obj, or0 or0Var);

    @Override // kotlinx.coroutines.Deferred, kotlinx.coroutines.Job, kotlin.coroutines.d.b, kotlin.coroutines.d
    /* synthetic */ d.b get(d.c cVar);

    @Override // kotlinx.coroutines.Deferred, kotlinx.coroutines.Job, kotlin.coroutines.d.b
    /* synthetic */ d.c getKey();

    @Override // kotlinx.coroutines.Deferred, kotlinx.coroutines.Job, kotlin.coroutines.d
    /* synthetic */ d minusKey(d.c cVar);

    @Override // kotlinx.coroutines.Deferred, kotlinx.coroutines.Job, kotlin.coroutines.d
    /* synthetic */ d plus(d dVar);
}
