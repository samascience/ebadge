package kotlinx.coroutines;

import defpackage.k83;
import defpackage.x30;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
@InternalCoroutinesApi
public interface DelayWithTimeoutDiagnostics extends Delay {

    public static final class DefaultImpls {
        public static Object delay(DelayWithTimeoutDiagnostics delayWithTimeoutDiagnostics, long j, x30 x30Var) {
            Object objDelay = Delay.DefaultImpls.delay(delayWithTimeoutDiagnostics, j, x30Var);
            return objDelay == kotlin.coroutines.intrinsics.a.d() ? objDelay : k83.a;
        }

        public static DisposableHandle invokeOnTimeout(DelayWithTimeoutDiagnostics delayWithTimeoutDiagnostics, long j, Runnable runnable, d dVar) {
            return Delay.DefaultImpls.invokeOnTimeout(delayWithTimeoutDiagnostics, j, runnable, dVar);
        }
    }

    /* JADX INFO: renamed from: timeoutMessage-LRDsOJo, reason: not valid java name */
    String m83timeoutMessageLRDsOJo(long j);
}
