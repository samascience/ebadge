package defpackage;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.util.LRUMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class ym2 {
    private final LRUMap a;
    private final AtomicReference b;

    public ym2() {
        this(4000);
    }

    private final synchronized bd2 a() {
        bd2 bd2VarC;
        bd2VarC = (bd2) this.b.get();
        if (bd2VarC == null) {
            bd2VarC = bd2.c(this.a);
            this.b.set(bd2VarC);
        }
        return bd2VarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(JavaType javaType, f71 f71Var, an2 an2Var) {
        synchronized (this) {
            try {
                if (this.a.put(new q63(javaType, false), f71Var) == null) {
                    this.b.set(null);
                }
                if (f71Var instanceof cg2) {
                    ((cg2) f71Var).resolve(an2Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(Class cls, JavaType javaType, f71 f71Var, an2 an2Var) {
        synchronized (this) {
            try {
                Object objPut = this.a.put(new q63(cls, false), f71Var);
                Object objPut2 = this.a.put(new q63(javaType, false), f71Var);
                if (objPut == null || objPut2 == null) {
                    this.b.set(null);
                }
                if (f71Var instanceof cg2) {
                    ((cg2) f71Var).resolve(an2Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(JavaType javaType, f71 f71Var) {
        synchronized (this) {
            try {
                if (this.a.put(new q63(javaType, true), f71Var) == null) {
                    this.b.set(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(Class cls, f71 f71Var) {
        synchronized (this) {
            try {
                if (this.a.put(new q63(cls, true), f71Var) == null) {
                    this.b.set(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void f() {
        this.a.clear();
    }

    public bd2 g() {
        bd2 bd2Var = (bd2) this.b.get();
        return bd2Var != null ? bd2Var : a();
    }

    public synchronized int h() {
        return this.a.size();
    }

    public f71 i(JavaType javaType) {
        f71 f71Var;
        synchronized (this) {
            f71Var = (f71) this.a.get(new q63(javaType, true));
        }
        return f71Var;
    }

    public f71 j(Class cls) {
        f71 f71Var;
        synchronized (this) {
            f71Var = (f71) this.a.get(new q63(cls, true));
        }
        return f71Var;
    }

    public f71 k(JavaType javaType) {
        f71 f71Var;
        synchronized (this) {
            f71Var = (f71) this.a.get(new q63(javaType, false));
        }
        return f71Var;
    }

    public f71 l(Class cls) {
        f71 f71Var;
        synchronized (this) {
            f71Var = (f71) this.a.get(new q63(cls, false));
        }
        return f71Var;
    }

    public ym2(int i) {
        this.a = new LRUMap(Math.min(64, i >> 2), i);
        this.b = new AtomicReference();
    }
}
