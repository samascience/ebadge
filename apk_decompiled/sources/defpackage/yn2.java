package defpackage;

import android.graphics.Path;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
abstract class yn2 {
    static xn2 a(JsonReader jsonReader, fe1 fe1Var) throws IOException {
        String strNextString = null;
        f6 f6VarC = null;
        i6 i6VarH = null;
        boolean zNextBoolean = false;
        int iNextInt = 1;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "fillEnabled":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "c":
                    f6VarC = v6.c(jsonReader, fe1Var);
                    break;
                case "o":
                    i6VarH = v6.h(jsonReader, fe1Var);
                    break;
                case "r":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new xn2(strNextString, zNextBoolean, iNextInt == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, f6VarC, i6VarH);
    }
}
