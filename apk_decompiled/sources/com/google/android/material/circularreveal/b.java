package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import defpackage.ch1;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static final int j = 2;
    private final a a;
    private final View b;
    private final Path c;
    private final Paint d;
    private final Paint e;
    private c.e f;
    private Drawable g;
    private boolean h;
    private boolean i;

    public interface a {
        void c(Canvas canvas);

        boolean d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(a aVar) {
        this.a = aVar;
        View view = (View) aVar;
        this.b = view;
        view.setWillNotDraw(false);
        this.c = new Path();
        this.d = new Paint(7);
        Paint paint = new Paint(1);
        this.e = paint;
        paint.setColor(0);
    }

    private void d(Canvas canvas) {
        if (o()) {
            Rect bounds = this.g.getBounds();
            float fWidth = this.f.a - (bounds.width() / 2.0f);
            float fHeight = this.f.b - (bounds.height() / 2.0f);
            canvas.translate(fWidth, fHeight);
            this.g.draw(canvas);
            canvas.translate(-fWidth, -fHeight);
        }
    }

    private float g(c.e eVar) {
        return ch1.b(eVar.a, eVar.b, 0.0f, 0.0f, this.b.getWidth(), this.b.getHeight());
    }

    private void i() {
        if (j == 1) {
            this.c.rewind();
            c.e eVar = this.f;
            if (eVar != null) {
                this.c.addCircle(eVar.a, eVar.b, eVar.c, Path.Direction.CW);
            }
        }
        this.b.invalidate();
    }

    private boolean n() {
        c.e eVar = this.f;
        boolean z = eVar == null || eVar.a();
        if (j == 0) {
            return !z && this.i;
        }
        return !z;
    }

    private boolean o() {
        return (this.h || this.g == null || this.f == null) ? false : true;
    }

    private boolean p() {
        return (this.h || Color.alpha(this.e.getColor()) == 0) ? false : true;
    }

    public void a() {
        if (j == 0) {
            this.h = true;
            this.i = false;
            this.b.buildDrawingCache();
            Bitmap drawingCache = this.b.getDrawingCache();
            if (drawingCache == null && this.b.getWidth() != 0 && this.b.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.b.getWidth(), this.b.getHeight(), Bitmap.Config.ARGB_8888);
                this.b.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.d;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.h = false;
            this.i = true;
        }
    }

    public void b() {
        if (j == 0) {
            this.i = false;
            this.b.destroyDrawingCache();
            this.d.setShader(null);
            this.b.invalidate();
        }
    }

    public void c(Canvas canvas) {
        if (n()) {
            int i = j;
            if (i == 0) {
                c.e eVar = this.f;
                canvas.drawCircle(eVar.a, eVar.b, eVar.c, this.d);
                if (p()) {
                    c.e eVar2 = this.f;
                    canvas.drawCircle(eVar2.a, eVar2.b, eVar2.c, this.e);
                }
            } else if (i == 1) {
                int iSave = canvas.save();
                canvas.clipPath(this.c);
                this.a.c(canvas);
                if (p()) {
                    canvas.drawRect(0.0f, 0.0f, this.b.getWidth(), this.b.getHeight(), this.e);
                }
                canvas.restoreToCount(iSave);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("Unsupported strategy " + i);
                }
                this.a.c(canvas);
                if (p()) {
                    canvas.drawRect(0.0f, 0.0f, this.b.getWidth(), this.b.getHeight(), this.e);
                }
            }
        } else {
            this.a.c(canvas);
            if (p()) {
                canvas.drawRect(0.0f, 0.0f, this.b.getWidth(), this.b.getHeight(), this.e);
            }
        }
        d(canvas);
    }

    public Drawable e() {
        return this.g;
    }

    public int f() {
        return this.e.getColor();
    }

    public c.e h() {
        c.e eVar = this.f;
        if (eVar == null) {
            return null;
        }
        c.e eVar2 = new c.e(eVar);
        if (eVar2.a()) {
            eVar2.c = g(eVar2);
        }
        return eVar2;
    }

    public boolean j() {
        return this.a.d() && !n();
    }

    public void k(Drawable drawable) {
        this.g = drawable;
        this.b.invalidate();
    }

    public void l(int i) {
        this.e.setColor(i);
        this.b.invalidate();
    }

    public void m(c.e eVar) {
        if (eVar == null) {
            this.f = null;
        } else {
            c.e eVar2 = this.f;
            if (eVar2 == null) {
                this.f = new c.e(eVar);
            } else {
                eVar2.c(eVar);
            }
            if (ch1.c(eVar.c, g(eVar), 1.0E-4f)) {
                this.f.c = Float.MAX_VALUE;
            }
        }
        i();
    }
}
