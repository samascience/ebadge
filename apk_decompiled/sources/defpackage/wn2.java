package defpackage;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class wn2 implements eb3 {
    public static final wn2 a = new wn2();

    private wn2() {
    }

    @Override // defpackage.eb3
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public vn2 a(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List listF = null;
        boolean zNextBoolean = false;
        List listF2 = null;
        List listF3 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "i":
                    listF2 = s71.f(jsonReader, f);
                    break;
                case "o":
                    listF3 = s71.f(jsonReader, f);
                    break;
                case "v":
                    listF = s71.f(jsonReader, f);
                    break;
            }
        }
        jsonReader.endObject();
        if (jsonReader.peek() == JsonToken.END_ARRAY) {
            jsonReader.endArray();
        }
        if (listF == null || listF2 == null || listF3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listF.isEmpty()) {
            return new vn2(new PointF(), false, Collections.emptyList());
        }
        int size = listF.size();
        PointF pointF = (PointF) listF.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i = 1; i < size; i++) {
            PointF pointF2 = (PointF) listF.get(i);
            int i2 = i - 1;
            arrayList.add(new d50(ok1.a((PointF) listF.get(i2), (PointF) listF3.get(i2)), ok1.a(pointF2, (PointF) listF2.get(i)), pointF2));
        }
        if (zNextBoolean) {
            PointF pointF3 = (PointF) listF.get(0);
            int i3 = size - 1;
            arrayList.add(new d50(ok1.a((PointF) listF.get(i3), (PointF) listF3.get(i3)), ok1.a(pointF3, (PointF) listF2.get(0)), pointF3));
        }
        return new vn2(pointF, zNextBoolean, arrayList);
    }
}
