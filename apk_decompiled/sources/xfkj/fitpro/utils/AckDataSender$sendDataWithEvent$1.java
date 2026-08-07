package xfkj.fitpro.utils;

import android.os.Handler;
import android.os.Looper;
import defpackage.ar0;
import defpackage.h70;
import defpackage.k83;
import defpackage.ng;
import defpackage.or0;
import defpackage.x30;
import defpackage.yq0;
import defpackage.zi2;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.utils.AckDataSender$sendDataWithEvent$1", f = "AckDataSender.kt", l = {}, m = "invokeSuspend")
final class AckDataSender$sendDataWithEvent$1 extends SuspendLambda implements or0 {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ Class<ng> $eventClass;
    final /* synthetic */ int $maxRetries;
    final /* synthetic */ ar0 $onError;
    final /* synthetic */ ar0 $onEventReceived;
    final /* synthetic */ or0 $onRetry;
    final /* synthetic */ yq0 $onTimeout;
    final /* synthetic */ int $requestId;
    final /* synthetic */ long $retryDelayMs;
    final /* synthetic */ long $timeoutMs;
    int label;
    final /* synthetic */ xfkj.fitpro.utils.a this$0;

    public static final class a implements xfkj.fitpro.utils.a.c {
        final /* synthetic */ Handler a;
        final /* synthetic */ Runnable b;
        final /* synthetic */ int c;
        final /* synthetic */ ar0 d;
        final /* synthetic */ Class e;

        a(Handler handler, Runnable runnable, xfkj.fitpro.utils.a aVar, int i, ar0 ar0Var, Class cls) {
            this.a = handler;
            this.b = runnable;
            this.c = i;
            this.d = ar0Var;
            this.e = cls;
        }
    }

    public static final class b implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ Ref$IntRef b;
        final /* synthetic */ int c;
        final /* synthetic */ or0 d;
        final /* synthetic */ long e;
        final /* synthetic */ yq0 f;
        final /* synthetic */ Class g;
        final /* synthetic */ ar0 h;
        final /* synthetic */ byte[] i;
        final /* synthetic */ long j;
        final /* synthetic */ ar0 k;

        public b(xfkj.fitpro.utils.a aVar, int i, Ref$IntRef ref$IntRef, int i2, or0 or0Var, long j, yq0 yq0Var, Class cls, ar0 ar0Var, byte[] bArr, long j2, ar0 ar0Var2) {
            this.a = i;
            this.b = ref$IntRef;
            this.c = i2;
            this.d = or0Var;
            this.e = j;
            this.f = yq0Var;
            this.g = cls;
            this.h = ar0Var;
            this.i = bArr;
            this.j = j2;
            this.k = ar0Var2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            xfkj.fitpro.utils.a.g(null, "等待事件超时，请求ID: " + this.a + "，重试次数: " + this.b.element);
            BuildersKt__Builders_commonKt.launch$default(xfkj.fitpro.utils.a.b(null), null, null, new AckDataSender$sendDataWithEvent$1$attemptSend$timeoutRunnable$1$1(this.b, this.c, null, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.a, this.k, null), 3, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AckDataSender$sendDataWithEvent$1(xfkj.fitpro.utils.a aVar, ar0 ar0Var, byte[] bArr, long j, Class<ng> cls, int i, ar0 ar0Var2, int i2, or0 or0Var, long j2, yq0 yq0Var, x30 x30Var) {
        super(2, x30Var);
        this.$onError = ar0Var;
        this.$data = bArr;
        this.$timeoutMs = j;
        this.$eventClass = cls;
        this.$requestId = i;
        this.$onEventReceived = ar0Var2;
        this.$maxRetries = i2;
        this.$onRetry = or0Var;
        this.$retryDelayMs = j2;
        this.$onTimeout = yq0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends ng> void invokeSuspend$attemptSend(xfkj.fitpro.utils.a aVar, ar0 ar0Var, byte[] bArr, long j, Class<T> cls, int i, Ref$IntRef ref$IntRef, ar0 ar0Var2, int i2, or0 or0Var, long j2, yq0 yq0Var) {
        if (!zi2.i()) {
            xfkj.fitpro.utils.a.e(aVar, "设备未连接");
            if (ar0Var != null) {
                ar0Var.invoke("设备未连接");
                return;
            }
            return;
        }
        try {
            zi2.o(bArr, "ddddd");
            Handler handler = new Handler(Looper.getMainLooper());
            b bVar = new b(aVar, i, ref$IntRef, i2, or0Var, j2, yq0Var, cls, ar0Var, bArr, j, ar0Var2);
            handler.postDelayed(bVar, j);
            xfkj.fitpro.utils.a.h(aVar, cls, new a(handler, bVar, aVar, i, ar0Var2, cls));
        } catch (Exception e) {
            xfkj.fitpro.utils.a.e(aVar, "数据发送失败: " + e.getMessage());
            if (ar0Var != null) {
                ar0Var.invoke("发送失败: " + e.getMessage());
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new AckDataSender$sendDataWithEvent$1(null, this.$onError, this.$data, this.$timeoutMs, this.$eventClass, this.$requestId, this.$onEventReceived, this.$maxRetries, this.$onRetry, this.$retryDelayMs, this.$onTimeout, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        d.b(obj);
        invokeSuspend$attemptSend(null, this.$onError, this.$data, this.$timeoutMs, this.$eventClass, this.$requestId, new Ref$IntRef(), this.$onEventReceived, this.$maxRetries, this.$onRetry, this.$retryDelayMs, this.$onTimeout);
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((AckDataSender$sendDataWithEvent$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
