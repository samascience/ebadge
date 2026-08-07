package androidx.slidingpanelayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.customview.view.AbsSavedState;
import defpackage.be3;
import defpackage.fe3;
import defpackage.m2;
import defpackage.q30;
import defpackage.t1;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SlidingPaneLayout extends ViewGroup {
    private int a;
    private int b;
    private Drawable c;
    private Drawable d;
    private final int e;
    private boolean f;
    View g;
    float h;
    private float i;
    int j;
    boolean k;
    private int l;
    private float m;
    private float n;
    final fe3 o;
    boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f200q;
    private final Rect r;
    final ArrayList s;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean a;

        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a ? 1 : 0);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt() != 0;
        }
    }

    class a extends t1 {
        private final Rect a = new Rect();

        a() {
        }

        private void c(m2 m2Var, m2 m2Var2) {
            Rect rect = this.a;
            m2Var2.k(rect);
            m2Var.e0(rect);
            m2Var2.l(rect);
            m2Var.f0(rect);
            m2Var.O0(m2Var2.V());
            m2Var.z0(m2Var2.x());
            m2Var.j0(m2Var2.o());
            m2Var.n0(m2Var2.s());
            m2Var.p0(m2Var2.K());
            m2Var.k0(m2Var2.I());
            m2Var.r0(m2Var2.L());
            m2Var.s0(m2Var2.M());
            m2Var.c0(m2Var2.F());
            m2Var.H0(m2Var2.S());
            m2Var.w0(m2Var2.P());
            m2Var.a(m2Var2.i());
            m2Var.y0(m2Var2.w());
        }

        public boolean d(View view) {
            return SlidingPaneLayout.this.h(view);
        }

        @Override // defpackage.t1
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        @Override // defpackage.t1
        public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
            m2 m2VarX = m2.X(m2Var);
            super.onInitializeAccessibilityNodeInfo(view, m2VarX);
            c(m2Var, m2VarX);
            m2VarX.a0();
            m2Var.j0(SlidingPaneLayout.class.getName());
            m2Var.J0(view);
            Object objG = be3.G(view);
            if (objG instanceof View) {
                m2Var.B0((View) objG);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!d(childAt) && childAt.getVisibility() == 0) {
                    be3.z0(childAt, 1);
                    m2Var.c(childAt);
                }
            }
        }

        @Override // defpackage.t1
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (d(view)) {
                return false;
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
    }

    private class b implements Runnable {
        final View a;

        b(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.getParent() == SlidingPaneLayout.this) {
                this.a.setLayerType(0, null);
                SlidingPaneLayout.this.g(this.a);
            }
            SlidingPaneLayout.this.s.remove(this);
        }
    }

    private class c extends fe3.c {
        c() {
        }

        @Override // fe3.c
        public int a(View view, int i, int i2) {
            d dVar = (d) SlidingPaneLayout.this.g.getLayoutParams();
            if (SlidingPaneLayout.this.i()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) dVar).rightMargin) + SlidingPaneLayout.this.g.getWidth());
                return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.j);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin;
            return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.j + paddingLeft);
        }

        @Override // fe3.c
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // fe3.c
        public int d(View view) {
            return SlidingPaneLayout.this.j;
        }

        @Override // fe3.c
        public void f(int i, int i2) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            slidingPaneLayout.o.c(slidingPaneLayout.g, i2);
        }

        @Override // fe3.c
        public void i(View view, int i) {
            SlidingPaneLayout.this.p();
        }

        @Override // fe3.c
        public void j(int i) {
            if (SlidingPaneLayout.this.o.B() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.h != 0.0f) {
                    slidingPaneLayout.e(slidingPaneLayout.g);
                    SlidingPaneLayout.this.p = true;
                } else {
                    slidingPaneLayout.r(slidingPaneLayout.g);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.d(slidingPaneLayout2.g);
                    SlidingPaneLayout.this.p = false;
                }
            }
        }

        @Override // fe3.c
        public void k(View view, int i, int i2, int i3, int i4) {
            SlidingPaneLayout.this.l(i);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // fe3.c
        public void l(View view, float f, float f2) {
            int paddingLeft;
            d dVar = (d) view.getLayoutParams();
            if (SlidingPaneLayout.this.i()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) dVar).rightMargin;
                if (f < 0.0f || (f == 0.0f && SlidingPaneLayout.this.h > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.j;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.g.getWidth();
            } else {
                paddingLeft = ((ViewGroup.MarginLayoutParams) dVar).leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && SlidingPaneLayout.this.h > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.j;
                }
            }
            SlidingPaneLayout.this.o.P(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // fe3.c
        public boolean m(View view, int i) {
            if (SlidingPaneLayout.this.k) {
                return false;
            }
            return ((d) view.getLayoutParams()).b;
        }
    }

    public interface e {
    }

    public SlidingPaneLayout(Context context) {
        this(context, null);
    }

    private boolean b(View view, int i) {
        if (!this.f200q && !q(0.0f, i)) {
            return false;
        }
        this.p = false;
        return true;
    }

    private void c(View view, float f, int i) {
        d dVar = (d) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) ((((-16777216) & i) >>> 24) * f)) << 24) | (i & 16777215);
            if (dVar.d == null) {
                dVar.d = new Paint();
            }
            dVar.d.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, dVar.d);
            }
            g(view);
            return;
        }
        if (view.getLayerType() != 0) {
            Paint paint = dVar.d;
            if (paint != null) {
                paint.setColorFilter(null);
            }
            b bVar = new b(view);
            this.s.add(bVar);
            be3.h0(this, bVar);
        }
    }

    private boolean n(View view, int i) {
        if (!this.f200q && !q(1.0f, i)) {
            return false;
        }
        this.p = true;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    private void o(float f) {
        boolean z;
        boolean zI = i();
        d dVar = (d) this.g.getLayoutParams();
        if (!dVar.c) {
            z = false;
        } else if ((zI ? ((ViewGroup.MarginLayoutParams) dVar).rightMargin : ((ViewGroup.MarginLayoutParams) dVar).leftMargin) <= 0) {
            z = true;
        } else {
            z = false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != this.g) {
                float f2 = 1.0f - this.i;
                int i2 = this.l;
                this.i = f;
                int i3 = ((int) (f2 * i2)) - ((int) ((1.0f - f) * i2));
                if (zI) {
                    i3 = -i3;
                }
                childAt.offsetLeftAndRight(i3);
                if (z) {
                    float f3 = this.i;
                    c(childAt, zI ? f3 - 1.0f : 1.0f - f3, this.b);
                }
            }
        }
    }

    private static boolean s(View view) {
        return view.isOpaque();
    }

    public boolean a() {
        return b(this.g, 0);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.o.n(true)) {
            if (this.f) {
                be3.g0(this);
            } else {
                this.o.a();
            }
        }
    }

    void d(View view) {
        sendAccessibilityEvent(32);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i;
        int right;
        super.draw(canvas);
        Drawable drawable = i() ? this.d : this.c;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (i()) {
            right = childAt.getRight();
            i = intrinsicWidth + right;
        } else {
            int left = childAt.getLeft();
            int i2 = left - intrinsicWidth;
            i = left;
            right = i2;
        }
        drawable.setBounds(right, top, i, bottom);
        drawable.draw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        d dVar = (d) view.getLayoutParams();
        int iSave = canvas.save();
        if (this.f && !dVar.b && this.g != null) {
            canvas.getClipBounds(this.r);
            if (i()) {
                Rect rect = this.r;
                rect.left = Math.max(rect.left, this.g.getRight());
            } else {
                Rect rect2 = this.r;
                rect2.right = Math.min(rect2.right, this.g.getLeft());
            }
            canvas.clipRect(this.r);
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(iSave);
        return zDrawChild;
    }

    void e(View view) {
        sendAccessibilityEvent(32);
    }

    void f(View view) {
    }

    void g(View view) {
        be3.D0(view, ((d) view.getLayoutParams()).d);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new d();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new d((ViewGroup.MarginLayoutParams) layoutParams) : new d(layoutParams);
    }

    public int getCoveredFadeColor() {
        return this.b;
    }

    public int getParallaxDistance() {
        return this.l;
    }

    public int getSliderFadeColor() {
        return this.a;
    }

    boolean h(View view) {
        if (view == null) {
            return false;
        }
        return this.f && ((d) view.getLayoutParams()).c && this.h > 0.0f;
    }

    boolean i() {
        return be3.A(this) == 1;
    }

    public boolean j() {
        return !this.f || this.h == 1.0f;
    }

    public boolean k() {
        return this.f;
    }

    void l(int i) {
        if (this.g == null) {
            this.h = 0.0f;
            return;
        }
        boolean zI = i();
        d dVar = (d) this.g.getLayoutParams();
        int width = this.g.getWidth();
        if (zI) {
            i = (getWidth() - i) - width;
        }
        float paddingRight = (i - ((zI ? getPaddingRight() : getPaddingLeft()) + (zI ? ((ViewGroup.MarginLayoutParams) dVar).rightMargin : ((ViewGroup.MarginLayoutParams) dVar).leftMargin))) / this.j;
        this.h = paddingRight;
        if (this.l != 0) {
            o(paddingRight);
        }
        if (dVar.c) {
            c(this.g, this.h, this.a);
        }
        f(this.g);
    }

    public boolean m() {
        return n(this.g, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f200q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f200q = true;
        int size = this.s.size();
        for (int i = 0; i < size; i++) {
            ((b) this.s.get(i)).run();
        }
        this.s.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.f && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.p = !this.o.F(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.f || (this.k && actionMasked != 0)) {
            this.o.b();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked == 3 || actionMasked == 1) {
            this.o.b();
            return false;
        }
        if (actionMasked == 0) {
            this.k = false;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.m = x;
            this.n = y;
            if (this.o.F(this.g, (int) x, (int) y) && h(this.g)) {
                z = true;
            }
            return this.o.Q(motionEvent) || z;
        }
        if (actionMasked == 2) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float fAbs = Math.abs(x2 - this.m);
            float fAbs2 = Math.abs(y2 - this.n);
            if (fAbs > this.o.A() && fAbs2 > fAbs) {
                this.o.b();
                this.k = true;
                return false;
            }
        }
        z = false;
        if (this.o.Q(motionEvent)) {
            return true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        boolean zI = i();
        if (zI) {
            this.o.N(2);
        } else {
            this.o.N(1);
        }
        int i9 = i3 - i;
        int paddingRight = zI ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = zI ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f200q) {
            this.h = (this.f && this.p) ? 1.0f : 0.0f;
        }
        int i10 = paddingRight;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (dVar.b) {
                    int i12 = i9 - paddingLeft;
                    int iMin = (Math.min(paddingRight, i12 - this.e) - i10) - (((ViewGroup.MarginLayoutParams) dVar).leftMargin + ((ViewGroup.MarginLayoutParams) dVar).rightMargin);
                    this.j = iMin;
                    int i13 = zI ? ((ViewGroup.MarginLayoutParams) dVar).rightMargin : ((ViewGroup.MarginLayoutParams) dVar).leftMargin;
                    dVar.c = ((i10 + i13) + iMin) + (measuredWidth / 2) > i12;
                    int i14 = (int) (iMin * this.h);
                    i10 += i13 + i14;
                    this.h = i14 / iMin;
                    i5 = 0;
                } else if (!this.f || (i6 = this.l) == 0) {
                    i10 = paddingRight;
                    i5 = 0;
                } else {
                    i5 = (int) ((1.0f - this.h) * i6);
                    i10 = paddingRight;
                }
                if (zI) {
                    i8 = (i9 - i10) + i5;
                    i7 = i8 - measuredWidth;
                } else {
                    i7 = i10 - i5;
                    i8 = i7 + measuredWidth;
                }
                childAt.layout(i7, paddingTop, i8, childAt.getMeasuredHeight() + paddingTop);
                paddingRight += childAt.getWidth();
            }
        }
        if (this.f200q) {
            if (this.f) {
                if (this.l != 0) {
                    o(this.h);
                }
                if (((d) this.g.getLayoutParams()).c) {
                    c(this.g, this.h, this.a);
                }
            } else {
                for (int i15 = 0; i15 < childCount; i15++) {
                    c(getChildAt(i15), 0.0f, this.a);
                }
            }
            r(this.g);
        }
        this.f200q = false;
    }

    /* JADX WARN: Code duplicated, block: B:131:0x0114 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x00ad A[PHI: r13
      0x00ad: PHI (r13v2 float) = (r13v1 float), (r13v3 float) binds: [B:36:0x00a4, B:38:0x00a9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:42:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:46:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:49:0x00da  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:53:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:60:0x0109  */
    /* JADX WARN: Code duplicated, block: B:61:0x010c  */
    /* JADX WARN: Code duplicated, block: B:64:0x0112  */
    /* JADX WARN: Code duplicated, block: B:73:0x0135  */
    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int paddingTop;
        int iMin;
        int i3;
        int iMakeMeasureSpec;
        int i4;
        int i5;
        int iMakeMeasureSpec2;
        int i6;
        int i7;
        int iMakeMeasureSpec3;
        int i8;
        int iMakeMeasureSpec4;
        int measuredHeight;
        boolean z;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            }
            if (mode2 == 0) {
                size2 = 300;
                mode2 = Integer.MIN_VALUE;
            }
        }
        boolean z2 = false;
        if (mode2 != Integer.MIN_VALUE) {
            iMin = mode2 != 1073741824 ? 0 : (size2 - getPaddingTop()) - getPaddingBottom();
            paddingTop = iMin;
        } else {
            paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            iMin = 0;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.g = null;
        int i9 = 0;
        boolean z3 = false;
        int i10 = paddingLeft;
        float f = 0.0f;
        while (true) {
            i3 = 8;
            if (i9 >= childCount) {
                break;
            }
            View childAt = getChildAt(i9);
            d dVar = (d) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                dVar.c = z2;
            } else {
                float f2 = dVar.a;
                if (f2 > 0.0f) {
                    f += f2;
                    if (((ViewGroup.MarginLayoutParams) dVar).width != 0) {
                        i6 = ((ViewGroup.MarginLayoutParams) dVar).leftMargin + ((ViewGroup.MarginLayoutParams) dVar).rightMargin;
                        i7 = ((ViewGroup.MarginLayoutParams) dVar).width;
                        if (i7 == -2) {
                            iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i6, Integer.MIN_VALUE);
                        } else if (i7 == -1) {
                            iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i6, 1073741824);
                        } else {
                            iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                        }
                        i8 = ((ViewGroup.MarginLayoutParams) dVar).height;
                        if (i8 == -2) {
                            iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                        } else if (i8 == -1) {
                            iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                        } else {
                            iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
                        }
                        childAt.measure(iMakeMeasureSpec3, iMakeMeasureSpec4);
                        int measuredWidth = childAt.getMeasuredWidth();
                        measuredHeight = childAt.getMeasuredHeight();
                        if (mode2 == Integer.MIN_VALUE && measuredHeight > iMin) {
                            iMin = Math.min(measuredHeight, paddingTop);
                        }
                        i10 -= measuredWidth;
                        if (i10 < 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        dVar.b = z;
                        z3 |= z;
                        if (z) {
                            this.g = childAt;
                        }
                    }
                } else {
                    i6 = ((ViewGroup.MarginLayoutParams) dVar).leftMargin + ((ViewGroup.MarginLayoutParams) dVar).rightMargin;
                    i7 = ((ViewGroup.MarginLayoutParams) dVar).width;
                    if (i7 == -2) {
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i6, Integer.MIN_VALUE);
                    } else if (i7 == -1) {
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i6, 1073741824);
                    } else {
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                    }
                    i8 = ((ViewGroup.MarginLayoutParams) dVar).height;
                    if (i8 == -2) {
                        iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                    } else if (i8 == -1) {
                        iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                    } else {
                        iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
                    }
                    childAt.measure(iMakeMeasureSpec3, iMakeMeasureSpec4);
                    int measuredWidth2 = childAt.getMeasuredWidth();
                    measuredHeight = childAt.getMeasuredHeight();
                    if (mode2 == Integer.MIN_VALUE) {
                        iMin = Math.min(measuredHeight, paddingTop);
                    }
                    i10 -= measuredWidth2;
                    if (i10 < 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    dVar.b = z;
                    z3 |= z;
                    if (z) {
                        this.g = childAt;
                    }
                }
            }
            i9++;
            z2 = false;
        }
        if (z3 || f > 0.0f) {
            int i11 = paddingLeft - this.e;
            int i12 = 0;
            while (i12 < childCount) {
                View childAt2 = getChildAt(i12);
                if (childAt2.getVisibility() == i3) {
                    i4 = i11;
                } else {
                    d dVar2 = (d) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i3) {
                        boolean z4 = ((ViewGroup.MarginLayoutParams) dVar2).width == 0 && dVar2.a > 0.0f;
                        int measuredWidth3 = z4 ? 0 : childAt2.getMeasuredWidth();
                        if (!z3 || childAt2 == this.g) {
                            if (dVar2.a > 0.0f) {
                                if (((ViewGroup.MarginLayoutParams) dVar2).width == 0) {
                                    int i13 = ((ViewGroup.MarginLayoutParams) dVar2).height;
                                    if (i13 == -2) {
                                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                    } else {
                                        iMakeMeasureSpec = i13 == -1 ? View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824) : View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
                                    }
                                } else {
                                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                if (z3) {
                                    int i14 = paddingLeft - (((ViewGroup.MarginLayoutParams) dVar2).leftMargin + ((ViewGroup.MarginLayoutParams) dVar2).rightMargin);
                                    i4 = i11;
                                    int iMakeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
                                    if (measuredWidth3 != i14) {
                                        childAt2.measure(iMakeMeasureSpec5, iMakeMeasureSpec);
                                    }
                                } else {
                                    i4 = i11;
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth3 + ((int) ((dVar2.a * Math.max(0, i10)) / f)), 1073741824), iMakeMeasureSpec);
                                }
                            }
                        } else if (((ViewGroup.MarginLayoutParams) dVar2).width < 0 && (measuredWidth3 > i11 || dVar2.a > 0.0f)) {
                            if (z4) {
                                int i15 = ((ViewGroup.MarginLayoutParams) dVar2).height;
                                if (i15 == -2) {
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                    i5 = 1073741824;
                                } else if (i15 == -1) {
                                    i5 = 1073741824;
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                } else {
                                    i5 = 1073741824;
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
                                }
                            } else {
                                i5 = 1073741824;
                                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            }
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec(i11, i5), iMakeMeasureSpec2);
                        }
                        i4 = i11;
                    } else {
                        i4 = i11;
                    }
                }
                i12++;
                i11 = i4;
                i3 = 8;
            }
        }
        setMeasuredDimension(size, iMin + getPaddingTop() + getPaddingBottom());
        this.f = z3;
        if (this.o.B() == 0 || z3) {
            return;
        }
        this.o.a();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.a) {
            m();
        } else {
            a();
        }
        this.p = savedState.a;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = k() ? j() : this.p;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.f200q = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f) {
            return super.onTouchEvent(motionEvent);
        }
        this.o.G(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.m = x;
            this.n = y;
        } else if (actionMasked == 1 && h(this.g)) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f = x2 - this.m;
            float f2 = y2 - this.n;
            int iA = this.o.A();
            if ((f * f) + (f2 * f2) < iA * iA && this.o.F(this.g, (int) x2, (int) y2)) {
                b(this.g, 0);
            }
        }
        return true;
    }

    void p() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    boolean q(float f, int i) {
        int paddingLeft;
        if (!this.f) {
            return false;
        }
        boolean zI = i();
        d dVar = (d) this.g.getLayoutParams();
        if (zI) {
            paddingLeft = (int) (getWidth() - (((getPaddingRight() + ((ViewGroup.MarginLayoutParams) dVar).rightMargin) + (f * this.j)) + this.g.getWidth()));
        } else {
            paddingLeft = (int) (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin + (f * this.j));
        }
        fe3 fe3Var = this.o;
        View view = this.g;
        if (!fe3Var.R(view, paddingLeft, view.getTop())) {
            return false;
        }
        p();
        be3.g0(this);
        return true;
    }

    void r(View view) {
        int left;
        int right;
        int top;
        int bottom;
        View childAt;
        View view2 = view;
        boolean zI = i();
        int width = zI ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = zI ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !s(view)) {
            left = 0;
            right = 0;
            top = 0;
            bottom = 0;
        } else {
            left = view.getLeft();
            right = view.getRight();
            top = view.getTop();
            bottom = view.getBottom();
        }
        int childCount = getChildCount();
        int i = 0;
        while (i < childCount && (childAt = getChildAt(i)) != view2) {
            if (childAt.getVisibility() != 8) {
                childAt.setVisibility((Math.max(zI ? paddingLeft : width, childAt.getLeft()) < left || Math.max(paddingTop, childAt.getTop()) < top || Math.min(zI ? width : paddingLeft, childAt.getRight()) > right || Math.min(height, childAt.getBottom()) > bottom) ? 0 : 4);
            }
            i++;
            view2 = view;
            zI = zI;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.f) {
            return;
        }
        this.p = view == this.g;
    }

    public void setCoveredFadeColor(int i) {
        this.b = i;
    }

    public void setPanelSlideListener(e eVar) {
    }

    public void setParallaxDistance(int i) {
        this.l = i;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.c = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.d = drawable;
    }

    @Deprecated
    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(q30.e(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(q30.e(getContext(), i));
    }

    public void setSliderFadeColor(int i) {
        this.a = i;
    }

    public static class d extends ViewGroup.MarginLayoutParams {
        private static final int[] e = {R.attr.layout_weight};
        public float a;
        boolean b;
        boolean c;
        Paint d;

        public d() {
            super(-1, -1);
            this.a = 0.0f;
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0.0f;
        }

        public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 0.0f;
        }

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e);
            this.a = typedArrayObtainStyledAttributes.getFloat(0, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = -858993460;
        this.f200q = true;
        this.r = new Rect();
        this.s = new ArrayList();
        float f = context.getResources().getDisplayMetrics().density;
        this.e = (int) ((32.0f * f) + 0.5f);
        setWillNotDraw(false);
        be3.p0(this, new a());
        be3.z0(this, 1);
        fe3 fe3VarO = fe3.o(this, 0.5f, new c());
        this.o = fe3VarO;
        fe3VarO.O(f * 400.0f);
    }
}
