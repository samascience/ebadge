package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public class c extends ImageView {
    final String a;
    public boolean b;
    private Matrix c;
    private Matrix d;
    private int e;
    private float f;
    private float g;
    private Bitmap h;
    private boolean i;
    private float j;
    private float k;
    private PointF l;
    private PointF m;
    private float n;
    private float o;
    private Rect p;

    public c(Context context) {
        super(context);
        this.c = new Matrix();
        this.d = new Matrix();
        this.e = 0;
        this.f = 1.0f;
        this.g = 1.0f;
        this.i = false;
        this.a = "TouchView";
        this.l = new PointF();
        this.m = new PointF();
        this.n = 1.0f;
        this.o = 0.0f;
        this.b = false;
        Rect rect = new Rect();
        this.p = rect;
        getDrawingRect(rect);
        a();
    }

    private void a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        boolean z;
        Animation translateAnimation;
        if (this.h == null) {
            return;
        }
        float fWidth = this.p.width();
        float fHeight = this.p.height();
        float[] fArr = new float[9];
        this.c.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float f4 = this.f;
        if (f3 > f4) {
            float f5 = f4 / f3;
            this.o = f5;
            Matrix matrix = this.c;
            PointF pointF = this.m;
            matrix.postScale(f5, f5, pointF.x, pointF.y);
            setImageMatrix(this.c);
            float f6 = this.o;
            float f7 = 1.0f / f6;
            float f8 = 1.0f / f6;
            PointF pointF2 = this.m;
            translateAnimation = new ScaleAnimation(f7, 1.0f, f8, 1.0f, pointF2.x, pointF2.y);
        } else {
            float f9 = this.g;
            if (f3 < f9) {
                float f10 = f9 / f3;
                this.o = f10;
                Matrix matrix2 = this.c;
                PointF pointF3 = this.m;
                matrix2.postScale(f10, f10, pointF3.x, pointF3.y);
                float f11 = this.o;
                PointF pointF4 = this.m;
                translateAnimation = new ScaleAnimation(1.0f, f11, 1.0f, f11, pointF4.x, pointF4.y);
            } else {
                float width = this.h.getWidth() * f3;
                float height = this.h.getHeight() * f3;
                Rect rect = this.p;
                int i = rect.left;
                float f12 = i - f;
                int i2 = rect.top;
                float f13 = i2 - f2;
                if (f12 < 0.0f) {
                    f = i;
                    z = true;
                } else {
                    z = false;
                }
                if (f13 < 0.0f) {
                    f2 = i2;
                    z = true;
                }
                float f14 = height - f13;
                if (width - f12 < fWidth) {
                    f = i - (width - fWidth);
                    z = true;
                }
                if (f14 < fHeight) {
                    f2 = i2 - (height - fHeight);
                    z = true;
                }
                if (z) {
                    float f15 = fArr[2] - f;
                    float f16 = fArr[5] - f2;
                    fArr[2] = f;
                    fArr[5] = f2;
                    this.c.setValues(fArr);
                    setImageMatrix(this.c);
                    translateAnimation = new TranslateAnimation(f15, 0.0f, f16, 0.0f);
                } else {
                    setImageMatrix(this.c);
                    translateAnimation = null;
                }
            }
        }
        if (translateAnimation != null) {
            this.i = true;
            translateAnimation.setDuration(300L);
            startAnimation(translateAnimation);
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    c.this.post(new Runnable() { // from class: com.tencent.connect.avatar.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.clearAnimation();
                            c.this.b();
                        }
                    });
                    c.this.i = false;
                }
            }).start();
        }
    }

    private void c() {
        if (this.h == null) {
            return;
        }
        float[] fArr = {fMax, 0.0f, this.j, 0.0f, fMax, height, 0.0f, 0.0f, 0.0f};
        this.c.getValues(fArr);
        float fMax = Math.max(this.p.width() / this.h.getWidth(), this.p.height() / this.h.getHeight());
        this.j = this.p.left - (((this.h.getWidth() * fMax) - this.p.width()) / 2.0f);
        float height = this.p.top - (((this.h.getHeight() * fMax) - this.p.height()) / 2.0f);
        this.k = height;
        this.c.setValues(fArr);
        float fMin = Math.min(2048.0f / this.h.getWidth(), 2048.0f / this.h.getHeight());
        this.f = fMin;
        this.g = fMax;
        if (fMin < fMax) {
            this.f = fMax;
        }
        setImageMatrix(this.c);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0089  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.i) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.c.set(getImageMatrix());
            this.d.set(this.c);
            this.l.set(motionEvent.getX(), motionEvent.getY());
            this.e = 1;
        } else if (action == 1) {
            b();
            this.e = 0;
        } else if (action == 2) {
            int i = this.e;
            if (i == 1) {
                this.c.set(this.d);
                this.c.postTranslate(motionEvent.getX() - this.l.x, motionEvent.getY() - this.l.y);
                setImageMatrix(this.c);
            } else if (i == 2) {
                Matrix matrix = this.c;
                matrix.set(matrix);
                float fA = a(motionEvent);
                if (fA > 10.0f) {
                    this.c.set(this.d);
                    float f = fA / this.n;
                    Matrix matrix2 = this.c;
                    PointF pointF = this.m;
                    matrix2.postScale(f, f, pointF.x, pointF.y);
                }
                setImageMatrix(this.c);
            }
        } else if (action == 5) {
            float fA2 = a(motionEvent);
            this.n = fA2;
            if (fA2 > 10.0f) {
                this.d.set(this.c);
                a(this.m);
                this.e = 2;
            }
        } else if (action == 6) {
            b();
            this.e = 0;
        }
        this.b = true;
        return true;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.h = bitmap;
        if (bitmap != null) {
            this.h = bitmap;
        }
    }

    private float a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void a(Rect rect) {
        this.p = rect;
        if (this.h != null) {
            c();
        }
    }

    private void a(PointF pointF) {
        if (this.h == null) {
            return;
        }
        float[] fArr = new float[9];
        this.c.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float width = this.h.getWidth() * f3;
        float height = this.h.getHeight() * f3;
        Rect rect = this.p;
        float f4 = rect.left - f;
        if (f4 <= 1.0f) {
            f4 = 1.0f;
        }
        float f5 = (f + width) - rect.right;
        if (f5 <= 1.0f) {
            f5 = 1.0f;
        }
        float fWidth = (rect.width() * f4) / (f5 + f4);
        Rect rect2 = this.p;
        float f6 = fWidth + rect2.left;
        float f7 = rect2.top - f2;
        float f8 = (f2 + height) - rect2.bottom;
        if (f7 <= 1.0f) {
            f7 = 1.0f;
        }
        pointF.set(f6, ((rect2.height() * f7) / ((f8 > 1.0f ? f8 : 1.0f) + f7)) + this.p.top);
    }
}
