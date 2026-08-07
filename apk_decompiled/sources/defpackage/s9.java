package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class s9 implements Iterator, Iterable {
    private final Object[] a;
    private int b = 0;

    public s9(Object[] objArr) {
        this.a = objArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.a.length;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this;
    }

    @Override // java.util.Iterator
    public Object next() {
        int i = this.b;
        Object[] objArr = this.a;
        if (i >= objArr.length) {
            throw new NoSuchElementException();
        }
        this.b = i + 1;
        return objArr[i];
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
