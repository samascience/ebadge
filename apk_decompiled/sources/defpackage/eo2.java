package defpackage;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
abstract class eo2 {
    static do2 a(JsonReader jsonReader, fe1 fe1Var) throws IOException {
        String strNextString = null;
        n6 n6VarK = null;
        int iNextInt = 0;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "ks":
                    n6VarK = v6.k(jsonReader, fe1Var);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "ind":
                    iNextInt = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new do2(strNextString, iNextInt, n6VarK);
    }
}
