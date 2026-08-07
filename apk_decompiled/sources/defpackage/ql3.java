package defpackage;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.YAxis;

/* JADX INFO: loaded from: classes.dex */
public class ql3 extends zd {
    protected YAxis h;
    protected Paint i;
    protected Path j;
    protected RectF k;
    protected float[] l;
    protected Path m;
    protected RectF n;
    protected Path o;
    protected float[] p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected RectF f377q;

    public ql3(ue3 ue3Var, YAxis yAxis, c53 c53Var) {
        super(ue3Var, c53Var, yAxis);
        this.j = new Path();
        this.k = new RectF();
        this.l = new float[2];
        this.m = new Path();
        this.n = new RectF();
        this.o = new Path();
        this.p = new float[2];
        this.f377q = new RectF();
        this.h = yAxis;
        if (this.a != null) {
            this.e.setColor(-16777216);
            this.e.setTextSize(ta3.c(10.0f));
            Paint paint = new Paint(1);
            this.i = paint;
            paint.setColor(-7829368);
            this.i.setStrokeWidth(1.0f);
            this.i.setStyle(Paint.Style.STROKE);
        }
    }
}
