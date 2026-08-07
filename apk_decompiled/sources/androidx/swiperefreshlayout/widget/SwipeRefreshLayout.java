package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import defpackage.be3;
import defpackage.q30;
import defpackage.sn1;
import defpackage.sx;
import defpackage.tb1;
import defpackage.tn1;
import defpackage.wn1;

/* JADX INFO: loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements sn1 {
    private static final String S = "SwipeRefreshLayout";
    private static final int[] T = {R.attr.enabled};
    int F;
    sx G;
    private Animation H;
    private Animation I;
    private Animation J;
    private Animation K;
    private Animation L;
    boolean M;
    private int N;
    boolean O;
    private Animation.AnimationListener P;
    private final Animation Q;
    private final Animation R;
    private View a;
    j b;
    boolean c;
    private int d;
    private float e;
    private float f;
    private final wn1 g;
    private final tn1 h;
    private final int[] i;
    private final int[] j;
    private boolean k;
    private int l;
    int m;
    private float n;
    private float o;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f201q;
    boolean r;
    private boolean s;
    private final DecelerateInterpolator t;
    androidx.swiperefreshlayout.widget.a u;
    private int v;
    protected int w;
    float x;
    protected int y;
    int z;

    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            j jVar;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.c) {
                swipeRefreshLayout.k();
                return;
            }
            swipeRefreshLayout.G.setAlpha(255);
            SwipeRefreshLayout.this.G.start();
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            if (swipeRefreshLayout2.M && (jVar = swipeRefreshLayout2.b) != null) {
                jVar.a();
            }
            SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
            swipeRefreshLayout3.m = swipeRefreshLayout3.u.getTop();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class b extends Animation {
        b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f);
        }
    }

    class c extends Animation {
        c() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
        }
    }

    class d extends Animation {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        d(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            sx sxVar = SwipeRefreshLayout.this.G;
            int i = this.a;
            sxVar.setAlpha((int) (i + ((this.b - i) * f)));
        }
    }

    class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.r) {
                return;
            }
            swipeRefreshLayout.q(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class f extends Animation {
        f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            int iAbs = !swipeRefreshLayout.O ? swipeRefreshLayout.z - Math.abs(swipeRefreshLayout.y) : swipeRefreshLayout.z;
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            int i = swipeRefreshLayout2.w;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((i + ((int) ((iAbs - i) * f))) - swipeRefreshLayout2.u.getTop());
            SwipeRefreshLayout.this.G.e(1.0f - f);
        }
    }

    class g extends Animation {
        g() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.i(f);
        }
    }

    class h extends Animation {
        h() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f2 = swipeRefreshLayout.x;
            swipeRefreshLayout.setAnimationProgress(f2 + ((-f2) * f));
            SwipeRefreshLayout.this.i(f);
        }
    }

    public interface i {
    }

    public interface j {
        void a();
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    private void a(int i2, Animation.AnimationListener animationListener) {
        this.w = i2;
        this.Q.reset();
        this.Q.setDuration(200L);
        this.Q.setInterpolator(this.t);
        if (animationListener != null) {
            this.u.b(animationListener);
        }
        this.u.clearAnimation();
        this.u.startAnimation(this.Q);
    }

    private void b(int i2, Animation.AnimationListener animationListener) {
        if (this.r) {
            r(i2, animationListener);
            return;
        }
        this.w = i2;
        this.R.reset();
        this.R.setDuration(200L);
        this.R.setInterpolator(this.t);
        if (animationListener != null) {
            this.u.b(animationListener);
        }
        this.u.clearAnimation();
        this.u.startAnimation(this.R);
    }

    private void d() {
        this.u = new androidx.swiperefreshlayout.widget.a(getContext(), -328966);
        sx sxVar = new sx(getContext());
        this.G = sxVar;
        sxVar.l(1);
        this.u.setImageDrawable(this.G);
        this.u.setVisibility(8);
        addView(this.u);
    }

    private void e() {
        if (this.a == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.u)) {
                    this.a = childAt;
                    return;
                }
            }
        }
    }

    private void f(float f2) {
        if (f2 > this.e) {
            l(true, true);
            return;
        }
        this.c = false;
        this.G.j(0.0f, 0.0f);
        b(this.m, !this.r ? new e() : null);
        this.G.d(false);
    }

    private boolean g(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void h(float f2) {
        this.G.d(true);
        float fMin = Math.min(1.0f, Math.abs(f2 / this.e));
        float fMax = (((float) Math.max(((double) fMin) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float fAbs = Math.abs(f2) - this.e;
        int i2 = this.F;
        if (i2 <= 0) {
            i2 = this.O ? this.z - this.y : this.z;
        }
        float f3 = i2;
        double dMax = Math.max(0.0f, Math.min(fAbs, f3 * 2.0f) / f3) / 4.0f;
        float fPow = ((float) (dMax - Math.pow(dMax, 2.0d))) * 2.0f;
        int i3 = this.y + ((int) ((f3 * fMin) + (f3 * fPow * 2.0f)));
        if (this.u.getVisibility() != 0) {
            this.u.setVisibility(0);
        }
        if (!this.r) {
            this.u.setScaleX(1.0f);
            this.u.setScaleY(1.0f);
        }
        if (this.r) {
            setAnimationProgress(Math.min(1.0f, f2 / this.e));
        }
        if (f2 < this.e) {
            if (this.G.getAlpha() > 76 && !g(this.J)) {
                p();
            }
        } else if (this.G.getAlpha() < 255 && !g(this.K)) {
            o();
        }
        this.G.j(0.0f, Math.min(0.8f, fMax * 0.8f));
        this.G.e(Math.min(1.0f, fMax));
        this.G.g((((fMax * 0.4f) - 0.25f) + (fPow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i3 - this.m);
    }

    private void j(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f201q) {
            this.f201q = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void l(boolean z, boolean z2) {
        if (this.c != z) {
            this.M = z2;
            e();
            this.c = z;
            if (z) {
                a(this.m, this.P);
            } else {
                q(this.P);
            }
        }
    }

    private Animation m(int i2, int i3) {
        d dVar = new d(i2, i3);
        dVar.setDuration(300L);
        this.u.b(null);
        this.u.clearAnimation();
        this.u.startAnimation(dVar);
        return dVar;
    }

    private void n(float f2) {
        float f3 = this.o;
        float f4 = f2 - f3;
        int i2 = this.d;
        if (f4 <= i2 || this.p) {
            return;
        }
        this.n = f3 + i2;
        this.p = true;
        this.G.setAlpha(76);
    }

    private void o() {
        this.K = m(this.G.getAlpha(), 255);
    }

    private void p() {
        this.J = m(this.G.getAlpha(), 76);
    }

    private void r(int i2, Animation.AnimationListener animationListener) {
        this.w = i2;
        this.x = this.u.getScaleX();
        h hVar = new h();
        this.L = hVar;
        hVar.setDuration(150L);
        if (animationListener != null) {
            this.u.b(animationListener);
        }
        this.u.clearAnimation();
        this.u.startAnimation(this.L);
    }

    private void s(Animation.AnimationListener animationListener) {
        this.u.setVisibility(0);
        this.G.setAlpha(255);
        b bVar = new b();
        this.H = bVar;
        bVar.setDuration(this.l);
        if (animationListener != null) {
            this.u.b(animationListener);
        }
        this.u.clearAnimation();
        this.u.startAnimation(this.H);
    }

    private void setColorViewAlpha(int i2) {
        this.u.getBackground().setAlpha(i2);
        this.G.setAlpha(i2);
    }

    public boolean c() {
        View view = this.a;
        return view instanceof ListView ? tb1.a((ListView) view, -1) : view.canScrollVertically(-1);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.h.a(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.h.b(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.h.c(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.h.f(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.v;
        if (i4 < 0) {
            return i3;
        }
        if (i3 == i2 - 1) {
            return i4;
        }
        return i3 >= i4 ? i3 + 1 : i3;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.g.a();
    }

    public int getProgressCircleDiameter() {
        return this.N;
    }

    public int getProgressViewEndOffset() {
        return this.z;
    }

    public int getProgressViewStartOffset() {
        return this.y;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.h.k();
    }

    void i(float f2) {
        int i2 = this.w;
        setTargetOffsetTopAndBottom((i2 + ((int) ((this.y - i2) * f2))) - this.u.getTop());
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.h.m();
    }

    void k() {
        this.u.clearAnimation();
        this.G.stop();
        this.u.setVisibility(8);
        setColorViewAlpha(255);
        if (this.r) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.y - this.m);
        }
        this.m = this.u.getTop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k();
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0058  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        e();
        int actionMasked = motionEvent.getActionMasked();
        if (this.s && actionMasked == 0) {
            this.s = false;
        }
        if (!isEnabled() || this.s || c() || this.c || this.k) {
            return false;
        }
        if (actionMasked == 0) {
            setTargetOffsetTopAndBottom(this.y - this.u.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.f201q = pointerId;
            this.p = false;
            int iFindPointerIndex = motionEvent.findPointerIndex(pointerId);
            if (iFindPointerIndex < 0) {
                return false;
            }
            this.o = motionEvent.getY(iFindPointerIndex);
        } else if (actionMasked == 1) {
            this.p = false;
            this.f201q = -1;
        } else if (actionMasked == 2) {
            int i2 = this.f201q;
            if (i2 == -1) {
                Log.e(S, "Got ACTION_MOVE event but don't have an active pointer id.");
                return false;
            }
            int iFindPointerIndex2 = motionEvent.findPointerIndex(i2);
            if (iFindPointerIndex2 < 0) {
                return false;
            }
            n(motionEvent.getY(iFindPointerIndex2));
        } else if (actionMasked == 3) {
            this.p = false;
            this.f201q = -1;
        } else if (actionMasked == 6) {
            j(motionEvent);
        }
        return this.p;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.a == null) {
            e();
        }
        View view = this.a;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.u.getMeasuredWidth();
        int measuredHeight2 = this.u.getMeasuredHeight();
        int i6 = measuredWidth / 2;
        int i7 = measuredWidth2 / 2;
        int i8 = this.m;
        this.u.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.a == null) {
            e();
        }
        View view = this.a;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.u.measure(View.MeasureSpec.makeMeasureSpec(this.N, 1073741824), View.MeasureSpec.makeMeasureSpec(this.N, 1073741824));
        this.v = -1;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) == this.u) {
                this.v = i4;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.f;
            if (f2 > 0.0f) {
                float f3 = i3;
                if (f3 > f2) {
                    iArr[1] = i3 - ((int) f2);
                    this.f = 0.0f;
                } else {
                    this.f = f2 - f3;
                    iArr[1] = i3;
                }
                h(this.f);
            }
        }
        if (this.O && i3 > 0 && this.f == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.u.setVisibility(8);
        }
        int[] iArr2 = this.i;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        dispatchNestedScroll(i2, i3, i4, i5, this.j);
        int i6 = i5 + this.j[1];
        if (i6 >= 0 || c()) {
            return;
        }
        float fAbs = this.f + Math.abs(i6);
        this.f = fAbs;
        h(fAbs);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.g.b(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.f = 0.0f;
        this.k = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return (!isEnabled() || this.s || this.c || (i2 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        this.g.d(view);
        this.k = false;
        float f2 = this.f;
        if (f2 > 0.0f) {
            f(f2);
            this.f = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.s && actionMasked == 0) {
            this.s = false;
        }
        if (!isEnabled() || this.s || c() || this.c || this.k) {
            return false;
        }
        if (actionMasked == 0) {
            this.f201q = motionEvent.getPointerId(0);
            this.p = false;
        } else {
            if (actionMasked == 1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f201q);
                if (iFindPointerIndex < 0) {
                    Log.e(S, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.p) {
                    float y = (motionEvent.getY(iFindPointerIndex) - this.n) * 0.5f;
                    this.p = false;
                    f(y);
                }
                this.f201q = -1;
                return false;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.f201q);
                if (iFindPointerIndex2 < 0) {
                    Log.e(S, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y2 = motionEvent.getY(iFindPointerIndex2);
                n(y2);
                if (this.p) {
                    float f2 = (y2 - this.n) * 0.5f;
                    if (f2 <= 0.0f) {
                        return false;
                    }
                    h(f2);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        Log.e(S, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.f201q = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    j(motionEvent);
                }
            }
        }
        return true;
    }

    void q(Animation.AnimationListener animationListener) {
        c cVar = new c();
        this.I = cVar;
        cVar.setDuration(150L);
        this.u.b(animationListener);
        this.u.clearAnimation();
        this.u.startAnimation(this.I);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        View view = this.a;
        if (view == null || be3.U(view)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    void setAnimationProgress(float f2) {
        this.u.setScaleX(f2);
        this.u.setScaleY(f2);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        e();
        this.G.f(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = q30.c(context, iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i2) {
        this.e = i2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        k();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.h.n(z);
    }

    public void setOnChildScrollUpCallback(i iVar) {
    }

    public void setOnRefreshListener(j jVar) {
        this.b = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeColor(int i2) {
        this.u.setBackgroundColor(i2);
    }

    public void setProgressBackgroundColorSchemeResource(int i2) {
        setProgressBackgroundColorSchemeColor(q30.c(getContext(), i2));
    }

    public void setRefreshing(boolean z) {
        if (!z || this.c == z) {
            l(z, false);
            return;
        }
        this.c = z;
        setTargetOffsetTopAndBottom((!this.O ? this.z + this.y : this.z) - this.m);
        this.M = false;
        s(this.P);
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                this.N = (int) (displayMetrics.density * 56.0f);
            } else {
                this.N = (int) (displayMetrics.density * 40.0f);
            }
            this.u.setImageDrawable(null);
            this.G.l(i2);
            this.u.setImageDrawable(this.G);
        }
    }

    public void setSlingshotDistance(int i2) {
        this.F = i2;
    }

    void setTargetOffsetTopAndBottom(int i2) {
        this.u.bringToFront();
        be3.a0(this.u, i2);
        this.m = this.u.getTop();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return this.h.p(i2);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        this.h.r();
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = false;
        this.e = -1.0f;
        this.i = new int[2];
        this.j = new int[2];
        this.f201q = -1;
        this.v = -1;
        this.P = new a();
        this.Q = new f();
        this.R = new g();
        this.d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.l = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.t = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.N = (int) (displayMetrics.density * 40.0f);
        d();
        setChildrenDrawingOrderEnabled(true);
        int i2 = (int) (displayMetrics.density * 64.0f);
        this.z = i2;
        this.e = i2;
        this.g = new wn1(this);
        this.h = new tn1(this);
        setNestedScrollingEnabled(true);
        int i3 = -this.N;
        this.m = i3;
        this.y = i3;
        i(1.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, T);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
        typedArrayObtainStyledAttributes.recycle();
    }
}
