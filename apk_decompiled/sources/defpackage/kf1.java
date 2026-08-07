package defpackage;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* JADX INFO: loaded from: classes3.dex */
public class kf1 extends Scroller {
    private static final Interpolator b = new Interpolator() { // from class: jf1
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return kf1.b(f);
        }
    };
    public boolean a;

    public kf1(Context context) {
        this(context, b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float b(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }

    public void c(boolean z) {
        this.a = z;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        if (this.a) {
            super.startScroll(i, i2, i3, i4, 0);
        } else {
            super.startScroll(i, i2, i3, i4, i5);
        }
    }

    public kf1(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }
}
