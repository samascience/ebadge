package com.fasterxml.classmate;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Annotations implements Serializable, Iterable<Annotation> {
    private final Annotation[] NO_ANNOTATIONS = new Annotation[0];
    protected LinkedHashMap<Class<? extends Annotation>, Annotation> _annotations;

    public void add(Annotation annotation) {
        if (this._annotations == null) {
            this._annotations = new LinkedHashMap<>();
        }
        this._annotations.put(annotation.annotationType(), annotation);
    }

    public void addAll(Annotations annotations) {
        if (this._annotations == null) {
            this._annotations = new LinkedHashMap<>();
        }
        for (Annotation annotation : annotations._annotations.values()) {
            this._annotations.put(annotation.annotationType(), annotation);
        }
    }

    public void addAsDefault(Annotation annotation) {
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        LinkedHashMap<Class<? extends Annotation>, Annotation> linkedHashMap = this._annotations;
        if (linkedHashMap == null) {
            LinkedHashMap<Class<? extends Annotation>, Annotation> linkedHashMap2 = new LinkedHashMap<>();
            this._annotations = linkedHashMap2;
            linkedHashMap2.put(clsAnnotationType, annotation);
        } else {
            if (linkedHashMap.containsKey(clsAnnotationType)) {
                return;
            }
            this._annotations.put(clsAnnotationType, annotation);
        }
    }

    public Annotation[] asArray() {
        LinkedHashMap<Class<? extends Annotation>, Annotation> linkedHashMap = this._annotations;
        return (linkedHashMap == null || linkedHashMap.isEmpty()) ? this.NO_ANNOTATIONS : (Annotation[]) this._annotations.values().toArray(new Annotation[0]);
    }

    public List<Annotation> asList() {
        LinkedHashMap<Class<? extends Annotation>, Annotation> linkedHashMap = this._annotations;
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this._annotations.size());
        arrayList.addAll(this._annotations.values());
        return arrayList;
    }

    public <A extends Annotation> A get(Class<A> cls) {
        LinkedHashMap<Class<? extends Annotation>, Annotation> linkedHashMap = this._annotations;
        if (linkedHashMap == null) {
            return null;
        }
        return (A) linkedHashMap.get(cls);
    }

    @Override // java.lang.Iterable
    public Iterator<Annotation> iterator() {
        if (this._annotations == null) {
            this._annotations = new LinkedHashMap<>();
        }
        return this._annotations.values().iterator();
    }

    public int size() {
        LinkedHashMap<Class<? extends Annotation>, Annotation> linkedHashMap = this._annotations;
        if (linkedHashMap == null) {
            return 0;
        }
        return linkedHashMap.size();
    }

    public String toString() {
        LinkedHashMap<Class<? extends Annotation>, Annotation> linkedHashMap = this._annotations;
        return linkedHashMap == null ? "[null]" : linkedHashMap.toString();
    }
}
