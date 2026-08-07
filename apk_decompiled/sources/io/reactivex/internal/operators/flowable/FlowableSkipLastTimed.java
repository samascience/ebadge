package io.reactivex.internal.operators.flowable;

import defpackage.cw2;
import defpackage.dw2;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableSkipLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final int bufferSize;
    final boolean delayError;
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    static final class SkipLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, dw2 {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final cw2 downstream;
        Throwable error;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested = new AtomicLong();
        final Scheduler scheduler;
        final long time;
        final TimeUnit unit;
        dw2 upstream;

        SkipLastTimedSubscriber(cw2 cw2Var, long j, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
            this.downstream = cw2Var;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.queue = new SpscLinkedArrayQueue<>(i);
            this.delayError = z;
        }

        @Override // defpackage.dw2
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, cw2 cw2Var, boolean z3) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    cw2Var.onError(th);
                } else {
                    cw2Var.onComplete();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                cw2Var.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            cw2Var.onComplete();
            return true;
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            cw2 cw2Var = this.downstream;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            boolean z = this.delayError;
            TimeUnit timeUnit = this.unit;
            Scheduler scheduler = this.scheduler;
            long j = this.time;
            int iAddAndGet = 1;
            do {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    boolean z2 = this.done;
                    Long l = (Long) spscLinkedArrayQueue.peek();
                    boolean z3 = l == null;
                    boolean z4 = (z3 || l.longValue() <= scheduler.now(timeUnit) - j) ? z3 : true;
                    if (checkTerminated(z2, z4, cw2Var, z)) {
                        return;
                    }
                    if (z4) {
                        break;
                    }
                    spscLinkedArrayQueue.poll();
                    cw2Var.onNext(spscLinkedArrayQueue.poll());
                    j3++;
                }
                if (j3 != 0) {
                    BackpressureHelper.produced(this.requested, j3);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
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
            this.queue.offer(Long.valueOf(this.scheduler.now(this.unit)), t);
            drain();
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onSubscribe(dw2 dw2Var) {
            if (SubscriptionHelper.validate(this.upstream, dw2Var)) {
                this.upstream = dw2Var;
                this.downstream.onSubscribe(this);
                dw2Var.request(Long.MAX_VALUE);
            }
        }

        @Override // defpackage.dw2
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }
    }

    public FlowableSkipLastTimed(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        super(flowable);
        this.time = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSize = i;
        this.delayError = z;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(cw2 cw2Var) {
        this.source.subscribe((FlowableSubscriber) new SkipLastTimedSubscriber(cw2Var, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }
}
