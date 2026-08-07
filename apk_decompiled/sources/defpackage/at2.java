package defpackage;

import android.os.Looper;
import android.util.AndroidRuntimeException;

/* JADX INFO: loaded from: classes.dex */
public final class at2 extends he0 {
    private bt2 A;
    private float B;
    private boolean C;

    public at2(Object obj, bo0 bo0Var) {
        super(obj, bo0Var);
        this.A = null;
        this.B = Float.MAX_VALUE;
        this.C = false;
    }

    private void o() {
        bt2 bt2Var = this.A;
        if (bt2Var == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double dA = bt2Var.a();
        if (dA > this.g) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (dA < this.h) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    @Override // defpackage.he0
    public void i() {
        o();
        this.A.g(d());
        super.i();
    }

    @Override // defpackage.he0
    boolean k(long j) {
        if (this.C) {
            float f = this.B;
            if (f != Float.MAX_VALUE) {
                this.A.e(f);
                this.B = Float.MAX_VALUE;
            }
            this.b = this.A.a();
            this.a = 0.0f;
            this.C = false;
            return true;
        }
        if (this.B != Float.MAX_VALUE) {
            this.A.a();
            long j2 = j / 2;
            he0.o oVarH = this.A.h(this.b, this.a, j2);
            this.A.e(this.B);
            this.B = Float.MAX_VALUE;
            he0.o oVarH2 = this.A.h(oVarH.a, oVarH.b, j2);
            this.b = oVarH2.a;
            this.a = oVarH2.b;
        } else {
            he0.o oVarH3 = this.A.h(this.b, this.a, j);
            this.b = oVarH3.a;
            this.a = oVarH3.b;
        }
        float fMax = Math.max(this.b, this.h);
        this.b = fMax;
        float fMin = Math.min(fMax, this.g);
        this.b = fMin;
        if (!n(fMin, this.a)) {
            return false;
        }
        this.b = this.A.a();
        this.a = 0.0f;
        return true;
    }

    public void l(float f) {
        if (e()) {
            this.B = f;
            return;
        }
        if (this.A == null) {
            this.A = new bt2(f);
        }
        this.A.e(f);
        i();
    }

    public boolean m() {
        return this.A.b > 0.0d;
    }

    boolean n(float f, float f2) {
        return this.A.c(f, f2);
    }

    public at2 p(bt2 bt2Var) {
        this.A = bt2Var;
        return this;
    }

    public void q() {
        if (!m()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f) {
            this.C = true;
        }
    }
}
