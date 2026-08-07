package defpackage;

import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.FileUtils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class db3 {
    public static int a(Object obj) {
        return b(obj, 0);
    }

    public static int b(Object obj, int i) {
        if (obj == null) {
            return i;
        }
        try {
            String strTrim = obj.toString().trim();
            return strTrim.contains(FileUtils.FILE_EXTENSION_SEPARATOR) ? Integer.parseInt(strTrim.substring(0, strTrim.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR))) : Integer.parseInt(strTrim);
        } catch (Exception unused) {
            return i;
        }
    }

    public static long c(Object obj) {
        return d(obj, 0L);
    }

    public static long d(Object obj, long j) {
        if (obj == null) {
            return j;
        }
        try {
            String strTrim = obj.toString().trim();
            return strTrim.contains(FileUtils.FILE_EXTENSION_SEPARATOR) ? Long.parseLong(strTrim.substring(0, strTrim.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR))) : Long.parseLong(strTrim);
        } catch (Exception unused) {
            return j;
        }
    }

    public static String e(Object obj) {
        try {
            return obj.toString();
        } catch (Exception unused) {
            return Constants.STR_EMPTY;
        }
    }
}
