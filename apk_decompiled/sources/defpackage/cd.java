package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class cd extends eh0.c {
    private final int a;
    private final String b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;

    cd(int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.a = i;
        if (str == null) {
            throw new NullPointerException("Null mediaType");
        }
        this.b = str;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
        this.h = i7;
        this.i = i8;
        this.j = i9;
    }

    @Override // eh0.c
    public int b() {
        return this.h;
    }

    @Override // eh0.c
    public int c() {
        return this.c;
    }

    @Override // eh0.c
    public int d() {
        return this.i;
    }

    @Override // eh0.c
    public int e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof eh0.c)) {
            return false;
        }
        eh0.c cVar = (eh0.c) obj;
        return this.a == cVar.e() && this.b.equals(cVar.i()) && this.c == cVar.c() && this.d == cVar.f() && this.e == cVar.k() && this.f == cVar.h() && this.g == cVar.j() && this.h == cVar.b() && this.i == cVar.d() && this.j == cVar.g();
    }

    @Override // eh0.c
    public int f() {
        return this.d;
    }

    @Override // eh0.c
    public int g() {
        return this.j;
    }

    @Override // eh0.c
    public int h() {
        return this.f;
    }

    public int hashCode() {
        return ((((((((((((((((((this.a ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003) ^ this.e) * 1000003) ^ this.f) * 1000003) ^ this.g) * 1000003) ^ this.h) * 1000003) ^ this.i) * 1000003) ^ this.j;
    }

    @Override // eh0.c
    public String i() {
        return this.b;
    }

    @Override // eh0.c
    public int j() {
        return this.g;
    }

    @Override // eh0.c
    public int k() {
        return this.e;
    }

    public String toString() {
        return "VideoProfileProxy{codec=" + this.a + ", mediaType=" + this.b + ", bitrate=" + this.c + ", frameRate=" + this.d + ", width=" + this.e + ", height=" + this.f + ", profile=" + this.g + ", bitDepth=" + this.h + ", chromaSubsampling=" + this.i + ", hdrFormat=" + this.j + "}";
    }
}
