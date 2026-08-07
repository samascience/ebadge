package defpackage;

import android.util.JsonReader;
import android.util.JsonToken;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class k6 {
    public static j6 a(JsonReader jsonReader, fe1 fe1Var) {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(mz1.a(jsonReader, fe1Var));
            }
            jsonReader.endArray();
            n91.b(arrayList);
        } else {
            arrayList.add(new k91(s71.e(jsonReader, ya3.e())));
        }
        return new j6(arrayList);
    }

    static u6 b(JsonReader jsonReader, fe1 fe1Var) {
        jsonReader.beginObject();
        j6 j6VarA = null;
        g6 g6VarE = null;
        g6 g6VarE2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "k":
                    j6VarA = a(jsonReader, fe1Var);
                    continue;
                    break;
                case "x":
                    if (jsonReader.peek() == JsonToken.STRING) {
                        jsonReader.skipValue();
                        break;
                    } else {
                        g6VarE = v6.e(jsonReader, fe1Var);
                    }
                    break;
                case "y":
                    if (jsonReader.peek() == JsonToken.STRING) {
                        jsonReader.skipValue();
                        break;
                    } else {
                        g6VarE2 = v6.e(jsonReader, fe1Var);
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    continue;
                    break;
            }
            z = true;
        }
        jsonReader.endObject();
        if (z) {
            fe1Var.a("Lottie doesn't support expressions.");
        }
        return j6VarA != null ? j6VarA : new o6(g6VarE, g6VarE2);
    }
}
