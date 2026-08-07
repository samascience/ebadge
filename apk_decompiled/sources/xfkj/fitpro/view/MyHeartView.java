package xfkj.fitpro.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.connect.common.Constants;
import org.objectweb.asm.Opcodes;
import xfkj.fitpro.R$drawable;

/* JADX INFO: loaded from: classes4.dex */
public class MyHeartView extends View {
    private String a;
    private String b;
    private String c;
    private String d;
    private int e;
    private String f;
    private Bitmap g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int[] n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Paint f417q;
    private int r;

    public MyHeartView(Context context) {
        this(context, null);
    }

    private void a(int i, int i2, int i3, int i4, Canvas canvas, String str) {
        this.f417q.setStrokeWidth(i3);
        this.f417q.setStyle(Paint.Style.STROKE);
        this.f417q.setColor(Color.parseColor("#00f0ff"));
        int[] iArr = this.n;
        int i5 = iArr[0];
        int i6 = iArr[1];
        canvas.drawArc(new RectF((i5 - i4) + 10, (i6 - i4) + 10, (i5 + i4) - 10, (i6 + i4) - 10), i, i2, false, this.f417q);
    }

    private void b(int i, Canvas canvas) {
        this.f417q.setStrokeWidth(8.0f);
        this.f417q.setStyle(Paint.Style.FILL);
        this.f417q.setColor(Color.parseColor("#FFFFFF"));
        this.f417q.setTextAlign(Paint.Align.CENTER);
        this.f417q.setTextSize(45.0f);
        String str = this.f + Constants.STR_EMPTY;
        int[] iArr = this.n;
        canvas.drawText(str, iArr[0], iArr[1] + 10, this.f417q);
        this.f417q.setTextSize(120.0f);
        String str2 = i + Constants.STR_EMPTY;
        int[] iArr2 = this.n;
        canvas.drawText(str2, iArr2[0], iArr2[1] - 50, this.f417q);
        Bitmap bitmap = this.g;
        canvas.drawBitmap(bitmap, this.n[0] - (bitmap.getWidth() / 2), this.n[1] - 240, (Paint) null);
    }

    private void c(Canvas canvas) {
        b(this.i, canvas);
        e(this.i, canvas);
    }

    private void d(Canvas canvas, int i) {
        i();
        this.f417q.setStrokeWidth(6.0f);
        this.f417q.setColor(-1);
        this.f417q.setStyle(Paint.Style.STROKE);
        int[] iArr = this.n;
        int i2 = iArr[0];
        int i3 = this.l;
        int i4 = this.m;
        int i5 = iArr[1];
        canvas.drawArc(new RectF((i2 - i3) - i4, (i5 - i3) - i4, i2 + i3 + i4, i5 + i3 + i4), this.o, this.p, false, this.f417q);
        this.f417q.setStrokeWidth(1.0f);
        this.f417q.setStyle(Paint.Style.FILL);
        for (int i6 = 0; i6 < i; i6++) {
            float f = i6;
            int i7 = (int) ((200.0f / ((i * 1.0f) - 1.0f)) * f);
            int[] iArrG = g(((int) ((this.p / ((i - 1) * 1.0f)) * f)) + this.o, this.l + 90);
            this.f417q.setTextSize(22.0f);
            this.f417q.setTextAlign(Paint.Align.CENTER);
            canvas.save();
            canvas.drawText(i7 + Constants.STR_EMPTY, iArrG[0], iArrG[1], this.f417q);
            canvas.restore();
        }
    }

    private void e(int i, Canvas canvas) {
        a(this.o, (int) (this.p * (i / 200.0f)), this.m, this.l, canvas, "progress");
    }

    private void f(Canvas canvas) {
        d(canvas, this.r);
    }

    private int[] g(int i, int i2) {
        double d = i2;
        double d2 = (((double) i) * 3.141592653589793d) / 180.0d;
        return new int[]{(int) ((Math.cos(d2) * d) + ((double) this.n[0])), (int) ((d * Math.sin(d2)) + ((double) this.n[1]))};
    }

    public static Bitmap h(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    private void i() {
        Paint paint = new Paint();
        this.f417q = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f417q.setAntiAlias(true);
    }

    private void j() {
        setLayerType(1, null);
        this.g = BitmapFactory.decodeResource(getResources(), R$drawable.measure_hr_icon);
        int iMin = Math.min(this.j, this.k);
        this.h = iMin;
        int[] iArr = this.n;
        iArr[0] = this.j / 2;
        iArr[1] = (this.k / 2) + Opcodes.F2L;
        this.l = iMin / 2;
        this.o = Opcodes.GETFIELD;
        this.p = Opcodes.GETFIELD;
        this.g = h(this.g, 68, 66);
    }

    public int getProgress() {
        return this.i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        f(canvas);
        c(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.j = View.MeasureSpec.getSize(i);
        this.k = View.MeasureSpec.getSize(i2);
        j();
    }

    public MyHeartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyHeartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = "#33d24e";
        this.b = "#f8e71c";
        this.c = "#ff9500";
        this.d = "#ff4e65";
        this.e = 200;
        this.f = "bpm";
        this.i = 0;
        this.l = 0;
        this.m = 60;
        this.n = new int[2];
        this.o = 0;
        this.p = 0;
        this.r = 5;
        i();
    }
}
