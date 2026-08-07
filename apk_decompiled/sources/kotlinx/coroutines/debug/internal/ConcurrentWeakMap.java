package kotlinx.coroutines.debug.internal;

import defpackage.ar0;
import defpackage.cx;
import defpackage.ga2;
import defpackage.j1;
import defpackage.k1;
import defpackage.k81;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.y70;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;

/* JADX INFO: loaded from: classes4.dex */
public final class ConcurrentWeakMap<K, V> extends j1 {
    private static final AtomicIntegerFieldUpdater _size$FU = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");
    private static final AtomicReferenceFieldUpdater core$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentWeakMap.class, Object.class, "core");
    private volatile int _size;
    private volatile Object core;
    private final ReferenceQueue<K> weakRefQueue;

    private final class Core {
        private static final AtomicIntegerFieldUpdater load$FU = AtomicIntegerFieldUpdater.newUpdater(Core.class, "load");
        private final int allocated;
        private final AtomicReferenceArray keys;
        private volatile int load;
        private final int shift;
        private final int threshold;
        private final AtomicReferenceArray values;

        private final class KeyValueIterator<E> implements Iterator<E>, k81 {
            private final or0 factory;
            private int index = -1;
            private K key;
            private V value;

            public KeyValueIterator(or0 or0Var) {
                this.factory = or0Var;
                findNext();
            }

            private final void findNext() {
                K k;
                while (true) {
                    int i = this.index + 1;
                    this.index = i;
                    if (i >= ((Core) Core.this).allocated) {
                        return;
                    }
                    HashedWeakRef hashedWeakRef = (HashedWeakRef) ((Core) Core.this).keys.get(this.index);
                    if (hashedWeakRef != null && (k = (K) hashedWeakRef.get()) != null) {
                        this.key = k;
                        Object obj = (V) ((Core) Core.this).values.get(this.index);
                        if (obj instanceof Marked) {
                            obj = (V) ((Marked) obj).ref;
                        }
                        if (obj != null) {
                            this.value = (V) obj;
                            return;
                        }
                    }
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < ((Core) Core.this).allocated;
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.index >= ((Core) Core.this).allocated) {
                    throw new NoSuchElementException();
                }
                or0 or0Var = this.factory;
                Object obj = this.key;
                if (obj == null) {
                    p31.t("key");
                    obj = k83.a;
                }
                Object obj2 = this.value;
                if (obj2 == null) {
                    p31.t("value");
                    obj2 = k83.a;
                }
                E e = (E) or0Var.invoke(obj, obj2);
                findNext();
                return e;
            }

            @Override // java.util.Iterator
            public Void remove() {
                ConcurrentWeakMapKt.noImpl();
                throw new KotlinNothingValueException();
            }
        }

        public Core(int i) {
            this.allocated = i;
            this.shift = Integer.numberOfLeadingZeros(i) + 1;
            this.threshold = (i * 2) / 3;
            this.keys = new AtomicReferenceArray(i);
            this.values = new AtomicReferenceArray(i);
        }

        private final int index(int i) {
            return (i * (-1640531527)) >>> this.shift;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object putImpl$default(Core core, Object obj, Object obj2, HashedWeakRef hashedWeakRef, int i, Object obj3) {
            if ((i & 4) != 0) {
                hashedWeakRef = null;
            }
            return core.putImpl(obj, obj2, hashedWeakRef);
        }

        private final void removeCleanedAt(int i) {
            Object obj;
            do {
                obj = this.values.get(i);
                if (obj == null || (obj instanceof Marked)) {
                    return;
                }
            } while (!cx.a(this.values, i, obj, null));
            ConcurrentWeakMap.this.decrementSize();
        }

        private final void update$atomicfu(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, ar0 ar0Var, Object obj) {
            int i;
            do {
                i = atomicIntegerFieldUpdater.get(obj);
            } while (!atomicIntegerFieldUpdater.compareAndSet(obj, i, ((Number) ar0Var.invoke(Integer.valueOf(i))).intValue()));
        }

        public final void cleanWeakRef(HashedWeakRef<?> hashedWeakRef) {
            int iIndex = index(hashedWeakRef.hash);
            while (true) {
                HashedWeakRef<?> hashedWeakRef2 = (HashedWeakRef) this.keys.get(iIndex);
                if (hashedWeakRef2 == null) {
                    return;
                }
                if (hashedWeakRef2 == hashedWeakRef) {
                    removeCleanedAt(iIndex);
                    return;
                } else {
                    if (iIndex == 0) {
                        iIndex = this.allocated;
                    }
                    iIndex--;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final V getImpl(K k) {
            int iIndex = index(k.hashCode());
            while (true) {
                HashedWeakRef hashedWeakRef = (HashedWeakRef) this.keys.get(iIndex);
                if (hashedWeakRef == null) {
                    return null;
                }
                T t = hashedWeakRef.get();
                if (p31.a(k, t)) {
                    V v = (V) this.values.get(iIndex);
                    return v instanceof Marked ? (V) ((Marked) v).ref : v;
                }
                if (t == 0) {
                    removeCleanedAt(iIndex);
                }
                if (iIndex == 0) {
                    iIndex = this.allocated;
                }
                iIndex--;
            }
        }

        public final <E> Iterator<E> keyValueIterator(or0 or0Var) {
            return new KeyValueIterator(or0Var);
        }

        public final Object putImpl(K k, V v, HashedWeakRef<K> hashedWeakRef) {
            int i;
            Object obj;
            int iIndex = index(k.hashCode());
            boolean z = false;
            while (true) {
                HashedWeakRef hashedWeakRef2 = (HashedWeakRef) this.keys.get(iIndex);
                if (hashedWeakRef2 != null) {
                    T t = hashedWeakRef2.get();
                    if (p31.a(k, t)) {
                        if (!z) {
                            break;
                        }
                        load$FU.decrementAndGet(this);
                        break;
                    }
                    if (t == 0) {
                        removeCleanedAt(iIndex);
                    }
                    if (iIndex == 0) {
                        iIndex = this.allocated;
                    }
                    iIndex--;
                } else if (v != null) {
                    if (!z) {
                        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = load$FU;
                        do {
                            i = atomicIntegerFieldUpdater.get(this);
                            if (i >= this.threshold) {
                                return ConcurrentWeakMapKt.REHASH;
                            }
                        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, i + 1));
                        z = true;
                    }
                    if (hashedWeakRef == null) {
                        hashedWeakRef = new HashedWeakRef<>(k, ((ConcurrentWeakMap) ConcurrentWeakMap.this).weakRefQueue);
                    }
                    if (cx.a(this.keys, iIndex, null, hashedWeakRef)) {
                        break;
                    }
                } else {
                    return null;
                }
            }
            do {
                obj = this.values.get(iIndex);
                if (obj instanceof Marked) {
                    return ConcurrentWeakMapKt.REHASH;
                }
            } while (!cx.a(this.values, iIndex, obj, v));
            return obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final ConcurrentWeakMap<K, V>.Core rehash() {
            Object obj;
            while (true) {
                ConcurrentWeakMap<K, V>.Core core = (ConcurrentWeakMap<K, V>.Core) ConcurrentWeakMap.this.new Core(Integer.highestOneBit(ga2.b(ConcurrentWeakMap.this.size(), 4)) * 4);
                int i = this.allocated;
                for (int i2 = 0; i2 < i; i2++) {
                    HashedWeakRef hashedWeakRef = (HashedWeakRef) this.keys.get(i2);
                    Object obj2 = hashedWeakRef != null ? hashedWeakRef.get() : null;
                    if (hashedWeakRef != null && obj2 == null) {
                        removeCleanedAt(i2);
                    }
                    do {
                        obj = this.values.get(i2);
                        if (obj instanceof Marked) {
                            obj = ((Marked) obj).ref;
                            break;
                        }
                    } while (!cx.a(this.values, i2, obj, ConcurrentWeakMapKt.mark(obj)));
                    if (obj2 == null || obj == null || core.putImpl(obj2, obj, hashedWeakRef) != ConcurrentWeakMapKt.REHASH) {
                    }
                }
                return core;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class Entry<K, V> implements Map.Entry<K, V>, k81 {
        private final K key;
        private final V value;

        public Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            ConcurrentWeakMapKt.noImpl();
            throw new KotlinNothingValueException();
        }
    }

    private final class KeyValueSet<E> extends k1 {
        private final or0 factory;

        public KeyValueSet(or0 or0Var) {
            this.factory = or0Var;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            ConcurrentWeakMapKt.noImpl();
            throw new KotlinNothingValueException();
        }

        @Override // defpackage.k1
        public int getSize() {
            return ConcurrentWeakMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return ((Core) ConcurrentWeakMap.core$FU.get(ConcurrentWeakMap.this)).keyValueIterator(this.factory);
        }
    }

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    private final void cleanWeakRef(HashedWeakRef<?> hashedWeakRef) {
        ((Core) core$FU.get(this)).cleanWeakRef(hashedWeakRef);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void decrementSize() {
        _size$FU.decrementAndGet(this);
    }

    private final synchronized V putSynchronized(K k, V v) {
        V v2;
        Core coreRehash = (Core) core$FU.get(this);
        while (true) {
            v2 = (V) Core.putImpl$default(coreRehash, k, v, null, 4, null);
            if (v2 == ConcurrentWeakMapKt.REHASH) {
                coreRehash = coreRehash.rehash();
                core$FU.set(this, coreRehash);
            }
        }
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterator<Object> it = keySet().iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        return (V) ((Core) core$FU.get(this)).getImpl(obj);
    }

    @Override // defpackage.j1
    public Set<Map.Entry<K, V>> getEntries() {
        return new KeyValueSet(new or0() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$entries$1
            @Override // defpackage.or0
            public final Map.Entry<K, V> invoke(K k, V v) {
                return new ConcurrentWeakMap.Entry(k, v);
            }
        });
    }

    @Override // defpackage.j1
    public Set<K> getKeys() {
        return new KeyValueSet(new or0() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$keys$1
            @Override // defpackage.or0
            public final K invoke(K k, V v) {
                return k;
            }
        });
    }

    @Override // defpackage.j1
    public int getSize() {
        return _size$FU.get(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        V vPutSynchronized = (V) Core.putImpl$default((Core) core$FU.get(this), k, v, null, 4, null);
        if (vPutSynchronized == ConcurrentWeakMapKt.REHASH) {
            vPutSynchronized = putSynchronized(k, v);
        }
        if (vPutSynchronized == null) {
            _size$FU.incrementAndGet(this);
        }
        return vPutSynchronized;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (obj == 0) {
            return null;
        }
        V vPutSynchronized = (V) Core.putImpl$default((Core) core$FU.get(this), obj, null, null, 4, null);
        if (vPutSynchronized == ConcurrentWeakMapKt.REHASH) {
            vPutSynchronized = putSynchronized(obj, null);
        }
        if (vPutSynchronized != null) {
            _size$FU.decrementAndGet(this);
        }
        return vPutSynchronized;
    }

    public final void runWeakRefQueueCleaningLoopUntilInterrupted() {
        if (this.weakRefQueue == null) {
            throw new IllegalStateException("Must be created with weakRefQueue = true");
        }
        while (true) {
            try {
                Reference<? extends K> referenceRemove = this.weakRefQueue.remove();
                p31.d(referenceRemove, "null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
                cleanWeakRef((HashedWeakRef) referenceRemove);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public /* synthetic */ ConcurrentWeakMap(boolean z, int i, y70 y70Var) {
        this((i & 1) != 0 ? false : z);
    }

    public ConcurrentWeakMap(boolean z) {
        this.core = new Core(16);
        this.weakRefQueue = z ? new ReferenceQueue<>() : null;
    }
}
