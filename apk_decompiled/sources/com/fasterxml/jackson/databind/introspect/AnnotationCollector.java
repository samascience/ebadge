package com.fasterxml.jackson.databind.introspect;

import defpackage.l7;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class AnnotationCollector {
    protected static final l7 b = new NoAnnotations();
    protected final Object a;

    public static class NoAnnotations implements l7, Serializable {
        private static final long serialVersionUID = 1;

        NoAnnotations() {
        }

        @Override // defpackage.l7
        public <A extends Annotation> A get(Class<A> cls) {
            return null;
        }

        @Override // defpackage.l7
        public boolean has(Class<?> cls) {
            return false;
        }

        @Override // defpackage.l7
        public boolean hasOneOf(Class<? extends Annotation>[] clsArr) {
            return false;
        }

        @Override // defpackage.l7
        public int size() {
            return 0;
        }
    }

    public static class OneAnnotation implements l7, Serializable {
        private static final long serialVersionUID = 1;
        private final Class<?> _type;
        private final Annotation _value;

        public OneAnnotation(Class<?> cls, Annotation annotation) {
            this._type = cls;
            this._value = annotation;
        }

        @Override // defpackage.l7
        public <A extends Annotation> A get(Class<A> cls) {
            if (this._type == cls) {
                return (A) this._value;
            }
            return null;
        }

        @Override // defpackage.l7
        public boolean has(Class<?> cls) {
            return this._type == cls;
        }

        @Override // defpackage.l7
        public boolean hasOneOf(Class<? extends Annotation>[] clsArr) {
            for (Class<? extends Annotation> cls : clsArr) {
                if (cls == this._type) {
                    return true;
                }
            }
            return false;
        }

        @Override // defpackage.l7
        public int size() {
            return 1;
        }
    }

    public static class TwoAnnotations implements l7, Serializable {
        private static final long serialVersionUID = 1;
        private final Class<?> _type1;
        private final Class<?> _type2;
        private final Annotation _value1;
        private final Annotation _value2;

        public TwoAnnotations(Class<?> cls, Annotation annotation, Class<?> cls2, Annotation annotation2) {
            this._type1 = cls;
            this._value1 = annotation;
            this._type2 = cls2;
            this._value2 = annotation2;
        }

        @Override // defpackage.l7
        public <A extends Annotation> A get(Class<A> cls) {
            if (this._type1 == cls) {
                return (A) this._value1;
            }
            if (this._type2 == cls) {
                return (A) this._value2;
            }
            return null;
        }

        @Override // defpackage.l7
        public boolean has(Class<?> cls) {
            return this._type1 == cls || this._type2 == cls;
        }

        @Override // defpackage.l7
        public boolean hasOneOf(Class<? extends Annotation>[] clsArr) {
            for (Class<? extends Annotation> cls : clsArr) {
                if (cls == this._type1 || cls == this._type2) {
                    return true;
                }
            }
            return false;
        }

        @Override // defpackage.l7
        public int size() {
            return 2;
        }
    }

    static class a extends AnnotationCollector {
        public static final a c = new a(null);

        a(Object obj) {
            super(obj);
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public AnnotationCollector a(Annotation annotation) {
            return new c(this.a, annotation.annotationType(), annotation);
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public f b() {
            return new f();
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public l7 c() {
            return AnnotationCollector.b;
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public boolean f(Annotation annotation) {
            return false;
        }
    }

    static class b extends AnnotationCollector {
        protected final HashMap c;

        public b(Object obj, Class cls, Annotation annotation, Class cls2, Annotation annotation2) {
            super(obj);
            HashMap map = new HashMap();
            this.c = map;
            map.put(cls, annotation);
            map.put(cls2, annotation2);
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public AnnotationCollector a(Annotation annotation) {
            this.c.put(annotation.annotationType(), annotation);
            return this;
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public f b() {
            f fVar = new f();
            Iterator it = this.c.values().iterator();
            while (it.hasNext()) {
                fVar.b((Annotation) it.next());
            }
            return fVar;
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public l7 c() {
            if (this.c.size() != 2) {
                return new f(this.c);
            }
            Iterator it = this.c.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it.next();
            return new TwoAnnotations((Class) entry.getKey(), (Annotation) entry.getValue(), (Class) entry2.getKey(), (Annotation) entry2.getValue());
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public boolean f(Annotation annotation) {
            return this.c.containsKey(annotation.annotationType());
        }
    }

    static class c extends AnnotationCollector {
        private Class c;
        private Annotation d;

        public c(Object obj, Class cls, Annotation annotation) {
            super(obj);
            this.c = cls;
            this.d = annotation;
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public AnnotationCollector a(Annotation annotation) {
            Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
            Class<? extends Annotation> cls = this.c;
            if (cls != clsAnnotationType) {
                return new b(this.a, cls, this.d, clsAnnotationType, annotation);
            }
            this.d = annotation;
            return this;
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public f b() {
            return f.e(this.c, this.d);
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public l7 c() {
            return new OneAnnotation(this.c, this.d);
        }

        @Override // com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public boolean f(Annotation annotation) {
            return annotation.annotationType() == this.c;
        }
    }

    protected AnnotationCollector(Object obj) {
        this.a = obj;
    }

    public static l7 d() {
        return b;
    }

    public static AnnotationCollector e() {
        return a.c;
    }

    public abstract AnnotationCollector a(Annotation annotation);

    public abstract f b();

    public abstract l7 c();

    public abstract boolean f(Annotation annotation);
}
