package kotlinx.coroutines;

import defpackage.k83;
import defpackage.x30;
import kotlin.Result;

/* JADX INFO: loaded from: classes4.dex */
final class ResumeOnCompletion extends JobNode {
    private final x30 continuation;

    public ResumeOnCompletion(x30 x30Var) {
        this.continuation = x30Var;
    }

    @Override // kotlinx.coroutines.JobNode, kotlinx.coroutines.CompletionHandlerBase, defpackage.ar0
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return k83.a;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void invoke(Throwable th) {
        x30 x30Var = this.continuation;
        Result.a aVar = Result.Companion;
        x30Var.resumeWith(Result.m69constructorimpl(k83.a));
    }
}
