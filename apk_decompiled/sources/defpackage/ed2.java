package defpackage;

import com.tencent.open.SocialConstants;
import java.nio.ByteBuffer;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class ed2 implements ro {
    public final er2 a;
    public final fo b;
    public boolean c;

    public ed2(er2 er2Var) {
        p31.f(er2Var, "sink");
        this.a = er2Var;
        this.b = new fo();
    }

    @Override // defpackage.ro
    public ro A() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long size = this.b.size();
        if (size > 0) {
            this.a.b0(this.b, size);
        }
        return this;
    }

    @Override // defpackage.ro
    public ro B(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.B(i);
        return M();
    }

    @Override // defpackage.ro
    public ro C0(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.C0(j);
        return M();
    }

    @Override // defpackage.ro
    public ro F(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.F(i);
        return M();
    }

    @Override // defpackage.ro
    public ro I(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.I(i);
        return M();
    }

    @Override // defpackage.ro
    public long L(ks2 ks2Var) {
        p31.f(ks2Var, SocialConstants.PARAM_SOURCE);
        long j = 0;
        while (true) {
            long j2 = ks2Var.read(this.b, 8192L);
            if (j2 == -1) {
                return j;
            }
            j += j2;
            M();
        }
    }

    @Override // defpackage.ro
    public ro M() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long jY = this.b.y();
        if (jY > 0) {
            this.a.b0(this.b, jY);
        }
        return this;
    }

    @Override // defpackage.ro
    public ro S(String str) {
        p31.f(str, "string");
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.S(str);
        return M();
    }

    @Override // defpackage.ro
    public ro Z(byte[] bArr, int i, int i2) {
        p31.f(bArr, SocialConstants.PARAM_SOURCE);
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.Z(bArr, i, i2);
        return M();
    }

    @Override // defpackage.ro
    public fo b() {
        return this.b;
    }

    @Override // defpackage.er2
    public void b0(fo foVar, long j) {
        p31.f(foVar, SocialConstants.PARAM_SOURCE);
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.b0(foVar, j);
        M();
    }

    @Override // defpackage.ro
    public ro c0(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.c0(j);
        return M();
    }

    @Override // defpackage.er2, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.c) {
            return;
        }
        if (this.b.size() > 0) {
            er2 er2Var = this.a;
            fo foVar = this.b;
            er2Var.b0(foVar, foVar.size());
        }
        th = null;
        try {
            this.a.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // defpackage.ro, defpackage.er2, java.io.Flushable
    public void flush() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.b.size() > 0) {
            er2 er2Var = this.a;
            fo foVar = this.b;
            er2Var.b0(foVar, foVar.size());
        }
        this.a.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // defpackage.er2
    public h33 timeout() {
        return this.a.timeout();
    }

    public String toString() {
        return "buffer(" + this.a + ')';
    }

    @Override // defpackage.ro
    public ro u0(byte[] bArr) {
        p31.f(bArr, SocialConstants.PARAM_SOURCE);
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.u0(bArr);
        return M();
    }

    @Override // defpackage.ro
    public ro v0(ByteString byteString) {
        p31.f(byteString, "byteString");
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.b.v0(byteString);
        return M();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        p31.f(byteBuffer, SocialConstants.PARAM_SOURCE);
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.b.write(byteBuffer);
        M();
        return iWrite;
    }
}
