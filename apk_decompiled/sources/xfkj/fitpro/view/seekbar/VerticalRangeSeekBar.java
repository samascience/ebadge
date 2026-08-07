package xfkj.fitpro.view.seekbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class VerticalRangeSeekBar extends RangeSeekBar {
    private int S;

    public VerticalRangeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RangeSeekBar);
        this.S = typedArrayObtainStyledAttributes.getInt(19, -1);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // xfkj.fitpro.view.seekbar.RangeSeekBar
    protected float b(MotionEvent motionEvent) {
        return this.S == -1 ? getHeight() - motionEvent.getY() : motionEvent.getY();
    }

    @Override // xfkj.fitpro.view.seekbar.RangeSeekBar
    protected float c(MotionEvent motionEvent) {
        return this.S == -1 ? motionEvent.getX() : (-motionEvent.getX()) + getWidth();
    }

    @Override // xfkj.fitpro.view.seekbar.RangeSeekBar, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.S == -1) {
            canvas.rotate(-90.0f);
            canvas.translate(-getHeight(), 0.0f);
        } else {
            canvas.rotate(90.0f);
            canvas.translate(0.0f, -getWidth());
        }
        super.onDraw(canvas);
    }

    @Override // xfkj.fitpro.view.seekbar.RangeSeekBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i2, i, i4, i3);
    }
}
