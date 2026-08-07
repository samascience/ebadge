package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c81 {
    public static final Class a(h81 h81Var) {
        p31.f(h81Var, "<this>");
        Class clsC = ((ux) h81Var).c();
        p31.d(clsC, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return clsC;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class b(h81 h81Var) {
        p31.f(h81Var, "<this>");
        Class clsC = ((ux) h81Var).c();
        if (!clsC.isPrimitive()) {
            p31.d(clsC, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return clsC;
        }
        String name = clsC.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    clsC = Double.class;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    clsC = Integer.class;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    clsC = Byte.class;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    clsC = Character.class;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    clsC = Long.class;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    clsC = Void.class;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    clsC = Boolean.class;
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    clsC = Float.class;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    clsC = Short.class;
                }
                break;
        }
        p31.d(clsC, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return clsC;
    }

    public static final h81 c(Class cls) {
        p31.f(cls, "<this>");
        return ke2.b(cls);
    }
}
