package com.jaredrummler.materialspinner;

import android.content.Context;
import android.widget.ListAdapter;
import defpackage.xg1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class a extends xg1 {
    private final ListAdapter j;

    public a(Context context, ListAdapter listAdapter) {
        super(context);
        this.j = listAdapter;
    }

    @Override // defpackage.xg1
    public Object a(int i) {
        return this.j.getItem(i);
    }

    @Override // defpackage.xg1
    public List c() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.j.getCount(); i++) {
            arrayList.add(this.j.getItem(i));
        }
        return arrayList;
    }

    @Override // defpackage.xg1, android.widget.Adapter
    public int getCount() {
        int count = this.j.getCount();
        return (count == 1 || e()) ? count : count - 1;
    }

    @Override // defpackage.xg1, android.widget.Adapter
    public Object getItem(int i) {
        if (e()) {
            return this.j.getItem(i);
        }
        return (i < d() || this.j.getCount() == 1) ? this.j.getItem(i) : this.j.getItem(i + 1);
    }
}
