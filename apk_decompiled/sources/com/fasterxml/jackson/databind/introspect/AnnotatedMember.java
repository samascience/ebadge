package com.fasterxml.jackson.databind.introspect;

import defpackage.ay;
import defpackage.d7;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public abstract class AnnotatedMember extends d7 implements Serializable {
    private static final long serialVersionUID = 1;
    protected final transient f _annotations;
    protected final transient m _typeContext;

    protected AnnotatedMember(m mVar, f fVar) {
        this._typeContext = mVar;
        this._annotations = fVar;
    }

    @Deprecated
    public Iterable<Annotation> annotations() {
        f fVar = this._annotations;
        return fVar == null ? Collections.emptyList() : fVar.c();
    }

    public final void fixAccess(boolean z) {
        Member member = getMember();
        if (member != null) {
            ay.g(member, z);
        }
    }

    public f getAllAnnotations() {
        return this._annotations;
    }

    @Override // defpackage.d7
    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        f fVar = this._annotations;
        if (fVar == null) {
            return null;
        }
        return (A) fVar.get(cls);
    }

    public abstract Class<?> getDeclaringClass();

    public String getFullName() {
        return getDeclaringClass().getName() + "#" + getName();
    }

    public abstract Member getMember();

    @Deprecated
    public m getTypeContext() {
        return this._typeContext;
    }

    public abstract Object getValue(Object obj) throws UnsupportedOperationException, IllegalArgumentException;

    @Override // defpackage.d7
    public final boolean hasAnnotation(Class<?> cls) {
        f fVar = this._annotations;
        if (fVar == null) {
            return false;
        }
        return fVar.has(cls);
    }

    @Override // defpackage.d7
    public boolean hasOneOf(Class<? extends Annotation>[] clsArr) {
        f fVar = this._annotations;
        if (fVar == null) {
            return false;
        }
        return fVar.hasOneOf(clsArr);
    }

    public abstract void setValue(Object obj, Object obj2) throws UnsupportedOperationException, IllegalArgumentException;

    public abstract d7 withAnnotations(f fVar);

    protected AnnotatedMember(AnnotatedMember annotatedMember) {
        this._typeContext = annotatedMember._typeContext;
        this._annotations = annotatedMember._annotations;
    }
}
