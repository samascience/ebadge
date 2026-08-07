package defpackage;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
abstract class ie2 {
    static he2 a(JsonReader jsonReader, fe1 fe1Var) throws IOException {
        String strNextString = null;
        u6 u6VarB = null;
        l6 l6VarI = null;
        g6 g6VarE = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "p":
                    u6VarB = k6.b(jsonReader, fe1Var);
                    break;
                case "r":
                    g6VarE = v6.e(jsonReader, fe1Var);
                    break;
                case "s":
                    l6VarI = v6.i(jsonReader, fe1Var);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new he2(strNextString, u6VarB, l6VarI, g6VarE);
    }
}
