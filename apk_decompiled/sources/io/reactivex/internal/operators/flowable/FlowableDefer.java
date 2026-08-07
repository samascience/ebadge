package io.reactivex.internal.operators.flowable;

import defpackage.cw2;
import defpackage.i92;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableDefer<T> extends Flowable<T> {
    final Callable<? extends i92> supplier;

    public FlowableDefer(Callable<? extends i92> callable) {
        this.supplier = callable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(cw2 cw2Var) {
        try {
            ((i92) ObjectHelper.requireNonNull(this.supplier.call(), "The publisher supplied is null")).subscribe(cw2Var);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, cw2Var);
        }
    }
}
