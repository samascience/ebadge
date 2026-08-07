package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class d extends BaseAdapter {
    e a;
    private int b = -1;
    private boolean c;
    private final boolean d;
    private final LayoutInflater e;
    private final int f;

    public d(e eVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.d = z;
        this.e = layoutInflater;
        this.a = eVar;
        this.f = i;
        a();
    }

    void a() {
        g gVarX = this.a.x();
        if (gVarX != null) {
            ArrayList arrayListB = this.a.B();
            int size = arrayListB.size();
            for (int i = 0; i < size; i++) {
                if (((g) arrayListB.get(i)) == gVarX) {
                    this.b = i;
                    return;
                }
            }
        }
        this.b = -1;
    }

    public e b() {
        return this.a;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public g getItem(int i) {
        ArrayList arrayListB = this.d ? this.a.B() : this.a.G();
        int i2 = this.b;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (g) arrayListB.get(i);
    }

    public void d(boolean z) {
        this.c = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList arrayListB = this.d ? this.a.B() : this.a.G();
        return this.b < 0 ? arrayListB.size() : arrayListB.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.e.inflate(this.f, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.a.I() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        k.a aVar = (k.a) view;
        if (this.c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.initialize(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
