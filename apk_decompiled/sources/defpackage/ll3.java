package defpackage;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.XAxis;

/* JADX INFO: loaded from: classes.dex */
public class ll3 extends zd {
    protected XAxis h;
    protected Path i;
    protected float[] j;
    protected RectF k;
    protected float[] l;
    protected RectF m;
    float[] n;
    private Path o;

    public ll3(ue3 ue3Var, XAxis xAxis, c53 c53Var) {
        super(ue3Var, c53Var, xAxis);
        this.i = new Path();
        this.j = new float[2];
        this.k = new RectF();
        this.l = new float[2];
        this.m = new RectF();
        this.n = new float[4];
        this.o = new Path();
        this.h = xAxis;
        this.e.setColor(-16777216);
        this.e.setTextAlign(Paint.Align.CENTER);
        this.e.setTextSize(ta3.c(10.0f));
    }
}
