package kotlinx.coroutines.channels;

import defpackage.h70;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", l = {3056}, m = "receiveCatchingOnNoWaiterSuspend-GKJJFZk")
final class BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BufferedChannel<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(BufferedChannel<E> bufferedChannel, x30 x30Var) {
        super(x30Var);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM95receiveCatchingOnNoWaiterSuspendGKJJFZk = this.this$0.m95receiveCatchingOnNoWaiterSuspendGKJJFZk(null, 0, 0L, this);
        return objM95receiveCatchingOnNoWaiterSuspendGKJJFZk == a.d() ? objM95receiveCatchingOnNoWaiterSuspendGKJJFZk : ChannelResult.m102boximpl(objM95receiveCatchingOnNoWaiterSuspendGKJJFZk);
    }
}
