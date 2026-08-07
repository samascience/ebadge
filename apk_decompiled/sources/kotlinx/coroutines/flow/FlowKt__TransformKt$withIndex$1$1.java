package kotlinx.coroutines.flow;

import defpackage.b21;
import defpackage.k83;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.d;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: loaded from: classes4.dex */
final class FlowKt__TransformKt$withIndex$1$1<T> implements FlowCollector {
    final /* synthetic */ Ref$IntRef $index;
    final /* synthetic */ FlowCollector<b21> $this_unsafeFlow;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__TransformKt$withIndex$1$1(FlowCollector<? super b21> flowCollector, Ref$IntRef ref$IntRef) {
        this.$this_unsafeFlow = flowCollector;
        this.$index = ref$IntRef;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T t, x30 x30Var) throws Throwable {
        FlowKt__TransformKt$withIndex$1$1$emit$1 flowKt__TransformKt$withIndex$1$1$emit$1;
        if (x30Var instanceof FlowKt__TransformKt$withIndex$1$1$emit$1) {
            flowKt__TransformKt$withIndex$1$1$emit$1 = (FlowKt__TransformKt$withIndex$1$1$emit$1) x30Var;
            int i = flowKt__TransformKt$withIndex$1$1$emit$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__TransformKt$withIndex$1$1$emit$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__TransformKt$withIndex$1$1$emit$1 = new FlowKt__TransformKt$withIndex$1$1$emit$1(this, x30Var);
            }
        } else {
            flowKt__TransformKt$withIndex$1$1$emit$1 = new FlowKt__TransformKt$withIndex$1$1$emit$1(this, x30Var);
        }
        Object obj = flowKt__TransformKt$withIndex$1$1$emit$1.result;
        Object objD = a.d();
        int i2 = flowKt__TransformKt$withIndex$1$1$emit$1.label;
        if (i2 == 0) {
            d.b(obj);
            FlowCollector<b21> flowCollector = this.$this_unsafeFlow;
            Ref$IntRef ref$IntRef = this.$index;
            int i3 = ref$IntRef.element;
            ref$IntRef.element = i3 + 1;
            if (i3 < 0) {
                throw new ArithmeticException("Index overflow has happened");
            }
            b21 b21Var = new b21(i3, t);
            flowKt__TransformKt$withIndex$1$1$emit$1.label = 1;
            if (flowCollector.emit(b21Var, flowKt__TransformKt$withIndex$1$1$emit$1) == objD) {
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
}
