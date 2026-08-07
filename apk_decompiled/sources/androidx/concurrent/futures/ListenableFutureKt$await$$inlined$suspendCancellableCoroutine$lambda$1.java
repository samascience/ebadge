package androidx.concurrent.futures;

import defpackage.ar0;
import defpackage.k83;
import defpackage.ub1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
final class ListenableFutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1 extends Lambda implements ar0 {
    final /* synthetic */ ub1 $this_await$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ListenableFutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1(ub1 ub1Var) {
        super(1);
        this.$this_await$inlined = ub1Var;
    }

    @Override // defpackage.ar0
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return k83.a;
    }

    public final void invoke(Throwable th) {
        this.$this_await$inlined.cancel(false);
    }
}
