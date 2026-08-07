package xfkj.fitpro.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes4.dex */
public class MyScrollView extends ScrollView {
    private float a;
    private float b;
    private boolean c;
    private VelocityTracker d;

    public MyScrollView(Context context) {
        super(context);
        this.c = false;
        a();
    }

    private void a() {
        this.d = VelocityTracker.obtain();
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        VelocityTracker velocityTracker = this.d;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.d = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003c  */
    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.d.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a = motionEvent.getX();
            this.b = motionEvent.getY();
            this.c = false;
        } else if (action == 1) {
            this.d.clear();
        } else {
            if (action == 2) {
                if (Math.abs(motionEvent.getX() - this.a) > Math.abs(motionEvent.getY() - this.b)) {
                    this.c = true;
                }
                if (this.c) {
                    return false;
                }
                return super.onInterceptTouchEvent(motionEvent);
            }
            if (action == 3) {
                this.d.clear();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.d.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            this.d.clear();
        }
        return super.onTouchEvent(motionEvent);
    }

    public MyScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = false;
        a();
    }

    public MyScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = false;
        a();
    }
}
