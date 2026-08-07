package com.ldf.calendar.behavior;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.ldf.calendar.view.MonthPager;
import defpackage.e43;
import defpackage.sa3;

/* JADX INFO: loaded from: classes3.dex */
public class MonthPagerBehavior extends CoordinatorLayout.c {
    private float d;
    private float e;
    private float f;
    private float g;
    private boolean h;
    private boolean i;
    private int a = 0;
    private int b = 1;
    private int c = 0;
    private int j = -1;

    private void N(int i) {
        sa3.j(i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public boolean i(CoordinatorLayout coordinatorLayout, MonthPager monthPager, View view) {
        return view instanceof RecyclerView;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public boolean l(CoordinatorLayout coordinatorLayout, MonthPager monthPager, View view) {
        int i;
        int i2;
        e43.a(monthPager.getAdapter());
        if (this.j != -1) {
            int top = view.getTop() - this.j;
            int top2 = monthPager.getTop();
            int i3 = this.b;
            if (top > i3) {
                throw null;
            }
            if (top < (-i3)) {
                monthPager.getRowIndex();
                throw null;
            }
            int i4 = -top2;
            if (top > i4) {
                top = i4;
            }
            if (top < i4 - monthPager.getTopMovableDistance()) {
                top = i4 - monthPager.getTopMovableDistance();
            }
            monthPager.offsetTopAndBottom(top);
            Log.e("ldf", "onDependentViewChanged = " + top);
        }
        this.j = view.getTop();
        this.a = monthPager.getTop();
        if (this.c > monthPager.getCellHeight()) {
            throw null;
        }
        if (this.c < (-monthPager.getCellHeight())) {
            monthPager.getRowIndex();
            throw null;
        }
        if (this.j > monthPager.getCellHeight() - 24 && this.j < monthPager.getCellHeight() + 24 && this.a > (-this.b) - monthPager.getTopMovableDistance() && this.a < this.b - monthPager.getTopMovableDistance()) {
            sa3.m(true);
            monthPager.getRowIndex();
            throw null;
        }
        if (this.j <= monthPager.getViewHeight() - 24 || this.j >= monthPager.getViewHeight() + 24 || (i = this.a) >= (i2 = this.b) || i <= (-i2)) {
            return true;
        }
        sa3.m(false);
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public boolean o(CoordinatorLayout coordinatorLayout, MonthPager monthPager, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.d = motionEvent.getX();
            this.e = motionEvent.getY();
            this.g = sa3.i();
            this.f = this.e;
        } else if (action != 1) {
            if (action == 2) {
                if (this.e > this.g) {
                    return false;
                }
                if (Math.abs(motionEvent.getY() - this.e) > 25.0f && Math.abs(motionEvent.getX() - this.d) <= 25.0f && !this.h) {
                    this.h = true;
                    return true;
                }
            }
        } else if (this.h) {
            this.h = false;
            return true;
        }
        return this.h;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public boolean p(CoordinatorLayout coordinatorLayout, MonthPager monthPager, int i) {
        coordinatorLayout.M(monthPager, i);
        monthPager.offsetTopAndBottom(this.a);
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public boolean H(CoordinatorLayout coordinatorLayout, MonthPager monthPager, MotionEvent motionEvent) {
        if (this.e > this.g) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2 && this.h) {
                if (motionEvent.getY() > this.f) {
                    sa3.m(true);
                    this.i = false;
                } else {
                    sa3.m(false);
                    this.i = true;
                }
                if (this.g < (monthPager.getViewHeight() / 2) + (monthPager.getCellHeight() / 2)) {
                    if (motionEvent.getY() - this.e <= 0.0f || sa3.i() >= monthPager.getViewHeight()) {
                        this.f = motionEvent.getY();
                        return true;
                    }
                    if ((motionEvent.getY() - this.e) + monthPager.getCellHeight() >= monthPager.getViewHeight()) {
                        N(monthPager.getViewHeight());
                        sa3.l(coordinatorLayout, (RecyclerView) coordinatorLayout.getChildAt(1), monthPager.getViewHeight(), 10);
                        this.h = false;
                    } else {
                        N((int) (monthPager.getCellHeight() + (motionEvent.getY() - this.e)));
                        sa3.k(coordinatorLayout.getChildAt(1), (int) (this.f - motionEvent.getY()), monthPager.getCellHeight(), monthPager.getViewHeight());
                    }
                } else {
                    if (motionEvent.getY() - this.e >= 0.0f || sa3.i() <= monthPager.getCellHeight()) {
                        this.f = motionEvent.getY();
                        return true;
                    }
                    if ((motionEvent.getY() - this.e) + monthPager.getViewHeight() <= monthPager.getCellHeight()) {
                        N(monthPager.getCellHeight());
                        sa3.l(coordinatorLayout, (RecyclerView) coordinatorLayout.getChildAt(1), monthPager.getCellHeight(), 10);
                        this.h = false;
                    } else {
                        N((int) (monthPager.getViewHeight() + (motionEvent.getY() - this.e)));
                        sa3.k(coordinatorLayout.getChildAt(1), (int) (this.f - motionEvent.getY()), monthPager.getCellHeight(), monthPager.getViewHeight());
                    }
                }
                this.f = motionEvent.getY();
                return true;
            }
        } else if (this.h) {
            monthPager.setScrollable(true);
            e43.a(monthPager.getAdapter());
            this.h = false;
            return true;
        }
        return false;
    }
}
