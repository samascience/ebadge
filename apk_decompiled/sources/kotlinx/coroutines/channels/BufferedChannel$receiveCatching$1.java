package kotlinx.coroutines.channels;

import defpackage.h70;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", l = {739}, m = "receiveCatching-JP2dKIU$suspendImpl")
final class BufferedChannel$receiveCatching$1<E> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BufferedChannel<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BufferedChannel$receiveCatching$1(BufferedChannel<E> bufferedChannel, x30 x30Var) {
        super(x30Var);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM94receiveCatchingJP2dKIU$suspendImpl = BufferedChannel.m94receiveCatchingJP2dKIU$suspendImpl(this.this$0, this);
        return objM94receiveCatchingJP2dKIU$suspendImpl == a.d() ? objM94receiveCatchingJP2dKIU$suspendImpl : ChannelResult.m102boximpl(objM94receiveCatchingJP2dKIU$suspendImpl);
    }
}
