package defpackage;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyName;
import com.tencent.connect.common.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ay {
    private static final Class a = Object.class;
    private static final Annotation[] b = new Annotation[0];
    private static final a[] c = new a[0];
    private static final Iterator d = Collections.emptyIterator();

    public static final class a {
        public final Constructor a;
        private transient Annotation[] b;
        private transient Annotation[][] c;
        private int d = -1;

        public a(Constructor constructor) {
            this.a = constructor;
        }

        public Constructor a() {
            return this.a;
        }

        public Annotation[] b() {
            Annotation[] annotationArr = this.b;
            if (annotationArr != null) {
                return annotationArr;
            }
            Annotation[] declaredAnnotations = this.a.getDeclaredAnnotations();
            this.b = declaredAnnotations;
            return declaredAnnotations;
        }

        public Class c() {
            return this.a.getDeclaringClass();
        }

        public int d() {
            int i = this.d;
            if (i >= 0) {
                return i;
            }
            int parameterCount = this.a.getParameterCount();
            this.d = parameterCount;
            return parameterCount;
        }

        public Annotation[][] e() {
            Annotation[][] annotationArr = this.c;
            if (annotationArr != null) {
                return annotationArr;
            }
            Annotation[][] parameterAnnotations = this.a.getParameterAnnotations();
            this.c = parameterAnnotations;
            return parameterAnnotations;
        }
    }

    private static class b {
        static final b e = new b();
        private final Field a;
        private final Field b;
        private final String c;
        private final String d;

        private b() {
            String string;
            Field fieldD;
            String string2;
            Field fieldD2 = null;
            try {
                fieldD = d(EnumSet.class, "elementType", Class.class);
                string = null;
            } catch (Exception e2) {
                string = e2.toString();
                fieldD = null;
            }
            this.a = fieldD;
            this.c = string;
            try {
                fieldD2 = d(EnumMap.class, "keyType", Class.class);
                string2 = null;
            } catch (Exception e3) {
                string2 = e3.toString();
            }
            this.b = fieldD2;
            this.d = string2;
        }

        private Object c(Object obj, Field field) {
            try {
                return field.get(obj);
            } catch (Exception e2) {
                throw new IllegalArgumentException(e2);
            }
        }

        private static Field d(Class cls, String str, Class cls2) {
            for (Field field : cls.getDeclaredFields()) {
                if (str.equals(field.getName()) && field.getType() == cls2) {
                    field.setAccessible(true);
                    return field;
                }
            }
            throw new IllegalStateException(String.format("No field named '%s' in class '%s'", str, cls.getName()));
        }

        public Class a(EnumMap enumMap) {
            Field field = this.b;
            if (field != null) {
                return (Class) c(enumMap, field);
            }
            throw new IllegalStateException("Cannot figure out type parameter for `EnumMap` (odd JDK platform?), problem: " + this.d);
        }

        public Class b(EnumSet enumSet) {
            Field field = this.a;
            if (field != null) {
                return (Class) c(enumSet, field);
            }
            throw new IllegalStateException("Cannot figure out type parameter for `EnumSet` (odd JDK platform?), problem: " + this.c);
        }
    }

    public static a[] A(Class cls) {
        if (cls.isInterface() || R(cls)) {
            return c;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        int length = declaredConstructors.length;
        a[] aVarArr = new a[length];
        for (int i = 0; i < length; i++) {
            aVarArr[i] = new a(declaredConstructors[i]);
        }
        return aVarArr;
    }

    public static Class B(Class cls) {
        if (R(cls)) {
            return null;
        }
        return cls.getEnclosingClass();
    }

    public static Type[] C(Class cls) {
        return cls.getGenericInterfaces();
    }

    public static Type D(Class cls) {
        return cls.getGenericSuperclass();
    }

    public static Class E(Class cls) {
        if (!Modifier.isStatic(cls.getModifiers())) {
            try {
                if (I(cls)) {
                    return null;
                }
                return B(cls);
            } catch (SecurityException unused) {
            }
        }
        return null;
    }

    public static Throwable F(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    public static String G(JavaType javaType) {
        if (javaType == null) {
            return "[null]";
        }
        StringBuilder sb = new StringBuilder(80);
        sb.append('`');
        sb.append(javaType.toCanonical());
        sb.append('`');
        return sb.toString();
    }

    public static boolean H(Object obj, Class cls) {
        return obj != null && obj.getClass() == cls;
    }

    public static boolean I(Class cls) {
        return (R(cls) || cls.getEnclosingMethod() == null) ? false : true;
    }

    public static boolean J(Class cls) {
        return cls == Void.class || cls == Void.TYPE || cls == dr1.class;
    }

    public static boolean K(Class cls) {
        return (cls.getModifiers() & 1536) == 0;
    }

    public static boolean L(Class cls) {
        return Enum.class.isAssignableFrom(cls);
    }

    public static boolean M(Class cls) {
        String name = cls.getName();
        return name.startsWith("java.") || name.startsWith("javax.");
    }

    public static boolean N(Class cls) {
        return cls.getAnnotation(e41.class) != null;
    }

    public static boolean O(Object obj) {
        return obj == null || N(obj.getClass());
    }

    public static String P(Class cls, boolean z) {
        try {
            boolean zIsStatic = Modifier.isStatic(cls.getModifiers());
            if (!zIsStatic && I(cls)) {
                return "local/anonymous";
            }
            if (z || zIsStatic || B(cls) == null) {
                return null;
            }
            return "non-static member class";
        } catch (NullPointerException | SecurityException unused) {
            return null;
        }
    }

    public static boolean Q(Class cls) {
        return (Modifier.isStatic(cls.getModifiers()) || B(cls) == null) ? false : true;
    }

    public static boolean R(Class cls) {
        return cls == a || cls.isPrimitive();
    }

    public static boolean S(Class cls) {
        String name = cls.getName();
        return name.startsWith("net.sf.cglib.proxy.") || name.startsWith("org.hibernate.proxy.");
    }

    public static boolean T(Class cls) {
        Class superclass = cls.getSuperclass();
        return superclass != null && "com.android.tools.r8.RecordTag".equals(superclass.getName());
    }

    public static String U(PropertyName propertyName) {
        return propertyName == null ? "[null]" : d(propertyName.getSimpleName());
    }

    public static String V(String str) {
        return str == null ? "[null]" : d(str);
    }

    public static String W(in1 in1Var) {
        return in1Var == null ? "[null]" : d(in1Var.getName());
    }

    public static String X(Class cls) {
        if (cls == null) {
            return "[null]";
        }
        int i = 0;
        while (cls.isArray()) {
            i++;
            cls = cls.getComponentType();
        }
        String simpleName = cls.isPrimitive() ? cls.getSimpleName() : cls.getName();
        if (i > 0) {
            StringBuilder sb = new StringBuilder(simpleName);
            do {
                sb.append("[]");
                i--;
            } while (i > 0);
            simpleName = sb.toString();
        }
        return e(simpleName);
    }

    public static Object Y(Object obj, Object obj2) {
        return obj == null ? obj2 : obj;
    }

    public static String Z(String str) {
        return str == null ? Constants.STR_EMPTY : str;
    }

    private static void a(Class cls, Class cls2, Collection collection, boolean z) {
        if (cls == cls2 || cls == null || cls == Object.class) {
            return;
        }
        if (z) {
            if (collection.contains(cls)) {
                return;
            } else {
                collection.add(cls);
            }
        }
        for (Class cls3 : c(cls)) {
            a(cls3, cls2, collection, true);
        }
        a(cls.getSuperclass(), cls2, collection, true);
    }

    public static String a0(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    private static Method[] b(Class cls, Throwable th) {
        throw new IllegalArgumentException(String.format("Failed on call to `getDeclaredMethods()` on class `%s`, problem: (%s) %s", cls.getName(), th.getClass().getName(), th.getMessage()), th);
    }

    public static Class b0(Class cls) {
        if (cls.isPrimitive()) {
            return cls;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Character.class) {
            return Character.TYPE;
        }
        return null;
    }

    private static Class[] c(Class cls) {
        return cls.getInterfaces();
    }

    public static String c0(Object obj, String str) {
        return obj == null ? str : String.format("\"%s\"", obj);
    }

    public static String d(String str) {
        if (str == null) {
            return "[null]";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append('\'');
        sb.append(str);
        sb.append('\'');
        return sb.toString();
    }

    public static Class d0(JavaType javaType) {
        if (javaType == null) {
            return null;
        }
        return javaType.getRawClass();
    }

    public static String e(String str) {
        if (str == null) {
            return "[null]";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append('`');
        sb.append(str);
        sb.append('`');
        return sb.toString();
    }

    public static void e0(Throwable th) {
        f0(th, th.getMessage());
    }

    public static String f(Class cls) {
        if (cls.isAnnotation()) {
            return "annotation";
        }
        if (cls.isArray()) {
            return "array";
        }
        if (Enum.class.isAssignableFrom(cls)) {
            return "enum";
        }
        if (cls.isPrimitive()) {
            return "primitive";
        }
        return null;
    }

    public static void f0(Throwable th, String str) {
        j0(th);
        h0(th);
        throw new IllegalArgumentException(str, th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g(Member member, boolean z) {
        AccessibleObject accessibleObject = (AccessibleObject) member;
        try {
            Class<?> declaringClass = member.getDeclaringClass();
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(declaringClass.getModifiers()) && (!z || M(declaringClass))) {
                return;
            }
            accessibleObject.setAccessible(true);
        } catch (SecurityException e) {
            if (accessibleObject.isAccessible()) {
                return;
            }
            throw new IllegalArgumentException("Cannot access " + member + " (from class " + member.getDeclaringClass().getName() + "; failed to set access: " + e.getMessage());
        } catch (RuntimeException e2) {
            if (!"InaccessibleObjectException".equals(e2.getClass().getSimpleName())) {
                throw e2;
            }
            throw new IllegalArgumentException(String.format("Failed to call `setAccess()` on %s '%s' (of class %s) due to `%s`, problem: %s", member.getClass().getSimpleName(), member.getName(), X(member.getDeclaringClass()), e2.getClass().getName(), e2.getMessage()), e2);
        }
    }

    public static Object g0(DeserializationContext deserializationContext, IOException iOException) throws JsonMappingException {
        if (iOException instanceof JsonMappingException) {
            throw ((JsonMappingException) iOException);
        }
        throw JsonMappingException.from(deserializationContext, iOException.getMessage()).withCause(iOException);
    }

    public static String h(Object obj) {
        if (obj == null) {
            return "[null]";
        }
        return X(obj instanceof Class ? (Class) obj : obj.getClass());
    }

    public static Throwable h0(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
        return th;
    }

    public static Class i(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.getClass();
    }

    public static Throwable i0(Throwable th) throws IOException {
        if (th instanceof IOException) {
            throw ((IOException) th);
        }
        return th;
    }

    public static void j(JsonGenerator jsonGenerator, Closeable closeable, Exception exc) throws IOException {
        if (jsonGenerator != null) {
            jsonGenerator.e0(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
            try {
                jsonGenerator.close();
            } catch (Exception e) {
                exc.addSuppressed(e);
            }
        }
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                exc.addSuppressed(e2);
            }
        }
        i0(exc);
        j0(exc);
        throw new RuntimeException(exc);
    }

    public static Throwable j0(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        return th;
    }

    public static void k(JsonGenerator jsonGenerator, Exception exc) throws IOException {
        jsonGenerator.e0(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
        try {
            jsonGenerator.close();
        } catch (Exception e) {
            exc.addSuppressed(e);
        }
        i0(exc);
        j0(exc);
        throw new RuntimeException(exc);
    }

    public static Throwable k0(Throwable th) {
        return i0(F(th));
    }

    public static Object l(Class cls, boolean z) {
        Constructor constructorQ = q(cls, z);
        if (constructorQ == null) {
            throw new IllegalArgumentException("Class " + cls.getName() + " has no default (no arg) constructor");
        }
        try {
            return constructorQ.newInstance(null);
        } catch (Exception e) {
            m0(e, "Failed to instantiate class " + cls.getName() + ", problem: " + e.getMessage());
            return null;
        }
    }

    public static void l0(Throwable th) {
        e0(F(th));
    }

    public static Object m(Class cls) {
        if (cls == Integer.TYPE) {
            return 0;
        }
        if (cls == Long.TYPE) {
            return 0L;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (cls == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        if (cls == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (cls == Byte.TYPE) {
            return (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (short) 0;
        }
        if (cls == Character.TYPE) {
            return (char) 0;
        }
        throw new IllegalArgumentException("Class " + cls.getName() + " is not a primitive type");
    }

    public static void m0(Throwable th, String str) {
        f0(F(th), str);
    }

    public static Iterator n() {
        return d;
    }

    public static void n0(Class cls, Object obj, String str) {
        if (obj.getClass() != cls) {
            throw new IllegalStateException(String.format("Sub-class %s (of class %s) must override method '%s'", obj.getClass().getName(), cls.getName(), str));
        }
    }

    public static String o(Throwable th) {
        if (th instanceof JacksonException) {
            return ((JacksonException) th).getOriginalMessage();
        }
        return (!(th instanceof InvocationTargetException) || th.getCause() == null) ? th.getMessage() : th.getCause().getMessage();
    }

    public static Class o0(Class cls) {
        if (cls == Integer.TYPE) {
            return Integer.class;
        }
        if (cls == Long.TYPE) {
            return Long.class;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.class;
        }
        if (cls == Double.TYPE) {
            return Double.class;
        }
        if (cls == Float.TYPE) {
            return Float.class;
        }
        if (cls == Byte.TYPE) {
            return Byte.class;
        }
        if (cls == Short.TYPE) {
            return Short.class;
        }
        if (cls == Character.TYPE) {
            return Character.class;
        }
        throw new IllegalArgumentException("Class " + cls.getName() + " is not a primitive type");
    }

    public static Annotation[] p(Class cls) {
        return R(cls) ? b : cls.getDeclaredAnnotations();
    }

    public static Constructor q(Class cls, boolean z) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            if (z) {
                g(declaredConstructor, z);
            } else if (!Modifier.isPublic(declaredConstructor.getModifiers())) {
                throw new IllegalArgumentException("Default constructor for " + cls.getName() + " is not accessible (non-public?): not allowed to try modify access via Reflection: cannot instantiate type");
            }
            return declaredConstructor;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (Exception e) {
            m0(e, "Failed to find default constructor of class " + cls.getName() + ", problem: " + e.getMessage());
            return null;
        }
    }

    public static Class r(Class cls) {
        return cls.getSuperclass() != Enum.class ? cls.getSuperclass() : cls;
    }

    public static Class s(Enum r0) {
        return r0.getDeclaringClass();
    }

    public static Class t(EnumMap enumMap) {
        return !enumMap.isEmpty() ? s((Enum) enumMap.keySet().iterator().next()) : b.e.a(enumMap);
    }

    public static Class u(EnumSet enumSet) {
        return !enumSet.isEmpty() ? s((Enum) enumSet.iterator().next()) : b.e.b(enumSet);
    }

    public static Enum v(Class cls, Class cls2) {
        for (Field field : cls.getDeclaredFields()) {
            if (field.isEnumConstant() && field.getAnnotation(cls2) != null) {
                String name = field.getName();
                for (Enum r8 : (Enum[]) cls.getEnumConstants()) {
                    if (name.equals(r8.name())) {
                        return r8;
                    }
                }
            }
        }
        return null;
    }

    public static List w(Class cls, Class cls2, boolean z) {
        if (cls == null || cls == cls2 || cls == Object.class) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(8);
        a(cls, cls2, arrayList, z);
        return arrayList;
    }

    public static List x(Class cls, Class cls2, boolean z) {
        ArrayList arrayList = new ArrayList(8);
        if (cls != null && cls != cls2) {
            if (z) {
                arrayList.add(cls);
            }
            while (true) {
                cls = cls.getSuperclass();
                if (cls == null || cls == cls2) {
                    break;
                }
                arrayList.add(cls);
            }
        }
        return arrayList;
    }

    public static String y(Object obj) {
        if (obj == null) {
            return "unknown";
        }
        return X(obj instanceof Class ? (Class) obj : obj.getClass());
    }

    public static Method[] z(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader == null) {
                return b(cls, e);
            }
            try {
                try {
                    return contextClassLoader.loadClass(cls.getName()).getDeclaredMethods();
                } catch (Throwable th) {
                    return b(cls, th);
                }
            } catch (ClassNotFoundException e2) {
                e.addSuppressed(e2);
                return b(cls, e);
            }
        } catch (Throwable th2) {
            return b(cls, th2);
        }
    }
}
