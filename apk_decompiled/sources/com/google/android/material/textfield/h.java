package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import defpackage.sn2;
import defpackage.tg1;

/* JADX INFO: loaded from: classes3.dex */
abstract class h extends tg1 {
    b z;

    private static class c extends h {
        c(b bVar) {
            super(bVar);
        }

        @Override // defpackage.tg1
        protected void r(Canvas canvas) {
            if (this.z.w.isEmpty()) {
                super.r(canvas);
                return;
            }
            canvas.save();
            canvas.clipOutRect(this.z.w);
            super.r(canvas);
            canvas.restore();
        }
    }

    static h r0(sn2 sn2Var) {
        if (sn2Var == null) {
            sn2Var = new sn2();
        }
        return s0(new b(sn2Var, new RectF()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static h s0(b bVar) {
        return new c(bVar);
    }

    @Override // defpackage.tg1, android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.z = new b(this.z);
        return this;
    }

    boolean t0() {
        return !this.z.w.isEmpty();
    }

    void u0() {
        v0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    void v0(float f, float f2, float f3, float f4) {
        if (f == this.z.w.left && f2 == this.z.w.top && f3 == this.z.w.right && f4 == this.z.w.bottom) {
            return;
        }
        this.z.w.set(f, f2, f3, f4);
        invalidateSelf();
    }

    void w0(RectF rectF) {
        v0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    private static final class b extends tg1.c {
        private final RectF w;

        @Override // tg1.c, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            h hVarS0 = h.s0(this);
            hVarS0.invalidateSelf();
            return hVarS0;
        }

        private b(sn2 sn2Var, RectF rectF) {
            super(sn2Var, null);
            this.w = rectF;
        }

        private b(b bVar) {
            super(bVar);
            this.w = bVar.w;
        }
    }

    private h(b bVar) {
        super(bVar);
        this.z = bVar;
    }
}
