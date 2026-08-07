package kotlin.collections.builders;

import com.tencent.connect.common.Constants;
import defpackage.ga2;
import defpackage.k81;
import defpackage.l81;
import defpackage.p31;
import defpackage.qb1;
import defpackage.y70;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, l81 {
    public static final a Companion = new a(null);
    private static final MapBuilder Empty;
    private static final int INITIAL_CAPACITY = 8;
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    private static final int MAGIC = -1640531527;
    private static final int TOMBSTONE = -1;
    private kotlin.collections.builders.a entriesView;
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;
    private K[] keysArray;
    private kotlin.collections.builders.b keysView;
    private int length;
    private int maxProbeDistance;
    private int modCount;
    private int[] presenceArray;
    private int size;
    private V[] valuesArray;
    private kotlin.collections.builders.c valuesView;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c(int i) {
            return Integer.highestOneBit(ga2.b(i, 1) * 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(int i) {
            return Integer.numberOfLeadingZeros(i) + 1;
        }

        public final MapBuilder e() {
            return MapBuilder.Empty;
        }

        private a() {
        }
    }

    public static final class b extends d implements Iterator, k81 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MapBuilder mapBuilder) {
            super(mapBuilder);
            p31.f(mapBuilder, "map");
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public c next() {
            a();
            if (b() >= d().length) {
                throw new NoSuchElementException();
            }
            int iB = b();
            f(iB + 1);
            g(iB);
            c cVar = new c(d(), c());
            e();
            return cVar;
        }

        public final void i(StringBuilder sb) {
            p31.f(sb, "sb");
            if (b() >= d().length) {
                throw new NoSuchElementException();
            }
            int iB = b();
            f(iB + 1);
            g(iB);
            Object obj = d().keysArray[c()];
            if (obj == d()) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = d().valuesArray;
            p31.c(objArr);
            Object obj2 = objArr[c()];
            if (obj2 == d()) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            e();
        }

        public final int j() {
            if (b() >= d().length) {
                throw new NoSuchElementException();
            }
            int iB = b();
            f(iB + 1);
            g(iB);
            Object obj = d().keysArray[c()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = d().valuesArray;
            p31.c(objArr);
            Object obj2 = objArr[c()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            e();
            return iHashCode2;
        }
    }

    public static final class c implements Map.Entry, k81 {
        private final MapBuilder a;
        private final int b;
        private final int c;

        public c(MapBuilder mapBuilder, int i) {
            p31.f(mapBuilder, "map");
            this.a = mapBuilder;
            this.b = i;
            this.c = mapBuilder.modCount;
        }

        private final void a() {
            if (this.a.modCount != this.c) {
                throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
            }
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (p31.a(entry.getKey(), getKey()) && p31.a(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            a();
            return this.a.keysArray[this.b];
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            a();
            Object[] objArr = this.a.valuesArray;
            p31.c(objArr);
            return objArr[this.b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            Object value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            a();
            this.a.checkIsMutable$kotlin_stdlib();
            Object[] objArrAllocateValuesArray = this.a.allocateValuesArray();
            int i = this.b;
            Object obj2 = objArrAllocateValuesArray[i];
            objArrAllocateValuesArray[i] = obj;
            return obj2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    public static class d {
        private final MapBuilder a;
        private int b;
        private int c;
        private int d;

        public d(MapBuilder mapBuilder) {
            p31.f(mapBuilder, "map");
            this.a = mapBuilder;
            this.c = -1;
            this.d = mapBuilder.modCount;
            e();
        }

        public final void a() {
            if (this.a.modCount != this.d) {
                throw new ConcurrentModificationException();
            }
        }

        public final int b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }

        public final MapBuilder d() {
            return this.a;
        }

        public final void e() {
            while (this.b < this.a.length) {
                int[] iArr = this.a.presenceArray;
                int i = this.b;
                if (iArr[i] >= 0) {
                    return;
                } else {
                    this.b = i + 1;
                }
            }
        }

        public final void f(int i) {
            this.b = i;
        }

        public final void g(int i) {
            this.c = i;
        }

        public final boolean hasNext() {
            return this.b < this.a.length;
        }

        public final void remove() {
            a();
            if (this.c == -1) {
                throw new IllegalStateException("Call next() before removing element from the iterator.");
            }
            this.a.checkIsMutable$kotlin_stdlib();
            this.a.removeEntryAt(this.c);
            this.c = -1;
            this.d = this.a.modCount;
        }
    }

    public static final class e extends d implements Iterator, k81 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(MapBuilder mapBuilder) {
            super(mapBuilder);
            p31.f(mapBuilder, "map");
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (b() >= d().length) {
                throw new NoSuchElementException();
            }
            int iB = b();
            f(iB + 1);
            g(iB);
            Object obj = d().keysArray[c()];
            e();
            return obj;
        }
    }

    public static final class f extends d implements Iterator, k81 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(MapBuilder mapBuilder) {
            super(mapBuilder);
            p31.f(mapBuilder, "map");
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (b() >= d().length) {
                throw new NoSuchElementException();
            }
            int iB = b();
            f(iB + 1);
            g(iB);
            Object[] objArr = d().valuesArray;
            p31.c(objArr);
            Object obj = objArr[c()];
            e();
            return obj;
        }
    }

    static {
        MapBuilder mapBuilder = new MapBuilder(0);
        mapBuilder.isReadOnly = true;
        Empty = mapBuilder;
    }

    private MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i, int i2) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i;
        this.length = i2;
        this.hashShift = Companion.d(getHashSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V[] allocateValuesArray() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) qb1.d(getCapacity$kotlin_stdlib());
        this.valuesArray = vArr2;
        return vArr2;
    }

    private final void compact(boolean z) {
        int i;
        V[] vArr = this.valuesArray;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.length;
            if (i2 >= i) {
                break;
            }
            int[] iArr = this.presenceArray;
            int i4 = iArr[i2];
            if (i4 >= 0) {
                K[] kArr = this.keysArray;
                kArr[i3] = kArr[i2];
                if (vArr != null) {
                    vArr[i3] = vArr[i2];
                }
                if (z) {
                    iArr[i3] = i4;
                    this.hashArray[i4] = i3 + 1;
                }
                i3++;
            }
            i2++;
        }
        qb1.g(this.keysArray, i3, i);
        if (vArr != null) {
            qb1.g(vArr, i3, this.length);
        }
        this.length = i3;
    }

    private final boolean contentEquals(Map<?, ?> map) {
        return size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet());
    }

    private final void ensureCapacity(int i) {
        if (i < 0) {
            throw new OutOfMemoryError();
        }
        if (i > getCapacity$kotlin_stdlib()) {
            int iE = kotlin.collections.a.Companion.e(getCapacity$kotlin_stdlib(), i);
            this.keysArray = (K[]) qb1.e(this.keysArray, iE);
            V[] vArr = this.valuesArray;
            this.valuesArray = vArr != null ? (V[]) qb1.e(vArr, iE) : null;
            int[] iArrCopyOf = Arrays.copyOf(this.presenceArray, iE);
            p31.e(iArrCopyOf, "copyOf(...)");
            this.presenceArray = iArrCopyOf;
            int iC = Companion.c(iE);
            if (iC > getHashSize()) {
                rehash(iC);
            }
        }
    }

    private final void ensureExtraCapacity(int i) {
        if (shouldCompact(i)) {
            compact(true);
        } else {
            ensureCapacity(this.length + i);
        }
    }

    private final int findKey(K k) {
        int iHash = hash(k);
        int i = this.maxProbeDistance;
        while (true) {
            int i2 = this.hashArray[iHash];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (p31.a(this.keysArray[i3], k)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            iHash = iHash == 0 ? getHashSize() - 1 : iHash - 1;
        }
    }

    private final int findValue(V v) {
        int i = this.length;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.presenceArray[i] >= 0) {
                V[] vArr = this.valuesArray;
                p31.c(vArr);
                if (p31.a(vArr[i], v)) {
                    return i;
                }
            }
        }
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final int hash(K k) {
        return ((k != null ? k.hashCode() : 0) * MAGIC) >>> this.hashShift;
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z = false;
        if (collection.isEmpty()) {
            return false;
        }
        ensureExtraCapacity(collection.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> it = collection.iterator();
        while (it.hasNext()) {
            if (putEntry(it.next())) {
                z = true;
            }
        }
        return z;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> entry) {
        int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
        V[] vArrAllocateValuesArray = allocateValuesArray();
        if (iAddKey$kotlin_stdlib >= 0) {
            vArrAllocateValuesArray[iAddKey$kotlin_stdlib] = entry.getValue();
            return true;
        }
        int i = (-iAddKey$kotlin_stdlib) - 1;
        if (p31.a(entry.getValue(), vArrAllocateValuesArray[i])) {
            return false;
        }
        vArrAllocateValuesArray[i] = entry.getValue();
        return true;
    }

    private final boolean putRehash(int i) {
        int iHash = hash(this.keysArray[i]);
        int i2 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[iHash] == 0) {
                iArr[iHash] = i + 1;
                this.presenceArray[i] = iHash;
                return true;
            }
            i2--;
            if (i2 < 0) {
                return false;
            }
            iHash = iHash == 0 ? getHashSize() - 1 : iHash - 1;
        }
    }

    private final void registerModification() {
        this.modCount++;
    }

    private final void rehash(int i) {
        registerModification();
        int i2 = 0;
        if (this.length > size()) {
            compact(false);
        }
        this.hashArray = new int[i];
        this.hashShift = Companion.d(i);
        while (i2 < this.length) {
            int i3 = i2 + 1;
            if (!putRehash(i2)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i2 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeEntryAt(int i) {
        qb1.f(this.keysArray, i);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            qb1.f(vArr, i);
        }
        removeHashAt(this.presenceArray[i]);
        this.presenceArray[i] = -1;
        this.size = size() - 1;
        registerModification();
    }

    private final void removeHashAt(int i) {
        int iD = ga2.d(this.maxProbeDistance * 2, getHashSize() / 2);
        int i2 = 0;
        int i3 = i;
        do {
            i = i == 0 ? getHashSize() - 1 : i - 1;
            i2++;
            if (i2 > this.maxProbeDistance) {
                this.hashArray[i3] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i4 = iArr[i];
            if (i4 == 0) {
                iArr[i3] = 0;
                return;
            }
            if (i4 < 0) {
                iArr[i3] = -1;
            } else {
                int i5 = i4 - 1;
                if (((hash(this.keysArray[i5]) - i) & (getHashSize() - 1)) >= i2) {
                    this.hashArray[i3] = i4;
                    this.presenceArray[i5] = i3;
                }
                iD--;
            }
            i3 = i;
            i2 = 0;
            iD--;
        } while (iD >= 0);
        this.hashArray[i3] = -1;
    }

    private final boolean shouldCompact(int i) {
        int capacity$kotlin_stdlib = getCapacity$kotlin_stdlib();
        int i2 = this.length;
        int i3 = capacity$kotlin_stdlib - i2;
        int size = i2 - size();
        return i3 < i && i3 + size >= i && size >= getCapacity$kotlin_stdlib() / 4;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.isReadOnly) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final int addKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int iHash = hash(k);
            int iD = ga2.d(this.maxProbeDistance * 2, getHashSize() / 2);
            int i = 0;
            while (true) {
                int i2 = this.hashArray[iHash];
                if (i2 <= 0) {
                    if (this.length >= getCapacity$kotlin_stdlib()) {
                        ensureExtraCapacity(1);
                        break;
                    }
                    int i3 = this.length;
                    int i4 = i3 + 1;
                    this.length = i4;
                    this.keysArray[i3] = k;
                    this.presenceArray[i3] = iHash;
                    this.hashArray[iHash] = i4;
                    this.size = size() + 1;
                    registerModification();
                    if (i > this.maxProbeDistance) {
                        this.maxProbeDistance = i;
                    }
                    return i3;
                }
                if (p31.a(this.keysArray[i2 - 1], k)) {
                    return -i2;
                }
                i++;
                if (i > iD) {
                    rehash(getHashSize() * 2);
                    break;
                }
                iHash = iHash == 0 ? getHashSize() - 1 : iHash - 1;
            }
        }
    }

    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        if (size() > 0) {
            return this;
        }
        MapBuilder mapBuilder = Empty;
        p31.d(mapBuilder, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return mapBuilder;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        int i = this.length - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.presenceArray;
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    this.hashArray[i3] = 0;
                    iArr[i2] = -1;
                }
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        qb1.g(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            qb1.g(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
        registerModification();
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> collection) {
        p31.f(collection, "m");
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        p31.f(entry, "entry");
        int iFindKey = findKey(entry.getKey());
        if (iFindKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        p31.c(vArr);
        return p31.a(vArr[iFindKey], entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return findKey(obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return findValue(obj) >= 0;
    }

    public final b entriesIterator$kotlin_stdlib() {
        return new b(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Map) && contentEquals((Map) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object obj) {
        int iFindKey = findKey(obj);
        if (iFindKey < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        p31.c(vArr);
        return vArr[iFindKey];
    }

    public final int getCapacity$kotlin_stdlib() {
        return this.keysArray.length;
    }

    public Set<Map.Entry<K, V>> getEntries() {
        kotlin.collections.builders.a aVar = this.entriesView;
        if (aVar != null) {
            return aVar;
        }
        kotlin.collections.builders.a aVar2 = new kotlin.collections.builders.a(this);
        this.entriesView = aVar2;
        return aVar2;
    }

    public Set<K> getKeys() {
        kotlin.collections.builders.b bVar = this.keysView;
        if (bVar != null) {
            return bVar;
        }
        kotlin.collections.builders.b bVar2 = new kotlin.collections.builders.b(this);
        this.keysView = bVar2;
        return bVar2;
    }

    public int getSize() {
        return this.size;
    }

    public Collection<V> getValues() {
        kotlin.collections.builders.c cVar = this.valuesView;
        if (cVar != null) {
            return cVar;
        }
        kotlin.collections.builders.c cVar2 = new kotlin.collections.builders.c(this);
        this.valuesView = cVar2;
        return cVar2;
    }

    @Override // java.util.Map
    public int hashCode() {
        b bVarEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int iJ = 0;
        while (bVarEntriesIterator$kotlin_stdlib.hasNext()) {
            iJ += bVarEntriesIterator$kotlin_stdlib.j();
        }
        return iJ;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    public final e keysIterator$kotlin_stdlib() {
        return new e(this);
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        checkIsMutable$kotlin_stdlib();
        int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(k);
        V[] vArrAllocateValuesArray = allocateValuesArray();
        if (iAddKey$kotlin_stdlib >= 0) {
            vArrAllocateValuesArray[iAddKey$kotlin_stdlib] = v;
            return null;
        }
        int i = (-iAddKey$kotlin_stdlib) - 1;
        V v2 = vArrAllocateValuesArray[i];
        vArrAllocateValuesArray[i] = v;
        return v2;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        p31.f(map, Constants.FROM);
        checkIsMutable$kotlin_stdlib();
        putAllEntries(map.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object obj) {
        checkIsMutable$kotlin_stdlib();
        int iFindKey = findKey(obj);
        if (iFindKey < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        p31.c(vArr);
        V v = vArr[iFindKey];
        removeEntryAt(iFindKey);
        return v;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        p31.f(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int iFindKey = findKey(entry.getKey());
        if (iFindKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        p31.c(vArr);
        if (!p31.a(vArr[iFindKey], entry.getValue())) {
            return false;
        }
        removeEntryAt(iFindKey);
        return true;
    }

    public final boolean removeKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        int iFindKey = findKey(k);
        if (iFindKey < 0) {
            return false;
        }
        removeEntryAt(iFindKey);
        return true;
    }

    public final boolean removeValue$kotlin_stdlib(V v) {
        checkIsMutable$kotlin_stdlib();
        int iFindValue = findValue(v);
        if (iFindValue < 0) {
            return false;
        }
        removeEntryAt(iFindValue);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        b bVarEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i = 0;
        while (bVarEntriesIterator$kotlin_stdlib.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            bVarEntriesIterator$kotlin_stdlib.i(sb);
            i++;
        }
        sb.append("}");
        String string = sb.toString();
        p31.e(string, "toString(...)");
        return string;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public final f valuesIterator$kotlin_stdlib() {
        return new f(this);
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i) {
        this(qb1.d(i), null, new int[i], new int[Companion.c(i)], 2, 0);
    }
}
