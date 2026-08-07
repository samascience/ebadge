package xfkj.fitpro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class ColorPannelView extends View {
    private float a;
    private int b;
    private Paint c;

    public ColorPannelView(Context context) {
        super(context);
        a(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ColorPannelView);
        this.b = typedArrayObtainStyledAttributes.getColor(0, -16777216);
        this.a = typedArrayObtainStyledAttributes.getDimension(1, 40.0f);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(this.b);
    }

    public int getmColor() {
        return this.b;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, this.c);
    }

    public void setmColor(int i) {
        this.b = i;
        this.c.setColor(i);
        invalidate();
    }

    public ColorPannelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public ColorPannelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }
}
