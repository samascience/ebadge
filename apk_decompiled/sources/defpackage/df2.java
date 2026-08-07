package defpackage;

import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.j;
import kotlin.collections.u;
import kotlin.text.i;

/* JADX INFO: loaded from: classes4.dex */
public final class df2 {
    private final tx0 a;
    private final String b;
    private final iw0 c;
    private final ff2 d;
    private final Map e;
    private tp f;

    public df2(tx0 tx0Var, String str, iw0 iw0Var, ff2 ff2Var, Map map) {
        p31.f(tx0Var, SocialConstants.PARAM_URL);
        p31.f(str, "method");
        p31.f(iw0Var, "headers");
        p31.f(map, "tags");
        this.a = tx0Var;
        this.b = str;
        this.c = iw0Var;
        this.d = ff2Var;
        this.e = map;
    }

    public final ff2 a() {
        return this.d;
    }

    public final tp b() {
        tp tpVar = this.f;
        if (tpVar != null) {
            return tpVar;
        }
        tp tpVarB = tp.n.b(this.c);
        this.f = tpVarB;
        return tpVarB;
    }

    public final Map c() {
        return this.e;
    }

    public final String d(String str) {
        p31.f(str, "name");
        return this.c.a(str);
    }

    public final iw0 e() {
        return this.c;
    }

    public final boolean f() {
        return this.a.i();
    }

    public final String g() {
        return this.b;
    }

    public final a h() {
        return new a(this);
    }

    public final tx0 i() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.b);
        sb.append(", url=");
        sb.append(this.a);
        if (this.c.size() != 0) {
            sb.append(", headers=[");
            int i = 0;
            for (Object obj : this.c) {
                int i2 = i + 1;
                if (i < 0) {
                    j.s();
                }
                Pair pair = (Pair) obj;
                String str = (String) pair.component1();
                String str2 = (String) pair.component2();
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append(':');
                sb.append(str2);
                i = i2;
            }
            sb.append(']');
        }
        if (!this.e.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.e);
        }
        sb.append('}');
        String string = sb.toString();
        p31.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static class a {
        private tx0 a;
        private String b;
        private iw0.a c;
        private ff2 d;
        private Map e;

        public a() {
            this.e = new LinkedHashMap();
            this.b = Constants.HTTP_GET;
            this.c = new iw0.a();
        }

        public static /* synthetic */ a e(a aVar, ff2 ff2Var, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
            }
            if ((i & 1) != 0) {
                ff2Var = pa3.d;
            }
            return aVar.d(ff2Var);
        }

        public a a(String str, String str2) {
            p31.f(str, "name");
            p31.f(str2, "value");
            this.c.a(str, str2);
            return this;
        }

        public df2 b() {
            tx0 tx0Var = this.a;
            if (tx0Var != null) {
                return new df2(tx0Var, this.b, this.c.e(), this.d, pa3.V(this.e));
            }
            throw new IllegalStateException("url == null");
        }

        public final a c() {
            return e(this, null, 1, null);
        }

        public a d(ff2 ff2Var) {
            return i("DELETE", ff2Var);
        }

        public a f() {
            return i(Constants.HTTP_GET, null);
        }

        public a g(String str, String str2) {
            p31.f(str, "name");
            p31.f(str2, "value");
            this.c.h(str, str2);
            return this;
        }

        public a h(iw0 iw0Var) {
            p31.f(iw0Var, "headers");
            this.c = iw0Var.c();
            return this;
        }

        public a i(String str, ff2 ff2Var) {
            p31.f(str, "method");
            if (str.length() <= 0) {
                throw new IllegalArgumentException("method.isEmpty() == true");
            }
            if (ff2Var == null) {
                if (rx0.d(str)) {
                    throw new IllegalArgumentException(("method " + str + " must have a request body.").toString());
                }
            } else if (!rx0.a(str)) {
                throw new IllegalArgumentException(("method " + str + " must not have a request body.").toString());
            }
            this.b = str;
            this.d = ff2Var;
            return this;
        }

        public a j(ff2 ff2Var) {
            p31.f(ff2Var, "body");
            return i(Constants.HTTP_POST, ff2Var);
        }

        public a k(String str) {
            p31.f(str, "name");
            this.c.g(str);
            return this;
        }

        public a l(tx0 tx0Var) {
            p31.f(tx0Var, SocialConstants.PARAM_URL);
            this.a = tx0Var;
            return this;
        }

        public a m(String str) {
            p31.f(str, SocialConstants.PARAM_URL);
            if (i.E(str, "ws:", true)) {
                StringBuilder sb = new StringBuilder();
                sb.append("http:");
                String strSubstring = str.substring(3);
                p31.e(strSubstring, "this as java.lang.String).substring(startIndex)");
                sb.append(strSubstring);
                str = sb.toString();
            } else if (i.E(str, "wss:", true)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("https:");
                String strSubstring2 = str.substring(4);
                p31.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
                sb2.append(strSubstring2);
                str = sb2.toString();
            }
            return l(tx0.k.d(str));
        }

        public a(df2 df2Var) {
            Map mapP;
            p31.f(df2Var, SocialConstants.TYPE_REQUEST);
            this.e = new LinkedHashMap();
            this.a = df2Var.i();
            this.b = df2Var.g();
            this.d = df2Var.a();
            if (df2Var.c().isEmpty()) {
                mapP = new LinkedHashMap();
            } else {
                mapP = u.p(df2Var.c());
            }
            this.e = mapP;
            this.c = df2Var.e().c();
        }
    }
}
