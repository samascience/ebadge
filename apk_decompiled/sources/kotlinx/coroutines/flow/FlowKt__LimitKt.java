package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.j21;
import defpackage.k83;
import defpackage.or0;
import defpackage.pr0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class FlowKt__LimitKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__LimitKt", f = "Limit.kt", l = {Opcodes.L2I}, m = "collectWhile")
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__LimitKt.collectWhile(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1, reason: invalid class name and case insensitive filesystem */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1", f = "Limit.kt", l = {Opcodes.DCMPG}, m = "invokeSuspend")
    static final class C02381 extends SuspendLambda implements or0 {
        final /* synthetic */ Flow<T> $this_transformWhile;
        final /* synthetic */ pr0 $transform;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C02381(Flow<? extends T> flow, pr0 pr0Var, x30 x30Var) {
            super(2, x30Var);
            this.$this_transformWhile = flow;
            this.$transform = pr0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            C02381 c02381 = new C02381(this.$this_transformWhile, this.$transform, x30Var);
            c02381.L$0 = obj;
            return c02381;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1;
            Object objD = a.d();
            int i = this.label;
            if (i == 0) {
                d.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Flow<T> flow = this.$this_transformWhile;
                FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$2 = new FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1(this.$transform, flowCollector);
                try {
                    this.L$0 = flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$2;
                    this.label = 1;
                    if (flow.collect(flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$2, this) == objD) {
                        return objD;
                    }
                } catch (AbortFlowException e) {
                    e = e;
                    flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 = flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$2;
                    FlowExceptions_commonKt.checkOwnership(e, flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1);
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 = (FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1) this.L$0;
                try {
                    d.b(obj);
                } catch (AbortFlowException e2) {
                    e = e2;
                    FlowExceptions_commonKt.checkOwnership(e, flowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1);
                }
            }
            return k83.a;
        }

        @Override // defpackage.or0
        public final Object invoke(FlowCollector<? super R> flowCollector, x30 x30Var) {
            return ((C02381) create(flowCollector, x30Var)).invokeSuspend(k83.a);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object collectWhile(Flow<? extends T> flow, or0 or0Var, x30 x30Var) throws Throwable {
        AnonymousClass1 anonymousClass1;
        FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$1;
        if (x30Var instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) x30Var;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(x30Var);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(x30Var);
        }
        Object obj = anonymousClass1.result;
        Object objD = a.d();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            d.b(obj);
            FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$2 = new FlowKt__LimitKt$collectWhile$collector$1(or0Var);
            try {
                anonymousClass1.L$0 = flowKt__LimitKt$collectWhile$collector$2;
                anonymousClass1.label = 1;
                if (flow.collect(flowKt__LimitKt$collectWhile$collector$2, anonymousClass1) == objD) {
                    return objD;
                }
            } catch (AbortFlowException e) {
                e = e;
                flowKt__LimitKt$collectWhile$collector$1 = flowKt__LimitKt$collectWhile$collector$2;
                FlowExceptions_commonKt.checkOwnership(e, flowKt__LimitKt$collectWhile$collector$1);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowKt__LimitKt$collectWhile$collector$1 = (FlowKt__LimitKt$collectWhile$collector$1) anonymousClass1.L$0;
            try {
                d.b(obj);
            } catch (AbortFlowException e2) {
                e = e2;
                FlowExceptions_commonKt.checkOwnership(e, flowKt__LimitKt$collectWhile$collector$1);
            }
        }
        return k83.a;
    }

    private static final <T> Object collectWhile$$forInline(Flow<? extends T> flow, or0 or0Var, x30 x30Var) {
        FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$1 = new FlowKt__LimitKt$collectWhile$collector$1(or0Var);
        try {
            j21.c(0);
            flow.collect(flowKt__LimitKt$collectWhile$collector$1, x30Var);
            j21.c(1);
        } catch (AbortFlowException e) {
            FlowExceptions_commonKt.checkOwnership(e, flowKt__LimitKt$collectWhile$collector$1);
        }
        return k83.a;
    }

    public static final <T> Flow<T> drop(final Flow<? extends T> flow, final int i) {
        if (i >= 0) {
            return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$drop$$inlined$unsafeFlow$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super T> flowCollector, x30 x30Var) {
                    Object objCollect = flow.collect(new FlowKt__LimitKt$drop$2$1(new Ref$IntRef(), i, flowCollector), x30Var);
                    return objCollect == a.d() ? objCollect : k83.a;
                }
            };
        }
        throw new IllegalArgumentException(("Drop count should be non-negative, but had " + i).toString());
    }

    public static final <T> Flow<T> dropWhile(final Flow<? extends T> flow, final or0 or0Var) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super T> flowCollector, x30 x30Var) {
                Object objCollect = flow.collect(new FlowKt__LimitKt$dropWhile$1$1(new Ref$BooleanRef(), flowCollector, or0Var), x30Var);
                return objCollect == a.d() ? objCollect : k83.a;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Object emitAbort$FlowKt__LimitKt(FlowCollector<? super T> flowCollector, T t, x30 x30Var) throws Throwable {
        FlowKt__LimitKt$emitAbort$1 flowKt__LimitKt$emitAbort$1;
        if (x30Var instanceof FlowKt__LimitKt$emitAbort$1) {
            flowKt__LimitKt$emitAbort$1 = (FlowKt__LimitKt$emitAbort$1) x30Var;
            int i = flowKt__LimitKt$emitAbort$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$emitAbort$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__LimitKt$emitAbort$1 = new FlowKt__LimitKt$emitAbort$1(x30Var);
            }
        } else {
            flowKt__LimitKt$emitAbort$1 = new FlowKt__LimitKt$emitAbort$1(x30Var);
        }
        Object obj = flowKt__LimitKt$emitAbort$1.result;
        Object objD = a.d();
        int i2 = flowKt__LimitKt$emitAbort$1.label;
        if (i2 == 0) {
            d.b(obj);
            flowKt__LimitKt$emitAbort$1.L$0 = flowCollector;
            flowKt__LimitKt$emitAbort$1.label = 1;
            if (flowCollector.emit(t, flowKt__LimitKt$emitAbort$1) == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowCollector) flowKt__LimitKt$emitAbort$1.L$0;
            d.b(obj);
        }
        throw new AbortFlowException(flowCollector);
    }

    public static final <T> Flow<T> take(Flow<? extends T> flow, int i) {
        if (i > 0) {
            return new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(flow, i);
        }
        throw new IllegalArgumentException(("Requested element count " + i + " should be positive").toString());
    }

    public static final <T> Flow<T> takeWhile(Flow<? extends T> flow, or0 or0Var) {
        return new FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1(flow, or0Var);
    }

    public static final <T, R> Flow<R> transformWhile(Flow<? extends T> flow, pr0 pr0Var) {
        return FlowKt.flow(new C02381(flow, pr0Var, null));
    }
}
