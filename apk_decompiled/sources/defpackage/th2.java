package defpackage;

import android.animation.TimeInterpolator;

/* JADX INFO: loaded from: classes3.dex */
public class th2 implements TimeInterpolator {
    private final TimeInterpolator a;

    public th2(TimeInterpolator timeInterpolator) {
        this.a = timeInterpolator;
    }

    public static TimeInterpolator a(boolean z, TimeInterpolator timeInterpolator) {
        return z ? timeInterpolator : new th2(timeInterpolator);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return 1.0f - this.a.getInterpolation(f);
    }
}
