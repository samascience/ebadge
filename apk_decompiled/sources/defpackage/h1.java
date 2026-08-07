package defpackage;

import java.util.AbstractCollection;
import java.util.Collection;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h1 extends AbstractCollection implements Collection, k81 {
    protected h1() {
    }

    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }
}
