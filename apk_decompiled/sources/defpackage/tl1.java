package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class tl1 {
    private static final hd1 d = ld1.k(tl1.class);
    private String a;
    private String b;
    private String c;

    @xm2("status_code")
    private Integer statusCode;

    private tl1() {
    }

    public static tl1 b(u50 u50Var) {
        tl1 tl1Var = new tl1();
        tl1Var.l(u50Var.e());
        tl1Var.m(u50Var.f());
        tl1Var.i(u50Var.b());
        tl1Var.j(u50Var.d());
        if (u50Var.g() != null) {
            e43.a(t71.a(u50Var.g().c(), ul1.class));
            tl1Var.n(null);
        }
        if (u50Var.q() != null) {
            e43.a(t71.a((o61) u50Var.q(), sl1.class));
            tl1Var.k(null);
        } else {
            d.error("Result no output: {}", u50Var);
        }
        return tl1Var;
    }

    protected boolean a(Object obj) {
        return obj instanceof tl1;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public sl1 e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof tl1)) {
            return false;
        }
        tl1 tl1Var = (tl1) obj;
        if (!tl1Var.a(this)) {
            return false;
        }
        Integer numG = g();
        Integer numG2 = tl1Var.g();
        if (numG != null ? !numG.equals(numG2) : numG2 != null) {
            return false;
        }
        String strF = f();
        String strF2 = tl1Var.f();
        if (strF != null ? !strF.equals(strF2) : strF2 != null) {
            return false;
        }
        h();
        tl1Var.h();
        e();
        tl1Var.e();
        String strC = c();
        String strC2 = tl1Var.c();
        if (strC != null ? !strC.equals(strC2) : strC2 != null) {
            return false;
        }
        String strD = d();
        String strD2 = tl1Var.d();
        return strD != null ? strD.equals(strD2) : strD2 == null;
    }

    public String f() {
        return this.a;
    }

    public Integer g() {
        return this.statusCode;
    }

    public ul1 h() {
        return null;
    }

    public int hashCode() {
        Integer numG = g();
        int iHashCode = numG == null ? 43 : numG.hashCode();
        String strF = f();
        int i = (iHashCode + 59) * 59;
        int iHashCode2 = strF == null ? 43 : strF.hashCode();
        h();
        e();
        int i2 = ((((i + iHashCode2) * 59) + 43) * 59) + 43;
        String strC = c();
        int iHashCode3 = (i2 * 59) + (strC == null ? 43 : strC.hashCode());
        String strD = d();
        return (iHashCode3 * 59) + (strD != null ? strD.hashCode() : 43);
    }

    public void i(String str) {
        this.b = str;
    }

    public void j(String str) {
        this.c = str;
    }

    public void k(sl1 sl1Var) {
    }

    public void l(String str) {
        this.a = str;
    }

    public void m(Integer num) {
        this.statusCode = num;
    }

    public void n(ul1 ul1Var) {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiModalConversationResult(requestId=");
        sb.append(f());
        sb.append(", usage=");
        h();
        sb.append((Object) null);
        sb.append(", output=");
        e();
        sb.append((Object) null);
        sb.append(", statusCode=");
        sb.append(g());
        sb.append(", code=");
        sb.append(c());
        sb.append(", message=");
        sb.append(d());
        sb.append(")");
        return sb.toString();
    }
}
