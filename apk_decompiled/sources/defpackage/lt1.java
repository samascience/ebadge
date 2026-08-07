package defpackage;

import com.fasterxml.jackson.annotation.b;
import com.fasterxml.jackson.databind.PropertyName;

/* JADX INFO: loaded from: classes.dex */
public class lt1 {
    private static final lt1 f = new lt1(PropertyName.NO_NAME, Object.class, null, false, null);
    protected final PropertyName a;
    protected final Class b;
    protected final Class c;
    protected final Class d;
    protected final boolean e;

    public lt1(PropertyName propertyName, Class cls, Class cls2, Class cls3) {
        this(propertyName, cls, cls2, false, cls3);
    }

    public static lt1 a() {
        return f;
    }

    public boolean b() {
        return this.e;
    }

    public Class c() {
        return this.b;
    }

    public PropertyName d() {
        return this.a;
    }

    public Class e() {
        return this.c;
    }

    public Class f() {
        return this.d;
    }

    public lt1 g(boolean z) {
        return this.e == z ? this : new lt1(this.a, this.d, this.b, z, this.c);
    }

    public String toString() {
        return "ObjectIdInfo: propName=" + this.a + ", scope=" + ay.X(this.d) + ", generatorType=" + ay.X(this.b) + ", alwaysAsId=" + this.e;
    }

    protected lt1(PropertyName propertyName, Class cls, Class cls2, boolean z, Class cls3) {
        this.a = propertyName;
        this.d = cls;
        this.b = cls2;
        this.e = z;
        this.c = cls3 == null ? b.class : cls3;
    }
}
