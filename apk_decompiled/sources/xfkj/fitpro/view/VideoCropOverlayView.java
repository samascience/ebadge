package xfkj.fitpro.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import defpackage.wa3;

/* JADX INFO: loaded from: classes4.dex */
public class VideoCropOverlayView extends View {
    private RectF a;
    private Paint b;
    private Paint c;
    private Paint d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private RectF n;
    private float o;
    private a p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f422q;
    private float r;

    public interface a {
        void a(RectF rectF, float f, float f2, float f3, float f4);
    }

    public VideoCropOverlayView(Context context) {
        this(context, null);
    }

    private void a() {
        float fWidth = this.a.width();
        float fHeight = this.a.height();
        float f = fWidth / fHeight;
        float fCenterX = this.a.centerX();
        float fCenterY = this.a.centerY();
        float f2 = this.o;
        if (f > f2) {
            fWidth = fHeight * f2;
        } else {
            fHeight = fWidth / f2;
        }
        float f3 = this.f422q;
        if (fWidth < f3) {
            fHeight = f3 / f2;
            fWidth = f3;
        }
        if (fHeight < f3) {
            fWidth = f3 * f2;
        } else {
            f3 = fHeight;
        }
        float f4 = fWidth / 2.0f;
        float f5 = fCenterX - f4;
        float f6 = f3 / 2.0f;
        float f7 = fCenterY - f6;
        float f8 = fCenterX + f4;
        float f9 = fCenterY + f6;
        RectF rectF = this.n;
        float f10 = rectF.left;
        if (f5 < f10) {
            f8 = f10 + fWidth;
            f5 = f10;
        }
        float f11 = rectF.right;
        if (f8 > f11) {
            f5 = f11 - fWidth;
            f8 = f11;
        }
        float f12 = rectF.top;
        if (f7 < f12) {
            f9 = f12 + f3;
            f7 = f12;
        }
        float f13 = rectF.bottom;
        if (f9 > f13) {
            f7 = f13 - f3;
            f9 = f13;
        }
        this.a.set(f5, f7, f8, f9);
    }

    private void b(Canvas canvas, float f, float f2, boolean z, boolean z2) {
        float f3 = this.r;
        float f4 = z ? f : f - f3;
        float f5 = z ? f + f3 : f;
        float f6 = z2 ? f2 : f2 - f3;
        float f7 = z2 ? f3 + f2 : f2;
        canvas.drawLine(f4, f2, f5, f2, this.d);
        canvas.drawLine(f, f6, f, f7, this.d);
    }

