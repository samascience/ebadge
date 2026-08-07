package kotlinx.coroutines;

import defpackage.ar0;
import defpackage.or0;
import defpackage.rm2;
import defpackage.x30;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.d;
import kotlinx.coroutines.selects.SelectClause0;

/* JADX INFO: loaded from: classes4.dex */
public interface Job extends d.b {
    public static final Key Key = Key.$$INSTANCE;

    public static final class DefaultImpls {
        public static /* synthetic */ void cancel$default(Job job, CancellationException cancellationException, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                cancellationException = null;
            }
            job.cancel(cancellationException);
        }

        public static <R> R fold(Job job, R r, or0 or0Var) {
            return (R) d.b.a.a(job, r, or0Var);
        }

        public static <E extends d.b> E get(Job job, d.c cVar) {
            return (E) d.b.a.b(job, cVar);
        }

        @ExperimentalCoroutinesApi
        public static /* synthetic */ void getParent$annotations() {
        }

        public static /* synthetic */ DisposableHandle invokeOnCompletion$default(Job job, boolean z, boolean z2, ar0 ar0Var, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = true;
            }
            return job.invokeOnCompletion(z, z2, ar0Var);
        }

        public static d minusKey(Job job, d.c cVar) {
            return d.b.a.c(job, cVar);
        }

        public static Job plus(Job job, Job job2) {
            return job2;
        }

        public static /* synthetic */ boolean cancel$default(Job job, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                th = null;
            }
            return job.cancel(th);
        }

        public static d plus(Job job, d dVar) {
            return d.b.a.d(job, dVar);
        }
    }

    public static final class Key implements d.c {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }

    @InternalCoroutinesApi
    ChildHandle attachChild(ChildJob childJob);

    /* synthetic */ void cancel();

    void cancel(CancellationException cancellationException);

    /* synthetic */ boolean cancel(Throwable th);

    @Override // kotlin.coroutines.d
    /* synthetic */ Object fold(Object obj, or0 or0Var);

    @Override // kotlin.coroutines.d.b, kotlin.coroutines.d
    /* synthetic */ d.b get(d.c cVar);

    @InternalCoroutinesApi
    CancellationException getCancellationException();

    rm2 getChildren();

    @Override // kotlin.coroutines.d.b
    /* synthetic */ d.c getKey();

    SelectClause0 getOnJoin();

    Job getParent();

    DisposableHandle invokeOnCompletion(ar0 ar0Var);

    @InternalCoroutinesApi
    DisposableHandle invokeOnCompletion(boolean z, boolean z2, ar0 ar0Var);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    Object join(x30 x30Var);

    @Override // kotlin.coroutines.d
    /* synthetic */ d minusKey(d.c cVar);

    @Override // kotlin.coroutines.d
    /* synthetic */ d plus(d dVar);

    Job plus(Job job);

    boolean start();
}
