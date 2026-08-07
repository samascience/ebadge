package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;
import com.lsjwzh.widget.recyclerviewpager.a;

/* JADX INFO: loaded from: classes3.dex */
public class de1 extends a {
    public de1(RecyclerViewPager recyclerViewPager, RecyclerView.Adapter adapter) {
        super(recyclerViewPager, adapter);
    }

    public int c() {
        return super.getItemCount();
    }

    public int d(int i) {
        return (c() <= 0 || i < c()) ? i : i % c();
    }

    @Override // com.lsjwzh.widget.recyclerviewpager.a, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (c() > 0) {
            return Integer.MAX_VALUE;
        }
        return super.getItemCount();
    }

    @Override // com.lsjwzh.widget.recyclerviewpager.a, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return super.getItemId(d(i));
    }

    @Override // com.lsjwzh.widget.recyclerviewpager.a, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (c() > 0) {
            return super.getItemViewType(d(i));
        }
        return 0;
    }

    @Override // com.lsjwzh.widget.recyclerviewpager.a, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        super.onBindViewHolder(viewHolder, d(i));
        ke3.a(viewHolder, i);
    }
}
