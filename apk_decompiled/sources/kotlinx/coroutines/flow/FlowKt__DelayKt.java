package kotlinx.coroutines.flow;

import defpackage.ar0;
import defpackage.e43;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.pr0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.selects.SelectImplementation;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class FlowKt__DelayKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3, reason: invalid class name and case insensitive filesystem */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3", f = "Delay.kt", l = {316, 318, 319}, m = "invokeSuspend")
    static final class C02353 extends SuspendLambda implements or0 {
        final /* synthetic */ long $delayMillis;
        final /* synthetic */ long $initialDelayMillis;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02353(long j, long j2, x30 x30Var) {
            super(2, x30Var);
            this.$initialDelayMillis = j;
            this.$delayMillis = j2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            C02353 c02353 = new C02353(this.$initialDelayMillis, this.$delayMillis, x30Var);
            c02353.L$0 = obj;
            return c02353;
        }

        /* JADX WARN: Code duplicated, block: B:17:0x004f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:20:0x005c A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005a -> B:15:0x003f). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:20:0x005c
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.d()
                int r1 = r7.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2a
                if (r1 == r4) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                goto L22
            L12:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1a:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
                kotlin.d.b(r8)
                goto L50
            L22:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
                kotlin.d.b(r8)
                goto L3f
            L2a:
                kotlin.d.b(r8)
                java.lang.Object r8 = r7.L$0
                r1 = r8
                kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
                long r5 = r7.$initialDelayMillis
                r7.L$0 = r1
                r7.label = r4
                java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r5, r7)
                if (r8 != r0) goto L3f
                return r0
            L3f:
                kotlinx.coroutines.channels.SendChannel r8 = r1.getChannel()
                k83 r4 = defpackage.k83.a
                r7.L$0 = r1
                r7.label = r3
                java.lang.Object r8 = r8.send(r4, r7)
                if (r8 != r0) goto L50
                return r0
            L50:
                long r4 = r7.$delayMillis
                r7.L$0 = r1
                r7.label = r2
                java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r4, r7)
                if (r8 != r0) goto L3f
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt.C02353.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // defpackage.or0
        public final Object invoke(ProducerScope<? super k83> producerScope, x30 x30Var) {
            return ((C02353) create(producerScope, x30Var)).invokeSuspend(k83.a);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2, reason: invalid class name and case insensitive filesystem */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", l = {423}, m = "invokeSuspend")
    static final class C02362 extends SuspendLambda implements pr0 {
        final /* synthetic */ long $periodMillis;
        final /* synthetic */ Flow<T> $this_sample;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C02362(long j, Flow<? extends T> flow, x30 x30Var) {
            super(3, x30Var);
            this.$periodMillis = j;
            this.$this_sample = flow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            FlowCollector flowCollector;
            ReceiveChannel receiveChannel;
            Ref$ObjectRef ref$ObjectRef;
            ReceiveChannel receiveChannelFixedPeriodTicker$default;
            Object objD = a.d();
            int i = this.label;
            if (i == 0) {
                d.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                FlowCollector flowCollector2 = (FlowCollector) this.L$1;
                ReceiveChannel receiveChannelProduce$default = ProduceKt.produce$default(coroutineScope, null, -1, new FlowKt__DelayKt$sample$2$values$1(this.$this_sample, null), 1, null);
                Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                flowCollector = flowCollector2;
                receiveChannel = receiveChannelProduce$default;
                ref$ObjectRef = ref$ObjectRef2;
                receiveChannelFixedPeriodTicker$default = FlowKt__DelayKt.fixedPeriodTicker$default(coroutineScope, this.$periodMillis, 0L, 2, null);
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                receiveChannelFixedPeriodTicker$default = (ReceiveChannel) this.L$3;
                ref$ObjectRef = (Ref$ObjectRef) this.L$2;
                receiveChannel = (ReceiveChannel) this.L$1;
                flowCollector = (FlowCollector) this.L$0;
                d.b(obj);
            }
            while (ref$ObjectRef.element != NullSurrogateKt.DONE) {
                SelectImplementation selectImplementation = new SelectImplementation(getContext());
                selectImplementation.invoke(receiveChannel.getOnReceiveCatching(), new FlowKt__DelayKt$sample$2$1$1(ref$ObjectRef, receiveChannelFixedPeriodTicker$default, null));
                selectImplementation.invoke(receiveChannelFixedPeriodTicker$default.getOnReceive(), new FlowKt__DelayKt$sample$2$1$2(ref$ObjectRef, flowCollector, null));
                this.L$0 = flowCollector;
                this.L$1 = receiveChannel;
                this.L$2 = ref$ObjectRef;
                this.L$3 = receiveChannelFixedPeriodTicker$default;
                this.label = 1;
                if (selectImplementation.doSelect(this) == objD) {
                    return objD;
                }
            }
            return k83.a;
        }

        @Override // defpackage.pr0
        public final Object invoke(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, x30 x30Var) {
            C02362 c02362 = new C02362(this.$periodMillis, this.$this_sample, x30Var);
            c02362.L$0 = coroutineScope;
            c02362.L$1 = flowCollector;
            return c02362.invokeSuspend(k83.a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @FlowPreview
    public static final <T> Flow<T> debounce(Flow<? extends T> flow, final long j) {
        if (j >= 0) {
            return j == 0 ? flow : debounceInternal$FlowKt__DelayKt(flow, new ar0() { // from class: kotlinx.coroutines.flow.FlowKt__DelayKt.debounce.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // defpackage.ar0
                public final Long invoke(T t) {
                    return Long.valueOf(j);
                }
            });
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative");
    }

    @FlowPreview
    /* JADX INFO: renamed from: debounce-HG0u8IE, reason: not valid java name */
    public static final <T> Flow<T> m127debounceHG0u8IE(Flow<? extends T> flow, long j) {
        return FlowKt.debounce(flow, DelayKt.m82toDelayMillisLRDsOJo(j));
    }

    @FlowPreview
    public static final <T> Flow<T> debounceDuration(Flow<? extends T> flow, final ar0 ar0Var) {
        return debounceInternal$FlowKt__DelayKt(flow, new ar0() { // from class: kotlinx.coroutines.flow.FlowKt__DelayKt.debounce.3
            {
                super(1);
            }

            @Override // defpackage.ar0
            public final Long invoke(T t) {
                e43.a(ar0Var.invoke(t));
                throw null;
            }
        });
    }

    private static final <T> Flow<T> debounceInternal$FlowKt__DelayKt(Flow<? extends T> flow, ar0 ar0Var) {
        return FlowCoroutineKt.scopedFlow(new FlowKt__DelayKt$debounceInternal$1(ar0Var, flow, null));
    }

    public static final ReceiveChannel<k83> fixedPeriodTicker(CoroutineScope coroutineScope, long j, long j2) {
        if (j < 0) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
        }
        if (j2 >= 0) {
            return ProduceKt.produce$default(coroutineScope, null, 0, new C02353(j2, j, null), 1, null);
        }
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel fixedPeriodTicker$default(CoroutineScope coroutineScope, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        return FlowKt.fixedPeriodTicker(coroutineScope, j, j2);
    }

    @FlowPreview
    public static final <T> Flow<T> sample(Flow<? extends T> flow, long j) {
        if (j > 0) {
            return FlowCoroutineKt.scopedFlow(new C02362(j, flow, null));
        }
        throw new IllegalArgumentException("Sample period should be positive");
    }

    @FlowPreview
    /* JADX INFO: renamed from: sample-HG0u8IE, reason: not valid java name */
    public static final <T> Flow<T> m128sampleHG0u8IE(Flow<? extends T> flow, long j) {
        return FlowKt.sample(flow, DelayKt.m82toDelayMillisLRDsOJo(j));
    }

    @FlowPreview
    /* JADX INFO: renamed from: timeout-HG0u8IE, reason: not valid java name */
    public static final <T> Flow<T> m129timeoutHG0u8IE(Flow<? extends T> flow, long j) {
        return m130timeoutInternalHG0u8IE$FlowKt__DelayKt(flow, j);
    }

    /* JADX INFO: renamed from: timeoutInternal-HG0u8IE$FlowKt__DelayKt, reason: not valid java name */
    private static final <T> Flow<T> m130timeoutInternalHG0u8IE$FlowKt__DelayKt(Flow<? extends T> flow, long j) {
        return FlowCoroutineKt.scopedFlow(new FlowKt__DelayKt$timeoutInternal$1(j, flow, null));
    }

    @FlowPreview
    public static final <T> Flow<T> debounce(Flow<? extends T> flow, ar0 ar0Var) {
        return debounceInternal$FlowKt__DelayKt(flow, ar0Var);
    }
}
