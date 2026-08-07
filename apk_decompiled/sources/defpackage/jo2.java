package defpackage;

import android.graphics.Outline;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes3.dex */
class jo2 extends io2 {
    private boolean f = false;
    private float g = 0.0f;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            jo2 jo2Var = jo2.this;
            if (jo2Var.c == null || jo2Var.d.isEmpty()) {
                return;
            }
            jo2 jo2Var2 = jo2.this;
            RectF rectF = jo2Var2.d;
            outline.setRoundRect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom, jo2Var2.g);
        }
    }

    jo2(View view) {
        n(view);
    }

    private float m() {
        RectF rectF;
        sn2 sn2Var = this.c;
        if (sn2Var == null || (rectF = this.d) == null) {
            return 0.0f;
        }
        return sn2Var.f.a(rectF);
    }

    private void n(View view) {
        view.setOutlineProvider(new a());
    }

    private boolean o() {
        sn2 sn2Var;
        if (this.d.isEmpty() || (sn2Var = this.c) == null) {
            return false;
        }
        return sn2Var.u(this.d);
    }

    private boolean p() {
        sn2 sn2Var;
        if (!this.d.isEmpty() && (sn2Var = this.c) != null && this.b && !sn2Var.u(this.d) && q(this.c)) {
            float fA = this.c.r().a(this.d);
            float fA2 = this.c.t().a(this.d);
            float fA3 = this.c.j().a(this.d);
            float fA4 = this.c.l().a(this.d);
            if (fA == 0.0f && fA3 == 0.0f && fA2 == fA4) {
                RectF rectF = this.d;
                rectF.set(rectF.left - fA2, rectF.top, rectF.right, rectF.bottom);
                this.g = fA2;
                return true;
            }
            if (fA == 0.0f && fA2 == 0.0f && fA3 == fA4) {
                RectF rectF2 = this.d;
                rectF2.set(rectF2.left, rectF2.top - fA3, rectF2.right, rectF2.bottom);
                this.g = fA3;
                return true;
            }
            if (fA2 == 0.0f && fA4 == 0.0f && fA == fA3) {
                RectF rectF3 = this.d;
                rectF3.set(rectF3.left, rectF3.top, rectF3.right + fA, rectF3.bottom);
                this.g = fA;
                return true;
            }
            if (fA3 == 0.0f && fA4 == 0.0f && fA == fA2) {
                RectF rectF4 = this.d;
                rectF4.set(rectF4.left, rectF4.top, rectF4.right, rectF4.bottom + fA);
                this.g = fA;
                return true;
            }
        }
        return false;
    }

    private static boolean q(sn2 sn2Var) {
        return (sn2Var.q() instanceof ii2) && (sn2Var.s() instanceof ii2) && (sn2Var.i() instanceof ii2) && (sn2Var.k() instanceof ii2);
    }

    @Override // defpackage.io2
    void b(View view) {
        this.g = m();
        this.f = o() || p();
        view.setClipToOutline(!j());
        if (j()) {
            view.invalidate();
        } else {
            view.invalidateOutline();
        }
    }

    @Override // defpackage.io2
    boolean j() {
        return !this.f || this.a;
    }
}
