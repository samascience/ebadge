package defpackage;

import com.tencent.connect.common.Constants;
import java.util.Formatter;

/* JADX INFO: loaded from: classes.dex */
public abstract class ga {
    public static String a(byte[] bArr, String str) {
        if (bArr == null || bArr.length == 0) {
            return Constants.STR_EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format("%02X", Byte.valueOf(bArr[0]));
        for (int i = 1; i < bArr.length; i++) {
            if (!vv2.a(str)) {
                sb.append(str);
            }
            formatter.format("%02X", Byte.valueOf(bArr[i]));
        }
        formatter.flush();
        formatter.close();
        return sb.toString();
    }
}
