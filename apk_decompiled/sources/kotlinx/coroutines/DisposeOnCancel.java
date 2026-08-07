package kotlinx.coroutines;

import defpackage.k83;

/* JADX INFO: loaded from: classes4.dex */
final class DisposeOnCancel extends CancelHandler {
    private final DisposableHandle handle;

    public DisposeOnCancel(DisposableHandle disposableHandle) {
        this.handle = disposableHandle;
    }

    @Override // kotlinx.coroutines.CancelHandler, kotlinx.coroutines.CancelHandlerBase, defpackage.ar0
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return k83.a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.handle + ']';
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void invoke(Throwable th) {
        this.handle.dispose();
    }
}
