package com.tencent.open.a;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.h;
import defpackage.df2;
import defpackage.eh2;
import defpackage.ff2;
import defpackage.fi1;
import defpackage.gm1;
import defpackage.gp0;
import defpackage.l31;
import defpackage.zt1;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static a a;
    private zt1 b;
    private h c;

    /* JADX INFO: renamed from: com.tencent.open.a.a$a, reason: collision with other inner class name */
    private static class C0112a implements l31 {
        private final String a;

        public C0112a(String str) {
            this.a = str;
        }

        @Override // defpackage.l31
        public eh2 intercept(l31.a aVar) throws IOException {
            return aVar.a(aVar.request().h().g("User-Agent", this.a).b());
        }
    }

    protected a() {
        b();
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                try {
                    if (a == null) {
                        a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        a.c();
        return a;
    }

    private void b() {
        C0112a c0112a = new C0112a("AndroidSDK_" + Build.VERSION.SDK + "_" + f.a().a(g.a()) + "_" + Build.VERSION.RELEASE);
        zt1.a aVarG = new zt1.a().g(Arrays.asList(okhttp3.b.i, okhttp3.b.j));
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        zt1.a aVarA = aVarG.d(15000L, timeUnit).Q(30000L, timeUnit).T(30000L, timeUnit).c(null).a(c0112a);
        a(aVarA);
        this.b = aVarA.b();
    }

    private void c() {
        h hVar = this.c;
        if (hVar == null) {
            return;
        }
        int iA = hVar.a("Common_HttpConnectionTimeout");
        if (iA == 0) {
            iA = 15000;
        }
        int iA2 = this.c.a("Common_SocketConnectionTimeout");
        if (iA2 == 0) {
            iA2 = 30000;
        }
        a(iA, iA2);
    }

    public void a(h hVar) {
        this.c = hVar;
        c();
    }

    public void a(long j, long j2) {
        if (this.b.j() == j && this.b.F() == j2) {
            return;
        }
        SLog.i("openSDK_LOG.OpenHttpService", "setTimeout changed.");
        zt1.a aVarY = this.b.y();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.b = aVarY.d(j, timeUnit).Q(j2, timeUnit).T(j2, timeUnit).b();
    }

    public b b(String str, Map<String, String> map) throws IOException {
        SLog.i("openSDK_LOG.OpenHttpService", "post data");
        gp0.a aVar = new gp0.a();
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null) {
                    aVar.a(str2, str3);
                }
            }
        }
        gp0 gp0VarC = aVar.c();
        return new b(this.b.a(new df2.a().m(str).j(gp0VarC).b()).execute(), (int) gp0VarC.contentLength());
    }

    public b a(String str, Map<String, String> map) throws IOException {
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder(Constants.STR_EMPTY);
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null) {
                    sb.append(URLEncoder.encode(str2, Constants.ENC_UTF_8));
                    sb.append("=");
                    sb.append(URLEncoder.encode(str3, Constants.ENC_UTF_8));
                    sb.append("&");
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return a(str, sb.toString());
        }
        return a(str, Constants.STR_EMPTY);
    }

    public b a(String str, String str2) throws IOException {
        SLog.i("openSDK_LOG.OpenHttpService", "get.");
        if (!TextUtils.isEmpty(str2)) {
            int iIndexOf = str2.indexOf("?");
            if (iIndexOf == -1) {
                str = str + "?";
            } else if (iIndexOf != str.length() - 1) {
                str = str + "&";
            }
            str = str + str2;
        }
        return new b(this.b.a(new df2.a().m(str).f().b()).execute(), str2.length());
    }

    public b a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 != null && map2.size() != 0) {
            SLog.i("openSDK_LOG.OpenHttpService", "post data, has byte data");
            gm1.a aVar = new gm1.a();
            if (map != null && map.size() > 0) {
                for (String str2 : map.keySet()) {
                    String str3 = map.get(str2);
                    if (str3 != null) {
                        aVar.a(str2, str3);
                    }
                }
            }
            for (String str4 : map2.keySet()) {
                byte[] bArr = map2.get(str4);
                if (bArr != null && bArr.length > 0) {
                    aVar.b(str4, str4, ff2.create(fi1.e("content/unknown"), bArr));
                    SLog.w("openSDK_LOG.OpenHttpService", "post byte data.");
                }
            }
            gm1 gm1VarE = aVar.e();
            return new b(this.b.a(new df2.a().m(str).j(gm1VarE).b()).execute(), (int) gm1VarE.contentLength());
        }
        return b(str, map);
    }

    private void a(zt1.a aVar) {
    }
}
