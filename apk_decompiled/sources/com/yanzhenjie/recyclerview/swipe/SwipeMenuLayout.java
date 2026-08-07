package com.yanzhenjie.recyclerview.swipe;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.TextView;
import defpackage.be3;
import defpackage.py2;

/* JADX INFO: loaded from: classes.dex */
public class SwipeMenuLayout extends FrameLayout implements py2 {
    private int a;
    private int b;
    private int c;
    private float d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private View k;
    private c l;
    private e m;
    private b n;
    private boolean o;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f319q;
    private OverScroller r;
    private VelocityTracker s;
    private int t;
    private int u;

    public SwipeMenuLayout(Context context) {
        this(context, null);
    }

    private int d(MotionEvent motionEvent, int i) {
        int x = (int) (motionEvent.getX() - getScrollX());
        int iG = this.n.g();
        int i2 = iG / 2;
        float f = iG;
        float f2 = i2;
        return Math.min(i > 0 ? Math.round(Math.abs((f2 + (c(Math.min(1.0f, (Math.abs(x) * 1.0f) / f)) * f2)) / i) * 1000.0f) * 4 : (int) (((Math.abs(x) / f) + 1.0f) * 100.0f), this.e);
    }

    private void o(int i, int i2) {
        if (this.n != null) {
            if (Math.abs(getScrollX()) < this.n.f().getWidth() * this.d) {
                b();
                return;
            }
            if (Math.abs(i) > this.f || Math.abs(i2) > this.f) {
                if (j()) {
                    b();
                    return;
                } else {
                    q();
                    return;
                }
            }
            if (a()) {
                b();
            } else {
                q();
            }
        }
    }

    private void r(int i) {
        b bVar = this.n;
        if (bVar != null) {
            bVar.b(this.r, getScrollX(), i);
            invalidate();
        }
    }

    @Override // defpackage.py2
    public boolean a() {
        return h() || l();
    }

    @Override // defpackage.py2
    public void b() {
        p(this.e);
    }

    float c(float f) {
        return (float) Math.sin((float) (((double) (f - 0.5f)) * 0.4712389167638204d));
    }

    @Override // android.view.View
    public void computeScroll() {
        b bVar;
        if (!this.r.computeScrollOffset() || (bVar = this.n) == null) {
            return;
        }
        if (bVar instanceof e) {
            scrollTo(Math.abs(this.r.getCurrX()), 0);
            invalidate();
        } else {
            scrollTo(-Math.abs(this.r.getCurrX()), 0);
            invalidate();
        }
    }

    public boolean e() {
        c cVar = this.l;
        return cVar != null && cVar.c();
    }

    public boolean f() {
        e eVar = this.m;
        return eVar != null && eVar.c();
    }

    public boolean g() {
        c cVar = this.l;
        return (cVar == null || cVar.i(getScrollX())) ? false : true;
    }

    public float getOpenPercent() {
        return this.d;
    }

    public boolean h() {
        c cVar = this.l;
        return cVar != null && cVar.j(getScrollX());
    }

    public boolean i() {
        c cVar = this.l;
        return cVar != null && cVar.k(getScrollX());
    }

    public boolean j() {
        return i() || m();
    }

    public boolean k() {
        e eVar = this.m;
        return (eVar == null || eVar.i(getScrollX())) ? false : true;
    }

    public boolean l() {
        e eVar = this.m;
        return eVar != null && eVar.j(getScrollX());
    }

    public boolean m() {
        e eVar = this.m;
        return eVar != null && eVar.k(getScrollX());
    }

