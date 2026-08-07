package kotlinx.coroutines.flow.internal;

import defpackage.b21;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.pr0;
import defpackage.x30;
import defpackage.yq0;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.YieldKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes4.dex */
public final class CombineKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", l = {54, 76, 79}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements or0 {
        final /* synthetic */ yq0 $arrayFactory;
        final /* synthetic */ Flow<T>[] $flows;
        final /* synthetic */ FlowCollector<R> $this_combineInternal;
        final /* synthetic */ pr0 $transform;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
        @h70(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", l = {31}, m = "invokeSuspend")
        static final class AnonymousClass1 extends SuspendLambda implements or0 {
            final /* synthetic */ Flow<T>[] $flows;
            final /* synthetic */ int $i;
            final /* synthetic */ AtomicInteger $nonClosed;
            final /* synthetic */ Channel<b21> $resultChannel;
            int label;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1, reason: invalid class name and collision with other inner class name */
            static final class C01371<T> implements FlowCollector {
                final /* synthetic */ int $i;
                final /* synthetic */ Channel<b21> $resultChannel;

                C01371(Channel<b21> channel, int i) {
                    this.$resultChannel = channel;
                    this.$i = i;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(T t, x30 x30Var) throws Throwable {
                    CombineKt$combineInternal$2$1$1$emit$1 combineKt$combineInternal$2$1$1$emit$1;
                    if (x30Var instanceof CombineKt$combineInternal$2$1$1$emit$1) {
                        combineKt$combineInternal$2$1$1$emit$1 = (CombineKt$combineInternal$2$1$1$emit$1) x30Var;
                        int i = combineKt$combineInternal$2$1$1$emit$1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            combineKt$combineInternal$2$1$1$emit$1.label = i - Integer.MIN_VALUE;
                        } else {
                            combineKt$combineInternal$2$1$1$emit$1 = new CombineKt$combineInternal$2$1$1$emit$1(this, x30Var);
                        }
                    } else {
                        combineKt$combineInternal$2$1$1$emit$1 = new CombineKt$combineInternal$2$1$1$emit$1(this, x30Var);
                    }
                    Object obj = combineKt$combineInternal$2$1$1$emit$1.result;
                    Object objD = a.d();
                    int i2 = combineKt$combineInternal$2$1$1$emit$1.label;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            d.b(obj);
                        } else {
                            if (i2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            d.b(obj);
                        }
                        return k83.a;
                    }
                    d.b(obj);
                    Channel<b21> channel = this.$resultChannel;
                    b21 b21Var = new b21(this.$i, t);
                    combineKt$combineInternal$2$1$1$emit$1.label = 1;
                    if (channel.send(b21Var, combineKt$combineInternal$2$1$1$emit$1) == objD) {
                        return objD;
                    }
                    combineKt$combineInternal$2$1$1$emit$1.label = 2;
                    if (YieldKt.yield(combineKt$combineInternal$2$1$1$emit$1) == objD) {
                        return objD;
                    }
                    return k83.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Flow<? extends T>[] flowArr, int i, AtomicInteger atomicInteger, Channel<b21> channel, x30 x30Var) {
                super(2, x30Var);
                this.$flows = flowArr;
                this.$i = i;
                this.$nonClosed = atomicInteger;
                this.$resultChannel = channel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final x30 create(Object obj, x30 x30Var) {
                return new AnonymousClass1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, x30Var);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = a.d();
                int i = this.label;
                try {
                    if (i == 0) {
                        d.b(obj);
                        Flow[] flowArr = this.$flows;
                        int i2 = this.$i;
                        Flow flow = flowArr[i2];
                        C01371 c01371 = new C01371(this.$resultChannel, i2);
                        this.label = 1;
                        if (flow.collect(c01371, this) == objD) {
                            return objD;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d.b(obj);
                    }
                    if (this.$nonClosed.decrementAndGet() == 0) {
                        SendChannel.DefaultImpls.close$default(this.$resultChannel, null, 1, null);
                    }
                    return k83.a;
                } catch (Throwable th) {
                    if (this.$nonClosed.decrementAndGet() == 0) {
                        SendChannel.DefaultImpls.close$default(this.$resultChannel, null, 1, null);
                    }
                    throw th;
                }
            }

            @Override // defpackage.or0
            public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
                return ((AnonymousClass1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Flow<? extends T>[] flowArr, yq0 yq0Var, pr0 pr0Var, FlowCollector<? super R> flowCollector, x30 x30Var) {
            super(2, x30Var);
            this.$flows = flowArr;
            this.$arrayFactory = yq0Var;
            this.$transform = pr0Var;
            this.$this_combineInternal = flowCollector;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, x30Var);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x00bd A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x00be  */
        /* JADX WARN: Code duplicated, block: B:26:0x00c7  */
        /* JADX WARN: Code duplicated, block: B:28:0x00ca A[LOOP:0: B:28:0x00ca->B:48:?, LOOP_START, PHI: r6 r10
          0x00ca: PHI (r6v6 int) = (r6v5 int), (r6v7 int) binds: [B:25:0x00c5, B:48:?] A[DONT_GENERATE, DONT_INLINE]
          0x00ca: PHI (r10v8 b21) = (r10v7 b21), (r10v21 b21) binds: [B:25:0x00c5, B:48:?] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:30:0x00da  */
        /* JADX WARN: Code duplicated, block: B:33:0x00e0  */
        /* JADX WARN: Code duplicated, block: B:36:0x00f1  */
        /* JADX WARN: Code duplicated, block: B:38:0x00fb  */
        /* JADX WARN: Code duplicated, block: B:40:0x0111 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:41:0x0112  */
        /* JADX WARN: Code duplicated, block: B:43:0x0134 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:46:0x00ef A[EDGE_INSN: B:46:0x00ef->B:35:0x00ef BREAK  A[LOOP:0: B:28:0x00ca->B:48:?], SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0135 -> B:45:0x0137). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                Method dump skipped, instruction units count: 314
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // defpackage.or0
        public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
            return ((AnonymousClass2) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
        }
    }

    public static final <R, T> Object combineInternal(FlowCollector<? super R> flowCollector, Flow<? extends T>[] flowArr, yq0 yq0Var, pr0 pr0Var, x30 x30Var) {
        Object objFlowScope = FlowCoroutineKt.flowScope(new AnonymousClass2(flowArr, yq0Var, pr0Var, flowCollector, null), x30Var);
        return objFlowScope == a.d() ? objFlowScope : k83.a;
    }

    public static final <T1, T2, R> Flow<R> zipImpl(final Flow<? extends T1> flow, final Flow<? extends T2> flow2, final pr0 pr0Var) {
        return new Flow<R>() { // from class: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super R> flowCollector, x30 x30Var) {
                Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new CombineKt$zipImpl$1$1(flowCollector, flow2, flow, pr0Var, null), x30Var);
                return objCoroutineScope == a.d() ? objCoroutineScope : k83.a;
            }
        };
    }
}
