package defpackage;

import android.os.Build;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
public abstract class db0 {
    public static String a() {
        return Build.MANUFACTURER;
    }

    public static String b() {
        String str = Build.MODEL;
        return str != null ? str.trim().replaceAll("\\s*", Constants.STR_EMPTY) : Constants.STR_EMPTY;
    }

    public static String c() {
        return Build.VERSION.RELEASE;
    }
}
