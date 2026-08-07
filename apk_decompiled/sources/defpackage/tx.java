package defpackage;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class tx implements l40 {
    private final float a;

    public tx(float f) {
        this.a = f;
    }

    public static tx b(v0 v0Var) {
        return new tx(v0Var.b());
    }

    private static float c(RectF rectF) {
        return Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f);
    }

    @Override // defpackage.l40
    public float a(RectF rectF) {
        return Math.min(this.a, c(rectF));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof tx) && this.a == ((tx) obj).a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a)});
    }
}
