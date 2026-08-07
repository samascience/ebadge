package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Deflater;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class dj1 implements Closeable {
    private final boolean a;
    private final fo b;
    private final Deflater c;
    private final f90 d;

    public dj1(boolean z) {
        this.a = z;
        fo foVar = new fo();
        this.b = foVar;
        Deflater deflater = new Deflater(-1, true);
        this.c = deflater;
        this.d = new f90((er2) foVar, deflater);
    }

    private final boolean u(fo foVar, ByteString byteString) {
        return foVar.m0(foVar.size() - ((long) byteString.size()), byteString);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
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
        this.d.b0(foVar, foVar.size());
        this.d.flush();
        if (u(this.b, ej1.a)) {
            long size = this.b.size() - ((long) 4);
            fo.a aVarA0 = fo.A0(this.b, null, 1, null);
            try {
                aVarA0.w(size);
                ty.a(aVarA0, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    ty.a(aVarA0, th);
                    throw th2;
                }
            }
        } else {
            this.b.I(0);
        }
        fo foVar2 = this.b;
        foVar.b0(foVar2, foVar2.size());
    }
}
