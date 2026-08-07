package defpackage;

import java.io.Closeable;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.d;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt__JobKt;

/* JADX INFO: loaded from: classes.dex */
public final class sy implements Closeable, CoroutineScope {
    private final d a;

    public sy(d dVar) {
        p31.f(dVar, "context");
        this.a = dVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        JobKt__JobKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public d getCoroutineContext() {
        return this.a;
    }
}
