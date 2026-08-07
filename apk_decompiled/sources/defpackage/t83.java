package defpackage;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public abstract class t83 {
    public static final t83 a = c();

    class a extends t83 {
        final /* synthetic */ Method b;
        final /* synthetic */ Object c;

        a(Method method, Object obj) {
            this.b = method;
            this.c = obj;
        }

        @Override // defpackage.t83
        public Object d(Class cls) {
            t83.b(cls);
            return this.b.invoke(this.c, cls);
        }
    }

    class b extends t83 {
        final /* synthetic */ Method b;
        final /* synthetic */ int c;

        b(Method method, int i) {
            this.b = method;
            this.c = i;
        }

        @Override // defpackage.t83
        public Object d(Class cls) {
            t83.b(cls);
            return this.b.invoke(null, cls, Integer.valueOf(this.c));
        }
    }

    class c extends t83 {
        final /* synthetic */ Method b;

        c(Method method) {
            this.b = method;
        }

        @Override // defpackage.t83
        public Object d(Class cls) {
            t83.b(cls);
            return this.b.invoke(null, cls, Object.class);
        }
    }

    class d extends t83 {
        d() {
        }

        @Override // defpackage.t83
        public Object d(Class cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Class cls) {
        String strA = p20.a(cls);
        if (strA == null) {
            return;
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + strA);
    }

    private static t83 c() {
        try {
            try {
                try {
                    Class<?> cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
                } catch (Exception unused) {
                    return new d();
                }
            } catch (Exception unused2) {
                Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod.setAccessible(true);
                return new c(declaredMethod);
            }
        } catch (Exception unused3) {
            Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
            declaredMethod2.setAccessible(true);
            int iIntValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
            Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
            declaredMethod3.setAccessible(true);
            return new b(declaredMethod3, iIntValue);
        }
    }

    public abstract Object d(Class cls);
}
