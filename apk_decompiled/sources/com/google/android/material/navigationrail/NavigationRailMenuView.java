package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationRailMenuView extends NavigationBarMenuView {
    private int a;
    private final FrameLayout.LayoutParams b;

    public NavigationRailMenuView(Context context) {
        super(context);
        this.a = -1;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.b = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
        setItemActiveIndicatorResizeable(true);
    }

    private int f(int i, int i2, int i3) {
        int iMax = i2 / Math.max(1, i3);
        int size = this.a;
        if (size == -1) {
            size = View.MeasureSpec.getSize(i);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, iMax), 0);
    }

    private int g(View view, int i, int i2) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        view.measure(i, i2);
        return view.getMeasuredHeight();
    }

    private int h(int i, int i2, int i3, View view) {
        int iF = view == null ? f(i, i2, i3) : View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        int childCount = getChildCount();
        int iG = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt != view) {
                iG += g(childAt, i, iF);
            }
        }
        return iG;
    }

    private int i(int i, int i2, int i3) {
        int iG;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            iG = g(childAt, i, f(i, i2, i3));
            i2 -= iG;
            i3--;
        } else {
            iG = 0;
        }
        return iG + h(i, i2, i3, childAt);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    protected NavigationBarItemView createNavigationBarItemView(Context context) {
        return new a(context);
    }

    boolean e() {
        return (this.b.gravity & 112) == 48;
    }

    public int getItemMinimumHeight() {
        return this.a;
    }

    int getMenuGravity() {
        return this.b.gravity;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i6;
                childAt.layout(0, i6, i5, measuredHeight);
                i6 = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = getMenu().G().size();
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.resolveSizeAndState((size2 <= 1 || !isShifting(getLabelVisibilityMode(), size2)) ? h(i, size, size2, null) : i(i, size, size2), i2, 0));
    }

    public void setItemMinimumHeight(int i) {
        if (this.a != i) {
            this.a = i;
            requestLayout();
        }
    }

    void setMenuGravity(int i) {
        FrameLayout.LayoutParams layoutParams = this.b;
        if (layoutParams.gravity != i) {
            layoutParams.gravity = i;
            setLayoutParams(layoutParams);
        }
    }
}
