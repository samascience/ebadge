package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class il3 {
    private static il3 b = new il3();
    private ty1 a = null;

    public static ty1 a(Context context) {
        return b.b(context);
    }

    public final synchronized ty1 b(Context context) {
        try {
            if (this.a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.a = new ty1(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.a;
    }
}
