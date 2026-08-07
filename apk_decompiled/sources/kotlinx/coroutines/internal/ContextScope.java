package kotlinx.coroutines.internal;

import kotlin.coroutines.d;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
public final class ContextScope implements CoroutineScope {
    private final d coroutineContext;

    public ContextScope(d dVar) {
        this.coroutineContext = dVar;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public d getCoroutineContext() {
        return this.coroutineContext;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    }
}
