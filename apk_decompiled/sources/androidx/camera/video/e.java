package androidx.camera.video;

/* JADX INFO: loaded from: classes.dex */
final class e extends o.b {
    private final s b;
    private final int c;

    e(s sVar, int i) {
        if (sVar == null) {
            throw new NullPointerException("Null fallbackQuality");
        }
        this.b = sVar;
        this.c = i;
    }

    @Override // androidx.camera.video.o.b
    s b() {
        return this.b;
    }

    @Override // androidx.camera.video.o.b
    int c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o.b)) {
            return false;
        }
        o.b bVar = (o.b) obj;
        return this.b.equals(bVar.b()) && this.c == bVar.c();
    }

    public int hashCode() {
        return ((this.b.hashCode() ^ 1000003) * 1000003) ^ this.c;
    }

    public String toString() {
        return "RuleStrategy{fallbackQuality=" + this.b + ", fallbackRule=" + this.c + "}";
    }
}
