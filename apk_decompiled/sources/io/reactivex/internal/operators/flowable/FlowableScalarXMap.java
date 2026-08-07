package io.reactivex.internal.operators.flowable;

import defpackage.a0;
import defpackage.cw2;
import defpackage.i92;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableScalarXMap {

    static final class ScalarXMapFlowable<T, R> extends Flowable<R> {
        final Function<? super T, ? extends i92> mapper;
        final T value;

        ScalarXMapFlowable(T t, Function<? super T, ? extends i92> function) {
            this.value = t;
            this.mapper = function;
        }

        @Override // io.reactivex.Flowable
        public void subscribeActual(cw2 cw2Var) {
            try {
                i92 i92Var = (i92) ObjectHelper.requireNonNull(this.mapper.apply(this.value), "The mapper returned a null Publisher");
                if (!(i92Var instanceof Callable)) {
                    i92Var.subscribe(cw2Var);
                    return;
                }
                try {
                    Object objCall = ((Callable) i92Var).call();
                    if (objCall == null) {
                        EmptySubscription.complete(cw2Var);
                    } else {
                        cw2Var.onSubscribe(new ScalarSubscription(cw2Var, objCall));
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptySubscription.error(th, cw2Var);
                }
            } catch (Throwable th2) {
                EmptySubscription.error(th2, cw2Var);
            }
        }
    }

    private FlowableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Flowable<U> scalarXMap(T t, Function<? super T, ? extends i92> function) {
        return RxJavaPlugins.onAssembly(new ScalarXMapFlowable(t, function));
    }

    public static <T, R> boolean tryScalarXMapSubscribe(i92 i92Var, cw2 cw2Var, Function<? super T, ? extends i92> function) {
        if (!(i92Var instanceof Callable)) {
            return false;
        }
        try {
            a0 a0Var = (Object) ((Callable) i92Var).call();
            if (a0Var == null) {
                EmptySubscription.complete(cw2Var);
                return true;
            }
            try {
                i92 i92Var2 = (i92) ObjectHelper.requireNonNull(function.apply(a0Var), "The mapper returned a null Publisher");
                if (i92Var2 instanceof Callable) {
                    try {
                        Object objCall = ((Callable) i92Var2).call();
                        if (objCall == null) {
                            EmptySubscription.complete(cw2Var);
                            return true;
                        }
                        cw2Var.onSubscribe(new ScalarSubscription(cw2Var, objCall));
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        EmptySubscription.error(th, cw2Var);
                        return true;
                    }
                } else {
                    i92Var2.subscribe(cw2Var);
                }
                return true;
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptySubscription.error(th2, cw2Var);
                return true;
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            EmptySubscription.error(th3, cw2Var);
            return true;
        }
    }
}
