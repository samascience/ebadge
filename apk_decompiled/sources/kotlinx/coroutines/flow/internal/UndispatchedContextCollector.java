package kotlinx.coroutines.flow.internal;

import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.a;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes4.dex */
final class UndispatchedContextCollector<T> implements FlowCollector<T> {
    private final Object countOrElement;
    private final d emitContext;
    private final or0 emitRef;

    public UndispatchedContextCollector(FlowCollector<? super T> flowCollector, d dVar) {
        this.emitContext = dVar;
        this.countOrElement = ThreadContextKt.threadContextElements(dVar);
        this.emitRef = new UndispatchedContextCollector$emitRef$1(flowCollector, null);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, x30 x30Var) {
        Object objWithContextUndispatched = ChannelFlowKt.withContextUndispatched(this.emitContext, t, this.countOrElement, this.emitRef, x30Var);
        return objWithContextUndispatched == a.d() ? objWithContextUndispatched : k83.a;
    }
}
