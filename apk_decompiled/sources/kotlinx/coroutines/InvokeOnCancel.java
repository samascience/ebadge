package kotlinx.coroutines;

import defpackage.ar0;
import defpackage.k83;

/* JADX INFO: loaded from: classes4.dex */
final class InvokeOnCancel extends CancelHandler {
    private final ar0 handler;

    public InvokeOnCancel(ar0 ar0Var) {
        this.handler = ar0Var;
    }

    @Override // kotlinx.coroutines.CancelHandler, kotlinx.coroutines.CancelHandlerBase, defpackage.ar0
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return k83.a;
    }

    public String toString() {
        return "InvokeOnCancel[" + DebugStringsKt.getClassSimpleName(this.handler) + '@' + DebugStringsKt.getHexAddress(this) + ']';
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void invoke(Throwable th) {
        this.handler.invoke(th);
    }
}
