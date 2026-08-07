package org.junit;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    static String a(String str, Object obj, Object obj2) {
        String str2 = Constants.STR_EMPTY;
        if (str != null && !str.equals(Constants.STR_EMPTY)) {
            str2 = str + " ";
        }
        String strValueOf = String.valueOf(obj);
        String strValueOf2 = String.valueOf(obj2);
        if (strValueOf.equals(strValueOf2)) {
            return str2 + "expected: " + b(obj, strValueOf) + " but was: " + b(obj2, strValueOf2);
        }
        return str2 + "expected:<" + strValueOf + "> but was:<" + strValueOf2 + ">";
    }

    private static String b(Object obj, String str) {
        return (obj == null ? "null" : obj.getClass().getName()) + "<" + str + ">";
    }
}
