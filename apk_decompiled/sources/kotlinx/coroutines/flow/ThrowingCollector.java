package kotlinx.coroutines.flow;

import defpackage.x30;

/* JADX INFO: loaded from: classes4.dex */
public final class ThrowingCollector implements FlowCollector<Object> {
    public final Throwable e;

    public ThrowingCollector(Throwable th) {
        this.e = th;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object obj, x30 x30Var) throws Throwable {
        throw this.e;
    }
}
