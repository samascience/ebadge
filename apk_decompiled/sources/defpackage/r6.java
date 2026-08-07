package defpackage;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class r6 {
    public static q6 a(JsonReader jsonReader, fe1 fe1Var) throws IOException {
        jsonReader.beginObject();
        q6 q6VarB = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("a")) {
                q6VarB = b(jsonReader, fe1Var);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return q6VarB == null ? new q6(null, null, null, null) : q6VarB;
    }

    private static q6 b(JsonReader jsonReader, fe1 fe1Var) throws IOException {
        jsonReader.beginObject();
        f6 f6VarC = null;
        f6 f6VarC2 = null;
        g6 g6VarE = null;
        g6 g6VarE2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "t":
                    g6VarE2 = v6.e(jsonReader, fe1Var);
                    break;
                case "fc":
                    f6VarC = v6.c(jsonReader, fe1Var);
                    break;
                case "sc":
                    f6VarC2 = v6.c(jsonReader, fe1Var);
                    break;
                case "sw":
                    g6VarE = v6.e(jsonReader, fe1Var);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new q6(f6VarC, f6VarC2, g6VarE, g6VarE2);
    }
}
