package kotlinx.coroutines.flow.internal;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.x30;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {
    protected final Flow<S> flow;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", l = {Opcodes.DCMPG}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements or0 {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ChannelFlowOperator<S, T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ChannelFlowOperator<S, T> channelFlowOperator, x30 x30Var) {
            super(2, x30Var);
            this.this$0 = channelFlowOperator;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, x30Var);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = a.d();
            int i = this.label;
            if (i == 0) {
                d.b(obj);
                FlowCollector<? super T> flowCollector = (FlowCollector) this.L$0;
                ChannelFlowOperator<S, T> channelFlowOperator = this.this$0;
                this.label = 1;
                if (channelFlowOperator.flowCollect(flowCollector, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj);
            }
            return k83.a;
        }

        @Override // defpackage.or0
        public final Object invoke(FlowCollector<? super T> flowCollector, x30 x30Var) {
            return ((AnonymousClass2) create(flowCollector, x30Var)).invokeSuspend(k83.a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowOperator(Flow<? extends S> flow, kotlin.coroutines.d dVar, int i, BufferOverflow bufferOverflow) {
        super(dVar, i, bufferOverflow);
        this.flow = flow;
    }

    static /* synthetic */ <S, T> Object collect$suspendImpl(ChannelFlowOperator<S, T> channelFlowOperator, FlowCollector<? super T> flowCollector, x30 x30Var) {
        if (channelFlowOperator.capacity == -3) {
            kotlin.coroutines.d context = x30Var.getContext();
            kotlin.coroutines.d dVarNewCoroutineContext = CoroutineContextKt.newCoroutineContext(context, channelFlowOperator.context);
            if (p31.a(dVarNewCoroutineContext, context)) {
                Object objFlowCollect = channelFlowOperator.flowCollect(flowCollector, x30Var);
                return objFlowCollect == a.d() ? objFlowCollect : k83.a;
            }
            c.b bVar = c.E;
            if (p31.a(dVarNewCoroutineContext.get(bVar), context.get(bVar))) {
                Object objCollectWithContextUndispatched = channelFlowOperator.collectWithContextUndispatched(flowCollector, dVarNewCoroutineContext, x30Var);
                return objCollectWithContextUndispatched == a.d() ? objCollectWithContextUndispatched : k83.a;
            }
        }
        Object objCollect = super.collect(flowCollector, x30Var);
        return objCollect == a.d() ? objCollect : k83.a;
    }

    static /* synthetic */ <S, T> Object collectTo$suspendImpl(ChannelFlowOperator<S, T> channelFlowOperator, ProducerScope<? super T> producerScope, x30 x30Var) {
        Object objFlowCollect = channelFlowOperator.flowCollect(new SendingCollector(producerScope), x30Var);
        return objFlowCollect == a.d() ? objFlowCollect : k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object collectWithContextUndispatched(FlowCollector<? super T> flowCollector, kotlin.coroutines.d dVar, x30 x30Var) {
        Object objWithContextUndispatched$default = ChannelFlowKt.withContextUndispatched$default(dVar, ChannelFlowKt.withUndispatchedContextCollector(flowCollector, x30Var.getContext()), null, new AnonymousClass2(this, null), x30Var, 4, null);
        return objWithContextUndispatched$default == a.d() ? objWithContextUndispatched$default : k83.a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, x30 x30Var) {
        return collect$suspendImpl((ChannelFlowOperator) this, (FlowCollector) flowCollector, x30Var);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected Object collectTo(ProducerScope<? super T> producerScope, x30 x30Var) {
        return collectTo$suspendImpl(this, producerScope, x30Var);
    }

    protected abstract Object flowCollect(FlowCollector<? super T> flowCollector, x30 x30Var);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return this.flow + " -> " + super.toString();
    }
}
