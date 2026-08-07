package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class ns1 {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    public ns1(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    protected boolean a(Object obj) {
        return obj instanceof ns1;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ns1)) {
            return false;
        }
        ns1 ns1Var = (ns1) obj;
        if (!ns1Var.a(this)) {
            return false;
        }
        String strF = f();
        String strF2 = ns1Var.f();
        if (strF != null ? !strF.equals(strF2) : strF2 != null) {
            return false;
        }
        String strB = b();
        String strB2 = ns1Var.b();
        if (strB != null ? !strB.equals(strB2) : strB2 != null) {
            return false;
        }
        String strD = d();
        String strD2 = ns1Var.d();
        if (strD != null ? !strD.equals(strD2) : strD2 != null) {
            return false;
        }
        String strC = c();
        String strC2 = ns1Var.c();
        if (strC != null ? !strC.equals(strC2) : strC2 != null) {
            return false;
        }
        String strE = e();
        String strE2 = ns1Var.e();
        if (strE != null ? !strE.equals(strE2) : strE2 != null) {
            return false;
        }
        String strH = h();
        String strH2 = ns1Var.h();
        if (strH != null ? !strH.equals(strH2) : strH2 != null) {
            return false;
        }
        String strG = g();
        String strG2 = ns1Var.g();
        return strG != null ? strG.equals(strG2) : strG2 == null;
    }

    public String f() {
        return this.a;
    }

    public String g() {
        return this.g;
    }

    public String h() {
        return this.f;
    }

    public int hashCode() {
        String strF = f();
        int iHashCode = strF == null ? 43 : strF.hashCode();
        String strB = b();
        int iHashCode2 = ((iHashCode + 59) * 59) + (strB == null ? 43 : strB.hashCode());
        String strD = d();
        int iHashCode3 = (iHashCode2 * 59) + (strD == null ? 43 : strD.hashCode());
        String strC = c();
        int iHashCode4 = (iHashCode3 * 59) + (strC == null ? 43 : strC.hashCode());
        String strE = e();
        int iHashCode5 = (iHashCode4 * 59) + (strE == null ? 43 : strE.hashCode());
        String strH = h();
        int iHashCode6 = (iHashCode5 * 59) + (strH == null ? 43 : strH.hashCode());
        String strG = g();
        return (iHashCode6 * 59) + (strG != null ? strG.hashCode() : 43);
    }

    public String toString() {
        return "OSSUploadCertificate(uploadHost=" + f() + ", ossAccessKeyId=" + b() + ", signature=" + d() + ", policy=" + c() + ", uploadDir=" + e() + ", xOssObjectAcl=" + h() + ", xOssForbidOverwrite=" + g() + ")";
    }
}