    public boolean n() {
        return this.f319q;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i = this.a;
        if (i != 0 && this.l == null) {
            this.l = new c(findViewById(i));
        }
        int i2 = this.c;
        if (i2 != 0 && this.m == null) {
            this.m = new e(findViewById(i2));
        }
        int i3 = this.b;
        if (i3 != 0 && this.k == null) {
            this.k = findViewById(i3);
            return;
        }
        TextView textView = new TextView(getContext());
        textView.setClickable(true);
        textView.setGravity(17);
        textView.setTextSize(16.0f);
        textView.setText("You may not have set the ContentView.");
        this.k = textView;
        addView(textView);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            int x = (int) motionEvent.getX();
            this.g = x;
            this.i = x;
            this.j = (int) motionEvent.getY();
            return false;
        }
        if (action == 1) {
            b bVar = this.n;
            boolean z = bVar != null && bVar.h(getWidth(), motionEvent.getX());
            if (!a() || !z) {
                return false;
            }
            b();
            return true;
        }
        if (action == 2) {
            int x2 = (int) (motionEvent.getX() - this.i);
            return Math.abs(x2) > this.f && Math.abs(x2) > Math.abs((int) (motionEvent.getY() - ((float) this.j)));
        }
        if (action != 3) {
            return zOnInterceptTouchEvent;
        }
        if (!this.r.isFinished()) {
            this.r.abortAnimation();
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view = this.k;
        if (view != null) {
            int measuredWidthAndState = view.getMeasuredWidthAndState();
            int measuredHeightAndState = this.k.getMeasuredHeightAndState();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.k.getLayoutParams();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop() + layoutParams.topMargin;
            this.k.layout(paddingLeft, paddingTop, measuredWidthAndState + paddingLeft, measuredHeightAndState + paddingTop);
        }
        c cVar = this.l;
        if (cVar != null) {
            View viewF = cVar.f();
            int measuredWidthAndState2 = viewF.getMeasuredWidthAndState();
            int measuredHeightAndState2 = viewF.getMeasuredHeightAndState();
            int paddingTop2 = getPaddingTop() + ((FrameLayout.LayoutParams) viewF.getLayoutParams()).topMargin;
            viewF.layout(-measuredWidthAndState2, paddingTop2, 0, measuredHeightAndState2 + paddingTop2);
        }
        e eVar = this.m;
        if (eVar != null) {
            View viewF2 = eVar.f();
            int measuredWidthAndState3 = viewF2.getMeasuredWidthAndState();
            int measuredHeightAndState3 = viewF2.getMeasuredHeightAndState();
            int paddingTop3 = getPaddingTop() + ((FrameLayout.LayoutParams) viewF2.getLayoutParams()).topMargin;
            int measuredWidthAndState4 = getMeasuredWidthAndState();
            viewF2.layout(measuredWidthAndState4, paddingTop3, measuredWidthAndState3 + measuredWidthAndState4, measuredHeightAndState3 + paddingTop3);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        super.onMeasure(i, i2);
        View view = this.k;
        if (view != null) {
            measureChildWithMargins(view, i, 0, i2, 0);
            measuredHeight = this.k.getMeasuredHeight();
        } else {
            measuredHeight = 0;
        }
        c cVar = this.l;
        if (cVar != null) {
            View viewF = cVar.f();
            viewF.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(measuredHeight == 0 ? viewF.getMeasuredHeightAndState() : measuredHeight, 1073741824));
        }
        e eVar = this.m;
        if (eVar != null) {
            View viewF2 = eVar.f();
            viewF2.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(measuredHeight == 0 ? viewF2.getMeasuredHeightAndState() : measuredHeight, 1073741824));
        }
        if (measuredHeight > 0) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), measuredHeight);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.s == null) {
            this.s = VelocityTracker.obtain();
        }
        this.s.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.g = (int) motionEvent.getX();
            this.h = (int) motionEvent.getY();
        } else if (action == 1) {
            int x = (int) (this.i - motionEvent.getX());
            int y = (int) (this.j - motionEvent.getY());
            this.p = false;
            this.s.computeCurrentVelocity(1000, this.u);
            int xVelocity = (int) this.s.getXVelocity();
            int iAbs = Math.abs(xVelocity);
            if (iAbs <= this.t) {
                o(x, y);
            } else if (this.n != null) {
                int iD = d(motionEvent, iAbs);
                if (this.n instanceof e) {
                    if (xVelocity < 0) {
                        r(iD);
                    } else {
                        p(iD);
                    }
                } else if (xVelocity > 0) {
                    r(iD);
                } else {
                    p(iD);
                }
                be3.g0(this);
            }
            this.s.clear();
            this.s.recycle();
            this.s = null;
            if (Math.abs(this.i - motionEvent.getX()) > this.f || Math.abs(this.j - motionEvent.getY()) > this.f || h() || l()) {
                motionEvent.setAction(3);
                super.onTouchEvent(motionEvent);
                return true;
            }
        } else if (action != 2) {
            if (action == 3) {
                this.p = false;
                if (this.r.isFinished()) {
                    o((int) (this.i - motionEvent.getX()), (int) (this.j - motionEvent.getY()));
                } else {
                    this.r.abortAnimation();
                }
            }
        } else if (n()) {
            int x2 = (int) (this.g - motionEvent.getX());
            int y2 = (int) (this.h - motionEvent.getY());
            if (!this.p && Math.abs(x2) > this.f && Math.abs(x2) > Math.abs(y2)) {
                this.p = true;
            }
            if (this.p) {
                if (this.n == null || this.o) {
                    if (x2 < 0) {
                        c cVar = this.l;
                        if (cVar != null) {
                            this.n = cVar;
                        } else {
                            this.n = this.m;
                        }
                    } else {
                        e eVar = this.m;
                        if (eVar != null) {
                            this.n = eVar;
                        } else {
                            this.n = this.l;
                        }
                    }
                }
                scrollBy(x2, 0);
                this.g = (int) motionEvent.getX();
                this.h = (int) motionEvent.getY();
                this.o = false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p(int i) {
        b bVar = this.n;
        if (bVar != null) {
            bVar.a(this.r, getScrollX(), i);
            invalidate();
        }
    }

    public void q() {
        r(this.e);
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        b bVar = this.n;
        if (bVar == null) {
            super.scrollTo(i, i2);
            return;
        }
        b.a aVarD = bVar.d(i, i2);
        this.o = aVarD.c;
        if (aVarD.a != getScrollX()) {
            super.scrollTo(aVarD.a, aVarD.b);
        }
    }

    public void setOpenPercent(float f) {
        this.d = f;
    }

    public void setScrollerDuration(int i) {
        this.e = i;
    }

    public void setSwipeEnable(boolean z) {
        this.f319q = z;
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0.5f;
        this.e = 200;
        this.f319q = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.recycler_swipe_SwipeMenuLayout);
        this.a = typedArrayObtainStyledAttributes.getResourceId(R$styleable.recycler_swipe_SwipeMenuLayout_leftViewId, this.a);
        this.b = typedArrayObtainStyledAttributes.getResourceId(R$styleable.recycler_swipe_SwipeMenuLayout_contentViewId, this.b);
        this.c = typedArrayObtainStyledAttributes.getResourceId(R$styleable.recycler_swipe_SwipeMenuLayout_rightViewId, this.c);
        typedArrayObtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f = viewConfiguration.getScaledTouchSlop();
        this.t = viewConfiguration.getScaledMinimumFlingVelocity();
        this.u = viewConfiguration.getScaledMaximumFlingVelocity();
        this.r = new OverScroller(getContext());
    }
}
