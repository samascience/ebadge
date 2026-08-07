package xfkj.fitpro.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes4.dex */
public class FullyGridLayoutManager extends GridLayoutManager {
    private int[] a;
    final RecyclerView.State b;

    private void e(RecyclerView.Recycler recycler, int i, int i2, int i3, int[] iArr) {
        if (i < this.b.getItemCount()) {
            try {
                View viewForPosition = recycler.getViewForPosition(0);
                if (viewForPosition != null) {
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewForPosition.getLayoutParams();
                    viewForPosition.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height));
                    iArr[0] = viewForPosition.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    iArr[1] = viewForPosition.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    recycler.recycleView(viewForPosition);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int itemCount = getItemCount();
        int spanCount = getSpanCount();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < itemCount; i5++) {
            e(recycler, i5, View.MeasureSpec.makeMeasureSpec(i5, 0), View.MeasureSpec.makeMeasureSpec(i5, 0), this.a);
            if (getOrientation() == 0) {
                if (i5 % spanCount == 0) {
                    i3 += this.a[0];
                }
                if (i5 == 0) {
                    i4 = this.a[1];
                }
            } else {
                if (i5 % spanCount == 0) {
                    i4 += this.a[1];
                }
                if (i5 == 0) {
                    i3 = this.a[0];
                }
            }
        }
        if (mode != 1073741824) {
            size = i3;
        }
        if (mode2 != 1073741824) {
            size2 = i4;
        }
        setMeasuredDimension(size, size2);
    }
}
