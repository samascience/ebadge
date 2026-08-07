package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public abstract class AnnotatedWithParams extends AnnotatedMember {
    private static final long serialVersionUID = 1;
    protected final f[] _paramAnnotations;

    protected AnnotatedWithParams(m mVar, f fVar, f[] fVarArr) {
        super(mVar, fVar);
        this._paramAnnotations = fVarArr;
    }

    public final void addOrOverrideParam(int i, Annotation annotation) {
        f fVar = this._paramAnnotations[i];
        if (fVar == null) {
            fVar = new f();
            this._paramAnnotations[i] = fVar;
        }
        fVar.b(annotation);
    }

    public abstract Object call() throws Exception;

    public abstract Object call(Object[] objArr) throws Exception;

    public abstract Object call1(Object obj) throws Exception;

    public final int getAnnotationCount() {
        return this._annotations.size();
    }

    @Deprecated
    public abstract Type getGenericParameterType(int i);

    public final AnnotatedParameter getParameter(int i) {
        return new AnnotatedParameter(this, getParameterType(i), this._typeContext, getParameterAnnotations(i), i);
    }

    public final f getParameterAnnotations(int i) {
        f[] fVarArr = this._paramAnnotations;
        if (fVarArr == null || i < 0 || i >= fVarArr.length) {
            return null;
        }
        return fVarArr[i];
    }

    public abstract int getParameterCount();

    public abstract JavaType getParameterType(int i);

    public abstract Class<?> getRawParameterType(int i);

    protected AnnotatedParameter replaceParameterAnnotations(int i, f fVar) {
        this._paramAnnotations[i] = fVar;
        return getParameter(i);
    }

    protected AnnotatedWithParams(AnnotatedWithParams annotatedWithParams, f[] fVarArr) {
        super(annotatedWithParams);
        this._paramAnnotations = fVarArr;
    }
}
