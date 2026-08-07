package kotlinx.coroutines.flow;

import defpackage.j21;
import defpackage.k83;
import defpackage.pr0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.d;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowKt__EmittersKt$unsafeTransform$1$1<T> implements FlowCollector {
    final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
    final /* synthetic */ pr0 $transform;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__EmittersKt$unsafeTransform$1$1(pr0 pr0Var, FlowCollector<? super R> flowCollector) {
        this.$transform = pr0Var;
        this.$this_unsafeFlow = flowCollector;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T t, x30 x30Var) throws Throwable {
        FlowKt__EmittersKt$unsafeTransform$1$1$emit$1 flowKt__EmittersKt$unsafeTransform$1$1$emit$1;
        if (x30Var instanceof FlowKt__EmittersKt$unsafeTransform$1$1$emit$1) {
            flowKt__EmittersKt$unsafeTransform$1$1$emit$1 = (FlowKt__EmittersKt$unsafeTransform$1$1$emit$1) x30Var;
            int i = flowKt__EmittersKt$unsafeTransform$1$1$emit$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__EmittersKt$unsafeTransform$1$1$emit$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__EmittersKt$unsafeTransform$1$1$emit$1 = new FlowKt__EmittersKt$unsafeTransform$1$1$emit$1(this, x30Var);
            }
        } else {
            flowKt__EmittersKt$unsafeTransform$1$1$emit$1 = new FlowKt__EmittersKt$unsafeTransform$1$1$emit$1(this, x30Var);
        }
        Object obj = flowKt__EmittersKt$unsafeTransform$1$1$emit$1.result;
        Object objD = a.d();
        int i2 = flowKt__EmittersKt$unsafeTransform$1$1$emit$1.label;
        if (i2 == 0) {
            d.b(obj);
            pr0 pr0Var = this.$transform;
            Object obj2 = this.$this_unsafeFlow;
            flowKt__EmittersKt$unsafeTransform$1$1$emit$1.label = 1;
            if (pr0Var.invoke(obj2, t, flowKt__EmittersKt$unsafeTransform$1$1$emit$1) == objD) {
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
        new FlowKt__EmittersKt$unsafeTransform$1$1$emit$1(this, x30Var);
        j21.c(5);
        this.$transform.invoke(this.$this_unsafeFlow, t, x30Var);
        return k83.a;
    }
}
