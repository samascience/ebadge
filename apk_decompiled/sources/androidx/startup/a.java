package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import defpackage.g21;
import defpackage.l43;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static volatile a d;
    private static final Object e = new Object();
    final Context c;
    final Set b = new HashSet();
    final Map a = new HashMap();

    a(Context context) {
        this.c = context.getApplicationContext();
    }

    private Object d(Class cls, Set set) {
        Object objB;
        if (l43.d()) {
            try {
                l43.a(cls.getSimpleName());
            } catch (Throwable th) {
                l43.b();
                throw th;
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.a.containsKey(cls)) {
            objB = this.a.get(cls);
        } else {
            set.add(cls);
            try {
                g21 g21Var = (g21) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listA = g21Var.a();
                if (!listA.isEmpty()) {
                    for (Class cls2 : listA) {
                        if (!this.a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                objB = g21Var.b(this.c);
                set.remove(cls);
                this.a.put(cls, objB);
            } catch (Throwable th2) {
                throw new StartupException(th2);
            }
        }
        l43.b();
        return objB;
    }

    public static a e(Context context) {
        if (d == null) {
            synchronized (e) {
                try {
                    if (d == null) {
                        d = new a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    void a() {
        try {
            try {
                l43.a("Startup");
                b(this.c.getPackageManager().getProviderInfo(new ComponentName(this.c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
                l43.b();
            } catch (PackageManager.NameNotFoundException e2) {
                throw new StartupException(e2);
            }
        } catch (Throwable th) {
            l43.b();
            throw th;
        }
    }

    void b(Bundle bundle) {
        String string = this.c.getString(R$string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (g21.class.isAssignableFrom(cls)) {
                            this.b.add(cls);
                        }
                    }
                }
                Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    d((Class) it.next(), hashSet);
                }
            } catch (ClassNotFoundException e2) {
                throw new StartupException(e2);
            }
        }
    }

    Object c(Class cls) {
        Object objD;
        synchronized (e) {
            try {
                objD = this.a.get(cls);
                if (objD == null) {
                    objD = d(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objD;
    }

    public Object f(Class cls) {
        return c(cls);
    }

    public boolean g(Class cls) {
        return this.b.contains(cls);
    }
}
