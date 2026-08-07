package defpackage;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public abstract class o50 implements j03 {
    private final int a;
    private final int b;
    private ef2 c;

    public o50() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // defpackage.j03
    public final void a(hr2 hr2Var) {
        hr2Var.d(this.a, this.b);
    }

    @Override // defpackage.j03
    public final void c(ef2 ef2Var) {
        this.c = ef2Var;
    }

    @Override // defpackage.j03
    public final void d(hr2 hr2Var) {
    }

    @Override // defpackage.j03
    public void e(Drawable drawable) {
    }

    @Override // defpackage.j03
    public void f(Drawable drawable) {
    }

    @Override // defpackage.j03
    public final ef2 g() {
        return this.c;
    }

    @Override // defpackage.bb1
    public void onDestroy() {
    }

    @Override // defpackage.bb1
    public void onStart() {
    }

    @Override // defpackage.bb1
    public void onStop() {
    }

    public o50(int i, int i2) {
        if (na3.s(i, i2)) {
            this.a = i;
            this.b = i2;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i + " and height: " + i2);
    }
}
