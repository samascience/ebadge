package xfkj.fitpro.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.u73;

/* JADX INFO: loaded from: classes4.dex */
public class SportTypeGradientColorTextView extends AppCompatTextView {
    private LinearGradient h;
    private Paint i;
    private int j;
    private Rect k;

    public SportTypeGradientColorTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = 0;
        this.k = new Rect();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.j = getMeasuredWidth();
        this.i = getPaint();
        String str = u73.b(R.string.start) + getText().toString();
        this.i.getTextBounds(str, 0, str.length(), this.k);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, this.j, 0.0f, new int[]{-1, -226499}, (float[]) null, Shader.TileMode.REPEAT);
        this.h = linearGradient;
        this.i.setShader(linearGradient);
        canvas.drawText(str, 0.0f, (getMeasuredHeight() / 2) + (this.k.height() / 2), this.i);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
    }
}
