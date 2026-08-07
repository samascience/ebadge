package kotlinx.coroutines;

import defpackage.or0;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
@InternalCoroutinesApi
public interface ParentJob extends Job {

    public static final class DefaultImpls {
        public static <R> R fold(ParentJob parentJob, R r, or0 or0Var) {
            return (R) Job.DefaultImpls.fold(parentJob, r, or0Var);
        }

        public static <E extends d.b> E get(ParentJob parentJob, d.c cVar) {
            return (E) Job.DefaultImpls.get(parentJob, cVar);
        }

        public static d minusKey(ParentJob parentJob, d.c cVar) {
            return Job.DefaultImpls.minusKey(parentJob, cVar);
        }

        public static d plus(ParentJob parentJob, d dVar) {
            return Job.DefaultImpls.plus(parentJob, dVar);
        }

        public static Job plus(ParentJob parentJob, Job job) {
            return Job.DefaultImpls.plus((Job) parentJob, job);
        }
    }

    @Override // kotlinx.coroutines.Job, kotlin.coroutines.d
    /* synthetic */ Object fold(Object obj, or0 or0Var);

    @Override // kotlinx.coroutines.Job, kotlin.coroutines.d.b, kotlin.coroutines.d
    /* synthetic */ d.b get(d.c cVar);

    @InternalCoroutinesApi
    CancellationException getChildJobCancellationCause();

    @Override // kotlinx.coroutines.Job, kotlin.coroutines.d.b
    /* synthetic */ d.c getKey();

    @Override // kotlinx.coroutines.Job, kotlin.coroutines.d
    /* synthetic */ d minusKey(d.c cVar);

    @Override // kotlinx.coroutines.Job, kotlin.coroutines.d
    /* synthetic */ d plus(d dVar);
}
