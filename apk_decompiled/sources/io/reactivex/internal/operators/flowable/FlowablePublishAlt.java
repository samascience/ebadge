package io.reactivex.internal.operators.flowable;

import defpackage.cw2;
import defpackage.dw2;
import defpackage.i92;
import defpackage.p62;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowablePublishAlt<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T>, ResettableConnectable {
    final int bufferSize;
    final AtomicReference<PublishConnection<T>> current = new AtomicReference<>();
    final i92 source;

    static final class InnerSubscription<T> extends AtomicLong implements dw2 {
        private static final long serialVersionUID = 2845000326761540265L;
        final cw2 downstream;
        long emitted;
        final PublishConnection<T> parent;

        InnerSubscription(cw2 cw2Var, PublishConnection<T> publishConnection) {
            this.downstream = cw2Var;
            this.parent = publishConnection;
        }

        @Override // defpackage.dw2
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.drain();
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        @Override // defpackage.dw2
        public void request(long j) {
            BackpressureHelper.addCancel(this, j);
            this.parent.drain();
        }
    }

    static final class PublishConnection<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscription[] EMPTY = new InnerSubscription[0];
        static final InnerSubscription[] TERMINATED = new InnerSubscription[0];
        private static final long serialVersionUID = -1672047311619175801L;
        final int bufferSize;
        int consumed;
        final AtomicReference<PublishConnection<T>> current;
        volatile boolean done;
        Throwable error;
        volatile SimpleQueue<T> queue;
        int sourceMode;
        final AtomicReference<dw2> upstream = new AtomicReference<>();
        final AtomicBoolean connect = new AtomicBoolean();
        final AtomicReference<InnerSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);

        PublishConnection(AtomicReference<PublishConnection<T>> atomicReference, int i) {
            this.current = atomicReference;
            this.bufferSize = i;
        }

        boolean add(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = this.subscribers.get();
                if (innerSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new InnerSubscription[length + 1];
                System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = innerSubscription;
            } while (!p62.a(this.subscribers, innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        boolean checkTerminated(boolean z, boolean z2) {
            if (!z || !z2) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                signalError(th);
                return true;
            }
            for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                if (!innerSubscription.isCancelled()) {
                    innerSubscription.downstream.onComplete();
                }
            }
            return true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.subscribers.getAndSet(TERMINATED);
            p62.a(this.current, this, null);
            SubscriptionHelper.cancel(this.upstream);
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            SimpleQueue<T> simpleQueue = this.queue;
            int i = this.consumed;
            int i2 = this.bufferSize;
            int i3 = i2 - (i2 >> 2);
            boolean z = this.sourceMode != 1;
            int iAddAndGet = 1;
            SimpleQueue<T> simpleQueue2 = simpleQueue;
            int i4 = i;
            while (true) {
                if (simpleQueue2 != null) {
                    InnerSubscription<T>[] innerSubscriptionArr = this.subscribers.get();
                    long jMin = Long.MAX_VALUE;
                    boolean z2 = false;
                    for (InnerSubscription<T> innerSubscription : innerSubscriptionArr) {
                        long j = innerSubscription.get();
                        if (j != Long.MIN_VALUE) {
                            jMin = Math.min(j - innerSubscription.emitted, jMin);
                            z2 = true;
                        }
                    }
                    long j2 = 0;
                    if (!z2) {
                        jMin = 0;
                    }
                    while (true) {
                        if (jMin != j2) {
                            boolean z3 = this.done;
                            try {
                                T tPoll = simpleQueue2.poll();
                                boolean z4 = tPoll == null;
                                if (checkTerminated(z3, z4)) {
                                    return;
                                }
                                if (!z4) {
                                    for (InnerSubscription<T> innerSubscription2 : innerSubscriptionArr) {
                                        if (!innerSubscription2.isCancelled()) {
                                            innerSubscription2.downstream.onNext(tPoll);
                                            innerSubscription2.emitted++;
                                        }
                                    }
                                    if (z && (i4 = i4 + 1) == i3) {
                                        this.upstream.get().request(i3);
                                        i4 = 0;
                                    }
                                    jMin--;
                                    if (innerSubscriptionArr == this.subscribers.get()) {
                                        j2 = 0;
                                    }
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.upstream.get().cancel();
                                simpleQueue2.clear();
                                this.done = true;
                                signalError(th);
                                return;
                            }
                        }
                        if (checkTerminated(this.done, simpleQueue2.isEmpty())) {
                            return;
                        }
                    }
                }
                this.consumed = i4;
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (simpleQueue2 == null) {
                    simpleQueue2 = this.queue;
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onNext(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                drain();
            } else {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            }
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onSubscribe(dw2 dw2Var) {
            if (SubscriptionHelper.setOnce(this.upstream, dw2Var)) {
                if (dw2Var instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) dw2Var;
                    int iRequestFusion = queueSubscription.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = queueSubscription;
                        dw2Var.request(this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                dw2Var.request(this.bufferSize);
            }
        }

        void remove(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = this.subscribers.get();
                int length = innerSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (innerSubscriptionArr[i] == innerSubscription) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriptionArr2 = EMPTY;
                } else {
                    InnerSubscription[] innerSubscriptionArr3 = new InnerSubscription[length - 1];
                    System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr3, 0, i);
                    System.arraycopy(innerSubscriptionArr, i + 1, innerSubscriptionArr3, i, (length - i) - 1);
                    innerSubscriptionArr2 = innerSubscriptionArr3;
                }
            } while (!p62.a(this.subscribers, innerSubscriptionArr, innerSubscriptionArr2));
        }

        void signalError(Throwable th) {
            for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(TERMINATED)) {
                if (!innerSubscription.isCancelled()) {
                    innerSubscription.downstream.onError(th);
                }
            }
        }
    }

    public FlowablePublishAlt(i92 i92Var, int i) {
        this.source = i92Var;
        this.bufferSize = i;
    }

    @Override // io.reactivex.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> consumer) {
        PublishConnection<T> publishConnection;
        while (true) {
            publishConnection = this.current.get();
            if (publishConnection != null && !publishConnection.isDisposed()) {
                break;
            }
            PublishConnection<T> publishConnection2 = new PublishConnection<>(this.current, this.bufferSize);
            if (p62.a(this.current, publishConnection, publishConnection2)) {
                publishConnection = publishConnection2;
                break;
            }
        }
        boolean z = false;
        if (!publishConnection.connect.get() && publishConnection.connect.compareAndSet(false, true)) {
            z = true;
        }
        try {
            consumer.accept(publishConnection);
            if (z) {
                this.source.subscribe(publishConnection);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    public int publishBufferSize() {
        return this.bufferSize;
    }

    @Override // io.reactivex.internal.disposables.ResettableConnectable
    public void resetIf(Disposable disposable) {
        p62.a(this.current, (PublishConnection) disposable, null);
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public i92 source() {
        return this.source;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(cw2 cw2Var) {
        PublishConnection<T> publishConnection;
        while (true) {
            publishConnection = this.current.get();
            if (publishConnection != null) {
                break;
            }
            PublishConnection<T> publishConnection2 = new PublishConnection<>(this.current, this.bufferSize);
            if (p62.a(this.current, publishConnection, publishConnection2)) {
                publishConnection = publishConnection2;
                break;
            }
        }
        InnerSubscription<T> innerSubscription = new InnerSubscription<>(cw2Var, publishConnection);
        cw2Var.onSubscribe(innerSubscription);
        if (publishConnection.add(innerSubscription)) {
            if (innerSubscription.isCancelled()) {
                publishConnection.remove(innerSubscription);
                return;
            } else {
                publishConnection.drain();
                return;
            }
        }
        Throwable th = publishConnection.error;
        if (th != null) {
            cw2Var.onError(th);
        } else {
            cw2Var.onComplete();
        }
    }
}
