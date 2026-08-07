package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class z93 {
    private String a;
    private ns1 b;

    public z93(String str, ns1 ns1Var) {
        this.a = str;
        this.b = ns1Var;
    }

    protected boolean a(Object obj) {
        return obj instanceof z93;
    }

    public ns1 b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof z93)) {
            return false;
        }
        z93 z93Var = (z93) obj;
        if (!z93Var.a(this)) {
            return false;
        }
        String strC = c();
        String strC2 = z93Var.c();
        if (strC != null ? !strC.equals(strC2) : strC2 != null) {
            return false;
        }
        ns1 ns1VarB = b();
        ns1 ns1VarB2 = z93Var.b();
        return ns1VarB != null ? ns1VarB.equals(ns1VarB2) : ns1VarB2 == null;
    }

    public int hashCode() {
        String strC = c();
        int iHashCode = strC == null ? 43 : strC.hashCode();
        ns1 ns1VarB = b();
        return ((iHashCode + 59) * 59) + (ns1VarB != null ? ns1VarB.hashCode() : 43);
    }

    public String toString() {
        return "UploadResult(ossUrl=" + c() + ", certificate=" + b() + ")";
    }
}
