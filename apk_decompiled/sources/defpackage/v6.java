package defpackage;

import android.util.JsonReader;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class v6 {
    private static List a(JsonReader jsonReader, float f, fe1 fe1Var, eb3 eb3Var) {
        return n91.a(jsonReader, fe1Var, f, eb3Var);
    }

    private static List b(JsonReader jsonReader, fe1 fe1Var, eb3 eb3Var) {
        return n91.a(jsonReader, fe1Var, 1.0f, eb3Var);
    }

    static f6 c(JsonReader jsonReader, fe1 fe1Var) {
        return new f6(b(jsonReader, fe1Var, jz.a));
    }

    static p6 d(JsonReader jsonReader, fe1 fe1Var) {
        return new p6(b(jsonReader, fe1Var, sc0.a));
    }

    public static g6 e(JsonReader jsonReader, fe1 fe1Var) {
        return f(jsonReader, fe1Var, true);
    }

    public static g6 f(JsonReader jsonReader, fe1 fe1Var, boolean z) {
        return new g6(a(jsonReader, z ? ya3.e() : 1.0f, fe1Var, ao0.a));
    }

    static h6 g(JsonReader jsonReader, fe1 fe1Var, int i) {
        return new h6(b(jsonReader, fe1Var, new cv0(i)));
    }

    static i6 h(JsonReader jsonReader, fe1 fe1Var) {
        return new i6(b(jsonReader, fe1Var, i31.a));
    }

    static l6 i(JsonReader jsonReader, fe1 fe1Var) {
        return new l6(a(jsonReader, ya3.e(), fe1Var, y32.a));
    }

    static m6 j(JsonReader jsonReader, fe1 fe1Var) {
        return new m6(b(jsonReader, fe1Var, dk2.a));
    }

    static n6 k(JsonReader jsonReader, fe1 fe1Var) {
        return new n6(a(jsonReader, ya3.e(), fe1Var, wn2.a));
    }
}
