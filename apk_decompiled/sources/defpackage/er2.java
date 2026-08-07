package defpackage;

import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: loaded from: classes4.dex */
public interface er2 extends Closeable, Flushable {
    void b0(fo foVar, long j);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();

    h33 timeout();
}
