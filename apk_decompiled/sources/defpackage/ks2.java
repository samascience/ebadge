package defpackage;

import java.io.Closeable;

/* JADX INFO: loaded from: classes4.dex */
public interface ks2 extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    long read(fo foVar, long j);

    h33 timeout();
}
