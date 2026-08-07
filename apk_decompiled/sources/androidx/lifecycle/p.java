package androidx.lifecycle;

import defpackage.p31;
import defpackage.sy;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {
    public static final CoroutineScope a(o oVar) {
        p31.f(oVar, "<this>");
        CoroutineScope coroutineScope = (CoroutineScope) oVar.c("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY");
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Object objE = oVar.e("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", new sy(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate())));
        p31.e(objE, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (CoroutineScope) objE;
    }
}
