package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class b11 {
    private String a;
    private String b;

    public static abstract class b {
        private String a;
        private String b;

        public abstract b11 c();

        public b d(String str) {
            this.b = str;
            return e();
        }

        protected abstract b e();

        public b f(String str) {
            this.a = str;
            return e();
        }

        public String toString() {
            return "ImageURL.ImageURLBuilder(url=" + this.a + ", detail=" + this.b + ")";
        }
    }

    private static final class c extends b {
        private c() {
        }

        @Override // b11.b
        public b11 c() {
            return new b11(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // b11.b
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public c e() {
            return this;
        }
    }

    protected b11(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
    }

    public static b a() {
        return new c();
    }

    protected boolean b(Object obj) {
        return obj instanceof b11;
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
        if (!(obj instanceof b11)) {
            return false;
        }
        b11 b11Var = (b11) obj;
        if (!b11Var.b(this)) {
            return false;
        }
        String strD = d();
        String strD2 = b11Var.d();
        if (strD != null ? !strD.equals(strD2) : strD2 != null) {
            return false;
        }
        String strC = c();
        String strC2 = b11Var.c();
        return strC != null ? strC.equals(strC2) : strC2 == null;
    }

    public int hashCode() {
        String strD = d();
        int iHashCode = strD == null ? 43 : strD.hashCode();
        String strC = c();
        return ((iHashCode + 59) * 59) + (strC != null ? strC.hashCode() : 43);
    }

    public String toString() {
        return "ImageURL(url=" + d() + ", detail=" + c() + ")";
    }
}
