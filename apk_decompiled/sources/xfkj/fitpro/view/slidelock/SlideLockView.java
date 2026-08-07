package xfkj.fitpro.view.slidelock;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import com.legend.smartwatch.electronicbadge.android.R;
import com.seeker.luckychart.animation.ChartCoordinateportAnimator;
import defpackage.fe3;

/* JADX INFO: loaded from: classes4.dex */
public class SlideLockView extends ViewGroup {
    private final String a;
    private fe3 b;
    private Paint c;
    private float d;
    private int e;
    private ObjectAnimator f;
    private View g;
    private RectF h;

    class a extends fe3.c {
        a() {
        }

        @Override // fe3.c
        public int a(View view, int i, int i2) {
            int left = view.getLeft();
            int width = SlideLockView.this.getWidth() - SlideLockView.this.g.getWidth();
            if (i > 0 && i < width) {
                view.layout(i, (SlideLockView.this.getHeight() - view.getHeight()) / 2, view.getWidth() + i, ((SlideLockView.this.getHeight() - view.getHeight()) / 2) + view.getHeight());
            }
            return left;
        }

        @Override // fe3.c
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // fe3.c
        public void l(View view, float f, float f2) {
            super.l(view, f, f2);
            if (view.getRight() - view.getWidth() >= SlideLockView.this.getWidth() * SlideLockView.this.d) {
                SlideLockView slideLockView = SlideLockView.this;
                slideLockView.e(view, slideLockView.getWidth() - SlideLockView.this.g.getWidth(), SlideLockView.this.e);
                Log.i(SlideLockView.this.a, "slide to end point");
                SlideLockView.this.getClass();
                return;
            }
            SlideLockView slideLockView2 = SlideLockView.this;
            slideLockView2.e(view, 0, slideLockView2.e);
            Log.i(SlideLockView.this.a, "slide to begin point");
            SlideLockView.this.getClass();
        }

        @Override // fe3.c
        public boolean m(View view, int i) {
            return SlideLockView.this.isEnabled() && (view.getLeft() > 0 || view.getRight() < SlideLockView.this.getWidth() - SlideLockView.this.g.getWidth()) && view == SlideLockView.this.g;
        }
    }

    class b extends Property {
        final /* synthetic */ View a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Class cls, String str, View view) {
            super(cls, str);
            this.a = view;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(View view) {
            return Integer.valueOf(this.a.getLeft());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Integer num) {
            view.layout(num.intValue(), (SlideLockView.this.getHeight() - SlideLockView.this.g.getHeight()) / 2, num.intValue() + view.getWidth(), ((SlideLockView.this.getHeight() - SlideLockView.this.g.getHeight()) / 2) + view.getHeight());
        }
    }

    public interface c {
    }

    public SlideLockView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        RectF rectF = this.h;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.bottom = getHeight();
        this.h.right = getWidth();
        float fMin = Math.min(this.g.getWidth(), this.g.getHeight()) / 2;
        canvas.drawRoundRect(this.h, fMin, fMin, this.c);
        super.dispatchDraw(canvas);
    }

    public void e(View view, int i, long j) {
        b bVar = new b(Integer.class, "layout", view);
        ObjectAnimator objectAnimator = this.f;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f.cancel();
        }
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(view, bVar, view.getLeft(), i);
        this.f = objectAnimatorOfInt;
        objectAnimatorOfInt.setInterpolator(new AccelerateInterpolator());
        this.f.setDuration(j);
        this.f.start();
    }

    public void f() {
        Paint paint = new Paint(1);
        this.c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.c.setColor(getResources().getColor(R.color.color_slide_lock_bg));
        this.b = fe3.o(this, 1.0f, new a());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.b.Q(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.g.getMeasuredWidth();
        int measuredHeight = this.g.getMeasuredHeight();
        int i5 = ((i4 - i2) - measuredHeight) / 2;
        this.g.layout(0, i5, measuredWidth, measuredHeight + i5);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), Integer.MIN_VALUE);
        View childAt = getChildAt(0);
        this.g = childAt;
        childAt.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        int measuredHeight = this.g.getMeasuredHeight();
        int measuredWidth = this.g.getMeasuredWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            measuredWidth = View.MeasureSpec.getSize(i);
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.b.G(motionEvent);
        return true;
    }

    public void setListener(c cVar) {
    }

    public SlideLockView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideLockView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = SlideLockView.class.getSimpleName();
        this.d = 0.7f;
        this.e = ChartCoordinateportAnimator.FAST_ANIMATION_DURATION;
        this.h = new RectF();
        f();
    }
}
