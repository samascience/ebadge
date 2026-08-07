package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends ng {
    private final String a;

    public p(String str) {
        p31.f(str, "ftpIpAddress");
        this.a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof p) && p31.a(this.a, ((p) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "AIGlassesFtpEnableEvent(ftpIpAddress=" + this.a + ")";
    }
}
