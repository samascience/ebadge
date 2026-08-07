package com.github.clans.fab;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class Label extends TextView {
    private static final Xfermode s = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    private int a;
    private int b;
    private int c;
    private int d;
    private Drawable e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private FloatingActionButton m;
    private Animation n;
    private Animation o;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f233q;
    GestureDetector r;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setOval(0, 0, view.getWidth(), view.getHeight());
        }
    }

    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            Label.this.s();
            if (Label.this.m != null) {
                Label.this.m.z();
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            Label.this.t();
            if (Label.this.m != null) {
                Label.this.m.A();
            }
            return super.onSingleTapUp(motionEvent);
        }
    }

    private class c extends Drawable {
        private Paint a;
        private Paint b;

        /* synthetic */ c(Label label, a aVar) {
            this();
        }

        private void a() {
            Label.this.setLayerType(1, null);
            this.a.setStyle(Paint.Style.FILL);
            this.a.setColor(Label.this.i);
            this.b.setXfermode(Label.s);
            if (Label.this.isInEditMode()) {
                return;
            }
            this.a.setShadowLayer(Label.this.a, Label.this.b, Label.this.c, Label.this.d);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            RectF rectF = new RectF(Label.this.a + Math.abs(Label.this.b), Label.this.a + Math.abs(Label.this.c), Label.this.g, Label.this.h);
            canvas.drawRoundRect(rectF, Label.this.l, Label.this.l, this.a);
            canvas.drawRoundRect(rectF, Label.this.l, Label.this.l, this.b);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        private c() {
            this.a = new Paint(1);
            this.b = new Paint(1);
            a();
        }
    }

    public Label(Context context) {
        super(context);
        this.f = true;
        this.f233q = true;
        this.r = new GestureDetector(getContext(), new b());
    }

    private int k() {
        if (this.h == 0) {
            this.h = getMeasuredHeight();
        }
        return getMeasuredHeight() + m();
    }

    private int l() {
        if (this.g == 0) {
            this.g = getMeasuredWidth();
        }
        return getMeasuredWidth() + n();
    }

    private Drawable o() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, p(this.j));
        stateListDrawable.addState(new int[0], p(this.i));
        if (!com.github.clans.fab.a.c()) {
            this.e = stateListDrawable;
            return stateListDrawable;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{this.k}), stateListDrawable, null);
        setOutlineProvider(new a());
        setClipToOutline(true);
        this.e = rippleDrawable;
        return rippleDrawable;
    }

    private Drawable p(int i) {
        int i2 = this.l;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{i2, i2, i2, i2, i2, i2, i2, i2}, null, null));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    @TargetApi(21)
    private void setBackgroundCompat(Drawable drawable) {
        if (com.github.clans.fab.a.b()) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    private void setShadow(FloatingActionButton floatingActionButton) {
        this.d = floatingActionButton.getShadowColor();
        this.a = floatingActionButton.getShadowRadius();
        this.b = floatingActionButton.getShadowXOffset();
        this.c = floatingActionButton.getShadowYOffset();
        this.f = floatingActionButton.t();
    }

    private void u() {
        if (this.o != null) {
            this.n.cancel();
            startAnimation(this.o);
        }
    }

    private void v() {
        if (this.n != null) {
            this.o.cancel();
            startAnimation(this.n);
        }
    }

    int m() {
        if (this.f) {
            return this.a + Math.abs(this.c);
        }
        return 0;
    }

    int n() {
        if (this.f) {
            return this.a + Math.abs(this.b);
        }
        return 0;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(l(), k());
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        FloatingActionButton floatingActionButton = this.m;
        if (floatingActionButton == null || floatingActionButton.getOnClickListener() == null || !this.m.isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            t();
            this.m.A();
        }
        this.r.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    void q(boolean z) {
        if (z) {
            u();
        }
        setVisibility(4);
    }

    boolean r() {
        return this.f233q;
    }

    void s() {
        if (this.p) {
            this.e = getBackground();
        }
        Drawable drawable = this.e;
        if (drawable instanceof StateListDrawable) {
            ((StateListDrawable) drawable).setState(new int[]{R.attr.state_pressed});
            return;
        }
        if (com.github.clans.fab.a.c()) {
            Drawable drawable2 = this.e;
            if (drawable2 instanceof RippleDrawable) {
                RippleDrawable rippleDrawable = (RippleDrawable) drawable2;
                rippleDrawable.setState(new int[]{R.attr.state_enabled, R.attr.state_pressed});
                rippleDrawable.setHotspot(getMeasuredWidth() / 2, getMeasuredHeight() / 2);
                rippleDrawable.setVisible(true, true);
            }
        }
    }

    void setCornerRadius(int i) {
        this.l = i;
    }

    void setFab(FloatingActionButton floatingActionButton) {
        this.m = floatingActionButton;
        setShadow(floatingActionButton);
    }

    void setHandleVisibilityChanges(boolean z) {
        this.f233q = z;
    }

    void setHideAnimation(Animation animation) {
        this.o = animation;
    }

    void setShowAnimation(Animation animation) {
        this.n = animation;
    }

    void setShowShadow(boolean z) {
        this.f = z;
    }

    void setUsingStyle(boolean z) {
        this.p = z;
    }

    void t() {
        if (this.p) {
            this.e = getBackground();
        }
        Drawable drawable = this.e;
        if (drawable instanceof StateListDrawable) {
            ((StateListDrawable) drawable).setState(new int[0]);
            return;
        }
        if (com.github.clans.fab.a.c()) {
            Drawable drawable2 = this.e;
            if (drawable2 instanceof RippleDrawable) {
                RippleDrawable rippleDrawable = (RippleDrawable) drawable2;
                rippleDrawable.setState(new int[0]);
                rippleDrawable.setHotspot(getMeasuredWidth() / 2, getMeasuredHeight() / 2);
                rippleDrawable.setVisible(true, true);
            }
        }
    }

    void w(int i, int i2, int i3) {
        this.i = i;
        this.j = i2;
        this.k = i3;
    }

    void x(boolean z) {
        if (z) {
            v();
        }
        setVisibility(0);
    }

    void y() {
        LayerDrawable layerDrawable;
        if (this.f) {
            layerDrawable = new LayerDrawable(new Drawable[]{new c(this, null), o()});
            layerDrawable.setLayerInset(1, this.a + Math.abs(this.b), this.a + Math.abs(this.c), this.a + Math.abs(this.b), this.a + Math.abs(this.c));
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{o()});
        }
        setBackgroundCompat(layerDrawable);
    }

    public Label(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = true;
        this.f233q = true;
        this.r = new GestureDetector(getContext(), new b());
    }

    public Label(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = true;
        this.f233q = true;
        this.r = new GestureDetector(getContext(), new b());
    }
}
