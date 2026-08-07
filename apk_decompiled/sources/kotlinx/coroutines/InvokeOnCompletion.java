package kotlinx.coroutines;

import defpackage.ar0;
import defpackage.k83;

/* JADX INFO: loaded from: classes4.dex */
final class InvokeOnCompletion extends JobNode {
    private final ar0 handler;

    public InvokeOnCompletion(ar0 ar0Var) {
        this.handler = ar0Var;
    }

    @Override // kotlinx.coroutines.JobNode, kotlinx.coroutines.CompletionHandlerBase, defpackage.ar0
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return k83.a;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void invoke(Throwable th) {
        this.handler.invoke(th);
    }
}
