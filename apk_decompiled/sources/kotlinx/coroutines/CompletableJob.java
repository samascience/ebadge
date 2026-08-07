package kotlinx.coroutines;

import defpackage.or0;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
public interface CompletableJob extends Job {

    public static final class DefaultImpls {
        public static <R> R fold(CompletableJob completableJob, R r, or0 or0Var) {
            return (R) Job.DefaultImpls.fold(completableJob, r, or0Var);
        }

        public static <E extends d.b> E get(CompletableJob completableJob, d.c cVar) {
            return (E) Job.DefaultImpls.get(completableJob, cVar);
        }

        public static d minusKey(CompletableJob completableJob, d.c cVar) {
            return Job.DefaultImpls.minusKey(completableJob, cVar);
        }

        public static d plus(CompletableJob completableJob, d dVar) {
            return Job.DefaultImpls.plus(completableJob, dVar);
        }

        public static Job plus(CompletableJob completableJob, Job job) {
            return Job.DefaultImpls.plus((Job) completableJob, job);
        }
    }

    boolean complete();

    boolean completeExceptionally(Throwable th);

    @Override // kotlinx.coroutines.Job, kotlin.coroutines.d
    /* synthetic */ Object fold(Object obj, or0 or0Var);

    @Override // kotlinx.coroutines.Job, kotlin.coroutines.d.b, kotlin.coroutines.d
    /* synthetic */ d.b get(d.c cVar);

    @Override // kotlinx.coroutines.Job, kotlin.coroutines.d.b
    /* synthetic */ d.c getKey();

    @Override // kotlinx.coroutines.Job, kotlin.coroutines.d
    /* synthetic */ d minusKey(d.c cVar);

    @Override // kotlinx.coroutines.Job, kotlin.coroutines.d
    /* synthetic */ d plus(d dVar);
}
