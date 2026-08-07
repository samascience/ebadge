package kotlinx.coroutines.future;

import defpackage.k83;
import defpackage.x30;
import java.util.concurrent.CompletionException;
import java.util.function.BiFunction;
import kotlin.Result;
import kotlin.d;

/* JADX INFO: loaded from: classes4.dex */
final class ContinuationHandler<T> implements BiFunction<T, Throwable, k83> {
    public volatile x30 cont;

    public ContinuationHandler(x30 x30Var) {
        this.cont = x30Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.BiFunction
    public /* bridge */ /* synthetic */ k83 apply(Object obj, Throwable th) {
        apply2(obj, th);
        return k83.a;
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public void apply2(T t, Throwable th) {
        Throwable cause;
        x30 x30Var = this.cont;
        if (x30Var == null) {
            return;
        }
        if (th == null) {
            x30Var.resumeWith(Result.m69constructorimpl(t));
            return;
        }
        CompletionException completionException = th instanceof CompletionException ? (CompletionException) th : null;
        if (completionException != null && (cause = completionException.getCause()) != null) {
            th = cause;
        }
        Result.a aVar = Result.Companion;
        x30Var.resumeWith(Result.m69constructorimpl(d.a(th)));
    }
}
