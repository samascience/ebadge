package defpackage;

import kotlin.coroutines.d;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes.dex */
public final class sz1 extends CoroutineDispatcher {
    public final gc0 a = new gc0();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* JADX INFO: renamed from: dispatch */
    public void mo149dispatch(d dVar, Runnable runnable) {
        p31.f(dVar, "context");
        p31.f(runnable, "block");
        this.a.c(dVar, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(d dVar) {
        p31.f(dVar, "context");
        if (Dispatchers.getMain().getImmediate().isDispatchNeeded(dVar)) {
            return true;
        }
        return !this.a.b();
    }
}
