package defpackage;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public class k91 {
    private final fe1 a;
    public final Object b;
    public final Object c;
    public final Interpolator d;
    public final float e;
    public Float f;
    private float g;
    private float h;
    public PointF i;
    public PointF j;

    public k91(fe1 fe1Var, Object obj, Object obj2, Interpolator interpolator, float f, Float f2) {
        this.g = Float.MIN_VALUE;
        this.h = Float.MIN_VALUE;
        this.i = null;
        this.j = null;
        this.a = fe1Var;
        this.b = obj;
        this.c = obj2;
        this.d = interpolator;
        this.e = f;
        this.f = f2;
    }

    public boolean a(float f) {
        return f >= c() && f < b();
    }

    public float b() {
        if (this.a == null) {
            return 1.0f;
        }
        if (this.h == Float.MIN_VALUE) {
            if (this.f == null) {
                this.h = 1.0f;
            } else {
                this.h = c() + ((this.f.floatValue() - this.e) / this.a.e());
            }
        }
        return this.h;
    }

    public float c() {
        fe1 fe1Var = this.a;
        if (fe1Var == null) {
            return 0.0f;
        }
        if (this.g == Float.MIN_VALUE) {
            this.g = (this.e - fe1Var.m()) / this.a.e();
        }
        return this.g;
    }

    public boolean d() {
        return this.d == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.b + ", endValue=" + this.c + ", startFrame=" + this.e + ", endFrame=" + this.f + ", interpolator=" + this.d + '}';
    }

    public k91(Object obj) {
        this.g = Float.MIN_VALUE;
        this.h = Float.MIN_VALUE;
        this.i = null;
        this.j = null;
        this.a = null;
        this.b = obj;
        this.c = obj;
        this.d = null;
        this.e = Float.MIN_VALUE;
        this.f = Float.valueOf(Float.MAX_VALUE);
    }
}
