package defpackage;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyName;

/* JADX INFO: loaded from: classes.dex */
public final class mt1 {
    public final JavaType a;
    public final vm2 b;
    public final ObjectIdGenerator c;
    public final f71 d;
    public final boolean e;

    protected mt1(JavaType javaType, vm2 vm2Var, ObjectIdGenerator objectIdGenerator, f71 f71Var, boolean z) {
        this.a = javaType;
        this.b = vm2Var;
        this.c = objectIdGenerator;
        this.d = f71Var;
        this.e = z;
    }

    public static mt1 a(JavaType javaType, PropertyName propertyName, ObjectIdGenerator objectIdGenerator, boolean z) {
        String simpleName = propertyName == null ? null : propertyName.getSimpleName();
        return new mt1(javaType, simpleName != null ? new SerializedString(simpleName) : null, objectIdGenerator, null, z);
    }

    public mt1 b(boolean z) {
        return z == this.e ? this : new mt1(this.a, this.b, this.c, this.d, z);
    }

    public mt1 c(f71 f71Var) {
        return new mt1(this.a, this.b, this.c, f71Var, this.e);
    }
}
