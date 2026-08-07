package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public final class li0 extends InputStream {
    private static final Queue c = na3.e(0);
    private InputStream a;
    private IOException b;

    li0() {
    }

    public static li0 u(InputStream inputStream) {
        li0 li0Var;
        Queue queue = c;
        synchronized (queue) {
            li0Var = (li0) queue.poll();
        }
        if (li0Var == null) {
            li0Var = new li0();
        }
        li0Var.y(inputStream);
        return li0Var;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.a.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.a.markSupported();
    }

    public IOException n() {
        return this.b;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.a.read();
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        try {
            return this.a.skip(j);
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }

    public void w() {
        this.b = null;
        this.a = null;
        Queue queue = c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    void y(InputStream inputStream) {
        this.a = inputStream;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.a.read(bArr);
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            return this.a.read(bArr, i, i2);
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }
}
