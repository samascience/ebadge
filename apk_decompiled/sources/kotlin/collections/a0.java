package kotlin.collections;

import defpackage.f1;
import defpackage.ga2;
import defpackage.p31;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes4.dex */
final class a0 extends kotlin.collections.a implements RandomAccess {
    private final Object[] a;
    private final int b;
    private int c;
    private int d;

    public static final class a extends f1 {
        private int c;
        private int d;

        a() {
            this.c = a0.this.size();
            this.d = a0.this.c;
        }

        @Override // defpackage.f1
        protected void a() {
            if (this.c == 0) {
                b();
                return;
            }
            c(a0.this.a[this.d]);
            this.d = (this.d + 1) % a0.this.b;
            this.c--;
        }
    }

    public a0(Object[] objArr, int i) {
        p31.f(objArr, "buffer");
        this.a = objArr;
        if (i < 0) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i).toString());
        }
        if (i <= objArr.length) {
            this.b = objArr.length;
            this.d = i;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i + " cannot be larger than the buffer size: " + objArr.length).toString());
    }

    public final void f(Object obj) {
        if (h()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.a[(this.c + size()) % this.b] = obj;
        this.d = size() + 1;
    }

    public final a0 g(int i) {
        Object[] array;
        int i2 = this.b;
        int iD = ga2.d(i2 + (i2 >> 1) + 1, i);
        if (this.c == 0) {
            array = Arrays.copyOf(this.a, iD);
            p31.e(array, "copyOf(...)");
        } else {
            array = toArray(new Object[iD]);
        }
        return new a0(array, size());
    }

    @Override // kotlin.collections.a, java.util.List
    public Object get(int i) {
        kotlin.collections.a.Companion.b(i, size());
        return this.a[(this.c + i) % this.b];
    }

    @Override // defpackage.x0
    public int getSize() {
        return this.d;
    }

    public final boolean h() {
        return size() == this.b;
    }

    public final void i(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i).toString());
        }
        if (i > size()) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i + ", size = " + size()).toString());
        }
        if (i > 0) {
            int i2 = this.c;
            int i3 = (i2 + i) % this.b;
            if (i2 > i3) {
                d.m(this.a, null, i2, this.b);
                d.m(this.a, null, 0, i3);
            } else {
                d.m(this.a, null, i2, i3);
            }
            this.c = i3;
            this.d = size() - i;
        }
    }

    @Override // kotlin.collections.a, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new a();
    }

    @Override // defpackage.x0, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        p31.f(objArr, "array");
        if (objArr.length < size()) {
            objArr = Arrays.copyOf(objArr, size());
            p31.e(objArr, "copyOf(...)");
        }
        int size = size();
        int i = 0;
        int i2 = 0;
        for (int i3 = this.c; i2 < size && i3 < this.b; i3++) {
            objArr[i2] = this.a[i3];
            i2++;
        }
        while (i2 < size) {
            objArr[i2] = this.a[i];
            i2++;
            i++;
        }
        return j.f(size, objArr);
    }

    public a0(int i) {
        this(new Object[i], 0);
    }

    @Override // defpackage.x0, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
