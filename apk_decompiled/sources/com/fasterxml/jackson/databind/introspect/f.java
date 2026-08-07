package com.fasterxml.jackson.databind.introspect;

import defpackage.l7;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class f implements l7 {
    protected HashMap a;

    public f() {
    }

    public static f d(f fVar, f fVar2) {
        HashMap map;
        HashMap map2;
        if (fVar == null || (map = fVar.a) == null || map.isEmpty()) {
            return fVar2;
        }
        if (fVar2 == null || (map2 = fVar2.a) == null || map2.isEmpty()) {
            return fVar;
        }
        HashMap map3 = new HashMap();
        for (Annotation annotation : fVar2.a.values()) {
            map3.put(annotation.annotationType(), annotation);
        }
        for (Annotation annotation2 : fVar.a.values()) {
            map3.put(annotation2.annotationType(), annotation2);
        }
        return new f(map3);
    }

    public static f e(Class cls, Annotation annotation) {
        HashMap map = new HashMap(4);
        map.put(cls, annotation);
        return new f(map);
    }

    protected final boolean a(Annotation annotation) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        Annotation annotation2 = (Annotation) this.a.put(annotation.annotationType(), annotation);
        return annotation2 == null || !annotation2.equals(annotation);
    }

    public boolean b(Annotation annotation) {
        return a(annotation);
    }

    public Iterable c() {
        HashMap map = this.a;
        return (map == null || map.size() == 0) ? Collections.emptyList() : this.a.values();
    }

    @Override // defpackage.l7
    public Annotation get(Class cls) {
        HashMap map = this.a;
        if (map == null) {
            return null;
        }
        return (Annotation) map.get(cls);
    }

    @Override // defpackage.l7
    public boolean has(Class cls) {
        HashMap map = this.a;
        if (map == null) {
            return false;
        }
        return map.containsKey(cls);
    }

    @Override // defpackage.l7
    public boolean hasOneOf(Class[] clsArr) {
        if (this.a != null) {
            for (Class cls : clsArr) {
                if (this.a.containsKey(cls)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // defpackage.l7
    public int size() {
        HashMap map = this.a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public String toString() {
        HashMap map = this.a;
        return map == null ? "[null]" : map.toString();
    }

    f(HashMap map) {
        this.a = map;
    }
}
