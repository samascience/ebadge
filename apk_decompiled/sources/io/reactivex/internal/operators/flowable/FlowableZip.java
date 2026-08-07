package io.reactivex.internal.operators.flowable;

import defpackage.cw2;
import defpackage.dw2;
import defpackage.i92;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableZip<T, R> extends Flowable<R> {
    final int bufferSize;
    final boolean delayError;
    final i92[] sources;
    final Iterable<? extends i92> sourcesIterable;
    final Function<? super Object[], ? extends R> zipper;

    static final class ZipCoordinator<T, R> extends AtomicInteger implements dw2 {
        private static final long serialVersionUID = -2434867452883857743L;
        volatile boolean cancelled;
        final Object[] current;
        final boolean delayErrors;
        final cw2 downstream;
        final AtomicThrowable errors;
        final AtomicLong requested;
        final ZipSubscriber<T, R>[] subscribers;
        final Function<? super Object[], ? extends R> zipper;

        ZipCoordinator(cw2 cw2Var, Function<? super Object[], ? extends R> function, int i, int i2, boolean z) {
            this.downstream = cw2Var;
            this.zipper = function;
            this.delayErrors = z;
            ZipSubscriber<T, R>[] zipSubscriberArr = new ZipSubscriber[i];
            for (int i3 = 0; i3 < i; i3++) {
                zipSubscriberArr[i3] = new ZipSubscriber<>(this, i2);
            }
            this.current = new Object[i];
            this.subscribers = zipSubscriberArr;
            this.requested = new AtomicLong();
            this.errors = new AtomicThrowable();
        }

        @Override // defpackage.dw2
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
        }

        void cancelAll() {
            for (ZipSubscriber<T, R> zipSubscriber : this.subscribers) {
                zipSubscriber.cancel();
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            cw2 cw2Var = this.downstream;
            ZipSubscriber<T, R>[] zipSubscriberArr = this.subscribers;
            int length = zipSubscriberArr.length;
            Object[] objArr = this.current;
            int iAddAndGet = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (j != j2) {
                    if (this.cancelled) {
                        return;
                    }
                    if (!this.delayErrors && this.errors.get() != null) {
                        cancelAll();
                        cw2Var.onError(this.errors.terminate());
                        return;
                    }
                    boolean z = false;
                    for (int i = 0; i < length; i++) {
                        ZipSubscriber<T, R> zipSubscriber = zipSubscriberArr[i];
                        if (objArr[i] == null) {
                            try {
                                boolean z2 = zipSubscriber.done;
                                SimpleQueue<T> simpleQueue = zipSubscriber.queue;
                                T tPoll = simpleQueue != null ? simpleQueue.poll() : null;
                                boolean z3 = tPoll == null;
                                if (z2 && z3) {
                                    cancelAll();
                                    if (this.errors.get() != null) {
                                        cw2Var.onError(this.errors.terminate());
                                        return;
                                    } else {
                                        cw2Var.onComplete();
                                        return;
                                    }
                                }
                                if (z3) {
                                    z = true;
                                } else {
                                    objArr[i] = tPoll;
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.errors.addThrowable(th);
                                if (!this.delayErrors) {
                                    cancelAll();
                                    cw2Var.onError(this.errors.terminate());
                                    return;
                                }
                            }
                        }
                    }
                    if (z) {
                        break;
                    }
                    try {
                        cw2Var.onNext(ObjectHelper.requireNonNull(this.zipper.apply(objArr.clone()), "The zipper returned a null value"));
                        j2++;
                        Arrays.fill(objArr, (Object) null);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        cancelAll();
                        this.errors.addThrowable(th2);
                        cw2Var.onError(this.errors.terminate());
                        return;
                    }
                }
                if (j == j2) {
                    if (this.cancelled) {
                        return;
                    }
                    if (!this.delayErrors && this.errors.get() != null) {
                        cancelAll();
                        cw2Var.onError(this.errors.terminate());
                        return;
                    }
                    for (int i2 = 0; i2 < length; i2++) {
                        ZipSubscriber<T, R> zipSubscriber2 = zipSubscriberArr[i2];
                        if (objArr[i2] == null) {
                            try {
                                boolean z4 = zipSubscriber2.done;
                                SimpleQueue<T> simpleQueue2 = zipSubscriber2.queue;
                                T tPoll2 = simpleQueue2 != null ? simpleQueue2.poll() : null;
                                boolean z5 = tPoll2 == null;
                                if (z4 && z5) {
                                    cancelAll();
                                    if (this.errors.get() != null) {
                                        cw2Var.onError(this.errors.terminate());
                                        return;
                                    } else {
                                        cw2Var.onComplete();
                                        return;
                                    }
                                }
                                if (!z5) {
                                    objArr[i2] = tPoll2;
                                }
                            } catch (Throwable th3) {
                                Exceptions.throwIfFatal(th3);
                                this.errors.addThrowable(th3);
                                if (!this.delayErrors) {
                                    cancelAll();
                                    cw2Var.onError(this.errors.terminate());
                                    return;
                                }
                            }
                        }
                    }
                }
                if (j2 != 0) {
                    for (ZipSubscriber<T, R> zipSubscriber3 : zipSubscriberArr) {
                        zipSubscriber3.request(j2);
                    }
                    if (j != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j2);
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        void error(ZipSubscriber<T, R> zipSubscriber, Throwable th) {
            if (!this.errors.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                zipSubscriber.done = true;
                drain();
            }
        }

        @Override // defpackage.dw2
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        void subscribe(i92[] i92VarArr, int i) {
            ZipSubscriber<T, R>[] zipSubscriberArr = this.subscribers;
            for (int i2 = 0; i2 < i && !this.cancelled; i2++) {
                if (!this.delayErrors && this.errors.get() != null) {
                    return;
                }
                i92VarArr[i2].subscribe(zipSubscriberArr[i2]);
            }
        }
    }

    static final class ZipSubscriber<T, R> extends AtomicReference<dw2> implements FlowableSubscriber<T>, dw2 {
        private static final long serialVersionUID = -4627193790118206028L;
        volatile boolean done;
        final int limit;
        final ZipCoordinator<T, R> parent;
        final int prefetch;
        long produced;
        SimpleQueue<T> queue;
        int sourceMode;

        ZipSubscriber(ZipCoordinator<T, R> zipCoordinator, int i) {
            this.parent = zipCoordinator;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        @Override // defpackage.dw2
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onError(Throwable th) {
            this.parent.error(this, th);
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onNext(T t) {
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            this.parent.drain();
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onSubscribe(dw2 dw2Var) {
            if (SubscriptionHelper.setOnce(this, dw2Var)) {
                if (dw2Var instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) dw2Var;
                    int iRequestFusion = queueSubscription.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = queueSubscription;
                        dw2Var.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                dw2Var.request(this.prefetch);
            }
        }

        @Override // defpackage.dw2
        public void request(long j) {
            if (this.sourceMode != 1) {
                long j2 = this.produced + j;
                if (j2 < this.limit) {
                    this.produced = j2;
                } else {
                    this.produced = 0L;
                    get().request(j2);
                }
            }
        }
    }

    public FlowableZip(i92[] i92VarArr, Iterable<? extends i92> iterable, Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.sources = i92VarArr;
        this.sourcesIterable = iterable;
        this.zipper = function;
        this.bufferSize = i;
        this.delayError = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(cw2 cw2Var) {
        int length;
        i92[] i92VarArr = this.sources;
        if (i92VarArr == null) {
            i92VarArr = new i92[8];
            length = 0;
            for (i92 i92Var : this.sourcesIterable) {
                if (length == i92VarArr.length) {
                    i92[] i92VarArr2 = new i92[(length >> 2) + length];
                    System.arraycopy(i92VarArr, 0, i92VarArr2, 0, length);
                    i92VarArr = i92VarArr2;
                }
                i92VarArr[length] = i92Var;
                length++;
            }
        } else {
            length = i92VarArr.length;
        }
        int i = length;
        if (i == 0) {
            EmptySubscription.complete(cw2Var);
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(cw2Var, this.zipper, i, this.bufferSize, this.delayError);
        cw2Var.onSubscribe(zipCoordinator);
        zipCoordinator.subscribe(i92VarArr, i);
    }
}
