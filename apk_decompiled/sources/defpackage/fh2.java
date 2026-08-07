package defpackage;

import com.tencent.open.SocialConstants;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public abstract class fh2 implements Closeable {
    public static final b Companion = new b(null);
    private Reader reader;

    public static final class a extends Reader {
        private final so a;
        private final Charset b;
        private boolean c;
        private Reader d;

        public a(so soVar, Charset charset) {
            p31.f(soVar, SocialConstants.PARAM_SOURCE);
            p31.f(charset, "charset");
            this.a = soVar;
            this.b = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            k83 k83Var;
            this.c = true;
            Reader reader = this.d;
            if (reader != null) {
                reader.close();
                k83Var = k83.a;
            } else {
                k83Var = null;
            }
            if (k83Var == null) {
                this.a.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            p31.f(cArr, "cbuf");
            if (this.c) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.d;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.a.E0(), pa3.I(this.a, this.b));
                this.d = inputStreamReader;
            }
            return inputStreamReader.read(cArr, i, i2);
        }
    }

    public static final class b {

        public static final class a extends fh2 {
            final /* synthetic */ fi1 a;
            final /* synthetic */ long b;
            final /* synthetic */ so c;

            a(fi1 fi1Var, long j, so soVar) {
                this.a = fi1Var;
                this.b = j;
                this.c = soVar;
            }

            @Override // defpackage.fh2
            public long contentLength() {
                return this.b;
            }

            @Override // defpackage.fh2
            public fi1 contentType() {
                return this.a;
            }

            @Override // defpackage.fh2
            public so source() {
                return this.c;
            }
        }

        public /* synthetic */ b(y70 y70Var) {
            this();
        }

        public static /* synthetic */ fh2 i(b bVar, byte[] bArr, fi1 fi1Var, int i, Object obj) {
            if ((i & 1) != 0) {
                fi1Var = null;
            }
            return bVar.h(bArr, fi1Var);
        }

        public final fh2 a(so soVar, fi1 fi1Var, long j) {
            p31.f(soVar, "<this>");
            return new a(fi1Var, j, soVar);
        }

        public final fh2 b(fi1 fi1Var, long j, so soVar) {
            p31.f(soVar, "content");
            return a(soVar, fi1Var, j);
        }

        public final fh2 c(fi1 fi1Var, String str) {
            p31.f(str, "content");
            return f(str, fi1Var);
        }

        public final fh2 d(fi1 fi1Var, ByteString byteString) {
            p31.f(byteString, "content");
            return g(byteString, fi1Var);
        }

        public final fh2 e(fi1 fi1Var, byte[] bArr) {
            p31.f(bArr, "content");
            return h(bArr, fi1Var);
        }

        public final fh2 f(String str, fi1 fi1Var) {
            p31.f(str, "<this>");
            Charset charset = gx.b;
            if (fi1Var != null) {
                Charset charsetD = fi1.d(fi1Var, null, 1, null);
                if (charsetD == null) {
                    fi1Var = fi1.e.b(fi1Var + "; charset=utf-8");
                } else {
                    charset = charsetD;
                }
            }
            fo foVarW0 = new fo().W0(str, charset);
            return a(foVarW0, fi1Var, foVarW0.size());
        }

        public final fh2 g(ByteString byteString, fi1 fi1Var) {
            p31.f(byteString, "<this>");
            return a(new fo().v0(byteString), fi1Var, byteString.size());
        }

        public final fh2 h(byte[] bArr, fi1 fi1Var) {
            p31.f(bArr, "<this>");
            return a(new fo().u0(bArr), fi1Var, bArr.length);
        }

        private b() {
        }
    }

    public static final fh2 create(so soVar, fi1 fi1Var, long j) {
        return Companion.a(soVar, fi1Var, j);
    }

    private final Charset n() {
        Charset charsetC;
        fi1 fi1VarContentType = contentType();
        return (fi1VarContentType == null || (charsetC = fi1VarContentType.c(gx.b)) == null) ? gx.b : charsetC;
    }

    public final InputStream byteStream() {
        return source().E0();
    }

    public final ByteString byteString() throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + jContentLength);
        }
        so soVarSource = source();
        try {
            ByteString byteStringF0 = soVarSource.f0();
            ty.a(soVarSource, null);
            int size = byteStringF0.size();
            if (jContentLength == -1 || jContentLength == size) {
                return byteStringF0;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + size + ") disagree");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ty.a(soVarSource, th);
                throw th2;
            }
        }
    }

    public final byte[] bytes() throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + jContentLength);
        }
        so soVarSource = source();
        try {
            byte[] bArrG = soVarSource.G();
            ty.a(soVarSource, null);
            int length = bArrG.length;
            if (jContentLength == -1 || jContentLength == length) {
                return bArrG;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + length + ") disagree");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ty.a(soVarSource, th);
                throw th2;
            }
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        a aVar = new a(source(), n());
        this.reader = aVar;
        return aVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        pa3.m(source());
    }

    public abstract long contentLength();

    public abstract fi1 contentType();

    public abstract so source();

    public final String string() throws IOException {
        so soVarSource = source();
        try {
            String strY = soVarSource.Y(pa3.I(soVarSource, n()));
            ty.a(soVarSource, null);
            return strY;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ty.a(soVarSource, th);
                throw th2;
            }
        }
    }

    public static final fh2 create(fi1 fi1Var, long j, so soVar) {
        return Companion.b(fi1Var, j, soVar);
    }

    public static final fh2 create(fi1 fi1Var, String str) {
        return Companion.c(fi1Var, str);
    }

    public static final fh2 create(fi1 fi1Var, ByteString byteString) {
        return Companion.d(fi1Var, byteString);
    }

    public static final fh2 create(fi1 fi1Var, byte[] bArr) {
        return Companion.e(fi1Var, bArr);
    }

    public static final fh2 create(String str, fi1 fi1Var) {
        return Companion.f(str, fi1Var);
    }

    public static final fh2 create(ByteString byteString, fi1 fi1Var) {
        return Companion.g(byteString, fi1Var);
    }

    public static final fh2 create(byte[] bArr, fi1 fi1Var) {
        return Companion.h(bArr, fi1Var);
    }
}
