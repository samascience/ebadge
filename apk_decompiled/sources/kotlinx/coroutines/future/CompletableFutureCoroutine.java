package kotlinx.coroutines.future;

import defpackage.k83;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import kotlin.coroutines.d;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
final class CompletableFutureCoroutine<T> extends AbstractCoroutine<T> implements BiFunction<T, Throwable, k83> {
    private final CompletableFuture<T> future;

    public CompletableFutureCoroutine(d dVar, CompletableFuture<T> completableFuture) {
        super(dVar, true, true);
        this.future = completableFuture;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.BiFunction
    public /* bridge */ /* synthetic */ k83 apply(Object obj, Throwable th) {
        apply2(obj, th);
        return k83.a;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void onCancelled(Throwable th, boolean z) {
        this.future.completeExceptionally(th);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void onCompleted(T t) {
        this.future.complete(t);
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public void apply2(T t, Throwable th) {
        Job.DefaultImpls.cancel$default((Job) this, (CancellationException) null, 1, (Object) null);
    }
}
