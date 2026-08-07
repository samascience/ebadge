package defpackage;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class g1 extends k1 {
    public final boolean a(Map.Entry entry) {
        p31.f(entry, "element");
        return b(entry);
    }

    public abstract boolean b(Map.Entry entry);

    public abstract /* bridge */ boolean c(Map.Entry entry);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return a((Map.Entry) obj);
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return c((Map.Entry) obj);
        }
        return false;
    }
}
