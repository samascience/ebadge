package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.j21;
import defpackage.k83;
import defpackage.oi0;
import defpackage.or0;
import defpackage.pr0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class FlowKt__EmittersKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1", f = "Emitters.kt", l = {40}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements or0 {
        final /* synthetic */ Flow<T> $this_transform;
        final /* synthetic */ pr0 $transform;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01351<T> implements FlowCollector {
            final /* synthetic */ FlowCollector<R> $$this$flow;
            final /* synthetic */ pr0 $transform;

            /* JADX WARN: Multi-variable type inference failed */
            public C01351(pr0 pr0Var, FlowCollector<? super R> flowCollector) {
                this.$transform = pr0Var;
                this.$$this$flow = flowCollector;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(T t, x30 x30Var) throws Throwable {
                FlowKt__EmittersKt$transform$1$1$emit$1 flowKt__EmittersKt$transform$1$1$emit$1;
                if (x30Var instanceof FlowKt__EmittersKt$transform$1$1$emit$1) {
                    flowKt__EmittersKt$transform$1$1$emit$1 = (FlowKt__EmittersKt$transform$1$1$emit$1) x30Var;
                    int i = flowKt__EmittersKt$transform$1$1$emit$1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        flowKt__EmittersKt$transform$1$1$emit$1.label = i - Integer.MIN_VALUE;
                    } else {
                        flowKt__EmittersKt$transform$1$1$emit$1 = new FlowKt__EmittersKt$transform$1$1$emit$1(this, x30Var);
                    }
                } else {
                    flowKt__EmittersKt$transform$1$1$emit$1 = new FlowKt__EmittersKt$transform$1$1$emit$1(this, x30Var);
                }
                Object obj = flowKt__EmittersKt$transform$1$1$emit$1.result;
                Object objD = a.d();
                int i2 = flowKt__EmittersKt$transform$1$1$emit$1.label;
                if (i2 == 0) {
                    d.b(obj);
                    pr0 pr0Var = this.$transform;
                    Object obj2 = this.$$this$flow;
                    flowKt__EmittersKt$transform$1$1$emit$1.label = 1;
                    if (pr0Var.invoke(obj2, t, flowKt__EmittersKt$transform$1$1$emit$1) == objD) {
                        return objD;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d.b(obj);
                }
                return k83.a;
            }

            public final Object emit$$forInline(T t, x30 x30Var) {
                j21.c(4);
                new FlowKt__EmittersKt$transform$1$1$emit$1(this, x30Var);
                j21.c(5);
                this.$transform.invoke(this.$$this$flow, t, x30Var);
                return k83.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Flow<? extends T> flow, pr0 pr0Var, x30 x30Var) {
            super(2, x30Var);
            this.$this_transform = flow;
            this.$transform = pr0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_transform, this.$transform, x30Var);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = a.d();
            int i = this.label;
            if (i == 0) {
                d.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Flow<T> flow = this.$this_transform;
                C01351 c01351 = new C01351(this.$transform, flowCollector);
                this.label = 1;
                if (flow.collect(c01351, this) == objD) {
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

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object invokeSuspend$$forInline(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Flow<T> flow = this.$this_transform;
            C01351 c01351 = new C01351(this.$transform, flowCollector);
            j21.c(0);
            flow.collect(c01351, this);
            j21.c(1);
            return k83.a;
        }

        @Override // defpackage.or0
        public final Object invoke(FlowCollector<? super R> flowCollector, x30 x30Var) {
            return ((AnonymousClass1) create(flowCollector, x30Var)).invokeSuspend(k83.a);
        }
    }

    public static final void ensureActive(FlowCollector<?> flowCollector) {
        if (flowCollector instanceof ThrowingCollector) {
            throw ((ThrowingCollector) flowCollector).e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object invokeSafely$FlowKt__EmittersKt(FlowCollector<? super T> flowCollector, pr0 pr0Var, Throwable th, x30 x30Var) throws Throwable {
        FlowKt__EmittersKt$invokeSafely$1 flowKt__EmittersKt$invokeSafely$1;
        if (x30Var instanceof FlowKt__EmittersKt$invokeSafely$1) {
            flowKt__EmittersKt$invokeSafely$1 = (FlowKt__EmittersKt$invokeSafely$1) x30Var;
            int i = flowKt__EmittersKt$invokeSafely$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__EmittersKt$invokeSafely$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__EmittersKt$invokeSafely$1 = new FlowKt__EmittersKt$invokeSafely$1(x30Var);
            }
        } else {
            flowKt__EmittersKt$invokeSafely$1 = new FlowKt__EmittersKt$invokeSafely$1(x30Var);
        }
        Object obj = flowKt__EmittersKt$invokeSafely$1.result;
        Object objD = a.d();
        int i2 = flowKt__EmittersKt$invokeSafely$1.label;
        try {
            if (i2 == 0) {
                d.b(obj);
                flowKt__EmittersKt$invokeSafely$1.L$0 = th;
                flowKt__EmittersKt$invokeSafely$1.label = 1;
                if (pr0Var.invoke(flowCollector, th, flowKt__EmittersKt$invokeSafely$1) == objD) {
                    return objD;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = (Throwable) flowKt__EmittersKt$invokeSafely$1.L$0;
                d.b(obj);
            }
            return k83.a;
        } catch (Throwable th2) {
            if (th != null && th != th2) {
                oi0.a(th2, th);
            }
            throw th2;
        }
    }

    public static final <T> Flow<T> onCompletion(Flow<? extends T> flow, pr0 pr0Var) {
        return new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(flow, pr0Var);
    }

    public static final <T> Flow<T> onEmpty(Flow<? extends T> flow, or0 or0Var) {
        return new FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1(flow, or0Var);
    }

    public static final <T> Flow<T> onStart(Flow<? extends T> flow, or0 or0Var) {
        return new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(or0Var, flow);
    }

    public static final <T, R> Flow<R> transform(Flow<? extends T> flow, pr0 pr0Var) {
        return FlowKt.flow(new AnonymousClass1(flow, pr0Var, null));
    }

    public static final <T, R> Flow<R> unsafeTransform(Flow<? extends T> flow, pr0 pr0Var) {
        return new FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1(flow, pr0Var);
    }
}
