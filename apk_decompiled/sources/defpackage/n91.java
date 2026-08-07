package defpackage;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class n91 {
    static List a(JsonReader jsonReader, fe1 fe1Var, float f, eb3 eb3Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            fe1Var.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (!strNextName.equals("k")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonToken.NUMBER) {
                    arrayList.add(m91.b(jsonReader, fe1Var, f, eb3Var, false));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(m91.b(jsonReader, fe1Var, f, eb3Var, true));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(m91.b(jsonReader, fe1Var, f, eb3Var, false));
            }
        }
        jsonReader.endObject();
        b(arrayList);
        return arrayList;
    }

    public static void b(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            k91 k91Var = (k91) list.get(i2);
            i2++;
            k91Var.f = Float.valueOf(((k91) list.get(i2)).e);
        }
        k91 k91Var2 = (k91) list.get(i);
        if (k91Var2.b == null) {
            list.remove(k91Var2);
        }
    }
}
