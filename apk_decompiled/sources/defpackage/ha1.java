package defpackage;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public abstract class ha1 {
    public static Layer a(fe1 fe1Var) {
        Rect rectB = fe1Var.b();
        return new Layer(Collections.emptyList(), fe1Var, "__container", -1L, Layer.LayerType.PreComp, -1L, null, Collections.emptyList(), new s6(), 0, 0, 0, 0.0f, 0.0f, rectB.width(), rectB.height(), null, null, Collections.emptyList(), Layer.MatteType.None, null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v45 */
    /* JADX WARN: Type inference failed for: r4v46 */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v51 */
    /* JADX WARN: Type inference failed for: r4v52 */
    /* JADX WARN: Type inference failed for: r4v53 */
    /* JADX WARN: Type inference failed for: r4v54 */
    /* JADX WARN: Type inference failed for: r4v55 */
    /* JADX WARN: Type inference failed for: r4v56 */
    /* JADX WARN: Type inference failed for: r4v57 */
    /* JADX WARN: Type inference failed for: r4v58 */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r4v60 */
    /* JADX WARN: Type inference failed for: r4v61 */
    /* JADX WARN: Type inference failed for: r4v62 */
    /* JADX WARN: Type inference failed for: r4v63 */
    /* JADX WARN: Type inference failed for: r4v64 */
    /* JADX WARN: Type inference failed for: r4v65 */
    /* JADX WARN: Type inference failed for: r4v66 */
    /* JADX WARN: Type inference failed for: r4v67 */
    /* JADX WARN: Type inference failed for: r4v68 */
    /* JADX WARN: Type inference failed for: r4v69 */
    /* JADX WARN: Type inference failed for: r4v70 */
    /* JADX WARN: Type inference failed for: r4v71 */
    /* JADX WARN: Type inference failed for: r4v72 */
    /* JADX WARN: Type inference failed for: r4v73 */
    /* JADX WARN: Type inference failed for: r4v74 */
    /* JADX WARN: Type inference failed for: r4v75 */
    /* JADX WARN: Type inference failed for: r4v76 */
    /* JADX WARN: Type inference failed for: r4v77 */
    /* JADX WARN: Type inference failed for: r4v78 */
    /* JADX WARN: Type inference failed for: r4v79 */
    /* JADX WARN: Type inference failed for: r4v80 */
    /* JADX WARN: Type inference failed for: r4v81 */
    /* JADX WARN: Type inference failed for: r4v82 */
    /* JADX WARN: Type inference failed for: r4v83 */
    /* JADX WARN: Type inference failed for: r4v84 */
    /* JADX WARN: Type inference failed for: r4v85 */
    /* JADX WARN: Type inference failed for: r4v86 */
    /* JADX WARN: Type inference failed for: r4v87 */
    /* JADX WARN: Type inference failed for: r4v88 */
    public static Layer b(JsonReader jsonReader, fe1 fe1Var) {
        ArrayList arrayList;
        float f;
        Layer.MatteType matteType = Layer.MatteType.None;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        jsonReader.beginObject();
        boolean z = false;
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        Layer.MatteType matteType2 = matteType;
        String strNextString = null;
        s6 s6VarA = null;
        p6 p6VarD = null;
        q6 q6VarA = null;
        g6 g6VarF = null;
        long jNextInt = 0;
        int iNextInt = 0;
        int iNextInt2 = 0;
        int color = 0;
        int iNextInt3 = 0;
        int iNextInt4 = 0;
        float fNextDouble = 1.0f;
        long jNextInt2 = -1;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        String strNextString2 = "UNSET";
        String strNextString3 = null;
        Layer.LayerType layerType = null;
        float fNextDouble4 = 0.0f;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            ?? r4 = -1;
            r4 = -1;
            r4 = -1;
            r4 = -1;
            r4 = -1;
            r4 = -1;
            r4 = -1;
            r4 = -1;
            r4 = -1;
            r4 = -1;
            r4 = -1;
            r4 = -1;
            r4 = -1;
            r4 = -1;
            r4 = -1;
            r4 = -1;
            r4 = -1;
            r4 = -1;
            r4 = -1;
            r4 = -1;
            r4 = -1;
            r4 = -1;
            r4 = -1;
            switch (strNextName.hashCode()) {
                case -995424086:
                    if (strNextName.equals("parent")) {
                        r4 = z;
                    }
                    break;
                case -903568142:
                    if (strNextName.equals("shapes")) {
                        r4 = 1;
                    }
                    break;
                case 104:
                    if (strNextName.equals("h")) {
                        r4 = 2;
                    }
                    break;
                case 116:
                    if (strNextName.equals("t")) {
                        r4 = 3;
                    }
                    break;
                case 119:
                    if (strNextName.equals("w")) {
                        r4 = 4;
                    }
                    break;
                case 3177:
                    if (strNextName.equals("cl")) {
                        r4 = 5;
                    }
                    break;
                case 3233:
                    if (strNextName.equals("ef")) {
                        r4 = 6;
                    }
                    break;
                case 3367:
                    if (strNextName.equals("ip")) {
                        r4 = 7;
                    }
                    break;
                case 3432:
                    if (strNextName.equals("ks")) {
                        r4 = 8;
                    }
                    break;
                case 3519:
                    if (strNextName.equals("nm")) {
                        r4 = 9;
                    }
                    break;
                case 3553:
                    if (strNextName.equals("op")) {
                        r4 = 10;
                    }
                    break;
                case 3664:
                    if (strNextName.equals("sc")) {
                        r4 = 11;
                    }
                    break;
                case 3669:
                    if (strNextName.equals("sh")) {
                        r4 = 12;
                    }
                    break;
                case 3679:
                    if (strNextName.equals("sr")) {
                        r4 = 13;
                    }
                    break;
                case 3681:
                    if (strNextName.equals("st")) {
                        r4 = 14;
                    }
                    break;
                case 3684:
                    if (strNextName.equals("sw")) {
                        r4 = 15;
                    }
                    break;
                case 3705:
                    if (strNextName.equals("tm")) {
                        r4 = 16;
                    }
                    break;
                case 3712:
                    if (strNextName.equals("tt")) {
                        r4 = 17;
                    }
                    break;
                case 3717:
                    if (strNextName.equals("ty")) {
                        r4 = 18;
                    }
                    break;
                case 104415:
                    if (strNextName.equals("ind")) {
                        r4 = 19;
                    }
                    break;
                case 108390670:
                    if (strNextName.equals("refId")) {
                        r4 = 20;
                    }
                    break;
                case 1441620890:
                    if (strNextName.equals("masksProperties")) {
                        r4 = 21;
                    }
                    break;
            }
            switch (r4) {
                case 0:
                    jNextInt2 = jsonReader.nextInt();
                    continue;
                    z = false;
                    break;
                case 1:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        j30 j30VarA = k30.a(jsonReader, fe1Var);
                        if (j30VarA != null) {
                            arrayList3.add(j30VarA);
                        }
                    }
                    jsonReader.endArray();
                    continue;
                    z = false;
                    break;
                case 2:
                    iNextInt4 = (int) (jsonReader.nextInt() * ya3.e());
                    continue;
                    z = false;
                    break;
                case 3:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals("a")) {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                q6VarA = r6.a(jsonReader, fe1Var);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        } else if (strNextName2.equals("d")) {
                            p6VarD = v6.d(jsonReader, fe1Var);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                    z = false;
                    break;
                case 4:
                    iNextInt3 = (int) (jsonReader.nextInt() * ya3.e());
                    continue;
                    z = false;
                    break;
                case 5:
                    strNextString3 = jsonReader.nextString();
                    continue;
                    z = false;
                    break;
                case 6:
                    jsonReader.beginArray();
                    ArrayList arrayList4 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName3 = jsonReader.nextName();
                            strNextName3.hashCode();
                            if (strNextName3.equals("nm")) {
                                arrayList4.add(jsonReader.nextString());
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    fe1Var.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList4);
                    continue;
                    z = false;
                    break;
                case 7:
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    continue;
                    z = false;
                    break;
                case 8:
                    s6VarA = t6.a(jsonReader, fe1Var);
                    continue;
                    z = false;
                    break;
                case 9:
                    strNextString2 = jsonReader.nextString();
                    continue;
                    z = false;
                    break;
                case 10:
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    continue;
                    z = false;
                    break;
                case 11:
                    color = Color.parseColor(jsonReader.nextString());
                    continue;
                    z = false;
                    break;
                case 12:
                    iNextInt2 = (int) (jsonReader.nextInt() * ya3.e());
                    continue;
                    z = false;
                    break;
                case 13:
                    fNextDouble = (float) jsonReader.nextDouble();
                    continue;
                    z = false;
                    break;
                case 14:
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    continue;
                    z = false;
                    break;
                case 15:
                    iNextInt = (int) (jsonReader.nextInt() * ya3.e());
                    continue;
                    z = false;
                    break;
                case 16:
                    g6VarF = v6.f(jsonReader, fe1Var, z);
                    continue;
                    z = false;
                    break;
                case 17:
                    matteType2 = Layer.MatteType.values()[jsonReader.nextInt()];
                    break;
                case 18:
                    int iNextInt5 = jsonReader.nextInt();
                    layerType = Layer.LayerType.Unknown;
                    if (iNextInt5 < layerType.ordinal()) {
                        layerType = Layer.LayerType.values()[iNextInt5];
                    }
                    break;
                case 19:
                    jNextInt = jsonReader.nextInt();
                    break;
                case 20:
                    strNextString = jsonReader.nextString();
                    break;
                case 21:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList2.add(yf1.a(jsonReader, fe1Var));
                    }
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            z = false;
        }
        jsonReader.endObject();
        float f2 = fNextDouble2 / fNextDouble;
        float f3 = fNextDouble4 / fNextDouble;
        ArrayList arrayList5 = new ArrayList();
        if (f2 > 0.0f) {
            arrayList = arrayList5;
            arrayList.add(new k91(fe1Var, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(f2)));
            f = 0.0f;
        } else {
            arrayList = arrayList5;
            f = 0.0f;
        }
        if (f3 <= f) {
            f3 = fe1Var.f();
        }
        arrayList.add(new k91(fe1Var, fValueOf, fValueOf, null, f2, Float.valueOf(f3)));
        arrayList.add(new k91(fe1Var, fValueOf2, fValueOf2, null, f3, Float.valueOf(Float.MAX_VALUE)));
        if (strNextString2.endsWith(".ai") || "ai".equals(strNextString3)) {
            fe1Var.a("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList3, fe1Var, strNextString2, jNextInt, layerType, jNextInt2, strNextString, arrayList2, s6VarA, iNextInt, iNextInt2, color, fNextDouble, fNextDouble3, iNextInt3, iNextInt4, p6VarD, q6VarA, arrayList, matteType2, g6VarF);
    }
}
