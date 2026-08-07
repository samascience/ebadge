package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import defpackage.ay;
import defpackage.f7;
import defpackage.hi1;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e extends i {
    private final h.a d;
    private final boolean e;

    private static final class a {
        public m a;
        public Method b;
        public AnnotationCollector c;

        public a(m mVar, Method method, AnnotationCollector annotationCollector) {
            this.a = mVar;
            this.b = method;
            this.c = annotationCollector;
        }

        public AnnotatedMethod a() {
            Method method = this.b;
            if (method == null) {
                return null;
            }
            return new AnnotatedMethod(this.a, method, this.c.b(), null);
        }
    }

    e(AnnotationIntrospector annotationIntrospector, h.a aVar, boolean z) {
        super(annotationIntrospector);
        this.d = annotationIntrospector == null ? null : aVar;
        this.e = z;
    }

    private void i(m mVar, Class cls, Map map, Class cls2) {
        if (cls2 != null) {
            j(mVar, cls, map, cls2);
        }
        if (cls == null) {
            return;
        }
        for (Method method : ay.z(cls)) {
            if (k(method)) {
                hi1 hi1Var = new hi1(method);
                a aVar = (a) map.get(hi1Var);
                if (aVar == null) {
                    map.put(hi1Var, new a(mVar, method, this.a == null ? AnnotationCollector.e() : e(method.getDeclaredAnnotations())));
                } else {
                    if (this.e) {
                        aVar.c = f(aVar.c, method.getDeclaredAnnotations());
                    }
                    Method method2 = aVar.b;
                    if (method2 == null) {
                        aVar.b = method;
                    } else if (Modifier.isAbstract(method2.getModifiers()) && !Modifier.isAbstract(method.getModifiers())) {
                        aVar.b = method;
                        aVar.a = mVar;
                    }
                }
            }
        }
    }

    private static boolean k(Method method) {
        return (Modifier.isStatic(method.getModifiers()) || method.isSynthetic() || method.isBridge() || method.getParameterCount() > 2) ? false : true;
    }

    public static f7 m(AnnotationIntrospector annotationIntrospector, m mVar, h.a aVar, TypeFactory typeFactory, JavaType javaType, List list, Class cls, boolean z) {
        return new e(annotationIntrospector, aVar, z).l(typeFactory, mVar, javaType, list, cls);
    }

    protected void j(m mVar, Class cls, Map map, Class cls2) {
        if (this.a == null) {
            return;
        }
        Iterator it = ay.w(cls2, cls, true).iterator();
        while (it.hasNext()) {
            for (Method method : ((Class) it.next()).getDeclaredMethods()) {
                if (k(method)) {
                    hi1 hi1Var = new hi1(method);
                    a aVar = (a) map.get(hi1Var);
                    Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                    if (aVar == null) {
                        map.put(hi1Var, new a(mVar, null, e(declaredAnnotations)));
                    } else {
                        aVar.c = f(aVar.c, declaredAnnotations);
                    }
                }
            }
        }
    }

    f7 l(TypeFactory typeFactory, m mVar, JavaType javaType, List list, Class cls) {
        Class clsFindMixInClassFor;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        i(mVar, javaType.getRawClass(), linkedHashMap, cls);
        Iterator it = list.iterator();
        while (true) {
            Class clsFindMixInClassFor2 = null;
            if (!it.hasNext()) {
                break;
            }
            JavaType javaType2 = (JavaType) it.next();
            h.a aVar = this.d;
            if (aVar != null) {
                clsFindMixInClassFor2 = aVar.findMixInClassFor(javaType2.getRawClass());
            }
            i(new m.a(typeFactory, javaType2.getBindings()), javaType2.getRawClass(), linkedHashMap, clsFindMixInClassFor2);
        }
        h.a aVar2 = this.d;
        if (aVar2 != null && (clsFindMixInClassFor = aVar2.findMixInClassFor(Object.class)) != null) {
            j(mVar, javaType.getRawClass(), linkedHashMap, clsFindMixInClassFor);
            if (this.a != null && !linkedHashMap.isEmpty()) {
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    hi1 hi1Var = (hi1) entry.getKey();
                    if ("hashCode".equals(hi1Var.b()) && hi1Var.a() == 0) {
                        try {
                            Method declaredMethod = Object.class.getDeclaredMethod(hi1Var.b(), null);
                            if (declaredMethod != null) {
                                a aVar3 = (a) entry.getValue();
                                aVar3.c = f(aVar3.c, declaredMethod.getDeclaredAnnotations());
                                aVar3.b = declaredMethod;
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        if (linkedHashMap.isEmpty()) {
            return new f7();
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap.size());
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            AnnotatedMethod annotatedMethodA = ((a) entry2.getValue()).a();
            if (annotatedMethodA != null) {
                linkedHashMap2.put(entry2.getKey(), annotatedMethodA);
            }
        }
        return new f7(linkedHashMap2);
    }
}
