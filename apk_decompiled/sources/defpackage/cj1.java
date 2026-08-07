package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class cj1 extends zi1 {
    private String a;
    private String b;

    @xm2("cache_control")
    private b cacheControl;

    public static class b {
        private String a;
        private String b;

        public static abstract class a {
            private String a;
            private String b;

            public abstract b c();

            protected abstract a d();

            public a e(String str) {
                this.b = str;
                return d();
            }

            public a f(String str) {
                this.a = str;
                return d();
            }

            public String toString() {
                return "MessageContentText.CacheControl.CacheControlBuilder(type=" + this.a + ", ttl=" + this.b + ")";
            }
        }

        /* JADX INFO: renamed from: cj1$b$b, reason: collision with other inner class name */
        private static final class C0047b extends a {
            private C0047b() {
            }

            @Override // cj1.b.a
            public b c() {
                return new b(this);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // cj1.b.a
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public C0047b d() {
                return this;
            }
        }

        protected b(a aVar) {
            this.a = aVar.a;
            this.b = aVar.b;
        }

        public static a a() {
            return new C0047b();
        }

        protected boolean b(Object obj) {
            return obj instanceof b;
        }

        public String c() {
            return this.b;
        }

        public String d() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!bVar.b(this)) {
                return false;
            }
            String strD = d();
            String strD2 = bVar.d();
            if (strD != null ? !strD.equals(strD2) : strD2 != null) {
                return false;
            }
            String strC = c();
            String strC2 = bVar.c();
            return strC != null ? strC.equals(strC2) : strC2 == null;
        }

        public int hashCode() {
            String strD = d();
            int iHashCode = strD == null ? 43 : strD.hashCode();
            String strC = c();
            return ((iHashCode + 59) * 59) + (strC != null ? strC.hashCode() : 43);
        }

        public String toString() {
            return "MessageContentText.CacheControl(type=" + d() + ", ttl=" + c() + ")";
        }
    }

    public static abstract class c extends zi1.a {
        private boolean a;
        private String b;
        private String c;
        private b d;

        public abstract cj1 e();

        public c f(b bVar) {
            this.d = bVar;
            return g();
        }

        protected abstract c g();

        public c h(String str) {
            this.c = str;
            return g();
        }

        public c i(String str) {
            this.b = str;
            this.a = true;
            return g();
        }

        @Override // zi1.a
        public String toString() {
            return "MessageContentText.MessageContentTextBuilder(super=" + super.toString() + ", type$value=" + this.b + ", text=" + this.c + ", cacheControl=" + this.d + ")";
        }
    }

    private static final class d extends c {
        private d() {
        }

        @Override // cj1.c
        public cj1 e() {
            return new cj1(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // cj1.c
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public d g() {
            return this;
        }
    }

    protected cj1(c cVar) {
        super(cVar);
        this.a = cVar.a ? cVar.b : c();
        this.b = cVar.c;
        this.cacheControl = cVar.d;
    }

    private static String c() {
        return "text";
    }

    public static c d() {
        return new d();
    }

    @Override // defpackage.zi1
    protected boolean a(Object obj) {
        return obj instanceof cj1;
    }

    @Override // defpackage.zi1
    public String b() {
        return this.a;
    }

    public b e() {
        return this.cacheControl;
    }

    @Override // defpackage.zi1
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cj1)) {
            return false;
        }
        cj1 cj1Var = (cj1) obj;
        if (!cj1Var.a(this) || !super.equals(obj)) {
            return false;
        }
        String strB = b();
        String strB2 = cj1Var.b();
        if (strB != null ? !strB.equals(strB2) : strB2 != null) {
            return false;
        }
        String strF = f();
        String strF2 = cj1Var.f();
        if (strF != null ? !strF.equals(strF2) : strF2 != null) {
            return false;
        }
        b bVarE = e();
        b bVarE2 = cj1Var.e();
        return bVarE != null ? bVarE.equals(bVarE2) : bVarE2 == null;
    }

    public String f() {
        return this.b;
    }

    @Override // defpackage.zi1
    public int hashCode() {
        int iHashCode = super.hashCode();
        String strB = b();
        int iHashCode2 = (iHashCode * 59) + (strB == null ? 43 : strB.hashCode());
        String strF = f();
        int iHashCode3 = (iHashCode2 * 59) + (strF == null ? 43 : strF.hashCode());
        b bVarE = e();
        return (iHashCode3 * 59) + (bVarE != null ? bVarE.hashCode() : 43);
    }

    public String toString() {
        return "MessageContentText(type=" + b() + ", text=" + f() + ", cacheControl=" + e() + ")";
    }
}
