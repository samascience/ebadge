package kotlin.reflect;

import defpackage.p31;
import defpackage.rm2;
import java.lang.reflect.Type;
import kotlin.sequences.d;
import kotlin.text.i;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TypesJVMKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(Type type) {
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (!cls.isArray()) {
            String name = cls.getName();
            p31.e(name, "getName(...)");
            return name;
        }
        rm2 rm2VarH = d.h(type, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
        return ((Class) d.u(rm2VarH)).getName() + i.y("[]", d.l(rm2VarH));
    }
}
