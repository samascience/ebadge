package defpackage;

import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class tk1 {
    private final zl1 a;
    private final a b;

    private static class a {
        private final Map a = new HashMap();

        /* JADX INFO: renamed from: tk1$a$a, reason: collision with other inner class name */
        private static class C0171a {
            final List a;

            public C0171a(List list) {
                this.a = list;
            }
        }

        a() {
        }

        public void a() {
            this.a.clear();
        }

        public List b(Class cls) {
            C0171a c0171a = (C0171a) this.a.get(cls);
            if (c0171a == null) {
                return null;
            }
            return c0171a.a;
        }

        public void c(Class cls, List list) {
            if (((C0171a) this.a.put(cls, new C0171a(list))) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public tk1(h42 h42Var) {
        this(new zl1(h42Var));
    }

    private static Class b(Object obj) {
        return obj.getClass();
    }

    private synchronized List e(Class cls) {
        List listB;
        listB = this.b.b(cls);
        if (listB == null) {
            listB = Collections.unmodifiableList(this.a.e(cls));
            this.b.c(cls, listB);
        }
        return listB;
    }

    public synchronized void a(Class cls, Class cls2, sk1 sk1Var) {
        this.a.b(cls, cls2, sk1Var);
        this.b.a();
    }

    public synchronized List c(Class cls) {
        return this.a.g(cls);
    }

    public List d(Object obj) {
        List listE = e(b(obj));
        if (listE.isEmpty()) {
            throw new Registry.NoModelLoaderAvailableException(obj);
        }
        int size = listE.size();
        List listEmptyList = Collections.emptyList();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            rk1 rk1Var = (rk1) listE.get(i);
            if (rk1Var.a(obj)) {
                if (z) {
                    listEmptyList = new ArrayList(size - i);
                    z = false;
                }
                listEmptyList.add(rk1Var);
            }
        }
        if (listEmptyList.isEmpty()) {
            throw new Registry.NoModelLoaderAvailableException(obj, (List<rk1>) listE);
        }
        return listEmptyList;
    }

    private tk1(zl1 zl1Var) {
        this.b = new a();
        this.a = zl1Var;
    }
}
