package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.contrarywind.view.WheelView;

/* JADX INFO: loaded from: classes.dex */
public final class ee1 extends GestureDetector.SimpleOnGestureListener {
    private final WheelView a;

    public ee1(WheelView wheelView) {
        this.a = wheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.a.p(f2);
        return true;
    }
}
