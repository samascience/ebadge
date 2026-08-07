package defpackage;

import android.content.Context;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes4.dex */
public abstract class af0 extends f50 {
    private int h;
    private int i;

    public af0(Context context) {
        super(context);
        this.h = -1;
        this.i = 0;
    }

    @Override // defpackage.f50, defpackage.nt0
    public boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.h = motionEvent.getPointerId(0);
        } else if (action == 1 || action == 3) {
            this.h = -1;
        } else if (action == 6) {
            int iA = s00.a(motionEvent.getAction());
            if (motionEvent.getPointerId(iA) == this.h) {
                int i = iA == 0 ? 1 : 0;
                this.h = motionEvent.getPointerId(i);
                this.b = motionEvent.getX(i);
                this.c = motionEvent.getY(i);
            }
        }
        int i2 = this.h;
        this.i = motionEvent.findPointerIndex(i2 != -1 ? i2 : 0);
        try {
            return super.b(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    @Override // defpackage.f50
    float e(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.i);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    @Override // defpackage.f50
    float f(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.i);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }
}
