package cn.bertsir.zbar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import cn.bertsir.zbar.R$color;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class LineView extends View {
    private Paint a;
    private Canvas b;
    private int c;
    private Shader d;

    public LineView(Context context) {
        super(context);
        this.c = getResources().getColor(R$color.common_color);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String strValueOf = String.valueOf(Integer.toHexString(this.c));
        String strSubstring = strValueOf.substring(strValueOf.length() - 6, strValueOf.length());
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{Color.parseColor("#00" + strSubstring), this.c, Color.parseColor("#00" + strSubstring)}, (float[]) null, Shader.TileMode.CLAMP);
        this.d = linearGradient;
        this.a.setShader(linearGradient);
        canvas.drawLine(0.0f, 0.0f, 1.6843096E7f, 0.0f, this.a);
    }

    public void setLinecolor(int i) {
        this.c = i;
        invalidate();
    }

    public LineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = getResources().getColor(R$color.common_color);
        this.a = new Paint();
        this.b = new Canvas();
        this.a.setStyle(Paint.Style.FILL);
        this.a.setStrokeWidth(10.0f);
        this.a.setAntiAlias(true);
    }
}
