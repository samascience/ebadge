package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import defpackage.at2;
import defpackage.bo0;
import defpackage.bt2;
import defpackage.e6;
import defpackage.eh1;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends f {
    private static final bo0 u = new a("indicatorLevel");
    private g p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final bt2 f265q;
    private final at2 r;
    private final g.a s;
    private boolean t;

    class a extends bo0 {
        a(String str) {
            super(str);
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(e eVar) {
            return eVar.y() * 10000.0f;
        }

        @Override // defpackage.bo0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(e eVar, float f) {
            eVar.A(f / 10000.0f);
        }
    }

    e(Context context, com.google.android.material.progressindicator.a aVar, g gVar) {
        super(context, aVar);
        this.t = false;
        z(gVar);
        this.s = new g.a();
        bt2 bt2Var = new bt2();
        this.f265q = bt2Var;
        bt2Var.d(1.0f);
        bt2Var.f(50.0f);
        at2 at2Var = new at2(this, u);
        this.r = at2Var;
        at2Var.p(bt2Var);
        n(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(float f) {
        this.s.b = f;
        invalidateSelf();
    }

    static e v(Context context, d dVar, b bVar) {
        return new e(context, dVar, bVar);
    }

    static e w(Context context, m mVar, j jVar) {
        return new e(context, mVar, jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float y() {
        return this.s.b;
    }

    void B(float f) {
        setLevel((int) (f * 10000.0f));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.p.g(canvas, getBounds(), h(), k(), j());
            this.m.setStyle(Paint.Style.FILL);
            this.m.setAntiAlias(true);
            g.a aVar = this.s;
            com.google.android.material.progressindicator.a aVar2 = this.b;
            aVar.c = aVar2.c[0];
            int iA = aVar2.g;
            if (iA > 0) {
                if (!(this.p instanceof j)) {
                    iA = (int) ((iA * eh1.a(y(), 0.0f, 0.01f)) / 0.01f);
                }
                this.p.d(canvas, this.m, y(), 1.0f, this.b.d, getAlpha(), iA);
            } else {
                this.p.d(canvas, this.m, 0.0f, 1.0f, aVar2.d, getAlpha(), 0);
            }
            this.p.c(canvas, this.m, this.s, getAlpha());
            this.p.b(canvas, this.m, this.b.c[0], getAlpha());
            canvas.restore();
        }
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.p.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.p.f();
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // com.google.android.material.progressindicator.f
    public /* bridge */ /* synthetic */ boolean i() {
        return super.i();
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // com.google.android.material.progressindicator.f
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.r.q();
        A(getLevel() / 10000.0f);
    }

    @Override // com.google.android.material.progressindicator.f
    public /* bridge */ /* synthetic */ boolean k() {
        return super.k();
    }

    @Override // com.google.android.material.progressindicator.f
    public /* bridge */ /* synthetic */ void m(e6 e6Var) {
        super.m(e6Var);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        if (this.t) {
            this.r.q();
            A(i / 10000.0f);
            return true;
        }
        this.r.h(y() * 10000.0f);
        this.r.l(i);
        return true;
    }

    @Override // com.google.android.material.progressindicator.f
    public /* bridge */ /* synthetic */ boolean q(boolean z, boolean z2, boolean z3) {
        return super.q(z, z2, z3);
    }

    @Override // com.google.android.material.progressindicator.f
    boolean r(boolean z, boolean z2, boolean z3) {
        boolean zR = super.r(z, z2, z3);
        float fA = this.c.a(this.a.getContentResolver());
        if (fA == 0.0f) {
            this.t = true;
        } else {
            this.t = false;
            this.f265q.f(50.0f / fA);
        }
        return zR;
    }

    @Override // com.google.android.material.progressindicator.f
    public /* bridge */ /* synthetic */ boolean s(e6 e6Var) {
        return super.s(e6Var);
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2);
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    g x() {
        return this.p;
    }

    void z(g gVar) {
        this.p = gVar;
    }
}
