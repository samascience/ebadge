package kotlinx.coroutines.flow;

import defpackage.j21;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.d;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes4.dex */
public final class FlowKt__LimitKt$collectWhile$collector$1<T> implements FlowCollector<T> {
    final /* synthetic */ or0 $predicate;

    public FlowKt__LimitKt$collectWhile$collector$1(or0 or0Var) {
        this.$predicate = or0Var;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, x30 x30Var) throws Throwable {
        FlowKt__LimitKt$collectWhile$collector$1$emit$1 flowKt__LimitKt$collectWhile$collector$1$emit$1;
        FlowKt__LimitKt$collectWhile$collector$1<T> flowKt__LimitKt$collectWhile$collector$1;
        if (x30Var instanceof FlowKt__LimitKt$collectWhile$collector$1$emit$1) {
            flowKt__LimitKt$collectWhile$collector$1$emit$1 = (FlowKt__LimitKt$collectWhile$collector$1$emit$1) x30Var;
            int i = flowKt__LimitKt$collectWhile$collector$1$emit$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$collectWhile$collector$1$emit$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__LimitKt$collectWhile$collector$1$emit$1 = new FlowKt__LimitKt$collectWhile$collector$1$emit$1(this, x30Var);
            }
        } else {
            flowKt__LimitKt$collectWhile$collector$1$emit$1 = new FlowKt__LimitKt$collectWhile$collector$1$emit$1(this, x30Var);
        }
        Object objInvoke = flowKt__LimitKt$collectWhile$collector$1$emit$1.result;
        Object objD = a.d();
        int i2 = flowKt__LimitKt$collectWhile$collector$1$emit$1.label;
        if (i2 == 0) {
            d.b(objInvoke);
            or0 or0Var = this.$predicate;
            flowKt__LimitKt$collectWhile$collector$1$emit$1.L$0 = this;
            flowKt__LimitKt$collectWhile$collector$1$emit$1.label = 1;
            objInvoke = or0Var.invoke(t, flowKt__LimitKt$collectWhile$collector$1$emit$1);
            if (objInvoke == objD) {
                return objD;
            }
            flowKt__LimitKt$collectWhile$collector$1 = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowKt__LimitKt$collectWhile$collector$1 = (FlowKt__LimitKt$collectWhile$collector$1) flowKt__LimitKt$collectWhile$collector$1$emit$1.L$0;
            d.b(objInvoke);
        }
        if (((Boolean) objInvoke).booleanValue()) {
            return k83.a;
        }
        throw new AbortFlowException(flowKt__LimitKt$collectWhile$collector$1);
    }

    public Object emit$$forInline(T t, x30 x30Var) {
        j21.c(4);
        new FlowKt__LimitKt$collectWhile$collector$1$emit$1(this, x30Var);
        j21.c(5);
        if (((Boolean) this.$predicate.invoke(t, x30Var)).booleanValue()) {
            return k83.a;
        }
        throw new AbortFlowException(this);
    }
}
