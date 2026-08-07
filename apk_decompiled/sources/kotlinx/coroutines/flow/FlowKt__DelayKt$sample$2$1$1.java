package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", l = {}, m = "invokeSuspend")
final class FlowKt__DelayKt$sample$2$1$1 extends SuspendLambda implements or0 {
    final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    final /* synthetic */ ReceiveChannel<k83> $ticker;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$sample$2$1$1(Ref$ObjectRef<Object> ref$ObjectRef, ReceiveChannel<k83> receiveChannel, x30 x30Var) {
        super(2, x30Var);
        this.$lastValue = ref$ObjectRef;
        this.$ticker = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        FlowKt__DelayKt$sample$2$1$1 flowKt__DelayKt$sample$2$1$1 = new FlowKt__DelayKt$sample$2$1$1(this.$lastValue, this.$ticker, x30Var);
        flowKt__DelayKt$sample$2$1$1.L$0 = obj;
        return flowKt__DelayKt$sample$2$1$1;
    }

    @Override // defpackage.or0
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m132invokeWpGqRn0(((ChannelResult) obj).m114unboximpl(), (x30) obj2);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m132invokeWpGqRn0(Object obj, x30 x30Var) {
        return ((FlowKt__DelayKt$sample$2$1$1) create(ChannelResult.m102boximpl(obj), x30Var)).invokeSuspend(k83.a);
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8, types: [T, kotlinx.coroutines.internal.Symbol] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        a.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        d.b(obj);
        ?? M114unboximpl = ((ChannelResult) this.L$0).m114unboximpl();
        Ref$ObjectRef<Object> ref$ObjectRef = this.$lastValue;
        boolean z = M114unboximpl instanceof ChannelResult.Failed;
        if (!z) {
            ref$ObjectRef.element = M114unboximpl;
        }
        ReceiveChannel<k83> receiveChannel = this.$ticker;
        if (z) {
            Throwable thM106exceptionOrNullimpl = ChannelResult.m106exceptionOrNullimpl(M114unboximpl);
            if (thM106exceptionOrNullimpl != null) {
                throw thM106exceptionOrNullimpl;
            }
            receiveChannel.cancel((CancellationException) new ChildCancelledException());
            ref$ObjectRef.element = NullSurrogateKt.DONE;
        }
        return k83.a;
    }
}
