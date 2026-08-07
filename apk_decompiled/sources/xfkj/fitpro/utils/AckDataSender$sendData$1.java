package xfkj.fitpro.utils;

import android.os.Handler;
import android.os.Looper;
import defpackage.h70;
import defpackage.jn;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import defpackage.zi2;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.utils.AckDataSender$sendData$1", f = "AckDataSender.kt", l = {156}, m = "invokeSuspend")
final class AckDataSender$sendData$1 extends SuspendLambda implements or0 {
    final /* synthetic */ or0 $callback;
    final /* synthetic */ byte[] $data;
    final /* synthetic */ int $maxRetries;
    final /* synthetic */ int $requestId;
    final /* synthetic */ long $retryDelayMs;
    final /* synthetic */ long $timeoutMs;
    int label;
    final /* synthetic */ xfkj.fitpro.utils.a this$0;

    public static final class a implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ Ref$IntRef b;
        final /* synthetic */ int c;
        final /* synthetic */ long d;
        final /* synthetic */ or0 e;
        final /* synthetic */ byte[] f;
        final /* synthetic */ long g;

        public a(xfkj.fitpro.utils.a aVar, int i, Ref$IntRef ref$IntRef, int i2, long j, or0 or0Var, byte[] bArr, long j2) {
            this.a = i;
            this.b = ref$IntRef;
            this.c = i2;
            this.d = j;
            this.e = or0Var;
            this.f = bArr;
            this.g = j2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            xfkj.fitpro.utils.a.g(null, "等待ACK超时，请求ID: " + this.a + "，重试次数: " + this.b.element);
            BuildersKt__Builders_commonKt.launch$default(xfkj.fitpro.utils.a.b(null), null, null, new AckDataSender$sendData$1$attemptSend$timeoutRunnable$1$1(null, this.b, this.c, this.d, this.e, this.f, this.g, this.a, null), 3, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AckDataSender$sendData$1(xfkj.fitpro.utils.a aVar, int i, long j, or0 or0Var, byte[] bArr, long j2, int i2, x30 x30Var) {
        super(2, x30Var);
        this.$maxRetries = i;
        this.$retryDelayMs = j;
        this.$callback = or0Var;
        this.$data = bArr;
        this.$timeoutMs = j2;
        this.$requestId = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static final Object invokeSuspend$attemptSend(xfkj.fitpro.utils.a aVar, Ref$IntRef ref$IntRef, int i, long j, or0 or0Var, byte[] bArr, long j2, int i2, x30 x30Var) {
        if (!zi2.i()) {
            xfkj.fitpro.utils.a.e(aVar, "设备未连接，重试次数: " + ref$IntRef.element);
            Object objD = xfkj.fitpro.utils.a.d(aVar, ref$IntRef.element, i, j, or0Var, "设备未连接", new AckDataSender$sendData$1$attemptSend$2(aVar, ref$IntRef, i, j, or0Var, bArr, j2, i2, null), x30Var);
            return objD == kotlin.coroutines.intrinsics.a.d() ? objD : k83.a;
        }
        try {
            zi2.o(bArr, "ddd");
            Handler handler = new Handler(Looper.getMainLooper());
            a aVar2 = new a(aVar, i2, ref$IntRef, i, j, or0Var, bArr, j2);
            handler.postDelayed(aVar2, j2);
            xfkj.fitpro.utils.a.a(aVar).put(jn.b(i2), new xfkj.fitpro.utils.a.C0180a(aVar, i2, handler, aVar2, or0Var));
            xfkj.fitpro.utils.a.c(aVar).put(jn.b(i2), new xfkj.fitpro.utils.a.d(i2, bArr, handler, aVar2, ref$IntRef.element, i, j, or0Var));
            return k83.a;
        } catch (Exception e) {
            xfkj.fitpro.utils.a.e(aVar, "数据发送失败: " + e.getMessage());
            Object objD2 = xfkj.fitpro.utils.a.d(aVar, ref$IntRef.element, i, j, or0Var, "发送失败: " + e.getMessage(), new AckDataSender$sendData$1$attemptSend$3(aVar, ref$IntRef, i, j, or0Var, bArr, j2, i2, null), x30Var);
            return objD2 == kotlin.coroutines.intrinsics.a.d() ? objD2 : k83.a;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new AckDataSender$sendData$1(null, this.$maxRetries, this.$retryDelayMs, this.$callback, this.$data, this.$timeoutMs, this.$requestId, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            int i2 = this.$maxRetries;
            long j = this.$retryDelayMs;
            or0 or0Var = this.$callback;
            byte[] bArr = this.$data;
            long j2 = this.$timeoutMs;
            int i3 = this.$requestId;
            this.label = 1;
            if (invokeSuspend$attemptSend(null, ref$IntRef, i2, j, or0Var, bArr, j2, i3, this) == objD) {
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

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((AckDataSender$sendData$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
