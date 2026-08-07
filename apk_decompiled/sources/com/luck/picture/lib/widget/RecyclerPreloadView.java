package com.luck.picture.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.bw1;

/* JADX INFO: loaded from: classes3.dex */
public class RecyclerPreloadView extends RecyclerView {
    public boolean a;
    public boolean b;
    private int c;
    private int d;
    private int e;
    private bw1 f;

    public RecyclerPreloadView(Context context) {
        super(context);
        this.a = false;
        this.b = false;
        this.e = 1;
    }

    public int getFirstVisiblePosition() {
        return this.c;
    }

    public int getLastVisiblePosition() {
        return this.d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
        if (i == 0 || i == 1) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                this.c = gridLayoutManager.findFirstVisibleItemPosition();
                this.d = gridLayoutManager.findLastVisibleItemPosition();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int i, int i2) {
        super.onScrolled(i, i2);
        if (this.f == null || !this.b) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null) {
            throw new RuntimeException("LayoutManager is null,Please check it!");
        }
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            throw new RuntimeException("Adapter is null,Please check it!");
        }
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            if (gridLayoutManager.findLastVisibleItemPosition() / gridLayoutManager.getSpanCount() >= (adapter.getItemCount() / gridLayoutManager.getSpanCount()) - this.e) {
                if (this.a) {
                    if (i2 == 0) {
                        this.a = false;
                        return;
                    }
                    return;
                } else {
                    this.f.j();
                    if (i2 > 0) {
                        this.a = true;
                        return;
                    }
                    return;
                }
            }
        }
        this.a = false;
    }

    public void setEnabledLoadMore(boolean z) {
        this.b = z;
    }

    public void setOnRecyclerViewPreloadListener(bw1 bw1Var) {
        this.f = bw1Var;
    }

    public void setReachBottomRow(int i) {
        if (i < 1) {
            i = 1;
        }
        this.e = i;
    }

    public RecyclerPreloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
        this.b = false;
        this.e = 1;
    }

    public RecyclerPreloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
        this.b = false;
        this.e = 1;
    }
}
