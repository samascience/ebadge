package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.widget.e0;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements e.b, k, AdapterView.OnItemClickListener {
    private static final int[] c = {R.attr.background, R.attr.divider};
    private e a;
    private int b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // androidx.appcompat.view.menu.e.b
    public boolean a(g gVar) {
        return this.a.O(gVar, 0);
    }

    public int getWindowAnimations() {
        return this.b;
    }

    @Override // androidx.appcompat.view.menu.k
    public void initialize(e eVar) {
        this.a = eVar;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a((g) getAdapter().getItem(i));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        e0 e0VarV = e0.v(context, attributeSet, c, i, 0);
        if (e0VarV.s(0)) {
            setBackgroundDrawable(e0VarV.g(0));
        }
        if (e0VarV.s(1)) {
            setDivider(e0VarV.g(1));
        }
        e0VarV.x();
    }
}
