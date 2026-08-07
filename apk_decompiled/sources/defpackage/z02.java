package defpackage;

import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: loaded from: classes3.dex */
public class z02 extends ContextWrapper {
    public z02(Context context) {
        super(context);
    }

    public static ContextWrapper a(Context context, int i) {
        y12.d(context, i);
        return new z02(context);
    }
}
