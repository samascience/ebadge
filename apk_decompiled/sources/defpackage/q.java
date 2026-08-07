package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends ng {
    private final String a;
    private final String b;

    public q(String str, String str2) {
        p31.f(str, "ssid");
        p31.f(str2, "password");
        this.a = str;
        this.b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return p31.a(this.a, qVar.a) && p31.a(this.b, qVar.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "AIGlassesLanInfoEvent(ssid=" + this.a + ", password=" + this.b + ")";
    }
}
