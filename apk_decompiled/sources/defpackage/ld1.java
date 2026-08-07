package defpackage;

import java.io.IOException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ld1 {
    static volatile int a;
    static volatile ej2 e;
    static final hw2 b = new hw2();
    static final hn1 c = new hn1();
    static boolean d = qa3.f("slf4j.detectLoggerNameMismatch");
    private static final String[] f = {"2.0"};

    private static final void b() {
        try {
            List listH = h();
            x(listH);
            if (listH == null || listH.isEmpty()) {
                a = 4;
                qa3.c("No SLF4J providers were found.");
                qa3.c("Defaulting to no-operation (NOP) logger implementation");
                qa3.c("See https://www.slf4j.org/codes.html#noProviders for further details.");
                w(g());
            } else {
                e = (ej2) listH.get(0);
                e.b();
                a = 3;
                v(listH);
            }
            s();
        } catch (Exception e2) {
            f(e2);
            throw new IllegalStateException("Unexpected initialization failure", e2);
        }
    }

    private static void c(gw2 gw2Var, int i) {
        if (gw2Var.g().c()) {
            d(i);
        } else {
            if (gw2Var.g().d()) {
                return;
            }
            e();
        }
    }

    private static void d(int i) {
        qa3.c("A number (" + i + ") of logging calls during the initialization phase have been intercepted and are");
        qa3.c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        qa3.c("See also https://www.slf4j.org/codes.html#replay");
    }

    private static void e() {
        qa3.c("The following set of substitute loggers may have been accessed");
        qa3.c("during the initialization phase. Logging calls during this");
        qa3.c("phase were not honored. However, subsequent logging calls to these");
        qa3.c("loggers will work as normally expected.");
        qa3.c("See also https://www.slf4j.org/codes.html#substituteLogger");
    }

    static void f(Throwable th) {
        a = 2;
        qa3.d("Failed to instantiate SLF4J LoggerFactory", th);
    }

    static Set g() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = ld1.class.getClassLoader();
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources("org/slf4j/impl/StaticLoggerBinder.class") : classLoader.getResources("org/slf4j/impl/StaticLoggerBinder.class");
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
        } catch (IOException e2) {
            qa3.d("Error getting resources from path", e2);
        }
        return linkedHashSet;
    }

    static List h() {
        ServiceLoader serviceLoaderN = n(ld1.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        Iterator it = serviceLoaderN.iterator();
        while (it.hasNext()) {
            y(arrayList, it);
        }
        return arrayList;
    }

    private static void i() {
        hw2 hw2Var = b;
        synchronized (hw2Var) {
            try {
                hw2Var.d().e();
                for (ew2 ew2Var : hw2Var.d().d()) {
                    ew2Var.g(l(ew2Var.getName()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static iy0 j() {
        return m().a();
    }

    public static hd1 k(Class cls) {
        Class clsA;
        hd1 hd1VarL = l(cls.getName());
        if (d && (clsA = qa3.a()) != null && q(cls, clsA)) {
            qa3.c(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", hd1VarL.getName(), clsA.getName()));
            qa3.c("See https://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return hd1VarL;
    }

    public static hd1 l(String str) {
        return j().a(str);
    }

    static ej2 m() {
        if (a == 0) {
            synchronized (ld1.class) {
                try {
                    if (a == 0) {
                        a = 1;
                        r();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        int i = a;
        if (i == 1) {
            return b;
        }
        if (i == 2) {
            throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also https://www.slf4j.org/codes.html#unsuccessfulInit");
        }
        if (i == 3) {
            return e;
        }
        if (i == 4) {
            return c;
        }
        throw new IllegalStateException("Unreachable code");
    }

    private static ServiceLoader n(final ClassLoader classLoader) {
        return System.getSecurityManager() == null ? ServiceLoader.load(ej2.class, classLoader) : (ServiceLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: kd1
            @Override // java.security.PrivilegedAction
            public final Object run() {
                return ld1.p(classLoader);
            }
        });
    }

    private static boolean o(List list) {
        return list.size() > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ServiceLoader p(ClassLoader classLoader) {
        return ServiceLoader.load(ej2.class, classLoader);
    }

    private static boolean q(Class cls, Class cls2) {
        return !cls2.isAssignableFrom(cls);
    }

    private static final void r() {
        b();
        if (a == 3) {
            z();
        }
    }

    private static void s() {
        i();
        t();
        b.d().b();
    }

    private static void t() {
        LinkedBlockingQueue linkedBlockingQueueC = b.d().c();
        int size = linkedBlockingQueueC.size();
        ArrayList<gw2> arrayList = new ArrayList(128);
        int i = 0;
        while (linkedBlockingQueueC.drainTo(arrayList, 128) != 0) {
            for (gw2 gw2Var : arrayList) {
                u(gw2Var);
                int i2 = i + 1;
                if (i == 0) {
                    c(gw2Var, size);
                }
                i = i2;
            }
            arrayList.clear();
        }
    }

    private static void u(gw2 gw2Var) {
        if (gw2Var == null) {
            return;
        }
        ew2 ew2VarG = gw2Var.g();
        String name = ew2VarG.getName();
        if (ew2VarG.e()) {
            throw new IllegalStateException("Delegate logger cannot be null at this state.");
        }
        if (ew2VarG.d()) {
            return;
        }
        if (!ew2VarG.c()) {
            qa3.c(name);
        } else if (ew2VarG.isEnabledForLevel(gw2Var.c())) {
            ew2VarG.f(gw2Var);
        }
    }

    private static void v(List list) {
        if (list.isEmpty() || !o(list)) {
            return;
        }
        qa3.c("Actual provider is of type [" + list.get(0) + "]");
    }

    private static void w(Set set) {
        if (set.isEmpty()) {
            return;
        }
        qa3.c("Class path contains SLF4J bindings targeting slf4j-api versions 1.7.x or earlier.");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            qa3.c("Ignoring binding found at [" + ((URL) it.next()) + "]");
        }
        qa3.c("See https://www.slf4j.org/codes.html#ignoredBindings for an explanation.");
    }

    private static void x(List list) {
        if (o(list)) {
            qa3.c("Class path contains multiple SLF4J providers.");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                qa3.c("Found provider [" + ((ej2) it.next()) + "]");
            }
            qa3.c("See https://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    private static void y(List list, Iterator it) {
        try {
            list.add((ej2) it.next());
        } catch (ServiceConfigurationError e2) {
            qa3.c("A SLF4J service provider failed to instantiate:\n" + e2.getMessage());
        }
    }

    private static final void z() {
        try {
            String strC = e.c();
            boolean z = false;
            for (String str : f) {
                if (strC.startsWith(str)) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            qa3.c("The requested version " + strC + " by your slf4j binding is not compatible with " + Arrays.asList(f).toString());
            qa3.c("See https://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            qa3.d("Unexpected problem occured during version sanity check", th);
        }
    }
}
