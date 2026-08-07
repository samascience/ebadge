package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends ng {
    private final int a;

    public b0(int i) {
        this.a = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b0) && this.a == ((b0) obj).a;
    }

    public int hashCode() {
        return Integer.hashCode(this.a);
    }

    public String toString() {
        return "AIGlassesVideoCountEvent(count=" + this.a + ")";
    }
}
