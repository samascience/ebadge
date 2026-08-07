package defpackage;

import com.fasterxml.jackson.databind.JavaType;

/* JADX INFO: loaded from: classes.dex */
public class q63 {
    protected int a;
    protected Class b;
    protected JavaType c;
    protected boolean d;

    public q63(Class cls, boolean z) {
        this.b = cls;
        this.c = null;
        this.d = z;
        this.a = z ? e(cls) : g(cls);
    }

    public static final int d(JavaType javaType) {
        return javaType.hashCode() - 2;
    }

    public static final int e(Class cls) {
        return cls.getName().hashCode() + 1;
    }

    public static final int f(JavaType javaType) {
        return javaType.hashCode() - 1;
    }

    public static final int g(Class cls) {
        return cls.getName().hashCode();
    }

    public Class a() {
        return this.b;
    }

    public JavaType b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        q63 q63Var = (q63) obj;
        if (q63Var.d != this.d) {
            return false;
        }
        Class cls = this.b;
        if (cls != null) {
            return q63Var.b == cls;
        }
        return this.c.equals(q63Var.c);
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        if (this.b != null) {
            return "{class: " + this.b.getName() + ", typed? " + this.d + "}";
        }
        return "{type: " + this.c + ", typed? " + this.d + "}";
    }

    public q63(JavaType javaType, boolean z) {
        this.c = javaType;
        this.b = null;
        this.d = z;
        this.a = z ? d(javaType) : f(javaType);
    }
}
