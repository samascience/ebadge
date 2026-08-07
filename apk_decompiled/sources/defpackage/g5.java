package defpackage;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g5 {
    public static long a(Context context, File file, String str) {
        if (!TextUtils.isEmpty(str) && file.getParentFile() != null) {
            return file.getParentFile().getName().hashCode();
        }
        return gi1.e(context);
    }

    public static String b(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return (ol2.a() && a22.n(str2)) ? Environment.DIRECTORY_MOVIES : "Camera";
        }
        File file = new File(str);
        return file.getParentFile() != null ? file.getParentFile().getName() : "Camera";
    }
}
