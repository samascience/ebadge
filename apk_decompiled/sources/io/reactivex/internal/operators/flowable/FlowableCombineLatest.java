package io.reactivex.internal.operators.flowable;

import defpackage.cw2;
import defpackage.dw2;
import defpackage.i92;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableCombineLatest<T, R> extends Flowable<R> {

    @Nullable
    final i92[] array;
    final int bufferSize;
    final Function<? super Object[], ? extends R> combiner;
    final boolean delayErrors;

    @Nullable
    final Iterable<? extends i92> iterable;

    static final class CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
        private static final long serialVersionUID = -5082275438355852221L;
        volatile boolean cancelled;
        final Function<? super Object[], ? extends R> combiner;
        int completedSources;
        final boolean delayErrors;
        volatile boolean done;
        final cw2 downstream;
        final AtomicReference<Throwable> error;
        final Object[] latest;
        int nonEmptySources;
        boolean outputFused;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested;
        final CombineLatestInnerSubscriber<T>[] subscribers;

        CombineLatestCoordinator(cw2 cw2Var, Function<? super Object[], ? extends R> function, int i, int i2, boolean z) {
            this.downstream = cw2Var;
            this.combiner = function;
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = new CombineLatestInnerSubscriber[i];
            for (int i3 = 0; i3 < i; i3++) {
                combineLatestInnerSubscriberArr[i3] = new CombineLatestInnerSubscriber<>(this, i3, i2);
            }
            this.subscribers = combineLatestInnerSubscriberArr;
            this.latest = new Object[i];
            this.queue = new SpscLinkedArrayQueue<>(i2);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
            this.delayErrors = z;
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, io.reactivex.internal.fuseable.QueueSubscription, defpackage.dw2
        public void cancel() {
            this.cancelled = true;
            cancelAll();
        }

        void cancelAll() {
            for (CombineLatestInnerSubscriber<T> combineLatestInnerSubscriber : this.subscribers) {
                combineLatestInnerSubscriber.cancel();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, cw2 cw2Var, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.cancelled) {
                cancelAll();
                spscLinkedArrayQueue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.delayErrors) {
                if (!z2) {
                    return false;
                }
                cancelAll();
                Throwable thTerminate = ExceptionHelper.terminate(this.error);
                if (thTerminate == null || thTerminate == ExceptionHelper.TERMINATED) {
                    cw2Var.onComplete();
                } else {
                    cw2Var.onError(thTerminate);
                }
                return true;
            }
            Throwable thTerminate2 = ExceptionHelper.terminate(this.error);
            if (thTerminate2 != null && thTerminate2 != ExceptionHelper.TERMINATED) {
                cancelAll();
                spscLinkedArrayQueue.clear();
                cw2Var.onError(thTerminate2);
                return true;
            }
            if (!z2) {
                return false;
            }
            cancelAll();
            cw2Var.onComplete();
            return true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.queue.clear();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainOutput();
            } else {
                drainAsync();
            }
        }

        void drainAsync() {
            cw2 cw2Var = this.downstream;
            SpscLinkedArrayQueue<?> spscLinkedArrayQueue = this.queue;
            int iAddAndGet = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.done;
                    Object objPoll = spscLinkedArrayQueue.poll();
                    boolean z2 = objPoll == null;
                    if (checkTerminated(z, z2, cw2Var, spscLinkedArrayQueue)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    try {
                        cw2Var.onNext(ObjectHelper.requireNonNull(this.combiner.apply((Object[]) spscLinkedArrayQueue.poll()), "The combiner returned a null value"));
                        ((CombineLatestInnerSubscriber) objPoll).requestOne();
                        j2++;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        cancelAll();
                        ExceptionHelper.addThrowable(this.error, th);
                        cw2Var.onError(ExceptionHelper.terminate(this.error));
                        return;
                    }
                }
                if (j2 == j && checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), cw2Var, spscLinkedArrayQueue)) {
                    return;
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        void drainOutput() {
            cw2 cw2Var = this.downstream;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                Throwable th = this.error.get();
                if (th != null) {
                    spscLinkedArrayQueue.clear();
                    cw2Var.onError(th);
                    return;
                }
                boolean z = this.done;
                boolean zIsEmpty = spscLinkedArrayQueue.isEmpty();
                if (!zIsEmpty) {
                    cw2Var.onNext(null);
                }
                if (z && zIsEmpty) {
                    cw2Var.onComplete();
                    return;
                } else {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            spscLinkedArrayQueue.clear();
        }

        void innerComplete(int i) {
            int i2;
            synchronized (this) {
                try {
                    Object[] objArr = this.latest;
                    if (objArr[i] != null && (i2 = this.completedSources + 1) != objArr.length) {
                        this.completedSources = i2;
                    } else {
                        this.done = true;
                        drain();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void innerError(int i, Throwable th) {
            if (!ExceptionHelper.addThrowable(this.error, th)) {
                RxJavaPlugins.onError(th);
            } else {
                if (this.delayErrors) {
                    innerComplete(i);
                    return;
                }
                cancelAll();
                this.done = true;
                drain();
            }
        }

        void innerValue(int i, T t) {
            boolean z;
            synchronized (this) {
                try {
                    Object[] objArr = this.latest;
                    int i2 = this.nonEmptySources;
                    if (objArr[i] == null) {
                        i2++;
                        this.nonEmptySources = i2;
                    }
                    objArr[i] = t;
                    if (objArr.length == i2) {
                        this.queue.offer(this.subscribers[i], objArr.clone());
                        z = false;
                    } else {
                        z = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z) {
                this.subscribers[i].requestOne();
            } else {
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public R poll() throws Exception {
            Object objPoll = this.queue.poll();
            if (objPoll == null) {
                return null;
            }
            R r = (R) ObjectHelper.requireNonNull(this.combiner.apply((Object[]) this.queue.poll()), "The combiner returned a null value");
            ((CombineLatestInnerSubscriber) objPoll).requestOne();
            return r;
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, io.reactivex.internal.fuseable.QueueSubscription, defpackage.dw2
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 4) != 0) {
                return 0;
            }
            int i2 = i & 2;
            this.outputFused = i2 != 0;
            return i2;
        }

        void subscribe(i92[] i92VarArr, int i) {
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = this.subscribers;
            for (int i2 = 0; i2 < i && !this.done && !this.cancelled; i2++) {
                i92VarArr[i2].subscribe(combineLatestInnerSubscriberArr[i2]);
            }
        }
    }

    static final class CombineLatestInnerSubscriber<T> extends AtomicReference<dw2> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -8730235182291002949L;
        final int index;
        final int limit;
        final CombineLatestCoordinator<T, ?> parent;
        final int prefetch;
        int produced;

        CombineLatestInnerSubscriber(CombineLatestCoordinator<T, ?> combineLatestCoordinator, int i, int i2) {
            this.parent = combineLatestCoordinator;
            this.index = i;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onNext(T t) {
            this.parent.innerValue(this.index, t);
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onSubscribe(dw2 dw2Var) {
            SubscriptionHelper.setOnce(this, dw2Var, this.prefetch);
        }

        public void requestOne() {
            int i = this.produced + 1;
            if (i != this.limit) {
                this.produced = i;
            } else {
                this.produced = 0;
                get().request(i);
            }
        }
    }

    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        @Override // io.reactivex.functions.Function
        public R apply(T t) throws Exception {
            return FlowableCombineLatest.this.combiner.apply(new Object[]{t});
        }
    }

    public FlowableCombineLatest(@NonNull i92[] i92VarArr, @NonNull Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.array = i92VarArr;
        this.iterable = null;
        this.combiner = function;
        this.bufferSize = i;
        this.delayErrors = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(cw2 cw2Var) {
        int length;
        i92[] i92VarArr = this.array;
        if (i92VarArr == null) {
            i92VarArr = new i92[8];
            try {
                Iterator it = (Iterator) ObjectHelper.requireNonNull(this.iterable.iterator(), "The iterator returned is null");
                length = 0;
                while (it.hasNext()) {
                    try {
                        try {
                            i92 i92Var = (i92) ObjectHelper.requireNonNull(it.next(), "The publisher returned by the iterator is null");
                            if (length == i92VarArr.length) {
                                i92[] i92VarArr2 = new i92[(length >> 2) + length];
                                System.arraycopy(i92VarArr, 0, i92VarArr2, 0, length);
                                i92VarArr = i92VarArr2;
                            }
                            i92VarArr[length] = i92Var;
                            length++;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            EmptySubscription.error(th, cw2Var);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        EmptySubscription.error(th2, cw2Var);
                        return;
                    }
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                EmptySubscription.error(th3, cw2Var);
                return;
            }
        } else {
            length = i92VarArr.length;
        }
        int i = length;
        if (i == 0) {
            EmptySubscription.complete(cw2Var);
        } else {
            if (i == 1) {
                i92VarArr[0].subscribe(new FlowableMap.MapSubscriber(cw2Var, new SingletonArrayFunc()));
                return;
            }
            CombineLatestCoordinator combineLatestCoordinator = new CombineLatestCoordinator(cw2Var, this.combiner, i, this.bufferSize, this.delayErrors);
            cw2Var.onSubscribe(combineLatestCoordinator);
            combineLatestCoordinator.subscribe(i92VarArr, i);
        }
    }

    public FlowableCombineLatest(@NonNull Iterable<? extends i92> iterable, @NonNull Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.array = null;
        this.iterable = iterable;
        this.combiner = function;
        this.bufferSize = i;
        this.delayErrors = z;
    }
}
