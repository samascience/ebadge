package defpackage;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.d;

/* JADX INFO: loaded from: classes4.dex */
public class ls2 extends RecyclerView.ItemDecoration {
    private final String a = ls2.class.getSimpleName();
    private int b;
    private int c;
    private int d;
    private int e;

    public ls2(int i) {
        this.b = d.c(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition() < 0) {
            return;
        }
        rect.left = this.c;
        rect.right = this.d;
        rect.bottom = this.b;
        rect.top = this.e;
    }

    public ls2(int i, int i2, int i3) {
        this.b = d.c(i);
        this.c = d.c(i2);
        this.d = d.c(i3);
    }
}
