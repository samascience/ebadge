package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class xt2 {
    private int a;
    private String b;
    private String c;
    private boolean d;
    private o61 e;
    private String f;

    public static class a {
        private int a;
        private String b;
        private String c;
        private boolean d;
        private boolean e;
        private o61 f;
        private String g;

        a() {
        }

        public xt2 a() {
            boolean zA = this.e;
            if (!this.d) {
                zA = xt2.a();
            }
            return new xt2(this.a, this.b, this.c, zA, this.f, this.g);
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public a c(boolean z) {
            this.e = z;
            this.d = true;
            return this;
        }

        public a d(String str) {
            this.b = str;
            return this;
        }

        public a e(String str) {
            this.g = str;
            return this;
        }

        public a f(int i) {
            this.a = i;
            return this;
        }

        public String toString() {
            return "Status.StatusBuilder(statusCode=" + this.a + ", message=" + this.b + ", code=" + this.c + ", isJson$value=" + this.e + ", usage=" + this.f + ", requestId=" + this.g + ")";
        }
    }

    xt2(int i, String str, String str2, boolean z, o61 o61Var, String str3) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = z;
        this.e = o61Var;
        this.f = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a() {
        return false;
    }

    public static a c() {
        return new a();
    }

    protected boolean d(Object obj) {
        return obj instanceof xt2;
    }

    public String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof xt2)) {
            return false;
        }
        xt2 xt2Var = (xt2) obj;
        if (!xt2Var.d(this) || h() != xt2Var.h() || j() != xt2Var.j()) {
            return false;
        }
        String strF = f();
        String strF2 = xt2Var.f();
        if (strF != null ? !strF.equals(strF2) : strF2 != null) {
            return false;
        }
        String strE = e();
        String strE2 = xt2Var.e();
        if (strE != null ? !strE.equals(strE2) : strE2 != null) {
            return false;
        }
        o61 o61VarI = i();
        o61 o61VarI2 = xt2Var.i();
        if (o61VarI != null ? !o61VarI.equals(o61VarI2) : o61VarI2 != null) {
            return false;
        }
        String strG = g();
        String strG2 = xt2Var.g();
        return strG != null ? strG.equals(strG2) : strG2 == null;
    }

    public String f() {
        return this.b;
    }

    public String g() {
        return this.f;
    }

    public int h() {
        return this.a;
    }

    public int hashCode() {
        int iH = ((h() + 59) * 59) + (j() ? 79 : 97);
        String strF = f();
        int iHashCode = (iH * 59) + (strF == null ? 43 : strF.hashCode());
        String strE = e();
        int iHashCode2 = (iHashCode * 59) + (strE == null ? 43 : strE.hashCode());
        o61 o61VarI = i();
        int iHashCode3 = (iHashCode2 * 59) + (o61VarI == null ? 43 : o61VarI.hashCode());
        String strG = g();
        return (iHashCode3 * 59) + (strG != null ? strG.hashCode() : 43);
    }

    public o61 i() {
        return this.e;
    }

    public boolean j() {
        return this.d;
    }

    public String toString() {
        return "Status(statusCode=" + h() + ", message=" + f() + ", code=" + e() + ", isJson=" + j() + ", usage=" + i() + ", requestId=" + g() + ")";
    }
}
