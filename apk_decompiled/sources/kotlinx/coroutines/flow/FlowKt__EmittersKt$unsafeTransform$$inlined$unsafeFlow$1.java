package kotlinx.coroutines.flow;

import defpackage.j21;
import defpackage.k83;
import defpackage.pr0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes4.dex */
public final class FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1<R> implements Flow<R> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ pr0 $transform$inlined;

    public FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1(Flow flow, pr0 pr0Var) {
        this.$this_unsafeTransform$inlined = flow;
        this.$transform$inlined = pr0Var;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super R> flowCollector, x30 x30Var) {
        Object objCollect = this.$this_unsafeTransform$inlined.collect(new FlowKt__EmittersKt$unsafeTransform$1$1(this.$transform$inlined, flowCollector), x30Var);
        return objCollect == a.d() ? objCollect : k83.a;
    }

    public Object collect$$forInline(FlowCollector flowCollector, x30 x30Var) {
        j21.c(4);
        new ContinuationImpl(x30Var) { // from class: kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1.this.collect(null, this);
            }
        };
        j21.c(5);
        Flow flow = this.$this_unsafeTransform$inlined;
        FlowKt__EmittersKt$unsafeTransform$1$1 flowKt__EmittersKt$unsafeTransform$1$1 = new FlowKt__EmittersKt$unsafeTransform$1$1(this.$transform$inlined, flowCollector);
        j21.c(0);
        flow.collect(flowKt__EmittersKt$unsafeTransform$1$1, x30Var);
        j21.c(1);
        return k83.a;
    }
}
