package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class c {
    protected final ObjectIdGenerator.IdKey a;
    protected LinkedList b;

    public c(ObjectIdGenerator.IdKey idKey) {
        this.a = idKey;
    }

    public void a(a aVar) {
        if (this.b == null) {
            this.b = new LinkedList();
        }
        this.b.add(aVar);
    }

    public void b(Object obj) {
        throw null;
    }

    public ObjectIdGenerator.IdKey c() {
        return this.a;
    }

    public boolean d() {
        LinkedList linkedList = this.b;
        return (linkedList == null || linkedList.isEmpty()) ? false : true;
    }

    public Iterator e() {
        LinkedList linkedList = this.b;
        return linkedList == null ? Collections.emptyList().iterator() : linkedList.iterator();
    }

    public Object f() {
        throw null;
    }

    public void g(com.fasterxml.jackson.annotation.a aVar) {
    }

    public boolean h(DeserializationContext deserializationContext) {
        return false;
    }

    public String toString() {
        return String.valueOf(this.a);
    }

    public static abstract class a {
        private final UnresolvedForwardReference a;
        private final Class b;

        public a(UnresolvedForwardReference unresolvedForwardReference, Class cls) {
            this.a = unresolvedForwardReference;
            this.b = cls;
        }

        public Class a() {
            return this.b;
        }

        public JsonLocation b() {
            return this.a.getLocation();
        }

        public a(UnresolvedForwardReference unresolvedForwardReference, JavaType javaType) {
            this.a = unresolvedForwardReference;
            this.b = javaType.getRawClass();
        }
    }
}
