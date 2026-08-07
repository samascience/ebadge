package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends ng {
    private final int a;

    public t(int i) {
        this.a = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof t) && this.a == ((t) obj).a;
    }

    public int hashCode() {
        return Integer.hashCode(this.a);
    }

    public String toString() {
        return "AIGlassesOtherVolumeEvent(volume=" + this.a + ")";
    }
}
