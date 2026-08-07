package defpackage;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class lh2 {
    private String a;
    private u51 b;
    private Map c;
    private Integer d;
    private String e;
    private String f;

    protected abstract boolean a(Object obj);

    public String b() {
        return this.e;
    }

    public Map c() {
        return this.c;
    }

    public String d() {
        return this.f;
    }

    public String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof lh2)) {
            return false;
        }
        lh2 lh2Var = (lh2) obj;
        if (!lh2Var.a(this)) {
            return false;
        }
        Integer numF = f();
        Integer numF2 = lh2Var.f();
        if (numF != null ? !numF.equals(numF2) : numF2 != null) {
            return false;
        }
        String strE = e();
        String strE2 = lh2Var.e();
        if (strE != null ? !strE.equals(strE2) : strE2 != null) {
            return false;
        }
        u51 u51VarG = g();
        u51 u51VarG2 = lh2Var.g();
        if (u51VarG != null ? !u51VarG.equals(u51VarG2) : u51VarG2 != null) {
            return false;
        }
        Map mapC = c();
        Map mapC2 = lh2Var.c();
        if (mapC != null ? !mapC.equals(mapC2) : mapC2 != null) {
            return false;
        }
        String strB = b();
        String strB2 = lh2Var.b();
        if (strB != null ? !strB.equals(strB2) : strB2 != null) {
            return false;
        }
        String strD = d();
        String strD2 = lh2Var.d();
        return strD != null ? strD.equals(strD2) : strD2 == null;
    }

    public Integer f() {
        return this.d;
    }

    public u51 g() {
        return this.b;
    }

    public void h(String str) {
        this.e = str;
    }

    public int hashCode() {
        Integer numF = f();
        int iHashCode = numF == null ? 43 : numF.hashCode();
        String strE = e();
        int iHashCode2 = ((iHashCode + 59) * 59) + (strE == null ? 43 : strE.hashCode());
        u51 u51VarG = g();
        int iHashCode3 = (iHashCode2 * 59) + (u51VarG == null ? 43 : u51VarG.hashCode());
        Map mapC = c();
        int iHashCode4 = (iHashCode3 * 59) + (mapC == null ? 43 : mapC.hashCode());
        String strB = b();
        int iHashCode5 = (iHashCode4 * 59) + (strB == null ? 43 : strB.hashCode());
        String strD = d();
        return (iHashCode5 * 59) + (strD != null ? strD.hashCode() : 43);
    }

    public void i(String str) {
        this.f = str;
    }

    public void j(String str) {
        this.a = str;
    }

    public void k(Integer num) {
        this.d = num;
    }

    public void l(u51 u51Var) {
        this.b = u51Var;
    }
}
