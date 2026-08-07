package defpackage;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.g;

/* JADX INFO: loaded from: classes.dex */
public final class w40 {
    protected final AnnotationIntrospector a;
    protected final AnnotatedWithParams b;
    protected final int c;
    protected final a[] d;

    public static final class a {
        public final AnnotatedParameter a;
        public final g b;
        public final JacksonInject.Value c;

        public a(AnnotatedParameter annotatedParameter, g gVar, JacksonInject.Value value) {
            this.a = annotatedParameter;
            this.b = gVar;
            this.c = value;
        }
    }

    protected w40(AnnotationIntrospector annotationIntrospector, AnnotatedWithParams annotatedWithParams, a[] aVarArr, int i) {
        this.a = annotationIntrospector;
        this.b = annotatedWithParams;
        this.d = aVarArr;
        this.c = i;
    }

    public static w40 a(AnnotationIntrospector annotationIntrospector, AnnotatedWithParams annotatedWithParams, g[] gVarArr) {
        int parameterCount = annotatedWithParams.getParameterCount();
        a[] aVarArr = new a[parameterCount];
        for (int i = 0; i < parameterCount; i++) {
            AnnotatedParameter parameter = annotatedWithParams.getParameter(i);
            aVarArr[i] = new a(parameter, gVarArr == null ? null : gVarArr[i], annotationIntrospector.findInjectableValue(parameter));
        }
        return new w40(annotationIntrospector, annotatedWithParams, aVarArr, parameterCount);
    }

    public AnnotatedWithParams b() {
        return this.b;
    }

    public PropertyName c(int i) {
        g gVar = this.d[i].b;
        if (gVar == null || !gVar.x()) {
            return null;
        }
        return gVar.getFullName();
    }

    public PropertyName d(int i) {
        String strFindImplicitPropertyName = this.a.findImplicitPropertyName(this.d[i].a);
        if (strFindImplicitPropertyName == null || strFindImplicitPropertyName.isEmpty()) {
            return null;
        }
        return PropertyName.construct(strFindImplicitPropertyName);
    }

    public int e() {
        int i = -1;
        for (int i2 = 0; i2 < this.c; i2++) {
            if (this.d[i2].c == null) {
                if (i >= 0) {
                    return -1;
                }
                i = i2;
            }
        }
        return i;
    }

    public JacksonInject.Value f(int i) {
        return this.d[i].c;
    }

    public int g() {
        return this.c;
    }

    public PropertyName h(int i) {
        g gVar = this.d[i].b;
        if (gVar != null) {
            return gVar.getFullName();
        }
        return null;
    }

    public AnnotatedParameter i(int i) {
        return this.d[i].a;
    }

    public g j(int i) {
        return this.d[i].b;
    }

    public String toString() {
        return this.b.toString();
    }
}
