package kotlinx.coroutines;

import defpackage.k83;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes4.dex */
final class CancelFutureOnCancel extends CancelHandler {
    private final Future<?> future;

    public CancelFutureOnCancel(Future<?> future) {
        this.future = future;
    }

    @Override // kotlinx.coroutines.CancelHandler, kotlinx.coroutines.CancelHandlerBase, defpackage.ar0
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return k83.a;
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.future + ']';
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void invoke(Throwable th) {
        if (th != null) {
            this.future.cancel(false);
        }
    }
}
