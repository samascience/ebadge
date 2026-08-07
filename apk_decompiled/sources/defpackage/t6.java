package defpackage;

import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class t6 {
    public static s6 a(JsonReader jsonReader, fe1 fe1Var) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        j6 j6Var = null;
        m6 m6Var = null;
        i6 i6Var = null;
        u6 u6VarB = null;
        g6 g6VarF = null;
        g6 g6VarF2 = null;
        g6 g6VarF3 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "a":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if (jsonReader.nextName().equals("k")) {
                            j6Var = k6.a(jsonReader, fe1Var);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                    break;
                case "o":
                    i6Var = v6.h(jsonReader, fe1Var);
                    continue;
                    break;
                case "p":
                    u6VarB = k6.b(jsonReader, fe1Var);
                    continue;
                    break;
                case "r":
                    break;
                case "s":
                    m6Var = v6.j(jsonReader, fe1Var);
                    continue;
                    break;
                case "eo":
                    g6VarF3 = v6.f(jsonReader, fe1Var, false);
                    continue;
                    break;
                case "rz":
                    fe1Var.a("Lottie doesn't support 3D layers.");
                    break;
                case "so":
                    g6VarF2 = v6.f(jsonReader, fe1Var, false);
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    continue;
                    break;
            }
            g6VarF = v6.f(jsonReader, fe1Var, false);
        }
        if (z) {
            jsonReader.endObject();
        }
        if (j6Var == null) {
            Log.w("LOTTIE", "Layer has no transform property. You may be using an unsupported layer type such as a camera.");
            j6Var = new j6();
        }
        j6 j6Var2 = j6Var;
        if (m6Var == null) {
            m6Var = new m6(new ck2(1.0f, 1.0f));
        }
        m6 m6Var2 = m6Var;
        if (i6Var == null) {
            i6Var = new i6();
        }
        return new s6(j6Var2, u6VarB, m6Var2, g6VarF, i6Var, g6VarF2, g6VarF3);
    }
}
