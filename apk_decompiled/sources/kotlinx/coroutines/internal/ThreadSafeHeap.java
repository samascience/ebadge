package kotlinx.coroutines.internal;

import defpackage.ar0;
import defpackage.j21;
import defpackage.k83;
import defpackage.p31;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.collections.d;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

/* JADX INFO: loaded from: classes4.dex */
@InternalCoroutinesApi
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    private static final AtomicIntegerFieldUpdater _size$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, "_size");
    private volatile int _size;
    private T[] a;

    private final T[] realloc() {
        T[] tArr = this.a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new ThreadSafeHeapNode[4];
            this.a = tArr2;
            return tArr2;
        }
        if (getSize() < tArr.length) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, getSize() * 2);
        p31.e(objArrCopyOf, "copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((ThreadSafeHeapNode[]) objArrCopyOf);
        this.a = tArr3;
        return tArr3;
    }

    private final void setSize(int i) {
        _size$FU.set(this, i);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002b  */
    private final void siftDownFrom(int i) {
        while (true) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            if (i3 >= getSize()) {
                return;
            }
            T[] tArr = this.a;
            p31.c(tArr);
            int i4 = i2 + 2;
            if (i4 < getSize()) {
                T t = tArr[i4];
                p31.c(t);
                T t2 = tArr[i3];
                p31.c(t2);
                if (((Comparable) t).compareTo(t2) >= 0) {
                    i4 = i3;
                }
            } else {
                i4 = i3;
            }
            T t3 = tArr[i];
            p31.c(t3);
            T t4 = tArr[i4];
            p31.c(t4);
            if (((Comparable) t3).compareTo(t4) <= 0) {
                return;
            }
            swap(i, i4);
            i = i4;
        }
    }

    private final void siftUpFrom(int i) {
        while (i > 0) {
            T[] tArr = this.a;
            p31.c(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            p31.c(t);
            T t2 = tArr[i];
            p31.c(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            swap(i, i2);
            i = i2;
        }
    }

    private final void swap(int i, int i2) {
        T[] tArr = this.a;
        p31.c(tArr);
        T t = tArr[i2];
        p31.c(t);
        T t2 = tArr[i];
        p31.c(t2);
        tArr[i] = t;
        tArr[i2] = t2;
        t.setIndex(i);
        t2.setIndex(i2);
    }

    public final void addImpl(T t) {
        t.setHeap(this);
        ThreadSafeHeapNode[] threadSafeHeapNodeArrRealloc = realloc();
        int size = getSize();
        setSize(size + 1);
        threadSafeHeapNodeArrRealloc[size] = t;
        t.setIndex(size);
        siftUpFrom(size);
    }

    public final void addLast(T t) {
        synchronized (this) {
            addImpl(t);
            k83 k83Var = k83.a;
        }
    }

    public final boolean addLastIf(T t, ar0 ar0Var) {
        boolean z;
        synchronized (this) {
            try {
                if (((Boolean) ar0Var.invoke(firstImpl())).booleanValue()) {
                    addImpl(t);
                    z = true;
                } else {
                    z = false;
                }
                j21.b(1);
            } catch (Throwable th) {
                j21.b(1);
                j21.a(1);
                throw th;
            }
        }
        j21.a(1);
        return z;
    }

    public final void clear() {
        synchronized (this) {
            try {
                T[] tArr = this.a;
                if (tArr != null) {
                    d.n(tArr, null, 0, 0, 6, null);
                }
                _size$FU.set(this, 0);
                k83 k83Var = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final T find(ar0 ar0Var) {
        T t;
        synchronized (this) {
            try {
                int size = getSize();
                int i = 0;
                while (true) {
                    t = null;
                    if (i >= size) {
                        break;
                    }
                    T[] tArr = this.a;
                    t = tArr != null ? tArr[i] : null;
                    p31.c(t);
                    if (((Boolean) ar0Var.invoke(t)).booleanValue()) {
                        break;
                    }
                    i++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t;
    }

    public final T firstImpl() {
        T[] tArr = this.a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int getSize() {
        return _size$FU.get(this);
    }

    public final boolean isEmpty() {
        return getSize() == 0;
    }

    public final T peek() {
        T t;
        synchronized (this) {
            t = (T) firstImpl();
        }
        return t;
    }

    public final boolean remove(T t) {
        boolean z;
        synchronized (this) {
            if (t.getHeap() == null) {
                z = false;
            } else {
                removeAtImpl(t.getIndex());
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x003a  */
    public final T removeAtImpl(int i) {
        T[] tArr = this.a;
        p31.c(tArr);
        setSize(getSize() - 1);
        if (i < getSize()) {
            swap(i, getSize());
            int i2 = (i - 1) / 2;
            if (i > 0) {
                T t = tArr[i];
                p31.c(t);
                T t2 = tArr[i2];
                p31.c(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    swap(i, i2);
                    siftUpFrom(i2);
                } else {
                    siftDownFrom(i);
                }
            } else {
                siftDownFrom(i);
            }
        }
        T t3 = tArr[getSize()];
        p31.c(t3);
        t3.setHeap(null);
        t3.setIndex(-1);
        tArr[getSize()] = null;
        return t3;
    }

    public final T removeFirstIf(ar0 ar0Var) {
        synchronized (this) {
            int i = 1;
            try {
                ThreadSafeHeapNode threadSafeHeapNodeFirstImpl = firstImpl();
                T t = null;
                if (threadSafeHeapNodeFirstImpl == null) {
                    j21.b(2);
                    return null;
                }
                if (((Boolean) ar0Var.invoke(threadSafeHeapNodeFirstImpl)).booleanValue()) {
                    t = (T) removeAtImpl(0);
                }
                j21.b(i);
                return t;
            } finally {
                j21.b(i);
                j21.a(i);
            }
        }
    }

    public final T removeFirstOrNull() {
        T t;
        synchronized (this) {
            t = getSize() > 0 ? (T) removeAtImpl(0) : null;
        }
        return t;
    }
}
