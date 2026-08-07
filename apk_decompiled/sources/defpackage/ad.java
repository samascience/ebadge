package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class ad extends eh0.a {
    private final int a;
    private final String b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;

    ad(int i, String str, int i2, int i3, int i4, int i5) {
        this.a = i;
        if (str == null) {
            throw new NullPointerException("Null mediaType");
        }
        this.b = str;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
    }

    @Override // eh0.a
    public int b() {
        return this.c;
    }

    @Override // eh0.a
    public int c() {
        return this.e;
    }

    @Override // eh0.a
    public int d() {
        return this.a;
    }

    @Override // eh0.a
    public String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof eh0.a)) {
            return false;
        }
        eh0.a aVar = (eh0.a) obj;
        return this.a == aVar.d() && this.b.equals(aVar.e()) && this.c == aVar.b() && this.d == aVar.g() && this.e == aVar.c() && this.f == aVar.f();
    }

    @Override // eh0.a
    public int f() {
        return this.f;
    }

    @Override // eh0.a
    public int g() {
        return this.d;
    }

    public int hashCode() {
        return ((((((((((this.a ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003) ^ this.e) * 1000003) ^ this.f;
    }

    public String toString() {
        return "AudioProfileProxy{codec=" + this.a + ", mediaType=" + this.b + ", bitrate=" + this.c + ", sampleRate=" + this.d + ", channels=" + this.e + ", profile=" + this.f + "}";
    }
}
