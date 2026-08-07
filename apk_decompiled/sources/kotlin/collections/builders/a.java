package kotlin.collections.builders;

import defpackage.g1;
import defpackage.p31;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends g1 {
    private final MapBuilder a;

    public a(MapBuilder mapBuilder) {
        p31.f(mapBuilder, "backing");
        this.a = mapBuilder;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        p31.f(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.g1
    public boolean b(Map.Entry entry) {
        p31.f(entry, "element");
        return this.a.containsEntry$kotlin_stdlib(entry);
    }

    @Override // defpackage.g1
    public boolean c(Map.Entry entry) {
        p31.f(entry, "element");
        return this.a.removeEntry$kotlin_stdlib(entry);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        p31.f(collection, "elements");
        return this.a.containsAllEntries$kotlin_stdlib(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean add(Map.Entry entry) {
        p31.f(entry, "element");
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.k1
    public int getSize() {
        return this.a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return this.a.entriesIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        p31.f(collection, "elements");
        this.a.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        p31.f(collection, "elements");
        this.a.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}
