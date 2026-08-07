package defpackage;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ff2 {
    public static final a Companion = new a(null);

    public static final class a {

        /* JADX INFO: renamed from: ff2$a$a, reason: collision with other inner class name */
        public static final class C0128a extends ff2 {
            final /* synthetic */ fi1 a;
            final /* synthetic */ File b;

            C0128a(fi1 fi1Var, File file) {
                this.a = fi1Var;
                this.b = file;
            }

            @Override // defpackage.ff2
            public long contentLength() {
                return this.b.length();
            }

            @Override // defpackage.ff2
            public fi1 contentType() {
                return this.a;
            }

            @Override // defpackage.ff2
            public void writeTo(ro roVar) throws IOException {
                p31.f(roVar, "sink");
                ks2 ks2VarE = hu1.e(this.b);
                try {
                    roVar.L(ks2VarE);
                    ty.a(ks2VarE, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        ty.a(ks2VarE, th);
                        throw th2;
                    }
                }
            }
        }

        public static final class b extends ff2 {
            final /* synthetic */ fi1 a;
            final /* synthetic */ ByteString b;

            b(fi1 fi1Var, ByteString byteString) {
                this.a = fi1Var;
                this.b = byteString;
            }

            @Override // defpackage.ff2
            public long contentLength() {
                return this.b.size();
            }

            @Override // defpackage.ff2
            public fi1 contentType() {
                return this.a;
            }

            @Override // defpackage.ff2
            public void writeTo(ro roVar) {
                p31.f(roVar, "sink");
                roVar.v0(this.b);
            }
        }

        public static final class c extends ff2 {
            final /* synthetic */ fi1 a;
            final /* synthetic */ int b;
            final /* synthetic */ byte[] c;
            final /* synthetic */ int d;

            c(fi1 fi1Var, int i, byte[] bArr, int i2) {
                this.a = fi1Var;
                this.b = i;
                this.c = bArr;
                this.d = i2;
            }

            @Override // defpackage.ff2
            public long contentLength() {
                return this.b;
            }

            @Override // defpackage.ff2
            public fi1 contentType() {
                return this.a;
            }

            @Override // defpackage.ff2
            public void writeTo(ro roVar) {
                p31.f(roVar, "sink");
                roVar.Z(this.c, this.d, this.b);
            }
        }

        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public static /* synthetic */ ff2 n(a aVar, fi1 fi1Var, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                i = 0;
            }
            if ((i3 & 8) != 0) {
                i2 = bArr.length;
            }
            return aVar.f(fi1Var, bArr, i, i2);
        }

        public static /* synthetic */ ff2 o(a aVar, String str, fi1 fi1Var, int i, Object obj) {
            if ((i & 1) != 0) {
                fi1Var = null;
            }
            return aVar.h(str, fi1Var);
        }

        public static /* synthetic */ ff2 p(a aVar, byte[] bArr, fi1 fi1Var, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                fi1Var = null;
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return aVar.m(bArr, fi1Var, i, i2);
        }

        public final ff2 a(fi1 fi1Var, File file) {
            p31.f(file, "file");
            return g(file, fi1Var);
        }

        public final ff2 b(fi1 fi1Var, String str) {
            p31.f(str, "content");
            return h(str, fi1Var);
        }

        public final ff2 c(fi1 fi1Var, ByteString byteString) {
            p31.f(byteString, "content");
            return i(byteString, fi1Var);
        }

        public final ff2 d(fi1 fi1Var, byte[] bArr) {
            p31.f(bArr, "content");
            return n(this, fi1Var, bArr, 0, 0, 12, null);
        }

        public final ff2 e(fi1 fi1Var, byte[] bArr, int i) {
            p31.f(bArr, "content");
            return n(this, fi1Var, bArr, i, 0, 8, null);
        }

        public final ff2 f(fi1 fi1Var, byte[] bArr, int i, int i2) {
            p31.f(bArr, "content");
            return m(bArr, fi1Var, i, i2);
        }

        public final ff2 g(File file, fi1 fi1Var) {
            p31.f(file, "<this>");
            return new C0128a(fi1Var, file);
        }

        public final ff2 h(String str, fi1 fi1Var) {
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
            byte[] bytes = str.getBytes(charset);
            p31.e(bytes, "this as java.lang.String).getBytes(charset)");
            return m(bytes, fi1Var, 0, bytes.length);
        }

        public final ff2 i(ByteString byteString, fi1 fi1Var) {
            p31.f(byteString, "<this>");
            return new b(fi1Var, byteString);
        }

        public final ff2 j(byte[] bArr) {
            p31.f(bArr, "<this>");
            return p(this, bArr, null, 0, 0, 7, null);
        }

        public final ff2 k(byte[] bArr, fi1 fi1Var) {
            p31.f(bArr, "<this>");
            return p(this, bArr, fi1Var, 0, 0, 6, null);
        }

        public final ff2 l(byte[] bArr, fi1 fi1Var, int i) {
            p31.f(bArr, "<this>");
            return p(this, bArr, fi1Var, i, 0, 4, null);
        }

        public final ff2 m(byte[] bArr, fi1 fi1Var, int i, int i2) {
            p31.f(bArr, "<this>");
            pa3.l(bArr.length, i, i2);
            return new c(fi1Var, i2, bArr, i);
        }

        private a() {
        }
    }

    public static final ff2 create(fi1 fi1Var, File file) {
        return Companion.a(fi1Var, file);
    }

    public abstract long contentLength();

    public abstract fi1 contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(ro roVar);

    public static final ff2 create(fi1 fi1Var, String str) {
        return Companion.b(fi1Var, str);
    }

    public static final ff2 create(fi1 fi1Var, ByteString byteString) {
        return Companion.c(fi1Var, byteString);
    }

    public static final ff2 create(fi1 fi1Var, byte[] bArr) {
        return Companion.d(fi1Var, bArr);
    }

    public static final ff2 create(fi1 fi1Var, byte[] bArr, int i) {
        return Companion.e(fi1Var, bArr, i);
    }

    public static final ff2 create(fi1 fi1Var, byte[] bArr, int i, int i2) {
        return Companion.f(fi1Var, bArr, i, i2);
    }

    public static final ff2 create(File file, fi1 fi1Var) {
        return Companion.g(file, fi1Var);
    }

    public static final ff2 create(String str, fi1 fi1Var) {
        return Companion.h(str, fi1Var);
    }

    public static final ff2 create(ByteString byteString, fi1 fi1Var) {
        return Companion.i(byteString, fi1Var);
    }

    public static final ff2 create(byte[] bArr) {
        return Companion.j(bArr);
    }

    public static final ff2 create(byte[] bArr, fi1 fi1Var) {
        return Companion.k(bArr, fi1Var);
    }

    public static final ff2 create(byte[] bArr, fi1 fi1Var, int i) {
        return Companion.l(bArr, fi1Var, i);
    }

    public static final ff2 create(byte[] bArr, fi1 fi1Var, int i, int i2) {
        return Companion.m(bArr, fi1Var, i, i2);
    }
}
