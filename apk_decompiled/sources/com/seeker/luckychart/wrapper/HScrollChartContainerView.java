package com.seeker.luckychart.wrapper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import com.seeker.luckychart.model.ChartAxis;
import com.seeker.luckychart.provider.ChartProvider;

/* JADX INFO: loaded from: classes.dex */
public class HScrollChartContainerView extends HorizontalScrollView {
    private static final String TAG = "HScrollChartContainerVi";
    private FrameLayout childContainer;
    private LeftAxisView leftAxisView;
    private ChartProvider provider;

    public HScrollChartContainerView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void transform() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.childContainer = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        if (getChildCount() == 0) {
            throw new IllegalStateException("HorizontalScrollView hasn't add one direct child.");
        }
        View childAt = getChildAt(0);
        if (!(childAt instanceof ChartProvider)) {
            throw new IllegalStateException("direct child is't instanceof ChartProvider.");
        }
        this.provider = (ChartProvider) childAt;
        removeAllViews();
        this.childContainer.addView(childAt);
        addView(this.childContainer);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        transform();
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        ChartAxis leftAxis;
        super.onScrollChanged(i, i2, i3, i4);
        if (this.leftAxisView == null && (leftAxis = this.provider.getChartData().getLeftAxis()) != null && leftAxis.getCoordinateValues() != null && leftAxis.getCoordinateValues().length > 0) {
            LeftAxisView leftAxisView = new LeftAxisView(getContext(), this.provider);
            this.leftAxisView = leftAxisView;
            this.childContainer.addView(leftAxisView);
        }
        LeftAxisView leftAxisView2 = this.leftAxisView;
        if (leftAxisView2 != null) {
            leftAxisView2.setX(i);
        }
    }

    public HScrollChartContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HScrollChartContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOverScrollMode(2);
        setHorizontalScrollBarEnabled(false);
    }
}
