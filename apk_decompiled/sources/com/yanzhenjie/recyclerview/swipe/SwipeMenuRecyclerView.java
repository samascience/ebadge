package com.yanzhenjie.recyclerview.swipe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import defpackage.b80;
import defpackage.hv1;
import defpackage.iv1;
import defpackage.jy2;
import defpackage.ky2;
import defpackage.lv1;
import defpackage.my2;
import defpackage.oy2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SwipeMenuRecyclerView extends RecyclerView {
    protected int a;
    protected SwipeMenuLayout b;
    protected int c;
    private int d;
    private int e;
    private boolean f;
    private b80 g;
    private my2 h;
    private oy2 i;
    private jy2 j;
    private ky2 k;
    private com.yanzhenjie.recyclerview.swipe.a l;
    private RecyclerView.AdapterDataObserver m;
    private List n;
    private List o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f320q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private f v;

    class a extends GridLayoutManager.SpanSizeLookup {
        final /* synthetic */ GridLayoutManager a;
        final /* synthetic */ GridLayoutManager.SpanSizeLookup b;

        a(GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
            this.a = gridLayoutManager;
            this.b = spanSizeLookup;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            if (SwipeMenuRecyclerView.this.l.m(i) || SwipeMenuRecyclerView.this.l.l(i)) {
                return this.a.getSpanCount();
            }
            GridLayoutManager.SpanSizeLookup spanSizeLookup = this.b;
            if (spanSizeLookup != null) {
                return spanSizeLookup.getSpanSize(i - SwipeMenuRecyclerView.this.getHeaderItemCount());
            }
            return 1;
        }
    }

    private static class c implements jy2 {
        private SwipeMenuRecyclerView a;
        private jy2 b;

        public c(SwipeMenuRecyclerView swipeMenuRecyclerView, jy2 jy2Var) {
            this.a = swipeMenuRecyclerView;
            this.b = jy2Var;
        }

        @Override // defpackage.jy2
        public void onItemClick(View view, int i) {
            int headerItemCount = i - this.a.getHeaderItemCount();
            if (headerItemCount >= 0) {
                this.b.onItemClick(view, headerItemCount);
            }
        }
    }

    private static class d implements ky2 {
        private SwipeMenuRecyclerView a;
        private ky2 b;

        public d(SwipeMenuRecyclerView swipeMenuRecyclerView, ky2 ky2Var) {
            this.a = swipeMenuRecyclerView;
            this.b = ky2Var;
        }

        @Override // defpackage.ky2
        public void a(View view, int i) {
            int headerItemCount = i - this.a.getHeaderItemCount();
            if (headerItemCount >= 0) {
                this.b.a(view, headerItemCount);
            }
        }
    }

    public interface e {
    }

    public interface f {
        void a(e eVar);

        void b();
    }

    private static class g implements oy2 {
        private SwipeMenuRecyclerView a;
        private oy2 b;

        public g(SwipeMenuRecyclerView swipeMenuRecyclerView, oy2 oy2Var) {
            this.a = swipeMenuRecyclerView;
            this.b = oy2Var;
        }

        @Override // defpackage.oy2
        public void a(com.yanzhenjie.recyclerview.swipe.d dVar) {
            int iB = dVar.b() - this.a.getHeaderItemCount();
            if (iB >= 0) {
                dVar.e = iB;
                this.b.a(dVar);
            }
        }
    }

    public SwipeMenuRecyclerView(Context context) {
        this(context, null);
    }

    private void b(String str) {
        if (this.l != null) {
            throw new IllegalStateException(str);
        }
    }

    private void c() {
        if (this.s) {
            return;
        }
        if (!this.r) {
            f fVar = this.v;
            if (fVar != null) {
                fVar.a(null);
                return;
            }
            return;
        }
        if (this.f320q || this.t || !this.u) {
            return;
        }
        this.f320q = true;
        f fVar2 = this.v;
        if (fVar2 != null) {
            fVar2.b();
        }
    }

    private View d(View view) {
        if (view instanceof SwipeMenuLayout) {
            return view;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        while (!arrayList.isEmpty()) {
            View view2 = (View) arrayList.remove(0);
            if (view2 instanceof ViewGroup) {
                if (view2 instanceof SwipeMenuLayout) {
                    return view2;
                }
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    arrayList.add(viewGroup.getChildAt(i));
                }
            }
        }
        return view;
    }

    private boolean e(int i, int i2, boolean z) {
        int i3 = this.d - i;
        int i4 = this.e - i2;
        if (Math.abs(i3) > this.a && Math.abs(i3) > Math.abs(i4)) {
            return false;
        }
        if (Math.abs(i4) >= this.a || Math.abs(i3) >= this.a) {
            return z;
        }
        return false;
    }

    private void f() {
        if (this.g == null) {
            b80 b80Var = new b80();
            this.g = b80Var;
            b80Var.attachToRecyclerView(this);
        }
    }

    public int getFooterItemCount() {
        com.yanzhenjie.recyclerview.swipe.a aVar = this.l;
        if (aVar == null) {
            return 0;
        }
        return aVar.h();
    }

    public int getHeaderItemCount() {
        com.yanzhenjie.recyclerview.swipe.a aVar = this.l;
        if (aVar == null) {
            return 0;
        }
        return aVar.i();
    }

    public RecyclerView.Adapter getOriginAdapter() {
        com.yanzhenjie.recyclerview.swipe.a aVar = this.l;
        if (aVar == null) {
            return null;
        }
        return aVar.j();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        SwipeMenuLayout swipeMenuLayout;
        ViewParent parent;
        boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (this.f) {
            return zOnInterceptTouchEvent;
        }
        boolean z2 = true;
        if (motionEvent.getPointerCount() > 1) {
            return true;
        }
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    zOnInterceptTouchEvent = e(x, y, zOnInterceptTouchEvent);
                    if (this.b == null || (parent = getParent()) == null) {
                        return zOnInterceptTouchEvent;
                    }
                    int i = this.d - x;
                    boolean z3 = i > 0 && (this.b.f() || this.b.g());
                    boolean z4 = i < 0 && (this.b.e() || this.b.k());
                    if (!z3 && !z4) {
                        z2 = false;
                    }
                    parent.requestDisallowInterceptTouchEvent(z2);
                } else if (action != 3) {
                    return zOnInterceptTouchEvent;
                }
            }
            return e(x, y, zOnInterceptTouchEvent);
        }
        this.d = x;
        this.e = y;
        int childAdapterPosition = getChildAdapterPosition(findChildViewUnder(x, y));
        if (childAdapterPosition == this.c || (swipeMenuLayout = this.b) == null || !swipeMenuLayout.a()) {
            z = false;
        } else {
            this.b.b();
            z = true;
        }
        if (z) {
            this.b = null;
            this.c = -1;
            return z;
        }
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(childAdapterPosition);
        if (viewHolderFindViewHolderForAdapterPosition == null) {
            return z;
        }
        View viewD = d(viewHolderFindViewHolderForAdapterPosition.itemView);
        if (!(viewD instanceof SwipeMenuLayout)) {
            return z;
        }
        this.b = (SwipeMenuLayout) viewD;
        this.c = childAdapterPosition;
        return z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        this.p = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int i, int i2) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager != null && (layoutManager instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int itemCount = layoutManager.getItemCount();
            if (itemCount > 0 && itemCount == linearLayoutManager.findLastVisibleItemPosition() + 1) {
                int i3 = this.p;
                if (i3 == 1 || i3 == 2) {
                    c();
                    return;
                }
                return;
            }
            return;
        }
        if (layoutManager == null || !(layoutManager instanceof StaggeredGridLayoutManager)) {
            return;
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
        int itemCount2 = layoutManager.getItemCount();
        if (itemCount2 <= 0) {
            return;
        }
        int[] iArrFindLastCompletelyVisibleItemPositions = staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null);
        if (itemCount2 == iArrFindLastCompletelyVisibleItemPositions[iArrFindLastCompletelyVisibleItemPositions.length - 1] + 1) {
            int i4 = this.p;
            if (i4 == 1 || i4 == 2) {
                c();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        SwipeMenuLayout swipeMenuLayout;
        if (motionEvent.getAction() == 2 && (swipeMenuLayout = this.b) != null && swipeMenuLayout.a()) {
            this.b.b();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        com.yanzhenjie.recyclerview.swipe.a aVar = this.l;
        if (aVar != null) {
            aVar.j().unregisterAdapterDataObserver(this.m);
        }
        if (adapter == null) {
            this.l = null;
        } else {
            adapter.registerAdapterDataObserver(this.m);
            com.yanzhenjie.recyclerview.swipe.a aVar2 = new com.yanzhenjie.recyclerview.swipe.a(getContext(), adapter);
            this.l = aVar2;
            aVar2.n(this.j);
            this.l.o(this.k);
            this.l.p(this.h);
            this.l.q(this.i);
            if (this.n.size() > 0) {
                Iterator it = this.n.iterator();
                while (it.hasNext()) {
                    this.l.f((View) it.next());
                }
            }
            if (this.o.size() > 0) {
                Iterator it2 = this.o.iterator();
                while (it2.hasNext()) {
                    this.l.e((View) it2.next());
                }
            }
        }
        super.setAdapter(this.l);
    }

    public void setAutoLoadMore(boolean z) {
        this.r = z;
    }

    public void setItemViewSwipeEnabled(boolean z) {
        f();
        this.f = z;
        this.g.a(z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new a(gridLayoutManager, gridLayoutManager.getSpanSizeLookup()));
        }
        super.setLayoutManager(layoutManager);
    }

    public void setLoadMoreListener(e eVar) {
    }

    public void setLoadMoreView(f fVar) {
        this.v = fVar;
    }

    public void setLongPressDragEnabled(boolean z) {
        f();
        this.g.b(z);
    }

    public void setOnItemMoveListener(hv1 hv1Var) {
        f();
        this.g.c(hv1Var);
    }

    public void setOnItemMovementListener(iv1 iv1Var) {
        f();
        this.g.d(iv1Var);
    }

    public void setOnItemStateChangedListener(lv1 lv1Var) {
        f();
        this.g.e(lv1Var);
    }

    public void setSwipeItemClickListener(jy2 jy2Var) {
        if (jy2Var == null) {
            return;
        }
        b("Cannot set item click listener, setAdapter has already been called.");
        this.j = new c(this, jy2Var);
    }

    public void setSwipeItemLongClickListener(ky2 ky2Var) {
        if (ky2Var == null) {
            return;
        }
        b("Cannot set item long click listener, setAdapter has already been called.");
        this.k = new d(this, ky2Var);
    }

    public void setSwipeMenuCreator(my2 my2Var) {
        if (my2Var == null) {
            return;
        }
        b("Cannot set menu creator, setAdapter has already been called.");
        this.h = my2Var;
    }

    public void setSwipeMenuItemClickListener(oy2 oy2Var) {
        if (oy2Var == null) {
            return;
        }
        b("Cannot set menu item click listener, setAdapter has already been called.");
        this.i = new g(this, oy2Var);
    }

    class b extends RecyclerView.AdapterDataObserver {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            SwipeMenuRecyclerView.this.l.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            SwipeMenuRecyclerView.this.l.notifyItemRangeChanged(i + SwipeMenuRecyclerView.this.getHeaderItemCount(), i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            SwipeMenuRecyclerView.this.l.notifyItemRangeInserted(i + SwipeMenuRecyclerView.this.getHeaderItemCount(), i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            SwipeMenuRecyclerView.this.l.notifyItemMoved(i + SwipeMenuRecyclerView.this.getHeaderItemCount(), i2 + SwipeMenuRecyclerView.this.getHeaderItemCount());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            SwipeMenuRecyclerView.this.l.notifyItemRangeRemoved(i + SwipeMenuRecyclerView.this.getHeaderItemCount(), i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            SwipeMenuRecyclerView.this.l.notifyItemRangeChanged(i + SwipeMenuRecyclerView.this.getHeaderItemCount(), i2, obj);
        }
    }

    public SwipeMenuRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeMenuRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = -1;
        this.f = false;
        this.m = new b();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = -1;
        this.f320q = false;
        this.r = true;
        this.s = false;
        this.t = true;
        this.u = false;
        this.a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
