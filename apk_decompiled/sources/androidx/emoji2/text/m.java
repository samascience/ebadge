package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import defpackage.sj1;

/* JADX INFO: loaded from: classes.dex */
public class m {
    private static final ThreadLocal d = new ThreadLocal();
    private final int a;
    private final l b;
    private volatile int c = 0;

    m(l lVar, int i) {
        this.b = lVar;
        this.a = i;
    }

    private sj1 g() {
        ThreadLocal threadLocal = d;
        sj1 sj1Var = (sj1) threadLocal.get();
        if (sj1Var == null) {
            sj1Var = new sj1();
            threadLocal.set(sj1Var);
        }
        this.b.d().j(sj1Var, this.a);
        return sj1Var;
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        Typeface typefaceG = this.b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(typefaceG);
        canvas.drawText(this.b.c(), this.a * 2, 2, f, f2, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i) {
        return g().h(i);
    }

    public int c() {
        return g().i();
    }

    public int d() {
        return this.c & 3;
    }

    public int e() {
        return g().k();
    }

    public int f() {
        return g().l();
    }

    public short h() {
        return g().m();
    }

    public int i() {
        return g().n();
    }

    public boolean j() {
        return g().j();
    }

    public boolean k() {
        return (this.c & 4) > 0;
    }

    public void l(boolean z) {
        int iD = d();
        if (z) {
            this.c = iD | 4;
        } else {
            this.c = iD;
        }
    }

    public void m(boolean z) {
        int i = this.c & 4;
        this.c = z ? i | 2 : i | 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(f()));
        sb.append(", codepoints:");
        int iC = c();
        for (int i = 0; i < iC; i++) {
            sb.append(Integer.toHexString(b(i)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
