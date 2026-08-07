package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends ng {
    private final int a;

    public v(int i) {
        this.a = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof v) && this.a == ((v) obj).a;
    }

    public int hashCode() {
        return Integer.hashCode(this.a);
    }

    public String toString() {
        return "AIGlassesPhotoCountEvent(count=" + this.a + ")";
    }
}
