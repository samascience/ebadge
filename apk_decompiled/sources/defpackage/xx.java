package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.j;
import kotlin.collections.u;
import kotlin.text.i;

/* JADX INFO: loaded from: classes4.dex */
public final class xx implements h81, ux {
    public static final a b = new a(null);
    private static final Map c;
    private static final HashMap d;
    private static final HashMap e;
    private static final HashMap f;
    private static final Map g;
    private final Class a;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x003b, code lost:
        
            if (r2 == null) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String a(java.lang.Class r7) {
            /*
                r6 = this;
                java.lang.String r0 = "jClass"
                defpackage.p31.f(r7, r0)
                boolean r0 = r7.isAnonymousClass()
                r1 = 0
                if (r0 == 0) goto Le
                goto Lb3
            Le:
                boolean r0 = r7.isLocalClass()
                if (r0 == 0) goto L6a
                java.lang.String r0 = r7.getSimpleName()
                java.lang.reflect.Method r2 = r7.getEnclosingMethod()
                r3 = 2
                r4 = 36
                if (r2 == 0) goto L41
                defpackage.p31.c(r0)
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r2 = r2.getName()
                r5.append(r2)
                r5.append(r4)
                java.lang.String r2 = r5.toString()
                java.lang.String r2 = kotlin.text.i.F0(r0, r2, r1, r3, r1)
                if (r2 != 0) goto L3e
                goto L41
            L3e:
                r1 = r2
                goto Lb3
            L41:
                java.lang.reflect.Constructor r7 = r7.getEnclosingConstructor()
                if (r7 == 0) goto L62
                defpackage.p31.c(r0)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r7 = r7.getName()
                r2.append(r7)
                r2.append(r4)
                java.lang.String r7 = r2.toString()
                java.lang.String r1 = kotlin.text.i.F0(r0, r7, r1, r3, r1)
                goto Lb3
            L62:
                defpackage.p31.c(r0)
                java.lang.String r1 = kotlin.text.i.E0(r0, r4, r1, r3, r1)
                goto Lb3
            L6a:
                boolean r0 = r7.isArray()
                if (r0 == 0) goto L9e
                java.lang.Class r7 = r7.getComponentType()
                boolean r0 = r7.isPrimitive()
                java.lang.String r2 = "Array"
                if (r0 == 0) goto L9b
                java.util.Map r0 = defpackage.xx.e()
                java.lang.String r7 = r7.getName()
                java.lang.Object r7 = r0.get(r7)
                java.lang.String r7 = (java.lang.String) r7
                if (r7 == 0) goto L9b
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r7)
                r0.append(r2)
                java.lang.String r1 = r0.toString()
            L9b:
                if (r1 != 0) goto Lb3
                goto L3e
            L9e:
                java.util.Map r0 = defpackage.xx.e()
                java.lang.String r1 = r7.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 != 0) goto Lb3
                java.lang.String r1 = r7.getSimpleName()
            Lb3:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: xx.a.a(java.lang.Class):java.lang.String");
        }

        public final boolean b(Object obj, Class cls) {
            p31.f(cls, "jClass");
            Map map = xx.c;
            p31.d(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(cls);
            if (num != null) {
                return p63.c(obj, num.intValue());
            }
            if (cls.isPrimitive()) {
                cls = c81.b(c81.c(cls));
            }
            return cls.isInstance(obj);
        }

        private a() {
        }
    }

    static {
        List listM = j.m(yq0.class, ar0.class, or0.class, pr0.class, qr0.class, rr0.class, sr0.class, tr0.class, ur0.class, vr0.class, zq0.class, br0.class, cr0.class, dr0.class, er0.class, fr0.class, gr0.class, hr0.class, ir0.class, jr0.class, lr0.class, mr0.class, nr0.class);
        ArrayList arrayList = new ArrayList(j.t(listM, 10));
        int i = 0;
        for (Object obj : listM) {
            int i2 = i + 1;
            if (i < 0) {
                j.s();
            }
            arrayList.add(d63.a((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        c = u.l(arrayList);
        HashMap map = new HashMap();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        d = map;
        HashMap map2 = new HashMap();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        e = map2;
        HashMap map3 = new HashMap();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        p31.e(collectionValues, "<get-values>(...)");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            p31.c(str);
            sb.append(i.H0(str, '.', null, 2, null));
            sb.append("CompanionObject");
            Pair pairA = d63.a(sb.toString(), str + ".Companion");
            map3.put(pairA.getFirst(), pairA.getSecond());
        }
        for (Map.Entry entry : c.entrySet()) {
            map3.put(((Class) entry.getKey()).getName(), "kotlin.Function" + ((Number) entry.getValue()).intValue());
        }
        f = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(u.c(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            Object key = entry2.getKey();
            String str2 = (String) entry2.getValue();
            p31.c(str2);
            linkedHashMap.put(key, i.H0(str2, '.', null, 2, null));
        }
        g = linkedHashMap;
    }

    public xx(Class cls) {
        p31.f(cls, "jClass");
        this.a = cls;
    }

    @Override // defpackage.h81
    public String a() {
        return b.a(c());
    }

    @Override // defpackage.h81
    public boolean b(Object obj) {
        return b.b(obj, c());
    }

    @Override // defpackage.ux
    public Class c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof xx) && p31.a(c81.b(this), c81.b((h81) obj));
    }

    public int hashCode() {
        return c81.b(this).hashCode();
    }

    public String toString() {
        return c() + " (Kotlin reflection is not available)";
    }
}
