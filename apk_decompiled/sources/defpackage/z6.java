package defpackage;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public abstract class z6 {
    public static Interpolator a(Context context, int i) {
        return AnimationUtils.loadInterpolator(context, i);
    }
}
