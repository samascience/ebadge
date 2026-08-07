package kotlinx.coroutines.flow;

import defpackage.ar0;
import defpackage.be0;
import defpackage.h70;
import defpackage.k83;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.TimeoutCancellationException;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$2", f = "Delay.kt", l = {}, m = "invokeSuspend")
final class FlowKt__DelayKt$timeoutInternal$1$1$2 extends SuspendLambda implements ar0 {
    final /* synthetic */ long $timeout;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$timeoutInternal$1$1$2(long j, x30 x30Var) {
        super(1, x30Var);
        this.$timeout = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(x30 x30Var) {
        return new FlowKt__DelayKt$timeoutInternal$1$1$2(this.$timeout, x30Var);
    }

    @Override // defpackage.ar0
    public final Object invoke(x30 x30Var) {
        return ((FlowKt__DelayKt$timeoutInternal$1$1$2) create(x30Var)).invokeSuspend(k83.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        a.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        d.b(obj);
        throw new TimeoutCancellationException("Timed out waiting for " + ((Object) be0.x(this.$timeout)));
    }
}
