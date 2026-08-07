package defpackage;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.io.ContentReference;

/* JADX INFO: loaded from: classes.dex */
public class oy0 {
    protected final ContentReference a;
    protected final Object b;
    protected JsonEncoding c;
    protected final boolean d;
    protected final io e;
    protected byte[] f;
    protected byte[] g;
    protected byte[] h;
    protected char[] i;
    protected char[] j;
    protected char[] k;

    public oy0(io ioVar, ContentReference contentReference, boolean z) {
        this.e = ioVar;
        this.a = contentReference;
        this.b = contentReference.getRawContent();
        this.d = z;
    }

    private IllegalArgumentException v() {
        return new IllegalArgumentException("Trying to release buffer smaller than original");
    }

    protected final void a(Object obj) {
        if (obj != null) {
            throw new IllegalStateException("Trying to call same allocXxx() method second time");
        }
    }

    protected final void b(byte[] bArr, byte[] bArr2) {
        if (bArr != bArr2 && bArr.length < bArr2.length) {
            throw v();
        }
    }

    protected final void c(char[] cArr, char[] cArr2) {
        if (cArr != cArr2 && cArr.length < cArr2.length) {
            throw v();
        }
    }

    public byte[] d() {
        a(this.h);
        byte[] bArrA = this.e.a(3);
        this.h = bArrA;
        return bArrA;
    }

    public char[] e() {
        a(this.j);
        char[] cArrC = this.e.c(1);
        this.j = cArrC;
        return cArrC;
    }

    public char[] f(int i) {
        a(this.k);
        char[] cArrD = this.e.d(3, i);
        this.k = cArrD;
        return cArrD;
    }

    public byte[] g() {
        a(this.f);
        byte[] bArrA = this.e.a(0);
        this.f = bArrA;
        return bArrA;
    }

    public char[] h() {
        a(this.i);
        char[] cArrC = this.e.c(0);
        this.i = cArrC;
        return cArrC;
    }

    public char[] i(int i) {
        a(this.i);
        char[] cArrD = this.e.d(0, i);
        this.i = cArrD;
        return cArrD;
    }

    public byte[] j() {
        a(this.g);
        byte[] bArrA = this.e.a(1);
        this.g = bArrA;
        return bArrA;
    }

    public w13 k() {
        return new w13(this.e);
    }

    public ContentReference l() {
        return this.a;
    }

    public JsonEncoding m() {
        return this.c;
    }

    public boolean n() {
        return this.d;
    }

    public void o(byte[] bArr) {
        if (bArr != null) {
            b(bArr, this.h);
            this.h = null;
            this.e.i(3, bArr);
        }
    }

    public void p(char[] cArr) {
        if (cArr != null) {
            c(cArr, this.j);
            this.j = null;
            this.e.j(1, cArr);
        }
    }

    public void q(char[] cArr) {
        if (cArr != null) {
            c(cArr, this.k);
            this.k = null;
            this.e.j(3, cArr);
        }
    }

    public void r(byte[] bArr) {
        if (bArr != null) {
            b(bArr, this.f);
            this.f = null;
            this.e.i(0, bArr);
        }
    }

    public void s(char[] cArr) {
        if (cArr != null) {
            c(cArr, this.i);
            this.i = null;
            this.e.j(0, cArr);
        }
    }

    public void t(byte[] bArr) {
        if (bArr != null) {
            b(bArr, this.g);
            this.g = null;
            this.e.i(1, bArr);
        }
    }

    public void u(JsonEncoding jsonEncoding) {
        this.c = jsonEncoding;
    }
}
