package defpackage;

import android.os.Build;
import com.tencent.connect.common.Constants;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class qf1 {
    private static String a() {
        String str = Build.MANUFACTURER;
        return str != null ? str.toLowerCase(Locale.ENGLISH) : Constants.STR_EMPTY;
    }

    public static boolean b() {
        return c() || e();
    }

    public static boolean c() {
        return a().equals("lge");
    }

    public static boolean d() {
        return a().equals("meizu");
    }

    public static boolean e() {
        return a().equals("samsung");
    }
}
