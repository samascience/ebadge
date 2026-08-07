package kotlinx.coroutines.flow;

import defpackage.j21;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes4.dex */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$3<R> implements Flow<R> {
    final /* synthetic */ Flow[] $flowArray$inlined;
    final /* synthetic */ or0 $transform$inlined;

    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$3(Flow[] flowArr, or0 or0Var) {
        this.$flowArray$inlined = flowArr;
        this.$transform$inlined = or0Var;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super R> flowCollector, x30 x30Var) {
        Flow[] flowArr = this.$flowArray$inlined;
        p31.j();
        FlowKt__ZipKt$combine$6$1 flowKt__ZipKt$combine$6$1 = new FlowKt__ZipKt$combine$6$1(this.$flowArray$inlined);
        p31.j();
        Object objCombineInternal = CombineKt.combineInternal(flowCollector, flowArr, flowKt__ZipKt$combine$6$1, new FlowKt__ZipKt$combine$6$2(this.$transform$inlined, null), x30Var);
        return objCombineInternal == a.d() ? objCombineInternal : k83.a;
    }

    public Object collect$$forInline(FlowCollector flowCollector, x30 x30Var) {
        j21.c(4);
        new ContinuationImpl(x30Var) { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$3.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__ZipKt$combine$$inlined$unsafeFlow$3.this.collect(null, this);
            }
        };
        j21.c(5);
        Flow[] flowArr = this.$flowArray$inlined;
        p31.j();
        FlowKt__ZipKt$combine$6$1 flowKt__ZipKt$combine$6$1 = new FlowKt__ZipKt$combine$6$1(this.$flowArray$inlined);
        p31.j();
        FlowKt__ZipKt$combine$6$2 flowKt__ZipKt$combine$6$2 = new FlowKt__ZipKt$combine$6$2(this.$transform$inlined, null);
        j21.c(0);
        CombineKt.combineInternal(flowCollector, flowArr, flowKt__ZipKt$combine$6$1, flowKt__ZipKt$combine$6$2, x30Var);
        j21.c(1);
        return k83.a;
    }
}
