package kotlinx.coroutines;

import defpackage.oi0;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes4.dex */
public final class ExceptionsKt {
    public static final CancellationException CancellationException(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static final void addSuppressedThrowable(Throwable th, Throwable th2) {
        oi0.a(th, th2);
    }
}
