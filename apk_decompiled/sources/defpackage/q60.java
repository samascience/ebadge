package defpackage;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes4.dex */
public abstract class q60 {
    public static int a(String str) {
        if (str == null || str.equals(Constants.STR_EMPTY)) {
            return -1;
        }
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 2;
            i2 += Integer.parseInt(str.substring(i, i3), 16);
            i = i3;
        }
        return i2;
    }
}
