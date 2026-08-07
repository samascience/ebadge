package com.phy.ota_demo.utils;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class SlideRecyclerView extends RecyclerView {
    private VelocityTracker a;
    private int b;
    private Rect c;
    private Scroller d;
    private float e;
    private float f;
    private float g;
    private boolean h;
    private ViewGroup i;
    private int j;
    private int k;

    public SlideRecyclerView(Context context) {
        this(context, null);
    }

    private void b(MotionEvent motionEvent) {
        if (this.a == null) {
            this.a = VelocityTracker.obtain();
        }
        this.a.addMovement(motionEvent);
    }

    private void d() {
        VelocityTracker velocityTracker = this.a;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.a.recycle();
            this.a = null;
        }
    }

    public void a() {
        ViewGroup viewGroup = this.i;
        if (viewGroup == null || viewGroup.getScrollX() == 0) {
            return;
        }
        this.i.scrollTo(0, 0);
    }

    public int c(int i, int i2) {
        int iFindFirstVisibleItemPosition = ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();
        Rect rect = this.c;
        if (rect == null) {
            rect = new Rect();
            this.c = rect;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return iFindFirstVisibleItemPosition + childCount;
                }
            }
        }
        return -1;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.d.computeScrollOffset()) {
            this.i.scrollTo(this.d.getCurrX(), this.d.getCurrY());
            invalidate();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0065, code lost:
    
        if (java.lang.Math.abs(r0 - r7.f) > java.lang.Math.abs(r1 - r7.g)) goto L15;
     */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phy.ota_demo.utils.SlideRecyclerView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.h || this.j == -1) {
            a();
            d();
            return super.onTouchEvent(motionEvent);
        }
        float x = motionEvent.getX();
        b(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1) {
            if (this.k != -1) {
                int scrollX = this.i.getScrollX();
                this.a.computeCurrentVelocity(1000);
                if (this.a.getXVelocity() < -600.0f) {
                    Scroller scroller = this.d;
                    int i = this.k;
                    scroller.startScroll(scrollX, 0, i - scrollX, 0, Math.abs(i - scrollX));
                } else if (this.a.getXVelocity() >= 600.0f) {
                    this.d.startScroll(scrollX, 0, -scrollX, 0, Math.abs(scrollX));
                } else {
                    int i2 = this.k;
                    if (scrollX >= i2 / 2) {
                        this.d.startScroll(scrollX, 0, i2 - scrollX, 0, Math.abs(i2 - scrollX));
                    } else {
                        this.d.startScroll(scrollX, 0, -scrollX, 0, Math.abs(scrollX));
                    }
                }
                invalidate();
            }
            this.k = -1;
            this.h = false;
            this.j = -1;
            d();
        } else if (action == 2 && this.k != -1) {
            float f = this.e - x;
            if (this.i.getScrollX() + f <= this.k && this.i.getScrollX() + f > 0.0f) {
                this.i.scrollBy((int) f, 0);
            }
            this.e = x;
        }
        return true;
    }

    public SlideRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = ViewConfiguration.get(context).getScaledTouchSlop();
        this.d = new Scroller(context);
    }
}
