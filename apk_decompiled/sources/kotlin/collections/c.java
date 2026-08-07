package kotlin.collections;

import defpackage.ga2;
import defpackage.i1;
import defpackage.p31;
import defpackage.y70;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends i1 {
    public static final a d = new a(null);
    private static final Object[] e = new Object[0];
    private int a;
    private Object[] b = e;
    private int c;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    private final void a(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.b.length;
        while (i < length && it.hasNext()) {
            this.b[i] = it.next();
            i++;
        }
        int i2 = this.a;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.b[i3] = it.next();
        }
        this.c = size() + collection.size();
    }

    private final void b(int i) {
        Object[] objArr = new Object[i];
        Object[] objArr2 = this.b;
        d.g(objArr2, objArr, 0, this.a, objArr2.length);
        Object[] objArr3 = this.b;
        int length = objArr3.length;
        int i2 = this.a;
        d.g(objArr3, objArr, length - i2, 0, i2);
        this.a = 0;
        this.b = objArr;
    }

    private final int c(int i) {
        return i == 0 ? d.u(this.b) : i - 1;
    }

    private final void d(int i) {
        if (i < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.b;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == e) {
            this.b = new Object[ga2.b(i, 10)];
        } else {
            b(kotlin.collections.a.Companion.e(objArr.length, i));
        }
    }

    private final int e(int i) {
        if (i == d.u(this.b)) {
            return 0;
        }
        return i + 1;
    }

    private final int g(int i) {
        return i < 0 ? i + this.b.length : i;
    }

    private final void h(int i, int i2) {
        if (i < i2) {
            d.m(this.b, null, i, i2);
            return;
        }
        Object[] objArr = this.b;
        d.m(objArr, null, i, objArr.length);
        d.m(this.b, null, 0, i2);
    }

    private final int i(int i) {
        Object[] objArr = this.b;
        return i >= objArr.length ? i - objArr.length : i;
    }

    private final void k(int i, int i2) {
        int i3 = i(this.a + (i - 1));
        int i4 = i(this.a + (i2 - 1));
        while (i > 0) {
            int i5 = i3 + 1;
            int iMin = Math.min(i, Math.min(i5, i4 + 1));
            Object[] objArr = this.b;
            int i6 = i4 - iMin;
            int i7 = i3 - iMin;
            d.g(objArr, objArr, i6 + 1, i7 + 1, i5);
            i3 = g(i7);
            i4 = g(i6);
            i -= iMin;
        }
    }

    private final void l(int i, int i2) {
        int i3 = i(this.a + i2);
        int i4 = i(this.a + i);
        int size = size();
        while (true) {
            size -= i2;
            if (size <= 0) {
                return;
            }
            Object[] objArr = this.b;
            i2 = Math.min(size, Math.min(objArr.length - i3, objArr.length - i4));
            Object[] objArr2 = this.b;
            int i5 = i3 + i2;
            d.g(objArr2, objArr2, i4, i3, i5);
            i3 = i(i5);
            i4 = i(i4 + i2);
        }
    }

    private final void registerModification() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        p31.f(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        registerModification();
        d(size() + collection.size());
        a(i(this.a + size()), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        registerModification();
        d(size() + 1);
        int iC = c(this.a);
        this.a = iC;
        this.b[iC] = obj;
        this.c = size() + 1;
    }

    public final void addLast(Object obj) {
        registerModification();
        d(size() + 1);
        this.b[i(this.a + size())] = obj;
        this.c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (!isEmpty()) {
            registerModification();
            h(this.a, i(this.a + size()));
        }
        this.a = 0;
        this.c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final Object f() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return this.b[i(this.a + j.l(this))];
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        kotlin.collections.a.Companion.b(i, size());
        return this.b[i(this.a + i)];
    }

    @Override // defpackage.i1
    public int getSize() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i;
        int i2 = i(this.a + size());
        int length = this.a;
        if (length < i2) {
            while (length < i2) {
                if (p31.a(obj, this.b[length])) {
                    i = this.a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < i2) {
            return -1;
        }
        int length2 = this.b.length;
        while (length < length2) {
            if (p31.a(obj, this.b[length])) {
                i = this.a;
            } else {
                length++;
            }
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (p31.a(obj, this.b[i3])) {
                length = i3 + this.b.length;
                i = this.a;
            }
        }
        return -1;
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final Object j() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int iU;
        int i;
        int i2 = i(this.a + size());
        int i3 = this.a;
        if (i3 < i2) {
            iU = i2 - 1;
            if (i3 <= iU) {
                while (!p31.a(obj, this.b[iU])) {
                    if (iU != i3) {
                        iU--;
                    }
                }
                i = this.a;
                return iU - i;
            }
            return -1;
        }
        if (i3 > i2) {
            for (int i4 = i2 - 1; -1 < i4; i4--) {
                if (p31.a(obj, this.b[i4])) {
                    iU = i4 + this.b.length;
                    i = this.a;
                    return iU - i;
                }
            }
            iU = d.u(this.b);
            int i5 = this.a;
            if (i5 <= iU) {
                while (!p31.a(obj, this.b[iU])) {
                    if (iU != i5) {
                        iU--;
                    }
                }
                i = this.a;
                return iU - i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        int i;
        p31.f(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.b.length != 0) {
            int i2 = i(this.a + size());
            int i3 = this.a;
            if (i3 < i2) {
                i = i3;
                while (i3 < i2) {
                    Object obj = this.b[i3];
                    if (collection.contains(obj)) {
                        z = true;
                    } else {
                        this.b[i] = obj;
                        i++;
                    }
                    i3++;
                }
                d.m(this.b, null, i, i2);
            } else {
                int length = this.b.length;
                boolean z2 = false;
                int i4 = i3;
                while (i3 < length) {
                    Object[] objArr = this.b;
                    Object obj2 = objArr[i3];
                    objArr[i3] = null;
                    if (collection.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.b[i4] = obj2;
                        i4++;
                    }
                    i3++;
                }
                i = i(i4);
                for (int i5 = 0; i5 < i2; i5++) {
                    Object[] objArr2 = this.b;
                    Object obj3 = objArr2[i5];
                    objArr2[i5] = null;
                    if (collection.contains(obj3)) {
                        z2 = true;
                    } else {
                        this.b[i] = obj3;
                        i = e(i);
                    }
                }
                z = z2;
            }
            if (z) {
                registerModification();
                this.c = g(i - this.a);
            }
        }
        return z;
    }

    @Override // defpackage.i1
    public Object removeAt(int i) {
        kotlin.collections.a.Companion.b(i, size());
        if (i == j.l(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        registerModification();
        int i2 = i(this.a + i);
        Object obj = this.b[i2];
        if (i < (size() >> 1)) {
            int i3 = this.a;
            if (i2 >= i3) {
                Object[] objArr = this.b;
                d.g(objArr, objArr, i3 + 1, i3, i2);
            } else {
                Object[] objArr2 = this.b;
                d.g(objArr2, objArr2, 1, 0, i2);
                Object[] objArr3 = this.b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i4 = this.a;
                d.g(objArr3, objArr3, i4 + 1, i4, objArr3.length - 1);
            }
            Object[] objArr4 = this.b;
            int i5 = this.a;
            objArr4[i5] = null;
            this.a = e(i5);
        } else {
            int i6 = i(this.a + j.l(this));
            if (i2 <= i6) {
                Object[] objArr5 = this.b;
                d.g(objArr5, objArr5, i2, i2 + 1, i6 + 1);
            } else {
                Object[] objArr6 = this.b;
                d.g(objArr6, objArr6, i2, i2 + 1, objArr6.length);
                Object[] objArr7 = this.b;
                objArr7[objArr7.length - 1] = objArr7[0];
                d.g(objArr7, objArr7, 0, 1, i6 + 1);
            }
            this.b[i6] = null;
        }
        this.c = size() - 1;
        return obj;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        registerModification();
        Object[] objArr = this.b;
        int i = this.a;
        Object obj = objArr[i];
        objArr[i] = null;
        this.a = e(i);
        this.c = size() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        registerModification();
        int i = i(this.a + j.l(this));
        Object[] objArr = this.b;
        Object obj = objArr[i];
        objArr[i] = null;
        this.c = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i, int i2) {
        kotlin.collections.a.Companion.d(i, i2, size());
        int i3 = i2 - i;
        if (i3 == 0) {
            return;
        }
        if (i3 == size()) {
            clear();
            return;
        }
        if (i3 == 1) {
            remove(i);
            return;
        }
        registerModification();
        if (i < size() - i2) {
            k(i, i2);
            int i4 = i(this.a + i3);
            h(this.a, i4);
            this.a = i4;
        } else {
            l(i, i2);
            int i5 = i(this.a + size());
            h(g(i5 - i3), i5);
        }
        this.c = size() - i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection collection) {
        int i;
        p31.f(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.b.length != 0) {
            int i2 = i(this.a + size());
            int i3 = this.a;
            if (i3 < i2) {
                i = i3;
                while (i3 < i2) {
                    Object obj = this.b[i3];
                    if (collection.contains(obj)) {
                        this.b[i] = obj;
                        i++;
                    } else {
                        z = true;
                    }
                    i3++;
                }
                d.m(this.b, null, i, i2);
            } else {
                int length = this.b.length;
                boolean z2 = false;
                int i4 = i3;
                while (i3 < length) {
                    Object[] objArr = this.b;
                    Object obj2 = objArr[i3];
                    objArr[i3] = null;
                    if (collection.contains(obj2)) {
                        this.b[i4] = obj2;
                        i4++;
                    } else {
                        z2 = true;
                    }
                    i3++;
                }
                i = i(i4);
                for (int i5 = 0; i5 < i2; i5++) {
                    Object[] objArr2 = this.b;
                    Object obj3 = objArr2[i5];
                    objArr2[i5] = null;
                    if (collection.contains(obj3)) {
                        this.b[i] = obj3;
                        i = e(i);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                registerModification();
                this.c = g(i - this.a);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        kotlin.collections.a.Companion.b(i, size());
        int i2 = i(this.a + i);
        Object[] objArr = this.b;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        p31.f(objArr, "array");
        if (objArr.length < size()) {
            objArr = e.a(objArr, size());
        }
        int i = i(this.a + size());
        int i2 = this.a;
        if (i2 < i) {
            d.j(this.b, objArr, 0, i2, i, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.b;
            d.g(objArr2, objArr, 0, this.a, objArr2.length);
            Object[] objArr3 = this.b;
            d.g(objArr3, objArr, objArr3.length - this.a, 0, i);
        }
        return j.f(size(), objArr);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        kotlin.collections.a.Companion.c(i, size());
        if (i == size()) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        registerModification();
        d(size() + 1);
        int i2 = i(this.a + i);
        if (i < ((size() + 1) >> 1)) {
            int iC = c(i2);
            int iC2 = c(this.a);
            int i3 = this.a;
            if (iC >= i3) {
                Object[] objArr = this.b;
                objArr[iC2] = objArr[i3];
                d.g(objArr, objArr, i3, i3 + 1, iC + 1);
            } else {
                Object[] objArr2 = this.b;
                d.g(objArr2, objArr2, i3 - 1, i3, objArr2.length);
                Object[] objArr3 = this.b;
                objArr3[objArr3.length - 1] = objArr3[0];
                d.g(objArr3, objArr3, 0, 1, iC + 1);
            }
            this.b[iC] = obj;
            this.a = iC2;
        } else {
            int i4 = i(this.a + size());
            if (i2 < i4) {
                Object[] objArr4 = this.b;
                d.g(objArr4, objArr4, i2 + 1, i2, i4);
            } else {
                Object[] objArr5 = this.b;
                d.g(objArr5, objArr5, 1, 0, i4);
                Object[] objArr6 = this.b;
                objArr6[0] = objArr6[objArr6.length - 1];
                d.g(objArr6, objArr6, i2 + 1, i2, objArr6.length - 1);
            }
            this.b[i2] = obj;
        }
        this.c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection collection) {
        p31.f(collection, "elements");
        kotlin.collections.a.Companion.c(i, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i == size()) {
            return addAll(collection);
        }
        registerModification();
        d(size() + collection.size());
        int i2 = i(this.a + size());
        int i3 = i(this.a + i);
        int size = collection.size();
        if (i < ((size() + 1) >> 1)) {
            int i4 = this.a;
            int length = i4 - size;
            if (i3 < i4) {
                Object[] objArr = this.b;
                d.g(objArr, objArr, length, i4, objArr.length);
                if (size >= i3) {
                    Object[] objArr2 = this.b;
                    d.g(objArr2, objArr2, objArr2.length - size, 0, i3);
                } else {
                    Object[] objArr3 = this.b;
                    d.g(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.b;
                    d.g(objArr4, objArr4, 0, size, i3);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.b;
                d.g(objArr5, objArr5, length, i4, i3);
            } else {
                Object[] objArr6 = this.b;
                length += objArr6.length;
                int i5 = i3 - i4;
                int length2 = objArr6.length - length;
                if (length2 >= i5) {
                    d.g(objArr6, objArr6, length, i4, i3);
                } else {
                    d.g(objArr6, objArr6, length, i4, i4 + length2);
                    Object[] objArr7 = this.b;
                    d.g(objArr7, objArr7, 0, this.a + length2, i3);
                }
            }
            this.a = length;
            a(g(i3 - size), collection);
        } else {
            int i6 = i3 + size;
            if (i3 < i2) {
                int i7 = size + i2;
                Object[] objArr8 = this.b;
                if (i7 <= objArr8.length) {
                    d.g(objArr8, objArr8, i6, i3, i2);
                } else if (i6 >= objArr8.length) {
                    d.g(objArr8, objArr8, i6 - objArr8.length, i3, i2);
                } else {
                    int length3 = i2 - (i7 - objArr8.length);
                    d.g(objArr8, objArr8, 0, length3, i2);
                    Object[] objArr9 = this.b;
                    d.g(objArr9, objArr9, i6, i3, length3);
                }
            } else {
                Object[] objArr10 = this.b;
                d.g(objArr10, objArr10, size, 0, i2);
                Object[] objArr11 = this.b;
                if (i6 >= objArr11.length) {
                    d.g(objArr11, objArr11, i6 - objArr11.length, i3, objArr11.length);
                } else {
                    d.g(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.b;
                    d.g(objArr12, objArr12, i6, i3, objArr12.length - size);
                }
            }
            a(i3, collection);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
