package kotlinx.coroutines.flow.internal;

import defpackage.j70;
import defpackage.or0;
import defpackage.p63;
import defpackage.x30;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.a;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ChannelFlowKt {
    public static final <T> ChannelFlow<T> asChannelFlow(Flow<? extends T> flow) {
        ChannelFlow<T> channelFlow = flow instanceof ChannelFlow ? (ChannelFlow) flow : null;
        if (channelFlow == null) {
            return new ChannelFlowOperatorImpl(flow, null, 0, null, 14, null);
        }
        return channelFlow;
    }

    public static final <T, V> Object withContextUndispatched(d dVar, V v, Object obj, or0 or0Var, x30 x30Var) {
        Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(dVar, obj);
        try {
            Object objInvoke = ((or0) p63.a(or0Var, 2)).invoke(v, new StackFrameContinuation(x30Var, dVar));
            ThreadContextKt.restoreThreadContext(dVar, objUpdateThreadContext);
            if (objInvoke == a.d()) {
                j70.c(x30Var);
            }
            return objInvoke;
        } catch (Throwable th) {
            ThreadContextKt.restoreThreadContext(dVar, objUpdateThreadContext);
            throw th;
        }
    }

    public static /* synthetic */ Object withContextUndispatched$default(d dVar, Object obj, Object obj2, or0 or0Var, x30 x30Var, int i, Object obj3) {
        if ((i & 4) != 0) {
            obj2 = ThreadContextKt.threadContextElements(dVar);
        }
        return withContextUndispatched(dVar, obj, obj2, or0Var, x30Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> FlowCollector<T> withUndispatchedContextCollector(FlowCollector<? super T> flowCollector, d dVar) {
        return flowCollector instanceof SendingCollector ? true : flowCollector instanceof NopCollector ? flowCollector : new UndispatchedContextCollector(flowCollector, dVar);
    }
}
