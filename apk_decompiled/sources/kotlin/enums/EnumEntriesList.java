package kotlin.enums;

import defpackage.p31;
import defpackage.vh0;
import java.io.Serializable;
import java.lang.Enum;
import kotlin.collections.d;

/* JADX INFO: loaded from: classes4.dex */
final class EnumEntriesList<T extends Enum<T>> extends kotlin.collections.a implements vh0, Serializable {
    private final T[] entries;

    public EnumEntriesList(T[] tArr) {
        p31.f(tArr, "entries");
        this.entries = tArr;
    }

    private final Object writeReplace() {
        return new EnumEntriesSerializationProxy(this.entries);
    }

    @Override // defpackage.x0, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return contains((Enum) obj);
        }
        return false;
    }

    @Override // defpackage.x0
    public int getSize() {
        return this.entries.length;
    }

    @Override // kotlin.collections.a, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return indexOf((Enum) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.a, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return lastIndexOf((Enum) obj);
        }
        return -1;
    }

    public boolean contains(T t) {
        p31.f(t, "element");
        return ((Enum) d.v(this.entries, t.ordinal())) == t;
    }

    @Override // kotlin.collections.a, java.util.List
    public T get(int i) {
        kotlin.collections.a.Companion.b(i, this.entries.length);
        return this.entries[i];
    }

    public int indexOf(T t) {
        p31.f(t, "element");
        int iOrdinal = t.ordinal();
        if (((Enum) d.v(this.entries, iOrdinal)) == t) {
            return iOrdinal;
        }
        return -1;
    }

    public int lastIndexOf(T t) {
        p31.f(t, "element");
        return indexOf((Object) t);
    }
}
