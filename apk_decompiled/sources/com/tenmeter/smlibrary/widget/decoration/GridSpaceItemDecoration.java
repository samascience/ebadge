package com.tenmeter.smlibrary.widget.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tenmeter.smlibrary.utils.DisplayUtil;

/* JADX INFO: loaded from: classes3.dex */
public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int spanCount;

    public GridSpaceItemDecoration(int i) {
        this.spanCount = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view) % this.spanCount;
        int measuredWidth = recyclerView.getMeasuredWidth();
        int iDp2px = DisplayUtil.dp2px(60.0f);
        double d = measuredWidth;
        int i = this.spanCount;
        rect.left = (int) (((d - ((double) (iDp2px * i))) / ((double) (i * (i - 1)))) * ((double) childAdapterPosition));
    }
}
