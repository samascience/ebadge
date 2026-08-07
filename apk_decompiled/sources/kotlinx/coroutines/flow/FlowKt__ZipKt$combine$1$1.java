package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.k83;
import defpackage.pr0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1", f = "Zip.kt", l = {33, 33}, m = "invokeSuspend")
final class FlowKt__ZipKt$combine$1$1 extends SuspendLambda implements pr0 {
    final /* synthetic */ pr0 $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__ZipKt$combine$1$1(pr0 pr0Var, x30 x30Var) {
        super(3, x30Var);
        this.$transform = pr0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        FlowCollector flowCollector;
        Object objD = a.d();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                flowCollector = (FlowCollector) this.L$0;
                d.b(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj);
            }
            return k83.a;
        }
        d.b(obj);
        flowCollector = (FlowCollector) this.L$0;
        Object[] objArr = (Object[]) this.L$1;
        pr0 pr0Var = this.$transform;
        Object obj2 = objArr[0];
        Object obj3 = objArr[1];
        this.L$0 = flowCollector;
        this.label = 1;
        obj = pr0Var.invoke(obj2, obj3, this);
        if (obj == objD) {
            return objD;
        }
        this.L$0 = null;
        this.label = 2;
        if (flowCollector.emit(obj, this) == objD) {
            return objD;
        }
        return k83.a;
    }

    @Override // defpackage.pr0
    public final Object invoke(FlowCollector<? super R> flowCollector, Object[] objArr, x30 x30Var) {
        FlowKt__ZipKt$combine$1$1 flowKt__ZipKt$combine$1$1 = new FlowKt__ZipKt$combine$1$1(this.$transform, x30Var);
        flowKt__ZipKt$combine$1$1.L$0 = flowCollector;
        flowKt__ZipKt$combine$1$1.L$1 = objArr;
        return flowKt__ZipKt$combine$1$1.invokeSuspend(k83.a);
    }
}
