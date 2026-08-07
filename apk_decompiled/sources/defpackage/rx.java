package defpackage;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
abstract class rx {
    static qx a(JsonReader jsonReader, fe1 fe1Var, int i) throws IOException {
        boolean z = i == 3;
        String strNextString = null;
        u6 u6VarB = null;
        l6 l6VarI = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "d":
                    if (jsonReader.nextInt() != 3) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                    break;
                case "p":
                    u6VarB = k6.b(jsonReader, fe1Var);
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
        return new qx(strNextString, u6VarB, l6VarI, z);
    }
}
