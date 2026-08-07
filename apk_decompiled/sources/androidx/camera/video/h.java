package androidx.camera.video;

/* JADX INFO: loaded from: classes.dex */
final class h extends u.a {
    private final s a;
    private final int b;

    h(s sVar, int i) {
        if (sVar == null) {
            throw new NullPointerException("Null quality");
        }
        this.a = sVar;
        this.b = i;
    }

    @Override // androidx.camera.video.u.a
    int a() {
        return this.b;
    }

    @Override // androidx.camera.video.u.a
    s b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u.a)) {
            return false;
        }
        u.a aVar = (u.a) obj;
        return this.a.equals(aVar.b()) && this.b == aVar.a();
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b;
    }

    public String toString() {
        return "QualityRatio{quality=" + this.a + ", aspectRatio=" + this.b + "}";
    }
}
