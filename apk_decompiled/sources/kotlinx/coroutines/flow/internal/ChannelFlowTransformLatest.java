package kotlinx.coroutines.flow.internal;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.pr0;
import defpackage.x30;
import defpackage.y70;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes4.dex */
public final class ChannelFlowTransformLatest<T, R> extends ChannelFlowOperator<T, R> {
    private final pr0 transform;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", l = {27}, m = "invokeSuspend")
    static final class AnonymousClass3 extends SuspendLambda implements or0 {
        final /* synthetic */ FlowCollector<R> $collector;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1, reason: invalid class name */
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ FlowCollector<R> $collector;
            final /* synthetic */ Ref$ObjectRef<Job> $previousFlow;
            final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2, reason: invalid class name */
            @h70(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2", f = "Merge.kt", l = {34}, m = "invokeSuspend")
            static final class AnonymousClass2 extends SuspendLambda implements or0 {
                final /* synthetic */ FlowCollector<R> $collector;
                final /* synthetic */ T $value;
                int label;
                final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass2(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, FlowCollector<? super R> flowCollector, T t, x30 x30Var) {
                    super(2, x30Var);
                    this.this$0 = channelFlowTransformLatest;
                    this.$collector = flowCollector;
                    this.$value = t;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final x30 create(Object obj, x30 x30Var) {
                    return new AnonymousClass2(this.this$0, this.$collector, this.$value, x30Var);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objD = a.d();
                    int i = this.label;
                    if (i == 0) {
                        d.b(obj);
                        pr0 pr0Var = ((ChannelFlowTransformLatest) this.this$0).transform;
                        FlowCollector<R> flowCollector = this.$collector;
                        T t = this.$value;
                        this.label = 1;
                        if (pr0Var.invoke(flowCollector, t, this) == objD) {
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
                public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
                    return ((AnonymousClass2) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Ref$ObjectRef<Job> ref$ObjectRef, CoroutineScope coroutineScope, ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, FlowCollector<? super R> flowCollector) {
                this.$previousFlow = ref$ObjectRef;
                this.$$this$coroutineScope = coroutineScope;
                this.this$0 = channelFlowTransformLatest;
                this.$collector = flowCollector;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(T t, x30 x30Var) throws Throwable {
                ChannelFlowTransformLatest$flowCollect$3$1$emit$1 channelFlowTransformLatest$flowCollect$3$1$emit$1;
                AnonymousClass1<T> anonymousClass1;
                if (x30Var instanceof ChannelFlowTransformLatest$flowCollect$3$1$emit$1) {
                    channelFlowTransformLatest$flowCollect$3$1$emit$1 = (ChannelFlowTransformLatest$flowCollect$3$1$emit$1) x30Var;
                    int i = channelFlowTransformLatest$flowCollect$3$1$emit$1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        channelFlowTransformLatest$flowCollect$3$1$emit$1.label = i - Integer.MIN_VALUE;
                    } else {
                        channelFlowTransformLatest$flowCollect$3$1$emit$1 = new ChannelFlowTransformLatest$flowCollect$3$1$emit$1(this, x30Var);
                    }
                } else {
                    channelFlowTransformLatest$flowCollect$3$1$emit$1 = new ChannelFlowTransformLatest$flowCollect$3$1$emit$1(this, x30Var);
                }
                Object obj = channelFlowTransformLatest$flowCollect$3$1$emit$1.result;
                Object objD = a.d();
                int i2 = channelFlowTransformLatest$flowCollect$3$1$emit$1.label;
                if (i2 == 0) {
                    d.b(obj);
                    Job job = this.$previousFlow.element;
                    if (job != null) {
                        job.cancel((CancellationException) new ChildCancelledException());
                        channelFlowTransformLatest$flowCollect$3$1$emit$1.L$0 = this;
                        channelFlowTransformLatest$flowCollect$3$1$emit$1.L$1 = t;
                        channelFlowTransformLatest$flowCollect$3$1$emit$1.L$2 = job;
                        channelFlowTransformLatest$flowCollect$3$1$emit$1.label = 1;
                        if (job.join(channelFlowTransformLatest$flowCollect$3$1$emit$1) == objD) {
                            return objD;
                        }
                    }
                    anonymousClass1 = this;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    t = (T) channelFlowTransformLatest$flowCollect$3$1$emit$1.L$1;
                    anonymousClass1 = (AnonymousClass1) channelFlowTransformLatest$flowCollect$3$1$emit$1.L$0;
                    d.b(obj);
                }
                anonymousClass1.$previousFlow.element = (T) BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(anonymousClass1.this$0, anonymousClass1.$collector, t, null), 1, null);
                return k83.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, FlowCollector<? super R> flowCollector, x30 x30Var) {
            super(2, x30Var);
            this.this$0 = channelFlowTransformLatest;
            this.$collector = flowCollector;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, this.$collector, x30Var);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = a.d();
            int i = this.label;
            if (i == 0) {
                d.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ChannelFlowTransformLatest<T, R> channelFlowTransformLatest = this.this$0;
                Flow<S> flow = channelFlowTransformLatest.flow;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(ref$ObjectRef, coroutineScope, channelFlowTransformLatest, this.$collector);
                this.label = 1;
                if (flow.collect(anonymousClass1, this) == objD) {
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
        public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
            return ((AnonymousClass3) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
        }
    }

    public /* synthetic */ ChannelFlowTransformLatest(pr0 pr0Var, Flow flow, kotlin.coroutines.d dVar, int i, BufferOverflow bufferOverflow, int i2, y70 y70Var) {
        this(pr0Var, flow, (i2 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : dVar, (i2 & 8) != 0 ? -2 : i, (i2 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow<R> create(kotlin.coroutines.d dVar, int i, BufferOverflow bufferOverflow) {
        return new ChannelFlowTransformLatest(this.transform, this.flow, dVar, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    protected Object flowCollect(FlowCollector<? super R> flowCollector, x30 x30Var) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass3(this, flowCollector, null), x30Var);
        return objCoroutineScope == a.d() ? objCoroutineScope : k83.a;
    }

    public ChannelFlowTransformLatest(pr0 pr0Var, Flow<? extends T> flow, kotlin.coroutines.d dVar, int i, BufferOverflow bufferOverflow) {
        super(flow, dVar, i, bufferOverflow);
        this.transform = pr0Var;
    }
}
