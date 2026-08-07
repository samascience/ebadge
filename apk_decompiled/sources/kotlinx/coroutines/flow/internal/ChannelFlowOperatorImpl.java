package kotlinx.coroutines.flow.internal;

import defpackage.k83;
import defpackage.x30;
import defpackage.y70;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.a;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes4.dex */
public final class ChannelFlowOperatorImpl<T> extends ChannelFlowOperator<T, T> {
    public /* synthetic */ ChannelFlowOperatorImpl(Flow flow, d dVar, int i, BufferOverflow bufferOverflow, int i2, y70 y70Var) {
        this(flow, (i2 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : dVar, (i2 & 4) != 0 ? -3 : i, (i2 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow<T> create(d dVar, int i, BufferOverflow bufferOverflow) {
        return new ChannelFlowOperatorImpl(this.flow, dVar, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Flow<T> dropChannelOperators() {
        return (Flow<T>) this.flow;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    protected Object flowCollect(FlowCollector<? super T> flowCollector, x30 x30Var) {
        Object objCollect = this.flow.collect((FlowCollector<? super S>) flowCollector, x30Var);
        return objCollect == a.d() ? objCollect : k83.a;
    }

    public ChannelFlowOperatorImpl(Flow<? extends T> flow, d dVar, int i, BufferOverflow bufferOverflow) {
        super(flow, dVar, i, bufferOverflow);
    }
}
