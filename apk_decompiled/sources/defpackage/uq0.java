package defpackage;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

/* JADX INFO: loaded from: classes4.dex */
public class uq0 extends af0 {
    protected final ScaleGestureDetector j;

    class a implements ScaleGestureDetector.OnScaleGestureListener {
        a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            uq0.this.a.a(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public uq0(Context context) {
        super(context);
        this.j = new ScaleGestureDetector(context, new a());
    }

    @Override // defpackage.af0, defpackage.f50, defpackage.nt0
    public boolean b(MotionEvent motionEvent) {
        try {
            this.j.onTouchEvent(motionEvent);
            return super.b(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    @Override // defpackage.nt0
    public boolean d() {
        return this.j.isInProgress();
    }
}
