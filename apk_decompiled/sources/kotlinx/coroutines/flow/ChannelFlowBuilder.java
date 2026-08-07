package kotlinx.coroutines.flow;

import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import defpackage.y70;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.a;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* JADX INFO: loaded from: classes4.dex */
class ChannelFlowBuilder<T> extends ChannelFlow<T> {
    private final or0 block;

    public /* synthetic */ ChannelFlowBuilder(or0 or0Var, d dVar, int i, BufferOverflow bufferOverflow, int i2, y70 y70Var) {
        this(or0Var, (i2 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : dVar, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    static /* synthetic */ <T> Object collectTo$suspendImpl(ChannelFlowBuilder<T> channelFlowBuilder, ProducerScope<? super T> producerScope, x30 x30Var) {
        Object objInvoke = ((ChannelFlowBuilder) channelFlowBuilder).block.invoke(producerScope, x30Var);
        return objInvoke == a.d() ? objInvoke : k83.a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected Object collectTo(ProducerScope<? super T> producerScope, x30 x30Var) {
        return collectTo$suspendImpl(this, producerScope, x30Var);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow<T> create(d dVar, int i, BufferOverflow bufferOverflow) {
        return new ChannelFlowBuilder(this.block, dVar, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return "block[" + this.block + "] -> " + super.toString();
    }

    public ChannelFlowBuilder(or0 or0Var, d dVar, int i, BufferOverflow bufferOverflow) {
        super(dVar, i, bufferOverflow);
        this.block = or0Var;
    }
}
