package defpackage;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class sc0 implements eb3 {
    public static final sc0 a = new sc0();

    private sc0() {
    }

    @Override // defpackage.eb3
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public rc0 a(JsonReader jsonReader, float f) throws IOException {
        jsonReader.beginObject();
        String strNextString = null;
        String strNextString2 = null;
        double dNextDouble = 0.0d;
        double dNextDouble2 = 0.0d;
        double dNextDouble3 = 0.0d;
        double dNextDouble4 = 0.0d;
        int iNextInt = 0;
        int iNextInt2 = 0;
        int iD = 0;
        int iD2 = 0;
        boolean zNextBoolean = true;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "f":
                    strNextString2 = jsonReader.nextString();
                    break;
                case "j":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "s":
                    dNextDouble = jsonReader.nextDouble();
                    break;
                case "t":
                    strNextString = jsonReader.nextString();
                    break;
                case "fc":
                    iD = s71.d(jsonReader);
                    break;
                case "lh":
                    dNextDouble2 = jsonReader.nextDouble();
                    break;
                case "ls":
                    dNextDouble3 = jsonReader.nextDouble();
                    break;
                case "of":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "sc":
                    iD2 = s71.d(jsonReader);
                    break;
                case "sw":
                    dNextDouble4 = jsonReader.nextDouble();
                    break;
                case "tr":
                    iNextInt2 = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new rc0(strNextString, strNextString2, dNextDouble, iNextInt, iNextInt2, dNextDouble2, dNextDouble3, iD, iD2, dNextDouble4, zNextBoolean);
    }
}
