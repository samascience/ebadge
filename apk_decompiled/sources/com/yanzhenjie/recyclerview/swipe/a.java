package com.yanzhenjie.recyclerview.swipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import defpackage.jy2;
import defpackage.ky2;
import defpackage.ly2;
import defpackage.my2;
import defpackage.ns2;
import defpackage.oy2;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends RecyclerView.Adapter {
    private ns2 a = new ns2();
    private ns2 b = new ns2();
    private RecyclerView.Adapter c;
    private LayoutInflater d;
    private my2 e;
    private oy2 f;
    private jy2 g;
    private ky2 h;

    /* JADX INFO: renamed from: com.yanzhenjie.recyclerview.swipe.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0126a implements View.OnClickListener {
        final /* synthetic */ RecyclerView.ViewHolder a;

        ViewOnClickListenerC0126a(RecyclerView.ViewHolder viewHolder) {
            this.a = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.g.onItemClick(view, this.a.getAdapterPosition());
        }
    }

    class b implements View.OnLongClickListener {
        final /* synthetic */ RecyclerView.ViewHolder a;

        b(RecyclerView.ViewHolder viewHolder) {
            this.a = viewHolder;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            a.this.h.a(view, this.a.getAdapterPosition());
            return true;
        }
    }

    static class c extends RecyclerView.ViewHolder {
        public c(View view) {
            super(view);
        }
    }

    a(Context context, RecyclerView.Adapter adapter) {
        this.d = LayoutInflater.from(context);
        this.c = adapter;
    }

    private int g() {
        return this.c.getItemCount();
    }

    private Class k(Class cls) {
        Class superclass = cls.getSuperclass();
        return (superclass == null || superclass.equals(Object.class)) ? cls : k(superclass);
    }

    public void e(View view) {
        this.b.g(h() + 200000, view);
    }

    public void f(View view) {
        this.a.g(i() + 100000, view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return i() + g() + h();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return (m(i) || l(i)) ? super.getItemId(i) : this.c.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (m(i)) {
            return this.a.f(i);
        }
        return l(i) ? this.b.f((i - i()) - g()) : this.c.getItemViewType(i - i());
    }

    public int h() {
        return this.b.h();
    }

    public int i() {
        return this.a.h();
    }

    public RecyclerView.Adapter j() {
        return this.c;
    }

    public boolean l(int i) {
        return i >= i() + g();
    }

    public boolean m(int i) {
        return i >= 0 && i < i();
    }

    void n(jy2 jy2Var) {
        this.g = jy2Var;
    }

    void o(ky2 ky2Var) {
        this.h = ky2Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.c.onAttachedToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.a.d(i) != null) {
            return new c((View) this.a.d(i));
        }
        if (this.b.d(i) != null) {
            return new c((View) this.b.d(i));
        }
        RecyclerView.ViewHolder viewHolderOnCreateViewHolder = this.c.onCreateViewHolder(viewGroup, i);
        if (this.g != null) {
            viewHolderOnCreateViewHolder.itemView.setOnClickListener(new ViewOnClickListenerC0126a(viewHolderOnCreateViewHolder));
        }
        if (this.h != null) {
            viewHolderOnCreateViewHolder.itemView.setOnLongClickListener(new b(viewHolderOnCreateViewHolder));
        }
        if (this.e == null) {
            return viewHolderOnCreateViewHolder;
        }
        SwipeMenuLayout swipeMenuLayout = (SwipeMenuLayout) this.d.inflate(R$layout.recycler_swipe_view_item, viewGroup, false);
        ly2 ly2Var = new ly2(swipeMenuLayout, i);
        ly2 ly2Var2 = new ly2(swipeMenuLayout, i);
        this.e.a(ly2Var, ly2Var2, i);
        if (ly2Var.b().size() > 0) {
            SwipeMenuView swipeMenuView = (SwipeMenuView) swipeMenuLayout.findViewById(R$id.swipe_left);
            swipeMenuView.setOrientation(ly2Var.c());
            swipeMenuView.c(ly2Var, swipeMenuLayout, this.f, 1);
        }
        if (ly2Var2.b().size() > 0) {
            SwipeMenuView swipeMenuView2 = (SwipeMenuView) swipeMenuLayout.findViewById(R$id.swipe_right);
            swipeMenuView2.setOrientation(ly2Var2.c());
            swipeMenuView2.c(ly2Var2, swipeMenuLayout, this.f, -1);
        }
        ((ViewGroup) swipeMenuLayout.findViewById(R$id.swipe_content)).addView(viewHolderOnCreateViewHolder.itemView);
        try {
            Field declaredField = k(viewHolderOnCreateViewHolder.getClass()).getDeclaredField("itemView");
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            declaredField.set(viewHolderOnCreateViewHolder, swipeMenuLayout);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return viewHolderOnCreateViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.c.onDetachedFromRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        int adapterPosition = viewHolder.getAdapterPosition();
        if (m(adapterPosition) || l(adapterPosition)) {
            return false;
        }
        return this.c.onFailedToRecycleView(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        int adapterPosition = viewHolder.getAdapterPosition();
        if (!m(adapterPosition) && !l(adapterPosition)) {
            this.c.onViewAttachedToWindow(viewHolder);
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams == null || !(layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            return;
        }
        ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        int adapterPosition = viewHolder.getAdapterPosition();
        if (m(adapterPosition) || l(adapterPosition)) {
            return;
        }
        this.c.onViewDetachedFromWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        int adapterPosition = viewHolder.getAdapterPosition();
        if (m(adapterPosition) || l(adapterPosition)) {
            return;
        }
        this.c.onViewRecycled(viewHolder);
    }

    void p(my2 my2Var) {
        this.e = my2Var;
    }

    void q(oy2 oy2Var) {
        this.f = oy2Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        this.c.setHasStableIds(z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        if (m(i) || l(i)) {
            return;
        }
        View view = viewHolder.itemView;
        if (view instanceof SwipeMenuLayout) {
            SwipeMenuLayout swipeMenuLayout = (SwipeMenuLayout) view;
            int childCount = swipeMenuLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = swipeMenuLayout.getChildAt(i2);
                if (childAt instanceof SwipeMenuView) {
                    ((SwipeMenuView) childAt).a(viewHolder);
                }
            }
        }
        this.c.onBindViewHolder(viewHolder, i - i(), list);
    }
}
