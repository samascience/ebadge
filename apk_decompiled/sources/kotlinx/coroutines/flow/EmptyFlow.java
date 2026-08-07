package kotlinx.coroutines.flow;

import defpackage.k83;
import defpackage.x30;

/* JADX INFO: loaded from: classes4.dex */
final class EmptyFlow implements Flow {
    public static final EmptyFlow INSTANCE = new EmptyFlow();

    private EmptyFlow() {
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<?> flowCollector, x30 x30Var) {
        return k83.a;
    }
}
