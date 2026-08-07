package defpackage;

import android.graphics.Path;
import android.util.JsonReader;
import com.airbnb.lottie.model.content.GradientType;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
abstract class fv0 {
    static dv0 a(JsonReader jsonReader, fe1 fe1Var) throws IOException {
        String strNextString = null;
        GradientType gradientType = null;
        Path.FillType fillType = null;
        h6 h6VarG = null;
        i6 i6VarH = null;
        l6 l6VarI = null;
        l6 l6VarI2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    l6VarI2 = v6.i(jsonReader, fe1Var);
                    break;
                case "g":
                    jsonReader.beginObject();
                    int iNextInt = -1;
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals("k")) {
                            h6VarG = v6.g(jsonReader, fe1Var, iNextInt);
                        } else if (strNextName2.equals("p")) {
                            iNextInt = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "o":
                    i6VarH = v6.h(jsonReader, fe1Var);
                    break;
                case "r":
                    fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case "s":
                    l6VarI = v6.i(jsonReader, fe1Var);
                    break;
                case "t":
                    gradientType = jsonReader.nextInt() == 1 ? GradientType.Linear : GradientType.Radial;
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new dv0(strNextString, gradientType, fillType, h6VarG, i6VarH, l6VarI, l6VarI2, null, null);
    }
}
