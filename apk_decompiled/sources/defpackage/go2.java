package defpackage;

import android.util.JsonReader;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
abstract class go2 {
    static ShapeTrimPath a(JsonReader jsonReader, fe1 fe1Var) throws IOException {
        String strNextString = null;
        ShapeTrimPath.Type typeForId = null;
        g6 g6VarF = null;
        g6 g6VarF2 = null;
        g6 g6VarF3 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    g6VarF2 = v6.f(jsonReader, fe1Var, false);
                    break;
                case "m":
                    typeForId = ShapeTrimPath.Type.forId(jsonReader.nextInt());
                    break;
                case "o":
                    g6VarF3 = v6.f(jsonReader, fe1Var, false);
                    break;
                case "s":
                    g6VarF = v6.f(jsonReader, fe1Var, false);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new ShapeTrimPath(strNextString, typeForId, g6VarF, g6VarF2, g6VarF3);
    }
}
