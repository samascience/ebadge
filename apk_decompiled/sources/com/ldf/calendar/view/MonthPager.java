package com.ldf.calendar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.ViewPager;
import com.ldf.calendar.behavior.MonthPagerBehavior;
import defpackage.e43;

/* JADX INFO: loaded from: classes3.dex */
@CoordinatorLayout.d(MonthPagerBehavior.class)
public class MonthPager extends ViewPager {
    public static int z0 = 1000;
    private int q0;
    private int r0;
    private int s0;
    private int t0;
    private b u0;
    private boolean v0;
    private boolean w0;
    private boolean x0;
    private int y0;

    class a implements ViewPager.j {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i) {
            MonthPager.this.y0 = i;
            if (MonthPager.this.u0 != null) {
                MonthPager.this.u0.onPageScrollStateChanged(i);
            }
            MonthPager.this.v0 = true;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i, float f, int i2) {
            if (MonthPager.this.u0 != null) {
                MonthPager.this.u0.onPageScrolled(i, f, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i) {
            MonthPager.this.q0 = i;
            if (MonthPager.this.v0) {
                if (MonthPager.this.u0 != null) {
                    MonthPager.this.u0.onPageSelected(i);
                }
                MonthPager.this.v0 = false;
            }
        }
    }

    public interface b {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    public MonthPager(Context context) {
        this(context, null);
    }

    private void b0() {
        c(new a());
        this.w0 = true;
    }

    public void a0(b bVar) {
        this.u0 = bVar;
        Log.e("ldf", "MonthPager Just Can Use Own OnPageChangeListener");
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void c(ViewPager.j jVar) {
        if (this.w0) {
            Log.e("ldf", "MonthPager Just Can Use Own OnPageChangeListener");
        } else {
            super.c(jVar);
        }
    }

    public int getCellHeight() {
        return this.r0;
    }

    public int getCurrentPosition() {
        return this.q0;
    }

    public int getPageScrollState() {
        return this.y0;
    }

    public int getRowIndex() {
        e43.a(getAdapter());
        throw null;
    }

    public int getTopMovableDistance() {
        e43.a(getAdapter());
        return this.r0;
    }

    public int getViewHeight() {
        return this.s0;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.x0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.x0) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setCurrentPosition(int i) {
        this.q0 = i;
    }

    public void setRowIndex(int i) {
        this.t0 = i;
    }

    public void setScrollable(boolean z) {
        this.x0 = z;
    }

    public void setViewHeight(int i) {
        this.r0 = i / 6;
        this.s0 = i;
    }

    public MonthPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q0 = z0;
        this.t0 = 6;
        this.v0 = false;
        this.w0 = false;
        this.x0 = true;
        this.y0 = 0;
        b0();
    }
}
