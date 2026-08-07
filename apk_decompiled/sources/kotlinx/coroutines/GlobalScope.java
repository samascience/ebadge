package kotlinx.coroutines;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
@DelicateCoroutinesApi
public final class GlobalScope implements CoroutineScope {
    public static final GlobalScope INSTANCE = new GlobalScope();

    private GlobalScope() {
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public d getCoroutineContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
