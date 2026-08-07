package kotlinx.coroutines;

import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.d;
import kotlinx.coroutines.intrinsics.CancellableKt;

/* JADX INFO: loaded from: classes4.dex */
final class LazyStandaloneCoroutine extends StandaloneCoroutine {
    private final x30 continuation;

    public LazyStandaloneCoroutine(d dVar, or0 or0Var) {
        super(dVar, false);
        this.continuation = kotlin.coroutines.intrinsics.a.b(or0Var, this, this);
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void onStart() throws Throwable {
        CancellableKt.startCoroutineCancellable(this.continuation, this);
    }
}
