package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 {
    private final String a;
    private final int b;

    public l0(String str, int i) {
        p31.f(str, "ssid");
        this.a = str;
        this.b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return p31.a(this.a, l0Var.a) && this.b == l0Var.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "AIGlassesWifiHotspot(ssid=" + this.a + ", signalStrength=" + this.b + ")";
    }
}
