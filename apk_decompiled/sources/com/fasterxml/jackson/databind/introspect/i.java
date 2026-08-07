package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import defpackage.ay;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
abstract class i {
    protected static final f[] b = new f[0];
    protected static final Annotation[] c = new Annotation[0];
    protected final AnnotationIntrospector a;

    protected i(AnnotationIntrospector annotationIntrospector) {
        this.a = annotationIntrospector;
    }

    static f a() {
        return new f();
    }

    static f[] b(int i) {
        if (i == 0) {
            return b;
        }
        f[] fVarArr = new f[i];
        for (int i2 = 0; i2 < i; i2++) {
            fVarArr[i2] = a();
        }
        return fVarArr;
    }

    protected static final boolean c(Annotation annotation) {
        return (annotation instanceof Target) || (annotation instanceof Retention);
    }

    protected final AnnotationCollector d(AnnotationCollector annotationCollector, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            annotationCollector = annotationCollector.a(annotation);
            if (this.a.isAnnotationBundle(annotation)) {
                annotationCollector = h(annotationCollector, annotation);
            }
        }
        return annotationCollector;
    }

    protected final AnnotationCollector e(Annotation[] annotationArr) {
        AnnotationCollector annotationCollectorE = AnnotationCollector.e();
        for (Annotation annotation : annotationArr) {
            annotationCollectorE = annotationCollectorE.a(annotation);
            if (this.a.isAnnotationBundle(annotation)) {
                annotationCollectorE = h(annotationCollectorE, annotation);
            }
        }
        return annotationCollectorE;
    }

    protected final AnnotationCollector f(AnnotationCollector annotationCollector, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            if (!annotationCollector.f(annotation)) {
                annotationCollector = annotationCollector.a(annotation);
                if (this.a.isAnnotationBundle(annotation)) {
                    annotationCollector = g(annotationCollector, annotation);
                }
            }
        }
        return annotationCollector;
    }

    protected final AnnotationCollector g(AnnotationCollector annotationCollector, Annotation annotation) {
        for (Annotation annotation2 : ay.p(annotation.annotationType())) {
            if (!c(annotation2) && !annotationCollector.f(annotation2)) {
                annotationCollector = annotationCollector.a(annotation2);
                if (this.a.isAnnotationBundle(annotation2)) {
                    annotationCollector = h(annotationCollector, annotation2);
                }
            }
        }
        return annotationCollector;
    }

    protected final AnnotationCollector h(AnnotationCollector annotationCollector, Annotation annotation) {
        for (Annotation annotation2 : ay.p(annotation.annotationType())) {
            if (!c(annotation2)) {
                if (!this.a.isAnnotationBundle(annotation2)) {
                    annotationCollector = annotationCollector.a(annotation2);
                } else if (!annotationCollector.f(annotation2)) {
                    annotationCollector = h(annotationCollector.a(annotation2), annotation2);
                }
            }
        }
        return annotationCollector;
    }
}
