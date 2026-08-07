package lombok.permit;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/permit/Permit.SCL.lombok */
public class Permit {
    private static final long ACCESSIBLE_OVERRIDE_FIELD_OFFSET;
    private static final IllegalAccessException INIT_ERROR;
    private static final Unsafe UNSAFE = (Unsafe) reflectiveStaticFieldAccess(Unsafe.class, "theUnsafe");

    private Permit() {
    }

    static {
        long g;
        Throwable ex;
        try {
            g = getOverrideFieldOffset();
            ex = null;
        } catch (Throwable t) {
            g = -1;
            ex = t;
        }
        ACCESSIBLE_OVERRIDE_FIELD_OFFSET = g;
        if (ex != null) {
            if (!(ex instanceof IllegalAccessException)) {
                INIT_ERROR = new IllegalAccessException("Cannot initialize Unsafe-based permit");
                INIT_ERROR.initCause(ex);
                return;
            } else {
                INIT_ERROR = (IllegalAccessException) ex;
                return;
            }
        }
        INIT_ERROR = null;
    }

    public static <T extends AccessibleObject> T setAccessible(T accessor) {
        if (INIT_ERROR == null) {
            UNSAFE.putBoolean(accessor, ACCESSIBLE_OVERRIDE_FIELD_OFFSET, true);
        } else {
            accessor.setAccessible(true);
        }
        return accessor;
    }

    private static long getOverrideFieldOffset() throws Throwable {
        Field f = null;
        Throwable saved = null;
        try {
            f = AccessibleObject.class.getDeclaredField("override");
        } catch (Throwable t) {
            saved = t;
        }
        if (f != null) {
            return UNSAFE.objectFieldOffset(f);
        }
        try {
            return UNSAFE.objectFieldOffset(Fake.class.getDeclaredField("override"));
        } catch (Throwable unused) {
            throw saved;
        }
    }

    /* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/permit/Permit$Fake.SCL.lombok */
    static class Fake {
        boolean override;
        Object accessCheckCache;

        Fake() {
        }
    }

    public static Method getMethod(Class<?> c, String mName, Class<?>... clsArr) throws NoSuchMethodException {
        Method m = null;
        while (c != null) {
            try {
                m = c.getDeclaredMethod(mName, clsArr);
                break;
            } catch (NoSuchMethodException unused) {
                c = c.getSuperclass();
            }
        }
        if (m == null) {
            throw new NoSuchMethodException(String.valueOf(c.getName()) + " :: " + mName + "(args)");
        }
        return (Method) setAccessible(m);
    }

