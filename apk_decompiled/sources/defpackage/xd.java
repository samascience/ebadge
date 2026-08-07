package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class xd extends vd3 {
    private final int a;
    private final int b;
    private final List c;
    private final List d;
    private final eh0.a e;
    private final eh0.c f;

    xd(int i, int i2, List list, List list2, eh0.a aVar, eh0.c cVar) {
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
        this.e = aVar;
        if (cVar == null) {
            throw new NullPointerException("Null defaultVideoProfile");
        }
        this.f = cVar;
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
        eh0.a aVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof vd3)) {
            return false;
        }
        vd3 vd3Var = (vd3) obj;
        return this.a == vd3Var.a() && this.b == vd3Var.b() && this.c.equals(vd3Var.c()) && this.d.equals(vd3Var.d()) && ((aVar = this.e) != null ? aVar.equals(vd3Var.j()) : vd3Var.j() == null) && this.f.equals(vd3Var.k());
    }

    public int hashCode() {
        int iHashCode = (((((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003;
        eh0.a aVar = this.e;
        return ((iHashCode ^ (aVar == null ? 0 : aVar.hashCode())) * 1000003) ^ this.f.hashCode();
    }

    @Override // defpackage.vd3
    public eh0.a j() {
        return this.e;
    }

    @Override // defpackage.vd3
    public eh0.c k() {
        return this.f;
    }

    public String toString() {
        return "VideoValidatedEncoderProfilesProxy{defaultDurationSeconds=" + this.a + ", recommendedFileFormat=" + this.b + ", audioProfiles=" + this.c + ", videoProfiles=" + this.d + ", defaultAudioProfile=" + this.e + ", defaultVideoProfile=" + this.f + "}";
    }
}
