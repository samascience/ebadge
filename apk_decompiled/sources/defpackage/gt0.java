package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class gt0 {
    private static final hd1 d = ld1.k(gt0.class);
    private String a;
    private String b;
    private String c;

    @xm2("status_code")
    private Integer statusCode;

    private gt0() {
    }

    public static gt0 a(u50 u50Var) {
        gt0 gt0Var = new gt0();
        gt0Var.k(u50Var.e());
        gt0Var.l(u50Var.f());
        gt0Var.h(u50Var.b());
        gt0Var.i(u50Var.d());
        if (u50Var.g() != null) {
            e43.a(t71.a(u50Var.g().c(), ht0.class));
            gt0Var.m(null);
        }
        if (u50Var.q() != null) {
            e43.a(t71.a((o61) u50Var.q(), dt0.class));
            gt0Var.j(null);
        } else {
            d.error(uv2.a("Result no output: %s", u50Var));
        }
        return gt0Var;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public dt0 d() {
        return null;
    }

    public String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gt0)) {
            return false;
        }
        gt0 gt0Var = (gt0) obj;
        Integer numF = f();
        Integer numF2 = gt0Var.f();
        if (numF != null ? !numF.equals(numF2) : numF2 != null) {
            return false;
        }
        String strE = e();
        String strE2 = gt0Var.e();
        if (strE != null ? !strE.equals(strE2) : strE2 != null) {
            return false;
        }
        g();
        gt0Var.g();
        d();
        gt0Var.d();
        String strB = b();
        String strB2 = gt0Var.b();
        if (strB != null ? !strB.equals(strB2) : strB2 != null) {
            return false;
        }
        String strC = c();
        String strC2 = gt0Var.c();
        return strC != null ? strC.equals(strC2) : strC2 == null;
    }

    public Integer f() {
        return this.statusCode;
    }

    public ht0 g() {
        return null;
    }

    public void h(String str) {
        this.b = str;
    }

    public int hashCode() {
        Integer numF = f();
        int iHashCode = numF == null ? 43 : numF.hashCode();
        String strE = e();
        int i = (iHashCode + 59) * 59;
        int iHashCode2 = strE == null ? 43 : strE.hashCode();
        g();
        d();
        int i2 = ((((i + iHashCode2) * 59) + 43) * 59) + 43;
        String strB = b();
        int iHashCode3 = (i2 * 59) + (strB == null ? 43 : strB.hashCode());
        String strC = c();
        return (iHashCode3 * 59) + (strC != null ? strC.hashCode() : 43);
    }

    public void i(String str) {
        this.c = str;
    }

    public void j(dt0 dt0Var) {
    }

    public void k(String str) {
        this.a = str;
    }

    public void l(Integer num) {
        this.statusCode = num;
    }

    public void m(ht0 ht0Var) {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GenerationResult(requestId=");
        sb.append(e());
        sb.append(", usage=");
        g();
        sb.append((Object) null);
        sb.append(", output=");
        d();
        sb.append((Object) null);
        sb.append(", statusCode=");
        sb.append(f());
        sb.append(", code=");
        sb.append(b());
        sb.append(", message=");
        sb.append(c());
        sb.append(")");
        return sb.toString();
    }
}
