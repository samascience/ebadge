package androidx.databinding;

import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class ObservableArrayList<T> extends ArrayList<T> implements h {
    private transient f mListeners = new f();

    private void notifyAdd(int i, int i2) {
        f fVar = this.mListeners;
        if (fVar != null) {
            fVar.p(this, i, i2);
        }
    }

    private void notifyRemove(int i, int i2) {
        f fVar = this.mListeners;
        if (fVar != null) {
            fVar.q(this, i, i2);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(T t) {
        super.add(t);
        notifyAdd(size() - 1, 1);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends T> collection) {
        int size = size();
        boolean zAddAll = super.addAll(collection);
        if (zAddAll) {
            notifyAdd(size, size() - size);
        }
        return zAddAll;
    }

    @Override // androidx.databinding.h
    public void addOnListChangedCallback(h.a aVar) {
        if (this.mListeners == null) {
            this.mListeners = new f();
        }
        this.mListeners.a(aVar);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int size = size();
        super.clear();
        if (size != 0) {
            notifyRemove(0, size);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public T remove(int i) {
        T t = (T) super.remove(i);
        notifyRemove(i, 1);
        return t;
    }

    @Override // androidx.databinding.h
    public void removeOnListChangedCallback(h.a aVar) {
        f fVar = this.mListeners;
        if (fVar != null) {
            fVar.i(aVar);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    protected void removeRange(int i, int i2) {
        super.removeRange(i, i2);
        notifyRemove(i, i2 - i);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        T t2 = (T) super.set(i, t);
        f fVar = this.mListeners;
        if (fVar != null) {
            fVar.o(this, i, 1);
        }
        return t2;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        super.add(i, t);
        notifyAdd(i, 1);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends T> collection) {
        boolean zAddAll = super.addAll(i, collection);
        if (zAddAll) {
            notifyAdd(i, collection.size());
        }
        return zAddAll;
    }
}
