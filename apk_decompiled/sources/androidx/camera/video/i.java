package androidx.camera.video;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class i extends s.b {
    private final int j;
    private final String k;
    private final List l;

    i(int i, String str, List list) {
        this.j = i;
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.k = str;
        if (list == null) {
            throw new NullPointerException("Null typicalSizes");
        }
        this.l = list;
    }

    @Override // androidx.camera.video.s.b
    public String c() {
        return this.k;
    }

    @Override // androidx.camera.video.s.b
    public List d() {
        return this.l;
    }

    @Override // androidx.camera.video.s.b
    public int e() {
        return this.j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s.b)) {
            return false;
        }
        s.b bVar = (s.b) obj;
        return this.j == bVar.e() && this.k.equals(bVar.c()) && this.l.equals(bVar.d());
    }

    public int hashCode() {
        return ((((this.j ^ 1000003) * 1000003) ^ this.k.hashCode()) * 1000003) ^ this.l.hashCode();
    }

    public String toString() {
        return "ConstantQuality{value=" + this.j + ", name=" + this.k + ", typicalSizes=" + this.l + "}";
    }
}
