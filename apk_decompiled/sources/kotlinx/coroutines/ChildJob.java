package kotlinx.coroutines;

import defpackage.or0;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
@InternalCoroutinesApi
public interface ChildJob extends Job {

    public static final class DefaultImpls {
        public static <R> R fold(ChildJob childJob, R r, or0 or0Var) {
            return (R) Job.DefaultImpls.fold(childJob, r, or0Var);
        }

        public static <E extends d.b> E get(ChildJob childJob, d.c cVar) {
            return (E) Job.DefaultImpls.get(childJob, cVar);
        }

        public static d minusKey(ChildJob childJob, d.c cVar) {
            return Job.DefaultImpls.minusKey(childJob, cVar);
        }

        public static d plus(ChildJob childJob, d dVar) {
            return Job.DefaultImpls.plus(childJob, dVar);
        }

        public static Job plus(ChildJob childJob, Job job) {
            return Job.DefaultImpls.plus((Job) childJob, job);
        }
    }

    @Override // kotlinx.coroutines.Job, kotlin.coroutines.d
    /* synthetic */ Object fold(Object obj, or0 or0Var);

    @Override // kotlinx.coroutines.Job, kotlin.coroutines.d.b, kotlin.coroutines.d
    /* synthetic */ d.b get(d.c cVar);

    @Override // kotlinx.coroutines.Job, kotlin.coroutines.d.b
    /* synthetic */ d.c getKey();

    @Override // kotlinx.coroutines.Job, kotlin.coroutines.d
    /* synthetic */ d minusKey(d.c cVar);

    @InternalCoroutinesApi
    void parentCancelled(ParentJob parentJob);

    @Override // kotlinx.coroutines.Job, kotlin.coroutines.d
    /* synthetic */ d plus(d dVar);
}
