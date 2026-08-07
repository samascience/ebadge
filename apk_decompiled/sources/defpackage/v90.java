package defpackage;

import android.util.Log;
import com.tencent.connect.common.Constants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public abstract class v90 {
    private static final Pattern a = Pattern.compile("_V\\d+_BadgeOK$");

    public static String a(String str) {
        if (pv2.f(str)) {
            return Constants.STR_EMPTY;
        }
        Matcher matcher = Pattern.compile("_V(\\d+)_BadgeOK$").matcher(str);
        if (!matcher.find()) {
            return Constants.STR_EMPTY;
        }
        String strGroup = matcher.group(1);
        Log.d("DeviceBadgeMarkUtils", "从设备名字中提取版本号: " + str + " -> " + strGroup);
        return strGroup;
    }

    public static boolean b(String str) {
        if (pv2.f(str)) {
            Log.w("DeviceBadgeMarkUtils", "设备名字为空，按老版本设备处理");
            return false;
        }
        boolean zFind = a.matcher(str).find();
        StringBuilder sb = new StringBuilder();
        sb.append("设备名字标记识别: ");
        sb.append(str);
        sb.append(" -> ");
        sb.append(zFind ? "新版本设备" : "老版本设备");
        Log.d("DeviceBadgeMarkUtils", sb.toString());
        return zFind;
    }
}
