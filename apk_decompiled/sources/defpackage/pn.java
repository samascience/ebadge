package defpackage;

import java.util.List;
import kotlin.collections.j;
import kotlin.text.i;

/* JADX INFO: loaded from: classes4.dex */
public final class pn implements l31 {
    private final i40 a;

    public pn(i40 i40Var) {
        p31.f(i40Var, "cookieJar");
        this.a = i40Var;
    }

    private final String a(List list) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                j.s();
            }
            h40 h40Var = (h40) obj;
            if (i > 0) {
                sb.append("; ");
            }
            sb.append(h40Var.e());
            sb.append('=');
            sb.append(h40Var.g());
            i = i2;
        }
        String string = sb.toString();
        p31.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // defpackage.l31
    public eh2 intercept(l31.a aVar) {
        fh2 fh2VarN;
        p31.f(aVar, "chain");
        df2 df2VarRequest = aVar.request();
        df2.a aVarH = df2VarRequest.h();
        ff2 ff2VarA = df2VarRequest.a();
        if (ff2VarA != null) {
            fi1 fi1VarContentType = ff2VarA.contentType();
            if (fi1VarContentType != null) {
                aVarH.g("Content-Type", fi1VarContentType.toString());
            }
            long jContentLength = ff2VarA.contentLength();
            if (jContentLength != -1) {
                aVarH.g("Content-Length", String.valueOf(jContentLength));
                aVarH.k("Transfer-Encoding");
            } else {
                aVarH.g("Transfer-Encoding", "chunked");
                aVarH.k("Content-Length");
            }
        }
        boolean z = false;
        if (df2VarRequest.d("Host") == null) {
            aVarH.g("Host", pa3.T(df2VarRequest.i(), false, 1, null));
        }
        if (df2VarRequest.d("Connection") == null) {
            aVarH.g("Connection", "Keep-Alive");
        }
        if (df2VarRequest.d("Accept-Encoding") == null && df2VarRequest.d("Range") == null) {
            aVarH.g("Accept-Encoding", "gzip");
            z = true;
        }
        List listB = this.a.b(df2VarRequest.i());
        if (!listB.isEmpty()) {
            aVarH.g("Cookie", a(listB));
        }
        if (df2VarRequest.d("User-Agent") == null) {
            aVarH.g("User-Agent", "okhttp/4.12.0");
        }
        eh2 eh2VarA = aVar.a(aVarH.b());
        mx0.f(this.a, df2VarRequest.i(), eh2VarA.j0());
        eh2.a aVarR = eh2VarA.w0().r(df2VarRequest);
        if (z && i.v("gzip", eh2.g0(eh2VarA, "Content-Encoding", null, 2, null), true) && mx0.b(eh2VarA) && (fh2VarN = eh2VarA.n()) != null) {
            uv0 uv0Var = new uv0(fh2VarN.source());
            aVarR.k(eh2VarA.j0().c().g("Content-Encoding").g("Content-Length").e());
            aVarR.b(new kd2(eh2.g0(eh2VarA, "Content-Type", null, 2, null), -1L, hu1.b(uv0Var)));
        }
        return aVarR.c();
    }
}
