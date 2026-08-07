package com.yalantis.ucrop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import defpackage.ei2;

/* JADX INFO: loaded from: classes3.dex */
public class GestureCropImageView extends CropImageView {
    private ScaleGestureDetector J;
    private ei2 K;
    private GestureDetector L;
    private float M;
    private float N;
    private boolean O;
    private boolean P;
    private int Q;

    private class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            GestureCropImageView gestureCropImageView = GestureCropImageView.this;
            gestureCropImageView.B(gestureCropImageView.getDoubleTapTargetScale(), motionEvent.getX(), motionEvent.getY(), 200L);
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            GestureCropImageView.this.m(-f, -f2);
            return true;
        }
    }

    private class c extends ei2.b {
        private c() {
        }

        @Override // ei2.a
        public boolean a(ei2 ei2Var) {
            GestureCropImageView.this.k(ei2Var.c(), GestureCropImageView.this.M, GestureCropImageView.this.N);
            return true;
        }
    }

    private class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private d() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            GestureCropImageView.this.l(scaleGestureDetector.getScaleFactor(), GestureCropImageView.this.M, GestureCropImageView.this.N);
            return true;
        }
    }

    public GestureCropImageView(Context context) {
        super(context);
        this.O = true;
        this.P = true;
        this.Q = 5;
    }

    private void I() {
        this.L = new GestureDetector(getContext(), new b(), null, true);
        this.J = new ScaleGestureDetector(getContext(), new d());
        this.K = new ei2(new c());
    }

    public int getDoubleTapScaleSteps() {
        return this.Q;
    }

    protected float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow(getMaxScale() / getMinScale(), 1.0f / this.Q));
    }

    @Override // com.yalantis.ucrop.view.TransformImageView
    protected void i() {
        super.i();
        I();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            t();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.M = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            this.N = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        }
        this.L.onTouchEvent(motionEvent);
        if (this.P) {
            this.J.onTouchEvent(motionEvent);
        }
        if (this.O) {
            this.K.d(motionEvent);
        }
        if ((motionEvent.getAction() & 255) == 1) {
            z();
        }
        return true;
    }

    public void setDoubleTapScaleSteps(int i) {
        this.Q = i;
    }

    public void setRotateEnabled(boolean z) {
        this.O = z;
    }

    public void setScaleEnabled(boolean z) {
        this.P = z;
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O = true;
        this.P = true;
        this.Q = 5;
    }
}
