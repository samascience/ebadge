package defpackage;

import android.content.Context;
import android.graphics.Color;
import com.google.android.material.R$attr;

/* JADX INFO: loaded from: classes3.dex */
public class hf0 {
    private static final int f = (int) Math.round(5.1000000000000005d);
    private final boolean a;
    private final int b;
    private final int c;
    private final int d;
    private final float e;

    public hf0(Context context) {
        this(gg1.b(context, R$attr.elevationOverlayEnabled, false), og1.b(context, R$attr.elevationOverlayColor, 0), og1.b(context, R$attr.elevationOverlayAccentColor, 0), og1.b(context, R$attr.colorSurface, 0), context.getResources().getDisplayMetrics().density);
    }

    private boolean f(int i) {
        return pz.k(i, 255) == this.d;
    }

    public float a(float f2) {
        float f3 = this.e;
        if (f3 <= 0.0f || f2 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f2 / f3)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i, float f2) {
        int i2;
        float fA = a(f2);
        int iAlpha = Color.alpha(i);
        int iJ = og1.j(pz.k(i, 255), this.b, fA);
        if (fA > 0.0f && (i2 = this.c) != 0) {
            iJ = og1.i(iJ, pz.k(i2, f));
        }
        return pz.k(iJ, iAlpha);
    }

    public int c(int i, float f2) {
        return (this.a && f(i)) ? b(i, f2) : i;
    }

    public int d(float f2) {
        return c(this.d, f2);
    }

    public boolean e() {
        return this.a;
    }

    public hf0(boolean z, int i, int i2, int i3, float f2) {
        this.a = z;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f2;
    }
}
