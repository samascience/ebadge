package kotlinx.coroutines.flow;

import defpackage.k83;
import defpackage.pr0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.d;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes4.dex */
final class FlowKt__TransformKt$runningFold$1$1<T> implements FlowCollector {
    final /* synthetic */ Ref$ObjectRef<R> $accumulator;
    final /* synthetic */ pr0 $operation;
    final /* synthetic */ FlowCollector<R> $this_unsafeFlow;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__TransformKt$runningFold$1$1(Ref$ObjectRef<R> ref$ObjectRef, pr0 pr0Var, FlowCollector<? super R> flowCollector) {
        this.$accumulator = ref$ObjectRef;
        this.$operation = pr0Var;
        this.$this_unsafeFlow = flowCollector;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T t, x30 x30Var) throws Throwable {
        FlowKt__TransformKt$runningFold$1$1$emit$1 flowKt__TransformKt$runningFold$1$1$emit$1;
        FlowKt__TransformKt$runningFold$1$1<T> flowKt__TransformKt$runningFold$1$1;
        Ref$ObjectRef ref$ObjectRef;
        if (x30Var instanceof FlowKt__TransformKt$runningFold$1$1$emit$1) {
            flowKt__TransformKt$runningFold$1$1$emit$1 = (FlowKt__TransformKt$runningFold$1$1$emit$1) x30Var;
            int i = flowKt__TransformKt$runningFold$1$1$emit$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__TransformKt$runningFold$1$1$emit$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__TransformKt$runningFold$1$1$emit$1 = new FlowKt__TransformKt$runningFold$1$1$emit$1(this, x30Var);
            }
        } else {
            flowKt__TransformKt$runningFold$1$1$emit$1 = new FlowKt__TransformKt$runningFold$1$1$emit$1(this, x30Var);
        }
        Object obj = flowKt__TransformKt$runningFold$1$1$emit$1.result;
        Object objD = a.d();
        int i2 = flowKt__TransformKt$runningFold$1$1$emit$1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                ref$ObjectRef = (Ref$ObjectRef) flowKt__TransformKt$runningFold$1$1$emit$1.L$1;
                flowKt__TransformKt$runningFold$1$1 = (FlowKt__TransformKt$runningFold$1$1) flowKt__TransformKt$runningFold$1$1$emit$1.L$0;
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
        Ref$ObjectRef ref$ObjectRef2 = this.$accumulator;
        pr0 pr0Var = this.$operation;
        T t2 = ref$ObjectRef2.element;
        flowKt__TransformKt$runningFold$1$1$emit$1.L$0 = this;
        flowKt__TransformKt$runningFold$1$1$emit$1.L$1 = ref$ObjectRef2;
        flowKt__TransformKt$runningFold$1$1$emit$1.label = 1;
        Object objInvoke = pr0Var.invoke(t2, t, flowKt__TransformKt$runningFold$1$1$emit$1);
        if (objInvoke == objD) {
            return objD;
        }
        flowKt__TransformKt$runningFold$1$1 = this;
        obj = (T) objInvoke;
        ref$ObjectRef = ref$ObjectRef2;
        ref$ObjectRef.element = (T) obj;
        FlowCollector<R> flowCollector = flowKt__TransformKt$runningFold$1$1.$this_unsafeFlow;
        T t3 = flowKt__TransformKt$runningFold$1$1.$accumulator.element;
        flowKt__TransformKt$runningFold$1$1$emit$1.L$0 = null;
        flowKt__TransformKt$runningFold$1$1$emit$1.L$1 = null;
        flowKt__TransformKt$runningFold$1$1$emit$1.label = 2;
        if (flowCollector.emit((R) t3, flowKt__TransformKt$runningFold$1$1$emit$1) == objD) {
            return objD;
        }
        return k83.a;
    }
}
