package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class yo3 {
    public static int a(ArrayList arrayList) {
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (((Float) ((ArrayList) arrayList.get(i2)).get(2)).floatValue() > 0.0f) {
                i++;
            }
        }
        return i;
    }

    public static int b(ArrayList arrayList) {
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (((Float) ((ArrayList) arrayList.get(i2)).get(2)).floatValue() >= 15.0f) {
                i++;
            }
        }
        return i;
    }

    public static int c(ArrayList arrayList) {
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (((Float) ((ArrayList) arrayList.get(i2)).get(2)).floatValue() >= 20.0f) {
                i++;
            }
        }
        return i;
    }

    public static int d(ArrayList arrayList) {
        float fFloatValue = 0.0f;
        for (int i = 0; i < arrayList.size(); i++) {
            if (((Float) ((ArrayList) arrayList.get(i)).get(2)).floatValue() > 0.0f) {
                fFloatValue += ((Float) ((ArrayList) arrayList.get(i)).get(2)).floatValue();
            }
        }
        return Math.round(fFloatValue);
    }

    public static int e(ArrayList arrayList) {
        return Math.round(d(arrayList) / a(arrayList));
    }

    public static int f(ArrayList arrayList) {
        float fFloatValue = 0.0f;
        for (int i = 0; i < arrayList.size(); i++) {
            if (((Float) ((ArrayList) arrayList.get(i)).get(2)).floatValue() > 0.0f) {
                fFloatValue += ((Float) ((ArrayList) arrayList.get(i)).get(2)).floatValue() * ((Float) ((ArrayList) arrayList.get(i)).get(1)).floatValue();
            }
        }
        return Math.round(fFloatValue);
    }

    public static int g(ArrayList arrayList) {
        return Math.round(f(arrayList) / a(arrayList));
    }

    public static int h(ArrayList arrayList) {
        int i;
        int[] iArr = new int[37];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= arrayList.size()) {
                break;
            }
            int iCeil = (int) Math.ceil(((Float) ((ArrayList) arrayList.get(i3)).get(0)).floatValue() / 10.0f);
            iArr[iCeil] = iArr[iCeil] + 1;
            i3++;
        }
        for (i = 1; i <= 36; i++) {
            if (iArr[i] > 0) {
                i2++;
            }
        }
        return Math.round((i2 / 36.0f) * 1000.0f);
    }
}
