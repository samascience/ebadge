package defpackage;

import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class f7 implements Iterable {
    protected Map a;

    public f7() {
    }

    public AnnotatedMethod a(String str, Class[] clsArr) {
        Map map = this.a;
        if (map == null) {
            return null;
        }
        return (AnnotatedMethod) map.get(new hi1(str, clsArr));
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        Map map = this.a;
        return map == null ? Collections.emptyIterator() : map.values().iterator();
    }

    public f7(Map map) {
        this.a = map;
    }
}
