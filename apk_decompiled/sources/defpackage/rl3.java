package defpackage;

import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.components.YAxis;

/* JADX INFO: loaded from: classes.dex */
public class rl3 extends ql3 {
    protected Path r;
    protected Path s;
    protected float[] t;

    public rl3(ue3 ue3Var, YAxis yAxis, c53 c53Var) {
        super(ue3Var, yAxis, c53Var);
        this.r = new Path();
        this.s = new Path();
        this.t = new float[4];
        this.g.setTextAlign(Paint.Align.LEFT);
    }
}
