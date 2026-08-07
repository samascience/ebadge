package kotlinx.coroutines.flow.internal;

import defpackage.k83;
import defpackage.x30;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes4.dex */
public final class NopCollector implements FlowCollector<Object> {
    public static final NopCollector INSTANCE = new NopCollector();

    private NopCollector() {
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object obj, x30 x30Var) {
        return k83.a;
    }
}
