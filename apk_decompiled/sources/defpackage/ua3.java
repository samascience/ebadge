package defpackage;

import android.content.Context;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public abstract class ua3 {
    public static long a() {
        return new Date().getTime();
    }

    public static String b() {
        Context contextA = r30.a();
        if (contextA == null) {
            return null;
        }
        return contextA.getCacheDir().getAbsolutePath() + "/qiniu";
    }
}
