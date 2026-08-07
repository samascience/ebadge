package defpackage;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
public class qf extends wf {
    protected sf h;
    protected RectF i;
    protected Paint j;
    protected Paint k;
    private RectF l;

    public qf(sf sfVar, hx hxVar, ue3 ue3Var) {
        super(hxVar, ue3Var);
        this.i = new RectF();
        this.l = new RectF();
        this.h = sfVar;
        Paint paint = new Paint(1);
        this.d = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.d.setColor(Color.rgb(0, 0, 0));
        this.d.setAlpha(120);
        Paint paint2 = new Paint(1);
        this.j = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint(1);
        this.k = paint3;
        paint3.setStyle(Paint.Style.STROKE);
    }

    @Override // defpackage.o60
    public void a() {
        this.h.getBarData();
        throw null;
    }
}
