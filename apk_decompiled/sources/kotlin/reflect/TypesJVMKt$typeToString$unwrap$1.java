package kotlin.reflect;

import defpackage.ar0;
import defpackage.p31;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
/* synthetic */ class TypesJVMKt$typeToString$unwrap$1 extends FunctionReferenceImpl implements ar0 {
    public static final TypesJVMKt$typeToString$unwrap$1 INSTANCE = new TypesJVMKt$typeToString$unwrap$1();

    TypesJVMKt$typeToString$unwrap$1() {
        super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
    }

    @Override // defpackage.ar0
    public final Class<?> invoke(Class<?> cls) {
        p31.f(cls, "p0");
        return cls.getComponentType();
    }
}
