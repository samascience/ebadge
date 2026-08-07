package com.fasterxml.jackson.databind.util.internal;

import defpackage.p62;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public final class PrivateMaxEntriesMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final long MAXIMUM_CAPACITY = 9223372034707292160L;
    static final int NCPU;
    static final int NUMBER_OF_READ_BUFFERS;
    static final int READ_BUFFERS_MASK;
    static final int READ_BUFFER_DRAIN_THRESHOLD = 8;
    static final int READ_BUFFER_INDEX_MASK = 15;
    static final int READ_BUFFER_SIZE = 16;
    static final int READ_BUFFER_THRESHOLD = 4;
    static final int WRITE_BUFFER_DRAIN_THRESHOLD = 16;
    static final long serialVersionUID = 1;
    final AtomicLong capacity;
    final int concurrencyLevel;
    final ConcurrentMap<K, Node<K, V>> data;
    final AtomicReference<DrainStatus> drainStatus;
    transient Set<Map.Entry<K, V>> entrySet;
    final com.fasterxml.jackson.databind.util.internal.b evictionDeque;
    final Lock evictionLock;
    transient Set<K> keySet;
    final AtomicLongArray readBufferDrainAtWriteCount;
    final long[] readBufferReadCount;
    final AtomicLongArray readBufferWriteCount;
    final AtomicReferenceArray<Node<K, V>> readBuffers;
    transient Collection<V> values;
    final AtomicLong weightedSize;
    final Queue<Runnable> writeBuffer;

    enum DrainStatus {
        IDLE { // from class: com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap.DrainStatus.1
            @Override // com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap.DrainStatus
            boolean shouldDrainBuffers(boolean z) {
                return !z;
            }
        },
        REQUIRED { // from class: com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap.DrainStatus.2
            @Override // com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap.DrainStatus
            boolean shouldDrainBuffers(boolean z) {
                return true;
            }
        },
        PROCESSING { // from class: com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap.DrainStatus.3
            @Override // com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap.DrainStatus
            boolean shouldDrainBuffers(boolean z) {
                return false;
            }
        };

        abstract boolean shouldDrainBuffers(boolean z);
    }

    static final class Node<K, V> extends AtomicReference<l> implements com.fasterxml.jackson.databind.util.internal.a {
        final K key;
        Node<K, V> next;
        Node<K, V> prev;

        Node(K k, l lVar) {
            super(lVar);
            this.key = k;
        }

        V getValue() {
            return (V) ((l) get()).b;
        }

        @Override // com.fasterxml.jackson.databind.util.internal.a
        public Node<K, V> getNext() {
            return this.next;
        }

        @Override // com.fasterxml.jackson.databind.util.internal.a
        public Node<K, V> getPrevious() {
            return this.prev;
        }

        @Override // com.fasterxml.jackson.databind.util.internal.a
        public void setNext(Node<K, V> node) {
            this.next = node;
        }

        @Override // com.fasterxml.jackson.databind.util.internal.a
        public void setPrevious(Node<K, V> node) {
            this.prev = node;
        }
    }

    static final class SerializationProxy<K, V> implements Serializable {
        static final long serialVersionUID = 1;
        final long capacity;
        final int concurrencyLevel;
        final Map<K, V> data;

        SerializationProxy(PrivateMaxEntriesMap<K, V> privateMaxEntriesMap) {
            this.concurrencyLevel = privateMaxEntriesMap.concurrencyLevel;
            this.data = new HashMap(privateMaxEntriesMap);
            this.capacity = privateMaxEntriesMap.capacity.get();
        }

        Object readResolve() {
            PrivateMaxEntriesMap privateMaxEntriesMapA = new c().d(this.capacity).a();
            privateMaxEntriesMapA.putAll(this.data);
            return privateMaxEntriesMapA;
        }
    }

    final class WriteThroughEntry extends AbstractMap.SimpleEntry<K, V> {
        static final long serialVersionUID = 1;

        WriteThroughEntry(Node<K, V> node) {
            super(node.key, node.getValue());
        }

        @Override // java.util.AbstractMap.SimpleEntry, java.util.Map.Entry
        public V setValue(V v) {
            PrivateMaxEntriesMap.this.put(getKey(), v);
            return (V) super.setValue(v);
        }

        Object writeReplace() {
            return new AbstractMap.SimpleEntry(this);
        }
    }

    final class b implements Runnable {
        final Node a;
        final int b;

        b(Node node, int i) {
            this.b = i;
            this.a = node;
        }

        @Override // java.lang.Runnable
        public void run() {
            AtomicLong atomicLong = PrivateMaxEntriesMap.this.weightedSize;
            atomicLong.lazySet(atomicLong.get() + ((long) this.b));
            if (this.a.get().b()) {
                PrivateMaxEntriesMap.this.evictionDeque.add(this.a);
                PrivateMaxEntriesMap.this.evict();
            }
        }
    }

    public static final class c {
        long c = -1;
        int b = 16;
        int a = 16;

        public PrivateMaxEntriesMap a() {
            PrivateMaxEntriesMap.checkState(this.c >= 0);
            return new PrivateMaxEntriesMap(this);
        }

        public c b(int i) {
            PrivateMaxEntriesMap.checkArgument(i > 0);
            this.a = i;
            return this;
        }

        public c c(int i) {
            PrivateMaxEntriesMap.checkArgument(i >= 0);
            this.b = i;
            return this;
        }

        public c d(long j) {
            PrivateMaxEntriesMap.checkArgument(j >= 0);
            this.c = j;
            return this;
        }
    }

    final class d implements Iterator {
        final Iterator a;
        Node b;

        d() {
            this.a = PrivateMaxEntriesMap.this.data.values().iterator();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            this.b = (Node) this.a.next();
            return new WriteThroughEntry(this.b);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            PrivateMaxEntriesMap.checkState(this.b != null);
            PrivateMaxEntriesMap.this.remove(this.b.key);
            this.b = null;
        }
    }

    final class e extends AbstractSet {
        final PrivateMaxEntriesMap a;

        e() {
            this.a = PrivateMaxEntriesMap.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            throw new UnsupportedOperationException("ConcurrentLinkedHashMap does not allow add to be called on entrySet()");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Node<K, V> node = this.a.data.get(entry.getKey());
            return node != null && node.getValue().equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.a.remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.a.size();
        }
    }

    final class f implements Iterator {
        final Iterator a;
        Object b;

        f() {
            this.a = PrivateMaxEntriesMap.this.data.keySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            Object next = this.a.next();
            this.b = next;
            return next;
        }

        @Override // java.util.Iterator
        public void remove() {
            PrivateMaxEntriesMap.checkState(this.b != null);
            PrivateMaxEntriesMap.this.remove(this.b);
            this.b = null;
        }
    }

    final class g extends AbstractSet {
        final PrivateMaxEntriesMap a;

        g() {
            this.a = PrivateMaxEntriesMap.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return PrivateMaxEntriesMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return this.a.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return this.a.data.keySet().toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray(Object[] objArr) {
            return this.a.data.keySet().toArray(objArr);
        }
    }

    final class h implements Runnable {
        final Node a;

        h(Node node) {
            this.a = node;
        }

        @Override // java.lang.Runnable
        public void run() {
            PrivateMaxEntriesMap.this.evictionDeque.x(this.a);
            PrivateMaxEntriesMap.this.makeDead(this.a);
        }
    }

    final class i implements Runnable {
        final int a;
        final Node b;

        i(Node node, int i) {
            this.a = i;
            this.b = node;
        }

        @Override // java.lang.Runnable
        public void run() {
            AtomicLong atomicLong = PrivateMaxEntriesMap.this.weightedSize;
            atomicLong.lazySet(atomicLong.get() + ((long) this.a));
            PrivateMaxEntriesMap.this.applyRead(this.b);
            PrivateMaxEntriesMap.this.evict();
        }
    }

    final class j implements Iterator {
        final Iterator a;
        Node b;

        j() {
            this.a = PrivateMaxEntriesMap.this.data.values().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            Node node = (Node) this.a.next();
            this.b = node;
            return node.getValue();
        }

        @Override // java.util.Iterator
        public void remove() {
            PrivateMaxEntriesMap.checkState(this.b != null);
            PrivateMaxEntriesMap.this.remove(this.b.key);
            this.b = null;
        }
    }

    final class k extends AbstractCollection {
        k() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            PrivateMaxEntriesMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return PrivateMaxEntriesMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new j();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return PrivateMaxEntriesMap.this.size();
        }
    }

    static final class l {
        final int a;
        final Object b;

        l(Object obj, int i) {
            this.a = i;
            this.b = obj;
        }

        boolean a(Object obj) {
            Object obj2 = this.b;
            return obj == obj2 || obj2.equals(obj);
        }

        boolean b() {
            return this.a > 0;
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        NCPU = iAvailableProcessors;
        int iMin = Math.min(4, ceilingNextPowerOfTwo(iAvailableProcessors));
        NUMBER_OF_READ_BUFFERS = iMin;
        READ_BUFFERS_MASK = iMin - 1;
    }

    static int ceilingNextPowerOfTwo(int i2) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i2 - 1));
    }

    static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    static void checkNotNull(Object obj) {
        obj.getClass();
    }

    static void checkState(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    private static int readBufferIndex(int i2, int i3) {
        return (i2 * 16) + i3;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }

    void afterRead(Node<K, V> node) {
        int bufferIndex = readBufferIndex();
        drainOnReadIfNeeded(bufferIndex, recordRead(bufferIndex, node));
    }

    void afterWrite(Runnable runnable) {
        this.writeBuffer.add(runnable);
        this.drainStatus.lazySet(DrainStatus.REQUIRED);
        tryToDrainBuffers();
    }

    void applyRead(Node<K, V> node) {
        if (this.evictionDeque.e(node)) {
            this.evictionDeque.k(node);
        }
    }

    public long capacity() {
        return this.capacity.get();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.evictionLock.lock();
        while (true) {
            try {
                Node<K, V> node = (Node) this.evictionDeque.poll();
                if (node == null) {
                    break;
                }
                this.data.remove(node.key, node);
                makeDead(node);
            } catch (Throwable th) {
                this.evictionLock.unlock();
                throw th;
            }
        }
        for (int i2 = 0; i2 < this.readBuffers.length(); i2++) {
            this.readBuffers.lazySet(i2, null);
        }
        while (true) {
            Runnable runnablePoll = this.writeBuffer.poll();
            if (runnablePoll == null) {
                this.evictionLock.unlock();
                return;
            }
            runnablePoll.run();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.data.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        checkNotNull(obj);
        Iterator<Node<K, V>> it = this.data.values().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    void drainBuffers() {
        drainReadBuffers();
        drainWriteBuffer();
    }

    void drainOnReadIfNeeded(int i2, long j2) {
        if (this.drainStatus.get().shouldDrainBuffers(j2 - this.readBufferDrainAtWriteCount.get(i2) < 4)) {
            tryToDrainBuffers();
        }
    }

    void drainReadBuffer(int i2) {
        int bufferIndex;
        Node<K, V> node;
        long j2 = this.readBufferWriteCount.get(i2);
        for (int i3 = 0; i3 < 8 && (node = this.readBuffers.get((bufferIndex = readBufferIndex(i2, (int) (this.readBufferReadCount[i2] & 15))))) != null; i3++) {
            this.readBuffers.lazySet(bufferIndex, null);
            applyRead(node);
            long[] jArr = this.readBufferReadCount;
            jArr[i2] = jArr[i2] + 1;
        }
        this.readBufferDrainAtWriteCount.lazySet(i2, j2);
    }

    void drainReadBuffers() {
        int id = (int) Thread.currentThread().getId();
        int i2 = NUMBER_OF_READ_BUFFERS + id;
        while (id < i2) {
            drainReadBuffer(READ_BUFFERS_MASK & id);
            id++;
        }
    }

    void drainWriteBuffer() {
        Runnable runnablePoll;
        for (int i2 = 0; i2 < 16 && (runnablePoll = this.writeBuffer.poll()) != null; i2++) {
            runnablePoll.run();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        e eVar = new e();
        this.entrySet = eVar;
        return eVar;
    }

    void evict() {
        Node<K, V> node;
        while (hasOverflowed() && (node = (Node) this.evictionDeque.poll()) != null) {
            this.data.remove(node.key, node);
            makeDead(node);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Node<K, V> node = this.data.get(obj);
        if (node == null) {
            return null;
        }
        afterRead(node);
        return node.getValue();
    }

    boolean hasOverflowed() {
        return this.weightedSize.get() > this.capacity.get();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        g gVar = new g();
        this.keySet = gVar;
        return gVar;
    }

    void makeDead(Node<K, V> node) {
        l lVar;
        do {
            lVar = (l) node.get();
        } while (!node.compareAndSet(lVar, new l(lVar.b, 0)));
        AtomicLong atomicLong = this.weightedSize;
        atomicLong.lazySet(atomicLong.get() - ((long) Math.abs(lVar.a)));
    }

    void makeRetired(Node<K, V> node) {
        l lVar;
        do {
            lVar = (l) node.get();
            if (!lVar.b()) {
                return;
            }
        } while (!node.compareAndSet(lVar, new l(lVar.b, -lVar.a)));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v) {
        return put(k2, v, false);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k2, V v) {
        return put(k2, v, true);
    }

    long recordRead(int i2, Node<K, V> node) {
        long j2 = this.readBufferWriteCount.get(i2);
        this.readBufferWriteCount.lazySet(i2, 1 + j2);
        this.readBuffers.lazySet(readBufferIndex(i2, (int) (15 & j2)), node);
        return j2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Node<K, V> nodeRemove = this.data.remove(obj);
        if (nodeRemove == null) {
            return null;
        }
        makeRetired(nodeRemove);
        afterWrite(new h(nodeRemove));
        return nodeRemove.getValue();
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k2, V v) {
        l lVar;
        checkNotNull(k2);
        checkNotNull(v);
        l lVar2 = new l(v, 1);
        Node<K, V> node = this.data.get(k2);
        if (node == null) {
            return null;
        }
        do {
            lVar = (l) node.get();
            if (!lVar.b()) {
                return null;
            }
        } while (!node.compareAndSet(lVar, lVar2));
        int i2 = 1 - lVar.a;
        if (i2 == 0) {
            afterRead(node);
        } else {
            afterWrite(new i(node, i2));
        }
        return (V) lVar.b;
    }

    public void setCapacity(long j2) {
        checkArgument(j2 >= 0);
        this.evictionLock.lock();
        try {
            this.capacity.lazySet(Math.min(j2, MAXIMUM_CAPACITY));
            drainBuffers();
            evict();
        } finally {
            this.evictionLock.unlock();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.data.size();
    }

    void tryToDrainBuffers() {
        if (this.evictionLock.tryLock()) {
            try {
                this.drainStatus.lazySet(DrainStatus.PROCESSING);
                drainBuffers();
                AtomicReference<DrainStatus> atomicReference = this.drainStatus;
            } finally {
                p62.a(this.drainStatus, DrainStatus.PROCESSING, DrainStatus.IDLE);
                this.evictionLock.unlock();
            }
        }
    }

    boolean tryToRetire(Node<K, V> node, l lVar) {
        if (lVar.b()) {
            return node.compareAndSet(lVar, new l(lVar.b, -lVar.a));
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        k kVar = new k();
        this.values = kVar;
        return kVar;
    }

    Object writeReplace() {
        return new SerializationProxy(this);
    }

    private PrivateMaxEntriesMap(c cVar) {
        int i2 = cVar.a;
        this.concurrencyLevel = i2;
        this.capacity = new AtomicLong(Math.min(cVar.c, MAXIMUM_CAPACITY));
        this.data = new ConcurrentHashMap(cVar.b, 0.75f, i2);
        this.evictionLock = new ReentrantLock();
        this.weightedSize = new AtomicLong();
        this.evictionDeque = new com.fasterxml.jackson.databind.util.internal.b();
        this.writeBuffer = new ConcurrentLinkedQueue();
        this.drainStatus = new AtomicReference<>(DrainStatus.IDLE);
        int i3 = NUMBER_OF_READ_BUFFERS;
        this.readBufferReadCount = new long[i3];
        this.readBufferWriteCount = new AtomicLongArray(i3);
        this.readBufferDrainAtWriteCount = new AtomicLongArray(i3);
        this.readBuffers = new AtomicReferenceArray<>(i3 * 16);
    }

    static int readBufferIndex() {
        return ((int) Thread.currentThread().getId()) & READ_BUFFERS_MASK;
    }

    V put(K k2, V v, boolean z) {
        checkNotNull(k2);
        checkNotNull(v);
        l lVar = new l(v, 1);
        Node<K, V> node = new Node<>(k2, lVar);
        while (true) {
            Node<K, V> nodePutIfAbsent = this.data.putIfAbsent(node.key, node);
            if (nodePutIfAbsent == null) {
                afterWrite(new b(node, 1));
                return null;
            }
            if (z) {
                afterRead(nodePutIfAbsent);
                return nodePutIfAbsent.getValue();
            }
            while (true) {
                l lVar2 = (l) nodePutIfAbsent.get();
                if (!lVar2.b()) {
                    break;
                }
                if (nodePutIfAbsent.compareAndSet(lVar2, lVar)) {
                    int i2 = 1 - lVar2.a;
                    if (i2 == 0) {
                        afterRead(nodePutIfAbsent);
                    } else {
                        afterWrite(new i(nodePutIfAbsent, i2));
                    }
                    return (V) lVar2.b;
                }
            }
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        Node<K, V> node = this.data.get(obj);
        if (node != null && obj2 != null) {
            l lVar = (l) node.get();
            while (lVar.a(obj2)) {
                if (tryToRetire(node, lVar)) {
                    if (!this.data.remove(obj, node)) {
                        break;
                    }
                    afterWrite(new h(node));
                    return true;
                }
                lVar = (l) node.get();
                if (!lVar.b()) {
                    break;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k2, V v, V v2) {
        l lVar;
        checkNotNull(k2);
        checkNotNull(v);
        checkNotNull(v2);
        l lVar2 = new l(v2, 1);
        Node<K, V> node = this.data.get(k2);
        if (node == null) {
            return false;
        }
        do {
            lVar = (l) node.get();
            if (!lVar.b() || !lVar.a(v)) {
                return false;
            }
        } while (!node.compareAndSet(lVar, lVar2));
        int i2 = 1 - lVar.a;
        if (i2 == 0) {
            afterRead(node);
        } else {
            afterWrite(new i(node, i2));
        }
        return true;
    }
}
