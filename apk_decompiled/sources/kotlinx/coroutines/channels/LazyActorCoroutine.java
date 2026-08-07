package kotlinx.coroutines.channels;

import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.p63;
import defpackage.pr0;
import defpackage.x30;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.a;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: loaded from: classes4.dex */
final class LazyActorCoroutine<E> extends ActorCoroutine<E> {
    private x30 continuation;

    public LazyActorCoroutine(d dVar, Channel<E> channel, or0 or0Var) {
        super(dVar, channel, false);
        this.continuation = a.b(or0Var, this, this);
    }

    public static /* synthetic */ void getOnSend$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSendRegFunction(SelectInstance<?> selectInstance, Object obj) throws Throwable {
        onStart();
        super.getOnSend().getRegFunc().invoke(this, selectInstance, obj);
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable th) {
        boolean zClose = super.close(th);
        start();
        return zClose;
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        LazyActorCoroutine$onSend$1 lazyActorCoroutine$onSend$1 = LazyActorCoroutine$onSend$1.INSTANCE;
        p31.d(lazyActorCoroutine$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new SelectClause2Impl(this, (pr0) p63.a(lazyActorCoroutine$onSend$1, 3), super.getOnSend().getProcessResFunc(), null, 8, null);
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public boolean offer(E e) {
        start();
        return super.offer(e);
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void onStart() throws Throwable {
        CancellableKt.startCoroutineCancellable(this.continuation, this);
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public Object send(E e, x30 x30Var) {
        start();
        Object objSend = super.send(e, x30Var);
        return objSend == a.d() ? objSend : k83.a;
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo92trySendJP2dKIU(E e) {
        start();
        return super.mo92trySendJP2dKIU(e);
    }
}
