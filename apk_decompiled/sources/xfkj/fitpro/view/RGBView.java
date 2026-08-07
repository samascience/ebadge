package xfkj.fitpro.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class RGBView extends View {
    private List a;
    private Paint b;

    public RGBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.b = paint;
        paint.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        List list = this.a;
        if (list == null || list.isEmpty()) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int size = this.a.size();
        int iMin = Math.min(width, height) / ((int) Math.sqrt(size));
        if (iMin == 0) {
            iMin = 1;
        }
        for (int i = 0; i < size; i++) {
            int[] iArr = (int[]) this.a.get(i);
            int i2 = width / iMin;
            int i3 = i / i2;
            int i4 = (i % i2) * iMin;
            int i5 = i3 * iMin;
            this.b.setColor(Color.argb(iArr[3], iArr[0], iArr[1], iArr[2]));
            canvas.drawRect(i4, i5, i4 + iMin, i5 + iMin, this.b);
        }
    }

    public void setRgba8888List(List<int[]> list) {
        this.a = list;
        invalidate();
    }

    public RGBView(Context context) {
        super(context);
        a();
    }
}
