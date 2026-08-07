package defpackage;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
abstract class ze2 {
    static xe2 a(JsonReader jsonReader, fe1 fe1Var) throws IOException {
        String strNextString = null;
        g6 g6VarF = null;
        g6 g6VarF2 = null;
        s6 s6VarA = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    g6VarF = v6.f(jsonReader, fe1Var, false);
                    break;
                case "o":
                    g6VarF2 = v6.f(jsonReader, fe1Var, false);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "tr":
                    s6VarA = t6.a(jsonReader, fe1Var);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new xe2(strNextString, g6VarF, g6VarF2, s6VarA);
    }
}
