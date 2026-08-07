package kotlinx.coroutines.flow;

import defpackage.k83;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.d;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: loaded from: classes4.dex */
final class FlowKt__LimitKt$take$2$1<T> implements FlowCollector {
    final /* synthetic */ Ref$IntRef $consumed;
    final /* synthetic */ int $count;
    final /* synthetic */ FlowCollector<T> $this_unsafeFlow;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__LimitKt$take$2$1(Ref$IntRef ref$IntRef, int i, FlowCollector<? super T> flowCollector) {
        this.$consumed = ref$IntRef;
        this.$count = i;
        this.$this_unsafeFlow = flowCollector;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T t, x30 x30Var) throws Throwable {
        FlowKt__LimitKt$take$2$1$emit$1 flowKt__LimitKt$take$2$1$emit$1;
        if (x30Var instanceof FlowKt__LimitKt$take$2$1$emit$1) {
            flowKt__LimitKt$take$2$1$emit$1 = (FlowKt__LimitKt$take$2$1$emit$1) x30Var;
            int i = flowKt__LimitKt$take$2$1$emit$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$take$2$1$emit$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__LimitKt$take$2$1$emit$1 = new FlowKt__LimitKt$take$2$1$emit$1(this, x30Var);
            }
        } else {
            flowKt__LimitKt$take$2$1$emit$1 = new FlowKt__LimitKt$take$2$1$emit$1(this, x30Var);
        }
        Object obj = flowKt__LimitKt$take$2$1$emit$1.result;
        Object objD = a.d();
        int i2 = flowKt__LimitKt$take$2$1$emit$1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                d.b(obj);
                return k83.a;
            }
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d.b(obj);
            return k83.a;
        }
        d.b(obj);
        Ref$IntRef ref$IntRef = this.$consumed;
        int i3 = ref$IntRef.element + 1;
        ref$IntRef.element = i3;
        if (i3 < this.$count) {
            FlowCollector<T> flowCollector = this.$this_unsafeFlow;
            flowKt__LimitKt$take$2$1$emit$1.label = 1;
            if (flowCollector.emit(t, flowKt__LimitKt$take$2$1$emit$1) == objD) {
                return objD;
            }
            return k83.a;
        }
        FlowCollector<T> flowCollector2 = this.$this_unsafeFlow;
        flowKt__LimitKt$take$2$1$emit$1.label = 2;
        if (FlowKt__LimitKt.emitAbort$FlowKt__LimitKt(flowCollector2, t, flowKt__LimitKt$take$2$1$emit$1) == objD) {
            return objD;
        }
        return k83.a;
    }
}
