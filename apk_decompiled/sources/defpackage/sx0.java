package defpackage;

import com.alibaba.dashscope.protocol.HttpMethod;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class sx0 {
    private HttpMethod a;
    private String b;
    private Map c;
    private Map d;
    private Object e;

    public static abstract class b {
        private HttpMethod a;
        private String b;
        private Map c;
        private Map d;
        private Object e;

        public b f(Object obj) {
            this.e = obj;
            return k();
        }

        public abstract sx0 g();

        public b h(Map map) {
            this.c = map;
            return k();
        }

        public b i(HttpMethod httpMethod) {
            this.a = httpMethod;
            return k();
        }

        public b j(Map map) {
            this.d = map;
            return k();
        }

        protected abstract b k();

        public b l(String str) {
            this.b = str;
            return k();
        }

        public String toString() {
            return "HttpRequest.HttpRequestBuilder(httpMethod=" + this.a + ", url=" + this.b + ", headers=" + this.c + ", parameters=" + this.d + ", body=" + this.e + ")";
        }
    }

    private static final class c extends b {
        private c() {
        }

        @Override // sx0.b
        public sx0 g() {
            return new sx0(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // sx0.b
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public c k() {
            return this;
        }
    }

    protected sx0(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
    }

    public static b a() {
        return new c();
    }

    protected boolean b(Object obj) {
        return obj instanceof sx0;
    }

    public Object c() {
        return this.e;
    }

    public Map d() {
        return this.c;
    }

    public HttpMethod e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof sx0)) {
            return false;
        }
        sx0 sx0Var = (sx0) obj;
        if (!sx0Var.b(this)) {
            return false;
        }
        HttpMethod httpMethodE = e();
        HttpMethod httpMethodE2 = sx0Var.e();
        if (httpMethodE != null ? !httpMethodE.equals(httpMethodE2) : httpMethodE2 != null) {
            return false;
        }
        String strG = g();
        String strG2 = sx0Var.g();
        if (strG != null ? !strG.equals(strG2) : strG2 != null) {
            return false;
        }
        Map mapD = d();
        Map mapD2 = sx0Var.d();
        if (mapD != null ? !mapD.equals(mapD2) : mapD2 != null) {
            return false;
        }
        Map mapF = f();
        Map mapF2 = sx0Var.f();
        if (mapF != null ? !mapF.equals(mapF2) : mapF2 != null) {
            return false;
        }
        Object objC = c();
        Object objC2 = sx0Var.c();
        return objC != null ? objC.equals(objC2) : objC2 == null;
    }

    public Map f() {
        return this.d;
    }

    public String g() {
        return this.b;
    }

    public int hashCode() {
        HttpMethod httpMethodE = e();
        int iHashCode = httpMethodE == null ? 43 : httpMethodE.hashCode();
        String strG = g();
        int iHashCode2 = ((iHashCode + 59) * 59) + (strG == null ? 43 : strG.hashCode());
        Map mapD = d();
        int iHashCode3 = (iHashCode2 * 59) + (mapD == null ? 43 : mapD.hashCode());
        Map mapF = f();
        int iHashCode4 = (iHashCode3 * 59) + (mapF == null ? 43 : mapF.hashCode());
        Object objC = c();
        return (iHashCode4 * 59) + (objC != null ? objC.hashCode() : 43);
    }

    public String toString() {
        return "HttpRequest(httpMethod=" + e() + ", url=" + g() + ", headers=" + d() + ", parameters=" + f() + ", body=" + c() + ")";
    }
}
