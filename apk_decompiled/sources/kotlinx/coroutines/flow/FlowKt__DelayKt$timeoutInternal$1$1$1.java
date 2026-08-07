package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.jn;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1", f = "Delay.kt", l = {404}, m = "invokeSuspend")
final class FlowKt__DelayKt$timeoutInternal$1$1$1 extends SuspendLambda implements or0 {
    final /* synthetic */ FlowCollector<T> $downStream;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__DelayKt$timeoutInternal$1$1$1(FlowCollector<? super T> flowCollector, x30 x30Var) {
        super(2, x30Var);
        this.$downStream = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        FlowKt__DelayKt$timeoutInternal$1$1$1 flowKt__DelayKt$timeoutInternal$1$1$1 = new FlowKt__DelayKt$timeoutInternal$1$1$1(this.$downStream, x30Var);
        flowKt__DelayKt$timeoutInternal$1$1$1.L$0 = obj;
        return flowKt__DelayKt$timeoutInternal$1$1$1;
    }

    @Override // defpackage.or0
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m133invokeWpGqRn0(((ChannelResult) obj).m114unboximpl(), (x30) obj2);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m133invokeWpGqRn0(Object obj, x30 x30Var) {
        return ((FlowKt__DelayKt$timeoutInternal$1$1$1) create(ChannelResult.m102boximpl(obj), x30Var)).invokeSuspend(k83.a);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003c  */
    /* JADX WARN: Code duplicated, block: B:19:0x0045  */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM114unboximpl;
        Object obj2;
        Object objD = a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            objM114unboximpl = ((ChannelResult) this.L$0).m114unboximpl();
            FlowCollector<T> flowCollector = this.$downStream;
            if (!(objM114unboximpl instanceof ChannelResult.Failed)) {
                this.L$0 = objM114unboximpl;
                this.label = 1;
                if (flowCollector.emit((T) objM114unboximpl, this) == objD) {
                    return objD;
                }
                obj2 = objM114unboximpl;
            }
            if (objM114unboximpl instanceof ChannelResult.Closed) {
                return jn.a(true);
            }
            ChannelResult.m106exceptionOrNullimpl(objM114unboximpl);
            return jn.a(false);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = this.L$0;
        d.b(obj);
        objM114unboximpl = obj2;
        if (objM114unboximpl instanceof ChannelResult.Closed) {
            return jn.a(true);
        }
        ChannelResult.m106exceptionOrNullimpl(objM114unboximpl);
        return jn.a(false);
    }
}
