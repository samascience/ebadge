package kotlin.collections.builders;

import defpackage.i1;
import defpackage.k81;
import defpackage.p31;
import defpackage.qb1;
import defpackage.y70;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.d;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes4.dex */
public final class ListBuilder<E> extends i1 implements List<E>, RandomAccess, Serializable, k81 {
    private static final a Companion = new a(null);
    private static final ListBuilder Empty;
    private E[] backing;
    private boolean isReadOnly;
    private int length;

    public static final class BuilderSubList<E> extends i1 implements List<E>, RandomAccess, Serializable, k81 {
        private E[] backing;
        private int length;
        private final int offset;
        private final BuilderSubList<E> parent;
        private final ListBuilder<E> root;

        private static final class a implements ListIterator, k81 {
            private final BuilderSubList a;
            private int b;
            private int c;
            private int d;

            public a(BuilderSubList builderSubList, int i) {
                p31.f(builderSubList, "list");
                this.a = builderSubList;
                this.b = i;
                this.c = -1;
                this.d = ((AbstractList) builderSubList).modCount;
            }

            private final void a() {
                if (((AbstractList) this.a.root).modCount != this.d) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.ListIterator
            public void add(Object obj) {
                a();
                BuilderSubList builderSubList = this.a;
                int i = this.b;
                this.b = i + 1;
                builderSubList.add(i, obj);
                this.c = -1;
                this.d = ((AbstractList) this.a).modCount;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.b < this.a.length;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.b > 0;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public Object next() {
                a();
                if (this.b >= this.a.length) {
                    throw new NoSuchElementException();
                }
                int i = this.b;
                this.b = i + 1;
                this.c = i;
                return this.a.backing[this.a.offset + this.c];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.b;
            }

            @Override // java.util.ListIterator
            public Object previous() {
                a();
                int i = this.b;
                if (i <= 0) {
                    throw new NoSuchElementException();
                }
                int i2 = i - 1;
                this.b = i2;
                this.c = i2;
                return this.a.backing[this.a.offset + this.c];
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.b - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                a();
                int i = this.c;
                if (i == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                this.a.remove(i);
                this.b = this.c;
                this.c = -1;
                this.d = ((AbstractList) this.a).modCount;
            }

            @Override // java.util.ListIterator
            public void set(Object obj) {
                a();
                int i = this.c;
                if (i == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                this.a.set(i, obj);
            }
        }

        public BuilderSubList(E[] eArr, int i, int i2, BuilderSubList<E> builderSubList, ListBuilder<E> listBuilder) {
            p31.f(eArr, "backing");
            p31.f(listBuilder, "root");
            this.backing = eArr;
            this.offset = i;
            this.length = i2;
            this.parent = builderSubList;
            this.root = listBuilder;
            ((AbstractList) this).modCount = ((AbstractList) listBuilder).modCount;
        }

        private final void addAllInternal(int i, Collection<? extends E> collection, int i2) {
            registerModification();
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList != null) {
                builderSubList.addAllInternal(i, collection, i2);
            } else {
                this.root.addAllInternal(i, collection, i2);
            }
            this.backing = (E[]) ((ListBuilder) this.root).backing;
            this.length += i2;
        }

        private final void addAtInternal(int i, E e) {
            registerModification();
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList != null) {
                builderSubList.addAtInternal(i, e);
            } else {
                this.root.addAtInternal(i, e);
            }
            this.backing = (E[]) ((ListBuilder) this.root).backing;
            this.length++;
        }

        private final void checkForComodification() {
            if (((AbstractList) this.root).modCount != ((AbstractList) this).modCount) {
                throw new ConcurrentModificationException();
            }
        }

        private final void checkIsMutable() {
            if (isReadOnly()) {
                throw new UnsupportedOperationException();
            }
        }

        private final boolean contentEquals(List<?> list) {
            return qb1.h(this.backing, this.offset, this.length, list);
        }

        private final boolean isReadOnly() {
            return ((ListBuilder) this.root).isReadOnly;
        }

        private final void registerModification() {
            ((AbstractList) this).modCount++;
        }

        private final E removeAtInternal(int i) {
            registerModification();
            BuilderSubList<E> builderSubList = this.parent;
            E eRemoveAtInternal = builderSubList != null ? builderSubList.removeAtInternal(i) : (E) this.root.removeAtInternal(i);
            this.length--;
            return eRemoveAtInternal;
        }

        private final void removeRangeInternal(int i, int i2) {
            if (i2 > 0) {
                registerModification();
            }
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList != null) {
                builderSubList.removeRangeInternal(i, i2);
            } else {
                this.root.removeRangeInternal(i, i2);
            }
            this.length -= i2;
        }

