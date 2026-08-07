package defpackage;

import android.opengl.EGLSurface;

/* JADX INFO: loaded from: classes.dex */
final class ld extends rw1.b {
    private final EGLSurface a;
    private final int b;
    private final int c;

    ld(EGLSurface eGLSurface, int i, int i2) {
        if (eGLSurface == null) {
            throw new NullPointerException("Null eglSurface");
        }
        this.a = eGLSurface;
        this.b = i;
        this.c = i2;
    }

    @Override // rw1.b
    EGLSurface a() {
        return this.a;
    }

    @Override // rw1.b
    int b() {
        return this.c;
    }

    @Override // rw1.b
    int c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof rw1.b)) {
            return false;
        }
        rw1.b bVar = (rw1.b) obj;
        return this.a.equals(bVar.a()) && this.b == bVar.c() && this.c == bVar.b();
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c;
    }

    public String toString() {
        return "OutputSurface{eglSurface=" + this.a + ", width=" + this.b + ", height=" + this.c + "}";
    }
}
