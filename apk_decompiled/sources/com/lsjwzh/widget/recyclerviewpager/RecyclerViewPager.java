package com.lsjwzh.widget.recyclerviewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.e43;
import defpackage.h23;
import defpackage.pf3;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class RecyclerViewPager extends RecyclerView {
    private com.lsjwzh.widget.recyclerviewpager.a a;
    private float b;
    private float c;
    private float d;
    private float e;
    private List f;
    private int g;
    private int h;
    private boolean i;
    boolean j;
    float k;
    PointF l;
    boolean m;
    int n;
    int o;
    View p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f289q;
    int r;
    int s;
    int t;
    private int u;
    private boolean v;
    private boolean w;
    private float x;

    class a extends LinearSmoothScroller {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return RecyclerViewPager.this.d / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public PointF computeScrollVectorForPosition(int i) {
            if (getLayoutManager() == null) {
                return null;
            }
            return ((LinearLayoutManager) getLayoutManager()).computeScrollVectorForPosition(i);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        protected void onStop() {
            super.onStop();
            if (RecyclerViewPager.this.f != null) {
                Iterator it = RecyclerViewPager.this.f.iterator();
                while (it.hasNext()) {
                    e43.a(it.next());
                }
            }
            RecyclerViewPager.this.v = true;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            if (getLayoutManager() == null) {
                return;
            }
            int iCalculateDxToMakeVisible = calculateDxToMakeVisible(view, getHorizontalSnapPreference());
            int iCalculateDyToMakeVisible = calculateDyToMakeVisible(view, getVerticalSnapPreference());
            int leftDecorationWidth = iCalculateDxToMakeVisible > 0 ? iCalculateDxToMakeVisible - getLayoutManager().getLeftDecorationWidth(view) : iCalculateDxToMakeVisible + getLayoutManager().getRightDecorationWidth(view);
            int topDecorationHeight = iCalculateDyToMakeVisible > 0 ? iCalculateDyToMakeVisible - getLayoutManager().getTopDecorationHeight(view) : iCalculateDyToMakeVisible + getLayoutManager().getBottomDecorationHeight(view);
            int iCalculateTimeForDeceleration = calculateTimeForDeceleration((int) Math.sqrt((leftDecorationWidth * leftDecorationWidth) + (topDecorationHeight * topDecorationHeight)));
            if (iCalculateTimeForDeceleration > 0) {
                action.update(-leftDecorationWidth, -topDecorationHeight, iCalculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            RecyclerViewPager.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (RecyclerViewPager.this.g < 0 || RecyclerViewPager.this.g >= RecyclerViewPager.this.getItemCount() || RecyclerViewPager.this.f == null) {
                return;
            }
            Iterator it = RecyclerViewPager.this.f.iterator();
            while (it.hasNext()) {
                e43.a(it.next());
            }
        }
    }

    public RecyclerViewPager(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getItemCount() {
        com.lsjwzh.widget.recyclerviewpager.a aVar = this.a;
        if (aVar == null) {
            return 0;
        }
        return aVar.getItemCount();
    }

    private int i(int i, int i2) {
        if (i == 0) {
            return 0;
        }
        int i3 = i > 0 ? 1 : -1;
        return (int) (((double) i3) * Math.ceil((((i * i3) * this.c) / i2) - this.b));
    }

    private void j(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerViewPager, i, 0);
        this.c = typedArrayObtainStyledAttributes.getFloat(R$styleable.RecyclerViewPager_rvp_flingFactor, 0.15f);
        this.b = typedArrayObtainStyledAttributes.getFloat(R$styleable.RecyclerViewPager_rvp_triggerOffset, 0.25f);
        this.i = typedArrayObtainStyledAttributes.getBoolean(R$styleable.RecyclerViewPager_rvp_singlePageFling, this.i);
        this.j = typedArrayObtainStyledAttributes.getBoolean(R$styleable.RecyclerViewPager_rvp_inertia, false);
        this.d = typedArrayObtainStyledAttributes.getFloat(R$styleable.RecyclerViewPager_rvp_millisecondsPerInch, 25.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    private boolean k() {
        return h23.a(Locale.getDefault()) == 0;
    }

    private int l(int i, int i2) {
        if (i < 0) {
            return 0;
        }
        return i >= i2 ? i2 - 1 : i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && getLayoutManager() != null) {
            this.u = getLayoutManager().canScrollHorizontally() ? pf3.b(this) : pf3.d(this);
            this.x = motionEvent.getRawY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0074  */
    /* JADX WARN: Code duplicated, block: B:30:0x0077  */
    protected void f(int i) {
        View viewA;
        if (this.w) {
            i *= -1;
        }
        if (!k()) {
            i *= -1;
        }
        if (getChildCount() > 0) {
            int iB = pf3.b(this);
            int i2 = i(i, (getWidth() - getPaddingLeft()) - getPaddingRight());
            int i3 = iB + i2;
            if (this.i) {
                int iMax = Math.max(-1, Math.min(1, i2));
                i3 = iMax == 0 ? iB : this.u + iMax;
            }
            int iMin = Math.min(Math.max(i3, 0), getItemCount() - 1);
            if (iMin == iB && ((!this.i || this.u == iB) && (viewA = pf3.a(this)) != null)) {
                float f = this.e;
                float width = viewA.getWidth();
                float f2 = this.b;
                if (f <= width * f2 * f2 || iMin == 0) {
                    if (this.e < viewA.getWidth() * (-this.b) && iMin != getItemCount() - 1) {
                        if (this.w) {
                            iMin--;
                        } else {
                            iMin++;
                        }
                    }
                } else if (this.w) {
                    iMin++;
                } else {
                    iMin--;
                }
            }
            smoothScrollToPosition(l(iMin, getItemCount()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i, int i2) {
        float f = this.c;
        boolean zFling = super.fling((int) (i * f), (int) (i2 * f));
        if (zFling) {
            if (getLayoutManager().canScrollHorizontally()) {
                f(i);
            } else {
                g(i2);
            }
        }
        return zFling;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006b  */
    /* JADX WARN: Code duplicated, block: B:27:0x006e  */
    protected void g(int i) {
        View viewC;
        if (this.w) {
            i *= -1;
        }
        if (getChildCount() > 0) {
            int iD = pf3.d(this);
            int i2 = i(i, (getHeight() - getPaddingTop()) - getPaddingBottom());
            int i3 = iD + i2;
            if (this.i) {
                int iMax = Math.max(-1, Math.min(1, i2));
                i3 = iMax == 0 ? iD : this.u + iMax;
            }
            int iMin = Math.min(Math.max(i3, 0), getItemCount() - 1);
            if (iMin == iD && ((!this.i || this.u == iD) && (viewC = pf3.c(this)) != null)) {
                if (this.e <= viewC.getHeight() * this.b || iMin == 0) {
                    if (this.e < viewC.getHeight() * (-this.b) && iMin != getItemCount() - 1) {
                        if (this.w) {
                            iMin--;
                        } else {
                            iMin++;
                        }
                    }
                } else if (this.w) {
                    iMin++;
                } else {
                    iMin--;
                }
            }
            smoothScrollToPosition(l(iMin, getItemCount()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public RecyclerView.Adapter getAdapter() {
        com.lsjwzh.widget.recyclerviewpager.a aVar = this.a;
        if (aVar != null) {
            return aVar.b;
        }
        return null;
    }

    public int getCurrentPosition() {
        int iB = getLayoutManager().canScrollHorizontally() ? pf3.b(this) : pf3.d(this);
        return iB < 0 ? this.g : iB;
    }

    public float getFlingFactor() {
        return this.c;
    }

    public float getTriggerOffset() {
        return this.b;
    }

    public com.lsjwzh.widget.recyclerviewpager.a getWrapperAdapter() {
        return this.a;
    }

    public float getlLastY() {
        return this.x;
    }

    protected com.lsjwzh.widget.recyclerviewpager.a h(RecyclerView.Adapter adapter) {
        return adapter instanceof com.lsjwzh.widget.recyclerviewpager.a ? (com.lsjwzh.widget.recyclerviewpager.a) adapter : new com.lsjwzh.widget.recyclerviewpager.a(this, adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.j) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            if (this.l == null) {
                this.l = new PointF();
            }
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.l.set(rawX, rawY);
            } else if (action == 2) {
                float fSqrt = (float) Math.sqrt((rawX * rawX) + (rawY * rawY));
                PointF pointF = this.l;
                float f = pointF.x;
                float f2 = pointF.y;
                if (Math.abs(((float) Math.sqrt((f * f) + (f2 * f2))) - fSqrt) > this.k) {
                    PointF pointF2 = this.l;
                    float fAbs = Math.abs((pointF2.y - rawY) / (pointF2.x - rawX));
                    if (Math.abs(this.l.y - rawY) < 1.0f) {
                        return getLayoutManager().canScrollHorizontally();
                    }
                    if (Math.abs(this.l.x - rawX) < 1.0f) {
                        return !getLayoutManager().canScrollHorizontally();
                    }
                    return ((double) fAbs) < Math.tan(Math.toRadians(30.0d));
                }
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        try {
            Field declaredField = parcelable.getClass().getDeclaredField("mLayoutState");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(parcelable);
            Field declaredField2 = obj.getClass().getDeclaredField("mAnchorOffset");
            Field declaredField3 = obj.getClass().getDeclaredField("mAnchorPosition");
            declaredField3.setAccessible(true);
            declaredField2.setAccessible(true);
            if (declaredField2.getInt(obj) > 0) {
                declaredField3.set(obj, Integer.valueOf(declaredField3.getInt(obj) - 1));
            } else if (declaredField2.getInt(obj) < 0) {
                declaredField3.set(obj, Integer.valueOf(declaredField3.getInt(obj) + 1));
            }
            declaredField2.setInt(obj, 0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* JADX WARN: Code duplicated, block: B:63:0x0120  */
    /* JADX WARN: Code duplicated, block: B:64:0x0123  */
    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
        if (i == 1) {
            this.m = true;
            View viewA = getLayoutManager().canScrollHorizontally() ? pf3.a(this) : pf3.c(this);
            this.p = viewA;
            if (viewA != null) {
                if (this.v) {
                    this.h = getChildLayoutPosition(viewA);
                    this.v = false;
                }
                this.n = this.p.getLeft();
                this.o = this.p.getTop();
            } else {
                this.h = -1;
            }
            this.e = 0.0f;
            return;
        }
        if (i == 2) {
            this.m = false;
            if (this.p == null) {
                this.e = 0.0f;
            } else if (getLayoutManager().canScrollHorizontally()) {
                this.e = this.p.getLeft() - this.n;
            } else {
                this.e = this.p.getTop() - this.o;
            }
            this.p = null;
            return;
        }
        if (i == 0) {
            if (this.m) {
                int iB = getLayoutManager().canScrollHorizontally() ? pf3.b(this) : pf3.d(this);
                View view = this.p;
                if (view != null) {
                    iB = getChildAdapterPosition(view);
                    if (getLayoutManager().canScrollHorizontally()) {
                        boolean zK = k();
                        float left = this.p.getLeft() - this.n;
                        if (left <= this.p.getWidth() * this.b || this.p.getLeft() < this.f289q) {
                            if (left < this.p.getWidth() * (-this.b) && this.p.getLeft() <= this.r) {
                                if (this.w) {
                                    iB++;
                                } else {
                                    iB++;
                                }
                            }
                        } else if (this.w ? !zK : zK) {
                            iB--;
                        } else {
                            iB++;
                        }
                    } else {
                        float top = this.p.getTop() - this.o;
                        if (top <= this.p.getHeight() * this.b || this.p.getTop() < this.s) {
                            if (top < this.p.getHeight() * (-this.b) && this.p.getTop() <= this.t) {
                                if (this.w) {
                                    iB--;
                                } else {
                                    iB++;
                                }
                            }
                        } else if (this.w) {
                            iB++;
                        } else {
                            iB--;
                        }
                    }
                }
                smoothScrollToPosition(l(iB, getItemCount()));
                this.p = null;
            } else {
                int i2 = this.g;
                if (i2 != this.h) {
                    this.h = i2;
                }
            }
            this.f289q = Integer.MIN_VALUE;
            this.r = Integer.MAX_VALUE;
            this.s = Integer.MIN_VALUE;
            this.t = Integer.MAX_VALUE;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View view;
        if (motionEvent.getAction() == 2 && (view = this.p) != null) {
            this.f289q = Math.max(view.getLeft(), this.f289q);
            this.s = Math.max(this.p.getTop(), this.s);
            this.r = Math.min(this.p.getLeft(), this.r);
            this.t = Math.min(this.p.getTop(), this.t);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i) {
        this.h = getCurrentPosition();
        this.g = i;
        super.scrollToPosition(i);
        getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        com.lsjwzh.widget.recyclerviewpager.a aVarH = h(adapter);
        this.a = aVarH;
        super.setAdapter(aVarH);
    }

    public void setFlingFactor(float f) {
        this.c = f;
    }

    public void setInertia(boolean z) {
        this.j = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        if (layoutManager instanceof LinearLayoutManager) {
            this.w = ((LinearLayoutManager) layoutManager).getReverseLayout();
        }
    }

    public void setSinglePageFling(boolean z) {
        this.i = z;
    }

    public void setTriggerOffset(float f) {
        this.b = f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollToPosition(int i) {
        if (this.h < 0) {
            this.h = getCurrentPosition();
        }
        this.g = i;
        if (getLayoutManager() == null || !(getLayoutManager() instanceof LinearLayoutManager)) {
            super.smoothScrollToPosition(i);
            return;
        }
        a aVar = new a(getContext());
        aVar.setTargetPosition(i);
        if (i == -1) {
            return;
        }
        getLayoutManager().startSmoothScroll(aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void swapAdapter(RecyclerView.Adapter adapter, boolean z) {
        com.lsjwzh.widget.recyclerviewpager.a aVarH = h(adapter);
        this.a = aVarH;
        super.swapAdapter(aVarH, z);
    }

    public RecyclerViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0.25f;
        this.c = 0.15f;
        this.d = 25.0f;
        this.g = -1;
        this.h = -1;
        this.f289q = Integer.MIN_VALUE;
        this.r = Integer.MAX_VALUE;
        this.s = Integer.MIN_VALUE;
        this.t = Integer.MAX_VALUE;
        this.u = -1;
        this.v = true;
        this.w = false;
        j(context, attributeSet, i);
        setNestedScrollingEnabled(false);
        this.k = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
