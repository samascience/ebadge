package xfkj.fitpro.utils;

import defpackage.ar0;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.utils.AckDataSender$sendData$1$attemptSend$3", f = "AckDataSender.kt", l = {120}, m = "invokeSuspend")
final class AckDataSender$sendData$1$attemptSend$3 extends SuspendLambda implements ar0 {
    final /* synthetic */ or0 $callback;
    final /* synthetic */ byte[] $data;
    final /* synthetic */ int $maxRetries;
    final /* synthetic */ int $requestId;
    final /* synthetic */ Ref$IntRef $retryCount;
    final /* synthetic */ long $retryDelayMs;
    final /* synthetic */ long $timeoutMs;
    int label;
    final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AckDataSender$sendData$1$attemptSend$3(a aVar, Ref$IntRef ref$IntRef, int i, long j, or0 or0Var, byte[] bArr, long j2, int i2, x30 x30Var) {
        super(1, x30Var);
        this.$retryCount = ref$IntRef;
        this.$maxRetries = i;
        this.$retryDelayMs = j;
        this.$callback = or0Var;
        this.$data = bArr;
        this.$timeoutMs = j2;
        this.$requestId = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(x30 x30Var) {
        return new AckDataSender$sendData$1$attemptSend$3(null, this.$retryCount, this.$maxRetries, this.$retryDelayMs, this.$callback, this.$data, this.$timeoutMs, this.$requestId, x30Var);
    }

    @Override // defpackage.ar0
    public final Object invoke(x30 x30Var) {
        return ((AckDataSender$sendData$1$attemptSend$3) create(x30Var)).invokeSuspend(k83.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            Ref$IntRef ref$IntRef = this.$retryCount;
            int i2 = this.$maxRetries;
            long j = this.$retryDelayMs;
            or0 or0Var = this.$callback;
            byte[] bArr = this.$data;
            long j2 = this.$timeoutMs;
            int i3 = this.$requestId;
            this.label = 1;
            if (AckDataSender$sendData$1.invokeSuspend$attemptSend(null, ref$IntRef, i2, j, or0Var, bArr, j2, i3, this) == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d.b(obj);
        }
        return k83.a;
    }
}
