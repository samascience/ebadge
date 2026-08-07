package defpackage;

import android.graphics.Rect;
import android.util.JsonReader;
import com.airbnb.lottie.model.layer.Layer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class ie1 {
    public static fe1 a(JsonReader jsonReader) throws IOException {
        float fE = ya3.e();
        zd1 zd1Var = new zd1();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ns2 ns2Var = new ns2();
        fe1 fe1Var = new fe1();
        jsonReader.beginObject();
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        int iNextInt = 0;
        int iNextInt2 = 0;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "assets":
                    b(jsonReader, fe1Var, map, map2);
                    continue;
                    break;
                case "layers":
                    e(jsonReader, fe1Var, arrayList, zd1Var);
                    continue;
                    break;
                case "h":
                    iNextInt2 = jsonReader.nextInt();
                    continue;
                    break;
                case "v":
                    String[] strArrSplit = jsonReader.nextString().split("\\.");
                    if (ya3.h(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        continue;
                    } else {
                        fe1Var.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    break;
                case "w":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "fr":
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    break;
                case "ip":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "op":
                    fNextDouble2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    break;
                case "chars":
                    c(jsonReader, fe1Var, ns2Var);
                    break;
                case "fonts":
                    d(jsonReader, map3);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        fe1Var.n(new Rect(0, 0, (int) (iNextInt * fE), (int) (iNextInt2 * fE)), fNextDouble, fNextDouble2, fNextDouble3, arrayList, zd1Var, map, map2, ns2Var, map3);
        return fe1Var;
    }

    private static void b(JsonReader jsonReader, fe1 fe1Var, Map map, Map map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            zd1 zd1Var = new zd1();
            jsonReader.beginObject();
            int iNextInt = 0;
            int iNextInt2 = 0;
            String strNextString = null;
            String strNextString2 = null;
            String strNextString3 = null;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "layers":
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            Layer layerB = ha1.b(jsonReader, fe1Var);
                            zd1Var.f(layerB.b(), layerB);
                            arrayList.add(layerB);
                        }
                        jsonReader.endArray();
                        break;
                    case "h":
                        iNextInt2 = jsonReader.nextInt();
                        break;
                    case "p":
                        strNextString2 = jsonReader.nextString();
                        break;
                    case "u":
                        strNextString3 = jsonReader.nextString();
                        break;
                    case "w":
                        iNextInt = jsonReader.nextInt();
                        break;
                    case "id":
                        strNextString = jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (strNextString2 != null) {
                le1 le1Var = new le1(iNextInt, iNextInt2, strNextString, strNextString2, strNextString3);
                map2.put(le1Var.c(), le1Var);
            } else {
                map.put(strNextString, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static void c(JsonReader jsonReader, fe1 fe1Var, ns2 ns2Var) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ko0 ko0VarA = lo0.a(jsonReader, fe1Var);
            ns2Var.g(ko0VarA.hashCode(), ko0VarA);
        }
        jsonReader.endArray();
    }

    private static void d(JsonReader jsonReader, Map map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("list")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    ho0 ho0VarA = mo0.a(jsonReader);
                    map.put(ho0VarA.b(), ho0VarA);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void e(JsonReader jsonReader, fe1 fe1Var, List list, zd1 zd1Var) throws IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            Layer layerB = ha1.b(jsonReader, fe1Var);
            if (layerB.d() == Layer.LayerType.Image) {
                i++;
            }
            list.add(layerB);
            zd1Var.f(layerB.b(), layerB);
            if (i > 4) {
                o91.d("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }
}
