package kotlinx.coroutines;

import defpackage.x30;
import kotlin.Result;
import kotlin.d;
import kotlinx.coroutines.internal.DispatchedContinuation;

/* JADX INFO: loaded from: classes4.dex */
public final class DebugStringsKt {
    public static final String getClassSimpleName(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String getHexAddress(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String toDebugString(x30 x30Var) {
        Object objM69constructorimpl;
        if (x30Var instanceof DispatchedContinuation) {
            return x30Var.toString();
        }
        try {
            Result.a aVar = Result.Companion;
            objM69constructorimpl = Result.m69constructorimpl(x30Var + '@' + getHexAddress(x30Var));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            objM69constructorimpl = Result.m69constructorimpl(d.a(th));
        }
        if (Result.m72exceptionOrNullimpl(objM69constructorimpl) != null) {
            objM69constructorimpl = x30Var.getClass().getName() + '@' + getHexAddress(x30Var);
        }
        return (String) objM69constructorimpl;
    }
}
