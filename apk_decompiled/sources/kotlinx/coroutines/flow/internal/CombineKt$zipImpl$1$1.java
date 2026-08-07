package kotlinx.coroutines.flow.internal;

import defpackage.ar0;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.pr0;
import defpackage.x30;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", l = {126}, m = "invokeSuspend")
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements or0 {
    final /* synthetic */ Flow<T1> $flow;
    final /* synthetic */ Flow<T2> $flow2;
    final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
    final /* synthetic */ pr0 $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", f = "Combine.kt", l = {127}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements or0 {
        final /* synthetic */ Object $cnt;
        final /* synthetic */ Flow<T1> $flow;
        final /* synthetic */ d $scopeContext;
        final /* synthetic */ ReceiveChannel<Object> $second;
        final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
        final /* synthetic */ pr0 $transform;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1, reason: invalid class name */
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ Object $cnt;
            final /* synthetic */ d $scopeContext;
            final /* synthetic */ ReceiveChannel<Object> $second;
            final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
            final /* synthetic */ pr0 $transform;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1, reason: invalid class name and collision with other inner class name */
            @h70(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", l = {Opcodes.LOR, Opcodes.IINC, Opcodes.IINC}, m = "invokeSuspend")
            static final class C01381 extends SuspendLambda implements or0 {
                final /* synthetic */ ReceiveChannel<Object> $second;
                final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
                final /* synthetic */ pr0 $transform;
                final /* synthetic */ T1 $value;
                Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C01381(ReceiveChannel<? extends Object> receiveChannel, FlowCollector<? super R> flowCollector, pr0 pr0Var, T1 t1, x30 x30Var) {
                    super(2, x30Var);
                    this.$second = receiveChannel;
                    this.$this_unsafeFlow = flowCollector;
                    this.$transform = pr0Var;
                    this.$value = t1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final x30 create(Object obj, x30 x30Var) {
                    return new C01381(this.$second, this.$this_unsafeFlow, this.$transform, this.$value, x30Var);
                }

                @Override // defpackage.or0
                public final Object invoke(k83 k83Var, x30 x30Var) {
                    return ((C01381) create(k83Var, x30Var)).invokeSuspend(k83.a);
                }

                /* JADX WARN: Code duplicated, block: B:29:0x006e A[RETURN] */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objMo96receiveCatchingJP2dKIU;
                    FlowCollector flowCollector;
                    Object objD = a.d();
                    int i = this.label;
                    if (i != 0) {
                        if (i == 1) {
                            kotlin.d.b(obj);
                            objMo96receiveCatchingJP2dKIU = ((ChannelResult) obj).m114unboximpl();
                        } else if (i == 2) {
                            FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                            kotlin.d.b(obj);
                            flowCollector = flowCollector2;
                            this.L$0 = null;
                            this.label = 3;
                            if (flowCollector.emit(obj, this) == objD) {
                                return objD;
                            }
                        } else {
                            if (i != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            kotlin.d.b(obj);
                        }
                        return k83.a;
                    }
                    kotlin.d.b(obj);
                    ReceiveChannel<Object> receiveChannel = this.$second;
                    this.label = 1;
                    objMo96receiveCatchingJP2dKIU = receiveChannel.mo96receiveCatchingJP2dKIU(this);
                    if (objMo96receiveCatchingJP2dKIU == objD) {
                        return objD;
                    }
                    FlowCollector flowCollector3 = this.$this_unsafeFlow;
                    if (objMo96receiveCatchingJP2dKIU instanceof ChannelResult.Failed) {
                        Throwable thM106exceptionOrNullimpl = ChannelResult.m106exceptionOrNullimpl(objMo96receiveCatchingJP2dKIU);
                        if (thM106exceptionOrNullimpl == null) {
                            throw new AbortFlowException(flowCollector3);
                        }
                        throw thM106exceptionOrNullimpl;
                    }
                    pr0 pr0Var = this.$transform;
                    Object obj2 = this.$value;
                    if (objMo96receiveCatchingJP2dKIU == NullSurrogateKt.NULL) {
                        objMo96receiveCatchingJP2dKIU = null;
                    }
                    this.L$0 = flowCollector3;
                    this.label = 2;
                    obj = pr0Var.invoke(obj2, objMo96receiveCatchingJP2dKIU, this);
                    flowCollector = flowCollector3;
                    if (obj == objD) {
                        return objD;
                    }
                    this.L$0 = null;
                    this.label = 3;
                    if (flowCollector.emit(obj, this) == objD) {
                        return objD;
                    }
                    return k83.a;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(d dVar, Object obj, ReceiveChannel<? extends Object> receiveChannel, FlowCollector<? super R> flowCollector, pr0 pr0Var) {
                this.$scopeContext = dVar;
                this.$cnt = obj;
                this.$second = receiveChannel;
                this.$this_unsafeFlow = flowCollector;
                this.$transform = pr0Var;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(T1 t1, x30 x30Var) throws Throwable {
                CombineKt$zipImpl$1$1$2$1$emit$1 combineKt$zipImpl$1$1$2$1$emit$1;
                if (x30Var instanceof CombineKt$zipImpl$1$1$2$1$emit$1) {
                    combineKt$zipImpl$1$1$2$1$emit$1 = (CombineKt$zipImpl$1$1$2$1$emit$1) x30Var;
                    int i = combineKt$zipImpl$1$1$2$1$emit$1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        combineKt$zipImpl$1$1$2$1$emit$1.label = i - Integer.MIN_VALUE;
                    } else {
                        combineKt$zipImpl$1$1$2$1$emit$1 = new CombineKt$zipImpl$1$1$2$1$emit$1(this, x30Var);
                    }
                } else {
                    combineKt$zipImpl$1$1$2$1$emit$1 = new CombineKt$zipImpl$1$1$2$1$emit$1(this, x30Var);
                }
                Object obj = combineKt$zipImpl$1$1$2$1$emit$1.result;
                Object objD = a.d();
                int i2 = combineKt$zipImpl$1$1$2$1$emit$1.label;
                if (i2 == 0) {
                    kotlin.d.b(obj);
                    d dVar = this.$scopeContext;
                    k83 k83Var = k83.a;
                    Object obj2 = this.$cnt;
                    C01381 c01381 = new C01381(this.$second, this.$this_unsafeFlow, this.$transform, t1, null);
                    combineKt$zipImpl$1$1$2$1$emit$1.label = 1;
                    if (ChannelFlowKt.withContextUndispatched(dVar, k83Var, obj2, c01381, combineKt$zipImpl$1$1$2$1$emit$1) == objD) {
                        return objD;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.d.b(obj);
                }
                return k83.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Flow<? extends T1> flow, d dVar, Object obj, ReceiveChannel<? extends Object> receiveChannel, FlowCollector<? super R> flowCollector, pr0 pr0Var, x30 x30Var) {
            super(2, x30Var);
            this.$flow = flow;
            this.$scopeContext = dVar;
            this.$cnt = obj;
            this.$second = receiveChannel;
            this.$this_unsafeFlow = flowCollector;
            this.$transform = pr0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            return new AnonymousClass2(this.$flow, this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform, x30Var);
        }

        @Override // defpackage.or0
        public final Object invoke(k83 k83Var, x30 x30Var) {
            return ((AnonymousClass2) create(k83Var, x30Var)).invokeSuspend(k83.a);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = a.d();
            int i = this.label;
            if (i == 0) {
                kotlin.d.b(obj);
                Flow<T1> flow = this.$flow;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform);
                this.label = 1;
                if (flow.collect(anonymousClass1, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.d.b(obj);
            }
            return k83.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CombineKt$zipImpl$1$1(FlowCollector<? super R> flowCollector, Flow<? extends T2> flow, Flow<? extends T1> flow2, pr0 pr0Var, x30 x30Var) {
        super(2, x30Var);
        this.$this_unsafeFlow = flowCollector;
        this.$flow2 = flow;
        this.$flow = flow2;
        this.$transform = pr0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.$this_unsafeFlow, this.$flow2, this.$flow, this.$transform, x30Var);
        combineKt$zipImpl$1$1.L$0 = obj;
        return combineKt$zipImpl$1$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r1v5 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ReceiveChannel receiveChannel;
        ReceiveChannel receiveChannel2;
        Object objD = a.d();
        ?? r1 = this.label;
        try {
            if (r1 != 0) {
                if (r1 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                receiveChannel2 = (ReceiveChannel) this.L$0;
                try {
                    kotlin.d.b(obj);
                    r1 = receiveChannel2;
                } catch (AbortFlowException e) {
                    e = e;
                    FlowExceptions_commonKt.checkOwnership(e, this.$this_unsafeFlow);
                    r1 = receiveChannel2;
                }
                ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) r1, (CancellationException) null, 1, (Object) null);
                return k83.a;
            }
            kotlin.d.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ReceiveChannel receiveChannelProduce$default = ProduceKt.produce$default(coroutineScope, null, 0, new CombineKt$zipImpl$1$1$second$1(this.$flow2, null), 3, null);
            final CompletableJob completableJobJob$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
            p31.d(receiveChannelProduce$default, "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>");
            final FlowCollector flowCollector = this.$this_unsafeFlow;
            ((SendChannel) receiveChannelProduce$default).invokeOnClose(new ar0() { // from class: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // defpackage.ar0
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((Throwable) obj2);
                    return k83.a;
                }

                public final void invoke(Throwable th) {
                    if (completableJobJob$default.isActive()) {
                        completableJobJob$default.cancel((CancellationException) new AbortFlowException(flowCollector));
                    }
                }
            });
            try {
                d coroutineContext = coroutineScope.getCoroutineContext();
                Object objThreadContextElements = ThreadContextKt.threadContextElements(coroutineContext);
                d dVarPlus = coroutineScope.getCoroutineContext().plus(completableJobJob$default);
                k83 k83Var = k83.a;
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$flow, coroutineContext, objThreadContextElements, receiveChannelProduce$default, this.$this_unsafeFlow, this.$transform, null);
                this.L$0 = receiveChannelProduce$default;
                this.label = 1;
                receiveChannel = receiveChannelProduce$default;
                try {
                    if (ChannelFlowKt.withContextUndispatched$default(dVarPlus, k83Var, null, anonymousClass2, this, 4, null) == objD) {
                        return objD;
                    }
                    r1 = receiveChannel;
                    ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) r1, (CancellationException) null, 1, (Object) null);
                    return k83.a;
                } catch (AbortFlowException e2) {
                    e = e2;
                    receiveChannel2 = receiveChannel;
                    FlowExceptions_commonKt.checkOwnership(e, this.$this_unsafeFlow);
                    r1 = receiveChannel2;
                } catch (Throwable th) {
                    th = th;
                    r1 = receiveChannel;
                    ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) r1, (CancellationException) null, 1, (Object) null);
                    throw th;
                }
            } catch (AbortFlowException e3) {
                e = e3;
                receiveChannel = receiveChannelProduce$default;
            } catch (Throwable th2) {
                th = th2;
                receiveChannel = receiveChannelProduce$default;
            }
            FlowExceptions_commonKt.checkOwnership(e, this.$this_unsafeFlow);
            r1 = receiveChannel2;
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) r1, (CancellationException) null, 1, (Object) null);
            return k83.a;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((CombineKt$zipImpl$1$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
