package defpackage;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public final class xe1 {
    private final ov0 a = new ov0();
    private final b b = new b();
    private final Map c = new HashMap();
    private final Map d = new HashMap();
    private final int e;
    private int f;

    private static final class a implements f42 {
        private final b a;
        int b;
        private Class c;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // defpackage.f42
        public void a() {
            this.a.d(this);
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

    private static final class b extends rg {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.rg
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        a f(int i, Class cls) {
            a aVar = (a) c();
            aVar.b(i, cls);
            return aVar;
        }
    }

    public xe1(int i) {
        this.e = i;
    }

    private void b(int i, Class cls) {
        NavigableMap navigableMapJ = j(cls);
        Integer num = (Integer) navigableMapJ.get(Integer.valueOf(i));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapJ.remove(Integer.valueOf(i));
                return;
            } else {
                navigableMapJ.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
    }

    private void c() {
        d(this.e);
    }

    private void d(int i) {
        while (this.f > i) {
            Object objF = this.a.f();
            b52.g(objF);
            n9 n9VarF = f(objF);
            this.f -= n9VarF.b(objF) * n9VarF.a();
            b(n9VarF.b(objF), objF.getClass());
            if (Log.isLoggable(n9VarF.getTag(), 2)) {
                Log.v(n9VarF.getTag(), "evicted: " + n9VarF.b(objF));
            }
        }
    }

    private n9 f(Object obj) {
        return g(obj.getClass());
    }

    private n9 g(Class cls) {
        n9 xoVar = (n9) this.d.get(cls);
        if (xoVar == null) {
            if (cls.equals(int[].class)) {
                xoVar = new f31();
            } else {
                if (!cls.equals(byte[].class)) {
                    throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
                }
                xoVar = new xo();
            }
            this.d.put(cls, xoVar);
        }
        return xoVar;
    }

    private Object h(a aVar) {
        return this.a.a(aVar);
    }

    private Object i(a aVar, Class cls) {
        n9 n9VarG = g(cls);
        Object objH = h(aVar);
        if (objH != null) {
            this.f -= n9VarG.b(objH) * n9VarG.a();
            b(n9VarG.b(objH), cls);
        }
        if (objH != null) {
            return objH;
        }
        if (Log.isLoggable(n9VarG.getTag(), 2)) {
            Log.v(n9VarG.getTag(), "Allocated " + aVar.b + " bytes");
        }
        return n9VarG.newArray(aVar.b);
    }

    private NavigableMap j(Class cls) {
        NavigableMap navigableMap = (NavigableMap) this.c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.c.put(cls, treeMap);
        return treeMap;
    }

    private boolean k() {
        int i = this.f;
        return i == 0 || this.e / i >= 2;
    }

    private boolean l(int i) {
        return i <= this.e / 2;
    }

    private boolean m(int i, Integer num) {
        return num != null && (k() || num.intValue() <= i * 8);
    }

    public synchronized void a() {
        d(0);
    }

    public synchronized Object e(int i, Class cls) {
        Integer num;
        try {
            num = (Integer) j(cls).ceilingKey(Integer.valueOf(i));
        } catch (Throwable th) {
            throw th;
        }
        return i(m(i, num) ? this.b.f(num.intValue(), cls) : this.b.f(i, cls), cls);
    }

    public synchronized void n(Object obj) {
        Class<?> cls = obj.getClass();
        n9 n9VarG = g(cls);
        int iB = n9VarG.b(obj);
        int iA = n9VarG.a() * iB;
        if (l(iA)) {
            a aVarF = this.b.f(iB, cls);
            this.a.d(aVarF, obj);
            NavigableMap navigableMapJ = j(cls);
            Integer num = (Integer) navigableMapJ.get(Integer.valueOf(aVarF.b));
            Integer numValueOf = Integer.valueOf(aVarF.b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapJ.put(numValueOf, Integer.valueOf(iIntValue));
            this.f += iA;
            c();
        }
    }
}
