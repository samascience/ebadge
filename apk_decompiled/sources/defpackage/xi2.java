package defpackage;

import android.content.Context;
import android.os.Environment;

/* JADX INFO: loaded from: classes3.dex */
public abstract class xi2 {
    public static String a(Context context, String str) {
        if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            return context.getExternalCacheDir().getAbsolutePath() + str;
        }
        return context.getCacheDir().getAbsolutePath() + str;
    }
}
