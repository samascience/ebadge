package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes4.dex */
public final class hj1 implements Closeable {
    private final boolean a;
    private final fo b;
    private final Inflater c;
    private final d21 d;

    public hj1(boolean z) {
        this.a = z;
        fo foVar = new fo();
        this.b = foVar;
        Inflater inflater = new Inflater(true);
        this.c = inflater;
        this.d = new d21((ks2) foVar, inflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.d.close();
    }

    public final void n(fo foVar) throws IOException {
        p31.f(foVar, "buffer");
        if (this.b.size() != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (this.a) {
            this.c.reset();
        }
        this.b.L(foVar);
        this.b.F(65535);
        long bytesRead = this.c.getBytesRead() + this.b.size();
        do {
            this.d.n(foVar, Long.MAX_VALUE);
        } while (this.c.getBytesRead() < bytesRead);
    }
}