    private boolean c(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 2) {
            return false;
        }
        this.m = motionEvent.getPointerId(1);
        this.k = true;
        this.j = false;
        this.i = (float) Math.sqrt(Math.pow(motionEvent.getX(1) - motionEvent.getX(0), 2.0d) + Math.pow(motionEvent.getY(1) - motionEvent.getY(0), 2.0d));
        return true;
    }

    private boolean d(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        if (pointerId == this.l) {
            int i = actionIndex == 0 ? 1 : 0;
            this.l = motionEvent.getPointerId(i);
            this.e = motionEvent.getX(i);
            this.f = motionEvent.getY(i);
        } else if (pointerId == this.m) {
            this.m = -1;
        }
        this.k = false;
        return true;
    }

    private boolean e(MotionEvent motionEvent) {
        this.l = motionEvent.getPointerId(0);
        this.e = motionEvent.getX();
        float y = motionEvent.getY();
        this.f = y;
        float f = this.e;
        this.g = f;
        this.h = y;
        if (!this.a.contains(f, y)) {
            return false;
        }
        this.j = true;
        return true;
    }

    private boolean f(MotionEvent motionEvent) {
        if (!this.k || motionEvent.getPointerCount() != 2) {
            if (!this.j) {
                return false;
            }
            int iFindPointerIndex = motionEvent.findPointerIndex(this.l);
            if (iFindPointerIndex >= 0) {
                float x = motionEvent.getX(iFindPointerIndex);
                float y = motionEvent.getY(iFindPointerIndex);
                float f = x - this.e;
                float f2 = y - this.f;
                RectF rectF = this.a;
                float f3 = rectF.left + f;
                float f4 = rectF.top + f2;
                float f5 = rectF.right + f;
                float f6 = rectF.bottom + f2;
                RectF rectF2 = this.n;
                float f7 = rectF2.left;
                if (f3 < f7) {
                    float f8 = f7 - f3;
                    f3 += f8;
                    f5 += f8;
                }
                float f9 = rectF2.right;
                if (f5 > f9) {
                    float f10 = f5 - f9;
                    f3 -= f10;
                    f5 -= f10;
                }
                float f11 = rectF2.top;
                if (f4 < f11) {
                    float f12 = f11 - f4;
                    f4 += f12;
                    f6 += f12;
                }
                float f13 = rectF2.bottom;
                if (f6 > f13) {
                    float f14 = f6 - f13;
                    f4 -= f14;
                    f6 -= f14;
                }
                rectF.set(f3, f4, f5, f6);
                this.e = x;
                this.f = y;
                invalidate();
                j();
            }
            return true;
        }
        int iFindPointerIndex2 = motionEvent.findPointerIndex(this.l);
        int iFindPointerIndex3 = motionEvent.findPointerIndex(this.m);
        if (iFindPointerIndex2 >= 0 && iFindPointerIndex3 >= 0) {
            float fSqrt = (float) Math.sqrt(Math.pow(motionEvent.getX(iFindPointerIndex3) - motionEvent.getX(iFindPointerIndex2), 2.0d) + Math.pow(motionEvent.getY(iFindPointerIndex3) - motionEvent.getY(iFindPointerIndex2), 2.0d));
            float f15 = fSqrt / this.i;
            float fCenterX = this.a.centerX();
            float fCenterY = this.a.centerY();
            float fWidth = this.a.width() * f15;
            float f16 = fWidth / this.o;
            float fWidth2 = this.n.width();
            float fHeight = this.n.height();
            float f17 = fWidth2 / fHeight;
            float f18 = this.o;
            if (f17 > f18) {
                fWidth2 = fHeight * f18;
            } else {
                fHeight = fWidth2 / f18;
            }
            if (fWidth > fWidth2) {
                f16 = fWidth2 / f18;
                fWidth = fWidth2;
            }
            if (f16 > fHeight) {
                fWidth = fHeight * f18;
            } else {
                fHeight = f16;
            }
            float f19 = this.f422q;
            if (fWidth < f19) {
                fHeight = f19 / f18;
                fWidth = f19;
            }
            if (fHeight < f19) {
                fWidth = f19 * f18;
            } else {
                f19 = fHeight;
            }
            float f20 = fWidth / 2.0f;
            float f21 = fCenterX - f20;
            float f22 = f19 / 2.0f;
            float f23 = fCenterY - f22;
            float f24 = fCenterX + f20;
            float f25 = fCenterY + f22;
            RectF rectF3 = this.n;
            float f26 = rectF3.left;
            if (f21 < f26) {
                float f27 = f26 - f21;
                f21 += f27;
                f24 += f27;
            }
            float f28 = rectF3.right;
            if (f24 > f28) {
                float f29 = f24 - f28;
                f21 -= f29;
                f24 -= f29;
            }
            float f30 = rectF3.top;
            if (f23 < f30) {
                float f31 = f30 - f23;
                f23 += f31;
                f25 += f31;
            }
            float f32 = rectF3.bottom;
            if (f25 > f32) {
                float f33 = f25 - f32;
                f23 -= f33;
                f25 -= f33;
            }
            this.a.set(f21, f23, f24, f25);
            this.i = fSqrt;
            invalidate();
            j();
        }
        return true;
    }

    private boolean g(MotionEvent motionEvent) {
        this.j = false;
        this.k = false;
        this.l = -1;
        this.m = -1;
        return true;
    }

    private void h() {
        Paint paint = new Paint(1);
        this.b = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.b.setStrokeWidth(wa3.b(2.0f));
        this.b.setColor(-1);
        Paint paint2 = new Paint(1);
        this.c = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.c.setColor(Integer.MIN_VALUE);
        Paint paint3 = new Paint(1);
        this.d = paint3;
        paint3.setStyle(style);
        this.d.setStrokeWidth(wa3.b(3.0f));
        this.d.setColor(-1);
        setWillNotDraw(false);
    }

    private void i() {
        float f;
        float f2;
        float fWidth = this.n.width();
        float fHeight = this.n.height();
        if (fWidth <= 0.0f || fHeight <= 0.0f) {
            return;
        }
        float f3 = fWidth / fHeight;
        float f4 = this.o;
        if (f3 > f4) {
            f2 = fHeight * f4;
            f = fHeight;
        } else {
            f = fWidth / f4;
            f2 = fWidth;
        }
        if (f2 > fWidth) {
            f = fWidth / f4;
            f2 = fWidth;
        }
        if (f > fHeight) {
            f2 = fHeight * f4;
            f = fHeight;
        }
        float f5 = this.f422q;
        if (f2 < f5) {
            f = f5 / f4;
            f2 = f5;
        }
        if (f < f5) {
            f2 = f5 * f4;
        } else {
            f5 = f;
        }
        RectF rectF = this.n;
        float f6 = rectF.left + ((fWidth - f2) / 2.0f);
        float f7 = rectF.top + ((fHeight - f5) / 2.0f);
        this.a.set(f6, f7, f2 + f6, f5 + f7);
        j();
    }

    private void j() {
        if (this.p != null) {
            RectF rectF = this.a;
            float f = rectF.left;
            RectF rectF2 = this.n;
            this.p.a(new RectF(this.a), f - rectF2.left, rectF.top - rectF2.top, rectF.width(), this.a.height());
        }
    }

    public RectF getCropRect() {
        return new RectF(this.a);
    }

    public void k(float f, float f2, float f3, float f4) {
        this.n.set(f, f2, f3, f4);
        i();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.n.isEmpty() || this.a.isEmpty()) {
            return;
        }
        float f = this.a.top;
        RectF rectF = this.n;
        float f2 = rectF.top;
        if (f > f2) {
            canvas.drawRect(rectF.left, f2, rectF.right, f, this.c);
        }
        float f3 = this.a.bottom;
        RectF rectF2 = this.n;
        float f4 = rectF2.bottom;
        if (f3 < f4) {
            canvas.drawRect(rectF2.left, f3, rectF2.right, f4, this.c);
        }
        RectF rectF3 = this.a;
        float f5 = rectF3.left;
        float f6 = this.n.left;
        if (f5 > f6) {
            canvas.drawRect(f6, rectF3.top, f5, rectF3.bottom, this.c);
        }
        RectF rectF4 = this.a;
        float f7 = rectF4.right;
        float f8 = this.n.right;
        if (f7 < f8) {
            canvas.drawRect(f7, rectF4.top, f8, rectF4.bottom, this.c);
        }
        canvas.drawRect(this.a, this.b);
        RectF rectF5 = this.a;
        b(canvas, rectF5.left, rectF5.top, true, true);
        RectF rectF6 = this.a;
        b(canvas, rectF6.right, rectF6.top, false, true);
        RectF rectF7 = this.a;
        b(canvas, rectF7.left, rectF7.bottom, true, false);
        RectF rectF8 = this.a;
        b(canvas, rectF8.right, rectF8.bottom, false, false);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.n.isEmpty() || this.a.isEmpty()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            return e(motionEvent);
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                return f(motionEvent);
            }
            if (actionMasked != 3) {
                if (actionMasked != 5) {
                    return actionMasked != 6 ? super.onTouchEvent(motionEvent) : d(motionEvent);
                }
                return c(motionEvent);
            }
        }
        return g(motionEvent);
    }

    public void setAspectRatio(float f) {
        if (f > 0.0f) {
            this.o = f;
            a();
            invalidate();
        }
    }

    public void setOnCropChangeListener(a aVar) {
        this.p = aVar;
    }

    public VideoCropOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoCropOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new RectF();
        this.j = false;
        this.k = false;
        this.l = -1;
        this.m = -1;
        this.n = new RectF();
        this.o = 1.0f;
        this.f422q = wa3.b(50.0f);
        this.r = wa3.b(20.0f);
        h();
    }
}
