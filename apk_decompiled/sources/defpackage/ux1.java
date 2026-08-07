package defpackage;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class ux1 {

    public static class a {
        public static void a(Context context) {
            ux1.a(context);
        }
    }

    public static void a(Context context) {
        try {
            Log.i("OtaApplication", "OtaApplication 初始化（兼容方法，实际无需初始化）");
        } catch (Exception e) {
            Log.e("OtaApplication", "OtaApplication 初始化失败", e);
        }
    }
}
