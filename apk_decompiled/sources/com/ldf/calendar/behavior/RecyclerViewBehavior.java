package com.ldf.calendar.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.ldf.calendar.view.MonthPager;
import defpackage.be3;
import defpackage.sa3;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public class RecyclerViewBehavior extends CoordinatorLayout.c {
    private int a;
    private int b;
    private Context c;
    private boolean d;
    boolean e;
    boolean f;

    public RecyclerViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1;
        this.b = -1;
        this.d = false;
        this.e = false;
        this.f = false;
        this.c = context;
    }

    private MonthPager I(CoordinatorLayout coordinatorLayout) {
        return (MonthPager) coordinatorLayout.getChildAt(0);
    }

    private void J(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, MonthPager monthPager) {
        if (monthPager.getBottom() > 0 && this.a == -1) {
            int viewHeight = monthPager.getViewHeight();
            this.a = viewHeight;
            Q(viewHeight);
        }
        if (!this.d) {
            int viewHeight2 = monthPager.getViewHeight();
            this.a = viewHeight2;
            Q(viewHeight2);
            this.d = true;
        }
        recyclerView.offsetTopAndBottom(sa3.i());
        this.b = I(coordinatorLayout).getCellHeight();
    }

    private void Q(int i) {
        sa3.j(i);
        if (sa3.i() == this.a) {
            sa3.m(false);
        } else if (sa3.i() == this.b) {
            sa3.m(true);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public boolean p(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, int i) {
        coordinatorLayout.M(recyclerView, i);
        J(coordinatorLayout, recyclerView, I(coordinatorLayout));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public boolean r(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, float f, float f2, boolean z) {
        Log.d("ldf", "onNestedFling: velocityY: " + f2);
        return super.r(coordinatorLayout, recyclerView, view, f, f2, z);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public boolean s(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, float f, float f2) {
        return this.e || this.f;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public void t(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, int i, int i2, int[] iArr) {
        Log.e("ldf", "onNestedPreScroll");
        super.t(coordinatorLayout, recyclerView, view, i, i2, iArr);
        recyclerView.setVerticalScrollBarEnabled(true);
        boolean z = false;
        if (((MonthPager) coordinatorLayout.getChildAt(0)).getPageScrollState() != 0) {
            iArr[1] = i2;
            Log.w("ldf", "onNestedPreScroll: MonthPager dragging");
            Toast.makeText(this.c, "loading month data", 0).show();
            return;
        }
        this.e = i2 > 0 && recyclerView.getTop() <= this.a && recyclerView.getTop() > I(coordinatorLayout).getCellHeight();
        if (i2 < 0 && !be3.f(view, -1)) {
            z = true;
        }
        this.f = z;
        if (this.e || z) {
            iArr[1] = sa3.k(recyclerView, i2, I(coordinatorLayout).getCellHeight(), I(coordinatorLayout).getViewHeight());
            Q(recyclerView.getTop());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public boolean D(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, View view2, int i) {
        Log.e("ldf", "onStartNestedScroll");
        ((MonthPager) coordinatorLayout.getChildAt(0)).setScrollable(false);
        return (i & 2) != 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public void F(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view) {
        Log.e("ldf", "onStopNestedScroll");
        super.F(coordinatorLayout, recyclerView, view);
        ((MonthPager) coordinatorLayout.getChildAt(0)).setScrollable(true);
        if (sa3.h()) {
            if (sa3.i() - this.b <= sa3.f(this.c) || !this.f) {
                sa3.l(coordinatorLayout, recyclerView, I(coordinatorLayout).getCellHeight(), Opcodes.FCMPG);
                return;
            } else {
                sa3.l(coordinatorLayout, recyclerView, I(coordinatorLayout).getViewHeight(), 500);
                return;
            }
        }
        if (this.a - sa3.i() <= sa3.f(this.c) || !this.e) {
            sa3.l(coordinatorLayout, recyclerView, I(coordinatorLayout).getViewHeight(), Opcodes.FCMPG);
        } else {
            sa3.l(coordinatorLayout, recyclerView, I(coordinatorLayout).getCellHeight(), 500);
        }
    }
}
