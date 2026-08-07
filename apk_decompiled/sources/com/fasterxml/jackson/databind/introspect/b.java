package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.type.TypeBindings;
import defpackage.ay;
import defpackage.l7;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final l7 i = AnnotationCollector.d();
    private static final Class j = Object.class;
    private static final Class k = Enum.class;
    private static final Class l = List.class;
    private static final Class m = Map.class;
    private final MapperConfig a;
    private final AnnotationIntrospector b;
    private final h.a c;
    private final TypeBindings d;
    private final JavaType e;
    private final Class f;
    private final Class g;
    private final boolean h;

    b(MapperConfig mapperConfig, JavaType javaType, h.a aVar) {
        this.a = mapperConfig;
        this.e = javaType;
        Class<?> rawClass = javaType.getRawClass();
        this.f = rawClass;
        this.c = aVar;
        this.d = javaType.getBindings();
        AnnotationIntrospector annotationIntrospector = mapperConfig.isAnnotationProcessingEnabled() ? mapperConfig.getAnnotationIntrospector() : null;
        this.b = annotationIntrospector;
        this.g = aVar != null ? aVar.findMixInClassFor(rawClass) : null;
        this.h = (annotationIntrospector == null || (ay.M(rawClass) && javaType.isContainerType())) ? false : true;
    }

    private AnnotationCollector a(AnnotationCollector annotationCollector, Annotation[] annotationArr) {
        if (annotationArr != null) {
            for (Annotation annotation : annotationArr) {
                if (!annotationCollector.f(annotation)) {
                    annotationCollector = annotationCollector.a(annotation);
                    if (this.b.isAnnotationBundle(annotation)) {
                        annotationCollector = c(annotationCollector, annotation);
                    }
                }
            }
        }
        return annotationCollector;
    }

    private AnnotationCollector b(AnnotationCollector annotationCollector, Class cls, Class cls2) {
        if (cls2 != null) {
            annotationCollector = a(annotationCollector, ay.p(cls2));
            Iterator it = ay.x(cls2, cls, false).iterator();
            while (it.hasNext()) {
                annotationCollector = a(annotationCollector, ay.p((Class) it.next()));
            }
        }
        return annotationCollector;
    }

    private AnnotationCollector c(AnnotationCollector annotationCollector, Annotation annotation) {
        for (Annotation annotation2 : ay.p(annotation.annotationType())) {
            if (!(annotation2 instanceof Target) && !(annotation2 instanceof Retention) && !annotationCollector.f(annotation2)) {
                annotationCollector = annotationCollector.a(annotation2);
                if (this.b.isAnnotationBundle(annotation2)) {
                    annotationCollector = c(annotationCollector, annotation2);
                }
            }
        }
        return annotationCollector;
    }

    private static void d(JavaType javaType, List list, boolean z) {
        Class<?> rawClass = javaType.getRawClass();
        if (z) {
            if (f(list, rawClass)) {
                return;
            }
            list.add(javaType);
            if (rawClass == l || rawClass == m) {
                return;
            }
        }
        Iterator<JavaType> it = javaType.getInterfaces().iterator();
        while (it.hasNext()) {
            d(it.next(), list, true);
        }
    }

    private static void e(JavaType javaType, List list, boolean z) {
        Class<?> rawClass = javaType.getRawClass();
        if (rawClass == j || rawClass == k) {
            return;
        }
        if (z) {
            if (f(list, rawClass)) {
                return;
            } else {
                list.add(javaType);
            }
        }
        Iterator<JavaType> it = javaType.getInterfaces().iterator();
        while (it.hasNext()) {
            d(it.next(), list, true);
        }
        JavaType superClass = javaType.getSuperClass();
        if (superClass != null) {
            e(superClass, list, true);
        }
    }

    private static boolean f(List list, Class cls) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((JavaType) list.get(i2)).getRawClass() == cls) {
                return true;
            }
        }
        return false;
    }

    static a g(MapperConfig mapperConfig, Class cls) {
        return new a(cls);
    }

    static a h(Class cls) {
        return new a(cls);
    }

    public static a i(MapperConfig mapperConfig, JavaType javaType, h.a aVar) {
        return (javaType.isArrayType() && p(mapperConfig, javaType.getRawClass())) ? g(mapperConfig, javaType.getRawClass()) : new b(mapperConfig, javaType, aVar).k();
    }

    private l7 j(List list) {
        if (this.b == null) {
            return i;
        }
        h.a aVar = this.c;
        boolean z = aVar != null && (!(aVar instanceof SimpleMixInResolver) || ((SimpleMixInResolver) aVar).hasMixIns());
        if (!z && !this.h) {
            return i;
        }
        AnnotationCollector annotationCollectorE = AnnotationCollector.e();
        Class cls = this.g;
        if (cls != null) {
            annotationCollectorE = b(annotationCollectorE, this.f, cls);
        }
        if (this.h) {
            annotationCollectorE = a(annotationCollectorE, ay.p(this.f));
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            JavaType javaType = (JavaType) it.next();
            if (z) {
                Class<?> rawClass = javaType.getRawClass();
                annotationCollectorE = b(annotationCollectorE, rawClass, this.c.findMixInClassFor(rawClass));
            }
            if (this.h) {
                annotationCollectorE = a(annotationCollectorE, ay.p(javaType.getRawClass()));
            }
        }
        if (z) {
            annotationCollectorE = b(annotationCollectorE, Object.class, this.c.findMixInClassFor(Object.class));
        }
        return annotationCollectorE.c();
    }

    public static a m(MapperConfig mapperConfig, JavaType javaType, h.a aVar) {
        return (javaType.isArrayType() && p(mapperConfig, javaType.getRawClass())) ? g(mapperConfig, javaType.getRawClass()) : new b(mapperConfig, javaType, aVar).l();
    }

    public static a n(MapperConfig mapperConfig, Class cls) {
        return o(mapperConfig, cls, mapperConfig);
    }

    public static a o(MapperConfig mapperConfig, Class cls, h.a aVar) {
        return (cls.isArray() && p(mapperConfig, cls)) ? g(mapperConfig, cls) : new b(mapperConfig, cls, aVar).l();
    }

    private static boolean p(MapperConfig mapperConfig, Class cls) {
        return mapperConfig == null || mapperConfig.findMixInClassFor(cls) == null;
    }

    a k() {
        ArrayList arrayList = new ArrayList(8);
        if (!this.e.hasRawClass(Object.class)) {
            if (this.e.isInterface()) {
                d(this.e, arrayList, false);
            } else {
                e(this.e, arrayList, false);
            }
        }
        return new a(this.e, this.f, arrayList, this.g, j(arrayList), this.d, this.b, this.c, this.a.getTypeFactory(), this.h);
    }

    a l() {
        List listEmptyList = Collections.emptyList();
        return new a(null, this.f, listEmptyList, this.g, j(listEmptyList), this.d, this.b, this.c, this.a.getTypeFactory(), this.h);
    }

    b(MapperConfig mapperConfig, Class cls, h.a aVar) {
        this.a = mapperConfig;
        this.e = null;
        this.f = cls;
        this.c = aVar;
        this.d = TypeBindings.emptyBindings();
        if (mapperConfig == null) {
            this.b = null;
            this.g = null;
        } else {
            this.b = mapperConfig.isAnnotationProcessingEnabled() ? mapperConfig.getAnnotationIntrospector() : null;
            this.g = aVar != null ? aVar.findMixInClassFor(cls) : null;
        }
        this.h = this.b != null;
    }
}
