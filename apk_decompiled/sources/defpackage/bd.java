package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class bd extends eh0.b {
    private final int a;
    private final int b;
    private final List c;
    private final List d;

    bd(int i, int i2, List list, List list2) {
        this.a = i;
        this.b = i2;
        if (list == null) {
            throw new NullPointerException("Null audioProfiles");
        }
        this.c = list;
        if (list2 == null) {
            throw new NullPointerException("Null videoProfiles");
        }
        this.d = list2;
    }

    @Override // defpackage.eh0
    public int a() {
        return this.a;
    }

    @Override // defpackage.eh0
    public int b() {
        return this.b;
    }

    @Override // defpackage.eh0
    public List c() {
        return this.c;
    }

    @Override // defpackage.eh0
    public List d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof eh0.b)) {
            return false;
        }
        eh0.b bVar = (eh0.b) obj;
        return this.a == bVar.a() && this.b == bVar.b() && this.c.equals(bVar.c()) && this.d.equals(bVar.d());
    }

    public int hashCode() {
        return ((((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
    }

    public String toString() {
        return "ImmutableEncoderProfilesProxy{defaultDurationSeconds=" + this.a + ", recommendedFileFormat=" + this.b + ", audioProfiles=" + this.c + ", videoProfiles=" + this.d + "}";
    }
}
