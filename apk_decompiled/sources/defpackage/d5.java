package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public final class d5 {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final Long f;

    public d5(String str, String str2, String str3, String str4, String str5, Long l) {
        p31.f(str, "credential");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = l;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d5)) {
            return false;
        }
        d5 d5Var = (d5) obj;
        return p31.a(this.a, d5Var.a) && p31.a(this.b, d5Var.b) && p31.a(this.c, d5Var.c) && p31.a(this.d, d5Var.d) && p31.a(this.e, d5Var.e) && p31.a(this.f, d5Var.f);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.e;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l = this.f;
        return iHashCode5 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "AiAccessDecryptedConfig(credential=" + this.a + ", translateUrl=" + this.b + ", multimodalWsUrl=" + this.c + ", workspaceId=" + this.d + ", appId=" + this.e + ", expiresAtEpochSeconds=" + this.f + ")";
    }
}
