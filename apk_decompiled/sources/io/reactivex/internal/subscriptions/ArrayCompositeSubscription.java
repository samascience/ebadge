package io.reactivex.internal.subscriptions;

import defpackage.dw2;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes4.dex */
public final class ArrayCompositeSubscription extends AtomicReferenceArray<dw2> implements Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int i) {
        super(i);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        dw2 andSet;
        if (get(0) != SubscriptionHelper.CANCELLED) {
            int length = length();
            for (int i = 0; i < length; i++) {
                dw2 dw2Var = get(i);
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (dw2Var != subscriptionHelper && (andSet = getAndSet(i, subscriptionHelper)) != subscriptionHelper && andSet != null) {
                    andSet.cancel();
                }
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return get(0) == SubscriptionHelper.CANCELLED;
    }

    public dw2 replaceResource(int i, dw2 dw2Var) {
        dw2 dw2Var2;
        do {
            dw2Var2 = get(i);
            if (dw2Var2 == SubscriptionHelper.CANCELLED) {
                if (dw2Var == null) {
                    return null;
                }
                dw2Var.cancel();
                return null;
            }
        } while (!compareAndSet(i, dw2Var2, dw2Var));
        return dw2Var2;
    }

    public boolean setResource(int i, dw2 dw2Var) {
        dw2 dw2Var2;
        do {
            dw2Var2 = get(i);
            if (dw2Var2 == SubscriptionHelper.CANCELLED) {
                if (dw2Var == null) {
                    return false;
                }
                dw2Var.cancel();
                return false;
            }
        } while (!compareAndSet(i, dw2Var2, dw2Var));
        if (dw2Var2 == null) {
            return true;
        }
        dw2Var2.cancel();
        return true;
    }
}
