package androidx.work;

import defpackage.s21;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class OverwritingInputMerger extends s21 {
    @Override // defpackage.s21
    public b b(List list) {
        b.a aVar = new b.a();
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            map.putAll(((b) it.next()).h());
        }
        aVar.c(map);
        return aVar.a();
    }
}
