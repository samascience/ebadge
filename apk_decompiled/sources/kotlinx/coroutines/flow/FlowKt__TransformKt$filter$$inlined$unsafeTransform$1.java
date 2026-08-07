package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.j21;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.d;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes4.dex */
public final class FlowKt__TransformKt$filter$$inlined$unsafeTransform$1<T> implements Flow<T> {
    final /* synthetic */ or0 $predicate$inlined;
    final /* synthetic */ Flow $this_unsafeTransform$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ or0 $predicate$inlined;
        final /* synthetic */ FlowCollector $this_unsafeFlow;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
        @h70(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", f = "Transform.kt", l = {223, 223}, m = "emit")
        public static final class AnonymousClass1 extends ContinuationImpl {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;

            public AnonymousClass1(x30 x30Var) {
                super(x30Var);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public AnonymousClass2(FlowCollector flowCollector, or0 or0Var) {
            this.$this_unsafeFlow = flowCollector;
            this.$predicate$inlined = or0Var;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T t, x30 x30Var) throws Throwable {
            AnonymousClass1 anonymousClass1;
            Object obj;
            FlowCollector flowCollector;
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
            Object obj2 = anonymousClass1.result;
            Object objD = a.d();
            int i2 = anonymousClass1.label;
            if (i2 != 0) {
                if (i2 == 1) {
                    FlowCollector flowCollector2 = (FlowCollector) anonymousClass1.L$1;
                    obj = anonymousClass1.L$0;
                    d.b(obj2);
                    flowCollector = flowCollector2;
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d.b(obj2);
                }
                return k83.a;
            }
            d.b(obj2);
            FlowCollector flowCollector3 = this.$this_unsafeFlow;
            or0 or0Var = this.$predicate$inlined;
            anonymousClass1.L$0 = t;
            anonymousClass1.L$1 = flowCollector3;
            anonymousClass1.label = 1;
            Object objInvoke = or0Var.invoke(t, anonymousClass1);
            if (objInvoke == objD) {
                return objD;
            }
            obj = t;
            flowCollector = flowCollector3;
            obj2 = objInvoke;
            if (((Boolean) obj2).booleanValue()) {
                anonymousClass1.L$0 = null;
                anonymousClass1.L$1 = null;
                anonymousClass1.label = 2;
                if (flowCollector.emit(obj, anonymousClass1) == objD) {
                    return objD;
                }
            }
            return k83.a;
        }

        public final Object emit$$forInline(Object obj, x30 x30Var) {
            j21.c(4);
            new AnonymousClass1(x30Var);
            j21.c(5);
            FlowCollector flowCollector = this.$this_unsafeFlow;
            if (((Boolean) this.$predicate$inlined.invoke(obj, x30Var)).booleanValue()) {
                j21.c(0);
                flowCollector.emit(obj, x30Var);
                j21.c(1);
            }
            return k83.a;
        }
    }

    public FlowKt__TransformKt$filter$$inlined$unsafeTransform$1(Flow flow, or0 or0Var) {
        this.$this_unsafeTransform$inlined = flow;
        this.$predicate$inlined = or0Var;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, x30 x30Var) {
        Object objCollect = this.$this_unsafeTransform$inlined.collect(new AnonymousClass2(flowCollector, this.$predicate$inlined), x30Var);
        return objCollect == a.d() ? objCollect : k83.a;
    }

    public Object collect$$forInline(FlowCollector flowCollector, x30 x30Var) {
        j21.c(4);
        new ContinuationImpl(x30Var) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__TransformKt$filter$$inlined$unsafeTransform$1.this.collect(null, this);
            }
        };
        j21.c(5);
        Flow flow = this.$this_unsafeTransform$inlined;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(flowCollector, this.$predicate$inlined);
        j21.c(0);
        flow.collect(anonymousClass2, x30Var);
        j21.c(1);
        return k83.a;
    }
}
