package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ra1 implements wt {
    private final int b;

    public ra1(int i) {
        this.b = i;
    }

    @Override // defpackage.wt
    public List b(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            yt ytVar = (yt) it.next();
            b52.b(ytVar instanceof zt, "The camera info doesn't contain internal implementation.");
            if (ytVar.f() == this.b) {
                arrayList.add(ytVar);
            }
        }
        return arrayList;
    }

    public int c() {
        return this.b;
    }
}
