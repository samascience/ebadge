package defpackage;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.charts.RadarChart;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public class ca2 extends kb1 {
    protected RadarChart i;
    protected Paint j;
    protected Paint k;
    protected Path l;
    protected Path m;

    public ca2(RadarChart radarChart, hx hxVar, ue3 ue3Var) {
        super(hxVar, ue3Var);
        this.l = new Path();
        this.m = new Path();
        this.i = radarChart;
        Paint paint = new Paint(1);
        this.d = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.d.setStrokeWidth(2.0f);
        this.d.setColor(Color.rgb(255, Opcodes.NEW, 115));
        Paint paint2 = new Paint(1);
        this.j = paint2;
        paint2.setStyle(style);
        this.k = new Paint(1);
    }

    @Override // defpackage.o60
    public void a() {
    }
}
