package defpackage;

import com.fasterxml.jackson.core.JsonFactory;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.tencent.open.SocialConstants;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class gm1 extends ff2 {
    public static final b f = new b(null);
    public static final fi1 g;
    public static final fi1 h;
    public static final fi1 i;
    public static final fi1 j;
    public static final fi1 k;
    private static final byte[] l;
    private static final byte[] m;
    private static final byte[] n;
    private final ByteString a;
    private final fi1 b;
    private final List c;
    private final fi1 d;
    private long e;

    public static final class a {
        private final ByteString a;
        private fi1 b;
        private final List c;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final a a(String str, String str2) {
            p31.f(str, "name");
            p31.f(str2, "value");
            d(c.c.b(str, str2));
            return this;
        }

        public final a b(String str, String str2, ff2 ff2Var) {
            p31.f(str, "name");
            p31.f(ff2Var, "body");
            d(c.c.c(str, str2, ff2Var));
            return this;
        }

        public final a c(iw0 iw0Var, ff2 ff2Var) {
            p31.f(ff2Var, "body");
            d(c.c.a(iw0Var, ff2Var));
            return this;
        }

        public final a d(c cVar) {
            p31.f(cVar, "part");
            this.c.add(cVar);
            return this;
        }

        public final gm1 e() {
            if (this.c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new gm1(this.a, this.b, pa3.U(this.c));
        }

        public final a f(fi1 fi1Var) {
            p31.f(fi1Var, SocialConstants.PARAM_TYPE);
            if (p31.a(fi1Var.i(), "multipart")) {
                this.b = fi1Var;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + fi1Var).toString());
        }

        public a(String str) {
            p31.f(str, "boundary");
            this.a = ByteString.Companion.d(str);
            this.b = gm1.g;
            this.c = new ArrayList();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ a(String str, int i, y70 y70Var) {
            if ((i & 1) != 0) {
                str = UUID.randomUUID().toString();
                p31.e(str, "randomUUID().toString()");
            }
            this(str);
        }
    }

    public static final class b {
        public /* synthetic */ b(y70 y70Var) {
            this();
        }

        public final void a(StringBuilder sb, String str) {
            p31.f(sb, "<this>");
            p31.f(str, "key");
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt == '\n') {
                    sb.append("%0A");
                } else if (cCharAt == '\r') {
                    sb.append("%0D");
                } else if (cCharAt == '\"') {
                    sb.append("%22");
                } else {
                    sb.append(cCharAt);
                }
            }
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }

        private b() {
        }
    }

    public static final class c {
        public static final a c = new a(null);
        private final iw0 a;
        private final ff2 b;

        public static final class a {
            public /* synthetic */ a(y70 y70Var) {
                this();
            }

            public final c a(iw0 iw0Var, ff2 ff2Var) {
                p31.f(ff2Var, "body");
                y70 y70Var = null;
                if ((iw0Var != null ? iw0Var.a("Content-Type") : null) != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type");
                }
                if ((iw0Var != null ? iw0Var.a("Content-Length") : null) == null) {
                    return new c(iw0Var, ff2Var, y70Var);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }

            public final c b(String str, String str2) {
                p31.f(str, "name");
                p31.f(str2, "value");
                return c(str, null, ff2.a.o(ff2.Companion, str2, null, 1, null));
            }

            public final c c(String str, String str2, ff2 ff2Var) {
                p31.f(str, "name");
                p31.f(ff2Var, "body");
                StringBuilder sb = new StringBuilder();
                sb.append("form-data; name=");
                b bVar = gm1.f;
                bVar.a(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    bVar.a(sb, str2);
                }
                String string = sb.toString();
                p31.e(string, "StringBuilder().apply(builderAction).toString()");
                return a(new iw0.a().d("Content-Disposition", string).e(), ff2Var);
            }

            private a() {
            }
        }

        public /* synthetic */ c(iw0 iw0Var, ff2 ff2Var, y70 y70Var) {
            this(iw0Var, ff2Var);
        }

        public static final c b(String str, String str2, ff2 ff2Var) {
            return c.c(str, str2, ff2Var);
        }

        public final ff2 a() {
            return this.b;
        }

        public final iw0 c() {
            return this.a;
        }

        private c(iw0 iw0Var, ff2 ff2Var) {
            this.a = iw0Var;
            this.b = ff2Var;
        }
    }

    static {
        fi1.a aVar = fi1.e;
        g = aVar.a("multipart/mixed");
        h = aVar.a("multipart/alternative");
        i = aVar.a("multipart/digest");
        j = aVar.a("multipart/parallel");
        k = aVar.a("multipart/form-data");
        l = new byte[]{58, 32};
        m = new byte[]{AttrAndFunCode.SYS_INFO_ATTR_CURRENT_NOISE_MODE, 10};
        n = new byte[]{45, 45};
    }

    public gm1(ByteString byteString, fi1 fi1Var, List list) {
        p31.f(byteString, "boundaryByteString");
        p31.f(fi1Var, SocialConstants.PARAM_TYPE);
        p31.f(list, "parts");
        this.a = byteString;
        this.b = fi1Var;
        this.c = list;
        this.d = fi1.e.a(fi1Var + "; boundary=" + a());
        this.e = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long b(ro roVar, boolean z) throws EOFException {
        fo foVar;
        if (z) {
            roVar = new fo();
            foVar = roVar;
        } else {
            foVar = 0;
        }
        int size = this.c.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = (c) this.c.get(i2);
            iw0 iw0VarC = cVar.c();
            ff2 ff2VarA = cVar.a();
            p31.c(roVar);
            roVar.u0(n);
            roVar.v0(this.a);
            roVar.u0(m);
            if (iw0VarC != null) {
                int size2 = iw0VarC.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    roVar.S(iw0VarC.b(i3)).u0(l).S(iw0VarC.g(i3)).u0(m);
                }
            }
            fi1 fi1VarContentType = ff2VarA.contentType();
            if (fi1VarContentType != null) {
                roVar.S("Content-Type: ").S(fi1VarContentType.toString()).u0(m);
            }
            long jContentLength = ff2VarA.contentLength();
            if (jContentLength != -1) {
                roVar.S("Content-Length: ").C0(jContentLength).u0(m);
            } else if (z) {
                p31.c(foVar);
                foVar.u();
                return -1L;
            }
            byte[] bArr = m;
            roVar.u0(bArr);
            if (z) {
                j2 += jContentLength;
            } else {
                ff2VarA.writeTo(roVar);
            }
            roVar.u0(bArr);
        }
        p31.c(roVar);
        byte[] bArr2 = n;
        roVar.u0(bArr2);
        roVar.v0(this.a);
        roVar.u0(bArr2);
        roVar.u0(m);
        if (!z) {
            return j2;
        }
        p31.c(foVar);
        long size3 = j2 + foVar.size();
        foVar.u();
        return size3;
    }

    public final String a() {
        return this.a.utf8();
    }

    @Override // defpackage.ff2
    public long contentLength() throws EOFException {
        long j2 = this.e;
        if (j2 != -1) {
            return j2;
        }
        long jB = b(null, true);
        this.e = jB;
        return jB;
    }

    @Override // defpackage.ff2
    public fi1 contentType() {
        return this.d;
    }

    @Override // defpackage.ff2
    public void writeTo(ro roVar) throws EOFException {
        p31.f(roVar, "sink");
        b(roVar, false);
    }
}
