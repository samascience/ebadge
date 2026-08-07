package defpackage;

import android.util.Size;

/* JADX INFO: loaded from: classes.dex */
final class yc extends mw.c {
    private final Size d;
    private final int e;
    private final int f;
    private final boolean g;
    private final Size h;
    private final int i;
    private final bf0 j;
    private final bf0 k;

    yc(Size size, int i, int i2, boolean z, y01 y01Var, Size size2, int i3, bf0 bf0Var, bf0 bf0Var2) {
        if (size == null) {
            throw new NullPointerException("Null size");
        }
        this.d = size;
        this.e = i;
        this.f = i2;
        this.g = z;
        this.h = size2;
        this.i = i3;
        if (bf0Var == null) {
            throw new NullPointerException("Null requestEdge");
        }
        this.j = bf0Var;
        if (bf0Var2 == null) {
            throw new NullPointerException("Null errorEdge");
        }
        this.k = bf0Var2;
    }

    @Override // mw.c
    bf0 b() {
        return this.k;
    }

    @Override // mw.c
    y01 c() {
        return null;
    }

    @Override // mw.c
    int d() {
        return this.e;
    }

    @Override // mw.c
    int e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof mw.c)) {
            return false;
        }
        mw.c cVar = (mw.c) obj;
        if (this.d.equals(cVar.j()) && this.e == cVar.d() && this.f == cVar.e() && this.g == cVar.l()) {
            cVar.c();
            Size size = this.h;
            if (size != null ? size.equals(cVar.g()) : cVar.g() == null) {
                if (this.i == cVar.f() && this.j.equals(cVar.i()) && this.k.equals(cVar.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // mw.c
    int f() {
        return this.i;
    }

    @Override // mw.c
    Size g() {
        return this.h;
    }

    public int hashCode() {
        int iHashCode = (((((((this.d.hashCode() ^ 1000003) * 1000003) ^ this.e) * 1000003) ^ this.f) * 1000003) ^ (this.g ? 1231 : 1237)) * (-721379959);
        Size size = this.h;
        return ((((((iHashCode ^ (size == null ? 0 : size.hashCode())) * 1000003) ^ this.i) * 1000003) ^ this.j.hashCode()) * 1000003) ^ this.k.hashCode();
    }

    @Override // mw.c
    bf0 i() {
        return this.j;
    }

    @Override // mw.c
    Size j() {
        return this.d;
    }

    @Override // mw.c
    boolean l() {
        return this.g;
    }

    public String toString() {
        return "In{size=" + this.d + ", inputFormat=" + this.e + ", outputFormat=" + this.f + ", virtualCamera=" + this.g + ", imageReaderProxyProvider=" + ((Object) null) + ", postviewSize=" + this.h + ", postviewImageFormat=" + this.i + ", requestEdge=" + this.j + ", errorEdge=" + this.k + "}";
    }
}
