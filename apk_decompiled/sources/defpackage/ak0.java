package defpackage;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ak0 {
    private static final g a = new a();

    class a implements g {
        a() {
        }

        @Override // ak0.g
        public void a(Object obj) {
        }
    }

    class b implements d {
        b() {
        }

        @Override // ak0.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List create() {
            return new ArrayList();
        }
    }

    class c implements g {
        c() {
        }

        @Override // ak0.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(List list) {
            list.clear();
        }
    }

    public interface d {
        Object create();
    }

    private static final class e implements h42 {
        private final d a;
        private final g b;
        private final h42 c;

        e(h42 h42Var, d dVar, g gVar) {
            this.c = h42Var;
            this.a = dVar;
            this.b = gVar;
        }

        @Override // defpackage.h42
        public boolean a(Object obj) {
            if (obj instanceof f) {
                ((f) obj).e().b(true);
            }
            this.b.a(obj);
            return this.c.a(obj);
        }

        @Override // defpackage.h42
        public Object b() {
            Object objB = this.c.b();
            if (objB == null) {
                objB = this.a.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + objB.getClass());
                }
            }
            if (objB instanceof f) {
                ((f) objB).e().b(false);
            }
            return objB;
        }
    }

    public interface f {
        tt2 e();
    }

    public interface g {
        void a(Object obj);
    }

    private static h42 a(h42 h42Var, d dVar) {
        return b(h42Var, dVar, c());
    }

    private static h42 b(h42 h42Var, d dVar, g gVar) {
        return new e(h42Var, dVar, gVar);
    }

    private static g c() {
        return a;
    }

    public static h42 d(int i, d dVar) {
        return a(new j42(i), dVar);
    }

    public static h42 e() {
        return f(20);
    }

    public static h42 f(int i) {
        return b(new j42(i), new b(), new c());
    }
}
