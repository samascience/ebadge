package io.reactivex.disposables;

import defpackage.dw2;
import io.reactivex.annotations.NonNull;

/* JADX INFO: loaded from: classes4.dex */
final class SubscriptionDisposable extends ReferenceDisposable<dw2> {
    private static final long serialVersionUID = -707001650852963139L;

    SubscriptionDisposable(dw2 dw2Var) {
        super(dw2Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(@NonNull dw2 dw2Var) {
        dw2Var.cancel();
    }
}
