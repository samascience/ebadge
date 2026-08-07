package defpackage;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
abstract class ao2 {
    static zn2 a(JsonReader jsonReader, fe1 fe1Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strNextString = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("it")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    j30 j30VarA = k30.a(jsonReader, fe1Var);
                    if (j30VarA != null) {
                        arrayList.add(j30VarA);
                    }
                }
                jsonReader.endArray();
            } else if (strNextName.equals("nm")) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        return new zn2(strNextString, arrayList);
    }
}
