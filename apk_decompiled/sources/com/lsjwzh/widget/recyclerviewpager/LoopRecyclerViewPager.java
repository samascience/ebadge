package com.lsjwzh.widget.recyclerviewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.jieli.jl_rcsp.constant.WatchConstant;
import defpackage.de1;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: loaded from: classes3.dex */
public class LoopRecyclerViewPager extends RecyclerViewPager {
    public LoopRecyclerViewPager(Context context) {
        this(context, null);
    }

    private int getActualItemCountFromAdapter() {
        return ((de1) getWrapperAdapter()).c();
    }

    private int getMiddlePosition() {
        int i;
        int actualItemCountFromAdapter = getActualItemCountFromAdapter();
        return (actualItemCountFromAdapter <= 0 || (i = LockFreeTaskQueueCore.MAX_CAPACITY_MASK % actualItemCountFromAdapter) == 0) ? LockFreeTaskQueueCore.MAX_CAPACITY_MASK : LockFreeTaskQueueCore.MAX_CAPACITY_MASK - i;
    }

    private int m(int i) {
        int actualItemCountFromAdapter = getActualItemCountFromAdapter();
        if (actualItemCountFromAdapter == 0) {
            return actualItemCountFromAdapter;
        }
        int currentPosition = getCurrentPosition() % actualItemCountFromAdapter;
        int i2 = i % actualItemCountFromAdapter;
        int currentPosition2 = (getCurrentPosition() - currentPosition) + i2;
        int currentPosition3 = ((getCurrentPosition() - currentPosition) - actualItemCountFromAdapter) + i2;
        int currentPosition4 = (getCurrentPosition() - currentPosition) + actualItemCountFromAdapter + i2;
        Log.e("test", currentPosition2 + WatchConstant.FAT_FS_ROOT + currentPosition3 + WatchConstant.FAT_FS_ROOT + currentPosition4 + WatchConstant.FAT_FS_ROOT + getCurrentPosition());
        if (Math.abs(currentPosition2 - getCurrentPosition()) > Math.abs(currentPosition3 - getCurrentPosition())) {
            return Math.abs(currentPosition3 - getCurrentPosition()) > Math.abs(currentPosition4 - getCurrentPosition()) ? currentPosition4 : currentPosition3;
        }
        return Math.abs(currentPosition2 - getCurrentPosition()) > Math.abs(currentPosition4 - getCurrentPosition()) ? currentPosition4 : currentPosition2;
    }

    public int getActualCurrentPosition() {
        return n(getCurrentPosition());
    }

    @Override // com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager
    protected a h(RecyclerView.Adapter adapter) {
        return adapter instanceof de1 ? (de1) adapter : new de1(this, adapter);
    }

    public int n(int i) {
        if (getAdapter() == null || getAdapter().getItemCount() < 0) {
            return 0;
        }
        return i % getActualItemCountFromAdapter();
    }

    @Override // com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager, androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i) {
        super.scrollToPosition(m(i));
    }

    @Override // com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager, androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        super.scrollToPosition(getMiddlePosition());
    }

    @Override // com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager, androidx.recyclerview.widget.RecyclerView
    public void smoothScrollToPosition(int i) {
        int iM = m(i);
        super.smoothScrollToPosition(iM);
        Log.e("test", "transformedPosition:" + iM);
    }

    @Override // com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager, androidx.recyclerview.widget.RecyclerView
    public void swapAdapter(RecyclerView.Adapter adapter, boolean z) {
        super.swapAdapter(adapter, z);
        super.scrollToPosition(getMiddlePosition());
    }

    public LoopRecyclerViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoopRecyclerViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