        private final int retainOrRemoveAllInternal(int i, int i2, Collection<? extends E> collection, boolean z) {
            BuilderSubList<E> builderSubList = this.parent;
            int iRetainOrRemoveAllInternal = builderSubList != null ? builderSubList.retainOrRemoveAllInternal(i, i2, collection, z) : this.root.retainOrRemoveAllInternal(i, i2, collection, z);
            if (iRetainOrRemoveAllInternal > 0) {
                registerModification();
            }
            this.length -= iRetainOrRemoveAllInternal;
            return iRetainOrRemoveAllInternal;
        }

        private final Object writeReplace() throws NotSerializableException {
            if (isReadOnly()) {
                return new SerializedCollection(this, 0);
            }
            throw new NotSerializableException("The list cannot be serialized while it is being built.");
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(E e) {
            checkIsMutable();
            checkForComodification();
            addAtInternal(this.offset + this.length, e);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends E> collection) {
            p31.f(collection, "elements");
            checkIsMutable();
            checkForComodification();
            int size = collection.size();
            addAllInternal(this.offset + this.length, collection, size);
            return size > 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            checkIsMutable();
            checkForComodification();
            removeRangeInternal(this.offset, this.length);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            checkForComodification();
            return obj == this || ((obj instanceof List) && contentEquals((List) obj));
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            checkForComodification();
            kotlin.collections.a.Companion.b(i, this.length);
            return this.backing[this.offset + i];
        }

        @Override // defpackage.i1
        public int getSize() {
            checkForComodification();
            return this.length;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            checkForComodification();
            return qb1.i(this.backing, this.offset, this.length);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            checkForComodification();
            for (int i = 0; i < this.length; i++) {
                if (p31.a(this.backing[this.offset + i], obj)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            checkForComodification();
            return this.length == 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<E> iterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            checkForComodification();
            for (int i = this.length - 1; i >= 0; i--) {
                if (p31.a(this.backing[this.offset + i], obj)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object obj) {
            checkIsMutable();
            checkForComodification();
            int iIndexOf = indexOf(obj);
            if (iIndexOf >= 0) {
                remove(iIndexOf);
            }
            return iIndexOf >= 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection<? extends Object> collection) {
            p31.f(collection, "elements");
            checkIsMutable();
            checkForComodification();
            return retainOrRemoveAllInternal(this.offset, this.length, collection, false) > 0;
        }

        @Override // defpackage.i1
        public E removeAt(int i) {
            checkIsMutable();
            checkForComodification();
            kotlin.collections.a.Companion.b(i, this.length);
            return removeAtInternal(this.offset + i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(Collection<? extends Object> collection) {
            p31.f(collection, "elements");
            checkIsMutable();
            checkForComodification();
            return retainOrRemoveAllInternal(this.offset, this.length, collection, true) > 0;
        }

        @Override // java.util.AbstractList, java.util.List
        public E set(int i, E e) {
            checkIsMutable();
            checkForComodification();
            kotlin.collections.a.Companion.b(i, this.length);
            E[] eArr = this.backing;
            int i2 = this.offset;
            E e2 = eArr[i2 + i];
            eArr[i2 + i] = e;
            return e2;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<E> subList(int i, int i2) {
            kotlin.collections.a.Companion.d(i, i2, this.length);
            return new BuilderSubList(this.backing, this.offset + i, i2 - i, this, this.root);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public <T> T[] toArray(T[] tArr) {
            p31.f(tArr, "array");
            checkForComodification();
            int length = tArr.length;
            int i = this.length;
            if (length >= i) {
                E[] eArr = this.backing;
                int i2 = this.offset;
                d.g(eArr, tArr, 0, i2, i + i2);
                return (T[]) j.f(this.length, tArr);
            }
            E[] eArr2 = this.backing;
            int i3 = this.offset;
            T[] tArr2 = (T[]) Arrays.copyOfRange(eArr2, i3, i + i3, tArr.getClass());
            p31.e(tArr2, "copyOfRange(...)");
            return tArr2;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            checkForComodification();
            return qb1.j(this.backing, this.offset, this.length, this);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int i) {
            checkForComodification();
            kotlin.collections.a.Companion.c(i, this.length);
            return new a(this, i);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, E e) {
            checkIsMutable();
            checkForComodification();
            kotlin.collections.a.Companion.c(i, this.length);
            addAtInternal(this.offset + i, e);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i, Collection<? extends E> collection) {
            p31.f(collection, "elements");
            checkIsMutable();
            checkForComodification();
            kotlin.collections.a.Companion.c(i, this.length);
            int size = collection.size();
            addAllInternal(this.offset + i, collection, size);
            return size > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            checkForComodification();
            E[] eArr = this.backing;
            int i = this.offset;
            return d.l(eArr, i, this.length + i);
        }
    }

    private static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    private static final class b implements ListIterator, k81 {
        private final ListBuilder a;
        private int b;
        private int c;
        private int d;

        public b(ListBuilder listBuilder, int i) {
            p31.f(listBuilder, "list");
            this.a = listBuilder;
            this.b = i;
            this.c = -1;
            this.d = ((AbstractList) listBuilder).modCount;
        }

        private final void a() {
            if (((AbstractList) this.a).modCount != this.d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            a();
            ListBuilder listBuilder = this.a;
            int i = this.b;
            this.b = i + 1;
            listBuilder.add(i, obj);
            this.c = -1;
            this.d = ((AbstractList) this.a).modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a.length;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            a();
            if (this.b >= this.a.length) {
                throw new NoSuchElementException();
            }
            int i = this.b;
            this.b = i + 1;
            this.c = i;
            return this.a.backing[this.c];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.b;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            a();
            int i = this.b;
            if (i <= 0) {
                throw new NoSuchElementException();
            }
            int i2 = i - 1;
            this.b = i2;
            this.c = i2;
            return this.a.backing[this.c];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            a();
            int i = this.c;
            if (i == -1) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            }
            this.a.remove(i);
            this.b = this.c;
            this.c = -1;
            this.d = ((AbstractList) this.a).modCount;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            a();
            int i = this.c;
            if (i == -1) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            }
            this.a.set(i, obj);
        }
    }

    static {
        ListBuilder listBuilder = new ListBuilder(0);
        listBuilder.isReadOnly = true;
        Empty = listBuilder;
    }

    public ListBuilder() {
        this(0, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addAllInternal(int i, Collection<? extends E> collection, int i2) {
        registerModification();
        insertAtInternal(i, i2);
        Iterator<? extends E> it = collection.iterator();
        for (int i3 = 0; i3 < i2; i3++) {
            this.backing[i + i3] = it.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addAtInternal(int i, E e) {
        registerModification();
        insertAtInternal(i, 1);
        this.backing[i] = e;
    }

    private final void checkIsMutable() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean contentEquals(List<?> list) {
        return qb1.h(this.backing, 0, this.length, list);
    }

    private final void ensureCapacityInternal(int i) {
        if (i < 0) {
            throw new OutOfMemoryError();
        }
        E[] eArr = this.backing;
        if (i > eArr.length) {
            this.backing = (E[]) qb1.e(this.backing, kotlin.collections.a.Companion.e(eArr.length, i));
        }
    }

    private final void ensureExtraCapacity(int i) {
        ensureCapacityInternal(this.length + i);
    }

    private final void insertAtInternal(int i, int i2) {
        ensureExtraCapacity(i2);
        E[] eArr = this.backing;
        d.g(eArr, eArr, i + i2, i, this.length);
        this.length += i2;
    }

    private final void registerModification() {
        ((AbstractList) this).modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final E removeAtInternal(int i) {
        registerModification();
        E[] eArr = this.backing;
        E e = eArr[i];
        d.g(eArr, eArr, i, i + 1, this.length);
        qb1.f(this.backing, this.length - 1);
        this.length--;
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeRangeInternal(int i, int i2) {
        if (i2 > 0) {
            registerModification();
        }
        E[] eArr = this.backing;
        d.g(eArr, eArr, i, i + i2, this.length);
        E[] eArr2 = this.backing;
        int i3 = this.length;
        qb1.g(eArr2, i3 - i2, i3);
        this.length -= i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int retainOrRemoveAllInternal(int i, int i2, Collection<? extends E> collection, boolean z) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + i3;
            if (collection.contains(this.backing[i5]) == z) {
                E[] eArr = this.backing;
                i3++;
                eArr[i4 + i] = eArr[i5];
                i4++;
            } else {
                i3++;
            }
        }
        int i6 = i2 - i4;
        E[] eArr2 = this.backing;
        d.g(eArr2, eArr2, i + i4, i2 + i, this.length);
        E[] eArr3 = this.backing;
        int i7 = this.length;
        qb1.g(eArr3, i7 - i6, i7);
        if (i6 > 0) {
            registerModification();
        }
        this.length -= i6;
        return i6;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.isReadOnly) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        checkIsMutable();
        addAtInternal(this.length, e);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        p31.f(collection, "elements");
        checkIsMutable();
        int size = collection.size();
        addAllInternal(this.length, collection, size);
        return size > 0;
    }

    public final List<E> build() {
        checkIsMutable();
        this.isReadOnly = true;
        return this.length > 0 ? this : Empty;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkIsMutable();
        removeRangeInternal(0, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof List) && contentEquals((List) obj));
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        kotlin.collections.a.Companion.b(i, this.length);
        return this.backing[i];
    }

    @Override // defpackage.i1
    public int getSize() {
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return qb1.i(this.backing, 0, this.length);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i = 0; i < this.length; i++) {
            if (p31.a(this.backing[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i = this.length - 1; i >= 0; i--) {
            if (p31.a(this.backing[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        checkIsMutable();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            remove(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> collection) {
        p31.f(collection, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(0, this.length, collection, false) > 0;
    }

    @Override // defpackage.i1
    public E removeAt(int i) {
        checkIsMutable();
        kotlin.collections.a.Companion.b(i, this.length);
        return removeAtInternal(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> collection) {
        p31.f(collection, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(0, this.length, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        checkIsMutable();
        kotlin.collections.a.Companion.b(i, this.length);
        E[] eArr = this.backing;
        E e2 = eArr[i];
        eArr[i] = e;
        return e2;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int i, int i2) {
        kotlin.collections.a.Companion.d(i, i2, this.length);
        return new BuilderSubList(this.backing, i, i2 - i, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        p31.f(tArr, "array");
        int length = tArr.length;
        int i = this.length;
        if (length >= i) {
            d.g(this.backing, tArr, 0, 0, i);
            return (T[]) j.f(this.length, tArr);
        }
        T[] tArr2 = (T[]) Arrays.copyOfRange(this.backing, 0, i, tArr.getClass());
        p31.e(tArr2, "copyOfRange(...)");
        return tArr2;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return qb1.j(this.backing, 0, this.length, this);
    }

    public ListBuilder(int i) {
        this.backing = (E[]) qb1.d(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i) {
        kotlin.collections.a.Companion.c(i, this.length);
        return new b(this, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        checkIsMutable();
        kotlin.collections.a.Companion.c(i, this.length);
        addAtInternal(i, e);
    }

    public /* synthetic */ ListBuilder(int i, int i2, y70 y70Var) {
        this((i2 & 1) != 0 ? 10 : i);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        p31.f(collection, "elements");
        checkIsMutable();
        kotlin.collections.a.Companion.c(i, this.length);
        int size = collection.size();
        addAllInternal(i, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return d.l(this.backing, 0, this.length);
    }
}
