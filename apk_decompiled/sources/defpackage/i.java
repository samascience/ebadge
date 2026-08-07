package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends ng {
    private final int a;

    public i(int i) {
        this.a = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.a == ((i) obj).a;
    }

    public int hashCode() {
        return Integer.hashCode(this.a);
    }

    public String toString() {
        return "AIGlassesAiVolumeEvent(volume=" + this.a + ")";
    }
}
