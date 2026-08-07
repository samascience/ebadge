package androidx.lifecycle;

import android.app.Application;
import defpackage.c6;
import defpackage.hm1;
import defpackage.me3;
import defpackage.ne3;
import defpackage.p31;
import defpackage.v40;
import defpackage.y70;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class q {
    private final r a;
    private final b b;
    private final v40 c;

    public interface b {
        public static final a a = a.a;

        public static final class a {
            static final /* synthetic */ a a = new a();

            private a() {
            }
        }

        default o a(Class cls) {
            p31.f(cls, "modelClass");
            throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
        }

        default o b(Class cls, v40 v40Var) {
            p31.f(cls, "modelClass");
            p31.f(v40Var, "extras");
            return a(cls);
        }
    }

    public static class c implements b {
        private static c c;
        public static final a b = new a(null);
        public static final v40.b d = a.C0025a.a;

        public static final class a {

            /* JADX INFO: renamed from: androidx.lifecycle.q$c$a$a, reason: collision with other inner class name */
            private static final class C0025a implements v40.b {
                public static final C0025a a = new C0025a();

                private C0025a() {
                }
            }

            public /* synthetic */ a(y70 y70Var) {
                this();
            }

            public final c a() {
                if (c.c == null) {
                    c.c = new c();
                }
                c cVar = c.c;
                p31.c(cVar);
                return cVar;
            }

            private a() {
            }
        }

        @Override // androidx.lifecycle.q.b
        public o a(Class cls) throws InvocationTargetException {
            p31.f(cls, "modelClass");
            try {
                Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
                p31.e(objNewInstance, "{\n                modelC…wInstance()\n            }");
                return (o) objNewInstance;
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            }
        }
    }

    public static class d {
        public abstract void c(o oVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(r rVar, b bVar) {
        this(rVar, bVar, null, 4, null);
        p31.f(rVar, "store");
        p31.f(bVar, "factory");
    }

    public o a(Class cls) {
        p31.f(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    public o b(String str, Class cls) {
        o oVarA;
        p31.f(str, "key");
        p31.f(cls, "modelClass");
        o oVarB = this.a.b(str);
        if (!cls.isInstance(oVarB)) {
            hm1 hm1Var = new hm1(this.c);
            hm1Var.c(c.d, str);
            try {
                oVarA = this.b.b(cls, hm1Var);
            } catch (AbstractMethodError unused) {
                oVarA = this.b.a(cls);
            }
            this.a.d(str, oVarA);
            return oVarA;
        }
        Object obj = this.b;
        d dVar = obj instanceof d ? (d) obj : null;
        if (dVar != null) {
            p31.c(oVarB);
            dVar.c(oVarB);
        }
        p31.d(oVarB, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return oVarB;
    }

    public static class a extends c {
        private static a g;
        private final Application e;
        public static final C0023a f = new C0023a(null);
        public static final v40.b h = C0023a.C0024a.a;

        /* JADX INFO: renamed from: androidx.lifecycle.q$a$a, reason: collision with other inner class name */
        public static final class C0023a {

            /* JADX INFO: renamed from: androidx.lifecycle.q$a$a$a, reason: collision with other inner class name */
            private static final class C0024a implements v40.b {
                public static final C0024a a = new C0024a();

                private C0024a() {
                }
            }

            public /* synthetic */ C0023a(y70 y70Var) {
                this();
            }

            public final b a(ne3 ne3Var) {
                p31.f(ne3Var, "owner");
                return ne3Var instanceof androidx.lifecycle.c ? ((androidx.lifecycle.c) ne3Var).getDefaultViewModelProviderFactory() : c.b.a();
            }

            public final a b(Application application) {
                p31.f(application, "application");
                if (a.g == null) {
                    a.g = new a(application);
                }
                a aVar = a.g;
                p31.c(aVar);
                return aVar;
            }

            private C0023a() {
            }
        }

        private a(Application application, int i) {
            this.e = application;
        }

        private final o g(Class cls, Application application) {
            if (!c6.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            try {
                o oVar = (o) cls.getConstructor(Application.class).newInstance(application);
                p31.e(oVar, "{\n                try {\n…          }\n            }");
                return oVar;
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            }
        }

        @Override // androidx.lifecycle.q.c, androidx.lifecycle.q.b
        public o a(Class cls) {
            p31.f(cls, "modelClass");
            Application application = this.e;
            if (application != null) {
                return g(cls, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.q.b
        public o b(Class cls, v40 v40Var) {
            p31.f(cls, "modelClass");
            p31.f(v40Var, "extras");
            if (this.e != null) {
                return a(cls);
            }
            Application application = (Application) v40Var.a(h);
            if (application != null) {
                return g(cls, application);
            }
            if (c6.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return super.a(cls);
        }

        public a() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            this(application, 0);
            p31.f(application, "application");
        }
    }

    public q(r rVar, b bVar, v40 v40Var) {
        p31.f(rVar, "store");
        p31.f(bVar, "factory");
        p31.f(v40Var, "defaultCreationExtras");
        this.a = rVar;
        this.b = bVar;
        this.c = v40Var;
    }

    public /* synthetic */ q(r rVar, b bVar, v40 v40Var, int i, y70 y70Var) {
        this(rVar, bVar, (i & 4) != 0 ? v40.a.b : v40Var);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(ne3 ne3Var) {
        this(ne3Var.getViewModelStore(), a.f.a(ne3Var), me3.a(ne3Var));
        p31.f(ne3Var, "owner");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(ne3 ne3Var, b bVar) {
        this(ne3Var.getViewModelStore(), bVar, me3.a(ne3Var));
        p31.f(ne3Var, "owner");
        p31.f(bVar, "factory");
    }
}
