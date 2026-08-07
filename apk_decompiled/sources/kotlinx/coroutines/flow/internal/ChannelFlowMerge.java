package kotlinx.coroutines.flow.internal;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import defpackage.y70;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ChannelFlowMerge<T> extends ChannelFlow<T> {
    private final int concurrency;
    private final Flow<Flow<T>> flow;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2, reason: invalid class name */
    static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ SendingCollector<T> $collector;
        final /* synthetic */ Job $job;
        final /* synthetic */ ProducerScope<T> $scope;
        final /* synthetic */ Semaphore $semaphore;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1, reason: invalid class name */
        @h70(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1", f = "Merge.kt", l = {69}, m = "invokeSuspend")
        static final class AnonymousClass1 extends SuspendLambda implements or0 {
            final /* synthetic */ SendingCollector<T> $collector;
            final /* synthetic */ Flow<T> $inner;
            final /* synthetic */ Semaphore $semaphore;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Flow<? extends T> flow, SendingCollector<T> sendingCollector, Semaphore semaphore, x30 x30Var) {
                super(2, x30Var);
                this.$inner = flow;
                this.$collector = sendingCollector;
                this.$semaphore = semaphore;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final x30 create(Object obj, x30 x30Var) {
                return new AnonymousClass1(this.$inner, this.$collector, this.$semaphore, x30Var);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = a.d();
                int i = this.label;
                try {
                    if (i == 0) {
                        d.b(obj);
                        Flow<T> flow = this.$inner;
                        SendingCollector<T> sendingCollector = this.$collector;
                        this.label = 1;
                        if (flow.collect(sendingCollector, this) == objD) {
                            return objD;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d.b(obj);
                    }
                    this.$semaphore.release();
                    return k83.a;
                } catch (Throwable th) {
                    this.$semaphore.release();
                    throw th;
                }
            }

            @Override // defpackage.or0
            public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
                return ((AnonymousClass1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Job job, Semaphore semaphore, ProducerScope<? super T> producerScope, SendingCollector<T> sendingCollector) {
            this.$job = job;
            this.$semaphore = semaphore;
            this.$scope = producerScope;
            this.$collector = sendingCollector;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Flow<? extends T> flow, x30 x30Var) throws Throwable {
            ChannelFlowMerge$collectTo$2$emit$1 channelFlowMerge$collectTo$2$emit$1;
            AnonymousClass2<T> anonymousClass2;
            if (x30Var instanceof ChannelFlowMerge$collectTo$2$emit$1) {
                channelFlowMerge$collectTo$2$emit$1 = (ChannelFlowMerge$collectTo$2$emit$1) x30Var;
                int i = channelFlowMerge$collectTo$2$emit$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    channelFlowMerge$collectTo$2$emit$1.label = i - Integer.MIN_VALUE;
                } else {
                    channelFlowMerge$collectTo$2$emit$1 = new ChannelFlowMerge$collectTo$2$emit$1(this, x30Var);
                }
            } else {
                channelFlowMerge$collectTo$2$emit$1 = new ChannelFlowMerge$collectTo$2$emit$1(this, x30Var);
            }
            Object obj = channelFlowMerge$collectTo$2$emit$1.result;
            Object objD = a.d();
            int i2 = channelFlowMerge$collectTo$2$emit$1.label;
            if (i2 == 0) {
                d.b(obj);
                Job job = this.$job;
                if (job != null) {
                    JobKt.ensureActive(job);
                }
                Semaphore semaphore = this.$semaphore;
                channelFlowMerge$collectTo$2$emit$1.L$0 = this;
                channelFlowMerge$collectTo$2$emit$1.L$1 = flow;
                channelFlowMerge$collectTo$2$emit$1.label = 1;
                if (semaphore.acquire(channelFlowMerge$collectTo$2$emit$1) == objD) {
                    return objD;
                }
                anonymousClass2 = this;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flow = (Flow) channelFlowMerge$collectTo$2$emit$1.L$1;
                anonymousClass2 = (AnonymousClass2) channelFlowMerge$collectTo$2$emit$1.L$0;
                d.b(obj);
            }
            BuildersKt__Builders_commonKt.launch$default(anonymousClass2.$scope, null, null, new AnonymousClass1(flow, anonymousClass2.$collector, anonymousClass2.$semaphore, null), 3, null);
            return k83.a;
        }
    }

    public /* synthetic */ ChannelFlowMerge(Flow flow, int i, kotlin.coroutines.d dVar, int i2, BufferOverflow bufferOverflow, int i3, y70 y70Var) {
        this(flow, i, (i3 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : dVar, (i3 & 8) != 0 ? -2 : i2, (i3 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected String additionalToStringProps() {
        return "concurrency=" + this.concurrency;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected Object collectTo(ProducerScope<? super T> producerScope, x30 x30Var) {
        Object objCollect = this.flow.collect(new AnonymousClass2((Job) x30Var.getContext().get(Job.Key), SemaphoreKt.Semaphore$default(this.concurrency, 0, 2, null), producerScope, new SendingCollector(producerScope)), x30Var);
        return objCollect == a.d() ? objCollect : k83.a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow<T> create(kotlin.coroutines.d dVar, int i, BufferOverflow bufferOverflow) {
        return new ChannelFlowMerge(this.flow, this.concurrency, dVar, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ReceiveChannel<T> produceImpl(CoroutineScope coroutineScope) {
        return ProduceKt.produce(coroutineScope, this.context, this.capacity, getCollectToFun$kotlinx_coroutines_core());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowMerge(Flow<? extends Flow<? extends T>> flow, int i, kotlin.coroutines.d dVar, int i2, BufferOverflow bufferOverflow) {
        super(dVar, i2, bufferOverflow);
        this.flow = flow;
        this.concurrency = i;
    }
}
