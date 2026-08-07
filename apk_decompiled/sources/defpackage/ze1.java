package defpackage;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ze1 {
    private final Map a = new LinkedHashMap(100, 0.75f, true);
    private final long b;
    private long c;
    private long d;

    static final class a {
        final Object a;
        final int b;

        a(Object obj, int i) {
            this.a = obj;
            this.b = i;
        }
    }

    public ze1(long j) {
        this.b = j;
        this.c = j;
    }

    private void f() {
        m(this.c);
    }

    public void b() {
        m(0L);
    }

    public synchronized Object g(Object obj) {
        a aVar;
        aVar = (a) this.a.get(obj);
        return aVar != null ? aVar.a : null;
    }

    public synchronized long h() {
        return this.c;
    }

    protected int i(Object obj) {
        return 1;
    }

    protected void j(Object obj, Object obj2) {
    }

    public synchronized Object k(Object obj, Object obj2) {
        int i = i(obj2);
        long j = i;
        if (j >= this.c) {
            j(obj, obj2);
            return null;
        }
        if (obj2 != null) {
            this.d += j;
        }
        a aVar = (a) this.a.put(obj, obj2 == null ? null : new a(obj2, i));
        if (aVar != null) {
            this.d -= (long) aVar.b;
            if (!aVar.a.equals(obj2)) {
                j(obj, aVar.a);
            }
        }
        f();
        return aVar != null ? aVar.a : null;
    }

    public synchronized Object l(Object obj) {
        a aVar = (a) this.a.remove(obj);
        if (aVar == null) {
            return null;
        }
        this.d -= (long) aVar.b;
        return aVar.a;
    }

    protected synchronized void m(long j) {
        while (this.d > j) {
            Iterator it = this.a.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            a aVar = (a) entry.getValue();
            this.d -= (long) aVar.b;
            Object key = entry.getKey();
            it.remove();
            j(key, aVar.a);
        }
    }
}
