package defpackage;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class wg1 extends xg1 {
    private final List j;

    public wg1(Context context, List list) {
        super(context);
        this.j = list;
    }

    @Override // defpackage.xg1
    public Object a(int i) {
        return this.j.get(i);
    }

    @Override // defpackage.xg1
    public List c() {
        return this.j;
    }

    @Override // defpackage.xg1, android.widget.Adapter
    public int getCount() {
        int size = this.j.size();
        return (size == 1 || e()) ? size : size - 1;
    }

    @Override // defpackage.xg1, android.widget.Adapter
    public Object getItem(int i) {
        if (e()) {
            return this.j.get(i);
        }
        return (i < d() || this.j.size() == 1) ? this.j.get(i) : this.j.get(i + 1);
    }
}
