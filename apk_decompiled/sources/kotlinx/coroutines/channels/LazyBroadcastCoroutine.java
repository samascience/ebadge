package kotlinx.coroutines.channels;

import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.a;
import kotlinx.coroutines.intrinsics.CancellableKt;

/* JADX INFO: loaded from: classes4.dex */
final class LazyBroadcastCoroutine<E> extends BroadcastCoroutine<E> {
    private final x30 continuation;

    public LazyBroadcastCoroutine(d dVar, BroadcastChannel<E> broadcastChannel, or0 or0Var) {
        super(dVar, broadcastChannel, false);
        this.continuation = a.b(or0Var, this, this);
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void onStart() throws Throwable {
        CancellableKt.startCoroutineCancellable(this.continuation, this);
    }

    @Override // kotlinx.coroutines.channels.BroadcastCoroutine, kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel<E> openSubscription() {
        ReceiveChannel<E> receiveChannelOpenSubscription = get_channel().openSubscription();
        start();
        return receiveChannelOpenSubscription;
    }
}
