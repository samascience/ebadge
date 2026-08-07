package defpackage;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class w4 implements l40 {
    private final l40 a;
    private final float b;

    public w4(float f, l40 l40Var) {
        while (l40Var instanceof w4) {
            l40Var = ((w4) l40Var).a;
            f += ((w4) l40Var).b;
        }
        this.a = l40Var;
        this.b = f;
    }

    @Override // defpackage.l40
    public float a(RectF rectF) {
        return Math.max(0.0f, this.a.a(rectF) + this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w4)) {
            return false;
        }
        w4 w4Var = (w4) obj;
        return this.a.equals(w4Var.a) && this.b == w4Var.b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Float.valueOf(this.b)});
    }
}
