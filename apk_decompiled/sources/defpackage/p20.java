package defpackage;

import com.google.gson.JsonIOException;
import com.google.gson.ReflectionAccessFilter$FilterResult;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: classes3.dex */
public final class p20 {
    private final Map a;
    private final boolean b;
    private final List c;

    class a implements kt1 {
        a() {
        }

        @Override // defpackage.kt1
        public Object a() {
            return new TreeSet();
        }
    }

    class b implements kt1 {
        b() {
        }

        @Override // defpackage.kt1
        public Object a() {
            return new LinkedHashSet();
        }
    }

    class c implements kt1 {
        c() {
        }

        @Override // defpackage.kt1
        public Object a() {
            return new ArrayDeque();
        }
    }

    class d implements kt1 {
        d() {
        }

        @Override // defpackage.kt1
        public Object a() {
            return new ArrayList();
        }
    }

    class e implements kt1 {
        e() {
        }

        @Override // defpackage.kt1
        public Object a() {
            return new ConcurrentSkipListMap();
        }
    }

    class f implements kt1 {
        f() {
        }

        @Override // defpackage.kt1
        public Object a() {
            return new ConcurrentHashMap();
        }
    }

    class g implements kt1 {
        g() {
        }

        @Override // defpackage.kt1
        public Object a() {
            return new TreeMap();
        }
    }

    class h implements kt1 {
        h() {
        }

        @Override // defpackage.kt1
        public Object a() {
            return new LinkedHashMap();
        }
    }

    class i implements kt1 {
        i() {
        }

        @Override // defpackage.kt1
        public Object a() {
            return new LinkedTreeMap();
        }
    }

    class j implements kt1 {
        final /* synthetic */ Class a;

        j(Class cls) {
            this.a = cls;
        }

        @Override // defpackage.kt1
        public Object a() {
            try {
                return t83.a.d(this.a);
            } catch (Exception e) {
                throw new RuntimeException("Unable to create instance of " + this.a + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e);
            }
        }
    }

    class k implements kt1 {
        final /* synthetic */ String a;

        k(String str) {
            this.a = str;
        }

        @Override // defpackage.kt1
        public Object a() {
            throw new JsonIOException(this.a);
        }
    }

    class l implements kt1 {
        final /* synthetic */ String a;

        l(String str) {
            this.a = str;
        }

        @Override // defpackage.kt1
        public Object a() {
            throw new JsonIOException(this.a);
        }
    }

    class m implements kt1 {
        final /* synthetic */ String a;

        m(String str) {
            this.a = str;
        }

        @Override // defpackage.kt1
        public Object a() {
            throw new JsonIOException(this.a);
        }
    }

    class n implements kt1 {
        final /* synthetic */ Type a;

        n(Type type) {
            this.a = type;
        }

        @Override // defpackage.kt1
        public Object a() {
            Type type = this.a;
            if (!(type instanceof ParameterizedType)) {
                throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return EnumSet.noneOf((Class) type2);
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
        }
    }

    class o implements kt1 {
        final /* synthetic */ Type a;

        o(Type type) {
            this.a = type;
        }

        @Override // defpackage.kt1
        public Object a() {
            Type type = this.a;
            if (!(type instanceof ParameterizedType)) {
                throw new JsonIOException("Invalid EnumMap type: " + this.a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return new EnumMap((Class) type2);
            }
            throw new JsonIOException("Invalid EnumMap type: " + this.a.toString());
        }
    }

    class p implements kt1 {
        final /* synthetic */ String a;

        p(String str) {
            this.a = str;
        }

        @Override // defpackage.kt1
        public Object a() {
            throw new JsonIOException(this.a);
        }
    }

    class q implements kt1 {
        final /* synthetic */ String a;

        q(String str) {
            this.a = str;
        }

        @Override // defpackage.kt1
        public Object a() {
            throw new JsonIOException(this.a);
        }
    }

    class r implements kt1 {
        final /* synthetic */ Constructor a;

        r(Constructor constructor) {
            this.a = constructor;
        }

        @Override // defpackage.kt1
        public Object a() {
            try {
                return this.a.newInstance(null);
            } catch (IllegalAccessException e) {
                throw ne2.e(e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Failed to invoke constructor '" + ne2.c(this.a) + "' with no args", e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to invoke constructor '" + ne2.c(this.a) + "' with no args", e3.getCause());
            }
        }
    }

    public p20(Map map, boolean z, List list) {
        this.a = map;
        this.b = z;
        this.c = list;
    }

    static String a(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName();
    }

    private static kt1 c(Class cls, ReflectionAccessFilter$FilterResult reflectionAccessFilter$FilterResult) {
        String strM;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            ReflectionAccessFilter$FilterResult reflectionAccessFilter$FilterResult2 = ReflectionAccessFilter$FilterResult.ALLOW;
            if (reflectionAccessFilter$FilterResult == reflectionAccessFilter$FilterResult2 || (le2.a(declaredConstructor, null) && (reflectionAccessFilter$FilterResult != ReflectionAccessFilter$FilterResult.BLOCK_ALL || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return (reflectionAccessFilter$FilterResult != reflectionAccessFilter$FilterResult2 || (strM = ne2.m(declaredConstructor)) == null) ? new r(declaredConstructor) : new q(strM);
            }
            return new p("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static kt1 d(Type type, Class cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new a();
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new b();
            }
            return Queue.class.isAssignableFrom(cls) ? new c() : new d();
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new e();
        }
        if (ConcurrentMap.class.isAssignableFrom(cls)) {
            return new f();
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new g();
        }
        return (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) ? new i() : new h();
    }

    private static kt1 e(Type type, Class cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new n(type);
        }
        if (cls == EnumMap.class) {
            return new o(type);
        }
        return null;
    }

    private kt1 f(Class cls) {
        if (this.b) {
            return new j(cls);
        }
        return new k("Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public kt1 b(TypeToken typeToken) {
        Type type = typeToken.getType();
        Class rawType = typeToken.getRawType();
        e43.a(this.a.get(type));
        e43.a(this.a.get(rawType));
        kt1 kt1VarE = e(type, rawType);
        if (kt1VarE != null) {
            return kt1VarE;
        }
        ReflectionAccessFilter$FilterResult reflectionAccessFilter$FilterResultB = le2.b(this.c, rawType);
        kt1 kt1VarC = c(rawType, reflectionAccessFilter$FilterResultB);
        if (kt1VarC != null) {
            return kt1VarC;
        }
        kt1 kt1VarD = d(type, rawType);
        if (kt1VarD != null) {
            return kt1VarD;
        }
        String strA = a(rawType);
        if (strA != null) {
            return new l(strA);
        }
        if (reflectionAccessFilter$FilterResultB == ReflectionAccessFilter$FilterResult.ALLOW) {
            return f(rawType);
        }
        return new m("Unable to create instance of " + rawType + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    }

    public String toString() {
        return this.a.toString();
    }
}
