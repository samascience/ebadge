package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import defpackage.b52;
import defpackage.eh1;
import defpackage.pz;
import defpackage.y6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CarouselLayoutManager extends RecyclerView.LayoutManager implements com.google.android.material.carousel.b, RecyclerView.SmoothScroller.ScrollVectorProvider {
    int a;
    int b;
    int c;
    private boolean d;
    private final c e;
    private com.google.android.material.carousel.d f;
    private g g;
    private f h;
    private int i;
    private Map j;
    private com.google.android.material.carousel.c k;
    private final View.OnLayoutChangeListener l;
    private int m;
    private int n;
    private int o;

    class a extends LinearSmoothScroller {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDxToMakeVisible(View view, int i) {
            if (CarouselLayoutManager.this.g == null || !CarouselLayoutManager.this.d()) {
                return 0;
            }
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            return carouselLayoutManager.u(carouselLayoutManager.getPosition(view));
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDyToMakeVisible(View view, int i) {
            if (CarouselLayoutManager.this.g == null || CarouselLayoutManager.this.d()) {
                return 0;
            }
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            return carouselLayoutManager.u(carouselLayoutManager.getPosition(view));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public PointF computeScrollVectorForPosition(int i) {
            return CarouselLayoutManager.this.computeScrollVectorForPosition(i);
        }
    }

    private static final class b {
        final View a;
        final float b;
        final float c;
        final d d;

        b(View view, float f, float f2, d dVar) {
            this.a = view;
            this.b = f;
            this.c = f2;
            this.d = dVar;
        }
    }

    private static class c extends RecyclerView.ItemDecoration {
        private final Paint a;
        private List b;

        c() {
            Paint paint = new Paint();
            this.a = paint;
            this.b = Collections.unmodifiableList(new ArrayList());
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        void a(List list) {
            this.b = Collections.unmodifiableList(list);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            super.onDrawOver(canvas, recyclerView, state);
            this.a.setStrokeWidth(recyclerView.getResources().getDimension(R$dimen.m3_carousel_debug_keyline_width));
            for (f.c cVar : this.b) {
                this.a.setColor(pz.c(-65281, -16776961, cVar.c));
                if (((CarouselLayoutManager) recyclerView.getLayoutManager()).d()) {
                    canvas.drawLine(cVar.b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).K(), cVar.b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).F(), this.a);
                } else {
                    canvas.drawLine(((CarouselLayoutManager) recyclerView.getLayoutManager()).H(), cVar.b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).I(), cVar.b, this.a);
                }
            }
        }
    }

    private static class d {
        final f.c a;
        final f.c b;

        d(f.c cVar, f.c cVar2) {
            b52.a(cVar.a <= cVar2.a);
            this.a = cVar;
            this.b = cVar2;
        }
    }

    public CarouselLayoutManager() {
        this(new i());
    }

    private int A() {
        int i;
        int i2;
        if (getChildCount() <= 0) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) getChildAt(0).getLayoutParams();
        if (this.k.a == 0) {
            i = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            i2 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        } else {
            i = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            i2 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return i + i2;
    }

    private f B(int i) {
        f fVar;
        Map map = this.j;
        return (map == null || (fVar = (f) map.get(Integer.valueOf(eh1.b(i, 0, Math.max(0, getItemCount() + (-1)))))) == null) ? this.g.g() : fVar;
    }

    private int C() {
        if (getClipToPadding() || !this.f.f()) {
            return 0;
        }
        return getOrientation() == 1 ? getPaddingTop() : getPaddingLeft();
    }

    private float D(float f, d dVar) {
        f.c cVar = dVar.a;
        float f2 = cVar.d;
        f.c cVar2 = dVar.b;
        return y6.b(f2, cVar2.d, cVar.b, cVar2.b, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int F() {
        return this.k.g();
    }

    private int G() {
        return this.k.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int H() {
        return this.k.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int I() {
        return this.k.j();
    }

    private int J() {
        return this.k.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int K() {
        return this.k.l();
    }

    private int L() {
        if (getClipToPadding() || !this.f.f()) {
            return 0;
        }
        return getOrientation() == 1 ? getPaddingBottom() : getPaddingRight();
    }

    private int M(int i, f fVar) {
        return P() ? (int) (((y() - fVar.h().a) - (i * fVar.f())) - (fVar.f() / 2.0f)) : (int) (((i * fVar.f()) - fVar.a().a) + (fVar.f() / 2.0f));
    }

    private int N(int i, f fVar) {
        int i2 = Integer.MAX_VALUE;
        for (f.c cVar : fVar.e()) {
            float f = (i * fVar.f()) + (fVar.f() / 2.0f);
            int iY = (P() ? (int) ((y() - cVar.a) - f) : (int) (f - cVar.a)) - this.a;
            if (Math.abs(i2) > Math.abs(iY)) {
                i2 = iY;
            }
        }
        return i2;
    }

    private static d O(List list, float f, boolean z) {
        float f2 = Float.MAX_VALUE;
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        float f3 = -3.4028235E38f;
        float f4 = Float.MAX_VALUE;
        float f5 = Float.MAX_VALUE;
        for (int i5 = 0; i5 < list.size(); i5++) {
            f.c cVar = (f.c) list.get(i5);
            float f6 = z ? cVar.b : cVar.a;
            float fAbs = Math.abs(f6 - f);
            if (f6 <= f && fAbs <= f2) {
                i = i5;
                f2 = fAbs;
            }
            if (f6 > f && fAbs <= f4) {
                i3 = i5;
                f4 = fAbs;
            }
            if (f6 <= f5) {
                i2 = i5;
                f5 = f6;
            }
            if (f6 > f3) {
                i4 = i5;
                f3 = f6;
            }
        }
        if (i == -1) {
            i = i2;
        }
        if (i3 == -1) {
            i3 = i4;
        }
        return new d((f.c) list.get(i), (f.c) list.get(i3));
    }

    private boolean Q(float f, d dVar) {
        float fN = n(f, D(f, dVar) / 2.0f);
        if (P()) {
            if (fN >= 0.0f) {
                return false;
            }
        } else if (fN <= y()) {
            return false;
        }
        return true;
    }

    private boolean R(float f, d dVar) {
        float fM = m(f, D(f, dVar) / 2.0f);
        if (P()) {
            if (fM <= y()) {
                return false;
            }
        } else if (fM >= 0.0f) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i == i5 && i2 == i6 && i3 == i7 && i4 == i8) {
            return;
        }
        view.post(new Runnable() { // from class: sw
            @Override // java.lang.Runnable
            public final void run() {
                this.a.X();
            }
        });
    }

    private void T() {
        if (this.d && Log.isLoggable("CarouselLayoutManager", 3)) {
            Log.d("CarouselLayoutManager", "internal representation of views on the screen");
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                Log.d("CarouselLayoutManager", "item position " + getPosition(childAt) + ", center:" + z(childAt) + ", child index:" + i);
            }
            Log.d("CarouselLayoutManager", "==============");
        }
    }

    private b U(RecyclerView.Recycler recycler, float f, int i) {
        View viewForPosition = recycler.getViewForPosition(i);
        measureChildWithMargins(viewForPosition, 0, 0);
        float fM = m(f, this.h.f() / 2.0f);
        d dVarO = O(this.h.g(), fM, false);
        return new b(viewForPosition, fM, r(viewForPosition, fM, dVarO), dVarO);
    }

    private float V(View view, float f, float f2, Rect rect) {
        float fM = m(f, f2);
        d dVarO = O(this.h.g(), fM, false);
        float fR = r(view, fM, dVarO);
        super.getDecoratedBoundsWithMargins(view, rect);
        d0(view, fM, dVarO);
        this.k.o(view, rect, f2, fR);
        return fR;
    }

    private void W(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(0);
        measureChildWithMargins(viewForPosition, 0, 0);
        f fVarG = this.f.g(this, viewForPosition);
        if (P()) {
            fVarG = f.n(fVarG, y());
        }
        this.g = g.f(this, fVarG, A(), C(), L());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        this.g = null;
        requestLayout();
    }

    private void Y(RecyclerView.Recycler recycler) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            float fZ = z(childAt);
            if (!R(fZ, O(this.h.g(), fZ, true))) {
                break;
            } else {
                removeAndRecycleView(childAt, recycler);
            }
        }
        while (getChildCount() - 1 >= 0) {
            View childAt2 = getChildAt(getChildCount() - 1);
            float fZ2 = z(childAt2);
            if (!Q(fZ2, O(this.h.g(), fZ2, true))) {
                return;
            } else {
                removeAndRecycleView(childAt2, recycler);
            }
        }
    }

    private void Z(RecyclerView recyclerView, int i) {
        if (d()) {
            recyclerView.scrollBy(i, 0);
        } else {
            recyclerView.scrollBy(0, i);
        }
    }

    private void b0(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Carousel);
            a0(typedArrayObtainStyledAttributes.getInt(R$styleable.Carousel_carousel_alignment, 0));
            setOrientation(typedArrayObtainStyledAttributes.getInt(R$styleable.RecyclerView_android_orientation, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private int convertFocusDirectionToLayoutDirection(int i) {
        int orientation = getOrientation();
        if (i == 1) {
            return -1;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 17) {
            if (orientation == 0) {
                return P() ? 1 : -1;
            }
            return Integer.MIN_VALUE;
        }
        if (i == 33) {
            return orientation == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 66) {
            if (orientation == 0) {
                return P() ? -1 : 1;
            }
            return Integer.MIN_VALUE;
        }
        if (i == 130) {
            return orientation == 1 ? 1 : Integer.MIN_VALUE;
        }
        Log.d("CarouselLayoutManager", "Unknown focus request:" + i);
        return Integer.MIN_VALUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d0(View view, float f, d dVar) {
        if (view instanceof h) {
            f.c cVar = dVar.a;
            float f2 = cVar.c;
            f.c cVar2 = dVar.b;
            float fB = y6.b(f2, cVar2.c, cVar.a, cVar2.a, f);
            float height = view.getHeight();
            float width = view.getWidth();
            RectF rectFF = this.k.f(height, width, y6.b(0.0f, height / 2.0f, 0.0f, 1.0f, fB), y6.b(0.0f, width / 2.0f, 0.0f, 1.0f, fB));
            float fR = r(view, f, dVar);
            RectF rectF = new RectF(fR - (rectFF.width() / 2.0f), fR - (rectFF.height() / 2.0f), fR + (rectFF.width() / 2.0f), (rectFF.height() / 2.0f) + fR);
            RectF rectF2 = new RectF(H(), K(), I(), F());
            if (this.f.f()) {
                this.k.a(rectFF, rectF, rectF2);
            }
            this.k.n(rectFF, rectF, rectF2);
            ((h) view).setMaskRectF(rectFF);
        }
    }

    private void e0(g gVar) {
        int i = this.c;
        int i2 = this.b;
        if (i <= i2) {
            this.h = P() ? gVar.h() : gVar.l();
        } else {
            this.h = gVar.j(this.a, i2, i);
        }
        this.e.a(this.h.g());
    }

    private void f0() {
        int itemCount = getItemCount();
        int i = this.m;
        if (itemCount == i || this.g == null) {
            return;
        }
        if (this.f.h(this, i)) {
            X();
        }
        this.m = itemCount;
    }

    private void g0() {
        if (!this.d || getChildCount() < 1) {
            return;
        }
        int i = 0;
        while (i < getChildCount() - 1) {
            int position = getPosition(getChildAt(i));
            int i2 = i + 1;
            int position2 = getPosition(getChildAt(i2));
            if (position > position2) {
                T();
                throw new IllegalStateException("Detected invalid child order. Child at index [" + i + "] had adapter position [" + position + "] and child at index [" + i2 + "] had adapter position [" + position2 + "].");
            }
            i = i2;
        }
    }

    private View getChildClosestToEnd() {
        return getChildAt(P() ? 0 : getChildCount() - 1);
    }

    private View getChildClosestToStart() {
        return getChildAt(P() ? getChildCount() - 1 : 0);
    }

    private void l(View view, int i, b bVar) {
        float f = this.h.f() / 2.0f;
        addView(view, i);
        float f2 = bVar.c;
        this.k.m(view, (int) (f2 - f), (int) (f2 + f));
        d0(view, bVar.b, bVar.d);
    }

    private float m(float f, float f2) {
        return P() ? f - f2 : f + f2;
    }

    private float n(float f, float f2) {
        return P() ? f + f2 : f - f2;
    }

    private void o(RecyclerView.Recycler recycler, int i, int i2) {
        if (i < 0 || i >= getItemCount()) {
            return;
        }
        b bVarU = U(recycler, s(i), i);
        l(bVarU.a, i2, bVarU);
    }

    private void p(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        float fS = s(i);
        while (i < state.getItemCount()) {
            b bVarU = U(recycler, fS, i);
            if (Q(bVarU.c, bVarU.d)) {
                return;
            }
            fS = m(fS, this.h.f());
            if (!R(bVarU.c, bVarU.d)) {
                l(bVarU.a, -1, bVarU);
            }
            i++;
        }
    }

    private void q(RecyclerView.Recycler recycler, int i) {
        float fS = s(i);
        while (i >= 0) {
            b bVarU = U(recycler, fS, i);
            if (R(bVarU.c, bVarU.d)) {
                return;
            }
            fS = n(fS, this.h.f());
            if (!Q(bVarU.c, bVarU.d)) {
                l(bVarU.a, 0, bVarU);
            }
            i--;
        }
    }

    private float r(View view, float f, d dVar) {
        f.c cVar = dVar.a;
        float f2 = cVar.b;
        f.c cVar2 = dVar.b;
        float fB = y6.b(f2, cVar2.b, cVar.a, cVar2.a, f);
        if (dVar.b != this.h.c() && dVar.a != this.h.j()) {
            return fB;
        }
        float fE = this.k.e((RecyclerView.LayoutParams) view.getLayoutParams()) / this.h.f();
        f.c cVar3 = dVar.b;
        return fB + ((f - cVar3.a) * ((1.0f - cVar3.c) + fE));
    }

    private float s(int i) {
        return m(J() - this.a, this.h.f() * i);
    }

    private int scrollBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        if (this.g == null) {
            W(recycler);
        }
        int iV = v(i, this.a, this.b, this.c);
        this.a += iV;
        e0(this.g);
        float f = this.h.f() / 2.0f;
        float fS = s(getPosition(getChildAt(0)));
        Rect rect = new Rect();
        float f2 = P() ? this.h.h().b : this.h.a().b;
        float f3 = Float.MAX_VALUE;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            float fAbs = Math.abs(f2 - V(childAt, fS, f, rect));
            if (childAt != null && fAbs < f3) {
                this.n = getPosition(childAt);
                f3 = fAbs;
            }
            fS = m(fS, this.h.f());
        }
        x(recycler, state);
        return iV;
    }

    private int t(RecyclerView.State state, g gVar) {
        boolean zP = P();
        f fVarL = zP ? gVar.l() : gVar.h();
        f.c cVarA = zP ? fVarL.a() : fVarL.h();
        int itemCount = (int) (((((state.getItemCount() - 1) * fVarL.f()) * (zP ? -1.0f : 1.0f)) - (cVarA.a - J())) + (G() - cVarA.a) + (zP ? -cVarA.g : cVarA.h));
        return zP ? Math.min(0, itemCount) : Math.max(0, itemCount);
    }

    private static int v(int i, int i2, int i3, int i4) {
        int i5 = i2 + i;
        if (i5 < i3) {
            return i3 - i2;
        }
        return i5 > i4 ? i4 - i2 : i;
    }

    private int w(g gVar) {
        boolean zP = P();
        f fVarH = zP ? gVar.h() : gVar.l();
        return (int) (J() - n((zP ? fVarH.h() : fVarH.a()).a, fVarH.f() / 2.0f));
    }

    private void x(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Y(recycler);
        if (getChildCount() == 0) {
            q(recycler, this.i - 1);
            p(recycler, state, this.i);
        } else {
            int position = getPosition(getChildAt(0));
            int position2 = getPosition(getChildAt(getChildCount() - 1));
            q(recycler, position - 1);
            p(recycler, state, position2 + 1);
        }
        g0();
    }

    private int y() {
        return d() ? a() : b();
    }

    private float z(View view) {
        Rect rect = new Rect();
        super.getDecoratedBoundsWithMargins(view, rect);
        return d() ? rect.centerX() : rect.centerY();
    }

    int E(int i, f fVar) {
        return M(i, fVar) - this.a;
    }

    boolean P() {
        return d() && getLayoutDirection() == 1;
    }

    @Override // com.google.android.material.carousel.b
    public int a() {
        return getWidth();
    }

    public void a0(int i) {
        this.o = i;
        X();
    }

    @Override // com.google.android.material.carousel.b
    public int b() {
        return getHeight();
    }

    @Override // com.google.android.material.carousel.b
    public int c() {
        return this.o;
    }

    public void c0(com.google.android.material.carousel.d dVar) {
        this.f = dVar;
        X();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return !d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0 || this.g == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (getWidth() * (this.g.g().f() / computeHorizontalScrollRange(state)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return this.c - this.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (this.g == null) {
            return null;
        }
        int iE = E(i, B(i));
        return d() ? new PointF(iE, 0.0f) : new PointF(0.0f, iE);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0 || this.g == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (getHeight() * (this.g.g().f() / computeVerticalScrollRange(state)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return this.c - this.b;
    }

    @Override // com.google.android.material.carousel.b
    public boolean d() {
        return this.k.a == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        float fCenterY = rect.centerY();
        if (d()) {
            fCenterY = rect.centerX();
        }
        float fD = D(fCenterY, O(this.h.g(), fCenterY, true));
        float fWidth = d() ? (rect.width() - fD) / 2.0f : 0.0f;
        float fHeight = d() ? 0.0f : (rect.height() - fD) / 2.0f;
        rect.set((int) (rect.left + fWidth), (int) (rect.top + fHeight), (int) (rect.right - fWidth), (int) (rect.bottom - fHeight));
    }

    public int getOrientation() {
        return this.k.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void measureChildWithMargins(View view, int i, int i2) {
        if (!(view instanceof h)) {
            throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        Rect rect = new Rect();
        calculateItemDecorationsForChild(view, rect);
        int i3 = i + rect.left + rect.right;
        int i4 = i2 + rect.top + rect.bottom;
        g gVar = this.g;
        float f = (gVar == null || this.k.a != 0) ? ((ViewGroup.MarginLayoutParams) layoutParams).width : gVar.g().f();
        g gVar2 = this.g;
        view.measure(RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i3, (int) f, canScrollHorizontally()), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i4, (int) ((gVar2 == null || this.k.a != 1) ? ((ViewGroup.MarginLayoutParams) layoutParams).height : gVar2.g().f()), canScrollVertically()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.f.e(recyclerView.getContext());
        X();
        recyclerView.addOnLayoutChangeListener(this.l);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        recyclerView.removeOnLayoutChangeListener(this.l);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int iConvertFocusDirectionToLayoutDirection;
        if (getChildCount() == 0 || (iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i)) == Integer.MIN_VALUE) {
            return null;
        }
        if (iConvertFocusDirectionToLayoutDirection == -1) {
            if (getPosition(view) == 0) {
                return null;
            }
            o(recycler, getPosition(getChildAt(0)) - 1, 0);
            return getChildClosestToStart();
        }
        if (getPosition(view) == getItemCount() - 1) {
            return null;
        }
        o(recycler, getPosition(getChildAt(getChildCount() - 1)) + 1, -1);
        return getChildClosestToEnd();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(getPosition(getChildAt(0)));
            accessibilityEvent.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        f0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        f0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.getItemCount() <= 0 || y() <= 0.0f) {
            removeAndRecycleAllViews(recycler);
            this.i = 0;
            return;
        }
        boolean zP = P();
        boolean z = this.g == null;
        if (z) {
            W(recycler);
        }
        int iW = w(this.g);
        int iT = t(state, this.g);
        this.b = zP ? iT : iW;
        if (zP) {
            iT = iW;
        }
        this.c = iT;
        if (z) {
            this.a = iW;
            this.j = this.g.i(getItemCount(), this.b, this.c, P());
            int i = this.n;
            if (i != -1) {
                this.a = M(i, B(i));
            }
        }
        int i2 = this.a;
        this.a = i2 + v(0, i2, this.b, this.c);
        this.i = eh1.b(this.i, 0, state.getItemCount());
        e0(this.g);
        detachAndScrapAttachedViews(recycler);
        x(recycler, state);
        this.m = getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        if (getChildCount() == 0) {
            this.i = 0;
        } else {
            this.i = getPosition(getChildAt(0));
        }
        g0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
        int iN;
        if (this.g == null || (iN = N(getPosition(view), B(getPosition(view)))) == 0) {
            return false;
        }
        Z(recyclerView, N(getPosition(view), this.g.j(this.a + v(iN, this.a, this.b, this.c), this.b, this.c)));
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollHorizontally()) {
            return scrollBy(i, recycler, state);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.n = i;
        if (this.g == null) {
            return;
        }
        this.a = M(i, B(i));
        this.i = eh1.b(i, 0, Math.max(0, getItemCount() - 1));
        e0(this.g);
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollVertically()) {
            return scrollBy(i, recycler, state);
        }
        return 0;
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        assertNotInLayoutOrScroll(null);
        com.google.android.material.carousel.c cVar = this.k;
        if (cVar == null || i != cVar.a) {
            this.k = com.google.android.material.carousel.c.c(this, i);
            X();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i);
        startSmoothScroll(aVar);
    }

    int u(int i) {
        return (int) (this.a - M(i, B(i)));
    }

    public CarouselLayoutManager(com.google.android.material.carousel.d dVar) {
        this(dVar, 0);
    }

    public CarouselLayoutManager(com.google.android.material.carousel.d dVar, int i) {
        this.d = false;
        this.e = new c();
        this.i = 0;
        this.l = new View.OnLayoutChangeListener() { // from class: rw
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                this.a.S(view, i2, i3, i4, i5, i6, i7, i8, i9);
            }
        };
        this.n = -1;
        this.o = 0;
        c0(dVar);
        setOrientation(i);
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.d = false;
        this.e = new c();
        this.i = 0;
        this.l = new View.OnLayoutChangeListener() { // from class: rw
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                this.a.S(view, i3, i4, i5, i6, i7, i8, i9, i10);
            }
        };
        this.n = -1;
        this.o = 0;
        c0(new i());
        b0(context, attributeSet);
    }
}
