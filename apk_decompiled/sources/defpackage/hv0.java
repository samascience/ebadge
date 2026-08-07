package defpackage;

import android.util.JsonReader;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.content.a;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
abstract class hv0 {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x002f  */
    static a a(JsonReader jsonReader, fe1 fe1Var) throws IOException {
        int i;
        int i2;
        String str = "d";
        int i3 = 1;
        ArrayList arrayList = new ArrayList();
        float fNextDouble = 0.0f;
        String strNextString = null;
        GradientType gradientType = null;
        h6 h6VarG = null;
        i6 i6VarH = null;
        l6 l6VarI = null;
        l6 l6VarI2 = null;
        g6 g6VarE = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        g6 g6Var = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName.hashCode()) {
                case 100:
                    if (!strNextName.equals(str)) {
                        i = -1;
                    } else {
                        i = 0;
                    }
                    break;
                case 101:
                    if (!strNextName.equals("e")) {
                        i = -1;
                    } else {
                        i = i3;
                    }
                    break;
                case 103:
                    if (!strNextName.equals("g")) {
                        i = -1;
                    } else {
                        i = 2;
                    }
                    break;
                case 111:
                    if (!strNextName.equals("o")) {
                        i = -1;
                    } else {
                        i = 3;
                    }
                    break;
                case 115:
                    if (!strNextName.equals("s")) {
                        i = -1;
                    } else {
                        i = 4;
                    }
                    break;
                case 116:
                    if (!strNextName.equals("t")) {
                        i = -1;
                    } else {
                        i = 5;
                    }
                    break;
                case 119:
                    if (!strNextName.equals("w")) {
                        i = -1;
                    } else {
                        i = 6;
                    }
                    break;
                case 3447:
                    if (!strNextName.equals("lc")) {
                        i = -1;
                    } else {
                        i = 7;
                    }
                    break;
                case 3454:
                    if (!strNextName.equals("lj")) {
                        i = -1;
                    } else {
                        i = 8;
                    }
                    break;
                case 3487:
                    if (!strNextName.equals("ml")) {
                        i = -1;
                    } else {
                        i = 9;
                    }
                    break;
                case 3519:
                    if (!strNextName.equals("nm")) {
                        i = -1;
                    } else {
                        i = 10;
                    }
                    break;
                default:
                    i = -1;
                    break;
            }
            switch (i) {
                case 0:
                    str = str;
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
                        if (strNextString2.equals("o")) {
                            g6Var = g6VarE2;
                        } else if (strNextString2.equals(str) || strNextString2.equals("g")) {
                            arrayList.add(g6VarE2);
                        }
                    }
                    jsonReader.endArray();
                    i2 = 1;
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    break;
                case 1:
                    l6VarI2 = v6.i(jsonReader, fe1Var);
                    i2 = i3;
                    break;
                case 2:
                    jsonReader.beginObject();
                    int iNextInt = -1;
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.hashCode();
                        if (strNextName3.equals("k")) {
                            h6VarG = v6.g(jsonReader, fe1Var, iNextInt);
                        } else if (strNextName3.equals("p")) {
                            iNextInt = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    i2 = i3;
                    break;
                case 3:
                    i6VarH = v6.h(jsonReader, fe1Var);
                    i2 = i3;
                    break;
                case 4:
                    l6VarI = v6.i(jsonReader, fe1Var);
                    i2 = i3;
                    break;
                case 5:
                    gradientType = jsonReader.nextInt() == i3 ? GradientType.Linear : GradientType.Radial;
                    i2 = i3;
                    break;
                case 6:
                    g6VarE = v6.e(jsonReader, fe1Var);
                    i2 = i3;
                    break;
                case 7:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.nextInt() - i3];
                    i2 = i3;
                    break;
                case 8:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - i3];
                    i2 = i3;
                    break;
                case 9:
                    fNextDouble = (float) jsonReader.nextDouble();
                    i2 = i3;
                    break;
                case 10:
                    strNextString = jsonReader.nextString();
                    i2 = i3;
                    break;
                default:
                    jsonReader.skipValue();
                    i2 = i3;
                    break;
            }
            i3 = i2;
            str = str;
        }
        return new a(strNextString, gradientType, h6VarG, i6VarH, l6VarI, l6VarI2, g6VarE, lineCapType, lineJoinType, fNextDouble, arrayList, g6Var);
    }
}
