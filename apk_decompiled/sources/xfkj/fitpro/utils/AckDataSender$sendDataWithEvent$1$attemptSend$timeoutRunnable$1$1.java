package xfkj.fitpro.utils;

import defpackage.ar0;
import defpackage.h70;
import defpackage.jn;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import defpackage.yq0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.utils.AckDataSender$sendDataWithEvent$1$attemptSend$timeoutRunnable$1$1", f = "AckDataSender.kt", l = {224}, m = "invokeSuspend")
final class AckDataSender$sendDataWithEvent$1$attemptSend$timeoutRunnable$1$1 extends SuspendLambda implements or0 {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ Class<T> $eventClass;
    final /* synthetic */ int $maxRetries;
    final /* synthetic */ ar0 $onError;
    final /* synthetic */ ar0 $onEventReceived;
    final /* synthetic */ or0 $onRetry;
    final /* synthetic */ yq0 $onTimeout;
    final /* synthetic */ int $requestId;
    final /* synthetic */ Ref$IntRef $retryCount;
    final /* synthetic */ long $retryDelayMs;
    final /* synthetic */ long $timeoutMs;
    int label;
    final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AckDataSender$sendDataWithEvent$1$attemptSend$timeoutRunnable$1$1(Ref$IntRef ref$IntRef, int i, a aVar, or0 or0Var, long j, yq0 yq0Var, Class<T> cls, ar0 ar0Var, byte[] bArr, long j2, int i2, ar0 ar0Var2, x30 x30Var) {
        super(2, x30Var);
        this.$retryCount = ref$IntRef;
        this.$maxRetries = i;
        this.$onRetry = or0Var;
        this.$retryDelayMs = j;
        this.$onTimeout = yq0Var;
        this.$eventClass = cls;
        this.$onError = ar0Var;
        this.$data = bArr;
        this.$timeoutMs = j2;
        this.$requestId = i2;
        this.$onEventReceived = ar0Var2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new AckDataSender$sendDataWithEvent$1$attemptSend$timeoutRunnable$1$1(this.$retryCount, this.$maxRetries, null, this.$onRetry, this.$retryDelayMs, this.$onTimeout, this.$eventClass, this.$onError, this.$data, this.$timeoutMs, this.$requestId, this.$onEventReceived, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            Ref$IntRef ref$IntRef = this.$retryCount;
            int i2 = ref$IntRef.element;
            if (i2 < this.$maxRetries) {
                int i3 = i2 + 1;
                ref$IntRef.element = i3;
                a.f(null, "开始第 " + i3 + " 次重试");
                or0 or0Var = this.$onRetry;
                if (or0Var != null) {
                    or0Var.invoke(jn.b(this.$retryCount.element), "超时重试");
                }
                long j = this.$retryDelayMs;
                this.label = 1;
                if (DelayKt.delay(j, this) == objD) {
                    return objD;
                }
            } else {
                a.g(null, "重试次数已达上限，停止重试");
                yq0 yq0Var = this.$onTimeout;
                if (yq0Var != null) {
                    yq0Var.invoke();
                }
                a.i(null, this.$eventClass);
            }
            return k83.a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        d.b(obj);
        AckDataSender$sendDataWithEvent$1.invokeSuspend$attemptSend(null, this.$onError, this.$data, this.$timeoutMs, this.$eventClass, this.$requestId, this.$retryCount, this.$onEventReceived, this.$maxRetries, this.$onRetry, this.$retryDelayMs, this.$onTimeout);
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((AckDataSender$sendDataWithEvent$1$attemptSend$timeoutRunnable$1$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
