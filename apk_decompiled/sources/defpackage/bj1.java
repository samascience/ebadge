package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class bj1 extends zi1 {
    private String a;

    @xm2("image_url")
    private b11 imageURL;

    public static abstract class b extends zi1.a {
        private boolean a;
        private String b;
        private b11 c;

        public abstract bj1 d();

        public b e(b11 b11Var) {
            this.c = b11Var;
            return f();
        }

        protected abstract b f();

        public b g(String str) {
            this.b = str;
            this.a = true;
            return f();
        }

        @Override // zi1.a
        public String toString() {
            return "MessageContentImageURL.MessageContentImageURLBuilder(super=" + super.toString() + ", type$value=" + this.b + ", imageURL=" + this.c + ")";
        }
    }

    private static final class c extends b {
        private c() {
        }

        @Override // bj1.b
        public bj1 d() {
            return new bj1(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // bj1.b
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public c f() {
            return this;
        }
    }

    protected bj1(b bVar) {
        super(bVar);
        this.a = bVar.a ? bVar.b : c();
        this.imageURL = bVar.c;
    }

    private static String c() {
        return "image_url";
    }

    public static b d() {
        return new c();
    }

    @Override // defpackage.zi1
    protected boolean a(Object obj) {
        return obj instanceof bj1;
    }

    @Override // defpackage.zi1
    public String b() {
        return this.a;
    }

    public b11 e() {
        return this.imageURL;
    }

    @Override // defpackage.zi1
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bj1)) {
            return false;
        }
        bj1 bj1Var = (bj1) obj;
        if (!bj1Var.a(this) || !super.equals(obj)) {
            return false;
        }
        String strB = b();
        String strB2 = bj1Var.b();
        if (strB != null ? !strB.equals(strB2) : strB2 != null) {
            return false;
        }
        b11 b11VarE = e();
        b11 b11VarE2 = bj1Var.e();
        return b11VarE != null ? b11VarE.equals(b11VarE2) : b11VarE2 == null;
    }

    @Override // defpackage.zi1
    public int hashCode() {
        int iHashCode = super.hashCode();
        String strB = b();
        int iHashCode2 = (iHashCode * 59) + (strB == null ? 43 : strB.hashCode());
        b11 b11VarE = e();
        return (iHashCode2 * 59) + (b11VarE != null ? b11VarE.hashCode() : 43);
    }

    public String toString() {
        return "MessageContentImageURL(type=" + b() + ", imageURL=" + e() + ")";
    }
}
