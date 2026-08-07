package kotlinx.coroutines.flow.internal;

import defpackage.j70;
import defpackage.k83;
import defpackage.or0;
import defpackage.pr0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowCoroutineKt {
    public static final <R> Object flowScope(or0 or0Var, x30 x30Var) {
        FlowCoroutine flowCoroutine = new FlowCoroutine(x30Var.getContext(), x30Var);
        Object objStartUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(flowCoroutine, flowCoroutine, or0Var);
        if (objStartUndispatchedOrReturn == a.d()) {
            j70.c(x30Var);
        }
        return objStartUndispatchedOrReturn;
    }

    public static final <R> Flow<R> scopedFlow(final pr0 pr0Var) {
        return new Flow<R>() { // from class: kotlinx.coroutines.flow.internal.FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super R> flowCollector, x30 x30Var) {
                Object objFlowScope = FlowCoroutineKt.flowScope(new FlowCoroutineKt$scopedFlow$1$1(pr0Var, flowCollector, null), x30Var);
                return objFlowScope == a.d() ? objFlowScope : k83.a;
            }
        };
    }
}
