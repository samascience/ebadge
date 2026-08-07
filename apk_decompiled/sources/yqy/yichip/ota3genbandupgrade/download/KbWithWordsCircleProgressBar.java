package yqy.yichip.ota3genbandupgrade.download;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class KbWithWordsCircleProgressBar extends View {
    private int a;
    private int b;
    private final int c;
    private final int d;
    private final RectF e;
    private final Paint f;
    private final TextPaint g;
    private final Context h;
    private String i;
    private String j;

    public KbWithWordsCircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 100;
        this.b = 0;
        this.c = 3;
        this.d = 5;
        this.h = context;
        this.e = new RectF();
        this.f = new Paint();
        this.g = new TextPaint();
    }

    public int getMaxProgress() {
        return this.a;
    }

    public String getmTxtHint1() {
        return this.i;
    }

    public String getmTxtHint2() {
        return this.j;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (width != height) {
            width = Math.min(width, height);
            height = width;
        }
        this.f.setAntiAlias(true);
        this.f.setColor(Color.rgb(233, 233, 233));
        canvas.drawColor(0);
        this.f.setStrokeWidth(3.0f);
        this.f.setStyle(Paint.Style.STROKE);
        RectF rectF = this.e;
        rectF.left = 1.0f;
        rectF.top = 1.0f;
        rectF.right = width - 1;
        rectF.bottom = height - 1;
        canvas.drawArc(rectF, -90.0f, 360.0f, false, this.f);
        this.f.setColor(Color.parseColor("#ffda44"));
        canvas.drawArc(this.e, -90.0f, (this.b / this.a) * 360.0f, false, this.f);
        this.f.setStrokeWidth(5.0f);
        String str = this.b + "%";
        int i = height / 4;
        this.f.setTextSize(i);
        int iMeasureText = (int) this.f.measureText(str, 0, str.length());
        Paint paint = this.f;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        int i2 = width / 2;
        canvas.drawText(str, i2 - (iMeasureText / 2), (height / 2) + (i / 2), this.f);
        if (!TextUtils.isEmpty(this.i)) {
            this.f.setStrokeWidth(5.0f);
            String str2 = this.i;
            int i3 = height / 8;
            this.f.setTextSize(i3);
            this.f.setColor(Color.rgb(153, 153, 153));
            int iMeasureText2 = (int) this.f.measureText(str2, 0, str2.length());
            this.f.setStyle(style);
            canvas.drawText(str2, i2 - (iMeasureText2 / 2), i + (i3 / 2), this.f);
        }
        if (TextUtils.isEmpty(this.j)) {
            return;
        }
        this.f.setStrokeWidth(5.0f);
        String str3 = this.j;
        int i4 = height / 8;
        this.f.setTextSize(i4);
        int iMeasureText3 = (int) this.f.measureText(str3, 0, str3.length());
        this.f.setStyle(style);
        canvas.drawText(str3, i2 - (iMeasureText3 / 2), ((height * 3) / 4) + (i4 / 2), this.f);
    }

    public void setMaxProgress(int i) {
        this.a = i;
    }

    public void setProgress(int i) {
        if (i <= 100) {
            this.b = i;
            invalidate();
        }
    }

    public void setProgressNotInUiThread(int i) {
        this.b = i;
        postInvalidate();
    }

    public void setmTxtHint1(String str) {
        this.i = str;
    }

    public void setmTxtHint2(String str) {
        this.j = str;
    }
}
