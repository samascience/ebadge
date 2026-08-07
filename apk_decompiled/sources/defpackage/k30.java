package defpackage;

import android.util.JsonReader;
import android.util.Log;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.tenmeter.smlibrary.utils.DateFormatUtils;

/* JADX INFO: loaded from: classes.dex */
abstract class k30 {
    static j30 a(JsonReader jsonReader, fe1 fe1Var) {
        j30 j30VarA;
        String strNextString;
        jsonReader.beginObject();
        byte b = 2;
        int iNextInt = 2;
        while (true) {
            j30VarA = null;
            if (!jsonReader.hasNext()) {
                strNextString = null;
                break;
            }
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (!strNextName.equals("d")) {
                if (strNextName.equals("ty")) {
                    strNextString = jsonReader.nextString();
                    break;
                }
                jsonReader.skipValue();
            } else {
                iNextInt = jsonReader.nextInt();
            }
        }
        if (strNextString == null) {
            return null;
        }
        switch (strNextString.hashCode()) {
            case 3239:
                b = !strNextString.equals("el") ? (byte) -1 : (byte) 0;
                break;
            case 3270:
                b = !strNextString.equals("fl") ? (byte) -1 : (byte) 1;
                break;
            case 3295:
                if (!strNextString.equals("gf")) {
                    b = -1;
                }
                break;
            case 3307:
                b = !strNextString.equals("gr") ? (byte) -1 : (byte) 3;
                break;
            case 3308:
                b = !strNextString.equals("gs") ? (byte) -1 : (byte) 4;
                break;
            case 3488:
                b = !strNextString.equals(DateFormatUtils.MIN) ? (byte) -1 : (byte) 5;
                break;
            case 3633:
                b = !strNextString.equals("rc") ? (byte) -1 : (byte) 6;
                break;
            case 3646:
                b = !strNextString.equals("rp") ? (byte) -1 : (byte) 7;
                break;
            case 3669:
                b = !strNextString.equals("sh") ? (byte) -1 : (byte) 8;
                break;
            case 3679:
                b = !strNextString.equals("sr") ? (byte) -1 : (byte) 9;
                break;
            case 3681:
                b = !strNextString.equals("st") ? (byte) -1 : (byte) 10;
                break;
            case 3705:
                b = !strNextString.equals("tm") ? (byte) -1 : AttrAndFunCode.SYS_INFO_ATTR_HIGH_AND_BASS;
                break;
            case 3710:
                b = !strNextString.equals("tr") ? (byte) -1 : AttrAndFunCode.SYS_INFO_ATTR_EQ_PRESET_VALUE;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                j30VarA = rx.a(jsonReader, fe1Var, iNextInt);
                break;
            case 1:
                j30VarA = yn2.a(jsonReader, fe1Var);
                break;
            case 2:
                j30VarA = fv0.a(jsonReader, fe1Var);
                break;
            case 3:
                j30VarA = ao2.a(jsonReader, fe1Var);
                break;
            case 4:
                j30VarA = hv0.a(jsonReader, fe1Var);
                break;
            case 5:
                j30VarA = vi1.a(jsonReader);
                fe1Var.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                j30VarA = ie2.a(jsonReader, fe1Var);
                break;
            case 7:
                j30VarA = ze2.a(jsonReader, fe1Var);
                break;
            case 8:
                j30VarA = eo2.a(jsonReader, fe1Var);
                break;
            case 9:
                j30VarA = e42.a(jsonReader, fe1Var);
                break;
            case 10:
                j30VarA = fo2.a(jsonReader, fe1Var);
                break;
            case 11:
                j30VarA = go2.a(jsonReader, fe1Var);
                break;
            case 12:
                j30VarA = t6.a(jsonReader, fe1Var);
                break;
            default:
                Log.w("LOTTIE", "Unknown shape type " + strNextString);
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return j30VarA;
    }
}
