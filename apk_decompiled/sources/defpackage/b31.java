package defpackage;

import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b31 implements Iterator, k81 {
    public abstract int a();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
