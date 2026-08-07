package kotlinx.coroutines;

import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.d;
import kotlinx.coroutines.selects.SelectClause1;

/* JADX INFO: loaded from: classes4.dex */
public interface Deferred<T> extends Job {

    public static final class DefaultImpls {
        public static <T, R> R fold(Deferred<? extends T> deferred, R r, or0 or0Var) {
            return (R) Job.DefaultImpls.fold(deferred, r, or0Var);
        }

        public static <T, E extends d.b> E get(Deferred<? extends T> deferred, d.c cVar) {
            return (E) Job.DefaultImpls.get(deferred, cVar);
        }

        public static <T> d minusKey(Deferred<? extends T> deferred, d.c cVar) {
            return Job.DefaultImpls.minusKey(deferred, cVar);
        }

        public static <T> d plus(Deferred<? extends T> deferred, d dVar) {
            return Job.DefaultImpls.plus(deferred, dVar);
        }

        public static <T> Job plus(Deferred<? extends T> deferred, Job job) {
            return Job.DefaultImpls.plus((Job) deferred, job);
        }
    }

    Object await(x30 x30Var);

    @Override // kotlinx.coroutines.Job, kotlin.coroutines.d
    /* synthetic */ Object fold(Object obj, or0 or0Var);

    @Override // kotlinx.coroutines.Job, kotlin.coroutines.d.b, kotlin.coroutines.d
    /* synthetic */ d.b get(d.c cVar);

    @ExperimentalCoroutinesApi
    T getCompleted();

    @ExperimentalCoroutinesApi
    Throwable getCompletionExceptionOrNull();

    @Override // kotlinx.coroutines.Job, kotlin.coroutines.d.b
    /* synthetic */ d.c getKey();

    SelectClause1<T> getOnAwait();

    @Override // kotlinx.coroutines.Job, kotlin.coroutines.d
    /* synthetic */ d minusKey(d.c cVar);

    @Override // kotlinx.coroutines.Job, kotlin.coroutines.d
    /* synthetic */ d plus(d dVar);
}
