package defpackage;

import android.util.Base64;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
public abstract class cg0 {
    public static String a(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? Constants.STR_EMPTY : Base64.encodeToString(bArr, 2);
    }
}
