package defpackage;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class cv0 implements eb3 {
    private int a;

    public cv0(int i) {
        this.a = i;
    }

    private void b(zu0 zu0Var, List list) {
        int i = this.a * 4;
        if (list.size() <= i) {
            return;
        }
        int size = (list.size() - i) / 2;
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i2 = 0;
        while (i < list.size()) {
            if (i % 2 == 0) {
                dArr[i2] = ((Float) list.get(i)).floatValue();
            } else {
                dArr2[i2] = ((Float) list.get(i)).floatValue();
                i2++;
            }
            i++;
        }
        for (int i3 = 0; i3 < zu0Var.c(); i3++) {
            int i4 = zu0Var.a()[i3];
            zu0Var.a()[i3] = Color.argb(c(zu0Var.b()[i3], dArr, dArr2), Color.red(i4), Color.green(i4), Color.blue(i4));
        }
    }

    private int c(double d, double[] dArr, double[] dArr2) {
        double dI;
        for (int i = 1; i < dArr.length; i++) {
            int i2 = i - 1;
            double d2 = dArr[i2];
            double d3 = dArr[i];
            if (d3 >= d) {
                dI = ok1.i(dArr2[i2], dArr2[i], (d - d2) / (d3 - d2));
                return (int) (dI * 255.0d);
            }
        }
        dI = dArr2[dArr2.length - 1];
        return (int) (dI * 255.0d);
    }

    @Override // defpackage.eb3
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public zu0 a(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (z) {
            jsonReader.endArray();
        }
        if (this.a == -1) {
            this.a = arrayList.size() / 4;
        }
        int i = this.a;
        float[] fArr = new float[i];
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.a * 4; i4++) {
            int i5 = i4 / 4;
            double dFloatValue = ((Float) arrayList.get(i4)).floatValue();
            int i6 = i4 % 4;
            if (i6 == 0) {
                fArr[i5] = (float) dFloatValue;
            } else if (i6 == 1) {
                i2 = (int) (dFloatValue * 255.0d);
            } else if (i6 == 2) {
                i3 = (int) (dFloatValue * 255.0d);
            } else if (i6 == 3) {
                iArr[i5] = Color.argb(255, i2, i3, (int) (dFloatValue * 255.0d));
            }
        }
        zu0 zu0Var = new zu0(fArr, iArr);
        b(zu0Var, arrayList);
        return zu0Var;
    }
}
