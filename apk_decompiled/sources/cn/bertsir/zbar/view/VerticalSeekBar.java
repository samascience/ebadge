package cn.bertsir.zbar.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;
import cn.bertsir.zbar.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class VerticalSeekBar extends SeekBar {
    private int a;

    public VerticalSeekBar(Context context) {
        super(context);
        this.a = 90;
        a(context, null, 0, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.VerticalSeekBar, i, i2);
            int integer = typedArrayObtainStyledAttributes.getInteger(R$styleable.VerticalSeekBar_seekBarRotation, 0);
            if (b(integer)) {
                this.a = integer;
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private static boolean b(int i) {
        return i == 90 || i == 270;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        int i = this.a;
        if (i == 270) {
            canvas.rotate(270.0f);
            canvas.translate(-getHeight(), 0.0f);
        } else if (i == 90) {
            canvas.rotate(90.0f);
            canvas.translate(0.0f, -getWidth());
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i2, i);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i2, i, i4, i3);
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0 || action == 1 || action == 2) {
            int i = this.a;
            if (i == 270) {
                setProgress(getMax() - ((int) ((getMax() * motionEvent.getY()) / getHeight())));
            } else if (i == 90) {
                setProgress((int) ((getMax() * motionEvent.getY()) / getHeight()));
            }
            onSizeChanged(getWidth(), getHeight(), 0, 0);
        }
        return true;
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 90;
        a(context, attributeSet, 0, 0);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 90;
        a(context, attributeSet, i, 0);
    }
}
