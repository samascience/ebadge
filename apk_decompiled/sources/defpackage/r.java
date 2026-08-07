package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends ng {
    private final boolean a;

    public r(boolean z) {
        this.a = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r) && this.a == ((r) obj).a;
    }

    public int hashCode() {
        return Boolean.hashCode(this.a);
    }

    public String toString() {
        return "AIGlassesLanStatusEvent(isEnabled=" + this.a + ")";
    }
}
