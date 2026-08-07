package okhttp3.logging;

import com.tencent.connect.common.Constants;
import defpackage.df2;
import defpackage.eh2;
import defpackage.ff2;
import defpackage.fh2;
import defpackage.fi1;
import defpackage.fo;
import defpackage.iw0;
import defpackage.ka3;
import defpackage.l31;
import defpackage.mx0;
import defpackage.p10;
import defpackage.p31;
import defpackage.r32;
import defpackage.so;
import defpackage.ty;
import defpackage.uv0;
import defpackage.y70;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.collections.b0;
import kotlin.text.i;

/* JADX INFO: loaded from: classes4.dex */
public final class HttpLoggingInterceptor implements l31 {
    private final a a;
    private volatile Set b;
    private volatile Level c;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface a {
        public static final C0160a a = C0160a.a;
        public static final a b = new C0160a.C0161a();

        /* JADX INFO: renamed from: okhttp3.logging.HttpLoggingInterceptor$a$a, reason: collision with other inner class name */
        public static final class C0160a {
            static final /* synthetic */ C0160a a = new C0160a();

            /* JADX INFO: renamed from: okhttp3.logging.HttpLoggingInterceptor$a$a$a, reason: collision with other inner class name */
            private static final class C0161a implements a {
                @Override // okhttp3.logging.HttpLoggingInterceptor.a
                public void a(String str) {
                    p31.f(str, "message");
                    r32.k(r32.a.g(), str, 0, null, 6, null);
                }
            }

            private C0160a() {
            }
        }

        void a(String str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpLoggingInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final boolean a(iw0 iw0Var) {
        String strA = iw0Var.a("Content-Encoding");
        return (strA == null || i.v(strA, "identity", true) || i.v(strA, "gzip", true)) ? false : true;
    }

    private final void b(iw0 iw0Var, int i) {
        String strG = this.b.contains(iw0Var.b(i)) ? "██" : iw0Var.g(i);
        this.a.a(iw0Var.b(i) + ": " + strG);
    }

    public final HttpLoggingInterceptor c(Level level) {
        p31.f(level, "level");
        this.c = level;
        return this;
    }

    @Override // defpackage.l31
    public eh2 intercept(l31.a aVar) throws Exception {
        String string;
        char c;
        String string2;
        Charset charsetC;
        Charset charsetC2;
        p31.f(aVar, "chain");
        Level level = this.c;
        df2 df2VarRequest = aVar.request();
        if (level == Level.NONE) {
            return aVar.a(df2VarRequest);
        }
        boolean z = level == Level.BODY;
        boolean z2 = z || level == Level.HEADERS;
        ff2 ff2VarA = df2VarRequest.a();
        p10 p10VarB = aVar.b();
        StringBuilder sb = new StringBuilder();
        sb.append("--> ");
        sb.append(df2VarRequest.g());
        sb.append(' ');
        sb.append(df2VarRequest.i());
        if (p10VarB != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(' ');
            sb2.append(p10VarB.a());
            string = sb2.toString();
        } else {
            string = Constants.STR_EMPTY;
        }
        sb.append(string);
        String string3 = sb.toString();
        if (!z2 && ff2VarA != null) {
            string3 = string3 + " (" + ff2VarA.contentLength() + "-byte body)";
        }
        this.a.a(string3);
        if (z2) {
            iw0 iw0VarE = df2VarRequest.e();
            if (ff2VarA != null) {
                fi1 fi1VarContentType = ff2VarA.contentType();
                if (fi1VarContentType != null && iw0VarE.a("Content-Type") == null) {
                    this.a.a("Content-Type: " + fi1VarContentType);
                }
                if (ff2VarA.contentLength() != -1 && iw0VarE.a("Content-Length") == null) {
                    this.a.a("Content-Length: " + ff2VarA.contentLength());
                }
            }
            int size = iw0VarE.size();
            for (int i = 0; i < size; i++) {
                b(iw0VarE, i);
            }
            if (!z || ff2VarA == null) {
                this.a.a("--> END " + df2VarRequest.g());
            } else if (a(df2VarRequest.e())) {
                this.a.a("--> END " + df2VarRequest.g() + " (encoded body omitted)");
            } else if (ff2VarA.isDuplex()) {
                this.a.a("--> END " + df2VarRequest.g() + " (duplex request body omitted)");
            } else if (ff2VarA.isOneShot()) {
                this.a.a("--> END " + df2VarRequest.g() + " (one-shot body omitted)");
            } else {
                fo foVar = new fo();
                ff2VarA.writeTo(foVar);
                fi1 fi1VarContentType2 = ff2VarA.contentType();
                if (fi1VarContentType2 == null || (charsetC2 = fi1VarContentType2.c(StandardCharsets.UTF_8)) == null) {
                    charsetC2 = StandardCharsets.UTF_8;
                    p31.e(charsetC2, "UTF_8");
                }
                this.a.a(Constants.STR_EMPTY);
                if (ka3.a(foVar)) {
                    this.a.a(foVar.Y(charsetC2));
                    this.a.a("--> END " + df2VarRequest.g() + " (" + ff2VarA.contentLength() + "-byte body)");
                } else {
                    this.a.a("--> END " + df2VarRequest.g() + " (binary " + ff2VarA.contentLength() + "-byte body omitted)");
                }
            }
        }
        long jNanoTime = System.nanoTime();
        try {
            eh2 eh2VarA = aVar.a(df2VarRequest);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            fh2 fh2VarN = eh2VarA.n();
            p31.c(fh2VarN);
            long jContentLength = fh2VarN.contentLength();
            String str = jContentLength != -1 ? jContentLength + "-byte" : "unknown-length";
            a aVar2 = this.a;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("<-- ");
            sb3.append(eh2VarA.C());
            if (eh2VarA.m0().length() == 0) {
                string2 = Constants.STR_EMPTY;
                c = ' ';
            } else {
                String strM0 = eh2VarA.m0();
                StringBuilder sb4 = new StringBuilder();
                c = ' ';
                sb4.append(' ');
                sb4.append(strM0);
                string2 = sb4.toString();
            }
            sb3.append(string2);
            sb3.append(c);
            sb3.append(eh2VarA.G0().i());
            sb3.append(" (");
            sb3.append(millis);
            sb3.append("ms");
            sb3.append(z2 ? Constants.STR_EMPTY : ", " + str + " body");
            sb3.append(')');
            aVar2.a(sb3.toString());
            if (z2) {
                iw0 iw0VarJ0 = eh2VarA.j0();
                int size2 = iw0VarJ0.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    b(iw0VarJ0, i2);
                }
                if (!z || !mx0.b(eh2VarA)) {
                    this.a.a("<-- END HTTP");
                } else if (a(eh2VarA.j0())) {
                    this.a.a("<-- END HTTP (encoded body omitted)");
                } else {
                    so soVarSource = fh2VarN.source();
                    soVarSource.request(Long.MAX_VALUE);
                    fo foVarB = soVarSource.b();
                    Long l = null;
                    if (i.v("gzip", iw0VarJ0.a("Content-Encoding"), true)) {
                        Long lValueOf = Long.valueOf(foVarB.size());
                        uv0 uv0Var = new uv0(foVarB.clone());
                        try {
                            foVarB = new fo();
                            foVarB.L(uv0Var);
                            ty.a(uv0Var, null);
                            l = lValueOf;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                ty.a(uv0Var, th);
                                throw th2;
                            }
                        }
                    }
                    fi1 fi1VarContentType3 = fh2VarN.contentType();
                    if (fi1VarContentType3 == null || (charsetC = fi1VarContentType3.c(StandardCharsets.UTF_8)) == null) {
                        charsetC = StandardCharsets.UTF_8;
                        p31.e(charsetC, "UTF_8");
                    }
                    if (!ka3.a(foVarB)) {
                        this.a.a(Constants.STR_EMPTY);
                        this.a.a("<-- END HTTP (binary " + foVarB.size() + "-byte body omitted)");
                        return eh2VarA;
                    }
                    if (jContentLength != 0) {
                        this.a.a(Constants.STR_EMPTY);
                        this.a.a(foVarB.clone().Y(charsetC));
                    }
                    if (l != null) {
                        this.a.a("<-- END HTTP (" + foVarB.size() + "-byte, " + l + "-gzipped-byte body)");
                    } else {
                        this.a.a("<-- END HTTP (" + foVarB.size() + "-byte body)");
                    }
                }
            }
            return eh2VarA;
        } catch (Exception e) {
            this.a.a("<-- HTTP FAILED: " + e);
            throw e;
        }
    }

    public HttpLoggingInterceptor(a aVar) {
        p31.f(aVar, "logger");
        this.a = aVar;
        this.b = b0.d();
        this.c = Level.NONE;
    }

    public /* synthetic */ HttpLoggingInterceptor(a aVar, int i, y70 y70Var) {
        this((i & 1) != 0 ? a.b : aVar);
    }
}
