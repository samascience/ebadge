package kotlinx.coroutines.flow.internal;

import defpackage.k83;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes4.dex */
@InternalCoroutinesApi
public final class SendingCollector<T> implements FlowCollector<T> {
    private final SendChannel<T> channel;

    /* JADX WARN: Multi-variable type inference failed */
    public SendingCollector(SendChannel<? super T> sendChannel) {
        this.channel = sendChannel;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, x30 x30Var) {
        Object objSend = this.channel.send(t, x30Var);
        return objSend == a.d() ? objSend : k83.a;
    }
}
