package defpackage;

import android.util.JsonReader;
import com.airbnb.lottie.model.content.PolystarShape;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
abstract class e42 {
    static PolystarShape a(JsonReader jsonReader, fe1 fe1Var) throws IOException {
        String strNextString = null;
        PolystarShape.Type typeForValue = null;
        g6 g6VarF = null;
        u6 u6VarB = null;
        g6 g6VarF2 = null;
        g6 g6VarE = null;
        g6 g6VarE2 = null;
        g6 g6VarF3 = null;
        g6 g6VarF4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "p":
                    u6VarB = k6.b(jsonReader, fe1Var);
                    break;
                case "r":
                    g6VarF2 = v6.f(jsonReader, fe1Var, false);
                    break;
                case "ir":
                    g6VarE = v6.e(jsonReader, fe1Var);
                    break;
                case "is":
                    g6VarF3 = v6.f(jsonReader, fe1Var, false);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "or":
                    g6VarE2 = v6.e(jsonReader, fe1Var);
                    break;
                case "os":
                    g6VarF4 = v6.f(jsonReader, fe1Var, false);
                    break;
                case "pt":
                    g6VarF = v6.f(jsonReader, fe1Var, false);
                    break;
                case "sy":
                    typeForValue = PolystarShape.Type.forValue(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new PolystarShape(strNextString, typeForValue, g6VarF, u6VarB, g6VarF2, g6VarE, g6VarE2, g6VarF3, g6VarF4);
    }
}
