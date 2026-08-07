package defpackage;

import java.util.Map;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes.dex */
public class af1 {
    private int a;
    private final bf1 b;
    private final xc1 c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    public af1(int i) {
        this.a = i;
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.b = new bf1(0, 0.75f);
        this.c = new xc1();
    }

    private final int e(Object obj, Object obj2) {
        int iF = f(obj, obj2);
        if (iF >= 0) {
            return iF;
        }
        throw new IllegalStateException(("Negative size: " + obj + '=' + obj2).toString());
    }

    protected Object a(Object obj) {
        p31.f(obj, "key");
        return null;
    }

    protected void b(boolean z, Object obj, Object obj2, Object obj3) {
        p31.f(obj, "key");
        p31.f(obj2, "oldValue");
    }

    public final Object c(Object obj) {
        Object objD;
        p31.f(obj, "key");
        synchronized (this.c) {
            Object objA = this.b.a(obj);
            if (objA != null) {
                this.h++;
                return objA;
            }
            this.i++;
            Object objA2 = a(obj);
            if (objA2 == null) {
                return null;
            }
            synchronized (this.c) {
                try {
                    this.f++;
                    objD = this.b.d(obj, objA2);
                    if (objD != null) {
                        this.b.d(obj, objD);
                    } else {
                        this.d += e(obj, objA2);
                        k83 k83Var = k83.a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (objD != null) {
                b(false, obj, objA2, objD);
                return objD;
            }
            g(this.a);
            return objA2;
        }
    }

    public final Object d(Object obj, Object obj2) {
        Object objD;
        p31.f(obj, "key");
        p31.f(obj2, "value");
        synchronized (this.c) {
            try {
                this.e++;
                this.d += e(obj, obj2);
                objD = this.b.d(obj, obj2);
                if (objD != null) {
                    this.d -= e(obj, objD);
                }
                k83 k83Var = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objD != null) {
            b(false, obj, objD, obj2);
        }
        g(this.a);
        return objD;
    }

    protected int f(Object obj, Object obj2) {
        p31.f(obj, "key");
        p31.f(obj2, "value");
        return 1;
    }

    public void g(int i) {
        Object key;
        Object value;
        while (true) {
            synchronized (this.c) {
                try {
                    if (this.d < 0 || (this.b.c() && this.d != 0)) {
                        break;
                    }
                    if (this.d > i && !this.b.c()) {
                        Map.Entry entry = (Map.Entry) j.H(this.b.b());
                        if (entry == null) {
                            return;
                        }
                        key = entry.getKey();
                        value = entry.getValue();
                        this.b.e(key);
                        this.d -= e(key, value);
                        this.g++;
                    }
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
            b(true, key, value, null);
        }
        throw new IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
    }

    public String toString() {
        String str;
        synchronized (this.c) {
            try {
                int i = this.h;
                int i2 = this.i + i;
                str = "LruCache[maxSize=" + this.a + ",hits=" + this.h + ",misses=" + this.i + ",hitRate=" + (i2 != 0 ? (i * 100) / i2 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
