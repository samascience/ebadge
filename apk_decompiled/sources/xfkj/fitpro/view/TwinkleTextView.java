package xfkj.fitpro.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes4.dex */
public class TwinkleTextView extends AppCompatTextView {
    private LinearGradient h;
    private Matrix i;
    private Paint j;
    private int k;
    private int l;
    private boolean m;

    public TwinkleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = 0;
        this.l = 0;
        this.m = true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Matrix matrix;
        super.onDraw(canvas);
        if (!this.m || (matrix = this.i) == null) {
            return;
        }
        int i = this.l;
        int i2 = this.k;
        int i3 = i + (i2 / 10);
        this.l = i3;
        if (i3 > i2 * 2) {
            this.l = -i2;
        }
        matrix.setTranslate(this.l, 0.0f);
        this.h.setLocalMatrix(this.i);
        postInvalidateDelayed(50L);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.k == 0) {
            int measuredWidth = getMeasuredWidth();
            this.k = measuredWidth;
            if (measuredWidth > 0) {
                this.j = getPaint();
                LinearGradient linearGradient = new LinearGradient(-this.k, 0.0f, 0.0f, 0.0f, new int[]{-16777216, -1, -16777216}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                this.h = linearGradient;
                this.j.setShader(linearGradient);
                this.i = new Matrix();
            }
        }
    }
}
