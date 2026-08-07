package defpackage;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;

/* JADX INFO: loaded from: classes.dex */
public abstract class o63 implements n63 {
    protected final TypeFactory a;
    protected final JavaType b;

    protected o63(JavaType javaType, TypeFactory typeFactory) {
        this.b = javaType;
        this.a = typeFactory;
    }

    @Override // defpackage.n63
    public void c(JavaType javaType) {
    }

    @Override // defpackage.n63
    public String f() {
        return e(null, this.b.getRawClass());
    }
}
