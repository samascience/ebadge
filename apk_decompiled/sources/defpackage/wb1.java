package defpackage;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class wb1 {
    private final Set a = Collections.newSetFromMap(new WeakHashMap());

    public final void a() {
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            throw null;
        }
        this.a.clear();
    }
}
