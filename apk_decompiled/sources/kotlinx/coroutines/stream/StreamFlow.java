package kotlinx.coroutines.stream;

import defpackage.h70;
import defpackage.k83;
import defpackage.x30;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.d;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes4.dex */
final class StreamFlow<T> implements Flow<T> {
    private static final AtomicIntegerFieldUpdater consumed$FU = AtomicIntegerFieldUpdater.newUpdater(StreamFlow.class, "consumed");
    private volatile int consumed = 0;
    private final Stream<T> stream;

    /* JADX INFO: renamed from: kotlinx.coroutines.stream.StreamFlow$collect$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.stream.StreamFlow", f = "Stream.kt", l = {26}, m = "collect")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ StreamFlow<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StreamFlow<T> streamFlow, x30 x30Var) {
            super(x30Var);
            this.this$0 = streamFlow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.collect(null, this);
        }
    }

    public StreamFlow(Stream<T> stream) {
        this.stream = stream;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, x30 x30Var) throws Throwable {
        AnonymousClass1 anonymousClass1;
        StreamFlow<T> streamFlow;
        FlowCollector<? super T> flowCollector2;
        Iterator<T> it;
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
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            d.b(obj);
            if (!consumed$FU.compareAndSet(this, 0, 1)) {
                throw new IllegalStateException("Stream.consumeAsFlow can be collected only once");
            }
            try {
                streamFlow = this;
                flowCollector2 = flowCollector;
                it = this.stream.iterator();
            } catch (Throwable th) {
                th = th;
                streamFlow = this;
                streamFlow.stream.close();
                throw th;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) anonymousClass1.L$2;
            FlowCollector<? super T> flowCollector3 = (FlowCollector) anonymousClass1.L$1;
            streamFlow = (StreamFlow) anonymousClass1.L$0;
            try {
                d.b(obj);
                flowCollector2 = flowCollector3;
            } catch (Throwable th2) {
                th = th2;
                streamFlow.stream.close();
                throw th;
            }
        }
        while (it.hasNext()) {
            T next = it.next();
            anonymousClass1.L$0 = streamFlow;
            anonymousClass1.L$1 = flowCollector2;
            anonymousClass1.L$2 = it;
            anonymousClass1.label = 1;
            if (flowCollector2.emit(next, anonymousClass1) == objD) {
                return objD;
            }
        }
        streamFlow.stream.close();
        return k83.a;
    }
}
