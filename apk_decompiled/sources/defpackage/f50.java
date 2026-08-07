package defpackage;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes4.dex */
public abstract class f50 implements nt0 {
    protected bv1 a;
    float b;
    float c;
    final float d;
    final float e;
    private VelocityTracker f;
    private boolean g;

    public f50(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.e = viewConfiguration.getScaledMinimumFlingVelocity();
        this.d = viewConfiguration.getScaledTouchSlop();
    }

    @Override // defpackage.nt0
    public void a(bv1 bv1Var) {
        this.a = bv1Var;
    }

    @Override // defpackage.nt0
    public boolean b(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int action = motionEvent.getAction();
        if (action == 0) {
            VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
            this.f = velocityTrackerObtain;
            if (velocityTrackerObtain != null) {
                velocityTrackerObtain.addMovement(motionEvent);
            } else {
                bd1.a().i("CupcakeGestureDetector", "Velocity tracker is null");
            }
            this.b = e(motionEvent);
            this.c = f(motionEvent);
            this.g = false;
        } else if (action == 1) {
            if (this.g && this.f != null) {
                this.b = e(motionEvent);
                this.c = f(motionEvent);
                this.f.addMovement(motionEvent);
                this.f.computeCurrentVelocity(1000);
                float xVelocity = this.f.getXVelocity();
                float yVelocity = this.f.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.e) {
                    this.a.b(this.b, this.c, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker2 = this.f;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f = null;
            }
        } else if (action == 2) {
            float fE = e(motionEvent);
            float f = f(motionEvent);
            float f2 = fE - this.b;
            float f3 = f - this.c;
            if (!this.g) {
                this.g = Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) this.d);
            }
            if (this.g) {
                this.a.c(f2, f3);
                this.b = fE;
                this.c = f;
                VelocityTracker velocityTracker3 = this.f;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                }
            }
        } else if (action == 3 && (velocityTracker = this.f) != null) {
            velocityTracker.recycle();
            this.f = null;
        }
        return true;
    }

    @Override // defpackage.nt0
    public boolean c() {
        return this.g;
    }

    abstract float e(MotionEvent motionEvent);

    abstract float f(MotionEvent motionEvent);
}
