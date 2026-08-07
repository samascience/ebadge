package defpackage;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter$FilterResult;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class oe2 implements f63 {
    private final p20 a;
    private final ul0 b;
    private final wi0 c;
    private final f51 d;
    private final List e;

    class a extends c {
        final /* synthetic */ boolean f;
        final /* synthetic */ Method g;
        final /* synthetic */ boolean h;
        final /* synthetic */ e63 i;
        final /* synthetic */ qv0 j;
        final /* synthetic */ TypeToken k;
        final /* synthetic */ boolean l;
        final /* synthetic */ boolean m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Field field, boolean z, boolean z2, boolean z3, Method method, boolean z4, e63 e63Var, qv0 qv0Var, TypeToken typeToken, boolean z5, boolean z6) {
            super(str, field, z, z2);
            this.f = z3;
            this.g = method;
            this.h = z4;
            this.i = e63Var;
            this.j = qv0Var;
            this.k = typeToken;
            this.l = z5;
            this.m = z6;
        }

        @Override // oe2.c
        void a(a71 a71Var, int i, Object[] objArr) {
            Object objB = this.i.b(a71Var);
            if (objB != null || !this.l) {
                objArr[i] = objB;
                return;
            }
            throw new JsonParseException("null is not allowed as value for record component '" + this.c + "' of primitive type; at path " + a71Var.c());
        }

        @Override // oe2.c
        void b(a71 a71Var, Object obj) throws IllegalAccessException {
            Object objB = this.i.b(a71Var);
            if (objB == null && this.l) {
                return;
            }
            if (this.f) {
                oe2.c(obj, this.b);
            } else if (this.m) {
                throw new JsonIOException("Cannot set value of 'static final' " + ne2.g(this.b, false));
            }
            this.b.set(obj, objB);
        }

        @Override // oe2.c
        void c(a81 a81Var, Object obj) throws IllegalAccessException {
            Object objInvoke;
            if (this.d) {
                if (this.f) {
                    Method method = this.g;
                    if (method == null) {
                        oe2.c(obj, this.b);
                    } else {
                        oe2.c(obj, method);
                    }
                }
                Method method2 = this.g;
                if (method2 != null) {
                    try {
                        objInvoke = method2.invoke(obj, null);
                    } catch (InvocationTargetException e) {
                        throw new JsonIOException("Accessor " + ne2.g(this.g, false) + " threw exception", e.getCause());
                    }
                } else {
                    objInvoke = this.b.get(obj);
                }
                if (objInvoke == obj) {
                    return;
                }
                a81Var.k0(this.a);
                (this.h ? this.i : new g63(this.j, this.i, this.k.getType())).e(a81Var, objInvoke);
            }
        }
    }

    public static abstract class b extends e63 {
        final Map a;

        b(Map map) {
            this.a = map;
        }

        @Override // defpackage.e63
        public Object b(a71 a71Var) throws IOException {
            if (a71Var.M0() == JsonToken.NULL) {
                a71Var.I0();
                return null;
            }
            Object objF = f();
            try {
                a71Var.u();
                while (a71Var.j0()) {
                    c cVar = (c) this.a.get(a71Var.G0());
                    if (cVar == null || !cVar.e) {
                        a71Var.W0();
                    } else {
                        h(objF, a71Var, cVar);
                    }
                }
                a71Var.V();
                return g(objF);
            } catch (IllegalAccessException e) {
                throw ne2.e(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // defpackage.e63
        public void e(a81 a81Var, Object obj) throws IOException {
            if (obj == null) {
                a81Var.t0();
                return;
            }
            a81Var.y();
            try {
                Iterator it = this.a.values().iterator();
                while (it.hasNext()) {
                    ((c) it.next()).c(a81Var, obj);
                }
                a81Var.V();
            } catch (IllegalAccessException e) {
                throw ne2.e(e);
            }
        }

        abstract Object f();

        abstract Object g(Object obj);

        abstract void h(Object obj, a71 a71Var, c cVar);
    }

    static abstract class c {
        final String a;
        final Field b;
        final String c;
        final boolean d;
        final boolean e;

        protected c(String str, Field field, boolean z, boolean z2) {
            this.a = str;
            this.b = field;
            this.c = field.getName();
            this.d = z;
            this.e = z2;
        }

        abstract void a(a71 a71Var, int i, Object[] objArr);

        abstract void b(a71 a71Var, Object obj);

        abstract void c(a81 a81Var, Object obj);
    }

    private static final class d extends b {
        private final kt1 b;

        d(kt1 kt1Var, Map map) {
            super(map);
            this.b = kt1Var;
        }

        @Override // oe2.b
        Object f() {
            return this.b.a();
        }

        @Override // oe2.b
        Object g(Object obj) {
            return obj;
        }

        @Override // oe2.b
        void h(Object obj, a71 a71Var, c cVar) {
            cVar.b(a71Var, obj);
        }
    }

    private static final class e extends b {
        static final Map e = k();
        private final Constructor b;
        private final Object[] c;
        private final Map d;

        e(Class cls, Map map, boolean z) {
            super(map);
            this.d = new HashMap();
            Constructor constructorI = ne2.i(cls);
            this.b = constructorI;
            if (z) {
                oe2.c(null, constructorI);
            } else {
                ne2.l(constructorI);
            }
            String[] strArrJ = ne2.j(cls);
            for (int i = 0; i < strArrJ.length; i++) {
                this.d.put(strArrJ[i], Integer.valueOf(i));
            }
            Class<?>[] parameterTypes = this.b.getParameterTypes();
            this.c = new Object[parameterTypes.length];
            for (int i2 = 0; i2 < parameterTypes.length; i2++) {
                this.c[i2] = e.get(parameterTypes[i2]);
            }
        }

        private static Map k() {
            HashMap map = new HashMap();
            map.put(Byte.TYPE, (byte) 0);
            map.put(Short.TYPE, (short) 0);
            map.put(Integer.TYPE, 0);
            map.put(Long.TYPE, 0L);
            map.put(Float.TYPE, Float.valueOf(0.0f));
            map.put(Double.TYPE, Double.valueOf(0.0d));
            map.put(Character.TYPE, (char) 0);
            map.put(Boolean.TYPE, Boolean.FALSE);
            return map;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // oe2.b
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object[] f() {
            return (Object[]) this.c.clone();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // oe2.b
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Object g(Object[] objArr) {
            try {
                return this.b.newInstance(objArr);
            } catch (IllegalAccessException e2) {
                throw ne2.e(e2);
            } catch (IllegalArgumentException e3) {
                e = e3;
                throw new RuntimeException("Failed to invoke constructor '" + ne2.c(this.b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InstantiationException e4) {
                e = e4;
                throw new RuntimeException("Failed to invoke constructor '" + ne2.c(this.b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Failed to invoke constructor '" + ne2.c(this.b) + "' with args " + Arrays.toString(objArr), e5.getCause());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // oe2.b
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void h(Object[] objArr, a71 a71Var, c cVar) {
            Integer num = (Integer) this.d.get(cVar.c);
            if (num != null) {
                cVar.a(a71Var, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + ne2.c(this.b) + "' for field with name '" + cVar.c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public oe2(p20 p20Var, ul0 ul0Var, wi0 wi0Var, f51 f51Var, List list) {
        this.a = p20Var;
        this.b = ul0Var;
        this.c = wi0Var;
        this.d = f51Var;
        this.e = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static void c(Object obj, AccessibleObject accessibleObject) {
        if (Modifier.isStatic(((Member) accessibleObject).getModifiers())) {
            obj = null;
        }
        if (le2.a(accessibleObject, obj)) {
            return;
        }
        throw new JsonIOException(ne2.g(accessibleObject, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    private c d(qv0 qv0Var, Field field, Method method, String str, TypeToken typeToken, boolean z, boolean z2, boolean z3) {
        boolean zA = r62.a(typeToken.getRawType());
        int modifiers = field.getModifiers();
        boolean z4 = Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
        e51 e51Var = (e51) field.getAnnotation(e51.class);
        e63 e63VarB = e51Var != null ? this.d.b(this.a, qv0Var, typeToken, e51Var) : null;
        boolean z5 = e63VarB != null;
        if (e63VarB == null) {
            e63VarB = qv0Var.g(typeToken);
        }
        return new a(str, field, z, z2, z3, method, z5, e63VarB, qv0Var, typeToken, zA, z4);
    }

    private Map e(qv0 qv0Var, TypeToken typeToken, Class cls, boolean z, boolean z2) {
        boolean z3;
        Method method;
        int i;
        int i2;
        boolean z4;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        TypeToken typeToken2 = typeToken;
        boolean z5 = z;
        Class rawType = cls;
        while (rawType != Object.class) {
            Field[] declaredFields = rawType.getDeclaredFields();
            boolean z6 = true;
            boolean z7 = false;
            if (rawType != cls && declaredFields.length > 0) {
                ReflectionAccessFilter$FilterResult reflectionAccessFilter$FilterResultB = le2.b(this.e, rawType);
                if (reflectionAccessFilter$FilterResultB == ReflectionAccessFilter$FilterResult.BLOCK_ALL) {
                    throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + rawType + " (supertype of " + cls + "). Register a TypeAdapter for this type or adjust the access filter.");
                }
                z5 = reflectionAccessFilter$FilterResultB == ReflectionAccessFilter$FilterResult.BLOCK_INACCESSIBLE;
            }
            boolean z8 = z5;
            int length = declaredFields.length;
            int i3 = 0;
            while (i3 < length) {
                Field field = declaredFields[i3];
                boolean zG = this.g(field, z6);
                boolean zG2 = this.g(field, z7);
                if (zG || zG2) {
                    c cVar = null;
                    if (!z2) {
                        z3 = zG2;
                        method = null;
                    } else if (Modifier.isStatic(field.getModifiers())) {
                        method = null;
                        z3 = z7;
                    } else {
                        Method methodH = ne2.h(rawType, field);
                        if (!z8) {
                            ne2.l(methodH);
                        }
                        if (methodH.getAnnotation(xm2.class) != null && field.getAnnotation(xm2.class) == null) {
                            throw new JsonIOException("@SerializedName on " + ne2.g(methodH, z7) + " is not supported");
                        }
                        z3 = zG2;
                        method = methodH;
                    }
                    if (!z8 && method == null) {
                        ne2.l(field);
                    }
                    Type typeO = C$Gson$Types.o(typeToken2.getType(), rawType, field.getGenericType());
                    List listF = this.f(field);
                    int size = listF.size();
                    int i4 = z7;
                    while (i4 < size) {
                        String str = (String) listF.get(i4);
                        boolean z9 = i4 != 0 ? z7 : zG;
                        int i5 = i4;
                        c cVar2 = cVar;
                        int i6 = size;
                        List list = listF;
                        Field field2 = field;
                        int i7 = i3;
                        int i8 = length;
                        boolean z10 = z7;
                        cVar = cVar2 == null ? (c) linkedHashMap.put(str, d(qv0Var, field, method, str, TypeToken.get(typeO), z9, z3, z8)) : cVar2;
                        i4 = i5 + 1;
                        zG = z9;
                        i3 = i7;
                        size = i6;
                        listF = list;
                        field = field2;
                        length = i8;
                        z7 = z10;
                    }
                    c cVar3 = cVar;
                    Field field3 = field;
                    i = i3;
                    i2 = length;
                    z4 = z7;
                    if (cVar3 != null) {
                        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + cVar3.a + "'; conflict is caused by fields " + ne2.f(cVar3.b) + " and " + ne2.f(field3));
                    }
                } else {
                    i = i3;
                    i2 = length;
                    z4 = z7;
                }
                i3 = i + 1;
                z6 = true;
                this = this;
                length = i2;
                z7 = z4;
            }
            typeToken2 = TypeToken.get(C$Gson$Types.o(typeToken2.getType(), rawType, rawType.getGenericSuperclass()));
            rawType = typeToken2.getRawType();
            z5 = z8;
        }
        return linkedHashMap;
    }

    private List f(Field field) {
        xm2 xm2Var = (xm2) field.getAnnotation(xm2.class);
        if (xm2Var == null) {
            return Collections.singletonList(this.b.translateName(field));
        }
        String strValue = xm2Var.value();
        String[] strArrAlternate = xm2Var.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        Collections.addAll(arrayList, strArrAlternate);
        return arrayList;
    }

    private boolean g(Field field, boolean z) {
        return (this.c.c(field.getType(), z) || this.c.f(field, z)) ? false : true;
    }

    @Override // defpackage.f63
    public e63 a(qv0 qv0Var, TypeToken typeToken) {
        Class rawType = typeToken.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        ReflectionAccessFilter$FilterResult reflectionAccessFilter$FilterResultB = le2.b(this.e, rawType);
        if (reflectionAccessFilter$FilterResultB != ReflectionAccessFilter$FilterResult.BLOCK_ALL) {
            boolean z = reflectionAccessFilter$FilterResultB == ReflectionAccessFilter$FilterResult.BLOCK_INACCESSIBLE;
            return ne2.k(rawType) ? new e(rawType, e(qv0Var, typeToken, rawType, z, true), z) : new d(this.a.b(typeToken), e(qv0Var, typeToken, rawType, z, false));
        }
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + rawType + ". Register a TypeAdapter for this type or adjust the access filter.");
    }
}
