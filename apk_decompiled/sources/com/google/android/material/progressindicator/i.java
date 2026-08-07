package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.google.android.material.R$drawable;
import defpackage.a7;
import defpackage.dd0;
import defpackage.e6;
import defpackage.gb3;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends f {
    private g p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private h f266q;
    private Drawable r;

    i(Context context, a aVar, g gVar, h hVar) {
        super(context, aVar);
        z(gVar);
        y(hVar);
    }

    static i t(Context context, d dVar, b bVar) {
        i iVar = new i(context, dVar, bVar, new c(dVar));
        iVar.A(gb3.b(context.getResources(), R$drawable.indeterminate_static, null));
        return iVar;
    }

    static i u(Context context, m mVar, j jVar) {
        return new i(context, mVar, jVar, mVar.h == 0 ? new k(mVar) : new l(context, mVar));
    }

    private boolean x() {
        a7 a7Var = this.c;
        return a7Var != null && a7Var.a(this.a.getContentResolver()) == 0.0f;
    }

    public void A(Drawable drawable) {
        this.r = drawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable;
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            if (x() && (drawable = this.r) != null) {
                drawable.setBounds(getBounds());
                dd0.n(this.r, this.b.c[0]);
                this.r.draw(canvas);
                return;
            }
            canvas.save();
            this.p.g(canvas, getBounds(), h(), k(), j());
            int i = this.b.g;
            int alpha = getAlpha();
            if (i == 0) {
                this.p.d(canvas, this.m, 0.0f, 1.0f, this.b.d, alpha, 0);
            } else {
                g.a aVar = (g.a) this.f266q.b.get(0);
                List list = this.f266q.b;
                g.a aVar2 = (g.a) list.get(list.size() - 1);
                g gVar = this.p;
                if (gVar instanceof j) {
                    gVar.d(canvas, this.m, 0.0f, aVar.a, this.b.d, alpha, i);
                    this.p.d(canvas, this.m, aVar2.b, 1.0f, this.b.d, alpha, i);
                } else {
                    alpha = 0;
                    gVar.d(canvas, this.m, aVar2.b, 1.0f + aVar.a, this.b.d, 0, i);
                }
            }
            for (int i2 = 0; i2 < this.f266q.b.size(); i2++) {
                g.a aVar3 = (g.a) this.f266q.b.get(i2);
                this.p.c(canvas, this.m, aVar3, getAlpha());
                if (i2 > 0 && i > 0) {
                    this.p.d(canvas, this.m, ((g.a) this.f266q.b.get(i2 - 1)).b, aVar3.a, this.b.d, alpha, i);
                }
            }
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

    @Override // com.google.android.material.progressindicator.f
    public /* bridge */ /* synthetic */ boolean k() {
        return super.k();
    }

    @Override // com.google.android.material.progressindicator.f
    public /* bridge */ /* synthetic */ void m(e6 e6Var) {
        super.m(e6Var);
    }

    @Override // com.google.android.material.progressindicator.f
    public /* bridge */ /* synthetic */ boolean q(boolean z, boolean z2, boolean z3) {
        return super.q(z, z2, z3);
    }

    @Override // com.google.android.material.progressindicator.f
    boolean r(boolean z, boolean z2, boolean z3) {
        Drawable drawable;
        boolean zR = super.r(z, z2, z3);
        if (x() && (drawable = this.r) != null) {
            return drawable.setVisible(z, z2);
        }
        if (!isRunning()) {
            this.f266q.a();
        }
        if (z && z3) {
            this.f266q.g();
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

    h v() {
        return this.f266q;
    }

    g w() {
        return this.p;
    }

    void y(h hVar) {
        this.f266q = hVar;
        hVar.e(this);
    }

    void z(g gVar) {
        this.p = gVar;
    }
}
