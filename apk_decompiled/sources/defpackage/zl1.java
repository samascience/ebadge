package defpackage;

import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class zl1 {
    private static final c e = new c();
    private static final rk1 f = new a();
    private final List a;
    private final c b;
    private final Set c;
    private final h42 d;

    private static class a implements rk1 {
        a() {
        }

        @Override // defpackage.rk1
        public boolean a(Object obj) {
            return false;
        }

        @Override // defpackage.rk1
        public rk1.a b(Object obj, int i, int i2, rx1 rx1Var) {
            return null;
        }
    }

    private static class b {
        private final Class a;
        final Class b;
        final sk1 c;

        public b(Class cls, Class cls2, sk1 sk1Var) {
            this.a = cls;
            this.b = cls2;
            this.c = sk1Var;
        }

        public boolean a(Class cls) {
            return this.a.isAssignableFrom(cls);
        }

        public boolean b(Class cls, Class cls2) {
            return a(cls) && this.b.isAssignableFrom(cls2);
        }
    }

    static class c {
        c() {
        }

        public yl1 a(List list, h42 h42Var) {
            return new yl1(list, h42Var);
        }
    }

    public zl1(h42 h42Var) {
        this(h42Var, e);
    }

    private void a(Class cls, Class cls2, sk1 sk1Var, boolean z) {
        b bVar = new b(cls, cls2, sk1Var);
        List list = this.a;
        list.add(z ? list.size() : 0, bVar);
    }

    private rk1 c(b bVar) {
        return (rk1) z42.d(bVar.c.b(this));
    }

    private static rk1 f() {
        return f;
    }

    synchronized void b(Class cls, Class cls2, sk1 sk1Var) {
        a(cls, cls2, sk1Var, true);
    }

    public synchronized rk1 d(Class cls, Class cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b bVar : this.a) {
                if (this.c.contains(bVar)) {
                    z = true;
                } else if (bVar.b(cls, cls2)) {
                    this.c.add(bVar);
                    arrayList.add(c(bVar));
                    this.c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.b.a(arrayList, this.d);
            }
            if (arrayList.size() == 1) {
                return (rk1) arrayList.get(0);
            }
            if (!z) {
                throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
            }
            return f();
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
    }

    synchronized List e(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b bVar : this.a) {
                if (!this.c.contains(bVar) && bVar.a(cls)) {
                    this.c.add(bVar);
                    arrayList.add(c(bVar));
                    this.c.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
        return arrayList;
    }

    synchronized List g(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b bVar : this.a) {
            if (!arrayList.contains(bVar.b) && bVar.a(cls)) {
                arrayList.add(bVar.b);
            }
        }
        return arrayList;
    }

    zl1(h42 h42Var, c cVar) {
        this.a = new ArrayList();
        this.c = new HashSet();
        this.d = h42Var;
        this.b = cVar;
    }
}
