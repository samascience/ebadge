package io.reactivex.internal.operators.parallel;

import defpackage.cw2;
import defpackage.dw2;
import defpackage.i92;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes4.dex */
public final class ParallelFromPublisher<T> extends ParallelFlowable<T> {
    final int parallelism;
    final int prefetch;
    final i92 source;

    static final class ParallelDispatcher<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4470634016609963609L;
        volatile boolean cancelled;
        volatile boolean done;
        final long[] emissions;
        Throwable error;
        int index;
        final int limit;
        final int prefetch;
        int produced;
        SimpleQueue<T> queue;
        final AtomicLongArray requests;
        int sourceMode;
        final AtomicInteger subscriberCount = new AtomicInteger();
        final cw2[] subscribers;
        dw2 upstream;

        final class RailSubscription implements dw2 {
            final int j;
            final int m;

            RailSubscription(int i, int i2) {
                this.j = i;
                this.m = i2;
            }

            @Override // defpackage.dw2
            public void cancel() {
                if (ParallelDispatcher.this.requests.compareAndSet(this.j + this.m, 0L, 1L)) {
                    ParallelDispatcher parallelDispatcher = ParallelDispatcher.this;
                    int i = this.m;
                    parallelDispatcher.cancel(i + i);
                }
            }

            @Override // defpackage.dw2
            public void request(long j) {
                long j2;
                if (SubscriptionHelper.validate(j)) {
                    AtomicLongArray atomicLongArray = ParallelDispatcher.this.requests;
                    do {
                        j2 = atomicLongArray.get(this.j);
                        if (j2 == Long.MAX_VALUE) {
                            return;
                        }
                    } while (!atomicLongArray.compareAndSet(this.j, j2, BackpressureHelper.addCap(j2, j)));
                    if (ParallelDispatcher.this.subscriberCount.get() == this.m) {
                        ParallelDispatcher.this.drain();
                    }
                }
            }
        }

        ParallelDispatcher(cw2[] cw2VarArr, int i) {
            this.subscribers = cw2VarArr;
            this.prefetch = i;
            this.limit = i - (i >> 2);
            int length = cw2VarArr.length;
            int i2 = length + length;
            AtomicLongArray atomicLongArray = new AtomicLongArray(i2 + 1);
            this.requests = atomicLongArray;
            atomicLongArray.lazySet(i2, length);
            this.emissions = new long[length];
        }

        void cancel(int i) {
            if (this.requests.decrementAndGet(i) == 0) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.sourceMode == 1) {
                drainSync();
            } else {
                drainAsync();
            }
        }

        void drainAsync() {
            Throwable th;
            SimpleQueue<T> simpleQueue = this.queue;
            cw2[] cw2VarArr = this.subscribers;
            AtomicLongArray atomicLongArray = this.requests;
            long[] jArr = this.emissions;
            int length = jArr.length;
            int i = this.index;
            int i2 = this.produced;
            int iAddAndGet = 1;
            while (true) {
                int i3 = 0;
                int i4 = 0;
                do {
                    if (this.cancelled) {
                        simpleQueue.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        simpleQueue.clear();
                        int length2 = cw2VarArr.length;
                        while (i3 < length2) {
                            cw2VarArr[i3].onError(th);
                            i3++;
                        }
                        return;
                    }
                    boolean zIsEmpty = simpleQueue.isEmpty();
                    if (z && zIsEmpty) {
                        int length3 = cw2VarArr.length;
                        while (i3 < length3) {
                            cw2VarArr[i3].onComplete();
                            i3++;
                        }
                        return;
                    }
                    if (zIsEmpty) {
                        break;
                    }
                    long j = atomicLongArray.get(i);
                    long j2 = jArr[i];
                    if (j == j2 || atomicLongArray.get(length + i) != 0) {
                        i4++;
                    } else {
                        try {
                            T tPoll = simpleQueue.poll();
                            if (tPoll == null) {
                                break;
                            }
                            cw2VarArr[i].onNext(tPoll);
                            jArr[i] = j2 + 1;
                            i2++;
                            if (i2 == this.limit) {
                                this.upstream.request(i2);
                                i2 = 0;
                            }
                            i4 = 0;
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.upstream.cancel();
                            int length4 = cw2VarArr.length;
                            while (i3 < length4) {
                                cw2VarArr[i3].onError(th2);
                                i3++;
                            }
                            return;
                        }
                    }
                    i++;
                    if (i == length) {
                        i = 0;
                    }
                } while (i4 != length);
                int i5 = get();
                if (i5 == iAddAndGet) {
                    this.index = i;
                    this.produced = i2;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i5;
                }
            }
        }

        void drainSync() {
            SimpleQueue<T> simpleQueue = this.queue;
            cw2[] cw2VarArr = this.subscribers;
            AtomicLongArray atomicLongArray = this.requests;
            long[] jArr = this.emissions;
            int length = jArr.length;
            int i = this.index;
            int iAddAndGet = 1;
            while (true) {
                int i2 = 0;
                int i3 = 0;
                do {
                    if (this.cancelled) {
                        simpleQueue.clear();
                        return;
                    }
                    if (simpleQueue.isEmpty()) {
                        int length2 = cw2VarArr.length;
                        while (i2 < length2) {
                            cw2VarArr[i2].onComplete();
                            i2++;
                        }
                        return;
                    }
                    long j = atomicLongArray.get(i);
                    long j2 = jArr[i];
                    if (j == j2 || atomicLongArray.get(length + i) != 0) {
                        i3++;
                    } else {
                        try {
                            T tPoll = simpleQueue.poll();
                            if (tPoll == null) {
                                int length3 = cw2VarArr.length;
                                while (i2 < length3) {
                                    cw2VarArr[i2].onComplete();
                                    i2++;
                                }
                                return;
                            }
                            cw2VarArr[i].onNext(tPoll);
                            jArr[i] = j2 + 1;
                            i3 = 0;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.upstream.cancel();
                            int length4 = cw2VarArr.length;
                            while (i2 < length4) {
                                cw2VarArr[i2].onError(th);
                                i2++;
                            }
                            return;
                        }
                    }
                    i++;
                    if (i == length) {
                        i = 0;
                    }
                } while (i3 != length);
                int i4 = get();
                if (i4 == iAddAndGet) {
                    this.index = i;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i4;
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onNext(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                drain();
            } else {
                this.upstream.cancel();
                onError(new MissingBackpressureException("Queue is full?"));
            }
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onSubscribe(dw2 dw2Var) {
            if (SubscriptionHelper.validate(this.upstream, dw2Var)) {
                this.upstream = dw2Var;
                if (dw2Var instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) dw2Var;
                    int iRequestFusion = queueSubscription.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        setupSubscribers();
                        drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = queueSubscription;
                        setupSubscribers();
                        dw2Var.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                setupSubscribers();
                dw2Var.request(this.prefetch);
            }
        }

        void setupSubscribers() {
            cw2[] cw2VarArr = this.subscribers;
            int length = cw2VarArr.length;
            int i = 0;
            while (i < length && !this.cancelled) {
                int i2 = i + 1;
                this.subscriberCount.lazySet(i2);
                cw2VarArr[i].onSubscribe(new RailSubscription(i, length));
                i = i2;
            }
        }
    }

    public ParallelFromPublisher(i92 i92Var, int i, int i2) {
        this.source = i92Var;
        this.parallelism = i;
        this.prefetch = i2;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.parallelism;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(cw2[] cw2VarArr) {
        if (validate(cw2VarArr)) {
            this.source.subscribe(new ParallelDispatcher(cw2VarArr, this.prefetch));
        }
    }
}