    public static Method permissiveGetMethod(Class<?> c, String mName, Class<?>... clsArr) {
        try {
            return getMethod(c, mName, clsArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Field getField(Class<?> c, String fName) throws NoSuchFieldException {
        Field f = null;
        while (c != null) {
            try {
                f = c.getDeclaredField(fName);
                break;
            } catch (NoSuchFieldException unused) {
                c = c.getSuperclass();
            }
        }
        if (f == null) {
            throw new NoSuchFieldException(String.valueOf(c.getName()) + " :: " + fName);
        }
        return (Field) setAccessible(f);
    }

    public static Field permissiveGetField(Class<?> c, String fName) {
        try {
            return getField(c, fName);
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T permissiveReadField(Class<T> type, Field f, Object instance) {
        try {
            return type.cast(f.get(instance));
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> Constructor<T> getConstructor(Class<T> c, Class<?>... clsArr) throws NoSuchMethodException {
        return (Constructor) setAccessible(c.getDeclaredConstructor(clsArr));
    }

    private static Object reflectiveStaticFieldAccess(Class<?> c, String fName) {
        try {
            Field f = c.getDeclaredField(fName);
            f.setAccessible(true);
            return f.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isDebugReflection() {
        return !"false".equals(System.getProperty("lombok.debug.reflection", "false"));
    }

    public static void handleReflectionDebug(Throwable t, Throwable initError) {
        if (isDebugReflection()) {
            System.err.println("** LOMBOK REFLECTION exception: " + t.getClass() + ": " + (t.getMessage() == null ? "(no message)" : t.getMessage()));
            t.printStackTrace(System.err);
            if (initError != null) {
                System.err.println("*** ADDITIONALLY, exception occurred setting up reflection: ");
                initError.printStackTrace(System.err);
            }
        }
    }

    public static Object invoke(Method m, Object receiver, Object... args) throws IllegalAccessException, InvocationTargetException {
        return invoke(null, m, receiver, args);
    }

    public static Object invoke(Throwable initError, Method m, Object receiver, Object... args) throws IllegalAccessException, InvocationTargetException {
        try {
            return m.invoke(receiver, args);
        } catch (Error e) {
            handleReflectionDebug(e, initError);
            throw e;
        } catch (IllegalAccessException e2) {
            handleReflectionDebug(e2, initError);
            throw e2;
        } catch (RuntimeException e3) {
            handleReflectionDebug(e3, initError);
            throw e3;
        }
    }

    public static Object invokeSneaky(Method m, Object receiver, Object... args) {
        return invokeSneaky(null, m, receiver, args);
    }

    public static Object invokeSneaky(Throwable initError, Method m, Object receiver, Object... args) {
        try {
            return m.invoke(receiver, args);
        } catch (NoClassDefFoundError e) {
            handleReflectionDebug(e, initError);
            return null;
        } catch (Error e2) {
            handleReflectionDebug(e2, initError);
            throw e2;
        } catch (IllegalAccessException e3) {
            handleReflectionDebug(e3, initError);
            throw sneakyThrow(e3);
        } catch (NullPointerException e4) {
            handleReflectionDebug(e4, initError);
            return null;
        } catch (RuntimeException e5) {
            handleReflectionDebug(e5, initError);
            throw e5;
        } catch (InvocationTargetException e6) {
            throw sneakyThrow(e6.getCause());
        }
    }

    public static <T> T newInstance(Constructor<T> constructor, Object... objArr) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        return (T) newInstance(null, constructor, objArr);
    }

    public static <T> T newInstance(Throwable initError, Constructor<T> c, Object... args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        try {
            return c.newInstance(args);
        } catch (Error e) {
            handleReflectionDebug(e, initError);
            throw e;
        } catch (IllegalAccessException e2) {
            handleReflectionDebug(e2, initError);
            throw e2;
        } catch (InstantiationException e3) {
            handleReflectionDebug(e3, initError);
            throw e3;
        } catch (RuntimeException e4) {
            handleReflectionDebug(e4, initError);
            throw e4;
        }
    }

    public static <T> T newInstanceSneaky(Constructor<T> constructor, Object... objArr) {
        return (T) newInstanceSneaky(null, constructor, objArr);
    }

    public static <T> T newInstanceSneaky(Throwable initError, Constructor<T> c, Object... args) {
        try {
            return c.newInstance(args);
        } catch (IllegalAccessException e) {
            handleReflectionDebug(e, initError);
            throw sneakyThrow(e);
        } catch (NoClassDefFoundError e2) {
            handleReflectionDebug(e2, initError);
            return null;
        } catch (Error e3) {
            handleReflectionDebug(e3, initError);
            throw e3;
        } catch (InstantiationException e4) {
            handleReflectionDebug(e4, initError);
            throw sneakyThrow(e4);
        } catch (NullPointerException e5) {
            handleReflectionDebug(e5, initError);
            return null;
        } catch (RuntimeException e6) {
            handleReflectionDebug(e6, initError);
            throw e6;
        } catch (InvocationTargetException e7) {
            throw sneakyThrow(e7.getCause());
        }
    }

    public static Object get(Field f, Object receiver) throws IllegalAccessException {
        try {
            return f.get(receiver);
        } catch (Error e) {
            handleReflectionDebug(e, null);
            throw e;
        } catch (IllegalAccessException e2) {
            handleReflectionDebug(e2, null);
            throw e2;
        } catch (RuntimeException e3) {
            handleReflectionDebug(e3, null);
            throw e3;
        }
    }

    public static void set(Field f, Object receiver, Object newValue) throws IllegalAccessException {
        try {
            f.set(receiver, newValue);
        } catch (Error e) {
            handleReflectionDebug(e, null);
            throw e;
        } catch (IllegalAccessException e2) {
            handleReflectionDebug(e2, null);
            throw e2;
        } catch (RuntimeException e3) {
            handleReflectionDebug(e3, null);
            throw e3;
        }
    }

    public static void reportReflectionProblem(Throwable initError, String msg) {
        if (isDebugReflection()) {
            System.err.println("** LOMBOK REFLECTION issue: " + msg);
            if (initError != null) {
                System.err.println("*** ADDITIONALLY, exception occurred setting up reflection: ");
                initError.printStackTrace(System.err);
            }
        }
    }

    public static RuntimeException sneakyThrow(Throwable t) {
        if (t == null) {
            throw new NullPointerException("t");
        }
        return (RuntimeException) sneakyThrow0(t);
    }

    private static <T extends Throwable> T sneakyThrow0(Throwable t) throws Throwable {
        throw t;
    }
}
