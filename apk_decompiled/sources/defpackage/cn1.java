package defpackage;

import com.tencent.connect.common.Constants;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class cn1 {
    public static String a(int i) {
        StringBuilder sb;
        if (i >= 10) {
            sb = new StringBuilder();
            sb.append(i);
            sb.append(Constants.STR_EMPTY);
        } else {
            sb = new StringBuilder();
            sb.append("0");
            sb.append(i);
        }
        return sb.toString();
    }

    public static String b(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        return c(num, num2, num3, num4, num5, 0);
    }

    public static String c(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
        return num + "-" + a(num2.intValue()) + "-" + a(num3.intValue()) + " " + a(num4.intValue()) + ":" + a(num5.intValue()) + ":" + a(num6.intValue());
    }

    public static SimpleDateFormat d() {
        return new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);
    }
}
