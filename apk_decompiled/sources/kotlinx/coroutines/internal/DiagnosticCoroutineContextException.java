package kotlinx.coroutines.internal;

import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
public final class DiagnosticCoroutineContextException extends RuntimeException {
    private final transient d context;

    public DiagnosticCoroutineContextException(d dVar) {
        this.context = dVar;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.context.toString();
    }
}
