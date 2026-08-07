package kotlinx.coroutines.flow;

import defpackage.k83;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.d;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: loaded from: classes4.dex */
final class FlowKt__LimitKt$drop$2$1<T> implements FlowCollector {
    final /* synthetic */ int $count;
    final /* synthetic */ Ref$IntRef $skipped;
    final /* synthetic */ FlowCollector<T> $this_unsafeFlow;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__LimitKt$drop$2$1(Ref$IntRef ref$IntRef, int i, FlowCollector<? super T> flowCollector) {
        this.$skipped = ref$IntRef;
        this.$count = i;
        this.$this_unsafeFlow = flowCollector;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T t, x30 x30Var) throws Throwable {
        FlowKt__LimitKt$drop$2$1$emit$1 flowKt__LimitKt$drop$2$1$emit$1;
        if (x30Var instanceof FlowKt__LimitKt$drop$2$1$emit$1) {
            flowKt__LimitKt$drop$2$1$emit$1 = (FlowKt__LimitKt$drop$2$1$emit$1) x30Var;
            int i = flowKt__LimitKt$drop$2$1$emit$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$drop$2$1$emit$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__LimitKt$drop$2$1$emit$1 = new FlowKt__LimitKt$drop$2$1$emit$1(this, x30Var);
            }
        } else {
            flowKt__LimitKt$drop$2$1$emit$1 = new FlowKt__LimitKt$drop$2$1$emit$1(this, x30Var);
        }
        Object obj = flowKt__LimitKt$drop$2$1$emit$1.result;
        Object objD = a.d();
        int i2 = flowKt__LimitKt$drop$2$1$emit$1.label;
        if (i2 == 0) {
            d.b(obj);
            Ref$IntRef ref$IntRef = this.$skipped;
            int i3 = ref$IntRef.element;
            if (i3 < this.$count) {
                ref$IntRef.element = i3 + 1;
                return k83.a;
            }
            FlowCollector<T> flowCollector = this.$this_unsafeFlow;
            flowKt__LimitKt$drop$2$1$emit$1.label = 1;
            if (flowCollector.emit(t, flowKt__LimitKt$drop$2$1$emit$1) == objD) {
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
