package io.reactivex.internal.operators.flowable;

import defpackage.cw2;
import defpackage.dw2;
import defpackage.i92;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableSubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {
    final boolean nonScheduledRequests;
    final Scheduler scheduler;

    static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements FlowableSubscriber<T>, dw2, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;
        final cw2 downstream;
        final boolean nonScheduledRequests;
        i92 source;
        final Scheduler.Worker worker;
        final AtomicReference<dw2> upstream = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        static final class Request implements Runnable {
            final long n;
            final dw2 upstream;

            Request(dw2 dw2Var, long j) {
                this.upstream = dw2Var;
                this.n = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.upstream.request(this.n);
            }
        }

        SubscribeOnSubscriber(cw2 cw2Var, Scheduler.Worker worker, i92 i92Var, boolean z) {
            this.downstream = cw2Var;
            this.worker = worker;
            this.source = i92Var;
            this.nonScheduledRequests = !z;
        }

        @Override // defpackage.dw2
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.worker.dispose();
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onComplete() {
            this.downstream.onComplete();
            this.worker.dispose();
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onError(Throwable th) {
            this.downstream.onError(th);
            this.worker.dispose();
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onSubscribe(dw2 dw2Var) {
            if (SubscriptionHelper.setOnce(this.upstream, dw2Var)) {
                long andSet = this.requested.getAndSet(0L);
                if (andSet != 0) {
                    requestUpstream(andSet, dw2Var);
                }
            }
        }

        @Override // defpackage.dw2
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                dw2 dw2Var = this.upstream.get();
                if (dw2Var != null) {
                    requestUpstream(j, dw2Var);
                    return;
                }
                BackpressureHelper.add(this.requested, j);
                dw2 dw2Var2 = this.upstream.get();
                if (dw2Var2 != null) {
                    long andSet = this.requested.getAndSet(0L);
                    if (andSet != 0) {
                        requestUpstream(andSet, dw2Var2);
                    }
                }
            }
        }

        void requestUpstream(long j, dw2 dw2Var) {
            if (this.nonScheduledRequests || Thread.currentThread() == get()) {
                dw2Var.request(j);
            } else {
                this.worker.schedule(new Request(dw2Var, j));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            lazySet(Thread.currentThread());
            i92 i92Var = this.source;
            this.source = null;
            i92Var.subscribe(this);
        }
    }

    public FlowableSubscribeOn(Flowable<T> flowable, Scheduler scheduler, boolean z) {
        super(flowable);
        this.scheduler = scheduler;
        this.nonScheduledRequests = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(cw2 cw2Var) {
        Scheduler.Worker workerCreateWorker = this.scheduler.createWorker();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(cw2Var, workerCreateWorker, this.source, this.nonScheduledRequests);
        cw2Var.onSubscribe(subscribeOnSubscriber);
        workerCreateWorker.schedule(subscribeOnSubscriber);
    }
}
