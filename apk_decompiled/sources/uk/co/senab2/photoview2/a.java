package uk.co.senab2.photoview2;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes4.dex */
public class a implements GestureDetector.OnDoubleTapListener {
    private c a;

    public a(c cVar) {
        a(cVar);
    }

    public void a(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        c cVar = this.a;
        if (cVar == null) {
            return false;
        }
        try {
            float fC = cVar.C();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (fC < this.a.y()) {
                c cVar2 = this.a;
                cVar2.Z(cVar2.y(), x, y, true);
            } else if (fC < this.a.y() || fC >= this.a.x()) {
                c cVar3 = this.a;
                cVar3.Z(cVar3.z(), x, y, true);
            } else {
                c cVar4 = this.a;
                cVar4.Z(cVar4.x(), x, y, true);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF rectFQ;
        c cVar = this.a;
        if (cVar == null) {
            return false;
        }
        ImageView imageViewU = cVar.u();
        if (this.a.A() != null && (rectFQ = this.a.q()) != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (rectFQ.contains(x, y)) {
                this.a.A().a(imageViewU, (x - rectFQ.left) / rectFQ.width(), (y - rectFQ.top) / rectFQ.height());
                return true;
            }
            this.a.A().b();
        }
        if (this.a.B() != null) {
            this.a.B().a(imageViewU, motionEvent.getX(), motionEvent.getY());
        }
        return false;
    }
}
