package defpackage;

import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.components.Legend;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class qa1 extends we2 {
    protected Paint b;
    protected Paint c;
    protected Legend d;
    protected List e;
    protected Paint.FontMetrics f;
    private Path g;

    public qa1(ue3 ue3Var, Legend legend) {
        super(ue3Var);
        this.e = new ArrayList(16);
        this.f = new Paint.FontMetrics();
        this.g = new Path();
        this.d = legend;
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setTextSize(ta3.c(9.0f));
        this.b.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        this.c = paint2;
        paint2.setStyle(Paint.Style.FILL);
    }

    public Paint a() {
        return this.b;
    }
}
