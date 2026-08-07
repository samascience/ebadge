package defpackage;

import android.graphics.Paint;

/* JADX INFO: loaded from: classes.dex */
public abstract class zd extends we2 {
    protected yd b;
    protected c53 c;
    protected Paint d;
    protected Paint e;
    protected Paint f;
    protected Paint g;

    public zd(ue3 ue3Var, c53 c53Var, yd ydVar) {
        super(ue3Var);
        this.c = c53Var;
        this.b = ydVar;
        if (this.a != null) {
            this.e = new Paint(1);
            Paint paint = new Paint();
            this.d = paint;
            paint.setColor(-7829368);
            this.d.setStrokeWidth(1.0f);
            Paint paint2 = this.d;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            this.d.setAlpha(90);
            Paint paint3 = new Paint();
            this.f = paint3;
            paint3.setColor(-16777216);
            this.f.setStrokeWidth(1.0f);
            this.f.setStyle(style);
            Paint paint4 = new Paint(1);
            this.g = paint4;
            paint4.setStyle(style);
        }
    }

    public Paint a() {
        return this.e;
    }
}
