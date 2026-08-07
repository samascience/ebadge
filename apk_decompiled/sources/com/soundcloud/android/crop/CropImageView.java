package com.soundcloud.android.crop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CropImageView extends b {
    ArrayList l;
    HighlightView m;
    Context n;
    private float o;
    private float p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f310q;
    private int r;

    public CropImageView(Context context) {
        super(context);
        this.l = new ArrayList();
    }

    private void s(HighlightView highlightView) {
        Rect rect = highlightView.b;
        float fMax = Math.max(1.0f, Math.min((getWidth() / rect.width()) * 0.6f, (getHeight() / rect.height()) * 0.6f) * getScale());
        if (Math.abs(fMax - getScale()) / fMax > 0.1d) {
            float[] fArr = {highlightView.a.centerX(), highlightView.a.centerY()};
            getUnrotatedMatrix().mapPoints(fArr);
            q(fMax, fArr[0], fArr[1], 300.0f);
        }
        t(highlightView);
    }

    private void t(HighlightView highlightView) {
        Rect rect = highlightView.b;
        int iMax = Math.max(0, getLeft() - rect.left);
        int iMin = Math.min(0, getRight() - rect.right);
        int iMax2 = Math.max(0, getTop() - rect.top);
        int iMin2 = Math.min(0, getBottom() - rect.bottom);
        if (iMax == 0) {
            iMax = iMin;
        }
        if (iMax2 == 0) {
            iMax2 = iMin2;
        }
        if (iMax == 0 && iMax2 == 0) {
            return;
        }
        j(iMax, iMax2);
    }

    @Override // com.soundcloud.android.crop.b
    public /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    @Override // com.soundcloud.android.crop.b
    public /* bridge */ /* synthetic */ Matrix getUnrotatedMatrix() {
        return super.getUnrotatedMatrix();
    }

    @Override // com.soundcloud.android.crop.b
    protected void k(float f, float f2) {
        super.k(f, f2);
        for (HighlightView highlightView : this.l) {
            highlightView.c.postTranslate(f, f2);
            highlightView.n();
        }
    }

    @Override // com.soundcloud.android.crop.b
    public /* bridge */ /* synthetic */ void m(Bitmap bitmap, boolean z) {
        super.m(bitmap, z);
    }

    @Override // com.soundcloud.android.crop.b
    public /* bridge */ /* synthetic */ void n(e eVar, boolean z) {
        super.n(eVar, z);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            ((HighlightView) it.next()).c(canvas);
        }
    }

    @Override // com.soundcloud.android.crop.b, android.view.View, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.soundcloud.android.crop.b, android.view.View, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyUp(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    @Override // com.soundcloud.android.crop.b, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.e.a() != null) {
            for (HighlightView highlightView : this.l) {
                highlightView.c.set(getUnrotatedMatrix());
                highlightView.n();
                if (highlightView.l()) {
                    s(highlightView);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (((CropImageActivity) this.n).q()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            for (HighlightView highlightView : this.l) {
                int iH = highlightView.h(motionEvent.getX(), motionEvent.getY());
                if (iH != 1) {
                    this.f310q = iH;
                    this.m = highlightView;
                    this.o = motionEvent.getX();
                    this.p = motionEvent.getY();
                    this.r = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.m.r(iH == 32 ? HighlightView.ModifyMode.Move : HighlightView.ModifyMode.Grow);
                    break;
                }
            }
        } else if (action == 1) {
            HighlightView highlightView2 = this.m;
            if (highlightView2 != null) {
                s(highlightView2);
                this.m.r(HighlightView.ModifyMode.None);
            }
            this.m = null;
            b();
        } else if (action == 2) {
            if (this.m != null && motionEvent.getPointerId(motionEvent.getActionIndex()) == this.r) {
                this.m.k(this.f310q, motionEvent.getX() - this.o, motionEvent.getY() - this.p);
                this.o = motionEvent.getX();
                this.p = motionEvent.getY();
            }
            if (getScale() == 1.0f) {
                b();
            }
        }
        return true;
    }

    @Override // com.soundcloud.android.crop.b
    protected void p(float f, float f2, float f3) {
        super.p(f, f2, f3);
        for (HighlightView highlightView : this.l) {
            highlightView.c.set(getUnrotatedMatrix());
            highlightView.n();
        }
    }

    public void r(HighlightView highlightView) {
        this.l.add(highlightView);
        invalidate();
    }

    @Override // com.soundcloud.android.crop.b, android.widget.ImageView
    public /* bridge */ /* synthetic */ void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    @Override // com.soundcloud.android.crop.b
    public /* bridge */ /* synthetic */ void setRecycler(b.c cVar) {
        super.setRecycler(cVar);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = new ArrayList();
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = new ArrayList();
    }
}
