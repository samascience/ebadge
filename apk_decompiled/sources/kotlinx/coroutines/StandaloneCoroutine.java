package kotlinx.coroutines;

import defpackage.k83;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
class StandaloneCoroutine extends AbstractCoroutine<k83> {
    public StandaloneCoroutine(d dVar, boolean z) {
        super(dVar, true, z);
    }

    @Override // kotlinx.coroutines.JobSupport
    protected boolean handleJobException(Throwable th) {
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th);
        return true;
    }
}
