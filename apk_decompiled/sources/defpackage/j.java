package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends ng {
    private final int a;

    public j(int i) {
        this.a = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && this.a == ((j) obj).a;
    }

    public int hashCode() {
        return Integer.hashCode(this.a);
    }

    public String toString() {
        return "AIGlassesAudioCountEvent(count=" + this.a + ")";
    }
}
