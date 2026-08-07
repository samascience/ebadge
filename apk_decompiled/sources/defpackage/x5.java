package defpackage;

import android.content.Context;
import android.net.Uri;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class x5 {
    public static String a(Context context, long j, String str, int i, int i2, String str2, String str3) {
        try {
            String strD = s12.d(context, sv2.a(j, i, i2), str2, str3);
            File file = new File(strD);
            return (file.exists() || s12.v(y02.a(context, Uri.parse(str)), new FileOutputStream(file))) ? strD : Constants.STR_EMPTY;
        } catch (Exception e) {
            e.printStackTrace();
            return Constants.STR_EMPTY;
        }
    }
}
