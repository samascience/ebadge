package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.d;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: loaded from: classes4.dex */
public final class SubscribedFlowCollector<T> implements FlowCollector<T> {
    private final or0 action;
    private final FlowCollector<T> collector;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", l = {419, 423}, m = "onSubscription")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SubscribedFlowCollector<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SubscribedFlowCollector<T> subscribedFlowCollector, x30 x30Var) {
            super(x30Var);
            this.this$0 = subscribedFlowCollector;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.onSubscription(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubscribedFlowCollector(FlowCollector<? super T> flowCollector, or0 or0Var) {
        this.collector = flowCollector;
        this.action = or0Var;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, x30 x30Var) {
        return this.collector.emit(t, x30Var);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    public final Object onSubscription(x30 x30Var) throws Throwable {
        AnonymousClass1 anonymousClass1;
        SafeCollector safeCollector;
        SubscribedFlowCollector<T> subscribedFlowCollector;
        if (x30Var instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) x30Var;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, x30Var);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(this, x30Var);
        }
        Object obj = anonymousClass1.result;
        Object objD = a.d();
        ?? r2 = anonymousClass1.label;
        try {
            if (r2 != 0) {
                if (r2 == 1) {
                    safeCollector = (SafeCollector) anonymousClass1.L$1;
                    subscribedFlowCollector = (SubscribedFlowCollector) anonymousClass1.L$0;
                    d.b(obj);
                } else {
                    if (r2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d.b(obj);
                }
                return k83.a;
            }
            d.b(obj);
            safeCollector = new SafeCollector(this.collector, anonymousClass1.getContext());
            or0 or0Var = this.action;
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = safeCollector;
            anonymousClass1.label = 1;
            if (or0Var.invoke(safeCollector, anonymousClass1) == objD) {
                return objD;
            }
            subscribedFlowCollector = this;
            safeCollector.releaseIntercepted();
            FlowCollector<T> flowCollector = subscribedFlowCollector.collector;
            r2 = flowCollector instanceof SubscribedFlowCollector;
            if (r2 == 0) {
                return k83.a;
            }
            anonymousClass1.L$0 = null;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 2;
            if (((SubscribedFlowCollector) flowCollector).onSubscription(anonymousClass1) == objD) {
                return objD;
            }
            return k83.a;
        } catch (Throwable th) {
            r2.releaseIntercepted();
            throw th;
        }
    }
}
