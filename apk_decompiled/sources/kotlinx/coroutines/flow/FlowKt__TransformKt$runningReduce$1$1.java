package kotlinx.coroutines.flow;

import defpackage.k83;
import defpackage.pr0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: loaded from: classes4.dex */
final class FlowKt__TransformKt$runningReduce$1$1<T> implements FlowCollector {
    final /* synthetic */ Ref$ObjectRef<Object> $accumulator;
    final /* synthetic */ pr0 $operation;
    final /* synthetic */ FlowCollector<T> $this_unsafeFlow;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__TransformKt$runningReduce$1$1(Ref$ObjectRef<Object> ref$ObjectRef, pr0 pr0Var, FlowCollector<? super T> flowCollector) {
        this.$accumulator = ref$ObjectRef;
        this.$operation = pr0Var;
        this.$this_unsafeFlow = flowCollector;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0078 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T t, x30 x30Var) throws Throwable {
        FlowKt__TransformKt$runningReduce$1$1$emit$1 flowKt__TransformKt$runningReduce$1$1$emit$1;
        Ref$ObjectRef<Object> ref$ObjectRef;
        FlowKt__TransformKt$runningReduce$1$1<T> flowKt__TransformKt$runningReduce$1$1;
        Ref$ObjectRef<Object> ref$ObjectRef2;
        FlowCollector<T> flowCollector;
        T t2;
        if (x30Var instanceof FlowKt__TransformKt$runningReduce$1$1$emit$1) {
            flowKt__TransformKt$runningReduce$1$1$emit$1 = (FlowKt__TransformKt$runningReduce$1$1$emit$1) x30Var;
            int i = flowKt__TransformKt$runningReduce$1$1$emit$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__TransformKt$runningReduce$1$1$emit$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__TransformKt$runningReduce$1$1$emit$1 = new FlowKt__TransformKt$runningReduce$1$1$emit$1(this, x30Var);
            }
        } else {
            flowKt__TransformKt$runningReduce$1$1$emit$1 = new FlowKt__TransformKt$runningReduce$1$1$emit$1(this, x30Var);
        }
        Object obj = flowKt__TransformKt$runningReduce$1$1$emit$1.result;
        Object objD = a.d();
        int i2 = flowKt__TransformKt$runningReduce$1$1$emit$1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                ref$ObjectRef2 = (Ref$ObjectRef) flowKt__TransformKt$runningReduce$1$1$emit$1.L$1;
                flowKt__TransformKt$runningReduce$1$1 = (FlowKt__TransformKt$runningReduce$1$1) flowKt__TransformKt$runningReduce$1$1$emit$1.L$0;
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
        ref$ObjectRef = this.$accumulator;
        Object obj2 = ref$ObjectRef.element;
        if (obj2 == NullSurrogateKt.NULL) {
            flowKt__TransformKt$runningReduce$1$1 = this;
        } else {
            pr0 pr0Var = this.$operation;
            flowKt__TransformKt$runningReduce$1$1$emit$1.L$0 = this;
            flowKt__TransformKt$runningReduce$1$1$emit$1.L$1 = ref$ObjectRef;
            flowKt__TransformKt$runningReduce$1$1$emit$1.label = 1;
            Object objInvoke = pr0Var.invoke(obj2, t, flowKt__TransformKt$runningReduce$1$1$emit$1);
            if (objInvoke == objD) {
                return objD;
            }
            flowKt__TransformKt$runningReduce$1$1 = this;
            obj = objInvoke;
            ref$ObjectRef2 = ref$ObjectRef;
        }
        ref$ObjectRef.element = t;
        flowCollector = flowKt__TransformKt$runningReduce$1$1.$this_unsafeFlow;
        t2 = flowKt__TransformKt$runningReduce$1$1.$accumulator.element;
        flowKt__TransformKt$runningReduce$1$1$emit$1.L$0 = null;
        flowKt__TransformKt$runningReduce$1$1$emit$1.L$1 = null;
        flowKt__TransformKt$runningReduce$1$1$emit$1.label = 2;
        if (flowCollector.emit(t2, flowKt__TransformKt$runningReduce$1$1$emit$1) == objD) {
            return objD;
        }
        return k83.a;
        Object obj3 = obj;
        ref$ObjectRef = ref$ObjectRef2;
        t = (T) obj3;
        ref$ObjectRef.element = t;
        flowCollector = flowKt__TransformKt$runningReduce$1$1.$this_unsafeFlow;
        t2 = flowKt__TransformKt$runningReduce$1$1.$accumulator.element;
        flowKt__TransformKt$runningReduce$1$1$emit$1.L$0 = null;
        flowKt__TransformKt$runningReduce$1$1$emit$1.L$1 = null;
        flowKt__TransformKt$runningReduce$1$1$emit$1.label = 2;
        if (flowCollector.emit(t2, flowKt__TransformKt$runningReduce$1$1$emit$1) == objD) {
            return objD;
        }
        return k83.a;
    }
}
