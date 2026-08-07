package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextPaint;
import com.github.mikephil.charting.charts.PieChart;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class m32 extends o60 {
    protected PieChart g;
    protected Paint h;
    protected Paint i;
    protected Paint j;
    private TextPaint k;
    private Paint l;
    private RectF m;
    private RectF[] n;
    protected WeakReference o;
    protected Canvas p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Path f353q;
    private RectF r;
    private Path s;
    protected Path t;
    protected RectF u;

    public m32(PieChart pieChart, hx hxVar, ue3 ue3Var) {
        super(hxVar, ue3Var);
        this.m = new RectF();
        this.n = new RectF[]{new RectF(), new RectF(), new RectF()};
        this.f353q = new Path();
        this.r = new RectF();
        this.s = new Path();
        this.t = new Path();
        this.u = new RectF();
        this.g = pieChart;
        Paint paint = new Paint(1);
        this.h = paint;
        paint.setColor(-1);
        Paint paint2 = this.h;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        Paint paint3 = new Paint(1);
        this.i = paint3;
        paint3.setColor(-1);
        this.i.setStyle(style);
        this.i.setAlpha(105);
        TextPaint textPaint = new TextPaint(1);
        this.k = textPaint;
        textPaint.setColor(-16777216);
        this.k.setTextSize(ta3.c(12.0f));
        this.f.setTextSize(ta3.c(13.0f));
        this.f.setColor(-1);
        Paint paint4 = this.f;
        Paint.Align align = Paint.Align.CENTER;
        paint4.setTextAlign(align);
        Paint paint5 = new Paint(1);
        this.l = paint5;
        paint5.setColor(-1);
        this.l.setTextAlign(align);
        this.l.setTextSize(ta3.c(13.0f));
        Paint paint6 = new Paint(1);
        this.j = paint6;
        paint6.setStyle(Paint.Style.STROKE);
    }

    @Override // defpackage.o60
    public void a() {
    }

    public TextPaint b() {
        return this.k;
    }

    public Paint c() {
        return this.l;
    }

    public Paint d() {
        return this.h;
    }

    public Paint e() {
        return this.i;
    }

    public void f() {
        Canvas canvas = this.p;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.p = null;
        }
        WeakReference weakReference = this.o;
        if (weakReference != null) {
            Bitmap bitmap = (Bitmap) weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.o.clear();
            this.o = null;
        }
    }
}
