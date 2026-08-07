package defpackage;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/* JADX INFO: loaded from: classes4.dex */
public final class u5 extends Handler {
    public static final u5 a = new u5();

    private u5() {
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        p31.f(logRecord, "record");
        t5 t5Var = t5.a;
        String loggerName = logRecord.getLoggerName();
        p31.e(loggerName, "record.loggerName");
        int iB = v5.b(logRecord);
        String message = logRecord.getMessage();
        p31.e(message, "record.message");
        t5Var.a(loggerName, iB, message, logRecord.getThrown());
    }
}
