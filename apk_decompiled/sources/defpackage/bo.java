package defpackage;

import android.graphics.Paint;

/* JADX INFO: loaded from: classes.dex */
public class bo extends wf {
    protected eo h;
    private float[] i;
    private float[] j;
    private float[] k;

    public bo(eo eoVar, hx hxVar, ue3 ue3Var) {
        super(hxVar, ue3Var);
        this.i = new float[4];
        this.j = new float[2];
        this.k = new float[3];
        this.h = eoVar;
        this.c.setStyle(Paint.Style.FILL);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(ta3.c(1.5f));
    }

    @Override // defpackage.o60
    public void a() {
    }
}
