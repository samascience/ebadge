package defpackage;

import android.util.JsonReader;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
abstract class fo2 {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:65:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:7:0x0027  */
    static ShapeStroke a(JsonReader jsonReader, fe1 fe1Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        float fNextDouble = 0.0f;
        String strNextString = null;
        g6 g6Var = null;
        f6 f6VarC = null;
        i6 i6VarH = null;
        g6 g6VarE = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    f6VarC = v6.c(jsonReader, fe1Var);
                    break;
                case "d":
                    String str = strNextString;
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = null;
                        g6 g6VarE2 = null;
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            if (strNextName2.equals("n")) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals("v")) {
                                g6VarE2 = v6.e(jsonReader, fe1Var);
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                        strNextString2.hashCode();
                        switch (strNextString2) {
                            case "d":
                            case "g":
                                arrayList.add(g6VarE2);
                                break;
                            case "o":
                                g6Var = g6VarE2;
                                break;
                        }
                    }
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    strNextString = str;
                    break;
                case "o":
                    i6VarH = v6.h(jsonReader, fe1Var);
                    break;
                case "w":
                    g6VarE = v6.e(jsonReader, fe1Var);
                    break;
                case "lc":
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.nextInt() - 1];
                    strNextString = strNextString;
                    break;
                case "lj":
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - 1];
                    strNextString = strNextString;
                    break;
                case "ml":
                    fNextDouble = (float) jsonReader.nextDouble();
                    strNextString = strNextString;
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new ShapeStroke(strNextString, g6Var, arrayList, f6VarC, i6VarH, g6VarE, lineCapType, lineJoinType, fNextDouble);
    }
}
