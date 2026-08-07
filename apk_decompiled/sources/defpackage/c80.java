package defpackage;

import android.graphics.Canvas;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class c80 extends ItemTouchHelper.Callback {
    private boolean a;
    private boolean b;

    public void a(boolean z) {
        this.a = z;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public void c(hv1 hv1Var) {
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
    }

    public void d(iv1 iv1Var) {
    }

    public void e(lv1 lv1Var) {
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((LinearLayoutManager) layoutManager).getOrientation() == 0 ? ItemTouchHelper.Callback.makeMovementFlags(15, 3) : ItemTouchHelper.Callback.makeMovementFlags(15, 12);
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).getOrientation() == 0 ? ItemTouchHelper.Callback.makeMovementFlags(12, 3) : ItemTouchHelper.Callback.makeMovementFlags(3, 12);
        }
        return ItemTouchHelper.Callback.makeMovementFlags(0, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return this.a;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return this.b;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        float fAbs;
        int width;
        if (i == 1) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            float f3 = 1.0f;
            if (layoutManager instanceof LinearLayoutManager) {
                int orientation = ((LinearLayoutManager) layoutManager).getOrientation();
                if (orientation == 0) {
                    fAbs = Math.abs(f2);
                    width = viewHolder.itemView.getHeight();
                } else if (orientation == 1) {
                    fAbs = Math.abs(f);
                    width = viewHolder.itemView.getWidth();
                }
                f3 = 1.0f - (fAbs / width);
            }
            viewHolder.itemView.setAlpha(f3);
        }
        super.onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, z);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
        super.onSelectedChanged(viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
    }
}
