package defpackage;

import android.content.Context;
import android.view.PointerIcon;

/* JADX INFO: loaded from: classes.dex */
public final class a42 {
    private final PointerIcon a;

    static class a {
        static PointerIcon a(Context context, int i) {
            return PointerIcon.getSystemIcon(context, i);
        }
    }

    private a42(PointerIcon pointerIcon) {
        this.a = pointerIcon;
    }

    public static a42 b(Context context, int i) {
        return new a42(a.a(context, i));
    }

    public Object a() {
        return this.a;
    }
}
