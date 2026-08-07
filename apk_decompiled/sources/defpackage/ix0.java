package defpackage;

import com.jieli.otasdk.util.OtaConstant;
import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.b;

/* JADX INFO: loaded from: classes4.dex */
public final class ix0 implements ri0 {
    public static final a g = new a(null);
    private static final List h = pa3.w("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", OtaConstant.DIR_UPGRADE, ":method", ":path", ":scheme", ":authority");
    private static final List i = pa3.w("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", OtaConstant.DIR_UPGRADE);
    private final RealConnection a;
    private final jd2 b;
    private final b c;
    private volatile jx0 d;
    private final Protocol e;
    private volatile boolean f;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final List a(df2 df2Var) {
            p31.f(df2Var, SocialConstants.TYPE_REQUEST);
            iw0 iw0VarE = df2Var.e();
            ArrayList arrayList = new ArrayList(iw0VarE.size() + 4);
            arrayList.add(new gw0(gw0.g, df2Var.g()));
            arrayList.add(new gw0(gw0.h, hf2.a.c(df2Var.i())));
            String strD = df2Var.d("Host");
            if (strD != null) {
                arrayList.add(new gw0(gw0.j, strD));
            }
            arrayList.add(new gw0(gw0.i, df2Var.i().r()));
            int size = iw0VarE.size();
            for (int i = 0; i < size; i++) {
                String strB = iw0VarE.b(i);
                Locale locale = Locale.US;
                p31.e(locale, "US");
                String lowerCase = strB.toLowerCase(locale);
                p31.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (!ix0.h.contains(lowerCase) || (p31.a(lowerCase, "te") && p31.a(iw0VarE.g(i), "trailers"))) {
                    arrayList.add(new gw0(lowerCase, iw0VarE.g(i)));
                }
            }
            return arrayList;
        }

        public final eh2.a b(iw0 iw0Var, Protocol protocol) throws ProtocolException {
            p31.f(iw0Var, "headerBlock");
            p31.f(protocol, "protocol");
            iw0.a aVar = new iw0.a();
            int size = iw0Var.size();
            zt2 zt2VarA = null;
            for (int i = 0; i < size; i++) {
                String strB = iw0Var.b(i);
                String strG = iw0Var.g(i);
                if (p31.a(strB, ":status")) {
                    zt2VarA = zt2.d.a("HTTP/1.1 " + strG);
                } else if (!ix0.i.contains(strB)) {
                    aVar.c(strB, strG);
                }
            }
            if (zt2VarA != null) {
                return new eh2.a().p(protocol).g(zt2VarA.b).m(zt2VarA.c).k(aVar.e());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }

        private a() {
        }
    }

    public ix0(zt1 zt1Var, RealConnection realConnection, jd2 jd2Var, b bVar) {
        p31.f(zt1Var, "client");
        p31.f(realConnection, "connection");
        p31.f(jd2Var, "chain");
        p31.f(bVar, "http2Connection");
        this.a = realConnection;
        this.b = jd2Var;
        this.c = bVar;
        List listB = zt1Var.B();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.e = listB.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    @Override // defpackage.ri0
    public ks2 a(eh2 eh2Var) {
        p31.f(eh2Var, "response");
        jx0 jx0Var = this.d;
        p31.c(jx0Var);
        return jx0Var.p();
    }

    @Override // defpackage.ri0
    public void b(df2 df2Var) throws IOException {
        p31.f(df2Var, SocialConstants.TYPE_REQUEST);
        if (this.d != null) {
            return;
        }
        this.d = this.c.V0(g.a(df2Var), df2Var.a() != null);
        if (this.f) {
            jx0 jx0Var = this.d;
            p31.c(jx0Var);
            jx0Var.f(ErrorCode.CANCEL);
            throw new IOException("Canceled");
        }
        jx0 jx0Var2 = this.d;
        p31.c(jx0Var2);
        h33 h33VarV = jx0Var2.v();
        long jH = this.b.h();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        h33VarV.g(jH, timeUnit);
        jx0 jx0Var3 = this.d;
        p31.c(jx0Var3);
        jx0Var3.E().g(this.b.j(), timeUnit);
    }

    @Override // defpackage.ri0
    public void c() {
        jx0 jx0Var = this.d;
        p31.c(jx0Var);
        jx0Var.n().close();
    }

    @Override // defpackage.ri0
    public void cancel() {
        this.f = true;
        jx0 jx0Var = this.d;
        if (jx0Var != null) {
            jx0Var.f(ErrorCode.CANCEL);
        }
    }

    @Override // defpackage.ri0
    public long d(eh2 eh2Var) {
        p31.f(eh2Var, "response");
        if (mx0.b(eh2Var)) {
            return pa3.v(eh2Var);
        }
        return 0L;
    }

    @Override // defpackage.ri0
    public er2 e(df2 df2Var, long j) {
        p31.f(df2Var, SocialConstants.TYPE_REQUEST);
        jx0 jx0Var = this.d;
        p31.c(jx0Var);
        return jx0Var.n();
    }

    @Override // defpackage.ri0
    public eh2.a f(boolean z) throws IOException {
        jx0 jx0Var = this.d;
        if (jx0Var == null) {
            throw new IOException("stream wasn't created");
        }
        eh2.a aVarB = g.b(jx0Var.C(), this.e);
        if (z && aVarB.h() == 100) {
            return null;
        }
        return aVarB;
    }

    @Override // defpackage.ri0
    public RealConnection g() {
        return this.a;
    }

    @Override // defpackage.ri0
    public void h() {
        this.c.flush();
    }
}
