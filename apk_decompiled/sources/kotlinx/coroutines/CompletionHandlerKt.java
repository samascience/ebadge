package kotlinx.coroutines;

import defpackage.ar0;

/* JADX INFO: loaded from: classes4.dex */
public final class CompletionHandlerKt {
    public static final ar0 getAsHandler(CompletionHandlerBase completionHandlerBase) {
        return completionHandlerBase;
    }

    public static final void invokeIt(ar0 ar0Var, Throwable th) {
        ar0Var.invoke(th);
    }

    public static final ar0 getAsHandler(CancelHandlerBase cancelHandlerBase) {
        return cancelHandlerBase;
    }
}
