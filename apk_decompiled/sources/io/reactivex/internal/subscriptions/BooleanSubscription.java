package io.reactivex.internal.subscriptions;

import defpackage.dw2;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class BooleanSubscription extends AtomicBoolean implements dw2 {
    private static final long serialVersionUID = -8127758972444290902L;

    @Override // defpackage.dw2
    public void cancel() {
        lazySet(true);
    }

    public boolean isCancelled() {
        return get();
    }

    @Override // defpackage.dw2
    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "BooleanSubscription(cancelled=" + get() + ")";
    }
}
