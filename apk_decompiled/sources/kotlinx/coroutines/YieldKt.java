package kotlinx.coroutines;

import defpackage.j70;
import defpackage.k83;
import defpackage.x30;
import kotlin.coroutines.d;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

/* JADX INFO: loaded from: classes4.dex */
public final class YieldKt {
    public static final Object yield(x30 x30Var) {
        Object objD;
        d context = x30Var.getContext();
        JobKt.ensureActive(context);
        x30 x30VarC = kotlin.coroutines.intrinsics.a.c(x30Var);
        DispatchedContinuation dispatchedContinuation = x30VarC instanceof DispatchedContinuation ? (DispatchedContinuation) x30VarC : null;
        if (dispatchedContinuation == null) {
            objD = k83.a;
        } else {
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(context)) {
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(context, k83.a);
            } else {
                YieldContext yieldContext = new YieldContext();
                d dVarPlus = context.plus(yieldContext);
                k83 k83Var = k83.a;
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(dVarPlus, k83Var);
                objD = (!yieldContext.dispatcherWasUnconfined || DispatchedContinuationKt.yieldUndispatched(dispatchedContinuation)) ? kotlin.coroutines.intrinsics.a.d() : k83Var;
            }
            objD = kotlin.coroutines.intrinsics.a.d();
        }
        if (objD == kotlin.coroutines.intrinsics.a.d()) {
            j70.c(x30Var);
        }
        return objD == kotlin.coroutines.intrinsics.a.d() ? objD : k83.a;
    }
}
