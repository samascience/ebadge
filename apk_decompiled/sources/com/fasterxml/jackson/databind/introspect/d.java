package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import defpackage.ay;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d extends i {
    private final TypeFactory d;
    private final h.a e;
    private final boolean f;

    private static final class a {
        public final m a;
        public final Field b;
        public AnnotationCollector c = AnnotationCollector.e();

        public a(m mVar, Field field) {
            this.a = mVar;
            this.b = field;
        }

        public AnnotatedField a() {
            return new AnnotatedField(this.a, this.b, this.c.b());
        }
    }

    d(AnnotationIntrospector annotationIntrospector, TypeFactory typeFactory, h.a aVar, boolean z) {
        super(annotationIntrospector);
        this.d = typeFactory;
        this.e = annotationIntrospector == null ? null : aVar;
        this.f = z;
    }

    private void i(Class cls, Class cls2, Map map) {
        a aVar;
        Iterator it = ay.x(cls, cls2, true).iterator();
        while (it.hasNext()) {
            for (Field field : ((Class) it.next()).getDeclaredFields()) {
                if (k(field) && (aVar = (a) map.get(field.getName())) != null) {
                    aVar.c = d(aVar.c, field.getDeclaredAnnotations());
                }
            }
        }
    }

    private Map j(m mVar, JavaType javaType, Map map) {
        h.a aVar;
        Class clsFindMixInClassFor;
        JavaType superClass = javaType.getSuperClass();
        if (superClass == null) {
            return map;
        }
        Class<?> rawClass = javaType.getRawClass();
        Map mapJ = j(new m.a(this.d, superClass.getBindings()), superClass, map);
        for (Field field : rawClass.getDeclaredFields()) {
            if (k(field)) {
                if (mapJ == null) {
                    mapJ = new LinkedHashMap();
                }
                a aVar2 = new a(mVar, field);
                if (this.f) {
                    aVar2.c = d(aVar2.c, field.getDeclaredAnnotations());
                }
                mapJ.put(field.getName(), aVar2);
            }
        }
        if (mapJ != null && (aVar = this.e) != null && (clsFindMixInClassFor = aVar.findMixInClassFor(rawClass)) != null) {
            i(clsFindMixInClassFor, rawClass, mapJ);
        }
        return mapJ;
    }

    private boolean k(Field field) {
        return (field.isSynthetic() || Modifier.isStatic(field.getModifiers())) ? false : true;
    }

    public static List m(AnnotationIntrospector annotationIntrospector, m mVar, h.a aVar, TypeFactory typeFactory, JavaType javaType, boolean z) {
        return new d(annotationIntrospector, typeFactory, aVar, z).l(mVar, javaType);
    }

    List l(m mVar, JavaType javaType) {
        Map mapJ = j(mVar, javaType, null);
        if (mapJ == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(mapJ.size());
        Iterator it = mapJ.values().iterator();
        while (it.hasNext()) {
            arrayList.add(((a) it.next()).a());
        }
        return arrayList;
    }
}
