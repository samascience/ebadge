package defpackage;

import android.graphics.Canvas;

/* JADX INFO: loaded from: classes3.dex */
public abstract class nv {

    public interface a {
        void a(Canvas canvas);
    }

    public static int a(Canvas canvas, float f, float f2, float f3, float f4, int i) {
        return canvas.saveLayerAlpha(f, f2, f3, f4, i);
    }
}
