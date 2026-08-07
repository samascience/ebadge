package io.reactivex.internal.subscriptions;

import defpackage.dw2;
import defpackage.p62;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public enum SubscriptionHelper implements dw2 {
    CANCELLED;

    public static void deferredRequest(AtomicReference<dw2> atomicReference, AtomicLong atomicLong, long j) {
        dw2 dw2Var = atomicReference.get();
        if (dw2Var != null) {
            dw2Var.request(j);
            return;
        }
        if (validate(j)) {
            BackpressureHelper.add(atomicLong, j);
            dw2 dw2Var2 = atomicReference.get();
            if (dw2Var2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    dw2Var2.request(andSet);
                }
            }
        }
    }

    public static boolean deferredSetOnce(AtomicReference<dw2> atomicReference, AtomicLong atomicLong, dw2 dw2Var) {
        if (!setOnce(atomicReference, dw2Var)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0L);
        if (andSet == 0) {
            return true;
        }
        dw2Var.request(andSet);
        return true;
    }

    public static boolean replace(AtomicReference<dw2> atomicReference, dw2 dw2Var) {
        dw2 dw2Var2;
        do {
            dw2Var2 = atomicReference.get();
            if (dw2Var2 == CANCELLED) {
                if (dw2Var == null) {
                    return false;
                }
                dw2Var.cancel();
                return false;
            }
        } while (!p62.a(atomicReference, dw2Var2, dw2Var));
        return true;
    }

    public static void reportMoreProduced(long j) {
        RxJavaPlugins.onError(new ProtocolViolationException("More produced than requested: " + j));
    }

    public static void reportSubscriptionSet() {
        RxJavaPlugins.onError(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean set(AtomicReference<dw2> atomicReference, dw2 dw2Var) {
        dw2 dw2Var2;
        do {
            dw2Var2 = atomicReference.get();
            if (dw2Var2 == CANCELLED) {
                if (dw2Var == null) {
                    return false;
                }
                dw2Var.cancel();
                return false;
            }
        } while (!p62.a(atomicReference, dw2Var2, dw2Var));
        if (dw2Var2 == null) {
            return true;
        }
        dw2Var2.cancel();
        return true;
    }

    public static boolean setOnce(AtomicReference<dw2> atomicReference, dw2 dw2Var) {
        ObjectHelper.requireNonNull(dw2Var, "s is null");
        if (p62.a(atomicReference, null, dw2Var)) {
            return true;
        }
        dw2Var.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        reportSubscriptionSet();
        return false;
    }

    public static boolean validate(dw2 dw2Var, dw2 dw2Var2) {
        if (dw2Var2 == null) {
            RxJavaPlugins.onError(new NullPointerException("next is null"));
            return false;
        }
        if (dw2Var == null) {
            return true;
        }
        dw2Var2.cancel();
        reportSubscriptionSet();
        return false;
    }

    @Override // defpackage.dw2
    public void cancel() {
    }

    @Override // defpackage.dw2
    public void request(long j) {
    }

    public static boolean cancel(AtomicReference<dw2> atomicReference) {
        dw2 andSet;
        dw2 dw2Var = atomicReference.get();
        SubscriptionHelper subscriptionHelper = CANCELLED;
        if (dw2Var == subscriptionHelper || (andSet = atomicReference.getAndSet(subscriptionHelper)) == subscriptionHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static boolean validate(long j) {
        if (j > 0) {
            return true;
        }
        RxJavaPlugins.onError(new IllegalArgumentException("n > 0 required but it was " + j));
        return false;
    }

    public static boolean setOnce(AtomicReference<dw2> atomicReference, dw2 dw2Var, long j) {
        if (!setOnce(atomicReference, dw2Var)) {
            return false;
        }
        dw2Var.request(j);
        return true;
    }
}
