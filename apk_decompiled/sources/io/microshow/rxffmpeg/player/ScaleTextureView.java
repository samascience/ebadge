package io.microshow.rxffmpeg.player;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;

/* JADX INFO: loaded from: classes4.dex */
public class ScaleTextureView extends TextureView {
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;

    public ScaleTextureView(Context context) {
        this(context, null);
    }

    private float a(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(motionEvent.getY(0) - motionEvent.getY(1), motionEvent.getX(0) - motionEvent.getX(1)));
    }

    private float b(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a1  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.j) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.i = 1;
                this.e = motionEvent.getRawX();
                this.f = motionEvent.getRawY();
            } else if (action == 1) {
                this.i = 0;
            } else if (action == 2) {
                int i = this.i;
                if (i == 1) {
                    if (this.l) {
                        this.a = (this.a + motionEvent.getRawX()) - this.e;
                        this.b = (this.b + motionEvent.getRawY()) - this.f;
                        setTranslationX(this.a);
                        setTranslationY(this.b);
                        this.e = motionEvent.getRawX();
                        this.f = motionEvent.getRawY();
                    }
                } else if (i == 2) {
                    float fB = (this.c * b(motionEvent)) / this.g;
                    this.c = fB;
                    setScaleX(fB);
                    setScaleY(this.c);
                    if (this.k) {
                        float fA = (this.d + a(motionEvent)) - this.h;
                        this.d = fA;
                        if (fA > 360.0f) {
                            this.d = fA - 360.0f;
                        }
                        float f = this.d;
                        if (f < -360.0f) {
                            this.d = f + 360.0f;
                        }
                        setRotation(this.d);
                    }
                }
            } else if (action == 5) {
                this.i = 2;
                this.g = b(motionEvent);
                this.h = a(motionEvent);
            } else if (action == 6) {
                this.i = 0;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setEnabledRotation(boolean z) {
        this.k = z;
    }

    public void setEnabledTouch(boolean z) {
        this.j = z;
    }

    public void setEnabledTranslation(boolean z) {
        this.l = z;
    }

    public ScaleTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScaleTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 1.0f;
        this.j = true;
        this.k = true;
        this.l = true;
        setClickable(true);
    }
}
