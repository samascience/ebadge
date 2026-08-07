package androidx.viewpager2.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.R$styleable;
import defpackage.be3;
import defpackage.m2;
import defpackage.p2;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {
    static boolean u = true;
    private final Rect a;
    private final Rect b;
    private androidx.viewpager2.widget.b c;
    int d;
    boolean e;
    private RecyclerView.AdapterDataObserver f;
    private LinearLayoutManager g;
    private int h;
    private Parcelable i;
    RecyclerView j;
    private PagerSnapHelper k;
    androidx.viewpager2.widget.g l;
    private androidx.viewpager2.widget.b m;
    private androidx.viewpager2.widget.d n;
    private androidx.viewpager2.widget.f o;
    private RecyclerView.ItemAnimator p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f204q;
    private boolean r;
    private int s;
    e t;

    class a extends g {
        a() {
            super(null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.e = true;
            viewPager2.l.j();
        }
    }

    class b extends i {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                ViewPager2.this.q();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageSelected(int i) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.d != i) {
                viewPager2.d = i;
                viewPager2.t.q();
            }
        }
    }

    class c extends i {
        c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageSelected(int i) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.j.requestFocus(2);
            }
        }
    }

    class d implements RecyclerView.OnChildAttachStateChangeListener {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) layoutParams).width != -1 || ((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View view) {
        }
    }

    private abstract class e {
        private e() {
        }

        boolean a() {
            return false;
        }

        boolean b(int i) {
            return false;
        }

        boolean c(int i, Bundle bundle) {
            return false;
        }

        boolean d() {
            return false;
        }

        void e(RecyclerView.Adapter adapter) {
        }

        void f(RecyclerView.Adapter adapter) {
        }

        String g() {
            throw new IllegalStateException("Not implemented.");
        }

        void h(androidx.viewpager2.widget.b bVar, RecyclerView recyclerView) {
        }

        void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        void j(m2 m2Var) {
        }

        boolean k(int i) {
            throw new IllegalStateException("Not implemented.");
        }

        boolean l(int i, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        void m() {
        }

        CharSequence n() {
            throw new IllegalStateException("Not implemented.");
        }

        void o(AccessibilityEvent accessibilityEvent) {
        }

        void p() {
        }

        void q() {
        }

        void r() {
        }

        void s() {
        }

        /* synthetic */ e(ViewPager2 viewPager2, a aVar) {
            this();
        }
    }

    class f extends e {
        f() {
            super(ViewPager2.this, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean b(int i) {
            return (i == 8192 || i == 4096) && !ViewPager2.this.g();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean d() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void j(m2 m2Var) {
            if (ViewPager2.this.g()) {
                return;
            }
            m2Var.b0(m2.a.r);
            m2Var.b0(m2.a.f352q);
            m2Var.G0(false);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean k(int i) {
            if (b(i)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public CharSequence n() {
            if (d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    private static abstract class g extends RecyclerView.AdapterDataObserver {
        private g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        /* synthetic */ g(a aVar) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2, Object obj) {
            onChanged();
        }
    }

    private class h extends LinearLayoutManager {
        h(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(state, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, m2 m2Var) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, m2Var);
            ViewPager2.this.t.j(m2Var);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(RecyclerView.Recycler recycler, RecyclerView.State state, int i, Bundle bundle) {
            return ViewPager2.this.t.b(i) ? ViewPager2.this.t.k(i) : super.performAccessibilityAction(recycler, state, i, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }
    }

    public static abstract class i {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public abstract void onPageSelected(int i);
    }

    class j extends e {
        private final p2 b;
        private final p2 c;
        private RecyclerView.AdapterDataObserver d;

        class a implements p2 {
            a() {
            }

            @Override // defpackage.p2
            public boolean a(View view, p2.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        class b implements p2 {
            b() {
            }

            @Override // defpackage.p2
            public boolean a(View view, p2.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        class c extends g {
            c() {
                super(null);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                j.this.w();
            }
        }

        j() {
            super(ViewPager2.this, null);
            this.b = new a();
            this.c = new b();
        }

        private void t(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            int itemCount2;
            if (ViewPager2.this.getAdapter() == null) {
                itemCount = 0;
                itemCount2 = 0;
            } else if (ViewPager2.this.getOrientation() == 1) {
                itemCount = ViewPager2.this.getAdapter().getItemCount();
                itemCount2 = 0;
            } else {
                itemCount2 = ViewPager2.this.getAdapter().getItemCount();
                itemCount = 0;
            }
            m2.Q0(accessibilityNodeInfo).l0(m2.e.b(itemCount, itemCount2, false, 0));
        }

        private void u(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
            if (adapter == null || (itemCount = adapter.getItemCount()) == 0 || !ViewPager2.this.g()) {
                return;
            }
            if (ViewPager2.this.d > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (ViewPager2.this.d < itemCount - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
            accessibilityNodeInfo.setScrollable(true);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean a() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean c(int i, Bundle bundle) {
            return i == 8192 || i == 4096;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void e(RecyclerView.Adapter adapter) {
            w();
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void f(RecyclerView.Adapter adapter) {
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(this.d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public String g() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void h(androidx.viewpager2.widget.b bVar, RecyclerView recyclerView) {
            be3.z0(recyclerView, 2);
            this.d = new c();
            if (be3.y(ViewPager2.this) == 0) {
                be3.z0(ViewPager2.this, 1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
            t(accessibilityNodeInfo);
            u(accessibilityNodeInfo);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean l(int i, Bundle bundle) {
            if (!c(i, bundle)) {
                throw new IllegalStateException();
            }
            v(i == 8192 ? ViewPager2.this.getCurrentItem() - 1 : ViewPager2.this.getCurrentItem() + 1);
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void m() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void o(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(g());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void p() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void q() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void r() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void s() {
            w();
        }

        void v(int i) {
            if (ViewPager2.this.g()) {
                ViewPager2.this.m(i, true);
            }
        }

        void w() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i = R.id.accessibilityActionPageLeft;
            be3.j0(viewPager2, R.id.accessibilityActionPageLeft);
            be3.j0(viewPager2, R.id.accessibilityActionPageRight);
            be3.j0(viewPager2, R.id.accessibilityActionPageUp);
            be3.j0(viewPager2, R.id.accessibilityActionPageDown);
            if (ViewPager2.this.getAdapter() == null || (itemCount = ViewPager2.this.getAdapter().getItemCount()) == 0 || !ViewPager2.this.g()) {
                return;
            }
            if (ViewPager2.this.getOrientation() != 0) {
                if (ViewPager2.this.d < itemCount - 1) {
                    be3.l0(viewPager2, new m2.a(R.id.accessibilityActionPageDown, null), null, this.b);
                }
                if (ViewPager2.this.d > 0) {
                    be3.l0(viewPager2, new m2.a(R.id.accessibilityActionPageUp, null), null, this.c);
                    return;
                }
                return;
            }
            boolean zF = ViewPager2.this.f();
            int i2 = zF ? 16908360 : 16908361;
            if (zF) {
                i = 16908361;
            }
            if (ViewPager2.this.d < itemCount - 1) {
                be3.l0(viewPager2, new m2.a(i2, null), null, this.b);
            }
            if (ViewPager2.this.d > 0) {
                be3.l0(viewPager2, new m2.a(i, null), null, this.c);
            }
        }
    }

    public interface k {
        void transformPage(View view, float f);
    }

    private class l extends PagerSnapHelper {
        l() {
        }

        @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        public View findSnapView(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.e()) {
                return null;
            }
            return super.findSnapView(layoutManager);
        }
    }

    private class m extends RecyclerView {
        m(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.t.d() ? ViewPager2.this.t.n() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.d);
            accessibilityEvent.setToIndex(ViewPager2.this.d);
            ViewPager2.this.t.o(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.g() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.g() && super.onTouchEvent(motionEvent);
        }
    }

    private static class n implements Runnable {
        private final int a;
        private final RecyclerView b;

        n(int i, RecyclerView recyclerView) {
            this.a = i;
            this.b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.smoothScrollToPosition(this.a);
        }
    }

    public ViewPager2(Context context) {
        super(context);
        this.a = new Rect();
        this.b = new Rect();
        this.c = new androidx.viewpager2.widget.b(3);
        this.e = false;
        this.f = new a();
        this.h = -1;
        this.p = null;
        this.f204q = false;
        this.r = true;
        this.s = -1;
        d(context, null);
    }

    private RecyclerView.OnChildAttachStateChangeListener c() {
        return new d();
    }

    private void d(Context context, AttributeSet attributeSet) {
        this.t = u ? new j() : new f();
        m mVar = new m(context);
        this.j = mVar;
        mVar.setId(be3.l());
        this.j.setDescendantFocusability(Opcodes.ACC_DEPRECATED);
        h hVar = new h(context);
        this.g = hVar;
        this.j.setLayoutManager(hVar);
        this.j.setScrollingTouchSlop(1);
        n(context, attributeSet);
        this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.j.addOnChildAttachStateChangeListener(c());
        androidx.viewpager2.widget.g gVar = new androidx.viewpager2.widget.g(this);
        this.l = gVar;
        this.n = new androidx.viewpager2.widget.d(this, gVar, this.j);
        l lVar = new l();
        this.k = lVar;
        lVar.attachToRecyclerView(this.j);
        this.j.addOnScrollListener(this.l);
        androidx.viewpager2.widget.b bVar = new androidx.viewpager2.widget.b(3);
        this.m = bVar;
        this.l.m(bVar);
        b bVar2 = new b();
        c cVar = new c();
        this.m.a(bVar2);
        this.m.a(cVar);
        this.t.h(this.m, this.j);
        this.m.a(this.c);
        androidx.viewpager2.widget.f fVar = new androidx.viewpager2.widget.f(this.g);
        this.o = fVar;
        this.m.a(fVar);
        RecyclerView recyclerView = this.j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void h(RecyclerView.Adapter adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f);
        }
    }

    private void k() {
        RecyclerView.Adapter adapter;
        if (this.h == -1 || (adapter = getAdapter()) == null) {
            return;
        }
        if (this.i != null) {
            this.i = null;
        }
        int iMax = Math.max(0, Math.min(this.h, adapter.getItemCount() - 1));
        this.d = iMax;
        this.h = -1;
        this.j.scrollToPosition(iMax);
        this.t.m();
    }

    private void n(Context context, AttributeSet attributeSet) {
        int[] iArr = R$styleable.ViewPager2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInt(R$styleable.ViewPager2_android_orientation, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void o(RecyclerView.Adapter adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.f);
        }
    }

    public void a(RecyclerView.ItemDecoration itemDecoration) {
        this.j.addItemDecoration(itemDecoration);
    }

    public void b(RecyclerView.ItemDecoration itemDecoration, int i2) {
        this.j.addItemDecoration(itemDecoration, i2);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        return this.j.canScrollHorizontally(i2);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i2) {
        return this.j.canScrollVertically(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Parcelable parcelable = (Parcelable) sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i2 = ((SavedState) parcelable).a;
            sparseArray.put(this.j.getId(), sparseArray.get(i2));
            sparseArray.remove(i2);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        k();
    }

    public boolean e() {
        return this.n.a();
    }

    boolean f() {
        return this.g.getLayoutDirection() == 1;
    }

    public boolean g() {
        return this.r;
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return this.t.a() ? this.t.g() : super.getAccessibilityClassName();
    }

    public RecyclerView.Adapter getAdapter() {
        return this.j.getAdapter();
    }

    public int getCurrentItem() {
        return this.d;
    }

    public int getItemDecorationCount() {
        return this.j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.s;
    }

    public int getOrientation() {
        return this.g.getOrientation();
    }

    int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.j;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.l.f();
    }

    public void i(i iVar) {
        this.c.a(iVar);
    }

    public void j() {
        if (this.o.a() == null) {
            return;
        }
        double dE = this.l.e();
        int i2 = (int) dE;
        float f2 = (float) (dE - ((double) i2));
        this.o.onPageScrolled(i2, f2, Math.round(getPageSize() * f2));
    }

    public void l(int i2, boolean z) {
        if (e()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        m(i2, z);
    }

    void m(int i2, boolean z) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.h != -1) {
                this.h = Math.max(i2, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i2, 0), adapter.getItemCount() - 1);
        if (iMin == this.d && this.l.h()) {
            return;
        }
        int i3 = this.d;
        if (iMin == i3 && z) {
            return;
        }
        double dE = i3;
        this.d = iMin;
        this.t.q();
        if (!this.l.h()) {
            dE = this.l.e();
        }
        this.l.k(iMin, z);
        if (!z) {
            this.j.scrollToPosition(iMin);
            return;
        }
        double d2 = iMin;
        if (Math.abs(d2 - dE) <= 3.0d) {
            this.j.smoothScrollToPosition(iMin);
            return;
        }
        this.j.scrollToPosition(d2 > dE ? iMin - 3 : iMin + 3);
        RecyclerView recyclerView = this.j;
        recyclerView.post(new n(iMin, recyclerView));
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.t.i(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.j.getMeasuredWidth();
        int measuredHeight = this.j.getMeasuredHeight();
        this.a.left = getPaddingLeft();
        this.a.right = (i4 - i2) - getPaddingRight();
        this.a.top = getPaddingTop();
        this.a.bottom = (i5 - i3) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.a, this.b);
        RecyclerView recyclerView = this.j;
        Rect rect = this.b;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.e) {
            q();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        measureChild(this.j, i2, i3);
        int measuredWidth = this.j.getMeasuredWidth();
        int measuredHeight = this.j.getMeasuredHeight();
        int measuredState = this.j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, measuredState << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.h = savedState.b;
        this.i = savedState.c;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.j.getId();
        int i2 = this.h;
        if (i2 == -1) {
            i2 = this.d;
        }
        savedState.b = i2;
        Parcelable parcelable = this.i;
        if (parcelable != null) {
            savedState.c = parcelable;
        } else {
            this.j.getAdapter();
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    public void p(i iVar) {
        this.c.b(iVar);
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        return this.t.c(i2, bundle) ? this.t.l(i2, bundle) : super.performAccessibilityAction(i2, bundle);
    }

    void q() {
        PagerSnapHelper pagerSnapHelper = this.k;
        if (pagerSnapHelper == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View viewFindSnapView = pagerSnapHelper.findSnapView(this.g);
        if (viewFindSnapView == null) {
            return;
        }
        int position = this.g.getPosition(viewFindSnapView);
        if (position != this.d && getScrollState() == 0) {
            this.m.onPageSelected(position);
        }
        this.e = false;
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.j.getAdapter();
        this.t.f(adapter2);
        o(adapter2);
        this.j.setAdapter(adapter);
        this.d = 0;
        k();
        this.t.e(adapter);
        h(adapter);
    }

    public void setCurrentItem(int i2) {
        l(i2, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i2) {
        super.setLayoutDirection(i2);
        this.t.p();
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1 && i2 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.s = i2;
        this.j.requestLayout();
    }

    public void setOrientation(int i2) {
        this.g.setOrientation(i2);
        this.t.r();
    }

    public void setPageTransformer(k kVar) {
        if (kVar != null) {
            if (!this.f204q) {
                this.p = this.j.getItemAnimator();
                this.f204q = true;
            }
            this.j.setItemAnimator(null);
        } else if (this.f204q) {
            this.j.setItemAnimator(this.p);
            this.p = null;
            this.f204q = false;
        }
        if (kVar == this.o.a()) {
            return;
        }
        this.o.b(kVar);
        j();
    }

    public void setUserInputEnabled(boolean z) {
        this.r = z;
        this.t.s();
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int a;
        int b;
        Parcelable c;

        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeParcelable(this.c, i);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Rect();
        this.b = new Rect();
        this.c = new androidx.viewpager2.widget.b(3);
        this.e = false;
        this.f = new a();
        this.h = -1;
        this.p = null;
        this.f204q = false;
        this.r = true;
        this.s = -1;
        d(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new Rect();
        this.b = new Rect();
        this.c = new androidx.viewpager2.widget.b(3);
        this.e = false;
        this.f = new a();
        this.h = -1;
        this.p = null;
        this.f204q = false;
        this.r = true;
        this.s = -1;
        d(context, attributeSet);
    }
}
