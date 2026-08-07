package defpackage;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.google.android.material.R$attr;
import com.seeker.luckychart.animation.ChartCoordinateportAnimator;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public abstract class hg1 {
    private final TimeInterpolator a;
    protected final View b;
    protected final int c;
    protected final int d;
    protected final int e;
    private he f;

    public hg1(View view) {
        this.b = view;
        Context context = view.getContext();
        this.a = el1.g(context, R$attr.motionEasingStandardDecelerateInterpolator, jz1.a(0.0f, 0.0f, 0.0f, 1.0f));
        this.c = el1.f(context, R$attr.motionDurationMedium2, ChartCoordinateportAnimator.FAST_ANIMATION_DURATION);
        this.d = el1.f(context, R$attr.motionDurationShort3, Opcodes.FCMPG);
        this.e = el1.f(context, R$attr.motionDurationShort2, 100);
    }

    public float a(float f) {
        return this.a.getInterpolation(f);
    }

    protected he b() {
        if (this.f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        he heVar = this.f;
        this.f = null;
        return heVar;
    }

    public he c() {
        he heVar = this.f;
        this.f = null;
        return heVar;
    }

    protected void d(he heVar) {
        this.f = heVar;
    }

    protected he e(he heVar) {
        if (this.f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        he heVar2 = this.f;
        this.f = heVar;
        return heVar2;
    }
}
