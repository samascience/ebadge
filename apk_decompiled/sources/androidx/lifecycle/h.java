package androidx.lifecycle;

import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.FileUtils;
import defpackage.cb1;
import defpackage.d80;
import defpackage.e43;
import defpackage.p31;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    public static final h a = new h();
    private static final Map b = new HashMap();
    private static final Map c = new HashMap();

    private h() {
    }

    private final b a(Constructor constructor, Object obj) {
        try {
            Object objNewInstance = constructor.newInstance(obj);
            p31.e(objNewInstance, "{\n            constructo…tance(`object`)\n        }");
            e43.a(objNewInstance);
            return null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    private final Constructor b(Class cls) {
        try {
            Package r0 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r0 != null ? r0.getName() : Constants.STR_EMPTY;
            p31.e(name, "fullPackage");
            if (name.length() != 0) {
                p31.e(canonicalName, "name");
                canonicalName = canonicalName.substring(name.length() + 1);
                p31.e(canonicalName, "this as java.lang.String).substring(startIndex)");
            }
            p31.e(canonicalName, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
            String strC = c(canonicalName);
            if (name.length() != 0) {
                strC = name + '.' + strC;
            }
            Class<?> cls2 = Class.forName(strC);
            p31.d(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(cls);
            if (declaredConstructor.isAccessible()) {
                return declaredConstructor;
            }
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String c(String str) {
        p31.f(str, "className");
        return kotlin.text.i.C(str, FileUtils.FILE_EXTENSION_SEPARATOR, "_", false, 4, null) + "_LifecycleAdapter";
    }

    private final int d(Class cls) {
        Map map = b;
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iG = g(cls);
        map.put(cls, Integer.valueOf(iG));
        return iG;
    }

    private final boolean e(Class cls) {
        return cls != null && cb1.class.isAssignableFrom(cls);
    }

    public static final f f(Object obj) {
        p31.f(obj, "object");
        boolean z = obj instanceof f;
        boolean z2 = obj instanceof d80;
        if (z && z2) {
            return new DefaultLifecycleObserverAdapter((d80) obj, (f) obj);
        }
        if (z2) {
            return new DefaultLifecycleObserverAdapter((d80) obj, null);
        }
        if (z) {
            return (f) obj;
        }
        Class<?> cls = obj.getClass();
        h hVar = a;
        if (hVar.d(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        Object obj2 = c.get(cls);
        p31.c(obj2);
        List list = (List) obj2;
        if (list.size() == 1) {
            hVar.a((Constructor) list.get(0), obj);
            return new SingleGeneratedAdapterObserver(null);
        }
        int size = list.size();
        b[] bVarArr = new b[size];
        for (int i = 0; i < size; i++) {
            a.a((Constructor) list.get(i), obj);
            bVarArr[i] = null;
        }
        return new CompositeGeneratedAdaptersObserver(bVarArr);
    }

    private final int g(Class cls) {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor constructorB = b(cls);
        if (constructorB != null) {
            c.put(cls, kotlin.collections.j.e(constructorB));
            return 2;
        }
        if (a.c.d(cls)) {
            return 1;
        }
        Class superclass = cls.getSuperclass();
        if (e(superclass)) {
            p31.e(superclass, "superclass");
            if (d(superclass) == 1) {
                return 1;
            }
            Object obj = c.get(superclass);
            p31.c(obj);
            arrayList = new ArrayList((Collection) obj);
        } else {
            arrayList = null;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        p31.e(interfaces, "klass.interfaces");
        for (Class<?> cls2 : interfaces) {
            if (e(cls2)) {
                p31.e(cls2, "intrface");
                if (d(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                Object obj2 = c.get(cls2);
                p31.c(obj2);
                arrayList.addAll((Collection) obj2);
            }
        }
        if (arrayList == null) {
            return 1;
        }
        c.put(cls, arrayList);
        return 2;
    }
}
