package defpackage;

import com.tencent.connect.common.Constants;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public abstract class dm3 {
    public static final String a = a() + "saveLog/";
    public static final String b = a() + "saveFile/";
    public static final String c = a() + "saveTempFile/";

    private static String a() {
        if (!rz2.a()) {
            return Constants.STR_EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(c00.b().a().getExternalCacheDir());
        String str = File.separator;
        sb.append(str);
        sb.append("A_3GenBandOtaUpgrade");
        sb.append(str);
        return sb.toString();
    }
}
