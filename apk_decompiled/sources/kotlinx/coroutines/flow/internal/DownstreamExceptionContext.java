package kotlinx.coroutines.flow.internal;

import defpackage.or0;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
public final class DownstreamExceptionContext implements d {
    private final /* synthetic */ d $$delegate_0;
    public final Throwable e;

    public DownstreamExceptionContext(Throwable th, d dVar) {
        this.e = th;
        this.$$delegate_0 = dVar;
    }

    @Override // kotlin.coroutines.d
    public <R> R fold(R r, or0 or0Var) {
        return (R) this.$$delegate_0.fold(r, or0Var);
    }

    @Override // kotlin.coroutines.d
    public <E extends d.b> E get(d.c cVar) {
        return (E) this.$$delegate_0.get(cVar);
    }

    @Override // kotlin.coroutines.d
    public d minusKey(d.c cVar) {
        return this.$$delegate_0.minusKey(cVar);
    }

    @Override // kotlin.coroutines.d
    public d plus(d dVar) {
        return this.$$delegate_0.plus(dVar);
    }
}
