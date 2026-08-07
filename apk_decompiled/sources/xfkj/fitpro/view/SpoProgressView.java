package xfkj.fitpro.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class SpoProgressView extends View {
    private Paint a;
    private Paint b;
    private final float c;
    private final float d;
    private final int e;
    private int f;
    private int g;
    private int h;

    public SpoProgressView(Context context) {
        super(context);
        this.c = 0.7f;
        this.d = 0.03f;
        this.e = 6;
        this.f = 0;
        this.g = Color.parseColor("#ff6f16");
        this.h = Color.parseColor("#09c700");
        a();
    }

    private void a() {
        this.a = new Paint();
        this.b = new Paint();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a.setColor(this.g);
        this.a.setStrokeWidth(5.0f);
        float f = 11;
        canvas.drawLine(0.0f, f, getWidth() * 0.7f, f, this.a);
        this.a.setColor(0);
        canvas.drawLine(getWidth() * 0.7f, f, getWidth() * 0.72999996f, f, this.a);
        this.a.setColor(this.h);
        canvas.drawLine(getWidth() * 0.72999996f, f, getWidth(), f, this.a);
        float strokeWidth = (this.a.getStrokeWidth() + f) - 1.0f;
        float height = getHeight();
        int color = Color.parseColor("#ffc4a1");
        int color2 = Color.parseColor("#ffffff");
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.b.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, height, color, color2, tileMode));
        canvas.drawRect(0.0f, strokeWidth, getWidth() * 0.7f, getHeight(), this.b);
        this.a.setColor(0);
        canvas.drawRect(getWidth() * 0.7f, strokeWidth, getWidth() * 0.72999996f, getHeight(), this.a);
        this.b.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), Color.parseColor("#87e483"), Color.parseColor("#ffffff"), tileMode));
        canvas.drawRect(getWidth() * 0.72999996f, strokeWidth, getWidth(), getHeight(), this.b);
        int i = this.f;
        if (i > 70.0f && i < 72.99999f) {
            this.f = 70;
        }
        Paint paint = new Paint();
        float width = getWidth();
        int i2 = this.f;
        int i3 = (int) (width * (i2 / 100.0f));
        if (i2 < 72.99999f) {
            paint.setColor(this.g);
        } else {
            paint.setColor(this.h);
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5.0f);
        float f2 = i3;
        canvas.drawCircle(f2, f, 6.0f, paint);
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(-1);
        canvas.drawCircle(f2, f, 6.0f, paint2);
    }

    public void setProgress(int i) {
        if (i > 100) {
            i = 100;
        }
        this.f = i;
        invalidate();
    }

    public SpoProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0.7f;
        this.d = 0.03f;
        this.e = 6;
        this.f = 0;
        this.g = Color.parseColor("#ff6f16");
        this.h = Color.parseColor("#09c700");
        a();
    }

    public SpoProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 0.7f;
        this.d = 0.03f;
        this.e = 6;
        this.f = 0;
        this.g = Color.parseColor("#ff6f16");
        this.h = Color.parseColor("#09c700");
        a();
    }
}
