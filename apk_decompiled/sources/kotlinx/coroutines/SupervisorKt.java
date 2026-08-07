package kotlinx.coroutines;

import defpackage.j70;
import defpackage.or0;
import defpackage.x30;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* JADX INFO: loaded from: classes4.dex */
public final class SupervisorKt {
    public static final CompletableJob SupervisorJob(Job job) {
        return new SupervisorJobImpl(job);
    }

    public static /* synthetic */ CompletableJob SupervisorJob$default(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return SupervisorJob(job);
    }

    public static final <R> Object supervisorScope(or0 or0Var, x30 x30Var) {
        SupervisorCoroutine supervisorCoroutine = new SupervisorCoroutine(x30Var.getContext(), x30Var);
        Object objStartUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(supervisorCoroutine, supervisorCoroutine, or0Var);
        if (objStartUndispatchedOrReturn == kotlin.coroutines.intrinsics.a.d()) {
            j70.c(x30Var);
        }
        return objStartUndispatchedOrReturn;
    }

    /* JADX INFO: renamed from: SupervisorJob$default, reason: collision with other method in class */
    public static /* synthetic */ Job m89SupervisorJob$default(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return SupervisorJob(job);
    }
}
