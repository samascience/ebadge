package io.reactivex.internal.util;

import defpackage.dw2;
import defpackage.p62;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class EndConsumerHelper {
    private EndConsumerHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static String composeMessage(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void reportDoubleSubscription(Class<?> cls) {
        RxJavaPlugins.onError(new ProtocolViolationException(composeMessage(cls.getName())));
    }

    public static boolean setOnce(AtomicReference<Disposable> atomicReference, Disposable disposable, Class<?> cls) {
        ObjectHelper.requireNonNull(disposable, "next is null");
        if (p62.a(atomicReference, null, disposable)) {
            return true;
        }
        disposable.dispose();
        if (atomicReference.get() == DisposableHelper.DISPOSED) {
            return false;
        }
        reportDoubleSubscription(cls);
        return false;
    }

    public static boolean validate(Disposable disposable, Disposable disposable2, Class<?> cls) {
        ObjectHelper.requireNonNull(disposable2, "next is null");
        if (disposable == null) {
            return true;
        }
        disposable2.dispose();
        if (disposable == DisposableHelper.DISPOSED) {
            return false;
        }
        reportDoubleSubscription(cls);
        return false;
    }

    public static boolean validate(dw2 dw2Var, dw2 dw2Var2, Class<?> cls) {
        ObjectHelper.requireNonNull(dw2Var2, "next is null");
        if (dw2Var == null) {
            return true;
        }
        dw2Var2.cancel();
        if (dw2Var == SubscriptionHelper.CANCELLED) {
            return false;
        }
        reportDoubleSubscription(cls);
        return false;
    }

    public static boolean setOnce(AtomicReference<dw2> atomicReference, dw2 dw2Var, Class<?> cls) {
        ObjectHelper.requireNonNull(dw2Var, "next is null");
        if (p62.a(atomicReference, null, dw2Var)) {
            return true;
        }
        dw2Var.cancel();
        if (atomicReference.get() == SubscriptionHelper.CANCELLED) {
            return false;
        }
        reportDoubleSubscription(cls);
        return false;
    }
}
