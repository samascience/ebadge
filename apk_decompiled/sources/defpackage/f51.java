package defpackage;

import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes3.dex */
public final class f51 implements f63 {
    private final p20 a;

    public f51(p20 p20Var) {
        this.a = p20Var;
    }

    @Override // defpackage.f63
    public e63 a(qv0 qv0Var, TypeToken typeToken) {
        e51 e51Var = (e51) typeToken.getRawType().getAnnotation(e51.class);
        if (e51Var == null) {
            return null;
        }
        return b(this.a, qv0Var, typeToken, e51Var);
    }

    e63 b(p20 p20Var, qv0 qv0Var, TypeToken typeToken, e51 e51Var) {
        e63 a63Var;
        Object objA = p20Var.b(TypeToken.get(e51Var.value())).a();
        boolean zNullSafe = e51Var.nullSafe();
        if (objA instanceof e63) {
            a63Var = (e63) objA;
        } else if (objA instanceof f63) {
            a63Var = ((f63) objA).a(qv0Var, typeToken);
        } else {
            if (!(objA instanceof t51)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objA.getClass().getName() + " as a @JsonAdapter for " + typeToken.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            a63Var = new a63(null, objA instanceof t51 ? (t51) objA : null, qv0Var, typeToken, null, zNullSafe);
            zNullSafe = false;
        }
        return (a63Var == null || !zNullSafe) ? a63Var : a63Var.a();
    }
}
