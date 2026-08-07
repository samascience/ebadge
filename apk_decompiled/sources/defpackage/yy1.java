package defpackage;

import android.graphics.Paint;

/* JADX INFO: loaded from: classes.dex */
public abstract class yy1 {
    private static final ThreadLocal a = new ThreadLocal();

    static class a {
        static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    public static boolean a(Paint paint, String str) {
        return a.a(paint, str);
    }
}
