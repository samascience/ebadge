package kotlinx.coroutines.flow.internal;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.pr0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlinx.coroutines.flow.internal.FlowCoroutineKt$scopedFlow$1$1", f = "FlowCoroutine.kt", l = {51}, m = "invokeSuspend")
final class FlowCoroutineKt$scopedFlow$1$1 extends SuspendLambda implements or0 {
    final /* synthetic */ pr0 $block;
    final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowCoroutineKt$scopedFlow$1$1(pr0 pr0Var, FlowCollector<? super R> flowCollector, x30 x30Var) {
        super(2, x30Var);
        this.$block = pr0Var;
        this.$this_unsafeFlow = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        FlowCoroutineKt$scopedFlow$1$1 flowCoroutineKt$scopedFlow$1$1 = new FlowCoroutineKt$scopedFlow$1$1(this.$block, this.$this_unsafeFlow, x30Var);
        flowCoroutineKt$scopedFlow$1$1.L$0 = obj;
        return flowCoroutineKt$scopedFlow$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            pr0 pr0Var = this.$block;
            Object obj2 = this.$this_unsafeFlow;
            this.label = 1;
            if (pr0Var.invoke(coroutineScope, obj2, this) == objD) {
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

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((FlowCoroutineKt$scopedFlow$1$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
