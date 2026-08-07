package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public final a a;
    public final Object b;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.a$a, reason: collision with other inner class name */
    static final class C0068a extends a {
        final SettableAnyProperty c;
        final String d;

        public C0068a(a aVar, Object obj, SettableAnyProperty settableAnyProperty, String str) {
            super(aVar, obj);
            this.c = settableAnyProperty;
            this.d = str;
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.a
        public void a(Object obj) throws IOException {
            this.c.set(obj, this.d, this.b);
        }
    }

    static final class b extends a {
        final Object c;

        public b(a aVar, Object obj, Object obj2) {
            super(aVar, obj);
            this.c = obj2;
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.a
        public void a(Object obj) {
            ((Map) obj).put(this.c, this.b);
        }
    }

    static final class c extends a {
        final SettableBeanProperty c;

        public c(a aVar, Object obj, SettableBeanProperty settableBeanProperty) {
            super(aVar, obj);
            this.c = settableBeanProperty;
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.a
        public void a(Object obj) throws IOException {
            this.c.set(obj, this.b);
        }
    }

    protected a(a aVar, Object obj) {
        this.a = aVar;
        this.b = obj;
    }

    public abstract void a(Object obj);
}
