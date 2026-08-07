package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes4.dex */
public abstract class at0 {
    public static String[] a(int i) {
        List listAsList = Arrays.asList(b());
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < i / 255) {
            arrayList.addAll(listAsList.subList(0, listAsList.size()));
            i2++;
        }
        int i3 = i2 * 255;
        if (i3 < i) {
            arrayList.addAll(listAsList.subList(0, i - i3));
        }
        return (String[]) arrayList.toArray(new String[i]);
    }

    private static String[] b() {
        Random random = new Random();
        String[] strArr = new String[255];
        for (int i = 0; i < 255; i++) {
            String hexString = Integer.toHexString(random.nextInt(255));
            if (hexString.length() <= 1) {
                hexString = "0" + hexString;
            }
            strArr[i] = hexString;
        }
        return strArr;
    }

    public static String c(int i) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            int iNextInt = random.nextInt(35);
            if (i2 == 0) {
                stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789".toUpperCase().charAt(iNextInt));
            } else {
                stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789".toLowerCase().charAt(iNextInt));
            }
        }
        return stringBuffer.toString();
    }
}
