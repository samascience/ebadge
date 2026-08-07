package defpackage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class cg extends RecyclerView.Adapter {
    private List a = new ArrayList();
    private b b;

    public static abstract class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            p31.f(view, "itemView");
        }

        public abstract void a(Object obj, int i);
    }

    public interface b {
        void a(Object obj, int i, View view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(cg cgVar, Object obj, int i, a aVar, View view) {
        b bVar = cgVar.b;
        if (bVar != null) {
            View view2 = aVar.itemView;
            p31.e(view2, "itemView");
            bVar.a(obj, i, view2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(cg cgVar, Object obj, int i, a aVar, View view) {
        cgVar.getClass();
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final a aVar, final int i) {
        p31.f(aVar, "holder");
        final Object obj = this.a.get(i);
        aVar.a(obj, i);
        aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: ag
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                cg.f(this.a, obj, i, aVar, view);
            }
        });
        aVar.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: bg
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return cg.g(this.a, obj, i, aVar, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    public final void h(b bVar) {
        p31.f(bVar, "listener");
        this.b = bVar;
    }

    public final void setData(List list) {
        p31.f(list, "newData");
        this.a.clear();
        this.a.addAll(list);
        notifyDataSetChanged();
    }
}
