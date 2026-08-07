package defpackage;

import android.util.TypedValue;
import com.blankj.utilcode.util.a;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes4.dex */
public abstract class wa3 {
    public static String a(long j) {
        if (j <= 0) {
            return "00:00";
        }
        int i = (int) j;
        int i2 = i / 60;
        if (i2 < 60) {
            return d(i2) + ":" + d(i % 60);
        }
        int i3 = i2 / 60;
        if (i3 > 99) {
            return "99:59:59";
        }
        int i4 = i2 % 60;
        return d(i3) + ":" + d(i4) + ":" + d((int) ((j - ((long) (i3 * 3600))) - ((long) (i4 * 60))));
    }

    public static int b(float f) {
        return (int) TypedValue.applyDimension(1, f, a.g().getResources().getDisplayMetrics());
    }

    public static String c(String str) {
        String[] strArrSplit = str.split("\\.");
        return strArrSplit.length > 0 ? strArrSplit[0] : str;
    }

    private static String d(int i) {
        if (i < 0 || i >= 10) {
            return Constants.STR_EMPTY + i;
        }
        return "0" + Integer.toString(i);
    }
}
