package com.yanzhenjie.recyclerview.swipe.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import defpackage.e43;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StickyNestedScrollView extends NestedScrollView {
    private ArrayList L;
    private View M;
    private float N;
    private final Runnable O;
    private int P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private int T;
    private Drawable U;
    private boolean V;
    private List W;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (StickyNestedScrollView.this.M != null) {
                StickyNestedScrollView stickyNestedScrollView = StickyNestedScrollView.this;
                int iJ0 = stickyNestedScrollView.j0(stickyNestedScrollView.M);
                StickyNestedScrollView stickyNestedScrollView2 = StickyNestedScrollView.this;
                int iI0 = stickyNestedScrollView2.i0(stickyNestedScrollView2.M);
                StickyNestedScrollView stickyNestedScrollView3 = StickyNestedScrollView.this;
                StickyNestedScrollView.this.invalidate(iJ0, iI0, stickyNestedScrollView3.k0(stickyNestedScrollView3.M), (int) (StickyNestedScrollView.this.getScrollY() + StickyNestedScrollView.this.M.getHeight() + StickyNestedScrollView.this.N));
            }
            StickyNestedScrollView.this.postDelayed(this, 16L);
        }
    }

    public StickyNestedScrollView(Context context) {
        this(context, null);
    }

    private boolean f0(View view) {
        if (!l0(view).contains("sticky")) {
            return false;
        }
        this.L.add(view);
        return true;
    }

    private void g0() {
        float fMin;
        Iterator it = this.L.iterator();
        View view = null;
        View view2 = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            View view3 = (View) it.next();
            int iM0 = (m0(view3) - getScrollY()) + (this.R ? 0 : getPaddingTop());
            if (iM0 <= 0) {
                if (view != null) {
                    if (iM0 > (m0(view) - getScrollY()) + (this.R ? 0 : getPaddingTop())) {
                    }
                }
                view = view3;
            } else {
                if (view2 != null) {
                    if (iM0 < (m0(view2) - getScrollY()) + (this.R ? 0 : getPaddingTop())) {
                    }
                }
                view2 = view3;
            }
        }
        if (view == null) {
            if (this.M != null) {
                List list = this.W;
                if (list != null) {
                    Iterator it2 = list.iterator();
                    if (it2.hasNext()) {
                        e43.a(it2.next());
                        throw null;
                    }
                }
                s0();
                return;
            }
            return;
        }
        if (view2 == null) {
            fMin = 0.0f;
        } else {
            fMin = Math.min(0, ((m0(view2) - getScrollY()) + (this.R ? 0 : getPaddingTop())) - view.getHeight());
        }
        this.N = fMin;
        View view4 = this.M;
        if (view != view4) {
            if (view4 != null) {
                List list2 = this.W;
                if (list2 != null) {
                    Iterator it3 = list2.iterator();
                    if (it3.hasNext()) {
                        e43.a(it3.next());
                        throw null;
                    }
                }
                s0();
            }
            this.P = j0(view);
            r0(view);
            List list3 = this.W;
            if (list3 != null) {
                Iterator it4 = list3.iterator();
                if (it4.hasNext()) {
                    e43.a(it4.next());
                    throw null;
                }
            }
        }
    }

    private void h0(View view) {
        if (f0(view) || !(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            h0(viewGroup.getChildAt(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int i0(View view) {
        int bottom = view.getBottom();
        while (view.getParent() != null && view.getParent() != getChildAt(0)) {
            view = (View) view.getParent();
            bottom += view.getBottom();
        }
        return bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int j0(View view) {
        int left = view.getLeft();
        while (view.getParent() != null && view.getParent() != getChildAt(0)) {
            view = (View) view.getParent();
            left += view.getLeft();
        }
        return left;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int k0(View view) {
        int right = view.getRight();
        while (view.getParent() != null && view.getParent() != getChildAt(0)) {
            view = (View) view.getParent();
            right += view.getRight();
        }
        return right;
    }

    private String l0(View view) {
        return String.valueOf(view.getTag());
    }

    private int m0(View view) {
        int top = view.getTop();
        while (view.getParent() != null && view.getParent() != getChildAt(0)) {
            view = (View) view.getParent();
            top += view.getTop();
        }
        return top;
    }

    private void n0(View view) {
        view.setAlpha(0.0f);
    }

    private void o0() {
        if (this.M != null) {
            s0();
        }
        this.L.clear();
        h0(getChildAt(0));
        g0();
        invalidate();
    }

    private void q0(View view) {
        view.setAlpha(1.0f);
    }

    private void r0(View view) {
        this.M = view;
        if (view != null) {
            if (l0(view).contains("-hastransparency")) {
                n0(this.M);
            }
            if (l0(this.M).contains("-nonconstant")) {
                post(this.O);
            }
        }
    }

    private void s0() {
        if (l0(this.M).contains("-hastransparency")) {
            q0(this.M);
        }
        this.M = null;
        removeCallbacks(this.O);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        h0(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.M != null) {
            canvas.save();
            canvas.translate(getPaddingLeft() + this.P, getScrollY() + this.N + (this.R ? getPaddingTop() : 0));
            canvas.clipRect(0.0f, this.R ? -this.N : 0.0f, getWidth() - this.P, this.M.getHeight() + this.T + 1);
            if (this.U != null) {
                this.U.setBounds(0, this.M.getHeight(), this.M.getWidth(), this.M.getHeight() + this.T);
                this.U.draw(canvas);
            }
            canvas.clipRect(0.0f, this.R ? -this.N : 0.0f, getWidth(), this.M.getHeight());
            if (l0(this.M).contains("-hastransparency")) {
                q0(this.M);
                this.M.draw(canvas);
                n0(this.M);
            } else {
                this.M.draw(canvas);
            }
            canvas.restore();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.Q = true;
        }
        if (this.Q) {
            boolean z = this.M != null;
            this.Q = z;
            if (z) {
                this.Q = motionEvent.getY() <= ((float) this.M.getHeight()) + this.N && motionEvent.getX() >= ((float) j0(this.M)) && motionEvent.getX() <= ((float) k0(this.M));
            }
        } else if (this.M == null) {
            this.Q = false;
        }
        if (this.Q) {
            motionEvent.offsetLocation(0.0f, ((getScrollY() + this.N) - m0(this.M)) * (-1.0f));
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.O);
        super.onDetachedFromWindow();
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.S) {
            this.R = true;
        }
        o0();
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        g0();
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Q) {
            motionEvent.offsetLocation(0.0f, (getScrollY() + this.N) - m0(this.M));
        }
        if (motionEvent.getAction() == 0) {
            this.V = false;
        }
        if (this.V) {
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            motionEventObtain.setAction(0);
            super.onTouchEvent(motionEventObtain);
            this.V = false;
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.V = true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p0() {
        this.L = new ArrayList();
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        super.setClipToPadding(z);
        this.R = z;
        this.S = true;
    }

    public void setShadowDrawable(Drawable drawable) {
        this.U = drawable;
    }

    public void setShadowHeight(int i) {
        this.T = i;
    }

    public StickyNestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.scrollViewStyle);
    }

    public StickyNestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O = new a();
        this.T = 10;
        this.V = true;
        p0();
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        h0(view);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        h0(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, int i2) {
        super.addView(view, i, i2);
        h0(view);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        h0(view);
    }
}
