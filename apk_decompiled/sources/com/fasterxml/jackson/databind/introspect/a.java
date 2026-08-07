package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;
import defpackage.ay;
import defpackage.d7;
import defpackage.f7;
import defpackage.l7;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a extends d7 implements m {
    private static final C0069a o = new C0069a(null, Collections.emptyList(), Collections.emptyList());
    protected final JavaType a;
    protected final Class b;
    protected final TypeBindings c;
    protected final List d;
    protected final AnnotationIntrospector e;
    protected final TypeFactory f;
    protected final h.a g;
    protected final Class h;
    protected final boolean i;
    protected final l7 j;
    protected C0069a k;
    protected f7 l;
    protected List m;
    protected transient Boolean n;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.introspect.a$a, reason: collision with other inner class name */
    public static final class C0069a {
        public final AnnotatedConstructor a;
        public final List b;
        public final List c;

        public C0069a(AnnotatedConstructor annotatedConstructor, List list, List list2) {
            this.a = annotatedConstructor;
            this.b = list;
            this.c = list2;
        }
    }

    a(JavaType javaType, Class cls, List list, Class cls2, l7 l7Var, TypeBindings typeBindings, AnnotationIntrospector annotationIntrospector, h.a aVar, TypeFactory typeFactory, boolean z) {
        this.a = javaType;
        this.b = cls;
        this.d = list;
        this.h = cls2;
        this.j = l7Var;
        this.c = typeBindings;
        this.e = annotationIntrospector;
        this.g = aVar;
        this.f = typeFactory;
        this.i = z;
    }

    private final C0069a b() {
        C0069a c0069aP = this.k;
        if (c0069aP == null) {
            JavaType javaType = this.a;
            c0069aP = javaType == null ? o : c.p(this.e, this.f, this, javaType, this.h, this.i);
            this.k = c0069aP;
        }
        return c0069aP;
    }

    private final List c() {
        List listEmptyList = this.m;
        if (listEmptyList == null) {
            JavaType javaType = this.a;
            listEmptyList = javaType == null ? Collections.emptyList() : d.m(this.e, this, this.g, this.f, javaType, this.i);
            this.m = listEmptyList;
        }
        return listEmptyList;
    }

    private final f7 d() {
        f7 f7Var = this.l;
        if (f7Var == null) {
            JavaType javaType = this.a;
            f7Var = javaType == null ? new f7() : e.m(this.e, this, this.g, this.f, javaType, this.d, this.h, this.i);
            this.l = f7Var;
        }
        return f7Var;
    }

    @Override // com.fasterxml.jackson.databind.introspect.m
    public JavaType a(Type type) {
        return this.f.resolveMemberType(type, this.c);
    }

    public Iterable e() {
        return c();
    }

    @Override // defpackage.d7
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return ay.H(obj, a.class) && ((a) obj).b == this.b;
    }

    public AnnotatedMethod f(String str, Class[] clsArr) {
        return d().a(str, clsArr);
    }

    @Override // defpackage.d7
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Class getAnnotated() {
        return this.b;
    }

    @Override // defpackage.d7
    public Annotation getAnnotation(Class cls) {
        return this.j.get(cls);
    }

    @Override // defpackage.d7
    public int getModifiers() {
        return this.b.getModifiers();
    }

    @Override // defpackage.d7
    public String getName() {
        return this.b.getName();
    }

    @Override // defpackage.d7
    public Class getRawType() {
        return this.b;
    }

    @Override // defpackage.d7
    public JavaType getType() {
        return this.a;
    }

    public l7 h() {
        return this.j;
    }

    @Override // defpackage.d7
    public boolean hasAnnotation(Class cls) {
        return this.j.has(cls);
    }

    @Override // defpackage.d7
    public boolean hasOneOf(Class[] clsArr) {
        return this.j.hasOneOf(clsArr);
    }

    @Override // defpackage.d7
    public int hashCode() {
        return this.b.getName().hashCode();
    }

    public List i() {
        return b().b;
    }

    public AnnotatedConstructor j() {
        return b().a;
    }

    public List k() {
        return b().c;
    }

    public boolean l() {
        return this.j.size() > 0;
    }

    public boolean m() {
        Boolean boolValueOf = this.n;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ay.Q(this.b));
            this.n = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    public Iterable n() {
        return d();
    }

    @Override // defpackage.d7
    public String toString() {
        return "[AnnotedClass " + this.b.getName() + "]";
    }

    a(Class cls) {
        this.a = null;
        this.b = cls;
        this.d = Collections.emptyList();
        this.h = null;
        this.j = AnnotationCollector.d();
        this.c = TypeBindings.emptyBindings();
        this.e = null;
        this.g = null;
        this.f = null;
        this.i = false;
    }
}
