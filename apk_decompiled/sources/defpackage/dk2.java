package defpackage;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class dk2 implements eb3 {
    public static final dk2 a = new dk2();

    private dk2() {
    }

    @Override // defpackage.eb3
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ck2 a(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z) {
            jsonReader.endArray();
        }
        return new ck2((fNextDouble / 100.0f) * f, (fNextDouble2 / 100.0f) * f);
    }
}
