package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import defpackage.in1;
import defpackage.lt1;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class g implements in1 {
    protected static final JsonInclude.Value a = JsonInclude.Value.empty();

    public boolean a() {
        return m() != null;
    }

    public boolean b() {
        return h() != null;
    }

    public abstract JsonInclude.Value c();

    public lt1 d() {
        return null;
    }

    public String e() {
        AnnotationIntrospector.ReferenceProperty referencePropertyF = f();
        if (referencePropertyF == null) {
            return null;
        }
        return referencePropertyF.b();
    }

    public AnnotationIntrospector.ReferenceProperty f() {
        return null;
    }

    public Class[] g() {
        return null;
    }

    public abstract PropertyName getFullName();

    public abstract PropertyMetadata getMetadata();

    @Override // defpackage.in1
    public abstract String getName();

    public abstract PropertyName getWrapperName();

    public AnnotatedMember h() {
        AnnotatedMethod annotatedMethodL = l();
        return annotatedMethodL == null ? k() : annotatedMethodL;
    }

    public abstract AnnotatedParameter i();

    public abstract Iterator j();

    public abstract AnnotatedField k();

    public abstract AnnotatedMethod l();

    public AnnotatedMember m() {
        AnnotatedParameter annotatedParameterI = i();
        if (annotatedParameterI != null) {
            return annotatedParameterI;
        }
        AnnotatedMethod annotatedMethodR = r();
        return annotatedMethodR == null ? k() : annotatedMethodR;
    }

    public AnnotatedMember n() {
        AnnotatedMethod annotatedMethodR = r();
        return annotatedMethodR == null ? k() : annotatedMethodR;
    }

    public abstract AnnotatedMember o();

    public abstract JavaType p();

    public abstract Class q();

    public abstract AnnotatedMethod r();

    public abstract boolean s();

    public abstract boolean t();

    public abstract boolean u(PropertyName propertyName);

    public abstract boolean v();

    public abstract boolean w();

    public abstract boolean x();

    public boolean y() {
        return false;
    }
}
