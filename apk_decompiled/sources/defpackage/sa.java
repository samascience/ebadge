package defpackage;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes4.dex */
public abstract class sa {
    public static String a(String str, Object obj, Object obj2) {
        String str2;
        if (str == null || str.length() <= 0) {
            str2 = Constants.STR_EMPTY;
        } else {
            str2 = str + " ";
        }
        return str2 + "expected:<" + obj + "> but was:<" + obj2 + ">";
    }
}
