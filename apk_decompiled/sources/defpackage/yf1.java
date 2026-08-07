package defpackage;

import android.util.JsonReader;
import android.util.Log;
import com.airbnb.lottie.model.content.Mask;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
abstract class yf1 {
    static Mask a(JsonReader jsonReader, fe1 fe1Var) throws IOException {
        jsonReader.beginObject();
        Mask.MaskMode maskMode = null;
        n6 n6VarK = null;
        i6 i6VarH = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "o":
                    i6VarH = v6.h(jsonReader, fe1Var);
                    break;
                case "pt":
                    n6VarK = v6.k(jsonReader, fe1Var);
                    break;
                case "mode":
                    String strNextString = jsonReader.nextString();
                    strNextString.hashCode();
                    switch (strNextString) {
                        case "a":
                            maskMode = Mask.MaskMode.MaskModeAdd;
                            break;
                        case "i":
                            fe1Var.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            maskMode = Mask.MaskMode.MaskModeIntersect;
                            break;
                        case "s":
                            maskMode = Mask.MaskMode.MaskModeSubtract;
                            break;
                        default:
                            Log.w("LOTTIE", "Unknown mask mode " + strNextName + ". Defaulting to Add.");
                            maskMode = Mask.MaskMode.MaskModeAdd;
                            break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new Mask(maskMode, n6VarK, i6VarH);
    }
}
