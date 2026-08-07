package kotlinx.coroutines.android;

import defpackage.x30;
import defpackage.y70;
import kotlin.coroutines.d;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes4.dex */
public abstract class HandlerDispatcher extends MainCoroutineDispatcher implements Delay {
    public /* synthetic */ HandlerDispatcher(y70 y70Var) {
        this();
    }

    @Override // kotlinx.coroutines.Delay
    public Object delay(long j, x30 x30Var) {
        return Delay.DefaultImpls.delay(this, j, x30Var);
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public abstract HandlerDispatcher getImmediate();

    public DisposableHandle invokeOnTimeout(long j, Runnable runnable, d dVar) {
        return Delay.DefaultImpls.invokeOnTimeout(this, j, runnable, dVar);
    }

    private HandlerDispatcher() {
    }
}
