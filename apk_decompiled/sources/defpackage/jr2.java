package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class jr2 {
    public static int a(Context context, float f) {
        return (int) ((f * context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }
}
