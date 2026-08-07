package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 extends ng {
    private final boolean a;

    public i0(boolean z) {
        this.a = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i0) && this.a == ((i0) obj).a;
    }

    public int hashCode() {
        return Boolean.hashCode(this.a);
    }

    public String toString() {
        return "AIGlassesWanSwitchStatusEvent(isEnabled=" + this.a + ")";
    }
}
