package defpackage;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class we1 implements v9 {
    private final nv0 a = new nv0();
    private final b b = new b();
    private final Map c = new HashMap();
    private final Map d = new HashMap();
    private final int e;
    private int f;

    private static final class a implements g42 {
        private final b a;
        int b;
        private Class c;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // defpackage.g42
        public void a() {
            this.a.c(this);
        }

        void b(int i, Class cls) {
            this.b = i;
            this.c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && this.c == aVar.c;
        }

        public int hashCode() {
            int i = this.b * 31;
            Class cls = this.c;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.b + "array=" + this.c + '}';
        }
    }

    private static final class b extends sg {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.sg
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        a e(int i, Class cls) {
            a aVar = (a) b();
            aVar.b(i, cls);
            return aVar;
        }
    }

    public we1(int i) {
        this.e = i;
    }

    private void e(int i, Class cls) {
        NavigableMap navigableMapL = l(cls);
        Integer num = (Integer) navigableMapL.get(Integer.valueOf(i));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapL.remove(Integer.valueOf(i));
                return;
            } else {
                navigableMapL.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
    }

    private void f() {
        g(this.e);
    }

    private void g(int i) {
        while (this.f > i) {
            Object objF = this.a.f();
            z42.d(objF);
            o9 o9VarH = h(objF);
            this.f -= o9VarH.b(objF) * o9VarH.a();
            e(o9VarH.b(objF), objF.getClass());
            if (Log.isLoggable(o9VarH.getTag(), 2)) {
                Log.v(o9VarH.getTag(), "evicted: " + o9VarH.b(objF));
            }
        }
    }

    private o9 h(Object obj) {
        return i(obj.getClass());
    }

    private o9 i(Class cls) {
        o9 yoVar = (o9) this.d.get(cls);
        if (yoVar == null) {
            if (cls.equals(int[].class)) {
                yoVar = new g31();
            } else {
                if (!cls.equals(byte[].class)) {
                    throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
                }
                yoVar = new yo();
            }
            this.d.put(cls, yoVar);
        }
        return yoVar;
    }

    private Object j(a aVar) {
        return this.a.a(aVar);
    }

    private Object k(a aVar, Class cls) {
        o9 o9VarI = i(cls);
        Object objJ = j(aVar);
        if (objJ != null) {
            this.f -= o9VarI.b(objJ) * o9VarI.a();
            e(o9VarI.b(objJ), cls);
        }
        if (objJ != null) {
            return objJ;
        }
        if (Log.isLoggable(o9VarI.getTag(), 2)) {
            Log.v(o9VarI.getTag(), "Allocated " + aVar.b + " bytes");
        }
        return o9VarI.newArray(aVar.b);
    }

    private NavigableMap l(Class cls) {
        NavigableMap navigableMap = (NavigableMap) this.c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.c.put(cls, treeMap);
        return treeMap;
    }

    private boolean m() {
        int i = this.f;
        return i == 0 || this.e / i >= 2;
    }

    private boolean n(int i) {
        return i <= this.e / 2;
    }

    private boolean o(int i, Integer num) {
        return num != null && (m() || num.intValue() <= i * 8);
    }

    @Override // defpackage.v9
    public synchronized void a(int i) {
        try {
            if (i >= 40) {
                b();
            } else if (i >= 20 || i == 15) {
                g(this.e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.v9
    public synchronized void b() {
        g(0);
    }

    @Override // defpackage.v9
    public synchronized Object c(int i, Class cls) {
        return k(this.b.e(i, cls), cls);
    }

    @Override // defpackage.v9
    public synchronized Object d(int i, Class cls) {
        Integer num;
        try {
            num = (Integer) l(cls).ceilingKey(Integer.valueOf(i));
        } catch (Throwable th) {
            throw th;
        }
        return k(o(i, num) ? this.b.e(num.intValue(), cls) : this.b.e(i, cls), cls);
    }

    @Override // defpackage.v9
    public synchronized void put(Object obj) {
        Class<?> cls = obj.getClass();
        o9 o9VarI = i(cls);
        int iB = o9VarI.b(obj);
        int iA = o9VarI.a() * iB;
        if (n(iA)) {
            a aVarE = this.b.e(iB, cls);
            this.a.d(aVarE, obj);
            NavigableMap navigableMapL = l(cls);
            Integer num = (Integer) navigableMapL.get(Integer.valueOf(aVarE.b));
            Integer numValueOf = Integer.valueOf(aVarE.b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapL.put(numValueOf, Integer.valueOf(iIntValue));
            this.f += iA;
            f();
        }
    }
}
